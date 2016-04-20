<%--
  ~ Copyright (c) 2016 by FuShaoxing. All right reserved.
  --%>

<%--
  Created by IntelliJ IDEA.
  User: FuShaoxing
  Date: 2016/4/20
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<div class="spoon-panel" style="opacity: 0;">
  <!-- 添加面板 -->
  <div class="panel panel-default">
    <div class="panel-heading panel-closable">
      <span class="panel-title">用户配置</span>
        <span class="tools">
            <a class="fa fa-remove remove"></a>
            <a class="fa fa-refresh"></a>
        </span>
    </div>
    <div class="panel-body">
      <form id="confform" class="form-horizontal" modelAttribute="pojomodel" action="conf.do" method="post"
            role="form">

      </form>
    </div>
  </div>
</div>