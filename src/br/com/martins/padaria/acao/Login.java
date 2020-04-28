package br.com.martins.padaria.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.martins.padaria.dao.FakeDataBase;
import br.com.martins.padaria.model.Usuario;

public class Login implements Acao {

    private FakeDataBase dao = new FakeDataBase();
    
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Usuario usuario = dao.findUser(login, senha);
        
        if (usuario == null)
            return "redirect:cliente?acao=LoginForm";
        
        return "redirect:cliente?acao=ListaClientes";
    }

}
