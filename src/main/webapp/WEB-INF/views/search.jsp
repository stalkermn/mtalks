<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Поиск с использованием AJAX</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="/resources/style.css" media="screen" />
        <script src="/resources/jquery.min.js"></script>
        <script type="text/javascript">
            var url = "";
            $(function(){
                url = "search/login/";
                $("input:checkbox").change(function() {
                    if($(this).is(":checked")) {
                        url = "search/telephone/";
                    } else {
                        url = "search/login/";
                    }
                });
            });

            $(function() {
                $("#search").keyup(function(){
                    var search = $("#search").val();
                    $.ajax({
                        type: "GET",
                        url: url + search,

                        cache: false,
                        success: function(response){
                            console.log(response);
                            $("#result").html(response);
                        }
                    });

                    return false;
                });
            });

        </script>
    </head>
    <body>
        <a href="<c:url value="/" />">
        <spring:message code="label.addcontact" />
         </a>
        <div class="notice_password"><a href="<c:url value="/logout"/>" > Выход</a></div>
        <h1>Поиск пользователя</h1>
        <div id="form-search">
            <form action="/add" method="post" name="form" onsubmit="return false;">

                <p><input name="search" type="text" id="search"><input type="checkbox" name="type"/></p>
                <h2>Поиск пользователя по логину (по умолчанию) . Поиск пользователя по телефону (нажать чекбокс)</h2>
            </form>
        </div>
        <h2>Результат поиска</h2>
        <div id="result">Введите запрос</div>

    </body>
</html>
