<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
   <c:param name="header">
        <meta charset="UTF-8">
        <title>まいにちレシピ</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
   </c:param>
<c:param name="content">
<div class="imageA">
        <img src="images/2483944.jpg" alt="料理のイラスト"width="613" height="460">
    </div>
    <br><br>
    <div class="menu">
    <div class="kaimonolists">
    <a href="<c:url value='/kaimonolists/index' />"><img class="imageA" src="images/152227.jpg" alt="買い物リスト"width="200" height="200"  ></a>
    </div>
    <div class="zairyoulists">
    <a href="<c:url value='/zairyoulists/index' />"><img class="imageC" src="images/2136715.png" alt="食材リスト"width="200" height="200"></a>
    </div>
    <div class="myresipi">
    <a href="<c:url value='/myresipis/index' />"><img class="imageB" src="images/757688.jpg" alt="Myレシピ"width="200" height="200"  ></a>
    </div>
    </div>
    </c:param>

</c:import>