<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Sports Registration</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <h2>Sports Registration Form</h2>--%>
<%--    <form action="register" method="post">--%>
<%--        Name: <input type="text" name="name" required pattern="[A-Za-z ]+"><br>--%>
<%--        Phone: <input type="text" name="phone" required pattern="\d{10}"><br>--%>
<%--        Email: <input type="email" name="email" required><br>--%>
<%--        Sport: <input type="text" name="sport" required><br>--%>
<%--        <input type="submit" value="Register">--%>
<%--    </form>--%>
<%--    <p style="color:red;">${error}</p>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sports Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }
        input[type="text"], input[type="email"] {
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
        .error {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Sports Registration Form</h2>
    <form action="register" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required pattern="[A-Za-z ]+">

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" required pattern="\d{10}">

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="sport">Sport:</label>
        <input type="text" id="sport" name="sport" required>

        <input type="submit" value="Register">
    </form>
    <p class="error">${error}</p>
</div>
</body>
</html>