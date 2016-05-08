<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
  <title>Список номеров</title>
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
  <h1>Список комнат</h1>
  <table class="table">
    <th>ID</th>
    <th>Номер комнаты</th>
    <th>Тип комнаты</th>
    <th>Вид</th>

    <c:forEach var="room" items="${listRoom}" varStatus="status">
      <tr>
          <td>${room.idRoom}</td>
          <td>${room.nRoom}</td>
          <td>${room.typeroomByIdTRoomTR.nameTRoom}</td>
          <td><img src="${contextPath}/resources/img/${room.typeroomByIdTRoomTR.pictureByIdPicture}" alt="..."></td>
          <security:authorize access="hasRole('ROLE_ADMIN')">
              <td>
                <a href="deleteRoom?id=${room.idRoom}">Удалить</a>
                <a href="${contextPath}/roomEdit?id=${room.idRoom}">Редактировать</a>
              </td>
          </security:authorize>
      </tr>
    </c:forEach>
  </table>
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
