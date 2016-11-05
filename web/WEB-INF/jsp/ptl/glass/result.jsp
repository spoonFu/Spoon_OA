<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<div class="table-responsive" id="result-div">
    <table class="table data-table table-hover">
        <!-- <caption>标题</caption> -->
        <thead>
        <tr>
            <th data-field="product.name,chinese" style="">名称</th>
            <th data-field="style" style="">样式</th>
            <th data-field="material" style="">材质</th>
            <th data-field="brand" style="">品牌</th>
            <th data-field="shape" style="">镜框形状</th>
            <th data-field="price" style="">价格</th>
            <th class="disabled" style="">颜色</th>
            <th class="disabled" style="">宽度</th>
            <th class="disabled" style="width:15%;">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pagn.result}" var="glass" varStatus="index">
            <tr>
                <td style="text-align:left;">${glass.product.name}</td>
                <td><spoon:dict dictname="glass.style" key="${glass.style}" /></td>
                <td><spoon:dict dictname="glass.material" key="${glass.material}" /></td>
                <td>${glass.brand}</td>
                <td>${glass.shape}</td>
                <td>${glass.price}</td>
                <td>${glass.color}</td>
                <td>${glass.width}</td>
                <td class="handle">
                    <sec:authorize ifAnyGranted="${jspAuthorities['eval_order_mod']}">
                        <a class="spoon-btn" spoonhref="mod.do?id=${glass.id}"><span
                                class="fa fa-edit"></span></a>
                    </sec:authorize>
                    <a class="spoon-btn" title="修改" spoonhref="mod.do?id=${glass.id}"><span
                            class="fa fa-edit"></span></a>
                    <a class="del-btn" title="删除" delhref="del.do?id=${glass.id}"><span
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