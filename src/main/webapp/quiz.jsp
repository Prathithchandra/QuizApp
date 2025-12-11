<%@ page import="java.util.List" %>
<%@ page import="com.mphasis.dao.QuestionDAO" %>
<%@ page import="com.mphasis.models.Question" %>

<%
    QuestionDAO dao = new QuestionDAO();
    List<Question> questions = dao.getAllQuestions();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
</head>
<body>

<h2>Quiz Started</h2>

<form action="submitQuiz" method="post">

<%
 int i = 1;
 for(Question q : questions){
%>
    <p><b><%= i++ %>. <%= q.getQuestionText() %></b></p>
    <input type="radio" name="q<%= q.getId() %>" value="1"> <%= q.getOption1() %><br>
    <input type="radio" name="q<%= q.getId() %>" value="2"> <%= q.getOption2() %><br>
    <input type="radio" name="q<%= q.getId() %>" value="3"> <%= q.getOption3() %><br>
    <input type="radio" name="q<%= q.getId() %>" value="4"> <%= q.getOption4() %><br><br>
<%
 }
%>

<button type="submit">Submit Quiz</button>

</form>

</body>
</html>
