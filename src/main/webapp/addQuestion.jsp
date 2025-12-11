<!DOCTYPE html>
<html>
<head>
    <title>Add Question</title>
</head>
<body>

<h2>Add New Question</h2>

<form action="addQuestion" method="post">
    <input type="text" name="question" placeholder="Enter question" required><br><br>

    <input type="text" name="option1" placeholder="Option 1" required><br>
    <input type="text" name="option2" placeholder="Option 2" required><br>
    <input type="text" name="option3" placeholder="Option 3" required><br>
    <input type="text" name="option4" placeholder="Option 4" required><br><br>

    <label>Correct Option:</label>
    <select name="correct">
        <option value="1">Option 1</option>
        <option value="2">Option 2</option>
        <option value="3">Option 3</option>
        <option value="4">Option 4</option>
    </select><br><br>

    <button type="submit">Save Question</button>
</form>

</body>
</html>
