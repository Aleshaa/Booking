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

  <title>Добавить тип комнат</title>

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

  <form:form method="POST" modelAttribute="trForm" class="form-signin">
    <h2 class="form-signin-heading">Создать новый тип комнат в отеле</h2>
    <spring:bind path="idTRoom">
        <form:input type="hidden" path="idTRoom" class="form-control" placeholder="Название типа"
                    autofocus="true"></form:input>
    </spring:bind>
    <spring:bind path="nameTRoom">
      <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:input type="text" path="nameTRoom" class="form-control" placeholder="Название типа"
                    autofocus="true"></form:input>
        <form:errors path="nameTRoom"></form:errors>
      </div>
    </spring:bind>

    <spring:bind path="roominess">
      <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:input type="text" path="roominess" class="form-control" placeholder="Вместительность"></form:input>
        <form:errors path="roominess"></form:errors>
      </div>
    </spring:bind>

    <spring:bind path="price">
      <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:input type="text" path="price" class="form-control"
                    placeholder="Стоимость в сутки"></form:input>
        <form:errors path="price"></form:errors>
      </div>
    </spring:bind>
    <spring:bind path="pictureByIdPicture">
      <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:input type="file" path="pictureByIdPicture" class="form-control" value="pic2.jpg" placeholder="Путь к картинке"
                    autofocus="true"></form:input>
        <form:errors path="pictureByIdPicture"></form:errors>
      </div>
    </spring:bind>
    <input type="hidden" name="pic" value="${trForm.pictureByIdPicture}">
    <button class="btn btn-lg btn-primary btn-block" type="submit">Сохранить</button>
    <br><br/>
    <div class="text-center">
      <a href="${contextPath}/trList" class="btn btn-primary" role="button">Отмена</a>
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

