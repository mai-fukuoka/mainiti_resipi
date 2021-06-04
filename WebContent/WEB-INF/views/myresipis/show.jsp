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
                <h3>Myレシピ　詳細</h3>

    <div class="title_box">
    <c:out value="${myresipi.title}"/>
    </div>

    <div class="materials_box">
    <table>
    <tbody>
    <tr>
    <th>材料</th></tr>
    <tr>
   <td><pre><c:out value="${myresipi.materials}"/></pre></td></tr>
    </tbody></table>

    </div>

    <div class="content_cox">
    <c:out value="${myresipi.content}" />
    </div>

    <div class="coments">
<c:out value="${myresipi.coments}"/>
</div><br/>
<p><a href="<c:url value='/myresipis/edit?id=${myresipi.id}' />">このレシピを編集する</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/myresipis/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>