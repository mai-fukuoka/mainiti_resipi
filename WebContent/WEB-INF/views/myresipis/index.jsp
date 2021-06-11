<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="header">
        <meta charset="UTF-8">
        <title>Myレシピ</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
        <link rel="stylesheet" href="<c:url value='/css/myresipi.css' />">
    </c:param>
    <c:param name="content">
        <div class="name">
            <h3>Myレシピ</h3>
        </div>
        <table class="myresipi_list">
            <tbody>
                <tr>
                    <th class="id">ID</th>
                    <th class="resipi_title">料理名</th>
                    <th class="resipi_coments">コメント</th>
                    <th class="resipi_detail">詳細</th>
                </tr>
                <c:forEach var="myresipi" items="${myresipis}" varStatus="status">
                <td><c:out value="${myresipi.id}" /></td>
                <td><c:out value="${myresipi.title}" /></td>
                <td><c:out value="${myresipi.coments}" /></td>
                <td class="report_action">
                <a href="<c:url value='/myresipis/show?id=${myresipi.id}' />">詳細を見る</a></td>
                <tr>
                </c:forEach>
            </tbody>
        </table>
        <div id="pagination">
            （全 ${myresipis_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((myresipis_count - 1) / 10) + 1}"
                step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                       <a href="<c:url value='/myresipis/index?page=${i}' />"><c:out
                                value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <br/>
        <div class="create_btn">
            <a href="<c:url value='/myresipis/new' />">新規レシピの登録</a>
            </div>
    </c:param>
</c:import>