package br.com.cpsoftware.avancaif.app.controller.api.register;

import br.com.cpsoftware.avancaif.app.controller.api.register.data.RegisterNewUserRequest;
import br.com.cpsoftware.avancaif.app.controller.api.register.data.RegisterNewUserResponse;
import br.com.cpsoftware.avancaif.app.provider.mapstruct.UserMapper;
import br.com.cpsoftware.avancaif.app.util.constant.PathApiConstants;
import br.com.cpsoftware.avancaif.domain.usecase.CreateNewUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping(PathApiConstants.API_V1_REGISTER)
@ResponseStatus(HttpStatus.CREATED)
public class PostRegisterNewUserApiController {

    private final UserMapper mapper = UserMapper.INSTANCE;
    private final CreateNewUserUseCase createNewUserUseCase;

    @Autowired
    public PostRegisterNewUserApiController(CreateNewUserUseCase createNewUserUseCase) {
        this.createNewUserUseCase = createNewUserUseCase;
    }

    @PostMapping
    public ResponseEntity<RegisterNewUserResponse> apply(@Valid @RequestBody RegisterNewUserRequest registerNewUserRequest) {
        var savedUser = createNewUserUseCase.apply(registerNewUserRequest.toUserEntity());
        return new ResponseEntity<>(mapper.toNewUserResponse(savedUser), HttpStatus.CREATED);
    }
}

