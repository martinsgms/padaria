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

@WebServlet("/cliente/cadastro")
public class CadastroClienteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/cadastroClientes.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String dataNascimento = request.getParameter("dataNascimento");

        Date dataNascimentoFormatada = formatarData(dataNascimento);

        new FakeDataBase().create(new Cliente(nome, dataNascimentoFormatada));
        
        response.sendRedirect("painel");
    }

    private Date formatarData(String data) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFormatada = null;

        try {
            dataFormatada = formatter.parse(data);

        } catch (ParseException e) {
            e.printStackTrace();
            
        }
        return dataFormatada;
    }

}
