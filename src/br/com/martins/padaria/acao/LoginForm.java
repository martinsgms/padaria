package br.com.martins.padaria.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        return "forward:login.jsp";
    }

}
