package br.com.martins.padaria.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.martins.padaria.dao.FakeDataBase;
import br.com.martins.padaria.model.Cliente;

@WebServlet("/client")
public class ClienteService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Cliente> clientList = new FakeDataBase().findAll();
        
        String accept = request.getHeader("Accept");

        
        if(accept.contains("xml")) {
            XStream xstream = new XStream();
            xstream.alias("client", Cliente.class);
            
            String xml = xstream.toXML(clientList);
            
            response.setContentType("application/xml");
            response.getWriter().print(xml);
            
        } else if (accept.contains("json")) {
            Gson gson = new Gson();
            String json = gson.toJson(clientList);
            
            response.setContentType("application/json");
            response.getWriter().print(json);
            
        } else 
            response.getWriter().print("Message: Format not specified");
        
    }

}
