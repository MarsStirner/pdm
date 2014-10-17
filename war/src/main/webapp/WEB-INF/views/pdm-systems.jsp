<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<div class="pdm-frame">
    <div class="col">
        <div class="panel panel-info">
            <div class="panel-heading">
                Список подсистем
            </div>
            <div class="panel-body">
                <table class="table">
                    <thead>
                    <th>
                        Наименование
                    </th>
                    <th>
                        OID
                    </th>
                    </thead>
                    <tbody>
                    <c:forEach items="${pdmSystems.systems}" var="system" varStatus="status">
                        <tr>
                            <td>
                                    ${system.name}
                            </td>
                            <td>
                                <jsp:include page="alert.jsp">
                                    <jsp:param name="msg" value="${system.msg}"/>
                                    <jsp:param name="alertType" value="${system.getAlertName()}"/>
                                </jsp:include>
                                    ${system.oid}
                                <a class="btn btn-default pull-right" data-toggle="modal" data-target="#systemDelete${status.index}"
                                   placeholder="удалить">
                                    <span class="glyphicon glyphicon-remove"></span>
                                </a>
                                <a class="btn btn-default pull-right" data-toggle="modal" data-target="#systemUpdate${status.index}"
                                   placeholder="редактировать">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>
                                <jsp:include page="modal_system_oid_update.jsp">
                                    <jsp:param name="index" value="${status.index}"/>
                                    <jsp:param name="oid" value="${system.oid}"/>
                                </jsp:include>
                                <jsp:include page="modal_system_oid_delete.jsp">
                                    <jsp:param name="index" value="${status.index}"/>
                                    <jsp:param name="oid" value="${system.oid}"/>
                                </jsp:include>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td>
                            <jsp:include page="alert.jsp">
                                <jsp:param name="msg" value="${system.msg}"/>
                                <jsp:param name="alertType" value="${system.getAlertName()}"/>
                            </jsp:include>
                            <a class="btn btn-default" data-toggle="modal" data-target="#systemAdd"
                               placeholder="добавить">
                                Добавить
                                <%--<span class="glyphicon glyphicon-plus">--%></span>
                            </a>
                            <jsp:include page="modal_system_oid_new.jsp">
                                <jsp:param name="index" value="0"/>
                            </jsp:include>
                        </td>
                        <td>

                        </td>
                    </tr>

                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>