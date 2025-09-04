<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h1> User Login </h1>
    <form action = "loginHandler">
        <label>Enter username : </label>
        <input type="text" name="userName" placeholder="Enter username" required>
        <br>
        <label>Enter password : </label>
        <input type="password" name="userPassword" placeholder="Enter password" required>
        <br>
        <input type="submit">
    </form>
    <br>
    <form action = "register.jsp">
        <input type="submit" value="register instead?">
    </form>
</body>
</html>