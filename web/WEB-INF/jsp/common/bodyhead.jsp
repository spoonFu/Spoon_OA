<%@ page contentType="text/html;charset=utf-8" %>
<!-- 标题、面包屑导航栏 -->
<div class="content-head">
    <h2>${currentMenu.name}<a>${currentMenu.desc}</a></h2>
    <ul class="breadcrumb">
        <li>
            <span class="fa fa-home"></span>
            <a href="${rootUrl}/welcome.service">Home</a>
        </li>
        <c:forEach items="${breadcrumb}" var="li">
            <li><a href="<c:if test="${empty li.url}">#</c:if><c:if test="${!empty li.url}">${rootUrl}${li.url}</c:if>">${li.name}</a></li>
        </c:forEach>
    </ul>
</div>