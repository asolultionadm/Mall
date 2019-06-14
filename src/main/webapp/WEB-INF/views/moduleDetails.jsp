<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style>
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: SteelBlue;
	color: white;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>
</head>
<body>
	<form:form method="post" modelAttribute="module"
		action="/mall/addModule">
		<table>
			<tr>
				<th colspan="2"><c:choose>
						<c:when test="${module.id!='0'}">
							Update
						</c:when>
						<c:otherwise>
							Add
						</c:otherwise>
					</c:choose> Module</th>
			</tr>
			<tr>
				<td><form:label path="id">Module Id:</form:label></td>
				<td><c:choose>
						<c:when test="${module.id!='0'}">
						    ${module.id}
							<form:hidden path="id" />
						</c:when>
						<c:otherwise>
							<form:input path="id" size="30" maxlength="40"></form:input>
						</c:otherwise>
					</c:choose></td>
			</tr>

			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name" size="30" maxlength="40"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="description">Description:</form:label></td>
				<td><form:input path="description" size="30" maxlength="200"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="parent">Parent</form:label></td>
				<td><form:input path="parent" size="4" maxlength="4"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="hasChild">Has Child</form:label></td>
				<td><form:checkbox path="hasChild"></form:checkbox></td>
			</tr>

			<tr>
				<td><form:label path="publicAccess">Public Access:</form:label></td>
				<td><form:checkbox path="publicAccess"></form:checkbox></td>
			</tr>
			<tr>
				<td><form:label path="enable">Enable:</form:label></td>
				<td><form:checkbox path="enable"></form:checkbox></td>
			</tr>
			<tr>
				<td><form:label path="sequence">Sequence:</form:label></td>
				<td><form:input path="sequence" size="4" maxlength="4"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="url">Url:</form:label></td>
				<td><form:input path="url" size="30" maxlength="100"></form:input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="blue-button" /></td>
			</tr>
		</table>
	</form:form>
	</br>
	<h3>Module List</h3>
	<c:if test="${!empty listOfModules}">
		<table class="tg">
			<tr>
				<th width="80">Id</th>
				<th width="120">Module Name</th>
				<th width="120">Description</th>
				<th width="60">Parent</th>
				<th width="60">Has Child</th>
				<th width="60">For Public</th>
				<th width="60">Enabled</th>
				<th width="60">Sequence</th>
				<th width="60">Url</th>
			</tr>
			<c:forEach items="${listOfModules}" var="module">
				<tr>
					<td>${module.id}</td>
					<td>${module.name}</td>
					<td>${module.description}</td>
					<td>${module.parent}</td>
					<td>${module.hasChild}</td>
					<td>${module.publicAccess}</td>
					<td>${module.enable}</td>
					<td>${module.sequence}</td>
					<td>${module.url}</td>
					<td><a href="<c:url value='/updateModule/${module.id}' />">Edit</a></td>
					<td><a href="<c:url value='/deleteModule/${module.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
