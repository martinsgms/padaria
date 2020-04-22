<%@page import="java.util.List"%>
<%@page import="br.com.martins.padaria.model.Cliente"%>
<%
    List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
%>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Padaria :: Clientes</title>
    </head>
    <body>
        <h3>Cadastro</h3>
        <form method="post" action="/padaria/cliente">
            <label for="nome">Nome:</label> 
            <input id="nome" name="nome" type="text">
            
            <input type="submit" value="cadastrar">
        </form>
        <br><br>
                
        <h3>Clientes cadastrados</h3>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>nome</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Cliente cliente : clientes) {
                        out.println("<tr><td>" + cliente.getId() + "</td>");
                        out.println("<td>" + cliente.getNome() + "</td></tr>");
                    }
                %>
            </tbody>
        </table>
    </body>
</html>