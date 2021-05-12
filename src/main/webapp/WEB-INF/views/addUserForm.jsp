<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <title><spring:message code="form.adduser.name"/></title>
</head>
<body>

<h3><spring:message code="form.adduser.name"/></h3>

<form:form method="post" modelAttribute="userFormBean">
  <table>
    <tbody>
    <tr>
      <td><spring:message code="form.table.userlist.col.firstname"/></td>
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
