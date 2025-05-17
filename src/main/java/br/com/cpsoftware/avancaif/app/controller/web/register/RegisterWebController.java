package br.com.cpsoftware.avancaif.app.controller.web.register;

import br.com.cpsoftware.avancaif.app.util.constant.PathWebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(PathWebConstants.REGISTER)
public class RegisterWebController {

    @GetMapping
    public String getPage(Model model) {
        return PathWebConstants.REGISTER_PAGE;
    }
}
