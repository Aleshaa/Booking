<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Регистрация</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<%@include file="navibar.jsp"%>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Регистрация</h2>
        <spring:bind path="username">
            <p>Имя пользователя</p>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <p>Пароль</p>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <p>Повторите пароль</p>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="secondName">
            <p>Фамилия</p>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="secondName" class="form-control" placeholder="Фамилия"
                            autofocus="true"></form:input>
                <form:errors path="secondName"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="firstName">
            <p>Имя</p>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" class="form-control" placeholder="Имя"
                            autofocus="true"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="patronymic">
            <p>Отчество</p>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="patronymic" class="form-control" placeholder="Отчество"
                            autofocus="true"></form:input>
                <form:errors path="patronymic"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="dob">
            <p>Дата рождения(гггг-ММ-дд)</p>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="dob" class="form-control" placeholder="Дата рождения(гггг-ММ-дд)"
                            autofocus="true"></form:input>
                <form:errors path="dob"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="sex">
            <p>Пол</p>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select path="sex" class="form-control">
                    <form:option value="0">Мужской </form:option>
                    <form:option value="1">Женский</form:option>
                </form:select>
                <form:errors path="sex"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="passportSeries">
            <p>Серия паспорта</p>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="passportSeries" class="form-control" placeholder="Серия паспорта"
                            autofocus="true"></form:input>
                <form:errors path="passportSeries"></form:errors>

            </div>
        </spring:bind>
        <spring:bind path="passportN">
            <p>Номер паспорта</p>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="passportN" class="form-control" placeholder="Номер паспорта"
                            autofocus="true"></form:input>
                <form:errors path="passportN"></form:errors>

            </div>
        </spring:bind>
        <spring:bind path="identificationN">
            <p>Идентификационный номер паспорта</p>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="identificationN" class="form-control" placeholder="Идентификационный номер паспорта"
                            autofocus="true"></form:input>
                <form:errors path="identificationN"></form:errors>

            </div>
        </spring:bind>
        <spring:bind path="cash">
            <p>Количество денег</p>
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="cash" class="form-control" placeholder="Деньги"
                            autofocus="true"></form:input>
                <form:errors path="cash"></form:errors>

            </div>
        </spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Зарегистрироваться</button>
    </form:form>

</div>
<br><br/>
<br><br/>
<br><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<%@include file="footer.jsp"%>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
