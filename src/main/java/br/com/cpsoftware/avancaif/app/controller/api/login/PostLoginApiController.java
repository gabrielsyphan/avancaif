package br.com.cpsoftware.avancaif.app.controller.api.login;

import br.com.cpsoftware.avancaif.app.controller.api.login.data.LoginRequest;
import br.com.cpsoftware.avancaif.app.controller.api.login.data.LoginResponse;
import br.com.cpsoftware.avancaif.app.handler.exception.UserNotFoundResponseException;
import br.com.cpsoftware.avancaif.app.util.constant.PathApiConstants;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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
public class PostLoginApiController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public PostLoginApiController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest loginRequest,
            HttpServletResponse response
    ) {
        var authRequest = new UsernamePasswordAuthenticationToken(
                loginRequest.email(),
                loginRequest.password()
        );

        var authResponse = authenticationManager.authenticate(authRequest);

        if (authResponse != null && authResponse.isAuthenticated()) {
            var loggedUser = (User) authResponse.getPrincipal();
            var token = jwtUtil.generateToken(loggedUser);

            // 🔥 Cria o cookie com o JWT
            var cookie = new Cookie("JWT", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(7 * 24 * 60 * 60); // 7 dias, ou ajuste conforme sua necessidade
            response.addCookie(cookie);

            var loginResponse = new LoginResponse(token, loggedUser.getUsername());
            return ResponseEntity.ok(loginResponse);
        }

        throw new UserNotFoundResponseException();
    }
}

