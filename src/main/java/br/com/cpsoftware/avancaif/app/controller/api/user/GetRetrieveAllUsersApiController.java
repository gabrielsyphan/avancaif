package br.com.cpsoftware.avancaif.app.controller.api.user;

import br.com.cpsoftware.avancaif.app.util.constant.PathApiConstants;
import br.com.cpsoftware.avancaif.domain.entity.user.UserEntity;
import br.com.cpsoftware.avancaif.domain.usecase.RetrieveAllUsersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PathApiConstants.API_V1_USERS_CREATE)
public class GetRetrieveAllUsersApiController {

    private final RetrieveAllUsersUseCase retrieveAllUsersUseCase;

    @Autowired
    public GetRetrieveAllUsersApiController(RetrieveAllUsersUseCase retrieveAllUsersUseCase) {
        this.retrieveAllUsersUseCase = retrieveAllUsersUseCase;
    }

    @PostMapping
    public ResponseEntity<List<UserEntity>> apply() {
        var users = retrieveAllUsersUseCase.apply();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
