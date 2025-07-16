<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="/login" method="post">
    <label>Email:</label>
    <input type="text" name="emailUsuario" /><br>
    <label>Senha:</label>
    <input type="password" name="senhaUsuario" /><br>
    <button type="submit">Entrar</button>
</form>

<p>Não tem conta? <a href="/register">Registrar</a></p>
</body>
</html>
