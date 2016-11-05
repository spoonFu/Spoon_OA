<%--
  User: FuShaoxing  xinyu2010@126.com
  Date: 2015/9/10 20:17
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<div class="chat-div">
    <div class="chat-ident">
        <span class="fa fa-2x fa-comments-o"></span>

        <p>即时聊天</p>
    </div>
    <div class="chat-panel">
        <div class="chat-sidebar">
            <div class="search">
                <div class="input-group input-group-sm">
                    <input class="form-control" type="text">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button"><span class="fa fa-search"/></button>
                    </span>
                </div>
            </div>
            <ul class="user-recent">
                <%--<li data-pane="admin">
                    <div><img class="img-rounded" src="imgs/headIcon.jpg"></div>
                    <p>付韶兴</p>
                    <div class="rfloat"><a>×</a></div>
                </li>
                <li data-pane="test">
                    <div><img class="img-rounded" src="imgs/headIcon.jpg"></div>
                    <p>李雷</p>
                    <div class="rfloat"><a>×</a></div>
                </li>
                <li data-pane="haha">
                    <div><img class="img-rounded" src="imgs/headIcon.jpg"></div>
                    <p>韩梅梅</p>
                    <div class="rfloat"><a>×</a></div>
                    <span class="dot"></span>
                </li>--%>
            </ul>
            <div class="user-list">
                <div class="pull-up"><span class="fa fa-angle-double-up"></span></div>
                <ul>
                    <%--<li data-pane="admin">
                        <div><img class="img-rounded" src="imgs/headIcon.jpg"></div>
                        <p>付韶兴</p>
                    </li>
                    <li data-pane="test">
                        <div><img class="img-rounded" src="imgs/headIcon.jpg"></div>
                        <p>李雷</p>
                    </li>
                    <li data-pane="haha">
                        <div><img class="img-rounded" src="imgs/headIcon.jpg"></div>
                        <p>韩梅梅</p>
                    </li>--%>
                </ul>
            </div>
        </div>
        <div class="chat-content">
            <div class="chat-head">
                <a class="name normal"></a>

                <div class="close"><span class="fa fa-close"/></div>
            </div>
            <div class="chat-body">
                <%--<div class="chat-pane" id="admin">
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

                <div class="chat-pane" id="test">
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

                <div class="chat-pane" id="haha">
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
                </div>--%>
            </div>
            <div class="chat-foot">
                <div><input class="form-control input-sm" type="text" placeholder="请输入消息"></div>
                <div class="face"><span class="fa fa-smile-o"></span>

                    <div class="chat-face">
                        <ul>
                            <li data-text="[xkl拜年]" title="[xkl拜年]">
                            </li>
                            <li data-text="[xkl恭喜]" title="[xkl恭喜]">
                            </li>
                            <li data-text="[xkl发财]" title="[xkl发财]">
                            </li>
                            <li data-text="[xkl鞭炮]" title="[xkl鞭炮]">
                            </li>
                            <li data-text="[xkl下雪]" title="[xkl下雪]">
                            </li>
                            <li data-text="[xkl撒花]" title="[xkl撒花]">
                            </li>
                            <li data-text="[xkl扔糖豆]" title="[xkl扔糖豆]">
                            </li>
                            <li data-text="[xkl扭]" title="[xkl扭]">
                            </li>
                            <li data-text="[xkl你拍一]" title="[xkl你拍一]">
                            </li>
                            <li data-text="[xkl打岔]" title="[xkl打岔]">
                            </li>
                            <li data-text="[dada搬糖豆]" title="[dada搬糖豆]">
                            </li>
                            <li data-text="[xkl搬糖豆]" title="[xkl搬糖豆]">
                            </li>
                            <li data-text="[dada转圈]" title="[dada转圈]">
                            </li>
                            <li data-text="[dada秧歌]" title="[dada秧歌]">
                            </li>
                            <li data-text="[dada提灯笼]" title="[dada提灯笼]">
                            </li>
                            <li data-text="[xkl追]" title="[xkl追]">
                            </li>
                            <li data-text="[xkl拥抱]" title="[xkl拥抱]">
                            </li>
                            <li data-text="[xkl亲亲]" title="[xkl亲亲]">
                            </li>
                            <li data-text="[xkl困]" title="[xkl困]">
                            </li>
                            <li data-text="[xkl达达喜欢]" title="[xkl达达喜欢]">
                            </li>
                            <li data-text="[xkl达达吐舌头]" title="[xkl达达吐舌头]">
                            </li>
                            <li data-text="[xkl达达坏笑]" title="[xkl达达坏笑]">
                            </li>
                            <li data-text="[xkl达达黑暗]" title="[xkl达达黑暗]">
                            </li>
                            <li data-text="[xkl吃西瓜]" title="[xkl吃西瓜]">
                            </li>
                            <li data-text="[kxl晕]" title="[kxl晕]">
                            </li>
                            <li data-text="[xkl抓狂]" title="[xkl抓狂]">
                            </li>
                            <li data-text="[xkl眨眼]" title="[xkl眨眼]">
                            </li>
                            <li data-text="[xkl摇尾巴]" title="[xkl摇尾巴]">
                            </li>
                            <li data-text="[xkl偷看]" title="[xkl偷看]">
                            </li>
                            <li data-text="[xkl糖豆]" title="[xkl糖豆]">
                            </li>
                            <li data-text="[xkl囧]" title="[xkl囧]">
                            </li>
                            <li data-text="[xkl抚摸]" title="[xkl抚摸]">
                            </li>
                            <li data-text="[xkl奔跑]" title="[xkl奔跑]">
                            </li>
                            <li data-text="[xkl被抓]" title="[xkl被抓]">
                            </li>
                            <li data-text="[xkl被电]" title="[xkl被电]">
                            </li>
                            <li data-text="[xkl怒火]" title="[xkl怒火]">
                            </li>
                            <li data-text="[xkl转圈]" title="[xkl转圈]">
                            </li>
                            <li data-text="[xkl喜]" title="[xkl喜]">
                            </li>
                            <li data-text="[xkl委屈]" title="[xkl委屈]">
                            </li>
                            <li data-text="[xkl石化]" title="[xkl石化]">
                            </li>
                            <li data-text="[xkl期待]" title="[xkl期待]">
                            </li>
                            <li data-text="[xkl捏脸]" title="[xkl捏脸]">
                            </li>
                            <li data-text="[xkl路过]" title="[xkl路过]">
                            </li>
                            <li data-text="[xkl哈哈哈]" title="[xkl哈哈哈]">
                            </li>
                            <li data-text="[xkl顶]" title="[xkl顶]">
                            </li>
                        </ul>
                    </div>
                </div>
                <button class="btn btn-sm btn-default rfloat" disabled="disabled" type="button">发送</button>
            </div>
        </div>
    </div>
</div>
