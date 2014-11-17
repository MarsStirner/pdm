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
                <h4 class="modal-title" id="${param.id}Label">адрес</h4>
            </div>
            <div class="modal-body">
                <form role="form">
                    <div class="form-group">
                        <label for="description">тип:</label>
                        <input id="description" class="form-control" data-ng-model=" ${param.value}.description"/>
                    </div>
                    <div class="form-group">
                        <label for="country">Страна:</label>
                        <input id="country" class="form-control" data-ng-model=" ${param.value}.country"/>
                    </div>
                    <div class="form-group">
                        <label for="state">Регион:</label>
                        <input id="state" class="form-control" data-ng-model="${param.value}.state"/>
                    </div>
                    <div class="form-group">
                        <label for="county">Район:</label>
                        <input id="county" class="form-control" data-ng-model="${param.value}.county"/>
                    </div>
                    <div class="form-group">
                        <label for="precinct">Населённый пункт:</label>
                        <input id="precinct" class="form-control" data-ng-model="${param.value}.precinct"/>
                    </div>
                    <div class="form-group">
                        <label for="city">Город:</label>
                        <input id="city" class="form-control" data-ng-model="${param.value}.city"/>
                    </div>
                    <div class="form-group">
                        <label for="streetName">Улица:</label>
                        <input id="streetName" class="form-control" data-ng-model="${param.value}.streetName"/>
                    </div>
                    <div class="form-group">
                        <label for="postalCode">Индекс:</label>
                        <input id="postalCode" class="form-control" data-ng-model="${param.value}.postalCode"/>
                    </div>
                    <div class="form-group">
                        <label for="houseNumber">Номер дома:</label>
                        <input id="houseNumber" class="form-control" data-ng-model="${param.value}.houseNumber"/>
                        <label for="buildingNumberSuffix">Корпус:</label>
                        <input id="buildingNumberSuffix" class="form-control" data-ng-model="${param.value}.buildingNumberSuffix"/>
                        <label for="additionalLocator">Квартира:</label>
                        <input id="additionalLocator" class="form-control" data-ng-model="${param.value}.additionalLocator"/>
                    </div>
                    <div class="form-group">
                        <label for="streetAddressLine">Полный адрес:</label>
                        <input id="streetAddressLine" class="form-control" data-ng-model="${param.value}.streetAddressLine"/>
                    </div>
                    <div class="form-group" data-ng-if="${param.isUpdate}" >
                        <label for="updateTypeTelecom">Причина обновления:</label>
                        <select id="updateTypeTelecom" class="form-control" placeholder="тип обновления"
                                data-ng-model="${param.value}.updateTypeAddr"
                                data-ng-options="type.name for type in updateTypes"
                                data-ng-init="${param.value}.updateTypeAddr=updateTypes[0]"></select>
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