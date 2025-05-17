package br.com.cpsoftware.avancaif.app.controller.web.home;

import br.com.cpsoftware.avancaif.app.util.constant.PathWebConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(PathWebConstants.HOME)
public class HomeWebController {

    @GetMapping
    public String getPage(Model model) {
        return PathWebConstants.HOME_PAGE_PUBLIC;
    }
}
