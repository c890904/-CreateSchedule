<%@page import="model.ModelGroup"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Shop add</h1>
	<form method="post" action="./add">
		<input type="text" name="name"/><br/>
		<input type="checkbox" name ="groupcheck"  value="checked"><select name="groupselect">
			<option value="create" selected="selected">作成</option>
			<%
			ModelGroup[] groupList = (ModelGroup[])request.getAttribute("grouplist");
			for (int i = 0; i < groupList.length; i++) {
				%> <option value="<%= groupList[i].getId() %>"><%= groupList[i].getName() %></option> <%
			}
			%>
		</select><br/>
		<button type="submit">送信</button>
	</form>
</body>
</html>