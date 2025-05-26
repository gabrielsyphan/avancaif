package br.com.cpsoftware.avancaif.app.handler.advisor;

import br.com.cpsoftware.avancaif.app.util.constant.PathWebConstants;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException, ServletException {

        String acceptHeader = request.getHeader("Accept");

        if (acceptHeader != null && acceptHeader.contains("application/json")
                || request.getRequestURI().startsWith("/api")) {
            // 🔥 Caso seja API, responde com JSON 401
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"Unauthorized\"}");
        } else {
            // 🔄 Caso seja navegador (Thymeleaf), redireciona para login
            response.sendRedirect(PathWebConstants.LOGIN);
        }
    }
}
