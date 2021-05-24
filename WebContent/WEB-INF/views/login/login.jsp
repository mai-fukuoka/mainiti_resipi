<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
   <c:param name="header">
        <meta charset="UTF-8">
        <title>買い物リスト</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
        <link rel="stylesheet" href="<c:url value='/css/login.css' />">
   </c:param>
    <c:param name="content">
        <c:if test="${hasError }">
            <div id="flush_error">ユーザーIDかパスワードが間違っています。</div>
        </c:if>
        <c:if test="${flush !=null }">
            <div id="flush_success">
                <c:out value="${flush }"></c:out>
            </div>
        </c:if>
        <div class="form-wrapper">
         <div class="page">
            <a>Sign in</a>
            </div>
            <form method="POST" class="form" action="<c:url value='/login' />">
                <div class="form-item">
                    <label for="user_id">ユーザーID</label> <br/>
                    <input type="text" name="user_id" value="${user_id}" /></div>

                        <div class="form-item">
                        <label for="password">PASSWORD</label><br/>
                    <input type="password" name="password" /></div>

                    <div>
                    <input type="hidden" name="_token" value="${_token }" />
                </div>
                <div class="button-panel">
                    <input type="submit" class="button" title="Sign In" value="Sign In" />
                </div>
            </form>
        </div>
    </c:param>
</c:import>