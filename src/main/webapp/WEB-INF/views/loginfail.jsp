<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>mTalks | Вход</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="resources/css/styles.css" rel="stylesheet">
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
          <img src="resources/img/logo.png" alt="mTalks" id="logo">
          <div class="login">
              <div class="inner">
                  <form action="<spring:url value="/j_spring_security_check" />" method="POST">
                      <div class="notice_login">Логин или Email</div>
                      <div class="notice_password">Пароль</div>
                      <input type="text" name="j_username">
                      <input type="password" name="j_password">
                      <input type="submit" value="Войти">
                      <div class="rememberme"><input type="checkbox" name="_spring_security_remember_me" value="1" id="rm"><label for="rm">Запомнить меня</label></div>
                      <!--T//ODO: addPage for functional for PasswordRecover -->
                      <div class="remindpass"><a href="#">Забыли пароль?</a></div>
                  </form>
              </div>
          </div>
      </div>
  </header>
  <div class="content">
      <div class="inner">
        <div class="center">

          <div class="login-form">

              <form action="<spring:url value="/j_spring_security_check" />" method="POST">
                  <h1>Вход</h1>
                  <input type="text" placeholder="Логин или Email" name="j_username" id="mini" style="margin-right:10px;"><br>
                  <input type="password" placeholder="Ваш пароль" name="j_password"><br>
                  <div class="rememberme"><input type="checkbox" name="_spring_security_remember_me" value="1" id="rme"><label for="rme">Запомнить меня</label></div>
                  <input type="submit" value="Войти" class="btn btn-success">
                  <a href="#">Забыли пароль?</a>
              </form>


          </div>


        <c:if test="${not empty error}">
          <div class="login-notify alert alert-error">
            <div class="inner">
              Неправильный логин или пароль!
            </div>
          </div>
        </c:if>

        <c:if test="${empty error}">
          <div class="login-notify alert alert-info">
            <div class="inner">
              Авторизация позволит вам использовать весь функционал ресурса.
            </div>
          </div>
        </c:if>

        </div>
      </div>
  </div>
  <footer>
      <div class="inner">
            <ul class="lang">
                <li><a href="#">Русский</a></li>
                <li><a href="#">English</a></li>
            </ul>
            mTalks © 2013
      </div>
  </footer>



  <script src="resources/js/jquery.js"></script>
  <!--[if IE]>
  <script src="resources/js/forie.js"></script>
  <![endif]-->
  </body>
</html>
