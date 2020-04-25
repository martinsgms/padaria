package br.com.martins.padaria.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoClienteForm implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) {
        return "forward:cadastroClientes.jsp";
    }

}
