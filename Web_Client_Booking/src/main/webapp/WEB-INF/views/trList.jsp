<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Типы номеров</title>
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
  <h1>Список типов номеров</h1>
  <div class="row">
    <c:forEach var="tr" items="${listTR}" varStatus="status">
      <div class="col-sm-6 col-md-4">
        <div class="thumbnail">
          <img src="${contextPath}/resources/img/${tr.pictureByIdPicture.uploadedNname}" alt="...">
          <div class="caption">
            <h3>${tr.nameTRoom}</h3>
            <p>Вместительность: ${tr.roominess} человек<br><br/> Цена: ${tr.price} </p>
            <p><a href="#" class="btn btn-primary" role="button">Удалить</a> <a href="#" class="btn btn-default" role="button">Редактировать</a></p>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
</body>
</html>
