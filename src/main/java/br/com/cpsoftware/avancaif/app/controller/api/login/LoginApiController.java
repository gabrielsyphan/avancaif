package br.com.cpsoftware.avancaif.app.controller.api.login;

import br.com.cpsoftware.avancaif.app.controller.api.login.data.LoginRequest;
import br.com.cpsoftware.avancaif.app.controller.api.login.data.LoginResponse;
import br.com.cpsoftware.avancaif.app.handler.exception.UserNotFoundResponseException;
import br.com.cpsoftware.avancaif.app.util.constant.PathApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.User;

import br.com.cpsoftware.avancaif.app.provider.jwt.JwtUtil;

@RestController
@RequestMapping(PathApiConstants.API_V1_LOGIN)
public class LoginApiController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public LoginApiController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        var authenticationRequest = new UsernamePasswordAuthenticationToken(loginRequest.username(),
                loginRequest.password());
        var authenticationResponse = this.authenticationManager.authenticate(authenticationRequest);

        if (authenticationResponse != null && authenticationResponse.isAuthenticated()) {
            var loggedUser = (User) authenticationResponse.getPrincipal();
            var token = jwtUtil.generateToken(loggedUser);
            var loginResponse = new LoginResponse(token, loggedUser.getUsername());
            return ResponseEntity.ok(loginResponse);
        }

        throw new UserNotFoundResponseException();
    }
}
