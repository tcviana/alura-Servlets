<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:if test="${empty usuarioLogado}">
	<p>Usu�rio n�o encontrado.</p>
</c:if>
<c:if test="${not empty usuarioLogado}">
	<p>Usu�rio ${usuarioLogado.email} conectado.</p>
</c:if>
</body>
</html>