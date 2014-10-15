<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="cfgFileUpdate" tabindex="-1" role="dialog" aria-labelledby="cfgFileUpdateLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="cfgFileUpdateLabel">Файл конфигурации</h4>
            </div>
            <div class="modal-body">
                <form:form method="POST" action="config/path/update" modelAttribute="cfgFileUpdateInfo"
                           role="form">
                    <div class="form-group">
                        <form:label path="cfgFilePath">Новый путь к файлу конфигурации:</form:label>
                        <form:input path="cfgFilePath" cssClass="form-control"/>
                    </div>
                </form:form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default" data-dismiss="modal"
                        onClick="$('#cfgFileUpdateInfo').submit();">Сохранить
                </button>
                <button type="reset" class="btn btn-default" data-dismiss="modal">
                    Отмена
                </button>
            </div>
        </div>
    </div>
</div>
