<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Список броней</title>
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

<!-- container -->
<div class="container" align="center">
  <c:if test="${count>0}">
  <h1>Список комнат</h1>
  <table class="table">
    <th>ID</th>
    <th>Имя пользователя</th>
    <th>Номер комнаты</th>
    <th>Дата въезда</th>
    <th>Дата выезда</th>
    <th>Статус оплаты</th>
    <th>Процент начальной оплаты</th>
    <th>Статус прибытия</th>

    <c:forEach var="reserv" items="${listReserv}" varStatus="status">
      <security:authorize access="hasRole('ROLE_ADMIN')">
      <tr>
        <td>${reserv.idReserv}</td>
        <td>${reserv.userByIdUser.username}</td>
        <td>${reserv.roomByIdRoomR.nRoom}</td>
        <td>${reserv.checkInDateStr}</td>
        <td>${reserv.checkOutDateStr}</td>
        <c:if test="${reserv.complete == 0}">
          <td>Не оплачено</td>
        </c:if>
        <c:if test="${reserv.complete == 1}">
          <td>Оплачено</td>
        </c:if>
        <td>${reserv.interestPayment*100}</td>
        <c:if test="${reserv.arrived == 0}">
          <td>Не прибыл</td>
        </c:if>
        <c:if test="${reserv.arrived == 1}">
          <td>Прибыл</td>
        </c:if>
        <td>
          <a href="deleteReserv?id=${reserv.idReserv}">Удалить</a>
          <a href="${contextPath}/reservEdit?id=${reserv.idReserv}">Редактировать</a>
          <a href="#">Подтвердить прибытие</a>
        </td>

      </tr>
      </security:authorize>
      <security:authorize access="hasRole('ROLE_USER')">
        <c:if test="${reserv.userByIdUser.username == pageContext.request.userPrincipal.name}">
          <tr>
            <td>${reserv.idReserv}</td>
            <td>${reserv.userByIdUser.username}</td>
            <td>${reserv.roomByIdRoomR.nRoom}</td>
            <td>${reserv.checkInDateStr}</td>
            <td>${reserv.checkOutDateStr}</td>
            <c:if test="${reserv.complete == 0}">
              <td>Не оплачено</td>
            </c:if>
            <c:if test="${reserv.complete == 1}">
              <td>Оплачено</td>
            </c:if>
            <td>${reserv.interestPayment*100}</td>
            <c:if test="${reserv.arrived == 0}">
              <td>Не прибыл</td>
            </c:if>
            <c:if test="${reserv.arrived == 1}">
              <td>Прибыл</td>
            </c:if>
            <td>
              <a href="#">Подтвердить прибытие</a>
            </td>
          </tr>
        </c:if>
      </security:authorize>
    </c:forEach>
  </table>
  </c:if>
  <c:if test="${count == 0}">
    <h1 class="h1">Список броней пуст!</h1>
  </c:if>
</div>
<!-- /container -->
<%@include file="footer.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
