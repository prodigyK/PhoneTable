<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Phones</title>
    <jsp:include page="resources.jsp"/>
    <style>

        .searched {
            background-color: lightgreen;
        }

        .boss {
            background-color: #ccffcc;
            font-weight: bold;
        }

        .normal {

        }

        .background {
            background-color: lightgrey;
        }

        th {
            align-content: center;
            align-items: center;
            text-align: center;
            font-size: small;

        }

        .td {
            text-align: center;
            vertical-align: top;
            width: 500px;
        }

        .nameWidth {
            width: 300px;
        }

        .phoneWidth {
            width: 100px;
        }

        #fix_nv {
            z-index: 5;
            position: fixed;
            top: 80px;
            left: -15px;
            text-align: left;
            font-size: smaller;
            padding: 10px;
            zoom: 90%;
        }

        #fix_right {
            z-index: 5;
            position: fixed;
            top: 80px;
            right: 3px;
            text-align: left;
            font-size: smaller;
            padding: 10px;
            width: 220px;
            zoom: 90%;
        }

        <c:forEach items="${subdivisionList}" var="dep">
        #dep-${dep.id}:before {
            display: block;
            content: "";
            height: 75px;
            margin: -55px 0 0;
        }

        </c:forEach>

        .selection {
            border: #00b3ee;
        }
    </style>
    <script>

    </script>
</head>
<body>

<%--<jsp:include page="header.jsp"/>--%>
<%@include file="header.jsp" %>

<div id="fix_nv" class="alert alert-dismissible w3-card-2 w3-light-grey w3-panel w3-topbar w3-border-grey">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <c:if test="${office}">
        <ul class="sllft">
            <h7><b>Офис</b></h7>
            <c:forEach items="${officeList}" var="dep">
                <li><a href="#dep-${dep.id}"> ${dep.name}</a></li>
            </c:forEach>
        </ul>
    </c:if>
    <ul class="sllft">
        <h7><b>Подразделения</b></h7>
        <c:forEach items="${topSubdivisions}" var="dep">
            <li><a href="${dep.id}"> ${dep.name}</a></li>
        </c:forEach>
    </ul>
</div>

<div id="fix_right" class="alert alert-dismissible w3-card-2 w3-light-grey w3-panel w3-topbar w3-border-grey w3-small">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <ul class="sllft">
        <li><p><b>Для звонков по Одессе</b> набирать городской номер без добавления кода города.</p></li>
        <li><p><b>Для звонков на городские номера Украины</b> набирать <br/>(код города)(номер)</p></li>
        <li><p><b>Звонки на мобильные по Украине</b> осуществляются в формате 067ХХХХХХХ. </p></li>
        <li><p><b>Звонки по России</b> <br/>007(код)(номер).</p></li>
        <li><p><b>Звонки на международные направления</b> <br/>00(код страны)(код города)(номер)</p></li>
        <li><p><b>Для перевода звонка на внутренний номер</b> необходимо нажать<br/> ##(номер абонента)</p></li>

    </ul>
</div>

