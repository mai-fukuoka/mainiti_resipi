<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${hasError }">
            <div id="flush_error">ユーザーIDかパスワードが間違っています。</div>
        </c:if>
        <c:if test="${flush !=null }">
            <div id="flush_success">
                <c:out value="${flush }"></c:out>
            </div>
        </c:if>
        <div class="form_wrapper">
            <h1>Sign in</h1>
            <form method="POST" action="<c:url value='/login' />">
                <div class="form_item">
                    <label for="user_id"></label> <input type="text"
                        name="user_id" placeholder="USER ID" value="${user_id}" /></div>
                        <div class="form-item">
                        <label for="password"></label>
                    <input type="password" name="paassword" placeholder="Password"/></div>
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