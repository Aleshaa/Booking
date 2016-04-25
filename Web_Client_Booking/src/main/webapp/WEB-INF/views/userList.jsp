<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователи</title>
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
  <h1>Список пользователей</h1>
  <table class="table">
    <th>ID</th>
    <th>Username</th>
    <th>Фамилия</th>
    <th>Имя</th>
    <th>Отчество</th>
    <th>Дата рождения</th>
    <th>Серия паспорта</th>
    <th>Номер паспорта</th>
    <th>Идентификационный номер</th>
    <th>Денег на счету</th>

    <c:forEach var="user" items="${listUser}" varStatus="status">
      <tr>
        <c:if test="${user.idRole == 2}">
          <td>${user.idUser}</td>
          <td>${user.username}</td>
          <td>${user.secondName}</td>
          <td>${user.firstName}</td>
          <td>${user.patronymic}</td>
          <td>${user.dob}</td>
          <td>${user.passportSeries}</td>
          <td>${user.passportN}</td>
          <td>${user.identificationN}</td>
          <td>${user.cash}</td>
          <td>
            <a href="deleteUser?id=${user.idUser}">Delete</a>
          </td>
        </c:if>

      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
