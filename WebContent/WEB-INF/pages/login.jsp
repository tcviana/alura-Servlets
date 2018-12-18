<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:if test="${empty usuarioLogado}">
	<p>Usuário não encontrado.</p>
</c:if>
<c:if test="${not empty usuarioLogado}">
	<p>Usuário ${usuarioLogado.email} conectado.</p>
</c:if>
</body>
</html>