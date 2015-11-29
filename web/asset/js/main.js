/**
 * Created by FuShaoxing on 2015/5/30.
 */
/************实时记录页面宽高***************/
var window_width = window.screen.availWidth;
var window_height = window.screen.availHeight;
$(window).resize(function () {
    window_width = window.screen.availWidth;
    window_height = window.screen.availHeight;
});
$(function () {
    /*********侧边栏*********/
    $(".sidemenu>li").click(function (event) {
        // 点击二级菜单时不会收起
        if ($(event.target).closest("ul").hasClass("submenu"))
            return;
        var $this = $(this);
        if ($this.hasClass("active")) {
            $this.find(">ul").slideUp('fast', function () {
                $this.removeClass("active");
            });
        } else {
            $this.parent().find(">li.active>ul").slideUp('fast', function () {
                $(this).parent().removeClass("active");
            });
            $this.find(">ul").slideDown('fast', function () {
                $this.addClass("active");
            });
        }
    });

});
/**
 * 获取当前时间，格式为：yyyy/MM/dd HH:mm:ss
 */
function getNow() {
    var date = new Date();
    var now = "yyyy/MM/dd HH:mm:ss";
    var data = {
        "yyyy": date.getFullYear(),
        "MM": date.getMonth() + 1,
        "dd": date.getDate(),
        "HH": date.getHours(),
        "mm": date.getMinutes(),
        "ss": date.getSeconds()
    };
    for (var num in data)
        now = now.replace(num, data[num] < 10 ? "0" + data[num] : data[num]);
    return now;
}