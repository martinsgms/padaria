package br.com.martins.padaria.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.martins.padaria.dao.FakeDataBase;

public class RemoveCliente implements Acao {
    
    private FakeDataBase dao = new FakeDataBase(); 
    
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        
        dao.delete(id);
        
        return "redirect:cliente?acao=ListaClientes";
    }

}
