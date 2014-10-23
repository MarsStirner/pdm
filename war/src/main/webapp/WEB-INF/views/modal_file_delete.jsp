<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="fileDelete${param.index}" tabindex="-1" role="dialog" aria-labelledby="fileUpdateLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title text-danger" id="fileUpdateLabel"><strong>Удаление типа файлов</strong></h4>
            </div>
            <div class="modal-body">
                <h4 class="text-danger">Удалить тип файлов '${param.description}'?</h4>
                <form:form method="POST" action="files/delete/${param.index}" modelAttribute="pdmFiles"
                           role="form">
                    <form:input path="files[${param.index}].oid" type="hidden" />
                </form:form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-danger" data-dismiss="modal"
                        onClick="$('form[action=files\\/delete\\/${param.index}]').submit();">Удалить
                </button>
                <button type="reset" class="btn btn-danger" data-dismiss="modal">
                    Отмена
                </button>
            </div>
        </div>
    </div>
</div>
