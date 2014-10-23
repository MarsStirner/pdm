<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="attrAdd${param.docIndex}" tabindex="-1" role="dialog" aria-labelledby="attrAddLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="attrAddLabel">Добавить атрибут</h4>
            </div>
            <div class="modal-body">
                <form:form method="POST" action="docs/${param.docIndex}/new/attr"
                           modelAttribute="pdmDocs"
                           role="form">
                    <form:input path="docs[${param.docIndex}].name" type="hidden"/>
                    <div class="form-group">
                        <strong>
                            <form:label
                                    path="docs[${param.docIndex}].newAttr.newDescription">Наименование:</form:label>
                            <form:input path="docs[${param.docIndex}].newAttr.newDescription"
                                        cssClass="form-control"/>
                        </strong>
                    </div>
                    <div class="form-group">
                        <code>
                            <form:label path="docs[${param.docIndex}].newAttr.newOid">OID:</form:label>
                            <form:input path="docs[${param.docIndex}].newAttr.newOid"
                                        cssClass="form-control"/>
                        </code>
                    </div>
                    <div class="form-group">
                        <code>
                            <form:label path="docs[${param.docIndex}].newAttr.newName">Код:</form:label>
                            <form:input path="docs[${param.docIndex}].newAttr.newName"
                                        cssClass="form-control"/>
                        </code>
                    </div>
                </form:form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-default" data-dismiss="modal"
                        onClick="$('form[action=docs\\/${param.docIndex}\\/new\\/attr').submit();">Сохранить
                </button>
                <button type="reset" class="btn btn-default" data-dismiss="modal">
                    Отмена
                </button>
            </div>
        </div>
    </div>
</div>
