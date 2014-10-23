<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<div class="pdm-frame">
    <div class="col">

        <table class="table table-bordered">
            <thead>
            <th>Документ</th>
            <th>Код документа</th>
            <th>Атрибуты документа</th>
            <th>OID атрибута</th>
            <th>Код атрибута</th>
            </thead>
            <tbody>
            <c:forEach items="${pdmDocs.docs}" var="doc" varStatus="status">
                <tr>
                    <td rowspan="${doc.attrs.size() + 1}">
                        <strong>${doc.description}</strong>
                        <a class="btn btn-sm pull-right" data-toggle="modal"
                           data-target="#docDelete${status.index}"
                           placeholder="удалить">
                            <span class="glyphicon glyphicon-remove"></span>
                        </a>
                        <a class="btn btn-sm pull-right" data-toggle="modal"
                           data-target="#docUpdate${status.index}"
                           placeholder="редактировать">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </a>
                        <jsp:include page="modal_doc_update.jsp">
                            <jsp:param name="index" value="${status.index}"/>
                        </jsp:include>
                        <jsp:include page="modal_doc_delete.jsp">
                            <jsp:param name="index" value="${status.index}"/>
                            <jsp:param name="description" value="${doc.description}"/>
                            <jsp:param name="name" value="${doc.name}"/>
                        </jsp:include>
                    </td>
                    <td rowspan="${doc.attrs.size() + 1}">
                        <code>${doc.name}</code>
                    </td>
                    <td>
                        <i>${doc.attrs.get(0).description}</i>
                    </td>
                    <td>
                        <code>${doc.attrs.get(0).oid}</code>
                    </td>
                    <td>
                        <code>${doc.attrs.get(0).name}</code>
                        <a class="btn btn-sm pull-right" data-toggle="modal"
                           data-target="#attrDelete${doc.name}_${status.index}"
                           placeholder="удалить">
                            <span class="glyphicon glyphicon-remove"></span>
                        </a>
                        <a class="btn btn-sm pull-right" data-toggle="modal"
                           data-target="#attrUpdate${status.index}_0"
                           placeholder="редактировать">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </a>
                            <jsp:include page="modal_attr_update.jsp">
                                <jsp:param name="docIndex" value="${status.index}"/>
                                <jsp:param name="index" value="0"/>
                            </jsp:include>
                        <jsp:include page="modal_attr_delete.jsp">
                            <jsp:param name="index" value="0"/>
                            <jsp:param name="description" value="${doc.attrs[0].description}"/>
                            <jsp:param name="docName" value="${doc.name}"/>
                        </jsp:include>
                    </td>

                </tr>
                <c:forEach begin="1" items="${doc.attrs}" var="attr" varStatus="statusAttr">
                    <tr>

                        <td>
                            <i>${attr.description}</i>
                        </td>
                        <td>
                            <code>${attr.oid}</code>
                        </td>
                        <td>
                            <code>${attr.name}</code>
                            <a class="btn btn-sm pull-right" data-toggle="modal"
                               data-target="#attrDelete${doc.name}_${statusAttr.index}"
                               placeholder="удалить">
                                <span class="glyphicon glyphicon-remove"></span>
                            </a>
                            <a class="btn btn-sm pull-right" data-toggle="modal"
                               data-target="#attrUpdate${status.index}_${statusAttr.index}"
                               placeholder="редактировать">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a>
                            <jsp:include page="modal_attr_update.jsp">
                                <jsp:param name="docIndex" value="${status.index}"/>
                                <jsp:param name="index" value="${statusAttr.index}"/>
                            </jsp:include>
                            <jsp:include page="modal_attr_delete.jsp">
                                <jsp:param name="docName" value="${doc.name}"/>
                                <jsp:param name="index" value="${statusAttr.index}"/>
                                <jsp:param name="description" value="${attr.description}"/>
                            </jsp:include>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="3">
                        <a class="btn btn-sm" data-toggle="modal" data-target="#attrAdd${status.index}"
                           placeholder="добавить">
                            добавить атрибут
                                <%-- <span class="glyphicon glyphicon-plus"></span>--%>
                        </a>
                        <jsp:include page="modal_attr_new.jsp">
                            <jsp:param name="docIndex" value="${status.index}"/>
                        </jsp:include>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-default" data-toggle="modal" data-target="#docAdd"
           placeholder="добавить">
            Добавить документ
        </a>
        <jsp:include page="modal_doc_new.jsp"/>
    </div>

</div>
