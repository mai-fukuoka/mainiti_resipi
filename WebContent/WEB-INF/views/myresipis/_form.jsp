<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<div class="resipi_title">
<label for="title">料理名</label><br/>
<input type="text" name="title" value="${myresipi.title }"></div>

<!-- ここに画像を入れたい-->

<div class="ingresients">
<label for="ingredients">材料</label><br />
<input type="text" name="ingredients" value="${myresipi.ingredient }"></div>

<div class="content">
<label for="content">作り方</label><br />
<textarea name="content" rows="10" cols="50">${myresipi.content}</textarea></div>

<div class="resipi_coments">
<label for="coments">コメント</label><br/>
<input type="text" name="coments" value="${myresipi.coments }">
</div>

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>