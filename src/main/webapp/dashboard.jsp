<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    HttpSession sessionUser = request.getSession(false);
    if(sessionUser == null || sessionUser.getAttribute("user") == null){
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
</head>
<body>

<h2>Welcome, <%= sessionUser.getAttribute("user") %></h2>

<a href="quiz.jsp">Start Quiz</a><br><br>
<a href="logout">Logout</a>

</body>
</html>
