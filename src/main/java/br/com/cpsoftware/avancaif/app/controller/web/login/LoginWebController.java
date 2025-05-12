package br.com.cpsoftware.avancaif.app.controller.web.login;

import br.com.cpsoftware.avancaif.app.util.constant.PathWebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(PathWebConstants.LOGIN)
public class LoginWebController {

    @GetMapping
    public String getPage(Model model) {
        return PathWebConstants.LOGIN_PAGE;
    }
}
