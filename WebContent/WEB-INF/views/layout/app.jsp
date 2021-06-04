<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ja">
<head>${param.header}
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</head>
<body>

    <div id="wrapper">
        <div id="header">
                <div class="title" >
                    <a href="<c:url value='/'/>">まいにちレシピ</a>
                </div>
                           <div id="header-menu">
                <div id="login">
                    <c:choose>
                        <c:when test="${sessionScope.login_user !=null }">
                            <a href="<c:url value='/logout' />">ログアウト</a>
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value='/login' />">ログイン</a>
                        </c:otherwise>
                    </c:choose>
                    </div>
                    &nbsp;&nbsp;
                    <div id="new">
                            <a href="<c:url value='/users/new'/>">新規登録</a>
                    </div>
                    &nbsp;&nbsp;
                    <div id="faq"><a>FAQ</a></div>
            </div>
        </div>
        <div id="content">${param.content}</div>
        <div id="footer">by MAI FUKUOKA.</div>
    </div>


</body>
</html>