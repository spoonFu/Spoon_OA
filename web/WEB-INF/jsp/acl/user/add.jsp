<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<!--文章添加-->
<div class="spoon-panel">
    <!-- 添加面板 -->
    <div class="panel panel-default">
        <div class="panel-heading panel-closable">
            <span class="panel-title">用户添加</span>
        <span class="tools">
            <a class="fa fa-remove remove"></a>
            <a class="fa fa-refresh"></a>
        </span>
        </div>
        <div class="panel-body">
            <!-- 表单 -->
            <form id="addform" class="form-horizontal" modelAttribute="pojomodel" action="add.do" method="post"
                  role="form">
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="username">用户名</label>

                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="username" name="username" placeholder="用户名"/>
                    </div>
                    <!-- 标题 -->
                    <label class="col-sm-1 control-label" for="password">密码</label>

                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="password" name="password" placeholder="密码"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label" for="name">姓名</label>

                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name" name="name" placeholder="姓名"/>
                    </div>
                    <!-- 标题 -->
                    <label class="col-sm-1 control-label" for="male">性别</label>

                    <div class="col-sm-4">
                        <select id="male" name="male" class="form-control">
                            <option value="1">男</option>
                            <option value="0">女</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label" for="phone">联系方式</label>

                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="phone" name="phone" placeholder="联系方式"/>
                    </div>
                    <!-- 标题 -->
                    <label class="col-sm-1 control-label" for="email">邮箱</label>

                    <div class="col-sm-4">
                        <input type="email" class="form-control" id="email" name="email" placeholder="邮箱"/>
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
</div>