<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="systemDelete${param.index}" tabindex="-1" role="dialog" aria-labelledby="systemUpdateLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title text-danger" id="systemUpdateLabel"><strong>Удаление подсистемы</strong></h4>
            </div>
            <div class="modal-body">
                <form:form method="POST" action="systems/delete/${param.index}" modelAttribute="pdmSystems"
                           role="form">
                    <form:input path="systems[${param.index}].oid" type="hidden" />
                    <div class="form-group">
                        <form:label path="systems[${param.index}].curPassword" cssClass="text-danger">Пароль подсистемы '${param.name}':</form:label>
                        <form:password path="systems[${param.index}].curPassword" cssClass="form-control"/>
                    </div>
                </form:form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-danger" data-dismiss="modal"
                        onClick="$('form[action=systems\\/delete\\/${param.index}]').submit();">Удалить
                </button>
                <button type="reset" class="btn btn-danger" data-dismiss="modal">
                    Отмена
                </button>
            </div>
        </div>
    </div>
</div>
