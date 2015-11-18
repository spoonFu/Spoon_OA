/**
 * Created by FuShaoxing on 2015/5/30.
 */
(function ($) {
    /************实时记录页面宽高***************/
    var window_width = window.screen.availWidth;
    var window_height = window.screen.availHeight;
    $(window).resize(function () {
        window_width = window.screen.availWidth;
        window_height = window.screen.availHeight;
    });
    $(function () {
        /*********侧边栏*********/
        $(".sidemenu>li").click(function () {
            var $this = $(this);
            if ($this.hasClass("active")) {
                $this.removeClass("active");
                $this.find(">ul").slideUp();
            } else {
                $this.parent().find(">li.active>ul").slideUp();
                $this.parent().children().removeClass("active");
                $this.addClass("active");
                $this.find(">ul").slideDown();
            }
        });
        /*******聊天框******/
        $(".chat-send>input").keydown(function (event) {
            if (event.keyCode=='13') {
                $(".chat-send button").click();
            }
        });
        $(".nav-tabs .close").click(function () {
            if ($(".chat-panel>.nav-tabs>li").length==2)
                return;
            $liIn = $(".chat-panel>.nav-tabs>li.active");
            $contentIn = $(".chat-content .in");
            $liIn.next().addClass("active");
            $contentIn.next().addClass("in").addClass("active");
            $liIn.remove();
            $contentIn.remove();
        });
        $(".chat-send button").click(function () {
            var $input = $(this).parent().prev();
            if ($input.val()=="")
                return;
            var divStr = "<div class=\"chat-conv myself\"><img class=\"img-rounded\" src=\"imgs/headIcon.jpg\"><div class=\"chat-box\">";
            divStr += $input.val()+"</div></div>";
            $panelIn = $(".chat-content .in");
            $panelIn.append(divStr);
            /**当聊天框内记录数最大为100**/
            if ($panelIn.children().length>100) {
                $panelIn.children(":first").remove();
            }
            /**保证滚动条在最下方**/
            $(".chat-content").slimScroll({
                scrollTo: '10000000px'
            });
            $input.val("");
        });
        /**可以为div滚动条**/
        $(".email-list").slimScroll({
            height: '200px'
        });
        $(".chat-content").slimScroll({
            height: '300px'
        });
        /******签到*******/
        $(".check-work .signin").click(function () {
            var signintime = $(".check-work #signintime").text().replace(":", "");
            var now = getNow().substr(11, 5);
            var ok = parseInt(signintime)>parseInt(now.replace(":", ""));
            $("<a class=\""+(ok ? "ok" : "no")+"\">"+now+"</a><a class=\"ip\">127.0.0.1</a>").prependTo($(this).parent());
            $(this).hide();
            $(".check-work .signout").show();
        });
        $(".check-work .signout").click(function () {
            var signouttime = $(".check-work #signouttime").text().replace(":", "");
            var now = getNow().substr(11, 5);
            var ok = parseInt(signouttime)<parseInt(now.replace(":", ""));
            $("<a class=\""+(ok ? "ok" : "no")+"\">"+now+"</a><a class=\"ip\">127.0.0.1</a>").prependTo($(this).parent());
            $(this).hide();
        });
        /*创建页码*/
        createpage();
        /*可关闭panel*/
        $(".spoon-panel .remove").click(function () {
            var $panel = $(this).closest(".spoon-panel");
            $panel.animate({"height": "0", "opacity": 0}, 500, function () {
                $panel.remove();
            });
        });
    });
    /*************************************页码相关方法***************************************/
    function createpage() {
        /****** 创建页码的方法 ******/
        if ($(".page").length==0 || $(".page").html()!="")
            return;
        var div = $(".page")[0];
        var maxpage = 7;
        var pagesize = parseInt($(div).attr("pagesize"));
        var pagenum = parseInt($(div).attr("pagenum"));
        if (pagesize==0)
            return;
        pagenum = pagenum>pagesize ? pagesize : pagenum;
        var htmlStr = '<ul class="pagination">';
        // 上一页
        htmlStr += '<li'+(pagenum==1 ? ' class="disabled"' : '')+' index="'+(pagenum-1)+'"><a>&laquo;</a></li>';
        // 当整体页码小于8时,直接循环加li
        if (pagesize<maxpage+1) {
            //数字
            for (var i = 1; i<pagesize+1; i++) {
                htmlStr += '<li'+(i==pagenum ? ' class="active"' : '')+' index="'+i+'"><a>'+i+'</a></li>';
            }
            //尾页
            htmlStr += '<li'+(pagenum==pagesize ? ' class="disabled"' : '')+' index="'+(pagenum+1)+'"><a>&raquo;</a></li></ul>';
        } else {
            //首页
            htmlStr += '<li'+(pagenum==1 ? ' class="active"' : '')+' index="1"><a>'+(pagenum<5 ? '1' : '1...')+'</a></li>';
            var start = pagenum>(maxpage+1)/2 ? pagenum-2 : 2;
            start = pagenum>pagesize-(maxpage+1)/2 ? pagesize-5 : start;
            // 数字
            for (var i = 0; i<5; i++) {
                htmlStr += '<li'+(start+i==pagenum ? ' class="active"' : '')+' index="'+(start+i)+'"><a>'+(start+i)+'</a></li>';
            }
            //尾页
            htmlStr += '<li'+(pagenum==pagesize ? ' class="active"' : '')+' index="'+(pagesize)+'"><a>'+(pagenum>pagesize-(maxpage+1)/2 ? pagesize : '...'+pagesize)+'</a></li>';
            htmlStr += '<li'+(pagenum==pagesize ? ' class="disabled"' : '')+' index="'+(pagenum+1)+'"><a>&raquo;</a></li></ul>';
        }
        $(div).html(htmlStr);
        /*********点击页码事件*********/
        var form = $(div).parents(".panel-body").find("form")[0];
        $(div).find('.pagination li:not(.active):not(.disabled)').click(function () {
            $(form).find("#pageFlag").val("true");
            $(form).find("#pageNum").val($(this).attr("index"));
            // 换页时保留排序的箭头标识
            var field = "", style = "";
            $(".data-table th").each(function () {
                var temp = $(this).attr("class");
                if (temp=="asc" || temp=="desc") {
                    field = $(this).attr("data-field");
                    style = $(this).attr("class");
                }
            });
            ajaxpost(form, function (data) {
                $(".data-table th").each(function () {
                    if ($(this).attr("data-field")==field) {
                        $(this).attr("class", style);
                        if (style=="asc")
                            $(this).append('<span class="glyphicon glyphicon-chevron-up" style="float:right;"></span>');
                        else
                            $(this).append('<span class="glyphicon glyphicon-chevron-down" style="float:right;"></span>');
                    }
                });
            });
        });
    }

    /*************点击添加、修改等操作时滑入操作面板*************/
    function createmodal() {
        $(".spoon-btn").unbind();
        $(".spoon-btn").click(function () {
            var spoonbtn = $(this);
            var url = $(this).attr("spoonhref");

            //ajaxget(url, function (data) {
            //    $("#content").append(data);
            //    handleListener1();
            //    initDateTimePickers();
            //    var resultpanel = $(spoonbtn).parents(".panel");
            //    var orignheight = resultpanel.outerHeight();
            //    var spoonheight = $(".spoon-panel").outerHeight();
            //    if (orignheight>spoonheight) {
            //        $(".spoon-panel").height(orignheight);
            //        // 有百度编辑器的页面
            //        var editorheight = $("#edui1_iframeholder").height();
            //        $("#edui1_iframeholder").height(editorheight+orignheight-spoonheight);
            //    } else {
            //        $(resultpanel).animate({height: spoonheight});
            //    }
            //    // 滑入滑出效果实现
            //    var top = $(".spoon-panel .panel").css("top");
            //    //$(".spoon-panel .panel").css("left",window_width*0.85);
            //    $(".spoon-panel").animate({opacity: 1});
            //    //$(".spoon-panel .panel").animate({left:0});
            //    $(".spoon-panel .panel").animate({top: 0});
            //    //$(".spoon-panel .panel").css("top",0);
            //    $(".spoon-panel .remove").click(function () {
            //        $(".spoon-panel").animate({opacity: 0});
            //        $(resultpanel).animate({height: orignheight}, function () {
            //            $(resultpanel).css("height", "");
            //        });
            //        $(".spoon-panel .panel").animate({top: top}, function () {
            //            $(".spoon-panel").remove();
            //        });
            //    });
            //    $(".panel").click(function (event) {
            //        // 阻止冒泡事件，即阻止点击事件向父节点冒泡
            //        event.stopPropagation();
            //        return;
            //    });
            //    $(".spoon-panel").click(function () {
            //        $(".spoon-panel").animate({opacity: 0});
            //        $(resultpanel).animate({height: orignheight}, function () {
            //            $(resultpanel).css("height", "");
            //        });
            //        $(".spoon-panel .panel").animate({top: top}, function () {
            //            $(".spoon-panel").remove();
            //        });
            //    });
            //});
        });
    }

    /********************************加载数据时的modal页面***************************************/
    /** 将传入的div加上一层loading的modal，禁止点击 **/
    function loading(div, zindex) {
        zindex = !zindex ? 5 : zindex;
        var height = $(div).height();
        $(div).append('<div id="tempmodal" style="position:absolute;z-index:'+zindex+';left:0px;top:0px;width:100%;height:100%;background:rgba(0,0,0,0.1);">'
        +'<div style="margin:'+(height/2+30)+'px auto auto;text-align:center;"><img src="/imgs/loading-black(75).gif" /></div></div>');
    }

    /** 去掉由loading方法加上的modal **/
    function unloading(div) {
        $(div).find("#tempmodal").remove();
    }

    /**
     * 获取当前时间，格式为：yyyy/MM/dd HH:mm:ss
     */
    function getNow() {
        var date = new Date();
        var now = "yyyy/MM/dd HH:mm:ss";
        var data = {
            "yyyy": date.getFullYear(),
            "MM": date.getMonth()+1,
            "dd": date.getDate(),
            "HH": date.getHours(),
            "mm": date.getMinutes(),
            "ss": date.getSeconds()
        };
        for (var num in data)
            now = now.replace(num, data[num]<10 ? "0"+data[num] : data[num]);
        return now;
    }
})(window.jQuery);