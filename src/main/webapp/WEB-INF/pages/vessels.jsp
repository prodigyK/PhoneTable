<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Phones</title>
    <jsp:include page="resources.jsp"/>

</head>
<body>
<%@include file="header.jsp" %>

<br/>

<hr/>
<div class="container">
    <table class="table table-striped table-condensed w3-small">
        <thead>
        <tr>
            <th>Fleet</th>
            <th>Vessel</th>
            <th>Ukraine phone</th>
            <th>Abroad phone</th>
            <th>Travelsim</th>
            <th>E-mail</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${vesselList}" var="vessel">
            <tr>
                <td>${vessel.fleet.name}</td>
                <td><b>${vessel.name}</b></td>
                <td>${vessel.phoneUkraine}</td>
                <td>${vessel.phoneAbroad}</td>
                <td>${vessel.phoneTravel}</td>
                <td>${vessel.email}</td>
                <td></td>
                <td></td>
            </tr>
        </c:forEach>
        <tr>

        </tr>
        </tbody>
    </table>

</div>
</body>
</html>
