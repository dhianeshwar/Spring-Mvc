<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Senders</title>
</head>
<body>

<h2>Senders List</h2>

<c:if test="${not empty senders}">
    <table border="1">
        <thead>
        <tr>
            <th>Transaction ID</th>
            <th>Sender Account Number</th>
            <th>Receiver Account Number</th>
            <th>Amount</th>
            <th>Transaction Time</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sender" items="${senders}">
            <tr>
                <td>${sender.transactionId}</td>
                <td>${sender.senderAccountNumber}</td>
                <td>${sender.receiverAccountNumber}</td>
                <td>${sender.amount}</td>
                <td>${sender.transactionTime}</td>
            </tr>
            <c:set var="totalAmount" value="${totalAmount + sender.amount}" />

        </c:forEach>
        </tbody>
    </table>
    <p>Total Amount: ${totalAmount}</p>
</c:if>

<c:if test="${empty senders}">
    <p>${error}</p>
</c:if>
</body>
</html>
