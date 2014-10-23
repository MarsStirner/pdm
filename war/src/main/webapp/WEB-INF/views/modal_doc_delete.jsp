<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="docDelete${param.index}" tabindex="-1" role="dialog" aria-labelledby="docDeleteLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title text-danger" id="docDeleteLabel"><strong>Удаление документа</strong></h4>
            </div>
            <div class="modal-body">
                <h4 class="text-danger">Удалить документ '${param.description}'?</h4>
            </div>
            <div class="modal-footer">
                <a type="submit" class="btn btn-danger" data-dismiss="modal"
                        onClick="location.href = 'docs/delete/${param.name}'">Удалить
                </a>
                <a type="reset" class="btn btn-danger" data-dismiss="modal">
                    Отмена
                </a>
            </div>
        </div>
    </div>
</div>
