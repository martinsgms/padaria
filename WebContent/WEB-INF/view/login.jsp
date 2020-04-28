<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Padaria :: Login</title>
    </head>
    <body>
        <h3>Cadastro</h3>
        <form method="post" action="/padaria/cliente?acao=Login">
            <label for="login">Usuário:</label> 
            <input id="login" name="login" type="text">
            
            <label for="senha">Senha:</label> 
            <input id="senha" name="senha" type="password">
            
            <input type="submit" value="Entrar">
        </form>
    </body>
</html>