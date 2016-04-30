<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse"> 
  <div class="container-fluid">
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
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
          <li><a href="${contextPath}/login">Авторизация</a></li>
        </c:if>
      </ul> 
      <p class="navbar-text navbar-right">
          <c:if test="${pageContext.request.userPrincipal.name != null}">
            ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
          </c:if>
      </p>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>