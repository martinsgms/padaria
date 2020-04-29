package br.com.martins.padaria.servlet;

import java.io.IOException;

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
             
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        HttpSession session = request.getSession();
        
        String acao = request.getParameter("acao");

        boolean isAcaoProtegida = !(acao.equals("Login") || acao.equals("LoginForm"));
        
        if (isAcaoProtegida && session.getAttribute("currentUser") == null) {
            response.sendRedirect("cliente?acao=LoginForm");
            return;
        }
        
        chain.doFilter(request, response);
    }

}
