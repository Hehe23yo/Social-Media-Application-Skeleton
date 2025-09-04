<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
    <h1> User Registration </h1>
    <form action = "registerHandler">
        <label>Enter username : </label>
        <input type="text" name="userName" placeholder="Enter username" required>
        <br>
        <label>Enter password : </label>
        <input type="password" name="userPassword" placeholder="Enter password" required>
        <br>
        <input type="submit">
    </form>
    <br>
    <form action = "login.jsp">
        <input type="submit" value="login instead?">
    </form>
</body>
</html>