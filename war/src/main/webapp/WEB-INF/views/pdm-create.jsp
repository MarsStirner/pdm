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
                Основная информация
            </div>
            <div class="panel-body">
                <form role="form">
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary" placeholder="добавить" data-ng-click="create()">Добавить</button>
                        <button type="reset" class="btn btn-default pull-right" placeholder="отмена">Отмена</button>
                    </div>
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
                            <select id="sex" class="form-control" placeholder="пол" data-ng-model="newPerson.sex">
                                <option value="none"></option>
                                <option value="male">М</option>
                                <option value="female">Ж</option>
                            </select>
                        </div>
                        <div class="col-xs-2">
                            <label for="birthDate">Дата рождения:</label>
                            <input type="date" id="birthDate" class="form-control"
                                   placeholder="дата рождения" data-ng-model="newPerson.birthDate"/>
                        </div>
                        <div class="col-xs-3">
                            <label for="birthPlace">Место рождения:</label>
                            <input type="text" id="birthPlace" class="form-control"
                                   placeholder="место рождения" data-ng-model="newPerson.birthPlace"/>
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
                                        <a class="btn btn-default pull-right" data-toggle="modal"
                                           data-target="#newPersonTelecomDelete{{$index}}"
                                           placeholder="удалить">
                                            <span class="glyphicon glyphicon-remove"></span>
                                        </a>
                                        <a class="btn btn-default pull-right" data-toggle="modal"
                                           data-target="#newPersonTelecomUpdate{{$index}}"
                                           placeholder="редактировать">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </a>
                                        <jsp:include page="modal_new_person_new_value.jsp">
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
                        <jsp:include page="modal_new_person_new_value.jsp">
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
                            <tr data-ng-repeat="addr in newPerson.address">
                                <td>
                                    {{addr.description}}
                                </td>
                                <td>
                                    ${addr.value}
                                    <a class="btn btn-default pull-right" data-toggle="modal"
                                       data-target="#addrDelete${status.index}"
                                       placeholder="удалить">
                                        <span class="glyphicon glyphicon-remove"></span>
                                    </a>
                                    <a class="btn btn-default pull-right" data-toggle="modal"
                                       data-target="#addrUpdate${status.index}"
                                       placeholder="редактировать">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </a>
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
                        <button class="btn btn-default" data-toggle="modal" data-target="#addrAdd"
                                placeholder="добавить">
                            Добавить
                        </button>
                        <%--
                          <jsp:include page="modal_addr_new.jsp">
                          <jsp:param name="index" value="0"/>
                          </jsp:include>
                        --%>
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
                            <c:forEach items="${newPerson.docs}" var="doc" varStatus="status">
                                <tr>
                                    <td rowspan="${doc.attrs.size() + 1}">
                                        <strong>${doc.description}</strong>
                                    </td>
                                    <td>
                                        <i>${doc.attrs.get(0).description}</i>
                                    </td>
                                    <td>
                                        <code>${doc.attrs.get(0).value}</code>
                                        <button class="btn btn-sm pull-right" data-toggle="modal"
                                           data-target="#newAttrDelete${doc.name}_${status.index}"
                                           placeholder="удалить">
                                            <span class="glyphicon glyphicon-remove"></span>
                                        </button>
                                        <button class="btn btn-sm pull-right" data-toggle="modal"
                                           data-target="#newAttrUpdate${status.index}_0"
                                           placeholder="редактировать">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                       <%-- <jsp:include page="modal_attr_update.jsp">
                                            <jsp:param name="docIndex" value="${status.index}"/>
                                            <jsp:param name="index" value="0"/>
                                        </jsp:include>--%>
                                        <%--<jsp:include page="modal_attr_delete.jsp">
                                            <jsp:param name="index" value="0"/>
                                            <jsp:param name="description" value="${doc.attrs[0].description}"/>
                                            <jsp:param name="docName" value="${doc.name}"/>
                                        </jsp:include>--%>
                                    </td>

                                </tr>
                                <c:forEach begin="1" items="${doc.attrs}" var="attr" varStatus="statusAttr">
                                    <tr>
                                        <td>
                                            <i>${attr.description}</i>
                                        </td>
                                        <td>
                                            <code>${attr.value}</code>
                                            <button class="btn btn-sm pull-right" data-toggle="modal"
                                               data-target="#newAttrDelete${doc.name}_${statusAttr.index}"
                                               placeholder="удалить">
                                                <span class="glyphicon glyphicon-remove"></span>
                                            </button>
                                            <button class="btn btn-sm pull-right" data-toggle="modal"
                                               data-target="#newAttrUpdate${status.index}_${statusAttr.index}"
                                               placeholder="редактировать">
                                                <span class="glyphicon glyphicon-pencil"></span>
                                            </button>
                                            <%--<jsp:include page="modal_attr_update.jsp">
                                                <jsp:param name="docIndex" value="${status.index}"/>
                                                <jsp:param name="index" value="${statusAttr.index}"/>
                                            </jsp:include>--%>
                                            <%--<jsp:include page="modal_attr_delete.jsp">
                                                <jsp:param name="docName" value="${doc.name}"/>
                                                <jsp:param name="index" value="${statusAttr.index}"/>
                                                <jsp:param name="description" value="${attr.description}"/>
                                            </jsp:include>--%>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td colspan="3">
                                        <button class="btn btn-sm" data-toggle="modal" data-target="#newAttrAdd${status.index}"
                                           placeholder="добавить">
                                            добавить атрибут
                                        </button>
                                        <%--<jsp:include page="modal_new_person_attr_new.jsp">
                                            <jsp:param name="docIndex" value="${status.index}"/>
                                        </jsp:include>--%>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <button class="btn btn-default" data-toggle="modal" data-target="#newPersonDocAdd"
                           placeholder="добавить">
                            Добавить документ
                        </button>
                        <%--<jsp:include page="modal_doc_new.jsp"/>--%>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

    <%-- <div class="col">
        <div class="panel panel-info">
            <div class="panel-heading">
                Файлы
            </div>
            <div class="panel-body">
                //TODO
            </div>
        </div>
    </div>--%>


</div>