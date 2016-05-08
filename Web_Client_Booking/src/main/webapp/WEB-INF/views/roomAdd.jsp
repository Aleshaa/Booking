<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

  <title>Редактировать комнату</title>

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

  <form:form method="POST" modelAttribute="roomForm" class="form-signin">
    <h2 class="form-signin-heading">Комната</h2>
    <spring:bind path="idRoom">
      <form:input type="hidden" path="idRoom" class="form-control" autofocus="true"></form:input>
    </spring:bind>
    <spring:bind path="nRoom">
      <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:input type="text" path="nRoom" class="form-control" placeholder="Номер комнаты"
                    autofocus="true"></form:input>
        <form:errors path="nRoom"></form:errors>
      </div>
    </spring:bind>

    <spring:bind path="typeroomByIdTRoom">
      <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:select path="typeroomByIdTRoom" class="form-control">
          <c:forEach items = "${TRList}" var="tr">
            <form:option value="${tr.nameTRoom}">${tr.nameTRoom}</form:option>
          </c:forEach>
        </form:select>
        <form:errors path="typeroomByIdTRoom"></form:errors>
      </div>
    </spring:bind>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Сохранить</button>
    <br><br/>
    <div class="text-center">
      <a href="${contextPath}/roomList" class="btn btn-primary" role="button">Отмена</a>
    </div>
  </form:form>

</div>
<!-- /container -->
<br><br/>
<br><br/>
<br><br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<%@include file="footer.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>

