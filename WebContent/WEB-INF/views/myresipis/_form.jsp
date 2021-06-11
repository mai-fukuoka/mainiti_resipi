<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" />
            <br />
        </c:forEach>
        ​
    </div>
</c:if>
<div class="resipi_title">
    <label for="title">料理名</label><br /> <input type="text" size="20"
        name="title" value="${myresipi.title }">
</div>
<br />
​
<div class="materials">
    <label for="materials">材料</label><br />
    <textarea name="materials" rows="10" cols="50">${myresipi.materials}</textarea>
</div>
​<div style="width:50%; height:50%;">
<div class="content" >
    <label for="content">作り方</label><br />
    <textarea name="content" rows="10" cols="50">${myresipi.content}</textarea>
</div>
</div>
​
<div class="resipi_coments">
    <label for="coments">コメント</label><br /> <input type="text"
        name="coments" style="width: 100%;" value="${myresipi.coments}">
</div>
<br />
<div class="input_btn">
    <input type="hidden" name="_token" value="${_token}" /> <input
        type="hidden" name="myresipi_id" value="${myresipi.id}" /> <input
        type="hidden" name="userid" value="abc" />
    <button type="submit">投稿</button>
</div>