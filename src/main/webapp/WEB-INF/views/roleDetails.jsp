<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>           
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9
}     
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>
</head>
<body>
<form:form method="post" modelAttribute="role" action="/mall/addRole">
<table>
		<tr>
			<th colspan="2">Add Role</th>
		</tr>
		
		<tr>
          <td>
          <form:hidden path="id"/>
          <form:label path="name">Role Name:</form:label></td>
          <td><form:input path="name" size="30" maxlength="30"></form:input></td>
        </tr>
        
                				<tr>
          <td><form:label path="description">Description:</form:label></td>
          <td><form:input path="description" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
        <td><form:label path="roles">Modules:</form:label></td>
          <td><!-- form:checkboxes path="roles" items="${listOfModules}" itemValue="id" itemLabel="name"/-->
          </td>
          </tr>
		
		<tr>
			<td colspan="2"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
<h3>Role List</h3>
<c:if test="${!empty listOfRoles}">
	<table class="tg">
	<tr>
		<th width="80">Id</th>
		<th width="120">Role Name</th>
		<th width="120">Description</th>
	</tr>
	<c:forEach items="${listOfRoles}" var="role">
		<tr>
			<td>${role.id}</td>
			<td>${role.name}</td>
			<td>${role.description}</td>
			<td><a href="<c:url value='/updateRole/${role.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/deleteRole/${role.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
