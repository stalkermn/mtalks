<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>mTalks | Главная</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="resources/css/userstyles.css" rel="stylesheet">
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
     <img src="resources/img/logo.png" alt="mTalks" class="logo">
     <ul class="menu">
      <li><a href="#">Поиск</a></li>
      <li><a href="#">Сообщения</a></li>
      <li><a href="#">Моя группа</a></li>
      <li><a href="#">Музыка</a></li>
      <li><a href="#">Настройки</a></li>
      <li><a href="#">Выход</a></li>
     </ul>
   </div>
  </header>

  <div class="content">
    <div class="inner">

      <div class="menu">
        <ul>
          <a href="#"><li class="active">Главная</li></a>
          <a href="#"><li>Друзья</li></a>
          <a href="#"><li>Группа</li></a>
          <a href="#"><li>Музыка</li></a>
          <a href="#"><li>Фотографии</li></a>
          <a href="#"><li>Настройки</li></a>
          <a href="/logout"><li id="lastchild">Выход</li></a>
        </ul>
      </div>

      <div class="data">

        <div class="status_bar">
            <span class="name">${user.firstname}  ${user.lastname}</span>
            <span class="status">Online</span>
        </div>

        <div class="left">
          <div class="avatar">
            <img src="resources/img/a_1fe828a3.jpg" >
          </div>
          <div class="widget_block">
          </div>
        </div>

        <div class="right">

          <div class="desc">

            <div class="social_inf">
              <span class="name">${user.firstname}  ${user.lastname}</span>
              <span class="status">Логотип вижуалстудии отображает актуальное время компиляции больших проектов</span>
            </div>

            <div class="social_data">
              <div class="list">
                <div class="soc_list">
                  <div class="soc_label">День рождения:</div><div class="soc_data">${user.birthday}</div>
                </div>
                <div class="soc_list">
                  <div class="soc_label">Родной город:</div><div class="soc_data">${user.contact.adress}</div>
                </div>
                <div class="soc_list">
                  <div class="soc_label">Группа:</div><div class="soc_data">В активном поиске</div>
                </div>
                <div class="soc_list">
                  <div class="soc_label">Инструмент:</div><div class="soc_data">Cort CR210</div>
                </div>
                <div class="soc_list">
                  <div class="soc_label">Возраст:</div><div class="soc_data">лет</div>
                </div>
              </div>
            </div>

          </div>

          <div class="wall">
            <div class="widget_block">
              <div class="widget_head">
                <span>666 записей</span>
              </div>
              <div class="widget_content">
                <textarea type="text" placeholder="Что нового?"></textarea>
              </div>
            </div>
          </div>

        </div>

      </div>

    </div>
  </div>


  <script src="resources/js/jquery.js"></script>
  <!--[if IE]>
  <script src="resources/js/forie.js"></script>
  <![endif]-->
  </body>
</html>

