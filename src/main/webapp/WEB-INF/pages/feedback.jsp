<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Feedback</title>
    <jsp:include page="resources.jsp"/>
</head>
<body>
<%@include file="header.jsp" %>

<c:if test="${isSuccess}">
<div class="container w3-small">
    <div class="alert alert-success alert-dismissible w3-card-2">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong>Спасибо! Отзыв успешно отправлен!</strong>
        <%--<div class="card-body">Спасибо! Отзыв успешно отправлен!</b>--%>
        <%--</div>--%>
    </div>
</div>
</c:if>
<c:if test="${isFailure}">
    <div class="container w3-small">
        <div class="alert alert-danger alert-dismissible w3-card-2">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <strong>К сожалению, отзыв не удалось отправить. Пробуйте попытку чуть позже. Приносим свои извинения.
            </strong>
        </div>
    </div>
</c:if>

<div class="container w3-small">
    <div class="card bg-secondary text-white w3-card-2 w3-small">
        <div class="card-body">Вы можете оставить отзыв о работе телефонного справочника, а так же можете внести свои
            предложения по интерфейсу и юзабилити.
        </div>
    </div>
    <br>
    <spring:url var="sendFeedback" value="/sendFeedback"/>
    <form:form modelAttribute="newFeedback" action="${sendFeedback}">
        <div class="form-group">
            <label for="comment"><b>Отзыв:</b></label>
            <form:textarea path="text" rows="3" cssClass="form-control w3-small" id="comment"/>
        </div>
        <button type="submit" class="btn btn-secondary w3-small">Отправить</button>
    </form:form>

</div>


</body>
</html>
