<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2 class="title">買い物リスト</h2>
        <div id="list-add-area">
            <input id="list-input-area" type="text" placeholder="what to buy">
            <span class="add-btn">add</span>
       </div>
       <form method="GET" action="<c:url value='/kaimonolists/create' />">
        <ul class="lists"></ul>
        <br/>
        <div id="pagination">
            （全 ${kaimonolists_count} 件）
            <c:forEach var="i" begin="1" end="${((reports_count - 1) / 12) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/kiamonolists/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>

            <input type="hidden" name="_token" value="${_token}" />
            <button type="submit" class="button">更新</button></form>
<br/>
            <form method="GET" action="<c:url value='/kaimonolists/destroy'  />">
            <input type="hidden" name="_token" value="${_token}" />
            <button type="submit" class="button">全て削除</button></form>

    </c:param>
</c:import>
<!-- TODO:追加 -->
<script src="<c:url value='/js/index.js' />"></script>
