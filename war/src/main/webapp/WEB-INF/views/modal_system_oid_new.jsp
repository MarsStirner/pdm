<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="systemAdd" tabindex="-1" role="dialog" aria-labelledby="systemAddLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="systemAddLabel">Добавить подсистему</h4>
            </div>
            <div class="modal-body">
                <form:form method="POST" action="system/new" modelAttribute="pdmSystems.newSystem"
                           role="form">
                    <div class="form-group">
                        <form:label path="newName">Наименование:</form:label>
                        <form:input path="newName" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <form:label path="newOid">OID:</form:label>
                        <form:input path="newOid" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <form:label path="newPassword">Пароль:</form:label>
                        <form:password path="newPassword" cssClass="form-control"/>
                    </div>
                </form:form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default" data-dismiss="modal"
                        onClick="$('#pdmSystems\\.newSystem').submit();">Сохранить
                </button>
                <button type="reset" class="btn btn-default" data-dismiss="modal">
                    Отмена
                </button>
            </div>
        </div>
    </div>
</div>
