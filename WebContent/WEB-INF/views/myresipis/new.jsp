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
    <h3>新規レシピ登録</h3>

    <form method="POST" action="<c:url value='/myresipis/create' />">
            <c:import url="_form.jsp" />
        </form>

        <p><a href="<c:url value='/myresipis/index' />">一覧に戻る</a></p>


    </c:param>
    </c:import>