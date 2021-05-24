<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
   <c:param name="header">
        <meta charset="UTF-8">
        <title>買い物リスト</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
   </c:param>
<c:param name="content">
<div class="imageA">
        <img src="images/2483944.jpg" alt="料理のイラスト"width="613" height="460">
    </div>
    <br><br>
    <form method="POST" action="<c:url value='/kaimonolists/index' />">
    <div class="boxA">
    <img class="imageB" src="images/757688.png" alt="買い物リスト"width="162" height="100"  >
    <p >買い物リスト</p>
    </div></form>
    <div class="boxB">
    <img class="imageC" src="images/2136715.png" alt="食材リスト"width="109" height="148">
    </div>
    </c:param>

</c:import>
