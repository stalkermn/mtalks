<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Rocksearch | Главная</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="resources/css/styles.css" rel="stylesheet">
    <link href="resources/css/tipTip.css" rel="stylesheet">
    <link href="resources/css/bootstrap.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="resources/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="assets/ico/favicon.png">
    -->

  </head>

  <body>

  <header>
      <div class="inner">
          <a href="/"><img src="resources/img/logo.png" alt="RockSearch" id="logo"></a>
          <div class="login">
              <div class="inner">
              <c:if test="${empty error}">

                <sec:authorize access="isAuthenticated()">
                      <div class="notice_login">Зарегистрирован как <sec:authentication property="principal.username" /> </div>
                      <div class="notice_password"><a href="<c:url value="/logout"/>"> Выход</a></div>
                  </sec:authorize>
                  <sec:authorize access="!isAuthenticated()">
                  <form action="<spring:url value="/j_spring_security_check" />" method="POST">
                    <div class="notice_login">Логин или Email</div>
                    <div class="notice_password">Пароль</div>
                    <input type="text" name="j_username">
                    <input type="password" name="j_password">
                    <input type="submit" value="Войти">
                    <div class="rememberme"><input type="checkbox" name="_spring_security_remember_me" value="false" id="rm"><label for="rm">Запомнить меня</label></div>
                    <!--TOD/O: addPage for functional for PasswordRecover -->
                    <div class="remindpass"><a href="#">Забыли пароль?</a></div>
                  </form>
                  </sec:authorize>
              </c:if>
              </div>
          </div>
      </div>
  </header>
  <div class="content">
      <div class="inner">
        <div class="left">
            <h1>Найдите себя в мире музыки вместе с RockSearch.</h1>
            <div class="inline one">
                <span>Новостная лента&nbsp;&nbsp;</span>
                Узнавайте первыми и делитесь информацией о себе и своей группе.
            </div>
            <div class="inline two">
                <span>События&nbsp;&nbsp;</span>
                Будьте в курсе всех музыкальных событий вашего города.
            </div>
            <div class="inline three">
                <span>Поиск&nbsp;&nbsp;</span>
                Находите музыкантов в вашем городе.
            </div>
            <div class="inline four">
                <span>Сообщения&nbsp;&nbsp;</span>
                Обменивайтесь приватными сообщениями с важными для вас людьми.
            </div>
        </div>
        <div class="right">
            <form:form method="post" commandName="user" action="registration">
                <h1>Регистрация</h1>
                <input type="text" placeholder="Имя" name="firstname" id="mini" style="margin-right:10px;">
                <input type="text" placeholder="Фамилия" name="lastname" id="mini">
                <input type="text" placeholder="Логин" name="login">
                <input type="text" placeholder="Ваш Email" name="email">
                <input type="password" placeholder="Ваш пароль" name="password">
                <span>Регистрируясь вы соглашаетесь с правилами использования сервиса и политикой использования личных данных.</span>
                <input type="submit" value="Регистрация" class="btn btn-success"/>
            </form:form>
        </div>
      </div>
  </div>
  <footer>
      <div class="inner">
            <ul class="lang">
                <li><a href="#">Русский</a></li>
                <li><a href="#">English</a></li>
            </ul>
            RockSearch © 2013
      </div>
  </footer>



  <script src="resources/js/jquery.js"></script>
  <script src="resources/js/jquery.tipTip.min.js"></script>
  <script src="resources/js/valid.js"></script>
  <!--[if IE]>
  <script src="resources/js/forie.js"></script>
  <![endif]-->
  </body>
</html>
<%--<h1>Регистрация</h1>--%>
<%--<input type="text" placeholder="Имя" name="name"pattern="" id="mini" style="margin-right:10px;">--%>
<%--<input type="text" placeholder="Фамилия" name="surname" id="mini">--%>
<%--<input type="text" placeholder="Логин" name="login">--%>
<%--<input type="text" placeholder="Ваш Email" name="email">--%>
<%--<input type="password" placeholder="Ваш пароль" name="email">--%>
<%--<h4>Дата рождения:</h4>--%>
<%--<select>--%>
<%--<option>День:</option>--%>
<%--</select>--%>
<%--<select>--%>
<%--<option>Месяц:</option>--%>
<%--</select>--%>
<%--<select style="margin-right:0px">--%>
<%--<option>Год:</option>--%>
<%--</select>--%>
<%--<div class="check-label">--%>
<%--<input type="checkbox" name="sex" value="1" id="sex_1"><label for="sex_1">Мужчина</label>--%>
<%--</div>--%>
<%--<div class="check-label">--%>
<%--<input type="checkbox" name="sex" value="2" id="sex_2"><label for="sex_2">Женщина</label>--%>
<%--</div>--%>
<%--<span>Регистрируясь вы соглашаетесь с правилами использования сервиса и политикой использования личных данных.</span>--%>
