package br.com.martins.padaria.acao;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.martins.padaria.acao.Acao;
import br.com.martins.padaria.dao.FakeDataBase;
import br.com.martins.padaria.model.Cliente;
import br.com.martins.padaria.util.DateUtils;

public class EditarCliente implements Acao {
    
    private FakeDataBase dao = new FakeDataBase();
    
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String dataNascimento = request.getParameter("dataNascimento");

        Date dataNascimentoFormatada = DateUtils.parseToDefault(dataNascimento);

        Cliente cliente = dao.findById(id);
        cliente.setNome(nome);
        cliente.setDataNascimento(dataNascimentoFormatada);
        
        return "redirect:cliente?acao=ListaClientes";
    }

}
