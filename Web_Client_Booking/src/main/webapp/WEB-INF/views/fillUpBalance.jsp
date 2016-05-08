<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Create an account</title>

  <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  <link href="${contextPath}/resources/css/simple-sidebar.css" rel="stylesheet">


  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body>

<%@include file="navibar.jsp"%>

<div class="container" align="center">
        <form:form action="fillUpBalance" method="post" class="form-signin" role="search">
          <p class="text-success">${message}</p>
          <br><br/>
          <input type="hidden" id="idUser" name="idUser" value="${idUser}"/>
          <p>Введите количество</p>
          <input class="form-control" id="cash" name="cash" type="number" min="100" max="1000" step="10"  required/>
          <br><br/>
          <p>Пароль</p>
          <input class="form-control" id="password" name="password" type="password" placeholder="Пароль" required/>
          <br><br/>
          <p>Повторите пароль</p>
          <input class="form-control" id="passwordConfirm" name="passwordConfirm" type="password" placeholder="Пароль" required/>
          <br><br/>
          <button type="submit" class="btn btn-default">Пополнить</button>
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
