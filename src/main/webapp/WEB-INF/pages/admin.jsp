<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Phones Database</title>
    <jsp:include page="/WEB-INF/pages/resources.jsp"/>

</head>
<body>
<div class="jumbotron">
    <div class="container" align="center">
        <h4><b>Phones Admin Panel</b></h4>

        <div class="container">
            <table align="center">
                <form name='form_login' action="j_spring_security_check" method='POST'>
                    <tr>
                        <%--<td align="center">--%>
                        <%--<h4><b>Noon Reports</b></h4>--%>
                        <%--</td>--%>
                    </tr>
                    <tr>
                        <td>
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input id="username" type="text" class="form-control" name='user_login'
                                       placeholder="Username">
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <td>

                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="password" type="password" class="form-control" name='password_login'
                                       placeholder="Password">
                            </div>
                            <div align="right">
                                <button type="submit" name="Login" class="btn btn-block"><b>Login</b></button>
                            </div>
                            <c:if test="${not empty error}">
                                <div style="color: red; text-align: center; font-size:small;"><h7>${error}</h7></div>
                            </c:if>

                        </td>
                    </tr>
                </form>
            </table>
        </div>

    </div>
</div>


</body>
</html>