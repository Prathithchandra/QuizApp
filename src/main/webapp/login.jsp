<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>

<form action="login" method="post">
    <label>Email:</label><br>
    <input type="text" name="email" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required><br><br>

    <button type="submit">Login</button>
</form>

<br>
<a href="register.jsp">New user? Register</a>

<%
    String error = request.getParameter("error");
    if(error != null){
%>
    <p style="color:red;">Invalid email or password!</p>
<%
    }
%>
</body>
</html>
