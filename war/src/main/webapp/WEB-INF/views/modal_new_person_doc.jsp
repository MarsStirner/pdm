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
                        <label for="name">тип:</label>
                        <select id="name" class="form-control" placeholder="пол" data-ng-model="${param.value}.name">
                            <c:forEach items="${pdmDocs.docs}" var="doc" varStatus="status">
                                <option value=${doc.name}>${doc.description}</option>
                            </c:forEach>
                        </select>

                        <div ng-switch on="${param.value}.name">
                            <c:forEach items="${pdmDocs.docs}" var="doc" varStatus="status">
                                <div ng-switch-when="${doc.name}">
                                    <input type="hidden"
                                           data-ng-init="${param.value}.description = '${doc.description}'"/>
                                    <input type="hidden"
                                           data-ng-init="${param.value}.attrs = []"/>
                                    <c:forEach items="${doc.attrs}" var="attr" varStatus="statusAttr">
                                        <input type="hidden"
                                               data-ng-init="${param.value}.attrs.push({description:'${attr.description}', value: null})"/>
                                    </c:forEach>
                                </div>
                            </c:forEach>
                        </div>
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