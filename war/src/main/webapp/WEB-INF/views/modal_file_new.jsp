<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="fileAdd" tabindex="-1" role="dialog" aria-labelledby="fileAddLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="fileAddLabel">Добавить тип файлов</h4>
            </div>
            <div class="modal-body">
                <form:form method="POST" action="files/new" modelAttribute="pdmFiles.newFile"
                           role="form">
                    <div class="form-group">
                        <form:label path="newDescription">Наименование:</form:label>
                        <form:input path="newDescription" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <code>
                            <form:label path="newOid">OID:</form:label>
                            <form:input path="newOid" cssClass="form-control"/>
                        </code>
                    </div>
                    <div class="form-group">
                        <code>
                            <form:label path="newName">Код:</form:label>
                            <form:input path="newName" cssClass="form-control"/>
                        </code>
                    </div>
                </form:form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default" data-dismiss="modal"
                        onClick="$('form[action=files\\/new]').submit();">Сохранить
                </button>
                <button type="reset" class="btn btn-default" data-dismiss="modal">
                    Отмена
                </button>
            </div>
        </div>
    </div>
</div>
