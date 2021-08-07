<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="header">
        <meta charset="UTF-8">
        <title>Myレシピ</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
        <link rel="stylesheet" href="<c:url value='/css/myresipi.css' />">
    </c:param>
    <c:param name="content">
        <c:choose>
            <c:when test="${myresipi != null}">
                <h3 class="page_title">Myレシピ 詳細</h3>

                <div class="title_image_material">
                    <div class="title_images">
                        <div class="title_box">
                            <c:out value="${myresipi.title}" />
                        </div>
                        <br /> <img class="images"
                            src="${pageContext.request.contextPath}/show_image?id=${myresipi.file_id}">
                    </div>
                    <br />
                      <div class="material_image">
       <table class="materials_box">
    <tbody>
    <tr>
    <th>材料</th></tr>
    <tr>
   <td><pre><c:out value="${myresipi.materials}"/></pre></td></tr>
    </tbody></table>
</div>
                </div>
                <br />
                <table class="content_box">
                    <tbody>
                        <tr>
                            <th>作り方</th>
                        </tr>
                        <tr>
                            <td><pre style="white-space: pre-wrap ;">
                                    <c:out value="${myresipi.content}" />
                                </pre></td>
                        </tr>
                    </tbody>
                </table>
                <br />

                <table class="coments">
                    <tr>
                        <th>コメント</th>
                    </tr>
                    <tr>
                        <td>
                        <pre style="white-space: pre-wrap ;">
                        <c:out value="${myresipi.coments}" /></pre></td>
                    </tr>
                </table>

                <br />
                <p class="edit_btn">
                    <a href="<c:url value='/myresipis/edit?id=${myresipi.id}' />">このレシピを編集する</a>
                </p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p class="back_btn">
            <a href="<c:url value="/myresipis/index" />">一覧に戻る</a>
        </p>
    </c:param>
</c:import>