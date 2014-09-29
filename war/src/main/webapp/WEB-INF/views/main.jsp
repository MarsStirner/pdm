<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="ВТР">
    <meta http-equiv="X-UA-Compatible" content="IE=9" />
    <link href="resources/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="resources/jquery/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="resources/bootstrap/3.1.0/js/bootstrap.min.js"></script>

    <title>ЗХПД</title>
    <meta name="description" content="Защищенное хранилище персональных данных">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}" title="На главную станицу">ЗХПД</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="${pageContext.request.contextPath}/new" title="Новая запись">Создать</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/find" title="Все настройки (из табл. tmis_core.setting)">Редактировать</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <jsp:include page="pdm${state.getJspPath()}.jsp"/>
    </div>
</div>

</body>
</html>
