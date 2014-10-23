<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="docUpdate${param.index}" tabindex="-1" role="dialog" aria-labelledby="docUpdateLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="docUpdateLabel">Редактировать документ</h4>
            </div>
            <div class="modal-body">
                <form:form method="POST" action="docs/update/${param.index}" modelAttribute="pdmDocs"
                           role="form">
                    <form:input path="docs[${param.index}].name" type="hidden" />
                    <div class="form-group">
                        <strong>
                        <form:label path="docs[${param.index}].newDescription">Наименование:</form:label>
                        <form:input path="docs[${param.index}].newDescription" cssClass="form-control"/>
                        </strong>
                    </div>
                    <div class="form-group">
                        <code>
                        <form:label path="docs[${param.index}].newName">Код:</form:label>
                        <form:input path="docs[${param.index}].newName" cssClass="form-control"/>
                        </code>
                    </div>
                </form:form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default" data-dismiss="modal"
                        onClick="$('form[action=docs\\/update\\/${param.index}]').submit();">Сохранить
                </button>
                <button type="reset" class="btn btn-default" data-dismiss="modal">
                    Отмена
                </button>
            </div>
        </div>
    </div>
</div>
