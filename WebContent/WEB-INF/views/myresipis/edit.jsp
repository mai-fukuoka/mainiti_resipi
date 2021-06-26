<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
                <h3>Myレシピ 編集</h3>
                <form method="POST" action="<c:url value='/myresipis/update' />">
                    <c:import url="_form.jsp" />
                </form>
                <form method="POST" enctype="multipart/form-data"
                    action="${pageContext.request.contextPath}/upload">
                    <input name="uploadFile" type="file" /> <br> <br> <input
                        type="hidden" name="id" value="${myresipi_id}" /> <input
                        type="submit" value="送信" />
                </form>
            </c:when>
            <c:otherwise>
                <h2>データは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <form method="POST" action="<c:url value='/myresipis/destroy'  />">
            <input type="hidden" name="_token" value="${_token}" /> <input
                type="hidden" name="userid" value="abc" /> <input type="hidden"
                name="myresipi_id" value="${myresipi_id}" />
            <button type="submit" style="margin-top:20px; class="button">削除</button>
        </form>

        <p>
            <a href="<c:url value='/myresipis/index' />">一覧に戻る</a>
        </p>
    </c:param>
</c:import>