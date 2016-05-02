<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
  <title>Личный кабинет</title>
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
  <div id="wrapper" class="toggled">
    <!-- Sidebar -->
    <div id="sidebar-wrapper">
      <ul class="sidebar-nav">
        <li class="sidebar-brand">
          <a href="#">
            Личный кабинет
          </a>
        </li>
        <li>
          <a href="editAccount?id=${user.idUser}">Редактировать профиль</a>
        </li>
        <li>
          <a href="fillUpBalance?id=${user.idUser}">Пополнить баланс</a>
        </li>
      </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-12">
            <h1>Инфрмация об профиле</h1>
            <table class="table">
              <input type="hidden" name="idUser" value="${user.idUser}"/>
              <tr>
                <td>Username:</td>
                <td>${user.username}</td>
              </tr>
              <tr>
                <td>Фамилия:</td>
                <td>${user.secondName}</td>
              </tr>
              <tr>
                <td>Имя:</td>
                <td>${user.firstName}</td>
              </tr>
              <tr>
                <td>Отчество:</td>
                <td>${user.patronymic}</td>
              </tr>
              <tr>
                <td>Дата рождения:</td>
                <td>${user.dob}</td>
              </tr>
              <tr>
                <td>Серия паспорта:</td>
                <td>${user.passportSeries}</td>
              </tr>
              <tr>
                <td>Номер паспорта:</td>
                <td>${user.passportN}</td>
              </tr>
              <tr>
                <td>Идентификационный номер</td>
                <td>${user.identificationN}</td>
              </tr>
              <tr>
                <td>Денег на счету</td>
                <td>${user.cash}</td>
              </tr>
            </table>
            <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Изменить</a>
          </div>
        </div>
      </div>
    </div>
    <!-- /#page-content-wrapper -->
  </div>
  <!-- /#wrapper -->
</div>
<!-- jQuery -->
<script src="${contextPath}/resources/js/jquery.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- Menu Toggle Script -->
<script>
  $("#menu-toggle").click(function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
  });
</script>
<!-- /container -->
<%@include file="footer.jsp"%>
</body>
</html>
