<%@ page import="java.util.List" %>
<%@ page import="br.com.martins.padaria.model.Cliente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
    table {border:2px solid}
    th,td {border:1px solid; padding:5px}
</style>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Padaria :: Clientes</title>
    </head>
    <body>
        <h3>Cadastro</h3>
        <form method="post" action="/padaria/clientes">
            <label for="nome">Nome:</label> 
            <input id="nome" name="nome" type="text">
            
            <label for="dtCadastro">Data Cadastro:</label> 
            <input id="dtCadastro" name="dtCadastro" type="date">
            
            <input type="submit" value="cadastrar">
        </form>
        <br><br>
                
        <h3>Clientes cadastrados</h3>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>nome</th>
                    <th>data cadastro</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${clientes}" var="c">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.nome}</td>
                        <td><fmt:formatDate value="${c.dataCadastro}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>