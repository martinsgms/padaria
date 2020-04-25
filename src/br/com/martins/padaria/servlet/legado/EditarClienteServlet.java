package br.com.martins.padaria.servlet.legado;

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

@WebServlet("/cliente/editar")
public class EditarClienteServlet extends HttpServlet {
   
    private static final long serialVersionUID = 1L;
    private FakeDataBase dao = new FakeDataBase();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String dataNascimento = request.getParameter("dataNascimento");

        Date dataNascimentoFormatada = formatarData(dataNascimento);

        Cliente cliente = dao.findById(id);
        cliente.setNome(nome);
        cliente.setDataNascimento(dataNascimentoFormatada);
        
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
