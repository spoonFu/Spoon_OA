<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
	<head>
		<title>NO RIGHT!</title>
		
	</head>
	<body>
		<div style="text-align: center">
			<a>您无权访问当前页面！</a>
			<br/><br/>
			<a href="#" onclick="history.go(-1);" style="font-size: 20px;font-weight: bold;font-family: 黑体;">
				请点此返回上一页面
			</a>
			<br/><br/>
			<a href="${rootUrl}welcome.service"  style="font-size: 20px;font-weight: bold;font-family: 黑体;">
				请点此重新登录系统
			</a>
			</div>
	</body>
</html>