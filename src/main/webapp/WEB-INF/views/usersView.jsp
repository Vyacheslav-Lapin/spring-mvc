<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <title><spring:message code="form.users.name"/></title>

  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
        crossorigin="anonymous"/>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
          crossorigin="anonymous"></script>
</head>
<body>

<h3><spring:message code="form.table.users.title"/></h3>
<table class="table">
  <caption class="hide"><spring:message code="form.users.name"/></caption>
  <thead>
  <tr>
    <th id="id"><spring:message code="form.table.users.col.id"/></th>
    <th id="firstName"><spring:message code="form.table.users.col.firstName"/></th>
    <th id="lastName"><spring:message code="form.table.users.col.lastName"/></th>
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

<a href="${pageContext.request.contextPath}/addUser.form"><spring:message code="form.adduser.name"/></a>

</body>
</html>
