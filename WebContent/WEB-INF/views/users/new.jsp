<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
    <c:if test="${errors !=null }">
    <div id="flush_error">
    入力内容にエラーがあります。<br/>
    <c:forEach var="error" items="${errors }">
    <c:out value="${error }"/><br/>
    </c:forEach>

    </div>

    </c:if>
    <div class="new_login">
    <h1>新規登録ページ</h1>
    <form method="POST" action="<c:url value='/users/create' />">
<label for="user_id">ユーザーID</label><br/>
<input type="text" name="user_id" value="${user.user_id }" /><br/>

<label for="name">氏名</label><br/>
<input type="text" name="name" value="${user.name }"/><br/>

<label for="password">PASSWORD</label><br/>
<input type="password" name="password"/><br/>

<input type="hidden" name="_token" value="${_token }"/>
<button type="submit" class="button">登録</button></form>


</div>
    </c:param>
    </c:import>