<div class="container">

    <%--<div class="dropdown">--%>
        <%--<button class="btn btn-secondary dropdown-toggle w3-card-2" type="button" data-toggle="dropdown"--%>
                <%--style="width: 300px; margin-left: 57px" id="subdivButton">--%>
            <%--&lt;%&ndash;<a class="dropdown-item" href="${division.id}"><i class="fa fa-university fa-fw" aria-hidden="true"></i> ${division.name}</a>&ndash;%&gt;--%>
            <%--<i class="fa fa-university fa-fw" aria-hidden="true"></i><b> Подразделение</b>--%>
            <%--<span class="caret"></span></button>--%>
        <%--<ul class="dropdown-menu">--%>
            <%--<div class="list-group">--%>
                <%--<c:if test="${!empty subdivisionList}">--%>
                    <%--<c:forEach items="${subdivisionList}" var="division">--%>
                        <%--<c:if test="${empty division.parent}">--%>
                            <%--<spring:url var="subdiv" value="/subdiv"/>--%>
                            <%--<a class="dropdown-item" href="${division.id}"><i class="fa fa-university fa-fw"--%>
                                                                              <%--aria-hidden="true"></i>&nbsp; ${division.name}--%>
                            <%--</a>--%>
                        <%--</c:if>--%>
                    <%--</c:forEach>--%>
                <%--</c:if>--%>
            <%--</div>--%>
        <%--</ul>--%>
    <%--</div>--%>

    <%--<hr/>--%>


    <table border="0" align="center" style="table-layout: auto;" id="mainTable">
        <tr>
            <td class="td">
                <c:if test="${not empty search}">

                    <%--<c:if test="${empty phones}">--%>
                    <%--<div class="alert alert-warning" style="width: 800px; margin: 0 auto;">--%>
                    <%--<strong>Info! </strong> No results were found while searching.--%>
                    <%--</div>--%>
                    <%--</c:if>--%>

                    <c:forEach items="${searchDepList}" var="leftDep">

                        <table class="table table-bordered table-striped w3-tiny w3-card-4"
                               style="width: 400px; vertical-align:top;">
                            <thead>
                            <th colspan="2" align="center"
                                class="background"><i class="fa fa-home" aria-hidden="true"></i> ${leftDep.name}</th>
                            </thead>
                            <tbody>

                            <c:forEach items="${phoneList}" var="phone">
                                <c:set var="found" value="false"/>
                                <c:if test="${phone.subdivision.id == leftDep.id}">
                                    <c:forEach items="${phones}" var="phoneSearch">
                                        <c:if test="${phoneSearch.id == phone.id}">
                                            <c:set var="found" value="true"/>
                                            <tr class="searched">
                                                <td class="nameWidth searched"><b>${phone.userName}</b></td>
                                                <td class="td phoneWidth searched"><b>${phone.number}</b></td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${found == false}">
                                        <tr>
                                            <td class="nameWidth">${phone.userName}</td>
                                            <td class="td phoneWidth">${phone.number}</td>
                                        </tr>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                            </tbody>
                        </table>
                        <br/>
                    </c:forEach>

                </c:if>

                <c:forEach items="${leftDepList}" var="leftDep">

                    <div id="dep-${leftDep.id}"></div>

                    <table class="table table-bordered table-striped w3-tiny w3-card-4"
                           style="width: 400px; vertical-align:top;" align="center" id="table-${leftDep.id}">
                        <thead>
                        <th colspan="2" align="center"
                            class="background"><i class="fa fa-home" aria-hidden="true"></i> ${leftDep.name}</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${phoneList}" var="phone">
                            <c:if test="${phone.subdivision.id == leftDep.id}">
                                <tr>
                                    <td class="nameWidth ${not empty phone.boss ? 'boss' : 'normal'}">${phone.userName}</td>
                                    <td class="td phoneWidth ${not empty phone.boss ? 'boss' : 'normal'}">${phone.number}</td>
                                </tr>
                            </c:if>
                        </c:forEach>
                        </tbody>
                    </table>
                    <br/>
                </c:forEach>

            </td>


            <td class="td">
                <c:if test="${not empty rightDepList}">
                    <c:forEach items="${rightDepList}" var="rightDep">
                        <div id="dep-${rightDep.id}"></div>
                        <table class="table table-bordered table-striped w3-tiny w3-card-4"
                               style="width: 400px; vertical-align:top;" align="center">
                            <thead>
                            <th colspan="2" align="center"
                                class="background"><i class="fa fa-home" aria-hidden="true"></i> ${rightDep.name}</th>
                            </thead>
                            <tbody>
                            <c:forEach items="${phoneList}" var="phone">
                                <c:if test="${phone.subdivision.id == rightDep.id}">
                                    <tr>
                                        <td class="nameWidth ${not empty phone.boss ? 'boss' : 'normal'}">${phone.userName}</td>
                                        <td class="td phoneWidth ${not empty phone.boss ? 'boss' : 'normal'}">${phone.number}</td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                            </tbody>
                        </table>
                        <br/>
                    </c:forEach>
                </c:if>
            </td>

        </tr>
    </table>

</div>

</body>
</html>
