<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro</title>
</head>
<body>
<h2>Registrar</h2>
<form action="/register" method="post">
    <label>Nome:</label>
    <input type="text" name="nomeUsuario" /><br>
    <label>Email:</label>
    <input type="text" name="emailUsuario" /><br>
    <label>Senha:</label>
    <input type="password" name="senhaUsuario" /><br>
    <button type="submit">Registrar</button>
</form>
<p>Já tem conta? <a href="/">Voltar ao Login</a></p>
</body>
</html>
