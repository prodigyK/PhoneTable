<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core_rt" %>--%>


<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top w3-card-4" id="navbar">
    <!-- Brand -->
    <a class="navbar-brand" href="#"><i class="fa fa-phone" aria-hidden="true"></i> Phones Table</a>

    <div class="container">

        <!-- Links -->
        <ul class="navbar-nav">

            <li class="nav-item mr-sm-2 active">
                <spring:url value="/" var="main"/>
                <a class="nav-link" href="${main}"><b> Office</b></a>
            </li>
            <li class="nav-item mr-sm-2 active">
                <spring:url value="/vessels" var="vessels"/>
                <a class="nav-link" href="${vessels}"><b> Vessels</b></a>
            </li>
            <li class="nav-item mr-sm-2 active">
                <spring:url value="/feedback" var="feedback"/>
                <a class="nav-link" href="${feedback}"><b> Feedback</b></a>
            </li>
            <li class="nav-item mr-sm-2">
                <spring:url var="search" value="/search"/>
                <form:form class="form-inline ml-3 my-auto d-inline w-100" action="${search}" modelAttribute="userName">
                    <div class="input-group">
                        <input type="text" class="form-control" name="name" placeholder="Search phone or username"
                               style="width: 300px">
                        <span class="input-group-btn">
                    <button class="btn btn-secondary" type="submit"><i class="fa fa-search" aria-hidden="true"></i> </button>
                    </span>
                    </div>
                </form:form>
            </li>
        </ul>

    </div>
    <%--<ul class="navbar-nav justify-content-end">--%>
        <%--<spring:url var="login" value="/admin/login"/>--%>
        <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="${login}"><i class="fa fa-user" aria-hidden="true"></i> Login</a>--%>

        <%--</li>--%>
    <%--</ul>--%>
</nav>


<br>
<br>
<br>
<br>
