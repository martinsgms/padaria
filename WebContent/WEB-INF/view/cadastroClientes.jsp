<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Padaria :: Clientes - Cadastro</title>
    </head>
    <body>
        <h3>Cadastro</h3>
        <form method="post" action="/padaria/cliente/cadastro">
            <label for="nome">Nome:</label> 
            <input id="nome" name="nome" type="text">
            
            <label for="dataNascimento">Data de nascimento:</label> 
            <input id="dataNascimento" name="dataNascimento" type="date">
            
            <input type="submit" value="cadastrar">
        </form>
    </body>
</html>