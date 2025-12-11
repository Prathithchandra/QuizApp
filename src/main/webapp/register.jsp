<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Register</h2>

<form action="register" method="post">
    <label>Name:</label><br>
    <input type="text" name="name" required><br><br>

    <label>Email:</label><br>
    <input type="email" name="email" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required><br><br>

    <button type="submit">Register</button>
</form>

<br>
<a href="login.jsp">Already have an account? Login</a>

<%
    String success = request.getParameter("register");
    if("success".equals(success)){
%>
    <p style="color:green;">Registration successful! Please login.</p>
<%
    }
%>
</body>
</html>
