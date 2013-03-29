<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>mTalks</title>
</head>
<body>
<div class="login">
    <div class="inner">
        <c:if test="${empty error}">
                <form action="<spring:url value="/j_spring_security_check" />" method="POST">
                    <div class="notice_login">Логин или Email</div>
                    <div class="notice_password">Пароль</div>
                    <input type="text" name="j_username">
                    <input type="password" name="j_password">
                    <input type="submit" value="Войти">
                    <div class="rememberme"><input type="checkbox" name="_spring_security_remember_me" value="1" id="rm"><label for="rm">Запомнить меня</label></div>
                    <div class="remindpass"><a href="#">Забыли пароль?</a></div>
                </form>
        </c:if>
        <c:if test="${not empty error}">
            <form action="<spring:url value="/j_spring_security_check" />" method="POST">
                <div class="notice_login">Логин или Email</div>
                <div class="notice_password">Пароль</div>
                <input type="text" name="j_username">
                <input type="password" name="j_password">
                <input type="submit" value="Войти">
                <div class="rememberme"><input type="checkbox" name="_spring_security_remember_me" value="1" id="rm"><label for="rm">Запомнить меня</label></div>
                <div class="remindpass"><a href="#">Забыли пароль?</a></div>
            </form>
            <c:if test="${not empty captcha}">
                <div style="color : #8b0000">Captcha activated</div>
            </c:if>
        </c:if>
    </div>
</div>
</body>
</html>