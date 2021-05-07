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
    <div id="update-btn">更新</div>
    <div id="destroy-btn">削除</div>
    </c:param>
    </c:import>