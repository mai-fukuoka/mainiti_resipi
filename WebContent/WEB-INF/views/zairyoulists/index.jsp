<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../layout/app.jsp">
    <c:param name="header">
        <meta charset="UTF-8">
        <title>食材リスト</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
        <link rel="stylesheet" href="<c:url value='/css/kaimonolists.css' />">
    </c:param>
    <c:param name="content">
        <div class="name">
            <h3>食材リスト</h3>
        </div>
        <div id="list-add-area">
            <input id="list-input-area" type="text" placeholder="what to buy">
            <span class="add-btn">add</span>
        </div>

        <form method="POST" action="<c:url value='/zairyoulists/create' />">

            <ul class="lists">
                <c:forEach var="zairyoulist" items="${zairyoulists}">
                    <li class="parent list-item"><c:out
                            value="${zairyoulist.ingredient}" /> <span class="close">×</span>
                        <input type="hidden" name="todoData"
                        value="${zairyoulist.ingredient }"> <input type="hidden"
                        name="isTodoClick" value="0"></li>
                </c:forEach>

            </ul>
            <br />
            <div id="pagination">
                （全 ${zairyoulists_count} 件）
                <c:forEach var="i" begin="1"
                    end="${((zairyoulists_count - 1) / 9) + 1}" step="1">
                    <c:choose>
                        <c:when test="${i == page}">
                            <c:out value="${i}" />&nbsp;
                    </c:when>
                        <c:otherwise>
                            <a href="<c:url value='/zairyoulists/index?page=${i}' />"><c:out
                                    value="${i}" /></a>&nbsp;
                    </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>

            <input type="hidden" name="_token" value="${_token}" /> <input
                type="hidden" name="userid" value="abc" />
            <button type="submit" id="create" class="button">更新</button>
        </form>
        <br />
        <form method="POST" action="<c:url value='/zairyoulists/destroy'  />">
            <input type="hidden" name="_token" value="${_token}" /> <input
                type="hidden" name="userid" value="abc" />

            <button type="submit" class="button">全て削除</button>
        </form>
    </c:param>
</c:import>
<!-- TODO:追加 -->
<script src="<c:url value='/js/index.js' />"></script>
