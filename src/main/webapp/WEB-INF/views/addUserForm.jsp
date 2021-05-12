<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <title><spring:message code="form.adduser.name"/></title>

  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
        crossorigin="anonymous"/>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
          crossorigin="anonymous"></script>
</head>
<body>

<h3><spring:message code="form.adduser.name"/></h3>

<form:form modelAttribute="user">
  <table class="table table-striped table-bordered table-hover">
    <caption><spring:message code="form.adduser.name"/></caption>
    <thead>
    <tr>
      <th id="name" class="bg-success text-center h1">Name</th>
      <th id="value" class="bg-warning text-center h1">Value</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td><spring:message code="name.first"/></td>
      <td><form:input path="firstName"/></td>
    </tr>
    <tr>
      <td colspan="2" style="color: red; font-size: small;">
        <form:errors path="firstName"/>
      </td>
    </tr>
    <tr>
      <td><spring:message code="name.last"/></td>
      <td><form:input path="lastName"/></td>
    </tr>
    <tr>
      <td colspan="2" style="color: red; font-size: small;">
        <form:errors path="lastName"/>
      </td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="Save Changes"/></td>
    </tr>
    </tbody>
  </table>
</form:form>

</body>
</html>
