<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
Bem vindo ao nosso gerenciador de empresas!<br />
<c:if test="${not empty usuarioLogado}">
	Usuário logado como: ${usuarioLogado.email} <br />
</c:if>
<form action="novaEmpresa" method="post">
	Nome: <input type="text" name="nome" /> <br />
	<input type="submit" value="Enviar" />
</form>
<br />
<form action="login" method="post">
	Email: <input type="email" name="email" />
	Senha: <input type="password" name="senha" />
	<input type="submit" value="Enviar" />
</form>
<br />
<form action="logout" method="post">
	Sair <input type="submit" value="Logout" />
</form>
</body>
</html>