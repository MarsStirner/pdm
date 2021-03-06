<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="ВТР">
    <meta http-equiv="X-UA-Compatible" content="IE=9"/>
    <link rel="stylesheet" href="resources/css/style.min.css" />

    <title>ЗХПД</title>
    <meta name="description" content="Защищенное хранилище персональных данных">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-info" style="margin-top: 25%;">
                <div class="panel-heading">
                    <h3 class="panel-title">ЗХПД</h3>
                </div>
                <div class="panel-body">
                    <c:if test="${errorMsg != null}">
                        <div class="alert alert-danger">
                            <a class="close" data-dismiss="alert" href="#">×</a>${errorMsg}
                        </div>
                    </c:if>
                    <form:form method="POST" modelAttribute="user">
                        <fieldset>
                            <div class="form-group">
                                <form:input cssClass="form-control" path="login" placeholder="логин"/>
                            </div>
                            <div class="form-group">
                                <form:password class="form-control" path="password" placeholder="пароль"/>
                            </div>
                            <button type="submit" class="btn btn-lg btn-default btn-block">Войти</button>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="import_js.jsp"/>

</body>
</html>
