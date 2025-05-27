package br.com.cpsoftware.avancaif.app.controller.web.authenticated.admin.badge;

import br.com.cpsoftware.avancaif.app.util.constant.PathWebConstants;
import br.com.cpsoftware.avancaif.domain.enums.Role;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(PathWebConstants.ADMIN_BADGES)
public class BadgeWebController {

    @GetMapping
    public String getPage(Authentication authentication) {
        var authorities = authentication.getAuthorities();
        if (authorities.stream().noneMatch(authority -> authority.getAuthority().equals(Role.ROLE_ADMIN.name()))) {
            return "redirect:" + PathWebConstants.HOME;
        }

        return PathWebConstants.ADMIN_BADGES_PAGE;
    }
}
