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
                Список документов
            </div>
            <div class="panel-body">
                <table class="table">
                    <thead>
                    <th>
                        Код
                    </th>
                    <th>
                        Описание
                    </th>
                    <th>
                        Код атрибута
                    </th>
                    <th>
                        Описание атрибута
                    </th>
                    <th></th>
                    </thead>
                    <tbody>
                    <c:forEach items="${pdmDocs.systems}" var="doc" varStatus="status">
                        <tr>
                            <td rowspan="${doc.attr.size()}">
                                    ${doc.name}
                            </td>
                            <td rowspan="${doc.attr.size()}">
                                    ${doc.description}
                            </td>
                            <td></td>
                            <td></td>
                            <td rowspan="${doc.attr.size()}">
                                <jsp:include page="alert.jsp">
                                    <jsp:param name="msg" value="${system.msg}"/>
                                    <jsp:param name="alertType" value="${system.getAlertName()}"/>
                                </jsp:include>
                                    ${system.oid}
                                <a class="btn btn-default pull-right" data-toggle="modal"
                                   data-target="#docDelete${status.index}"
                                   placeholder="удалить">
                                    <span class="glyphicon glyphicon-remove"></span>
                                </a>
                                <a class="btn btn-default pull-right" data-toggle="modal"
                                   data-target="#docUpdate${status.index}"
                                   placeholder="редактировать">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>
                                    <%--<jsp:include page="modal_system_doc_update.jsp">
                                        <jsp:param name="index" value="${status.index}"/>
                                        <jsp:param name="oid" value="${system.oid}"/>
                                    </jsp:include>
                                    <jsp:include page="modal_system_dco_delete.jsp">
                                        <jsp:param name="index" value="${status.index}"/>
                                        <jsp:param name="oid" value="${system.oid}"/>
                                        <jsp:param name="name" value="${system.name}"/>
                                    </jsp:include>--%>
                            </td>
                        </tr>
                        <c:forEach items="${doc.attrs}" var="attr" varStatus="status">
                            <tr>
                                <td>
                                        ${attr.name}
                                </td>
                                <td>
                                        ${doc.description}
                                </td>
                            </tr>
                            < </c:forEach>
                    </c:forEach>
                    <tr>
                        <td>
                            <jsp:include page="alert.jsp">
                                <jsp:param name="msg" value="${msgNewDocs.msg}"/>
                                <jsp:param name="alertType" value="${msgNewDocs.getAlertName()}"/>
                            </jsp:include>
                            <a class="btn btn-default" data-toggle="modal" data-target="#systemAdd"
                               placeholder="добавить">
                                Добавить
                            </a>
                            <%--<jsp:include page="modal_system_oid_new.jsp">
                                <jsp:param name="index" value="0"/>
                            </jsp:include>--%>
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