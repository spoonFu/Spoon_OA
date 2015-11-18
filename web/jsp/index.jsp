<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/include.jsp" %>
<html>
<head lang="en">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="${rootUrl}asset/css/bootstrap.min.css">
    <link rel="stylesheet" href="${rootUrl}asset/css/default.css">
    <link rel="stylesheet" href="${rootUrl}asset/css/font-awesome.min.css">
    <link rel="stylesheet" href="${rootUrl}asset/clock/clock.css">
    <title>首页</title>
</head>
<body>
<%@include file="header.jsp" %>
<div id="wrapper">
    <%@include file="sidebar.jsp" %>
    <div id="mainbody" class="container-fluid">
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading"><h4 class="panel-title">个人考勤</h4></div>
                <div class="panel-body">
                    <div class="col-md-3">
                        <div class="calendar">
                            <div class="day">星期四</div>
                            <div class="date">4</div>
                            <div class="year">2015 六月</div>
                        </div>
                    </div>
                    <div class="col-md-9 check-work">
                        <table>
                            <tr>
                                <td>上班 <span id="signintime">08:00</span></td>
                                <td>
                                    <button class="btn btn-primary signin">签到</button>
                                </td>
                            </tr>
                            <tr>
                                <td>下班 <span id="signouttime">17:00</span></td>
                                <td>
                                    <button class="btn btn-primary signout" style="display: none;">签退</button>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-6 chat-panel">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#FuShaoxing" data-toggle="tab">付韶兴</a></li>
                <li><a href="#LiLiei" data-toggle="tab">李雷</a></li>
                <li><a href="#HanMeimei" data-toggle="tab">韩梅梅</a></li>
                <li class="close"><span class="fa fa-close" title="删除当前聊天"></span></li>
            </ul>
            <div class="tab-content chat-content">
                <div class="tab-pane fade in active" id="FuShaoxing">
                    <div class="chat-conv">
                        <img class="img-rounded" src="imgs/headIcon.jpg">

                        <div class="chat-box">你好啊</div>
                    </div>
                    <div class="chat-conv myself">
                        <img class="img-rounded" src="imgs/headIcon.jpg">

                        <div class="chat-box">你是谁？</div>
                    </div>
                    <div class="chat-conv">
                        <img class="img-rounded" src="imgs/headIcon.jpg">

                        <div class="chat-box">你猜一下</div>
                    </div>
                </div>
                <div class="tab-pane fade" id="LiLiei">
                    <div class="chat-conv">
                        <img class="img-rounded" src="imgs/headIcon.jpg">

                        <div class="chat-box">很高兴认识你</div>
                    </div>
                    <div class="chat-conv myself">
                        <img class="img-rounded" src="imgs/headIcon.jpg">

                        <div class="chat-box">谢谢，今天晚饭吃的什么？</div>
                    </div>
                    <div class="chat-conv">
                        <img class="img-rounded" src="imgs/headIcon.jpg">

                        <div class="chat-box">小鸡炖蘑菇。。。。。方便面</div>
                    </div>
                </div>
                <div class="tab-pane fade" id="HanMeimei">
                    <div class="chat-conv">
                        <img class="img-rounded" src="imgs/headIcon.jpg">

                        <div class="chat-box">工作顺利吗？</div>
                    </div>
                    <div class="chat-conv myself">
                        <img class="img-rounded" src="imgs/headIcon.jpg">

                        <div class="chat-box">还可以，不过最近肩膀很疼。</div>
                    </div>
                    <div class="chat-conv">
                        <img class="img-rounded" src="imgs/headIcon.jpg">

                        <div class="chat-box">那可要多注意休息啊。</div>
                    </div>
                    <div class="chat-conv myself">
                        <img class="img-rounded" src="imgs/headIcon.jpg">

                        <div class="chat-box">我会的，谢谢关心。</div>
                    </div>
                </div>
            </div>
            <div class="chat-send input-group">
                <input class="form-control" type="text" placeholder="发送内容">
                <span class="input-group-btn">
                    <button class="btn btn-primary">发送</button>
                </span>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${rootUrl}asset/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${rootUrl}asset/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${rootUrl}asset/js/jquery.slimscroll.min.js"></script>
<script type="text/javascript" src="${rootUrl}asset/js/main.js"></script>
</body>
</html>