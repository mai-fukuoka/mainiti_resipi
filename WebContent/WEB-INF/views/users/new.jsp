<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="header">
        <meta charset="UTF-8">
        <title>買い物リスト</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
        <link rel="stylesheet" href="<c:url value='/css/login.css' />">
    </c:param>
    <c:param name="content">
        <c:if test="${errors !=null }">
            <div id="flush_error">
                入力内容にエラーがあります。<br />
                <c:forEach var="error" items="${errors }">
                    <c:out value="${error }" />
                    <br />
                </c:forEach>

            </div>

        </c:if>
        <div class="form-wrapper">
            <div class="page">
                <a>新規登録ページ</a>
            </div>
            <form method="POST" class="form"
                action="<c:url value='/users/create' />">
                <div class="form-item">
                    <label for="user_id">ユーザーID</label><br /> <input type="text"
                        name="user_id" value="${user.user_id }" />
                </div>

                <div class="form-item">
                    <label for="name">氏名</label><br /> <input type="text" name="name"
                        value="${user.name }" />
                </div>

                <div class="form-item">
                    <label for="password">PASSWORD</label><br /> <input type="password"
                        name="password" />
                </div>

                <div class="button-panel">
                    <input type="hidden" name="_token" value="${_token }" /> <input
                        type="submit" class="button" title="登録" value="登録"></input>
                </div>
            </form>

        </div>
    </c:param>
</c:import>