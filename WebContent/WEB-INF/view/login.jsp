<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Padaria :: Login</title>
    </head>
    
    <body>
        <h3>:: Sistema da Padaria ::</h3>
        <form method="post" action="/padaria/cliente?acao=Login">
            <label for="login">Usu�rio:</label> 
            <input id="login" name="login" type="text">
            
            <label for="senha">Senha:</label> 
            <input id="senha" name="senha" type="password">
            
            <input type="submit" value="Entrar">
        </form>
        <p>
            Ainda n�o � Usu�rio?
                <a href="/padaria/cliente?acao=NovoClienteForm">Cadastre-se agora!</a>
        </p>
    </body>
</html>