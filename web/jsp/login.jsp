<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/jsp/include.jsp"%>
<html>
	<head>
		<title>登陆</title>
		<link rel="stylesheet" type="text/css" href="${rootUrl}css/bootstrap/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="${rootUrl}css/login.css">
	</head>
	<body>
	    <div class="container">
	      <form class="form-signin" role="form" action="j_spring_security_check" method="post">
	        <h2 class="form-signin-heading">SIGN IN</h2>
	        
	        <div class="input-group">
			  <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
			  <input id="j_username" name="j_username" autocomplete="off" type="text" class="form-control" placeholder="Username" value="${SPRING_SECURITY_LAST_USERNAME}" required autofocus>
			</div>
			
	        <div class="input-group">
			  <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
			  <input id="j_password" name="j_password" autocomplete="off" type="password" class="form-control" placeholder="Password" required>
			</div>
	        
	        <!-- 错误提示框 -->
	        <c:if test="${ErrorMsg!=null}">
		        <div class="alert alert-danger alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<strong>Warning!</strong><br />${ErrorMsg}
				</div>
	        </c:if>
	        <div class="checkbox">
	          <label>
	            <input type="checkbox" name="_spring_security_remember_me"> Remember me
	          </label>
	        </div>
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	      </form>
	      <div class="copyright">
	      	<a>xsdtitl.Com All Rights Reserved</a>
	      </div>
	    </div>
	    
		<script type="text/javascript" src="${rootUrl}js/jquery/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="${rootUrl}js/bootstrap/bootstrap.min.js"></script>
	</body>
</html>