/**
 * Created by Administrator on 2015/9/1.
 */
/*******聊天框******/

$(function () {
    var webName = document.location.pathname.split("/")[1];
    var seperator = "@#@";
    /**可以为div滚动条**/
    $(".email-list").slimScroll({
        height: '200px'
    });
    /******签到*******/
    $(".check-work .signin").click(function () {
        if ($(".check-work #signin").length > 0) {
            return;
        }
        var $this = $(this);
        $this.hide();
        ajaxget("/" + webName + "/adm/checkwork/sign.do", function (data) {
            var strs = data.split(seperator);
            var signintime = $(".check-work #signintime").text().replace(":", "");
            var ok = parseInt(signintime) > parseInt(strs[0].replace(":", ""));
            $("<a id='signin' class=\"" + (ok ? "ok" : "no") + "\">" + strs[0] + "</a><a class=\"ip\">" + strs[1] + "</a>").prependTo($this.parent());
            $(".check-work .signout").show();
        }, function () {
            $("<a style='color:red;'>签到失败...</a>").prependTo($this.parent());
        });
    });
    $(".check-work .signout").click(function () {
        if ($(".check-work #signout").length > 0) {
            return;
        }
        var $this = $(this);
        $this.hide();
        ajaxget("/" + webName + "/adm/checkwork/sign.do", function (data) {
            var strs = data.split(seperator);
            var signouttime = $(".check-work #signouttime").text().replace(":", "");
            var ok = parseInt(signouttime) < parseInt(strs[0].replace(":", ""));
            $("<a id='signout' class=\"" + (ok ? "ok" : "no") + "\">" + strs[0] + "</a><a class=\"ip\">" + strs[1] + "</a>").prependTo($this.parent());
        }, function () {
            $("<a style='color:red;'>签到失败...</a>").prependTo($this.parent());
        });
    });
    /** ajax **/
    function ajaxget(url, fn1, fn2) {
        $.ajax({
            type: "GET",
            async: true,
            url: url,
            dataType: "html",
            success: function (data) {
                if (undefined != fn1)
                    fn1(data);
            },
            error: function () {
                fn2();
                alert("请求失败!");
            }
        });
    }
});