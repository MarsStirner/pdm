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
                Список файлов
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
                    <th>
                        Код
                    </th>
                    </thead>
                    <tbody>
                    <c:forEach items="${pdmFiles.files}" var="file" varStatus="status">
                        <tr>
                            <td>
                                    ${file.description}
                            </td>
                            <td>
                                    ${file.oid}
                            </td>
                            <td>
                                <jsp:include page="alert.jsp">
                                    <jsp:param name="msg" value="${file.msg}"/>
                                    <jsp:param name="alertType" value="${file.getAlertName()}"/>
                                </jsp:include>
                                    ${file.name}
                                <a class="btn btn-default pull-right" data-toggle="modal"
                                   data-target="#fileDelete${status.index}"
                                   placeholder="удалить">
                                    <span class="glyphicon glyphicon-remove"></span>
                                </a>
                                <a class="btn btn-default pull-right" data-toggle="modal"
                                   data-target="#fileUpdate${status.index}"
                                   placeholder="редактировать">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>
                                <jsp:include page="modal_file_update.jsp">
                                    <jsp:param name="index" value="${status.index}"/>
                                    <jsp:param name="oid" value="${file.oid}"/>
                                </jsp:include>
                                <jsp:include page="modal_file_delete.jsp">
                                    <jsp:param name="index" value="${status.index}"/>
                                    <jsp:param name="description" value="${file.description}"/>
                                </jsp:include>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
                <jsp:include page="alert.jsp">
                    <jsp:param name="msg" value="${msgNewFile.msg}"/>
                    <jsp:param name="alertType" value="${msgNewFile.getAlertName()}"/>
                </jsp:include>
                <a class="btn btn-default" data-toggle="modal" data-target="#fileAdd"
                   placeholder="добавить">
                    Добавить
                </a>
                <jsp:include page="modal_file_new.jsp">
                    <jsp:param name="index" value="0"/>
                </jsp:include>
            </div>
        </div>

    </div>
</div>