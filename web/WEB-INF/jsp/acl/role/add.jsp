<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<%--
  ~ Copyright (c) 2015 by FuShaoxing. All right reserved.
  --%>

<!--文章添加-->
<div class="spoon-panel">
    <!-- 添加面板 -->
    <div class="panel panel-default">
        <div class="panel-heading panel-closable">
            <span class="panel-title">角色添加</span>
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
                    <label class="col-sm-2 control-label" for="name">名称</label>

                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name" name="name" placeholder="名称"/>
                    </div>

                    <label class="col-sm-2 control-label" for="desc">描述</label>

                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="desc" name="desc" placeholder="描述"/>
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