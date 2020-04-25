package br.com.martins.padaria.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.martins.padaria.acao.Acao;
import br.com.martins.padaria.dao.FakeDataBase;
import br.com.martins.padaria.model.Cliente;

public class MostrarCliente implements Acao {
    
    private FakeDataBase dao = new FakeDataBase();
    
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        
        Integer id = Integer.parseInt(request.getParameter("id"));
        
        Cliente cliente = dao.findById(id);
        
        request.setAttribute("cliente", cliente);
        
        return "forward:edicao.jsp";
    }

}
