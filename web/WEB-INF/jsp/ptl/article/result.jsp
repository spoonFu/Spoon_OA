<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<div class="table-responsive" id="result-div">
    <table class="table data-table table-hover">
        <!-- <caption>标题</caption> -->
        <thead>
        <tr>
            <!-- <th></th> -->
            <th data-field="title,chinese" style="width:30%;">标题</th>
            <th data-field="nav.name,chinese" style="width:10%;">菜单</th>
            <th data-field="createtime" style="width:15%;">创建日期</th>
            <th data-field="author.name,chinese" style="width:10%;">创建人</th>
            <th data-field="visible" style="width:10%;">可见</th>
            <th class="disabled" style="width:15%;">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pagn.result}" var="article" varStatus="atcindex">
            <tr>
                <%-- <td>${atcindex.count}</td> --%>
                <td style="text-align:left;">${article.title}</td>
                <td>${article.nav.name}</td>
                <td>${fn:substring(article.createtime,0,10)}</td>
                <td>${article.author.name}</td>
                <c:if test="${article.visible}">
                    <td>是</td>
                </c:if>
                <c:if test="${!article.visible}">
                    <td>否</td>
                </c:if>
                <td class="handle">
                    <sec:authorize ifAnyGranted="${jspAuthorities['eval_order_mod']}">
                        <a class="spoon-btn" spoonhref="mod.do?id=${article.id}"><span
                                class="fa fa-edit"></span></a>
                    </sec:authorize>
                    <a class="spoon-btn" title="修改" spoonhref="mod.do?id=${article.id}"><span
                            class="fa fa-edit"></span></a>
                    <a class="del-btn" title="删除" delhref="del.do?id=${article.id}" delname="${article.title}"><span
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