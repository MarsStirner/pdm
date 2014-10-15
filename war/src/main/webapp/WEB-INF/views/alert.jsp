<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${param.msg != null && !param.msg.isEmpty()}">
    <div class="alert alert-${param.alertType}">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
        ${param.msg}
    </div>
</c:if>