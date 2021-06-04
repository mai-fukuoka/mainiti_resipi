<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
 <c:param name="header">
        <meta charset="UTF-8">
        <title>Myレシピ</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
        <link rel="stylesheet" href="<c:url value='/css/myresipi.css' />">
   </c:param>
    <c:param name="content">
     <c:choose>
            <c:when test="${myresipi != null}">
                <h3>Myレシピ　編集</h3>
                <form method="POST" action="<c:url value='/myresipis/update' />">
                    <c:import url="_form.jsp" />
                </form>
            </c:when>
            <c:otherwise>
                <h2>データは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/myresipis/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>