package br.com.martins.padaria.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/cliente")
public class AutorizacaoFilter implements Filter {
             
    private boolean isPublicAction = true;
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        HttpSession session = request.getSession();
        
        String acao = request.getParameter("acao");
        
        isPublicAction = publicActions().contains(acao);
        
        if (!isPublicAction && session.getAttribute("currentUser") == null) {
            response.sendRedirect("cliente?acao=LoginForm");
            return;
        }
        
        chain.doFilter(request, response);
    }
    
    private List<String> publicActions() {
        List<String> noAuth = new ArrayList<>();
        
        return noAuth = Arrays.asList("Login",
                                        "LoginForm",
                                        "NovoCliente",
                                        "NovoClienteForm");
    }

}
