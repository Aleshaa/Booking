<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Столбчатая диаграмма</title>
  <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<%@ include file="navibar.jsp" %>
<script src="${contextPath}/resources/js/loader.js"></script>
<script type="text/javascript">
  google.charts.load('current', {'packages':['corechart']});
  google.charts.setOnLoadCallback(drawChart);
  function drawChart() {
    function draw(type, title) {
      var charBlock = document.getElementById(type),
              chart = new google.visualization.BarChart(charBlock),
              tr = charBlock.getAttribute("value").split(",");
      data = new google.visualization.DataTable();
      data.addColumn('string', 'Тип комнаты');
      data.addColumn('number', 'Количество забронированных комнат');
      data.addRows(tr.length);
      for(var i=0;i<tr.length;i++){
        data.setCell(i,0,tr[i].split(":")[0]);
        data.setCell(i,1,tr[i].split(":")[1]);
      }
      var options = {
        title: title
      };
      chart.draw(data, options);
    }
    draw("chart", "Статистика популярности номеров");
  }
</script>
<div class="container">
  <div class="jumbotron">
    <div class="text-center row row-centered">
      <h1>Статистика популярности номеров</h1>
      <div class="text-center row row-centered" id="chart" style="display: inline-block; width: 500px; height: 500px;" name="chart" value="${chart}"></div>
    </div>
  </div>
</div>
<%@include file="footer.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
