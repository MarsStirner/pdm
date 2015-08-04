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
                Поиск
            </div>
            <div class="panel-body">
                <form role="form">
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
                        <div class="col-xs-7">
                            <label for="findQueryId">Поисковый запрос:</label>
                            <input type="text" id="findQueryId" class="form-control" placeholder="ФИО, дата или место рождения, адрес, номер документа..." data-ng-model="query"/>
                            </div>
                        <div class="col-xs-5">
                            <button type="submit" class="btn btn-primary  pull-right" placeholder="авторизация подсистемы" data-ng-click="find(query)">найти</button>
                        </div>
                    </fieldset>

                    <fieldset class="form-group">
                        <legend></legend>
                        <table class="table">
                            <thead>
                            <th class="col-xs-2">
                                Фамилия
                            </th>
                            <th class="col-xs-2">
                                Имя
                            </th>
                            <th class="col-xs-2">
                                Отчество
                            </th>
                            <th class="col-xs-6">
                                Публичый <code>Id</code>
                            </th>
                            </thead>
                            <tbody>
                                <tr data-ng-repeat="person in persons">
                                    <td>
                                        {{person.family}}
                                    </td>
                                    <td>
                                        {{person.given}}
                                    </td>
                                    <td>
                                        {{person.middleName}}
                                    </td>
                                    <td>
                                        <a href="/person/?publicKey={{person.publicKey}}&systemOid={{systemLogin.oid}}&token={{newPerson.tokenEncode}}">
                                            {{person.publicKey}}
                                        </a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>