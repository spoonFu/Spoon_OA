/**
 * Created by Administrator on 2015/8/16.
 */
(function ($) {
    var rootUrl = "/" + document.location.pathname.split("/")[1] + "/";
    $(function () {
        /****为页码所在的form创建相关查询条件****/
        if ($(".page").length != 0 || $(".page").html() == "") {
            var div = $(".page")[0];
            var form = $(div).parents(".panel-body").find("form")[0];
            $(form).append('<input type="hidden" id="pageFlag" name="pageFlag" value="false"/>');
            $(form).append('<input type="hidden" id="pageNum" name="pageNum" value="1"/>');
            $(form).append('<input type="hidden" id="order" name="order" value=""/>');
        }
        // 添加监听事件
        createpage();
        theadclick();
        createmodal();
        handleListener2();
        /******************使用查询按钮查询*******************/
        $(".query-btn").click(function () {
            var form = $(this).parents("form")[0];
            $(form).find("#pageNum").val("1");
            ajaxpost(form, function (data) {
            });
        });
        /*可关闭panel*/
        $(".spoon-panel .remove").click(function () {
            var $panel = $(this).closest(".spoon-panel");
            $panel.animate({"height": "0", "opacity": 0}, 500, function () {
                $panel.remove();
            });
        });
        /******************选择页面数据量时调用********************/
        $("#rowSize").change(function () {
            // 换页时保留排序的箭头标识
            var field = "", style = "";
            $(".data-table th").each(function () {
                var temp = $(this).attr("class");
                if (temp == "asc" || temp == "desc") {
                    field = $(this).attr("data-field");
                    style = $(this).attr("class");
                }
            });
            var form = $(this).parents("form")[0];
            ajaxpost(form, function (data) {
                $(".data-table th").each(function () {
                    if ($(this).attr("data-field") == field) {
                        $(this).attr("class", style);
                        if (style == "asc")
                            $(this).append('<span class="fa fa-chevron-up" style="float:right;"></span>');
                        else
                            $(this).append('<span class="fa fa-chevron-down" style="float:right;"></span>');
                    }
                });
            });
        });
    });
    /*************************************页码相关方法***************************************/
    function createpage() {
        /****** 创建页码的方法 ******/
        if ($(".page").length == 0 || $(".page").html() != "")
            return;
        var div = $(".page")[0];
        var maxpage = 7;
        var pagesize = parseInt($(div).attr("pagesize"));
        var pagenum = parseInt($(div).attr("pagenum"));
        if (pagesize == 0)
            return;
        pagenum = pagenum > pagesize ? pagesize : pagenum;
        var htmlStr = '<ul class="pagination">';
        // 上一页
        htmlStr += '<li' + (pagenum == 1 ? ' class="disabled"' : '') + ' index="' + (pagenum - 1) + '"><a>&laquo;</a></li>';
        // 当整体页码小于8时,直接循环加li
        if (pagesize < maxpage + 1) {
            //数字
            for (var i = 1; i < pagesize + 1; i++) {
                htmlStr += '<li' + (i == pagenum ? ' class="active"' : '') + ' index="' + i + '"><a>' + i + '</a></li>';
            }
            //尾页
            htmlStr += '<li' + (pagenum == pagesize ? ' class="disabled"' : '') + ' index="' + (pagenum + 1) + '"><a>&raquo;</a></li></ul>';
        } else {
            //首页
            htmlStr += '<li' + (pagenum == 1 ? ' class="active"' : '') + ' index="1"><a>' + (pagenum < 5 ? '1' : '1...') + '</a></li>';
            var start = pagenum > (maxpage + 1) / 2 ? pagenum - 2 : 2;
            start = pagenum > pagesize - (maxpage + 1) / 2 ? pagesize - 5 : start;
            // 数字
            for (var i = 0; i < 5; i++) {
                htmlStr += '<li' + (start + i == pagenum ? ' class="active"' : '') + ' index="' + (start + i) + '"><a>' + (start + i) + '</a></li>';
            }
            //尾页
            htmlStr += '<li' + (pagenum == pagesize ? ' class="active"' : '') + ' index="' + (pagesize) + '"><a>' + (pagenum > pagesize - (maxpage + 1) / 2 ? pagesize : '...' + pagesize) + '</a></li>';
            htmlStr += '<li' + (pagenum == pagesize ? ' class="disabled"' : '') + ' index="' + (pagenum + 1) + '"><a>&raquo;</a></li></ul>';
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
                if (temp == "asc" || temp == "desc") {
                    field = $(this).attr("data-field");
                    style = $(this).attr("class");
                }
            });
            ajaxpost(form, function (data) {
                $(".data-table th").each(function () {
                    if ($(this).attr("data-field") == field) {
                        $(this).attr("class", style);
                        if (style == "asc")
                            $(this).append('<span class="fa fa-chevron-up" style="float:right;"></span>');
                        else
                            $(this).append('<span class="fa fa-chevron-down" style="float:right;"></span>');
                    }
                });
            });
        });
    }

    /****************当点击表头调用排序方法*****************/
    function theadclick() {
        $(".data-table th").click(function () {
            var fieldStr = $(this).attr("data-field");
            if (!fieldStr)
                return;
            var field;
            var chinese = false;
            if (fieldStr.split(",").length == 2) {
                var strs = fieldStr.split(",");
                field = strs[0];
                if (strs[1] == "chinese")
                    chinese = true;
            } else {
                field = fieldStr;
            }
            var form = $(this).parents(".panel-body").find("form")[0];
            var order, span;
            if ($(this).hasClass("asc")) {
                $(form).find("#order").val(field + ",desc" + (chinese ? ",chinese" : ",else"));
                order = "desc";
                span = '<span class="fa fa-chevron-down" style="float:right;line-height:20px;"></span>';
            } else {
                $(form).find("#order").val(field + ",asc" + (chinese ? ",chinese" : ",else"));
                order = "asc";
                span = '<span class="fa fa-chevron-up" style="float:right;line-height:20px;"></span>';
            }
            ajaxpost(form, function (data) {
                $(".data-table th").each(function () {
                    $(this).find("span").remove();
                });
                $(".data-table th").each(function () {
                    if ($(this).attr("data-field") == fieldStr)
                        $(this).attr("class", order).append(span);
                    $(form).find("#order").val("");
                });
            });
        });
    }

    /******************提交新增和修改时的监听事件*******************/
    function handleListener1() {
        // 添加提交
        $(".add-btn").click(function () {
            var form = $(this).parents("form")[0];
            $("#pageNum").val("1");
            ajaxpost(form, function (data) {
                $(".spoon-panel .remove").click();
            }, 1000);
        });
        // 修改提交
        $(".mod-btn").click(function () {
            var form = $(this).parents("form")[0];
            ajaxpost(form, function (data) {
                $(".spoon-panel .remove").click();
            }, 1000);
        });
        // 增加tab页事件
        if ($(".nav-tabs").length > 0) {
            $($(".nav-tabs").next(".tab-content").find(".tab-pane")[$(".nav-tabs li.active").index()]).css("visibility", "visible").fadeIn();
            $(".nav-tabs li a").click(function () {
                //$(this).siblings().removeClass("active");
                //$(this).addClass("active");
                $(this).tab("show");
                var index = $(this).parent().index();
                var content = $(this).closest(".nav-tabs").next(".tab-content").find(".tab-pane:eq(" + index + ")");
                $(content).siblings().hide();
                $(content).css("visibility", "visible").fadeIn();
            });
        }
    }

    function handleListener2() {
        // 删除
        $(".del-btn").click(function () {
            var delhref = $(this).attr("delhref");
            var delname = $(this).attr("delname");
            var d = dialog({
                title: '提示',
                content: '确定删除' + (delname?'"'+delname+'"':'') + '？',
                okValue: '确定',
                cancelValue: '取消',
                ok: function () {
                    loading($("#result-div").parent());
                    ajaxget(delhref, function (data) {
                        $("#result-div").replaceWith(data);
                        unloading($("#result-div").parent());
                        createpage();
                        theadclick();
                        createmodal();
                        handleListener2();
                        $(".data-table tbody").slideDown(5000);
                    });
                },
                cancel: function () {
                    d.close().remove();
                }
            });
            d.showModal();
        });
    }

    /*************点击添加、修改等操作时滑入操作面板*************/
    function createmodal() {
        $(".spoon-btn").unbind();
        $(".spoon-btn").click(function () {
            var spoonbtn = $(this);
            var url = $(this).attr("spoonhref");
            ajaxget(url, function (data) {
                $("#content").append(data);
                handleListener1();
                //initDateTimePickers();
                var resultpanel = $(spoonbtn).parents(".panel");
                var orignheight = resultpanel.outerHeight();
                var spoonheight = $(".spoon-panel").outerHeight();
                if (orignheight > spoonheight) {
                    $(".spoon-panel").height(orignheight);
                } else {
                    $(resultpanel).animate({height: spoonheight});
                }
                // 滑入滑出效果实现
                var top = $(".spoon-panel .panel").css("top");
                $(".spoon-panel").animate({opacity: 1});
                $(".spoon-panel .panel").animate({top: 0});
                $(".spoon-panel .remove").click(function () {
                    $(".spoon-panel").animate({opacity: 0});
                    $(resultpanel).animate({height: orignheight}, function () {
                        $(resultpanel).css("height", "");
                    });
                    $(".spoon-panel .panel").animate({top: top}, function () {
                        $(".spoon-panel").remove();
                    });
                });
                $(".panel").click(function (event) {
                    // 阻止冒泡事件，即阻止点击事件向父节点冒泡
                    event.stopPropagation();
                    return;
                });
                $(".spoon-panel").click(function () {
                    $(".spoon-panel").animate({opacity: 0});
                    $(resultpanel).animate({height: orignheight}, function () {
                        $(resultpanel).css("height", "");
                    });
                    $(".spoon-panel .panel").animate({top: top}, function () {
                        $(".spoon-panel").remove();
                    });
                });
            });
        });
    }

    /** ajax异步get页面 **/
    function ajaxget(url, fn) {
        $.ajax({
            type: "GET",
            async: true,
            url: url,
            dataType: "html",
            success: function (data) {
                if (undefined != fn)
                    fn(data);
            },
            error: function () {
                alert("请求失败!");
            }
        });
    }

    /** ajax异步提交form,将页码查询参数还原 **/
    function ajaxpost(form, fn, zindex) {
        var url = $(form).attr("action");
        loading($(form).parent(), zindex);
        $.ajax({
            type: "POST",
            async: true,
            url: url,
            data: $(form).serialize(),
            dataType: "html",
            success: function (data) {
                $(form).find("#pageFlag").val("false");
                $("#result-div").replaceWith(data);
                evalJsp(data);
                if (undefined != fn)
                    fn(data);
                unloading($(form).parent());
                // 为替换的页面添加一系列监听事件
                createpage();
                theadclick();
                createmodal();
                handleListener2();
                $(".data-table tbody").slideDown(5000);
            },
            error: function () {
                alert("请求失败!");
                unloading($(form).parent());
            }
        });
    }

    /********************************加载数据时的modal页面***************************************/
    /** 将传入的div加上一层loading的modal，禁止点击 **/
    function loading(div, zindex) {
        zindex = !zindex ? 5 : zindex;
        var height = $(div).height();
        $(div).append('<div id="tempmodal" style="position:absolute;z-index:' + zindex + ';left:0px;top:0px;width:100%;height:100%;background:rgba(0,0,0,0.1);">'
        + '<div style="margin:' + (height / 2 + 30) + 'px auto auto;text-align:center;"><img src="' + rootUrl + 'imgs/loading-black(75).gif" /></div></div>');
    }

    /** 去掉由loading方法加上的modal **/
    function unloading(div) {
        $(div).find("#tempmodal").remove();
    }

    /**********初始化datepicker等时间选择器*********/
    function initDateTimePickers() {
        if (!jQuery().daterangepicker)
            return;
        $('.date-picker').datepicker({autoclose: true}).next().click(function () {
            $(this).prev().focus();
        });
    }

    /**********************************执行返回页面中的js*******************************************/
    function evalJsp(jspStr) {
        // 第一步：匹配加载的页面中是否含有js
        var regDetectJs = /<script(.|\n)*?>(.|\n|\r\n)*?<\/script>/ig;
        var jsContained = jspStr.match(regDetectJs);

        // 第二步：如果包含js，则一段一段的取出js再加载执行
        if (jsContained) {
            // 分段取出js正则
            var regGetJS = /<script(.|\n)*?>((.|\n|\r\n)*)?<\/script>/im;
            // 按顺序分段执行js
            var jsNums = jsContained.length;
            for (var i = 0; i < jsNums; i++) {
                var jsSection = jsContained[i].match(regGetJS);
                if (jsSection[2]) {
                    if (window.execScript) {
                        // 给IE的特殊待遇
                        window.execScript(jsSection[2]);
                    } else {
                        // 给其他大部分浏览器用的
                        window.eval(jsSection[2]);
                    }
                }
            }
        }
    }
})(window.jQuery)