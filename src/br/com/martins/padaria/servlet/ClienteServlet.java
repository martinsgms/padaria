package br.com.martins.padaria.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.martins.padaria.acao.Acao;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {
	
    private static final String VIEW_PATH = "WEB-INF/view/";
    private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    HttpSession session = request.getSession();

	    String acao = request.getParameter("acao");
	    boolean isAcaoProtegida = !(acao.equals("Login") || acao.equals("LoginForm"));
	    
	    if (isAcaoProtegida && session.getAttribute("currentUser") == null) {
	        response.sendRedirect("cliente?acao=LoginForm");
	        return;
	    }
		
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
