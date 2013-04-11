<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title" />
        <c:if test="${empty contact.id}">  <spring:message code="label.addcontact" /></c:if>
        <c:if test="${not empty contact.id}">  <spring:message code="label.edit" /> </c:if>
    </title>
</head>
<body>

<a href="<c:url value="/" />">
    <spring:message code="label.search" />
</a>

<h2><spring:message code="label.title" /></h2>
<c:if test="${empty contact.id}">
<form:form method="post" commandName="user" action="add" >
    <form:hidden path="id"/>

    <table>
        <tr>
            <td><form:label path="login" >
                <spring:message code="label.login" />
            </form:label></td>
            <td><form:input path="login"  name="login"/></td>
        </tr>
        <tr>
            <td><form:label path="password">
                <spring:message code="label.password" />
            </form:label></td>
            <td><form:input path="password"  name="password"/></td>
        </tr>
        <tr>
            <td><form:label path="enabled">
                <spring:message code="label.enabled" />
            </form:label></td>
            <td><form:input path="enabled"  name="enabled"/></td>
        </tr>
        <tr>
            <td><form:label path="role">
                <spring:message code="label.role" />
            </form:label></td>
            <td><form:input path="role"  name="role"/></td>
        </tr>
        <tr>
            <td><form:label path="firstname">
                <spring:message code="label.firstname" />
            </form:label></td>
            <td><form:input path="firstname"  name="firstname"/></td>
        </tr>
        <tr>
            <td><form:label path="lastname">
                <spring:message code="label.lastname" />
            </form:label></td>
            <td><form:input path="lastname"  name="lastname"/></td>
        </tr>
        <tr>
            <td><form:label path="email">
                <spring:message code="label.email" />
            </form:label></td>
            <td><form:input path="email"  name="email"/></td>
        </tr>
        <tr>
            <td><form:label path="telephone">
                <spring:message code="label.telephone" />
            </form:label></td>
            <td><form:input path="telephone"  name="telephone"/></td>
        </tr>
        <tr>
            <td><form:label path="gender">
                <spring:message code="label.gender" />
            </form:label></td>
            <td><form:input path="gender"   name="gender"/></td>
        </tr>
        <tr>
            <td><form:label path="adress">
                <spring:message code="label.adress" />
            </form:label></td>
            <td><form:input path="adress"  name="adress"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form:form>
</c:if>
<c:if test="${not empty contact.id}">
    <form:form method="post" commandName="user" action="edit" >
        <form:hidden path="id"/>

        <table>
            <tr>
                <td><form:label path="login" >
                    <spring:message code="label.login" />
                </form:label></td>
                <td><form:input path="login"  name="login" /></td>
            </tr>
            <tr>
                <td><form:label path="password">
                    <spring:message code="label.password" />
                </form:label></td>
                <td><form:input path="password"  name="password"/></td>
            </tr>
            <tr>
                <td><form:label path="enabled">
                    <spring:message code="label.enabled" />
                </form:label></td>
                <td><form:input path="enabled"  name="enabled"/></td>
            </tr>
            <tr>
                <td><form:label path="role">
                    <spring:message code="label.role" />
                </form:label></td>
                <td><form:input path="role"  name="role"/></td>
            </tr>
            <tr>
                <td><form:label path="firstname">
                    <spring:message code="label.firstname" />
                </form:label></td>
                <td><form:input path="firstname"  name="firstname"/></td>
            </tr>
            <tr>
                <td><form:label path="lastname">
                    <spring:message code="label.lastname" />
                </form:label></td>
                <td><form:input path="lastname"  name="lastname"/></td>
            </tr>
            <tr>
                <td><form:label path="email">
                    <spring:message code="label.email" />
                </form:label></td>
                <td><form:input path="email"  name="email"/></td>
            </tr>
            <tr>
                <td><form:label path="telephone">
                    <spring:message code="label.telephone" />
                </form:label></td>
                <td><form:input path="telephone"  name="telephone"/></td>
            </tr>
            <tr>
                <td><form:label path="gender">
                    <spring:message code="label.gender" />
                </form:label></td>
                <td><form:input path="gender"  name="gender"/></td>
            </tr>
            <tr>
                <td><form:label path="adress">
                    <spring:message code="label.adress" />
                </form:label></td>
                <td><form:input path="adress"  name="adress"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Сохранить" /></td>
            </tr>
        </table>
    </form:form>
</c:if>
</body>
</html>