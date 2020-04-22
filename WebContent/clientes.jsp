<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Padaria :: Clientes</title>
    </head>
    <body>
    
        <form method="post" action="/padaria/cliente">
            <label for="nome">Nome:</label> 
            <input id="nome" name="nome" type="text">
            
            <input type="submit" value="cadastrar">
        </form>
        
    </body>
</html>