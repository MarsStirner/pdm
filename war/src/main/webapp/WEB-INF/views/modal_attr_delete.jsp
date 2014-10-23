<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="attrDelete${param.docName}_${param.index}" tabindex="-1" role="dialog" aria-labelledby="attrDeleteLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title text-danger" id="attrDeleteLabel"><strong>Удаление атрибута</strong></h4>
            </div>
            <div class="modal-body">
                <h4 class="text-danger">Удалить атрибут '${param.description}'?</h4>
            </div>
            <div class="modal-footer">
                <a type="submit" class="btn btn-danger" data-dismiss="modal"
                        onClick="location.href = 'docs/${param.docName}/delete/attr/${param.index}'">Удалить
                </a>
                <a type="reset" class="btn btn-danger" data-dismiss="modal">
                    Отмена
                </a>
            </div>
        </div>
    </div>
</div>
