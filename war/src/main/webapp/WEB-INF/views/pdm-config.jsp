<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<div class="pdm-frame">
    <div class="col">
        <div class="panel panel-info">
            <div class="panel-heading">
                Настройки доступа и общая информация
            </div>
            <div class="panel-body">
                <table class="table">
                    <tr>
                        <td class="col-md-1">Версия ЗХПД:</td>
                        <td class="col-md-3"><h4><strong><span
                                class="label label-primary sp">${info.version}</span></strong></h4></td>
                    </tr>

                    <tr>
                        <td>Домашняя папка домена:</td>
                        <td><b>${info.domainPath}</b></td>
                    </tr>
                    <tr>
                        <td>Логин администратора:</td>
                        <td><b>${info.login}</b>
                            <!-- Button trigger modal -->
                            <a <%--class="btn btn-default"--%> data-toggle="modal" data-target="#loginUpdate"
                                                               placeholder="редактировать">
                                <b>${info.login}</b>
                                <%-- <span class="glyphicon glyphicon-pencil"></span>--%>
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>Файл конфигурации:</td>
                        <td>${info.cfgFileName}</td>
                    </tr>
                </table>
            </div>
        </div>


        <!-- Modal -->
        <div class="modal fade" id="loginUpdate" tabindex="-1" role="dialog" aria-labelledby="loginUpdateLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                                class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="loginUpdateLabel">Редактирование учетной записи администратора</h4>
                    </div>
                    <div class="modal-body">
                        <form:form method="POST" action="config/user/update" modelAttribute="info" role="form" cssClass="form-horizontal">
                            <div class="form-group">
                                <form:label path="curPassword">Текущий пароль:</form:label>
                                <form:input path="curPassword" cssClass="form-control"/>
                            </div>
                        </form:form>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default" data-dismiss="modal" onClick="$('#info').submit();">Сохранить</button>
                        <button type="reset" class="btn btn-default" data-dismiss="modal">
                            Отмена
                        </button>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>