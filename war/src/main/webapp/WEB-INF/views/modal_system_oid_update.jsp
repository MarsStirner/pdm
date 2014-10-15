<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="systemUpdate${param.index}" tabindex="-1" role="dialog" aria-labelledby="systemUpdateLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="systemUpdateLabel">Редактирование параметров подсистемы</h4>
            </div>
            <div class="modal-body">
                <form:form method="POST" action="system/update" modelAttribute="pdmSystems.systems[${param.index}]"
                           role="form">
                    <div class="form-group">
                        <form:label path="curPassword">Текущий пароль:</form:label>
                        <form:password path="curPassword" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <form:label path="newName">Новое наименование:</form:label>
                        <form:input path="newName" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <form:label path="newOid">Новый OID:</form:label>
                        <form:input path="newOid" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <form:label path="newPassword">Новый пароль:</form:label>
                        <form:password path="newPassword" cssClass="form-control"/>
                    </div>
                </form:form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default" data-dismiss="modal"
                        onClick="$('#pdmSystems\\.systems\\[${param.index}\\]').submit();">Сохранить
                </button>
                <button type="reset" class="btn btn-default" data-dismiss="modal">
                    Отмена
                </button>
            </div>
        </div>
    </div>
</div>
