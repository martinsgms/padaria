package br.com.martins.padaria.acao;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.martins.padaria.dao.FakeDataBase;
import br.com.martins.padaria.model.Cliente;
import br.com.martins.padaria.util.DateUtils;

public class NovoCliente implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) {

        String nome = request.getParameter("nome");
        String dataNascimento = request.getParameter("dataNascimento");

        Date dataNascimentoFormatada = DateUtils.parseToDefault(dataNascimento);

        new FakeDataBase().create(new Cliente(nome, dataNascimentoFormatada));
        
        return "redirect:cliente?acao=ListaClientes";
    }

}
