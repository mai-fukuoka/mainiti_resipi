<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ja">
<head>${param.header}
</head>
<body>

    <div id="wrapper">
        <div id="header">
                <div class="title" >
                    <a href="<c:url value='/'/>">まいにちレシピ</a>
                </div>
                           <div id="header-menus">
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
            </div>
        </div>
        <div id="content">${param.content}</div><br/><br/>
        <div id="footer">by MAI FUKUOKA.</div>
    </div>


</body>
</html>