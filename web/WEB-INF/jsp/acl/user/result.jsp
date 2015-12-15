<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<%--
  ~ Copyright (c) 2015 by FuShaoxing. All right reserved.
  --%>
<!-- 错误提示框 -->
<c:if test="${result=='error'}">
    <div class="alert alert-danger alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert">
            <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
        </button>
        <strong>Warning!</strong><br />${resultMsg}
    </div>
</c:if>
<div class="table-responsive" id="result-div">
    <table class="table data-table table-hover">
        <thead>
        <tr>
            <th data-field="name,chinese" style="width:25%;">姓名</th>
            <th data-field="username" style="width:15%;">登录名</th>
            <th data-field="dept.name" style="width:15%;">部门</th>
            <th data-field="male" style="width:10%;">性别</th>
            <th data-field="phone" style="width:20%;">联系方式</th>
            <th class="disabled" style="width:15%;">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pagn.result}" var="user" varStatus="userindex">
            <tr>
                <td style="text-align:left;">${user.name}</td>
                <td>${user.username}</td>
                <td>${user.dept.name}</td>
                <c:if test="${user.male}">
                    <td>男</td>
                </c:if>
                <c:if test="${!user.male}">
                    <td>女</td>
                </c:if>
                <td>${user.phone}</td>
                <td class="handle">
                    <sec:authorize ifAnyGranted="${jspAuthorities['eval_order_mod']}">
                        <a class="spoon-btn" spoonhref="mod.do?id=${user.id}"><span
                                class="fa fa-edit"></span></a>
                    </sec:authorize>
                    <a class="spoon-btn" title="修改" spoonhref="mod.do?id=${user.id}"><span
                            class="fa fa-edit"></span></a>
                    <a class="del-btn" title="删除" delhref="del.do?id=${user.id}" delname="${user.name}"><span
                            class="fa fa-trash-o"></span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="table-footer">
        <div class="page-info col-sm-4">Showing
            <c:if test="${pagn.pageSize==0}"></c:if><c:if test="${pagn.pageSize!=0}"><a>${pagn.startNum+1}</a>
                to <a>${pagn.startNum+fn:length(pagn.result)}</a> of </c:if><a>${pagn.totalCount}</a> entries
        </div>
        <div class="page col-sm-8" pagesize="${pagn.pageSize}" pagenum="${pagn.pageNum}"></div>
    </div>
</div>