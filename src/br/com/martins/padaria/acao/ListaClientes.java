package br.com.martins.padaria.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.martins.padaria.dao.FakeDataBase;

public class ListaClientes implements Acao {
    
    private FakeDataBase dao = new FakeDataBase();
    
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        
        request.setAttribute("clientes", dao.findAll());
        
        return "forward:painelClientes.jsp";
    }
}
