<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<div class="pdm-frame" ng-app="" ng-controller="createController">
    <div class="col">
        <div class="panel panel-info">
            <div class="panel-heading">
                Персональные данные
            </div>
            <div class="panel-body">
                <form role="form">
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary" placeholder="добавить" data-ng-click="create()">Добавить</button>
                        публичный ключ: <span class="label label-info">{{createRes.id}}</span>
                        <button type="reset" class="btn btn-default pull-right" placeholder="отмена">Отмена</button>
                    </div>
                    <fieldset class="form-group">
                        <legend></legend>
                        <div class="col-xs-2">
                            <label for="oid">OID подсистемы:</label>
                            <input type="text" id="oid" class="form-control" placeholder="OID подсистемы" data-ng-model="systemLogin.oid"/>
                        </div>
                        <div class="col-xs-5">
                            <label for="password">Пароль подсистемы:</label>
                            <input type="password" id="password" class="form-control" placeholder="пароль подсистемы" data-ng-model="systemLogin.password"/>
                        </div>
                        <div class="col-xs-5">
                            <button type="submit" class="btn btn-primary  pull-right" placeholder="авторизация подсистемы" data-ng-click="login()">Авторизация</button>
                            token:<span class="label label-info">{{newPerson.token}}</span>
                        </div>
                    </fieldset>

                    <fieldset class="form-group">
                        <legend></legend>
                        <div class="col-xs-2">
                            <label for="family">Фамилия:</label>
                            <input type="text" id="family" class="form-control" placeholder="Фамилия" data-ng-model="newPerson.family"/>
                        </div>
                        <div class="col-xs-2">
                            <label for="given">Имя:</label>
                            <input type="text" id="given" class="form-control" placeholder="Имя" data-ng-model="newPerson.given"/>
                        </div>
                        <div class="col-xs-2">
                            <label for="middleName">Отчество:</label>
                            <input type="text" id="middleName" class="form-control" placeholder="Отчество" data-ng-model="newPerson.middleName"/>
                        </div>
                        <div class="col-xs-1">
                            <label for="sex">Пол:</label>
                            <select id="sex" class="form-control" placeholder="пол" data-ng-model="newPerson.gender.value">
                                <option value="UN"></option>
                                <option value="M">М</option>
                                <option value="F">Ж</option>
                            </select>
                        </div>
                        <div class="col-xs-2">
                            <label for="birthDate">Дата рождения:</label>
                            <input type="date" id="birthDate" class="form-control"
                                   placeholder="дата рождения" data-ng-model="newPerson.birthInfo.birthDate"/>
                        </div>
                        <div class="col-xs-3">
                            <label for="birthPlace">Место рождения:</label>
                            <input type="text" id="birthPlace" class="form-control"
                                   placeholder="место рождения" data-ng-model="newPerson.birthInfo.birthPlace.streetAddressLine"/>
                        </div>
                    </fieldset>
                    <fieldset class="form-group">
                        <legend>Контакты</legend>
                        <table class="table">
                            <thead>
                            <th class="col-xs-2">
                                тип
                            </th>
                            <th class="col-xs-10">
                                контакт
                            </th>
                            </thead>
                            <tbody>
                                <tr data-ng-repeat="telecom in newPerson.telecoms">
                                    <td>
                                            {{telecom.description}}
                                    </td>
                                    <td>
                                            {{telecom.value}}
                                        <a class="btn btn-default pull-right"  data-ng-click="removeTelecom($index)"
                                           placeholder="удалить">
                                            <span class="glyphicon glyphicon-remove"></span>
                                        </a>
                                        <a class="btn btn-default pull-right" data-toggle="modal"
                                           data-target="#newPersonTelecomUpdate{{$index}}"
                                           placeholder="редактировать">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </a>
                                        <jsp:include page="modal_new_person_value.jsp">
                                            <jsp:param name="id" value="newPersonTelecomUpdate{{$index}}"/>
                                            <jsp:param name="valueName" value="контакт"/>
                                            <jsp:param name="value" value="telecom"/>
                                            <jsp:param name="action" value=""/>
                                        </jsp:include>
                                            <%--
                                             <jsp:include page="modal_addr_delete.jsp">
                                                 <jsp:param name="index" value="${status.index}"/>
                                             </jsp:include>--%>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <a class="btn btn-default" data-toggle="modal" data-target="#newPersonTelecomAdd"
                                placeholder="добавить">
                            Добавить
                        </a>
                        <jsp:include page="modal_new_person_value.jsp">
                            <jsp:param name="id" value="newPersonTelecomAdd"/>
                            <jsp:param name="valueName" value="контакт"/>
                            <jsp:param name="value" value="newValue"/>
                            <jsp:param name="action" value="addValue(newPerson.telecoms, newValue)"/>
                        </jsp:include>
                    </fieldset>
                    <fieldset class="form-group">
                        <legend>Адреса</legend>
                        <table class="table">
                            <thead>
                            <th class="col-xs-2">
                                тип
                            </th>
                            <th class="col-xs-10">
                                адрес
                            </th>
                            </thead>
                            <tbody>
                            <tr data-ng-repeat="addr in newPerson.addressList">
                                <td>
                                    {{addr.description}}
                                </td>
                                <td>
                                    {{addr.streetAddressLine}}
                                    <a class="btn btn-default pull-right" data-ng-click="removeAddress($index)"
                                       placeholder="удалить">
                                        <span class="glyphicon glyphicon-remove"></span>
                                    </a>
                                    <a class="btn btn-default pull-right" data-toggle="modal"
                                       data-target="#newPersonAddressUpdate${status.index}"
                                       placeholder="редактировать">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </a>
                                    <jsp:include page="modal_new_person_address.jsp">
                                        <jsp:param name="id" value="newPersonAddressUpdate${status.index}"/>
                                        <jsp:param name="value" value="addr"/>
                                        <jsp:param name="action" value=""/>
                                    </jsp:include>
                                    <%-- <jsp:include page="modal_addr_update.jsp">
                                         <jsp:param name="index" value="${status.index}"/>
                                     </jsp:include>
                                     <jsp:include page="modal_addr_delete.jsp">
                                         <jsp:param name="index" value="${status.index}"/>
                                     </jsp:include>--%>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <button class="btn btn-default" data-toggle="modal" data-target="#newPersonAddressAdd"
                                placeholder="добавить">
                            Добавить
                        </button>
                        <jsp:include page="modal_new_person_address.jsp">
                            <jsp:param name="id" value="newPersonAddressAdd"/>
                            <jsp:param name="value" value="newAddress"/>
                            <jsp:param name="action" value="addAddress(newPerson.addressList, newAddress)"/>
                        </jsp:include>
                    </fieldset>
                    <fieldset class="form-group">
                        <legend>Документы</legend>
                        <table class="table table-bordered">
                            <thead>
                            <th>Документ</th>
                            <th>Атрибуты документа</th>
                            <th>Значение</th>
                            </thead>
                            <tbody>
                                <tr data-ng-repeat-start="doc in newPerson.documents">
                                    <td rowspan="{{sizeAttrs($index) + 1}}">
                                        <strong>{{doc.description}}</strong>
                                    </td>
                                    <td>
                                        <i>{{doc.attrs[0].description}}</i>
                                    </td>
                                    <td>
                                        <code>{{doc.attrs[0].value}}</code>
                                        <button class="btn btn-sm pull-right" data-ng-click="removeAttr(doc,0)"
                                           placeholder="удалить">
                                            <span class="glyphicon glyphicon-remove"></span>
                                        </button>
                                        <button class="btn btn-sm pull-right" data-toggle="modal"
                                           data-target="#newAttrUpdate{{doc.name}}_0"
                                           placeholder="редактировать">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                        <jsp:include page="modal_new_person_doc_attr.jsp">
                                            <jsp:param name="id" value="newAttrUpdate{{doc.name}}_0"/>
                                            <jsp:param name="value" value="doc.attrs[0]"/>
                                            <jsp:param name="docName" value="doc.name"/>
                                            <jsp:param name="attrList" value="doc.attrs"/>
                                            <jsp:param name="action" value=""/>
                                        </jsp:include>
                                    </td>

                                </tr>
                                    <tr data-ng-repeat="attr in doc.attrs" ng-if="$index > 0">
                                        <td>
                                            <i>{{attr.description}}</i>
                                        </td>
                                        <td>
                                            <code>{{attr.value}}</code>
                                            <button class="btn btn-sm pull-right" data-ng-click="removeAttr(doc,$index)"
                                                    placeholder="удалить">
                                                <span class="glyphicon glyphicon-remove"></span>
                                            </button>
                                            <button class="btn btn-sm pull-right" data-toggle="modal"
                                               data-target="#newAttrUpdate{{doc.name}}_{{$index}}"
                                               placeholder="редактировать">
                                                <span class="glyphicon glyphicon-pencil"></span>
                                            </button>
                                            <jsp:include page="modal_new_person_doc_attr.jsp">
                                                <jsp:param name="id" value="newAttrUpdate{{doc.name}}_{{$index}}"/>
                                                <jsp:param name="value" value="attr"/>
                                                <jsp:param name="docName" value="doc.name"/>
                                                <jsp:param name="attrList" value="doc.attrs"/>
                                                <jsp:param name="action" value=""/>
                                            </jsp:include>
                                        </td>
                                    </tr>
                                <tr data-ng-repeat-end>
                                    <td colspan="3">
                                        <button class="btn btn-sm" data-toggle="modal" data-target="#newAttrAdd{{doc.name}}"
                                           placeholder="добавить">
                                            добавить атрибут
                                        </button>
                                       <jsp:include page="modal_new_person_doc_attr.jsp">
                                            <jsp:param name="id" value="newAttrAdd{{doc.name}}"/>
                                            <jsp:param name="value" value="newAttr"/>
                                            <jsp:param name="docName" value="doc.name"/>
                                           <jsp:param name="attrList" value="attrs"/>
                                            <jsp:param name="action" value="addAttr(newPerson.documents[$index], newAttr)"/>
                                        </jsp:include>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <button class="btn btn-default" data-toggle="modal" data-target="#newPersonDocAdd"
                           placeholder="добавить">
                            Добавить документ
                        </button>
                        <jsp:include page="modal_new_person_doc.jsp">
                            <jsp:param name="id" value="newPersonDocAdd"/>
                            <jsp:param name="value" value="newDoc"/>
                            <jsp:param name="action" value="addDoc(newPerson.docs, newDoc)"/>
                        </jsp:include>
                    </fieldset>
                    <fieldset class="form-group">
                        <legend>Файлы</legend>
                        <table class="table table-bordered">
                            <thead>
                            <th>oid</th>
                            <th>Имя файла</th>
                            </thead>
                            <tbody>
                            <tr data-ng-repeat="file in newPerson.files">
                                <td>
                                    <strong>{{file.oid}}</strong>
                                </td>
                                <td>
                                    {{file.name}}
                                    <%--<a href="/files/?publicKey={{file.publicKey}}&systemOid={{systemLogin.oid}}&token={{file.token}}">
                                        {{file.name}}
                                    </a>--%>

                                    <button class="btn btn-sm pull-right" data-ng-click="removeAttr(doc,0)"
                                            placeholder="удалить">
                                        <span class="glyphicon glyphicon-remove"></span>
                                    </button>
                                    <button class="btn btn-sm pull-right" data-toggle="modal"
                                            data-target="#newAttrUpdate{{doc.name}}_0"
                                            placeholder="редактировать">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                    <jsp:include page="modal_new_person_doc_attr.jsp">
                                        <jsp:param name="id" value="newAttrUpdate{{doc.name}}_0"/>
                                        <jsp:param name="value" value="doc.attrs[0]"/>
                                        <jsp:param name="docName" value="doc.name"/>
                                        <jsp:param name="attrList" value="doc.attrs"/>
                                        <jsp:param name="action" value=""/>
                                    </jsp:include>
                                </td>

                            </tr>

                            </tbody>
                        </table>
                        <button class="btn btn-default" data-toggle="modal" data-target="#newPersonFileAdd"
                                placeholder="добавить">
                            Добавить файл
                        </button>
                        <jsp:include page="modal_new_person_files.jsp">
                            <jsp:param name="id" value="newPersonFileAdd"/>
                            <jsp:param name="value" value="newFile"/>
                            <jsp:param name="action" value="addFile(newFile)"/>
                        </jsp:include>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

</div>