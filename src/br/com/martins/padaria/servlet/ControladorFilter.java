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

import br.com.martins.padaria.acao.Acao;

@WebFilter("/cliente")
public class ControladorFilter implements Filter {
    
    private static final String VIEW_PATH = "WEB-INF/view/";
    
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        String acao = request.getParameter("acao");
        String rawPostAction = null;
        
        try {
            
            Class<?> clazz = Class.forName("br.com.martins.padaria.acao." + acao);
            Acao instance = (Acao) clazz.newInstance();
            rawPostAction = instance.executa(request, response);
        
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        
        String[] postAction = rawPostAction.split(":");
        
        if (postAction[0].equals("forward")) 
            request.getRequestDispatcher(VIEW_PATH + postAction[1]).forward(request, response);
        else 
            response.sendRedirect(postAction[1]);
    }

}
