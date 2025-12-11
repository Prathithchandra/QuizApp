<%
    Integer score = (Integer) request.getAttribute("score");
    Integer total = (Integer) request.getAttribute("total");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
</head>
<body>

<h2>Your Result</h2>

<p>Score: <%= score %> / <%= total %></p>

<a href="dashboard.jsp">Back to Dashboard</a>

</body>
</html>
