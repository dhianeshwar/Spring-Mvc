<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Transaction Form</title>
</head>
<body>
<h2>Transaction Form</h2>
<h2>${error}</h2>

<form action="performTransaction" method="post">
    <label for="senderAccountNumber">Sender Account Number:</label>
    <input type="text" name="senderAccountNumber" id="senderAccountNumber" value="${merchant.accountNumber}"  readonly required>
    <br>

    <label for="receiverAccountNumber">Receiver Account Number:</label>
    <input type="text" name="receiverAccountNumber" id="receiverAccountNumber" required>
    <br>

    <label for="amount">Transaction Amount:</label>
    <input type="text" name="amount" id="amount" required>
    <br>
    <input type="submit" value="Perform Transaction">
</form>

</body>
</html>
