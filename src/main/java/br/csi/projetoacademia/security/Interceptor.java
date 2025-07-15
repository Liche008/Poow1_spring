package br.csi.projetoacademia.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String url = request.getRequestURI();

        if (url.equals("/login") || url.equals("/usuarios")) {
            return true;
        }

        if (request.getSession().getAttribute("usuarioLogado") == null) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}
