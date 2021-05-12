<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <title><spring:message code="form.users.name"/></title>
</head>
<body>

<h3><spring:message code="form.table.users.title"/></h3>
<table style="border-width: 1px">
  <caption></caption>
  <thead>
  <tr>
    <th><spring:message code="form.table.users.col.id"/></th>
    <th><spring:message code="form.table.users.col.firstName"/></th>
    <th><spring:message code="form.table.users.col.lastName"/></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="user" items="${users}">
    <tr>
      <td>${user.id}</td>
      <td>${user.firstName}</td>
      <td>${user.lastName}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<hr/>

<a href="${pageContext.request.contextPath}/adduser.form"><spring:message code="form.adduser.name"/></a>

</body>
</html>
