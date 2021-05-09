<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
    <h2 class="title">買い物リスト</h2>
    <div id="list-add-area">
    <input id="list-input-area" type="text" placeholder="what to buy">
    <span class="add-btn">add</span>
    </div>
    <ul class="lists"></ul>
    <span class="update-btn"><a href="<c:url value='/kaimonolists/create' />">更新</a></span>
    <span class="destroy-btn"><a href="<c:url value='/kaimonolists/destroy' />">全て削除</a></span>
    </c:param>
    </c:import>