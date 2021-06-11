<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../header.html" %>

<p>メニュー画面</p>

	<button id = "regist" onclick = "location.href = 'registration.jsp'">会員情報登録</button><br>
	<button id = "update" onclick = "location.href = 'change.jsp'">会員情報変更</button><br>
	<button id = "delete" onclick = "location.href = 'delete.jsp'">会員情報削除</button>
	


<%@include file="../footer.html" %>