<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

	<form method = "post">
	
	<p>名前<input type = "text" name = "name" required></p>
	<p>年齢<input type = "text" name = "age"></p>

	<p>生年月日
	<select id = "birthYear">
	<option value = ""></option>
	</select>
	
	<select id = "birthMonth">
	<option value = ""></option>
	</select>
	
	<select id = "birthDay">
	<option value = ""></option>
	</select>
	</p>
	
	<button onclick = "location.href = 'menu.jsp'">戻る</button>
	
	<input type = "submit" value = "登録">
	
	
	</form>


<script>

</script>

<%@include file="../footer.html" %>