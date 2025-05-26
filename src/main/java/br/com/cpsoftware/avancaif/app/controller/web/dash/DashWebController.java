package br.com.cpsoftware.avancaif.app.controller.web.dash;

import br.com.cpsoftware.avancaif.app.util.constant.PathWebConstants;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(PathWebConstants.DASH)
public class DashWebController {

    @GetMapping
    public String getPage(Model model, Authentication authentication) {
//        authentication.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))
        return PathWebConstants.DASH_PAGE;
    }
}
