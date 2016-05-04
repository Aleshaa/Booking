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

  <title>Редактировать бронь</title>

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

  <form:form method="POST" modelAttribute="reservForm" class="form-signin">
    <h2 class="form-signin-heading">Комната</h2>
    <spring:bind path="idReserv">
      <form:input type="hidden" path="idReserv" class="form-control" autofocus="true"></form:input>
    </spring:bind>
    <spring:bind path="interestPayment">
      <form:input type="hidden" path="interestPayment" class="form-control" autofocus="true"></form:input>
    </spring:bind>
    <spring:bind path="idUser">
      <form:input type="hidden" path="idUser" class="form-control" autofocus="true"></form:input>
    </spring:bind>
    <spring:bind path="roomByIdRoom">
      <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:select path="roomByIdRoom" class="form-control">
          <c:forEach items = "${RoomList}" var="tr">
            <form:option value="${tr.nRoom}">${tr.nRoom}</form:option>
          </c:forEach>
        </form:select>
      </div>
    </spring:bind>

    <spring:bind path="checkInDate">
      <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:input type="text" path="checkInDate" class="form-control" placeholder="Дата заезда"
                    autofocus="true"></form:input>
        <form:errors path="checkInDate"></form:errors>
      </div>
    </spring:bind>

    <spring:bind path="checkOutDate">
      <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:input type="text" path="checkOutDate" class="form-control" placeholder="Дата выезда"
                    autofocus="true"></form:input>
        <form:errors path="checkOutDate"></form:errors>
      </div>
    </spring:bind>

    <spring:bind path="complete">
      <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:select path="complete" class="form-control">
            <form:option value="0">Не оплачено</form:option>
            <form:option value="1">Оплачено</form:option>
        </form:select>
      </div>
    </spring:bind>

    <spring:bind path="arrived">
      <div class="form-group ${status.error ? 'has-error' : ''}">
        <form:select path="arrived" class="form-control">
          <form:option value="0">Не прибыл</form:option>
          <form:option value="1">Прибыл</form:option>
        </form:select>
      </div>
    </spring:bind>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    <br><br/>
    <div class="text-center">
      <a href="${contextPath}/reservList" class="btn btn-primary" role="button">Cancel</a>
    </div>
  </form:form>

</div>
<!-- /container -->
<%@include file="footer.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>

