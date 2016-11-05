/**
 * Created by Administrator on 2015/9/12.
 */
(function ($) {
    /**数据地址**/
    var socketUrl = "spoon.chat";
    var webName = document.location.pathname.split("/")[1];
    var rootUrl = window.location.host + "/" + webName + "/";
    var usersUrl = "/"+webName+"/acl/user/userList.ajax";
    var imMsgUrl = "/"+webName+"/getImMsg.ajax";
    /*****表情字典*****/
    var faceDict =
    {
        '[xkl拜年]': '<img src="/'+webName+'/imgs/face-xkl/xklbainian_org.gif">',
        '[xkl恭喜]': '<img src="/'+webName+'/imgs/face-xkl/xklgongxi_org.gif">',
        '[xkl发财]': '<img src="/'+webName+'/imgs/face-xkl/xklfacai_org.gif">',
        '[xkl鞭炮]': '<img src="/'+webName+'/imgs/face-xkl/xklbianpao_org.gif">',
        '[xkl下雪]': '<img src="/'+webName+'/imgs/face-xkl/xklxiaxue_org.gif">',
        '[xkl撒花]': '<img src="/'+webName+'/imgs/face-xkl/xklsahua_org.gif">',
        '[xkl扔糖豆]': '<img src="/'+webName+'/imgs/face-xkl/xklrengtangdou_org.gif">',
        '[xkl扭]': '<img src="/'+webName+'/imgs/face-xkl/xklniu_org.gif">',
        '[xkl你拍一]': '<img src="/'+webName+'/imgs/face-xkl/xklnipaiyi_org.gif">',
        '[xkl打岔]': '<img src="/'+webName+'/imgs/face-xkl/xkldacha_org.gif">',
        '[dada搬糖豆]': '<img src="/'+webName+'/imgs/face-xkl/xklbanyun2_org.gif">',
        '[xkl搬糖豆]': '<img src="/'+webName+'/imgs/face-xkl/xklbanyun1_org.gif">',
        '[dada转圈]': '<img src="/'+webName+'/imgs/face-xkl/dadazhuanquan_org.gif">',
        '[dada秧歌]': '<img src="/'+webName+'/imgs/face-xkl/dadayangge_org.gif">',
        '[dada提灯笼]': '<img src="/'+webName+'/imgs/face-xkl/dadadenglong_org.gif">',
        '[xkl追]': '<img src="/'+webName+'/imgs/face-xkl/xklzhui_org.gif">',
        '[xkl拥抱]': '<img src="/'+webName+'/imgs/face-xkl/xklyongbao_org.gif">',
        '[xkl亲亲]': '<img src="/'+webName+'/imgs/face-xkl/xklqinqin_org.gif">',
        '[xkl困]': '<img src="/'+webName+'/imgs/face-xkl/xklkun_org.gif">',
        '[xkl达达喜欢]': '<img src="/'+webName+'/imgs/face-xkl/xkldadaxihuan_org.gif">',
        '[xkl达达吐舌头]': '<img src="/'+webName+'/imgs/face-xkl/xkldadatushetou_org.gif">',
        '[xkl达达坏笑]': '<img src="/'+webName+'/imgs/face-xkl/xkldadahuaixiao_org.gif">',
        '[xkl达达黑暗]': '<img src="/'+webName+'/imgs/face-xkl/xkldadaheian_org.gif">',
        '[xkl吃西瓜]': '<img src="/'+webName+'/imgs/face-xkl/xklchixigua_org.gif">',
        '[kxl晕]': '<img src="/'+webName+'/imgs/face-xkl/kxlyun_org.gif">',
        '[xkl抓狂]': '<img src="/'+webName+'/imgs/face-xkl/xklzhuakuang_org.gif">',
        '[xkl眨眼]': '<img src="/'+webName+'/imgs/face-xkl/xklzhayan_org.gif">',
        '[xkl摇尾巴]': '<img src="/'+webName+'/imgs/face-xkl/xklyaoweiba_org.gif">',
        '[xkl偷看]': '<img src="/'+webName+'/imgs/face-xkl/xkltoukan_org.gif">',
        '[xkl糖豆]': '<img src="/'+webName+'/imgs/face-xkl/xkltangdou_org.gif">',
        '[xkl囧]': '<img src="/'+webName+'/imgs/face-xkl/xkljiong_org.gif">',
        '[xkl抚摸]': '<img src="/'+webName+'/imgs/face-xkl/xklfumo_org.gif">',
        '[xkl奔跑]': '<img src="/'+webName+'/imgs/face-xkl/xklbenpao_org.gif">',
        '[xkl被抓]': '<img src="/'+webName+'/imgs/face-xkl/xklbeizhua_org.gif">',
        '[xkl被电]': '<img src="/'+webName+'/imgs/face-xkl/xklbeidian_org.gif">',
        '[xkl怒火]': '<img src="/'+webName+'/imgs/face-xkl/xlknuhuo_org.gif">',
        '[xkl转圈]': '<img src="/'+webName+'/imgs/face-xkl/xklzhuanquan_org.gif">',
        '[xkl喜]': '<img src="/'+webName+'/imgs/face-xkl/xklxi_org.gif">',
        '[xkl委屈]': '<img src="/'+webName+'/imgs/face-xkl/xklweiqu_org.gif">',
        '[xkl石化]': '<img src="/'+webName+'/imgs/face-xkl/xklshihua_org.gif">',
        '[xkl期待]': '<img src="/'+webName+'/imgs/face-xkl/xklqidai_org.gif">',
        '[xkl捏脸]': '<img src="/'+webName+'/imgs/face-xkl/xklnielian_org.gif">',
        '[xkl路过]': '<img src="/'+webName+'/imgs/face-xkl/xklluguo_org.gif">',
        '[xkl哈哈哈]': '<img src="/'+webName+'/imgs/face-xkl/xklhahaha_org.gif">',
        '[xkl顶]': '<img src="/'+webName+'/imgs/face-xkl/xklding_org.gif">'
    }
    // 聊天初始化
    var init = function () {
        $.ajax({
            type: "GET",
            async: true,
            url: usersUrl,
            dataType: "json",
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    var user = data[i];
                    var $userListUl = $(".chat-sidebar .user-list>ul");
                    $userListUl.append('<li data-pane="' + user.id + '"><div><img class="img-rounded" src="' + user.icon + '"></div><p>' + user.name + '</p></li>');
                }
                userListOpenListener();
            },
            error: function () {
                alert("聊天服务器连接失败!");
            }
        });
    };
    init();
    /**滚动条控制区**/
    $(".chat-sidebar .user-recent").slimScroll({
        height: '340px',
        width: '160px'
    });
    $(".chat-sidebar .user-lust>ul").slimScroll({
        height: '340px',
        width: '160px'
    });
    $(".chat-body").slimScroll({
        height: '320px',
        width: '400px'
    });
    /**最近联系人列表点击**/
    var recentUserOpenListener = function () {
        $(".chat-div .chat-sidebar .user-recent>li").click(function () {
            var $this = $(this);
            if ($this.hasClass("active")) {
                return;
            }
            $this.addClass("active").siblings().removeClass("active");
            // 去掉新消息通知
            $this.find(".dot").remove();
            var userId = $this.data("pane");
            // 当此用户的聊天面板存在时显示，不存在时创建并显示
            var $pane = $(".chat-body .chat-pane#" + userId);
            if ($pane.length == 1) {
                $pane.addClass("in").siblings().removeClass("in");
            } else {
                createChatPane(userId);
            }
            $(".chat-foot button").removeAttr("disabled");
            $(".chat-head .name").html($(this).find("p").html());
        });
    };
    recentUserOpenListener();
    var createChatPane = function (userId) {
        $(".chat-body .chat-pane").removeClass("in");
        var $pane = $('<div class="chat-pane in" id="' + userId + '"></div>');
        $(".chat-body").append($pane);
        $.ajax({
            type: 'GET',
            async: true,
            url: imMsgUrl,
            data: {'userId': userId},
            dataType: 'json',
            success: function (msgArray) {
                if (msgArray.length == 0) {
                    return;
                }
                for (var i = 0; i < msgArray.length; i++) {
                    var msg = msgArray[i].message;
                    msg = faceConvert(msg);
                    var msgDiv = '<div class="chat-conv"><img class="img-rounded" src="imgs/headIcon.jpg"><div class="chat-box">' + msg + '</div></div>';
                    $pane.append(msgDiv);
                }
            },
            error: function () {
                alert("聊天服务器连接失败!");
            }
        });
    }
    /**关闭某一联系人**/
    var recentUserCloseListener = function () {
        $(".chat-sidebar .user-recent > li > div > a").click(function () {
            var $li = $(this).closest("li");
            var userId = $li.data("pane");
            $("#" + userId).remove();
            $li.remove();
            $(".chat-foot button").attr("disabled", "disabled");
            $(".chat-head .name").html("");
        });
    };
    recentUserCloseListener();
    /**点击用户列表上拉或下拉按钮**/
    $(".chat-sidebar .user-list .pull-up,.chat-sidebar .user-list .pull-down").click(function () {
        var isUp = $(this).hasClass("pull-up");
        if (isUp) {
            $(".user-recent").parent().slideUp();
            $(this).removeClass("pull-up").addClass("pull-down");
            $(this).find("span").removeClass("fa-angle-double-up").addClass("fa-angle-double-down");
        } else {
            $(".user-recent").parent().slideDown();
            $(this).removeClass("pull-down").addClass("pull-up");
            $(this).find("span").removeClass("fa-angle-double-down").addClass("fa-angle-double-up");
        }
    });
    // TODO 是否考虑在对话pane超出一定数值后删除，点击时重新加载pane。否则页面元素会过多
    // 双击打开聊天框事件
    var userListOpenListener = function () {
        $(".chat-sidebar .user-list>ul>li").dblclick(function () {
            var userId = $(this).data("pane");
            var $userLi = $(".chat-sidebar .user-recent>li[data-pane='" + userId + "']");
            var $recentUserUl = $(".chat-sidebar .user-recent");
            // 如果对话已在最近联系人列表则前置，否则添加
            if ($userLi.length == 1) {
                $recentUserUl.prepend($userLi);
            } else {
                $userLi = $(this).clone(false).append('<div class="rfloat"><a>×</a></div>');
                $recentUserUl.prepend($userLi);
            }
            $(".chat-sidebar .user-list .pull-down").click();
            // 重新添加打开关闭事件
            recentUserOpenListener();
            recentUserCloseListener();
            $userLi.click();
        });
    }
    userListOpenListener();
    /**聊天面板显示**/
    $(".chat-ident").click(function () {
        $(".chat-panel").show();
    });
    /**聊天面板关闭**/
    $(".chat-panel .close").click(function () {
        $(".chat-panel").hide();
    });
    /**回车发送消息**/
    $(".chat-foot input").keydown(function (event) {
        if (event.keyCode == '13') {
            $(".chat-foot button").click();
        }
    });
    /**填充表情图片**/
    $(".chat-foot .face .chat-face>ul>li").each(function () {
        var text = $(this).data("text");
        $(this).append(faceDict[text]);
    });
    /**表情弹出**/
    $(".chat-foot .face").click(function () {
        $(this).toggleClass("open");
        $(".chat-foot input").focus();
    })
    /**将消息中的符号转为图片**/
    var faceConvert = function (msg) {
        for (var key in faceDict) {
            var nkey = key.replace('[', '\\[').replace(']', '\\]');
            msg = msg.replace(new RegExp(nkey, 'g'), faceDict[key]);
        }
        return msg;
    }
    /**点击某一个表情**/
    $(".chat-foot .chat-face li").click(function () {
        $(this).toggleClass("open");
        var $input = $(".chat-foot input");
        $input.val($input.val() + $(this).data("text"));
        $input.focus();
    });
    /**点击按钮发送消息**/
    $(".chat-foot button").click(function () {
        if ($(".chat-foot button").attr("disabled") == "disabled") {
            return;
        }
        var $input = $(".chat-foot input");
        var msg = $input.val();
        if (!msg)
            return;
        var $panelIn = $(".chat-body>.in");
        var flag = msgSend($panelIn.attr("id"), msg);
        msg = faceConvert(msg);
        if (!flag) {
            msg = msg+"(未发送成功!)";
        }
        var divStr = '<div class="chat-conv myself"><img class="img-rounded" src="imgs/headIcon.jpg"><div class="chat-box">' + msg + '</div></div>';
        $panelIn.append(divStr);
        /**当聊天框内记录数最大为100**/
        if ($panelIn.children().length > 10) {
            $panelIn.children(":first").remove();
        }
        /**保证滚动条在最下方**/
        $(".chat-body").slimScroll({
            scrollTo: '10000000px'
        });
        $input.val("");
    });
    /**当收到新消息后给用户对应提示**/
    var newMsg = function (userId) {
        var $userListUl = $(".chat-sidebar .user-list>ul");
        var $recentUserLi = $(".chat-sidebar .user-recent>li[data-pane='" + userId + "']");
        var $recentUserUl = $(".chat-sidebar .user-recent");
        if ($recentUserLi.length == 1) {
            if (!$recentUserLi.hasClass("active") && $recentUserLi.find(".dot").length == 0) {
                $recentUserLi.append('<span class="dot"></span>');
            }
            $recentUserUl.prepend($recentUserLi);
        } else {
            var $userLi = $userListUl.find("li[data-pane='" + userId + "']").clone(false)
                .append('<div class="rfloat"><a>×</a></div>').append('<span class="dot"></span>');
            $recentUserUl.prepend($userLi);
        }
        // 重新添加打开关闭事件
        recentUserOpenListener();
        recentUserCloseListener();
    }
    /**********初始化websocket服务器************/
    var websocket;
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://" + rootUrl + socketUrl);
    } else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://" + rootUrl + socketUrl);
    } else {
        websocket = new SockJS("http://" + rootUrl + "sockjs/" + socketUrl);
    }
    websocket.onopen = function (event) {
        console.log("即时通信服务器开启!");
    };
    websocket.onmessage = function (event) {
        var msgArray = JSON.parse(event.data);
        if (msgArray.length == 0) {
            return;
        }
        var userId = msgArray[0]['fromUser']['id'];
        for (var i = 0; i < msgArray.length; i++) {
            var msg = msgArray[i].message;
            msg = faceConvert(msg);
            var msgDiv = '<div class="chat-conv"><img class="img-rounded" src="imgs/headIcon.jpg"><div class="chat-box">' + msg + '</div></div>';
            $(".chat-content .chat-body>#" + userId).append(msgDiv);
        }
        newMsg(userId);
        /**保证滚动条在最下方**/
        $(".chat-body").slimScroll({
            scrollTo: '10000000px'
        });
    };
    websocket.onerror = function (event) {
        alert("即时通信服务器异常!");
        websocket = new WebSocket("ws://" + rootUrl + socketUrl);
    };
    websocket.onclose = function (event) {
        console.log("即时通信服务器关闭!");
        websocket = new WebSocket("ws://" + rootUrl + socketUrl);
    };
    function msgSend(id, msg) {
        var msgObj = new Object();
        msgObj.toUser = {"id": id};
        msgObj.message = msg;
        try{
            websocket.send(JSON.stringify(msgObj));
            return true;
        }catch (e){
            console.error(e.message);
            return false;
        }
    }
})(jQuery);