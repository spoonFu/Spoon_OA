<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<div class="spoon-panel" style="opacity: 0;">
    <!-- 添加面板 -->
    <div class="panel panel-default">
        <div class="panel-heading panel-closable">
            <span class="panel-title">用户修改</span>
        <span class="tools">
            <a class="fa fa-remove remove"></a>
            <a class="fa fa-refresh"></a>
        </span>
        </div>
        <div class="panel-body">
            <!-- 表单 -->
            <form id="modform" class="form-horizontal" modelAttribute="pojomodel" action="mod.do" method="post"
                  role="form">
                <input type="hidden" name="id" value="${pojomodel.id}" />
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="name">姓名</label>

                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name" name="name" value="${pojomodel.name}" placeholder="姓名"/>
                    </div>
                    <!-- 标题 -->
                    <label class="col-sm-1 control-label" for="male">性别</label>

                    <div class="col-sm-4">
                        <select id="male" name="male" class="form-control">
                            <option value="1" <c:if test="${pojomodel.male='1'}">selected="selected" </c:if>>男</option>
                            <option value="0" <c:if test="${pojomodel.male='0'}">selected="selected" </c:if>>女</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label" for="phone">联系方式</label>

                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="phone" name="phone" value="${pojomodel.phone}" placeholder="联系方式"/>
                    </div>
                    <!-- 标题 -->
                    <label class="col-sm-1 control-label" for="email">邮箱</label>

                    <div class="col-sm-4">
                        <input type="email" class="form-control" id="email" name="email" value="${pojomodel.email}" placeholder="邮箱"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label" for="phone">头像</label>

                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="icon" name="icon" value="${pojomodel.icon}" placeholder="头像"/>
                    </div>
                    <!-- 标题 -->
                    <label class="col-sm-1 control-label" for="email">有效期</label>

                    <div class="col-sm-4">
                        <div class="input-group">
                            <input type="text" class="form-control date-picker" id="deadline" name="deadline" value="${fn:substring(pojomodel.deadline, 0, 10)}" placeholder="有效期"/>
                            <span class="input-group-btn"><button type="button" class="btn btn-default"><i class="fa fa-calendar"/></button> </span>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-1 col-sm-offset-10">
                        <a class="btn btn-primary form-control add-btn">提交</a>
                    </div>
                </div>
            </form>
            <!-- 表单 -->
        </div>
    </div>
    <!-- 面板 -->
    <!-- 主体内容结束 -->
</div>