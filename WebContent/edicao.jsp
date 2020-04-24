<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Padaria :: Clientes - Edição</title>
    </head>
    <body>
        <h3>Editar</h3>
        <form method="post" action="/padaria/cliente/editar">
            <label for="id">Id:</label> 
            <input id="id" name="id" value="${cliente.id}" type="text" readonly>
            
            <label for="nome">Nome:</label> 
            <input id="nome" name="nome" value="${cliente.nome}" type="text">
            
            <label for="dataNascimento">Data de nascimento:</label> 
            <input id="dataNascimento" name="dataNascimento" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${cliente.dataNascimento}'/>" type="date">
            
            <input type="submit" value="Editar">
        </form>
    </body>
</html>