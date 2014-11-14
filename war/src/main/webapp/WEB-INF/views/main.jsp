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
    <meta http-equiv="X-UA-Compatible" content="IE=9"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.min.css" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/angular/angular.min.js"></script>

    <title>ЗХПД</title>
    <meta name="description" content="Защищенное хранилище персональных данных">
</head>
<body>
<header>
    <nav>
        <ul class="pdm-navlist">
            <li><a href="${pageContext.request.contextPath}/config">Настройки</a></li>
            <li><a href="${pageContext.request.contextPath}/systems">Подсистемы</a></li>
            <li><a href="${pageContext.request.contextPath}/docs">Документы</a></li>
            <li><a href="${pageContext.request.contextPath}/files">Файлы</a></li>
            <li>
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">ЗХПД<b class="caret"></b></a>
                <ul class="dropdown-menu global_nav">
                    <li>
                        <a href="${pageContext.request.contextPath}/create">Новая запись</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/persons">Просмотр</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/find">Поиск</a>
                    </li>
                </ul>
            </li>
        </ul>
    </nav>
    <div class="pdm-title">
        <h2 class="${state.isShowTitle() ? "" : "hide"}">
            ${state.getTitle()}
        </h2>
    </div>
</header>
<div class="pdm-main">
        <jsp:include page="pdm${state.getJspPath()}.jsp"/>
</div>

<jsp:include page="import_js.jsp"/>

</body>
</html>
