package br.com.cpsoftware.avancaif.app.controller.web.authenticated.dash;

import br.com.cpsoftware.avancaif.app.util.constant.PathWebConstants;
import br.com.cpsoftware.avancaif.domain.enums.Role;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(PathWebConstants.DASH)
public class DashWebController {

    @GetMapping
    public String getPage(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(a -> Role.valueOf(a.getAuthority()))
                .findFirst()
                .map(role -> role.getPath() + PathWebConstants.DASH_PAGE)
                .orElseThrow(() -> new IllegalStateException("Role not found for user"));
    }
}
