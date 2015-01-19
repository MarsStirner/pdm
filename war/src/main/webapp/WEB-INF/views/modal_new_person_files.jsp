<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="${param.id}" tabindex="-1" role="dialog" aria-labelledby="${param.id}Label"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="${param.id}Label">${param.valueName}</h4>
            </div>
            <div class="modal-body">
                <form role="form">
                    <div class="form-group">
                        <label for="country">Файл:</label>
                        <%--<input type="file" ng-file-select="onFileSelect($files)"/>--%>
                        <input type="file" onchange="angular.element(this).scope().onFileSet(this.files)" data-ng-init = "${param.value}.value = ''; ${param.value}.name = ''"/>
                    </div>
                    <div class="form-group">
                        <label for="name">тип:</label>
                        <select id="name" class="form-control" placeholder="тип документа" data-ng-model="${param.value}.oid">
                            <c:forEach items="${pdmDocs.files}" var="file" varStatus="status">
                                <option value="${file.oid}">${file.description}</option>
                            </c:forEach>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default" data-dismiss="modal"
                        data-ng-click="${param.action}">Сохранить
                </button>
                <button type="reset" class="btn btn-default" data-dismiss="modal">
                    Отмена
                </button>
            </div>
        </div>
    </div>
</div>