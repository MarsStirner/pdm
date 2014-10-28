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
                                class="label label-primary">${info.version}</span></strong></h4></td>
                    </tr>

                    <tr>
                        <td>Домашняя папка домена:</td>
                        <td><b>${info.domainPath}</b></td>
                    </tr>
                    <tr>
                        <td>Логин администратора:</td>
                        <td>
                            <jsp:include page="alert.jsp">
                                <jsp:param name="msg" value="${updateLoginInfo.msg}"/>
                                <jsp:param name="alertType" value="${updateLoginInfo.getAlertName()}"/>
                            </jsp:include>
                            <b>${info.login}</b>
                            <!-- Button trigger modal -->
                            <a class="btn btn-default pull-right" data-toggle="modal" data-target="#loginUpdate"
                               placeholder="редактировать">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a>

                            <p/>
                        </td>
                    </tr>
                    <tr>
                        <td>Файл конфигурации:</td>
                        <td>
                            <jsp:include page="alert.jsp">
                                <jsp:param name="msg" value="${cfgFileUpdateInfo.msg}"/>
                                <jsp:param name="alertType" value="${cfgFileUpdateInfo.getAlertName()}"/>
                            </jsp:include>
                            <b>${info.cfgFileName}</b>
                            <a class="btn btn-default pull-right" data-toggle="modal" data-target="#cfgFileUpdate"
                               placeholder="редактировать">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a>
                            <p/>

                        </td>
                    </tr>
                </table>
            </div>
        </div>

        <jsp:include page="modal_admin_login_param.jsp"/>
        <jsp:include page="modal_cfg_file_path.jsp"/>

    </div>
</div>