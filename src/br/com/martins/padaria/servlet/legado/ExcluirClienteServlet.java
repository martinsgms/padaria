package br.com.martins.padaria.servlet.legado;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.martins.padaria.dao.FakeDataBase;

@WebServlet("/cliente/excluir")
public class ExcluirClienteServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    private FakeDataBase dao = new FakeDataBase(); 
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        
        dao.delete(id);
        
        response.sendRedirect("painel");
    }

}
