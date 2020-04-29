package br.com.martins.padaria.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.martins.padaria.model.Usuario;

@WebFilter("/cliente")
public class AuditoriaFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        
        String acao = request.getParameter("acao");
        
        Usuario usuario = (Usuario) session.getAttribute("currentUser");
        String nomeUsuario = usuario == null ? "anônimo" : usuario.getLogin(); 
        
        long i = System.currentTimeMillis();
        
        chain.doFilter(request, servletResponse);
        
        long f = System.currentTimeMillis();
        
        StringBuilder audit = new StringBuilder();
        
        audit.append(new Date() + " - ");
        audit.append(nomeUsuario);
        audit.append(" -> [" + acao + "] : ");
        audit.append((f - i) + " ms");
        
        System.out.println(audit.toString());
    }

}
