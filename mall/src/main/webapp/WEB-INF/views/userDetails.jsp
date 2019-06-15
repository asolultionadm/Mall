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
<form:form method="post" modelAttribute="user" action="/mall/addUser">
<table>
		<tr>
			<th colspan="2">Add User</th>
		</tr>
		
		<tr>
          <td>
          <form:hidden path="id"/>
          <form:label path="username">User Name:</form:label></td>
          <td><form:input path="username" size="30" maxlength="30"></form:input></td>
        </tr>
        
                				<tr>
          <td><form:label path="password">Password:</form:label></td>
          <td><form:input path="password" size="30" maxlength="30"></form:input></td>
        </tr>
        
		<tr>
			    <td><form:label path="registerDate">Register Date:</form:label></td>
          <td><form:input path="registerDate" size="30" maxlength="30"></form:input></td>
		</tr>
				<tr>
          <td><form:label path="expiredDate">Expiry Date</form:label></td>
          <td><form:input path="expiredDate" size="30" maxlength="30"></form:input></td>
        </tr>
        
        				<tr>
          <td><form:label path="active">Is Active:</form:label></td>
          <td><form:checkbox path="active"></form:checkbox>
        </tr>
		
				<tr>
          <td><form:label path="lockCount">Lock Count:</form:label></td>
          <td><form:input path="lockCount" size="2" maxlength="1"></form:input></td>
        </tr>
						<tr>
          <td><form:label path="roles">Lock Count:</form:label></td>
          <td><form:checkboxes path="roles" items="${listOfRoles}" itemLabel="name"></form:checkboxes></td>
        </tr>
		<tr>
			<td colspan="2"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
<h3>User List</h3>
<c:if test="${!empty listOfUsers}">
	<table class="tg">
	<tr>
		<th width="80">Id</th>
		<th width="120">User Name</th>
		<th width="120">Register Date</th>
		<th width="60">Expiry Date</th>
		<th width="60">Active</th>
		<th width="60">Lock Count</th>
	</tr>
	<c:forEach items="${listOfUsers}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.username}</td>
			<td>${user.registerDate}</td>
			<td>${user.expiredDate}</td>
			<td>${user.active}</td>
			<td>${user.lockCount}</td>
			<td><a href="<c:url value='/updateUser/${user.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/deleteUser/${user.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
