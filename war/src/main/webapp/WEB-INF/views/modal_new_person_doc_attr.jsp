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
                        <label for="name" data-ng-init="clearAttrOption()">атрибут:</label>
                        <c:forEach items="${pdmDocs.docs}" var="doc" varStatus="status">
                            <c:forEach items="${doc.attrs}" var="attr" varStatus="statusAttr">
                                <input type="hidden" data-ng-init="addAttrOption('${attr.oid}','${attr.description}')" data-ng-if="${param.docName} == '${doc.name}'"/>
                            </c:forEach>
                        </c:forEach>
                        <select id="name" class="form-control" placeholder="тип атрибута"
                                data-ng-model="${param.value}" data-ng-options="attr.description for attr in ${param.attrList}"/>
                    </div>
                    <div class="form-group">
                        <label for="value">занчение:</label>
                        <input id="value" class="form-control" data-ng-model="${param.value}.value"/>
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