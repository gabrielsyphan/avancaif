package br.com.cpsoftware.avancaif.app.controller.web.user;

import br.com.cpsoftware.avancaif.app.util.constant.PathWebConstants;
import br.com.cpsoftware.avancaif.domain.entity.user.UserEntity;
import br.com.cpsoftware.avancaif.domain.enums.Role;
import br.com.cpsoftware.avancaif.domain.usecase.RetrieveAllUsersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(PathWebConstants.USERS)
public class UserWebController {

    private final RetrieveAllUsersUseCase retrieveAllUsersUseCase;

    @Autowired
    public UserWebController(RetrieveAllUsersUseCase retrieveAllUsersUseCase) {
        this.retrieveAllUsersUseCase = retrieveAllUsersUseCase;
    }

    @GetMapping
    public String getPage(Model model) {
        List<UserEntity> userModels = retrieveAllUsersUseCase.apply();
        model.addAttribute("users", userModels);

        Map<String, String> authorityLabels = new LinkedHashMap<>();
        Role.getAllRoles().forEach(role -> authorityLabels.put(role.name(), role.getDescription()));

        model.addAttribute("authorityLabels", authorityLabels);
        model.addAttribute("authorityOptions", authorityLabels.keySet());
        return PathWebConstants.LIST_USERS_PAGE;
    }
}
