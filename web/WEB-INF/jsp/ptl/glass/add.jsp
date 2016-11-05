<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/jsp/common/include.jsp" %>
<!--文章添加-->
<div class="spoon-panel">
  <!-- 添加面板 -->
  <div class="panel panel-default">
    <div class="panel-heading panel-closable">
      <span class="panel-title">眼镜添加</span>
        <span class="tools">
            <a class="fa fa-remove remove"></a>
            <a class="fa fa-refresh"></a>
        </span>
    </div>
    <div class="panel-body">
      <!-- 表单 -->
      <form id="addform" class="form-horizontal" modelAttribute="pojomodel" action="add.do" method="post"
            role="form">
        <textarea hidden="hidden" name="content" id="articlecontent"/>
        <div class="form-group">
          <label class="col-sm-2 control-label" for="menu1">主菜单</label>

          <div class="col-sm-4">
            <select id="menu1" name="nav.id" class="form-control">
              <c:forEach items="${navs}" var="nav">
                <option value="${nav.id}">${nav.name}</option>
              </c:forEach>
            </select>
          </div>
          <!-- 标题 -->
          <label class="col-sm-1 control-label" for="title">标题</label>

          <div class="col-sm-4">
            <input type="text" class="form-control" id="title" name="title" placeholder="标题"/>
          </div>
        </div>
        <!-- 内容 -->
        <div class="form-group">
          <label class="col-sm-2 control-label" for="editor">内容</label>
          <div class="col-sm-9">
            <div id="editor"></div>
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
<script type="text/javascript">
  // 初始化富文本编辑器
  $('#editor').summernote({
    height: 500,
    disableDragAndDrop: true,// 禁止拖拽文件
    onInit: function(){
      // bootstrap下拉生效
      $("#addform .dropdown-toggle").dropdown().click(function(){
        $(this).dropdown()
      });
    },
    onChange: function(){
      $("#articlecontent").val($('#editor').code());
    }
  });
</script>