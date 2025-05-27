package br.com.cpsoftware.avancaif.app.controller.web.authenticated.admin.course;

import br.com.cpsoftware.avancaif.app.util.constant.PathWebConstants;
import br.com.cpsoftware.avancaif.domain.enums.Role;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(PathWebConstants.ADMIN_COURSES)
public class CourseWebController {

    @GetMapping
    public String getPage(Authentication authentication, Model model) {
        var authorities = authentication.getAuthorities();
        if (authorities.stream().noneMatch(authority -> authority.getAuthority().equals(Role.ROLE_ADMIN.name()))) {
            return "redirect:" + PathWebConstants.HOME;
        }

        model.addAttribute("currentUri", PathWebConstants.ADMIN_COURSES);
        return PathWebConstants.ADMIN_COURSES_PAGE;
    }
}
