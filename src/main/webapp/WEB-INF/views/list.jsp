<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Merchant List</title>
</head>
<body>
<h2>Merchant List</h2>
<h2>${error}</h2>
<table border="1">
    <tr>
        <th>Account Number</th>
        <th>Name</th>
        <th>Balance</th>
        <th>Age</th>
        <th>Email ID</th>
        <th>Update</th>
        <th>Delete</th>
        <th>Send Amount</th>
        <th>Send details</th>
        <th>Receiving details</th>
    </tr>
    <c:forEach var="merchant" items="${merchants}">
        <tr>
            <td>${merchant.accountNumber}</td>
            <td>${merchant.name}</td>
            <td>${merchant.balance}</td>
            <td>${merchant.age}</td>
            <td>${merchant.emailId}</td>
            <td><a href="<%=request.getContextPath()%>/update?accountNumber=${merchant.accountNumber}">Update</a></td>
            <td><a href="<%=request.getContextPath()%>/delete?accountNumber=${merchant.accountNumber}">Delete</a></td>
            <td><a href="<%=request.getContextPath()%>/send?accountNumber= ${merchant.accountNumber}">send</a></td>
            <td><a href="<%=request.getContextPath()%>/viewSenders?accountNumber= ${merchant.accountNumber}">Sending Transactions</a></td>
            <td><a href="<%=request.getContextPath()%>/viewReceivers?accountNumber= ${merchant.accountNumber}">Receiving Transactions</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
