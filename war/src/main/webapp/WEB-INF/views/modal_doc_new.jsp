<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="docAdd" tabindex="-1" role="dialog" aria-labelledby="docAddLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="docAddLabel">Добавить документ</h4>
            </div>
            <div class="modal-body">
                <form:form method="POST" action="docs/new" modelAttribute="pdmDocs.newDoc"
                           role="form">
                    <div class="form-group">
                        <strong>
                        <form:label path="description">Наименование:</form:label>
                        <form:input path="description" cssClass="form-control"/>
                        </strong>
                    </div>
                    <div class="form-group">
                        <code>
                        <form:label path="name">Код:</form:label>
                        <form:input path="name" cssClass="form-control"/>
                        </code>
                    </div>
                </form:form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default" data-dismiss="modal"
                        onClick="$('form[action=docs\\/new]').submit();">Сохранить
                </button>
                <button type="reset" class="btn btn-default" data-dismiss="modal">
                    Отмена
                </button>
            </div>
        </div>
    </div>
</div>
