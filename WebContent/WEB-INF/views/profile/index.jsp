<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="header">
        <meta charset="UTF-8">
        <title>プロフィール</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
        <link rel="stylesheet" href="<c:url value='/css/login.css' />">
    </c:param>
    <c:param name="content">
         <div class="form-wrapper">
    <div class="page">
    <a>プロフィール</a>
    </div>
    <form method="POST" class="form" action="<c:url value='/profile/edit' />">
    <div class="form-item">
<label for="user_id">ユーザーID</label><br/>
<input type="text" name="user_id" value="${user.user_id}" /></div>

<div class="form-item">
<label for="name">氏名</label><br/>
<input type="text" name="name" value="${user.name}"/></div>

<div class="form-item">
<label for="password">PASSWORD</label><br/>
<input type="password" name="password"/></div>

<div class="button-panel">
<input type="hidden" name="_token" value="${_token }"/>
<input type="submit" class="button" title="編集" value="編集"></input></div></form>

</div>
    </c:param>
</c:import>