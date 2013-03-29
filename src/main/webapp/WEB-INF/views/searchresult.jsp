<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3><spring:message code="label.searchresult" /></h3>
<c:if test="${!empty searchResult}">
    <table class="data">
        <tr>
            <th><spring:message code="label.login" /></th>
            <th><spring:message code="label.password" /></th>
            <th><spring:message code="label.enabled" /></th>
            <th><spring:message code="label.role" /></th>
            <th><spring:message code="label.firstname" /></th>
            <th><spring:message code="label.lastname" /></th>
            <th><spring:message code="label.email" /></th>
            <th><spring:message code="label.telephone" /></th>
            <th><spring:message code="label.gender" /></th>
            <th><spring:message code="label.adress" /></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${searchResult}" var="basicUser">
            <tr>
                <td>${contact.login}</td>
                <td>${contact.password}</td>
                <td>${contact.enabled}</td>
                <td>${contact.role}</td>
                <td>${contact.firstname}</td>
                <td>${contact.lastname}</td>
                <td>${contact.email}</td>
                <td>${contact.telephone}</td>
                <td>${contact.gender}</td>
                <td>${contact.adress}</td>
                <td><a href="delete/${contact.id}"><spring:message code="label.delete" /></a></td>
                <td><a href="<c:url value="/editContact?id=${contact.id}"/>"><spring:message code="label.edit" /></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
