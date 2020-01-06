<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
    <%--String name = (String)session.getAttribute("username");--%>
<%
    String path = request.getContextPath();
//    String basePath = request.getScheme() + "://"
//            + request.getServerName() + ":" + request.getServerPort()
//            + path + "/";
    String sessionValues=(String)request.getSession().getAttribute("username");
    int sessionuserid=(Integer)request.getSession().getAttribute("userid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>谋思特视频</title>
    <link rel="stylesheet" type="text/css" href="../../css/style.css" />
    <script src="/js/jquery.min.js" type="text/javascript"></script>
    <link href="/css/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/index.js"></script>
    <script type="text/javascript" src="/js/clipboard.min.js"></script>
    <style type="text/css">
        a{ color:#000; text-decoration:none;}
        a:link{ color:#000; text-decoration:none;}
        a:hover{color:#C03;text-decoration:none;}
        a:active{ color:#000; text-decoration:none;}
        a:visited{
            color: #000;
            text-decoration: none;
            font-size: 14px;
        }
    </style>
    <link rel="shortcut icon" type="image/x-icon" href="../../images/tubiao.ico" media="screen" />
</head>
<body>

<div id="all">

        <nav class="navbar navbar-default navbar-fixed-top">
            <div id="top">
                <div id="logoAndList">
                    <button class="btn btn-default" style="border: 0px; margin-left: 25px;">
                        <span class="glyphicon glyphicon-list"></span>
                    </button>
                    <a href="#"><img id="shouye" src="../../images/shouye.jpg" title="MostTV 首页"/></a>
                </div>
                <div id="searchdiv"  class="input-group input-group-sm" style="width: 30%; float: left;margin-top: 12px;">
                    <input id="searchinp" type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                        <button id="searchbtn" class="btn btn-default" type="button">
                            <span class="glyphicon glyphicon-search"/>
                        </button>
                    </span>
                </div>

                <%--<div id="111">--%>
                    <%--<span class="glyphicon glyphicon-search"/>--%>
                <%--</div>--%>


                <div id="topRight" style="float: right;font-size: 15px">
                    <a href="/MostTV/upload?name=<%=sessionValues%>"><span id="upload" class="glyphicon glyphicon-cloud-upload"data-toggle="tooltip" data-placement="left" title="上传"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="#"><span id="sharehap" class="glyphicon glyphicon-share-alt" data-toggle="tooltip" data-placement="right" title="分享"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <c:if test="${ sessionScope.username!=null}">
                        <span title="点击进入个人界面"><a href="/MostTV/login?name=<%=sessionValues%>" >欢迎你：${ sessionScope.username}</a></span>
                    </c:if>
                    <c:if test="${sessionScope.username == null}">
                        <%--<span class="glyphicon glyphicon-log-in"/>--%>
                        <span style="color: #00b7ee"><a href="/MostTV/login?name=<%=sessionValues%>" >登录</a></span>
                    </c:if>
                    <c:if test="${ sessionScope.userid!=null}">
                        <input type="hidden" id="userid" value=${ sessionScope.userid}>
                    </c:if>
                </div>
            </div>
        </nav>

    <div id="below" >
        <%--style="white-space:pre"下拉显示--%>
        <div id="left">
            <div id="leftTop">
                <ul class="nav nav-pills nav-stacked"  >
                    <li role="presentation" style="margin-top: 20px">
                        <a href="index" id="index" style="color: red">
                            <span class="glyphicon glyphicon-home" style="margin-left: 60px;"/> 首页
                        </a>
                    </li>
                    <li role="presentation">

                        <a href="mostsee" id="mostSee" >
                            <span  class="glyphicon glyphicon-fire" style="margin-left: 60px;"/> 观看最多
                        </a>

                    </li>
                    <li role="presentation">
                        <a href="rankingList" id="rankingList">
                            <span class="glyphicon glyphicon-sort" style="margin-left: 60px"/> 排行榜
                        </a>
                    </li>
                    <hr style="height:1px;border:none;border-top:1px solid  #dcdcdc;" />
                </ul>
            </div>
            <div id="leftCanent">
                <span style="margin-left: 30px" >MostvTV精选</span>
                <ul class="nav nav-pills nav-stacked allLabel">
                    <%--<li role="presentation" style="margin-left: 25px"></li>--%>
                    <li role="presentation" id="tvshowLabel">
                        <a href="tvshow">
                            <span class="glyphicon glyphicon-hd-video" style="margin-left: 60px"/> 美剧
                        </a>
                    </li>
                    <li role="presentation" id="filmshowLabel">
                        <a href="filmshow">
                            <span class="glyphicon glyphicon-film" style="margin-left: 60px"/> 电影
                        </a>
                    </li>
                     <li role="presentation" id="musicshowLabel">
                        <a href="musicshow">
                            <span class="glyphicon glyphicon-book" style="margin-left: 60px"/> 学习
                        </a>
                    </li>
                     <li role="presentation" id="newsshowLabel">
                        <a href="hotnews">
                            <span class="glyphicon glyphicon-list-alt" style="margin-left: 60px"/> 新闻
                        </a>
                    </li>
                     <li role="presentation" id="sportshowLabel">
                        <a href="sportshow">
                            <span class="glyphicon glyphicon-globe" style="margin-left: 60px"/> 体育
                        </a>
                    </li>
                     <li role="presentation" id="gameshowLabel">
                        <a href="gameshow">
                            <span class="glyphicon glyphicon-blackboard" style="margin-left: 60px"/> 游戏
                        </a>
                    </li>
                    <hr style="height:1px;border:none;border-top:1px solid  #dcdcdc;" />
                </ul>
            </div>
            <div id="leftBelow">
                <span style="margin-left: 30px" >帮助反馈</span>
                <ul class="nav nav-pills nav-stacked">
                    <%--<li role="presentation">--%>
                        <%--<a href="#">--%>
                            <%--<span class="glyphicon glyphicon-cog" style="margin-left: 60px"/> 设置--%>
                        <%--</a>--%>
                    <%--</li>--%>
                     <%--<li role="presentation">--%>
                        <%--<a href="#">--%>
                            <%--<span class="glyphicon glyphicon-question-sign" style="margin-left: 60px"/> 帮助--%>
                        <%--</a>--%>
                    <%--</li>--%>
                     <li role="presentation">
                        <a href="#">
                            <span class="glyphicon glyphicon-comment" style="margin-left: 60px;"/>
                            <button  id="sendadv" type="button" class="btn  btn-default" data-toggle="modal" data-target="#myModal" style="border: 0px;background-color:#f5f5f5">
                                发送反馈
                            </button>
                        </a>
                    </li>
                    <hr style="height:1px;border:none;border-top:1px solid  #dcdcdc;" />
                </ul>
                <div class="modal fade" id="myModal"  data-backdrop="static" tabindex="60" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title">您的问题</h4>
                            </div>
                            <div class="modal-body">
                                <p>问题描述</p>
                                <textarea class="form-control" id="advtext"></textarea>
                            </div>
                            <div class="modal-footer">
                                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                                <button class="btn btn-primary" id="submit" type="button">提交</button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div>
            </div>
            <div id="leftAbout" style="margin: 0 5px 0 5px;height: 300px">
                    <span style="margin-left: 30px;font-size:18px">MostvTV声明</span><br><br>
                    <span style="margin-top: 10px">
                        &nbsp; &nbsp;本网站的内容、图文来自于网络,我们尊重他人的合法权益,如有内容侵犯您的合法权益,请及时与我们联系,我们将第一时间安排核实及删除!</li>
                    </span>
                    <br/>
                    <span>法务联系:657281999@qq.com</span><br/>
                    <span style="margin-left: 20%">版权所有MOSTTV</span><br/>
                    <span style="margin-left: 20%">ICP证陕17003214</span>
                </div>
        </div>
        <div id="right">
            <div id="r1">
                <div class="allThume">
                    <div class="mainTitle">
                        <span class="title">观看最多</span>
                    </div>
                    <div id="indexmostsee">

                    </div>
                    <hr style="height:1px;border:none;border-top:1px solid  #dcdcdc;margin-top:260px" />
                </div>
                <div class="allThume">
                    <div class="mainTitle">
                        <span class="title">热门美剧</span>
                    </div>
                    <div id="indexustvv">

                    </div>

                    <hr style="height:1px;border:none;border-top:1px solid  #dcdcdc;margin-top:260px" />
                </div>
            </div>
        </div>
    </div>
    </div>

</div>

</body>
</html>