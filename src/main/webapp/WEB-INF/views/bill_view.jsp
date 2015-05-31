<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<style>
.total-row {
    background-color: #DBDBDB;
}
</style>

<%@ page isELIgnored="false" %>
</head>
<body>

<div class="row">
  <div class="col-md-3"></div>
  <div class="col-md-6">

<h2>Sky Bill</h2>

<table class="table">
    <tr>
        <td>Date</td>
        <td>${bill.statement.generated}</td>
    </tr>
    <tr>
        <td>Due</td>
        <td>${bill.statement.due}</td>
    </tr>
    <tr>
        <td>Period</td>
        <td>${bill.statement.period.from} - ${bill.statement.period.to}</td>
    </tr>
    <tr>
        <td>Total</td>
        <td>${bill.total}</td>
    </tr>
</table>
<br/>

<h3>Subscriptions</h3>
<table class="table">
    <thead>
    <tr class="info">
        <th>Type</th>
        <th>Name</th>
        <th>Cost</th>
    </tr>
    </thead>
    <c:forEach var="subscription" items="${bill.package.subscriptions}" varStatus="status">
    <tr>
    	<td>${subscription.type}</td>
        <td>${subscription.name}</td>
    	<td>${subscription.cost}</td>
    </tr>
</c:forEach>
    <tfoot>
        <tr class="total-row">
            <td colspan="2">Total</td>
            <td>${bill.callCharges.total}</td>
        </tr>
    </tfoot>
</table>
<br/>

<h3>Calls</h3>
<table class="table">
    <thead>
    <tr class="info">
        <th>Called</th>
        <th>Duration</th>
        <th>Cost</th>
    </tr>
    </thead>
    <c:forEach var="call" items="${bill.callCharges.calls}" varStatus="status">
    <tr>
    	<td>${call.called}</td>
        <td>${call.duration}</td>
    	<td>${call.cost}</td>
    </tr>
</c:forEach>
    <tfoot>
        <tr class="total-row">
            <td colspan="2">Total</td>
            <td>${bill.callCharges.total}</td>
        </tr>
    </tfoot>
</table>
<br/>

<h3>SkyStore</h3>
<table class="table">
    <thead>
    <tr class="info">
        <th>Type</th>
        <th>Title</th>
        <th>Cost</th>
    </tr>
    </thead>
    <c:forEach var="rental" items="${bill.skyStore.rentals}" varStatus="status">
    <tr>
    	<td>Rental</td>
        <td>${rental.title}</td>
    	<td>${rental.cost}</td>
    </tr>
    </c:forEach>

    <c:forEach var="buy" items="${bill.skyStore.buyAndKeep}" varStatus="status">
    <tr>
        <td>Purchase</td>
        <td>${buy.title}</td>
        <td>${buy.cost}</td>
    </tr>
    </c:forEach>

    <tfoot>
        <tr class="total-row">
            <td colspan="2">Total</td>
            <td>${bill.callCharges.total}</td>
        </tr>
    </tfoot>
</table>
</div>
  <div class="col-md-3"></div></body>
</html>

