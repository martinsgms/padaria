package br.com.martins.padaria.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.martins.padaria.dao.FakeDataBase;
import br.com.martins.padaria.model.Cliente;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getRequestDispatcher("/clientes.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String nome = request.getParameter("nome");
	    
        new FakeDataBase().create(new Cliente(nome));
	    
	    PrintWriter writer = response.getWriter();
	    writer.println("Cliente " + nome + " cadastrado com sucesso!");
	}

}
