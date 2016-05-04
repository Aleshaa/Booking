<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">KMN Hotel</a>
    </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="${contextPath}/">На главную страницу</a></li>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
          <security:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="${contextPath}/userList">Пользователи</a></li>
          </security:authorize>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
          <security:authorize access="hasRole('ROLE_ADMIN')">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Типы номеров<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="${contextPath}/trList">Просмотреть</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="${contextPath}/trAdd">Добавить</a></li>
              </ul>
            </li>
          </security:authorize>
          <security:authorize access="hasRole('ROLE_USER')">
              <li><a href="${contextPath}/trList">Типы номеров</a></li>
          </security:authorize>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
          <security:authorize access="hasRole('ROLE_ADMIN')">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Комнаты<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="${contextPath}/roomList">Просмотреть</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="${contextPath}/roomAdd">Добавить</a></li>
              </ul>
            </li>
          </security:authorize>
          <security:authorize access="hasRole('ROLE_USER')">
            <li><a href="${contextPath}/roomList">Номера</a></li>
          </security:authorize>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
          <security:authorize access="hasRole('ROLE_ADMIN')">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Брони<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="${contextPath}/reservList">Просмотреть</a></li>
                <li role="separator" class="divider"></li>
              </ul>
            </li>
          </security:authorize>
          <security:authorize access="hasRole('ROLE_USER')">
            <li><a href="${contextPath}/reservList">Брони</a></li>
          </security:authorize>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Статистика<span class="caret"></span></a>
              <ul class="dropdown-menu">
                  <li><a href="${contextPath}/TypeStat">По типам номеров</a></li>
                  <li role="separator" class="divider"></li>
                  <li><a href="${contextPath}/BarChart">По популярности номеров</a></li>
                  <li role="separator" class="divider"></li>
                  <li><a href="${contextPath}/BarChartProfit">По прибыли от номеров</a></li>
                  <li role="separator" class="divider"></li>
              </ul>
            </li>
        </c:if>

      </ul>
      <ul class="nav navbar-nav navbar-right">
          <c:if test="${pageContext.request.userPrincipal.name != null}">
              <security:authorize access="hasRole('ROLE_USER')">
                  <li><a href="${contextPath}/personalAccount">Личный кабинет</a></li>
              </security:authorize>
          </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
          <li><a href="${contextPath}/login">Войти</a></li>
        </c:if>
      </ul>
      <p class="navbar-text navbar-right">
          <c:if test="${pageContext.request.userPrincipal.name != null}">
            ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Выйти</a>
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
          </c:if>
      </p>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<c:if test="${pageContext.request.userPrincipal.name != null}">
  <security:authorize access="hasRole('ROLE_USER')">
      <nav role="navigation" class="navbar navbar-default navbar-fixed-bottom">
        <div class="container-fluid">
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">Забронировать свое проживание!</a>
          </div>
          <!-- Collection of nav links and other content for toggling -->
          <form:form action="reserv" method="get" class="navbar-form navbar-left" role="search">
            <div class="form-group">
               <label> C: </label>
               <input class="form-control" id="dayFrom" name="dayFrom" value="5" type="number" min="1" max="31" required/>
               <select class="form-control" id="monthFrom" name="monthFrom">
                    <option value="05" selected>Май</option>
                    <option value="06">Июнь</option>
                    <option value="07">Июль</option>
                    <option value="08">Август</option>
                    <option value="09">Сентябрь</option>
                    <option value="10">Октябрь</option>
                    <option value="11">Ноябрь</option>
                    <option value="12">Декабрь</option>
                    <option value="01">Январь</option>
                    <option value="02">Февраль</option>
                    <option value="03">Март</option>
                    <option value="04">Апрель</option>
                  </select>
                  <input class="form-control" id="yearFrom" name="yearFrom" value="2016" type="number" min="2016" max="2018" required/>
            </div>

            <div class="form-group">
                  <label> | На:</label>
                  <input class="form-control" id="duration" name="duration" value="1" type="number" min="1" max="60" required/>
                  <label> дней</label>
            </div>

            <div class="form-group">
              <label> | Количество людей:</label>
                  <input class="form-control" id="count" name="count" type="number" value="1" min="1" max="5" required/>
              </div>
              <c:if test="${not empty messageNav}">
                  <div class="form-group">
                      <label class="text-danger">${messageNav}!</label>
                  </div>
              </c:if>
            <button type="submit" class="btn btn-default">Забронировать</button>
          </form:form>
        </div>
      </nav>
    </security:authorize>
  </c:if>