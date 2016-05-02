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

  <title>Бронирование</title>

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

<div class="container" align="center">
  <c:if test="${count > 0}">
  <h1>С ${dateFrom} по ${dateFor} свободно ${count} номеров вместительностью ${roominess} человек</h1>
  <div class="row">
    <c:forEach var="tr" items="${listTR}" varStatus="status">
      <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
          <img src="${contextPath}/resources/img/${tr.pictureByIdPicture}" alt="...">
          <div class="caption">
            <h3>${tr.nameTRoom}</h3>
            <p>Вместительность: ${tr.roominess} человек<br><br/> Цена: ${tr.price} </p>
            <security:authorize access="hasRole('ROLE_USER')">
              <p><a href="${contextPath}/bookingRoom?id=${tr.idTRoom}&count=${count}&date=${dateFrom}" class="btn btn-primary" role="button">Забронировать</a></p>
            </security:authorize>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
  </c:if>
  <c:if test="${count == 0}">
    <h1>К сожалению с ${dateFrom} по ${dateFor} свободных номеров нет</h1>
  </c:if>
  <c:if test="${count < 0}">
    <h1>${message}</h1>
  </c:if>
</div>
<!-- /container -->
<%@include file="footer.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
