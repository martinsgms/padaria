package br.com.martins.padaria.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.martins.padaria.dao.FakeDataBase;
import br.com.martins.padaria.model.Cliente;

@WebServlet("/clientes")
public class ClienteServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("clientes", new FakeDataBase().findAll());
	    request.getRequestDispatcher("/clientes.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nome = request.getParameter("nome");
	    String dtCadastro = request.getParameter("dtCadastro");
	    
	    Date dtCadastroFormatada = formatarData(dtCadastro);
	    
        new FakeDataBase().create(new Cliente(nome, dtCadastroFormatada));
        
        request.setAttribute("clientes", new FakeDataBase().findAll());
	    request.getRequestDispatcher("/clientes.jsp").forward(request, response);
	    
	}

    private Date formatarData(String dtCadastro) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date dtCadastroFormatada = null;
	    
	    try {
            dtCadastroFormatada = sdf.parse(dtCadastro);
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dtCadastroFormatada;
    }

}
