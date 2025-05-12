package br.com.cpsoftware.avancaif.app.controller.api.user;

import br.com.cpsoftware.avancaif.app.util.constant.PathApiConstants;
import br.com.cpsoftware.avancaif.domain.entity.UserEntity;
import br.com.cpsoftware.avancaif.domain.usecase.CreateNewUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(PathApiConstants.API_V1_USERS)
public class PostCreateUserApiController {
    
    private final CreateNewUserUseCase createNewUserUseCase;

    @Autowired
    public PostCreateUserApiController(CreateNewUserUseCase createNewUserUseCase) {
        this.createNewUserUseCase = createNewUserUseCase;
    }


    @PostMapping
    public ResponseEntity<UserEntity> apply(@Valid @RequestBody UserEntity user) {
        var savedUser = createNewUserUseCase.apply(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
