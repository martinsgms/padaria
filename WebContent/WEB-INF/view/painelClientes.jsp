<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
    table {border:2px solid}
    th,td {border:1px solid; padding:5px}
</style>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Padaria :: Clientes - Painel</title>
    </head>
    <body>
        <h3>Clientes cadastrados</h3>
        <a href="/padaria/cliente?acao=NovoClienteForm">Cadastrar novo</a>
        <br><br>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>nome</th>
                    <th>nascimento</th>
                    <th>ações</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${empty clientes}">
                     <tr><td colspan="4">Nenhum cliente cadastrado</td></tr>
                </c:if>
                <c:if test="${not empty clientes}">
                    <c:forEach items="${clientes}" var="c">
                        <tr>
                            <td>${c.id}</td>
                            <td>${c.nome}</td>
                            <td><fmt:formatDate value="${c.dataNascimento}"/></td>
                            <td><a href="/padaria/cliente/edicao?id=${c.id}">Editar</a> <a href="/padaria/cliente/excluir?id=${c.id}">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
    </body>
</html>