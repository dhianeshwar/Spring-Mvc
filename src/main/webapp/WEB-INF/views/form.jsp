<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Merchant Form</title>
</head>
<body>

<h2>Merchant Form</h2>
<h2>${error}</h2>
<form action="insert" method="post">
    account nunmber:
    <input type="text" name="accountNumber"/>
    <label >Name:</label>
    <input type="text" name="name"  required/><br/>

    <label >Balance:</label>
    <input type="text" name="balance"  required/><br/>

    <label>Age:</label>
    <input type="text" name="age"  required/><br/>

    <label>Email:</label>
    <input type="text" name="emailId"  required/><br/>


    <input type="submit" value="Save"/>
</form>

</body>
</html>