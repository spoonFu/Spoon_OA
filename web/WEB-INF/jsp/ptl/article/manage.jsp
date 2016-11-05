<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<%@ taglib uri="/tags/spoon" prefix="spoon"%>
<html>
<head lang="en">
    <%@include file="/WEB-INF/jsp/common/stylesheet.jsp"%>
    <link rel="stylesheet" href="${rootUrl}asset/summernote/summernote.css">
    <title>付小勺OA</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/header.jsp" %>
<div id="wrapper">
    <%@include file="/WEB-INF/jsp/common/sidebar.jsp" %>
    <div id="mainbody" class="container-fluid">
        <%@include file="/WEB-INF/jsp/common/bodyhead.jsp" %>
        <!-- 内容 -->
        <div id="content">
            <!-- 管理面板开始 -->
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">文章管理</h3>
                </div>
                <div class="panel-body">
                    <!-- 查询表单开始 -->
                    <form class="form-inline query-form" modelAttribute="condition" action="manage.do" method="post" role="form">
                        <div class="form-group">
                            <label for="navid">菜单</label>
                            <select id="navid" name="navid" class="form-control">
                                <option value=""></option>
                                <c:forEach items="${navs}" var="nav">
                                    <option value="${nav.id}">${nav.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="btn-group">
                            <a class="btn btn-primary query-btn">查询</a>
                            <a class="btn btn-default spoon-btn" spoonhref="add.do">添加</a>
                        </div>
                        <div class="pagesize">
                            <label class="control-label">显示：</label>
                            <select id="rowSize" name="rowSize" class="input-sm">
                                <option value="10">10</option>
                                <option value="20">20</option>
                                <option value="30">30</option>
                            </select>
                        </div>
                    </form>
                    <!-- 查询表单结束 -->
                    <!-- 数据展示表开始 -->
                    <%@ include file="/WEB-INF/jsp/ptl/article/result.jsp"%>
                    <!-- 数据展示表结束 -->
                </div>
            </div>
            <!-- 面板结束 -->
        </div>
    </div>
</div>
<%@include file="/WEB-INF/jsp/common/webIm.jsp" %>
<%@include file="/WEB-INF/jsp/common/footer.jsp" %>
<script type="text/javascript" src="${rootUrl}asset/js/spoonpanel.js"></script>;
<script type="text/javascript" src="${rootUrl}asset/summernote/summernote.min.js"></script>
</body>
</html>