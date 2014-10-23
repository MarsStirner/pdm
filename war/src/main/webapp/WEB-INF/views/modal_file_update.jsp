<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="fileUpdate${param.index}" tabindex="-1" role="dialog" aria-labelledby="fileUpdateLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="fileUpdateLabel">Редактирование параметров файлов</h4>
            </div>
            <div class="modal-body">
                <form:form method="POST" action="files/update/${param.index}" modelAttribute="pdmFiles"
                           role="form">
                    <form:input path="files[${param.index}].oid" type="hidden" />
                    <div class="form-group">
                        <form:label path="files[${param.index}].newDescription">Наименование:</form:label>
                        <form:input path="files[${param.index}].newDescription" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <form:label path="files[${param.index}].newOid">OID:</form:label>
                        <form:input path="files[${param.index}].newOid" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <form:label path="files[${param.index}].newName">Код:</form:label>
                        <form:input path="files[${param.index}].newName" cssClass="form-control"/>
                    </div>
                </form:form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default" data-dismiss="modal"
                        onClick="$('form[action=files\\/update\\/${param.index}]').submit();">Сохранить
                </button>
                <button type="reset" class="btn btn-default" data-dismiss="modal">
                    Отмена
                </button>
            </div>
        </div>
    </div>
</div>
