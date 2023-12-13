<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Update Merchant</title>
</head>
<body>
<h2>Update Merchant</h2>

<form action="updateNow" method="post">
    <input type="hidden" name="accountNumber" value="${merchant.accountNumber}">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${merchant.name}" required><br>

    <label for="balance">Balance:</label>
    <input type="text" id="balance" name="balance" value="${merchant.balance}" required><br>

    <label for="age">Age:</label>
    <input type="text" id="age" name="age" value="${merchant.age}" required><br>

    <label for="emailId">Email ID:</label>
    <input type="text" id="emailId" name="emailId" value="${merchant.emailId}" required><br>

    <button type="submit">Update</button>
</form>

</body>
</html>
