<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<%@ taglib uri="/tags/spoon" prefix="spoon" %>
<html>
<head lang="en">
    <%@include file="common/stylesheet.jsp"%>
    <title>首页</title>
</head>
<body>
<%@include file="common/header.jsp" %>
<div id="wrapper">
    <%@include file="common/sidebar.jsp" %>
    <div id="mainbody" class="container-fluid">
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading"><h4 class="panel-title">个人考勤</h4></div>
                <div class="panel-body">
                    <div class="col-md-3">
                        <div class="calendar">
                            <div class="day">星期四</div>
                            <div class="date">4</div>
                            <div class="year">2015 六月</div>
                        </div>
                    </div>
                    <div class="col-md-9 check-work">
                        <table>
                            <tr>
                                <td>上班 <span id="signintime">${StartTime}</span></td>
                                <td>
                                    <c:if test="${!empty cw.signIn}"><a id="signin" class="<c:if test="${cw.late}">no</c:if><c:if test="${!cw.late}">ok</c:if>">${cw.signIn}</a><a class="ip">${cw.signInIp}</a></c:if>
                                    <button class="btn btn-primary signin" style="display: <c:if test="${empty cw.signIn}">block</c:if><c:if test="${!empty cw.signIn}">none</c:if>">签到</button>
                                </td>
                            </tr>
                            <tr>
                                <td>下班 <span id="signouttime">${EndTime}</span></td>
                                <td>
                                    <c:if test="${!empty cw.signOut}"><a id="signout" class="<c:if test="${cw.early}">no</c:if><c:if test="${!cw.early}">ok</c:if>">${cw.signOut}</a><a class="ip">${cw.signOutIp}</a></c:if>
                                    <button class="btn btn-primary signout"  style="display: <c:if test="${(!empty cw.signIn)&&(empty cw.signOut)}">block</c:if><c:if test="${(empty cw.signIn)||(!empty cw.signOut)}">none</c:if>">签退</button>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="common/webIm.jsp" %>
<%@include file="common/footer.jsp" %>
<script type="text/javascript" src="${rootUrl}asset/js/index.js"></script>
</body>
</html>