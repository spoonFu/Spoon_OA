<%@ page contentType="text/html;charset=utf-8" %>
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="navbar-brand"><a href="#">付小勺</a></div>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">主页</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">测试一<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">test1</a></li>
                        <li><a href="#">test1</a></li>
                        <li><a href="#">test1</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">测试二<span class="caret"></span></a>
                    <ul class="dropdown-menu col-menu-2">
                        <li class="col-sm-6">
                            <ul>
                                <li class="dropdown-header"><span class="fa fa-group"></span>customers</li>
                                <li><a href="#">test1</a></li>
                                <li><a href="#">test1</a></li>
                                <li class="dropdown-header"><span class="fa fa-gear"></span>config</li>
                                <li><a href="#">test1</a></li>
                                <li><a href="#">test1</a></li>
                            </ul>
                        </li>
                        <li class="col-sm-6">
                            <ul>
                                <li class="dropdown-header"><span class="fa fa-group"></span>customers</li>
                                <li><a href="#">test1</a></li>
                                <li><a href="#">test1</a></li>
                                <li class="dropdown-header"><span class="fa fa-gear"></span>config</li>
                                <li><a href="#">test1</a></li>
                                <li><a href="#">test1</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="headIcon dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="${rootUrl}imgs/headIcon.jpg" class="img-rounded">
                        ${LoginName}
                        <span class="fa fa-sort-down"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">个人资料</a></li>
                        <li><a href="${rootUrl}logout.service">退出</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right notice">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="fa fa-envelope"></span><span
                            class="badge">3</span></a>
                    <ul class="dropdown-menu">
                        <div class="email-list">
                            <ul>
                                <li>
                                    <a href="#" title="xinyu2010@126.com">付韶兴</a>

                                    <p>今天我加班，不用等我吃饭了。</p>
                                    <span class="date">2 minites ago</span>
                                </li>
                                <li>
                                    <a href="#" title="xinyu2010@126.com">付韶兴</a>

                                    <p>由于今天身体不舒服需要请假一天，望批准。</p>
                                    <span class="date">3 days ago</span>
                                </li>
                                <li>
                                    <a href="#" title="xinyu2010@126.com">付韶兴</a>

                                    <p>附件是今年的工作总结，请查收。</p>
                                    <span class="date">1 year ago</span>
                                </li>
                            </ul>
                        </div>
                    </ul>
                </li>
                <li><a href="#"><span class="fa fa-cab"></span><span class="badge">5</span></a></li>
            </ul>
        </div>
    </div>
</div>
