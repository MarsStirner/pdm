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
                        <label for="description">тип:</label>
                        <select id="description" class="form-control" data-ng-model=" ${param.value}.description">
                            <option value="HP">Телефон домашний</option>
                            <option value="MC">Телефон мобильный</option>
                            <option value="WP">Телефон рабочий</option>
                            <option value="e-mail">e-mail</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="value">${param.valueName}:</label>
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