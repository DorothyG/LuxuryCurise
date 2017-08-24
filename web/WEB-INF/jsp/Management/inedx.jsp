<%-- 
    Document   : inedx
    Created on : 2016-10-28, 15:22:20
    Author     : Apple
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path ;
%>
<!DOCTYPE html>
<html ng-app="layout">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="<%=basePath%>/css/background.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>/css/jquery.mCustomScrollbar.css" rel="stylesheet" type="text/css"/>
        <!--        <link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>-->

        <style>
            form#search{
                padding: 0 0 20px 30%;
            }
            input#name{
                width:300px;
            }
            i{
                margin: 0 15px 0 20px;
            }
            div#infoManageState{
                display: none;
            }
            div#customerGroupStateView, div#ageLevelStateView{
                width:50%;
                float: left;
            }
        </style>
    </head>
    <body>
        <div id="firstNav">
            <ul class="nav nav-tabs" style="background-color: #f9da83;">
                <li class="active"><a href="#roomManage" data-toggle="tab">客房管理</a></li>
                <li><a href="#infoManage" data-toggle="tab">信息管理</a></li>
                <li><a href="#engageManage" data-toggle="tab">经营管理</a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane in active" id="roomManage">
                    <div class="secondNav">
                        <ul class="nav nav-stacked" data-spy="affix">
                            <li class="active"><a href="#/roomManage#checkInState">
                                    <i class="icon-building"></i>入住状态统计</a></li>
                            <li><a href="#/roomManage#roomUseState">
                                    <i class="icon-suitcase"></i>客房使用统计</a></li>
                            <li><a href="#/roomManage#customerGroupState">
                                    <i class="icon-coffee"></i>消费群体统计</a></li>
                            <li><a href="#/roomManage#ageLevelState">
                                    <i class="icon-eye-open"></i>年龄阶段统计</a></li>
                        </ul>
                    </div>
                </div>
                <div class="tab-pane" id="infoManage">
                    <div class="secondNav">
                        <ul class="nav nav-stacked">
                            <li class="active"><a href="#/infoManage#creditCheck">
                                    <i class="icon-file-alt"></i>信用度审查</a></li>
                            <li><a href="#/infoManage#realNameRegister">
                                    <i class="icon-envelope"></i>实名制登记</a></li>
                            <li><a href="#/infoManage#customerPayment">
                                    <i class="icon-beer"></i>客人消费</a></li>
                        </ul>
                    </div>
                </div>
                <div class="tab-pane" id="engageManage">
                    <div class="secondNav">
                        <ul class="nav nav-stacked">
                            <li class="active"><a href="#/engageManage#retailDepart">
                                    <i class="icon-bullhorn"></i>零售部</a></li>
                            <li><a href="#/engageManage#entertainDepart">
                                    <i class="icon-camera"></i>娱乐事业部</a></li>
                            <li><a href="#/engageManage#foodDepart">
                                    <i class="icon-food"></i>餐饮部</a></li>
                            <li><a href="#/engageManage#roomDepart">
                                    <i class="icon-home"></i>客房营收</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div id="content" data-spy="scroll" data-target=".secondNav" class="mCustomScrollbar" data-mcs-theme="minimal">
            <div ng-view></div>
        </div>

        <div id="top">
            <div id="curise" name="curise" class="dropdown">
                <a id="curiseKind" class="dropdown-toggle" data-toggle="dropdown">
                    <img src="../../icon/Curise.png" width="56px" height="32px">
                </a>
                <ul class="dropdown-menu" role="menu" aria-labelledby="curiseKind">
                    <li><a data-toggle="tab">美国维多利亚号</a></li>
                    <li><a data-toggle="tab">东方皇家号</a></li>
                </ul>
            </div>
            <font>豪华邮轮前台服务系统</font>
            <div id="login" class="dropdown">
                <a id="loginState" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="icon-user icon-2x" id="user"></i>
                    <label style="font-size:18px;">Dorothy</label>
                </a>
                <ul class="dropdown-menu" role="menu" aria-labelledby="loginState">
                    <li><a data-toggle="tab">设置</a></li>
                    <li><a data-toggle="tab">退出</a></li>
                </ul>
            </div>
        </div>

        <div id="tabBackground">
            <img src="../../icon/perficient.png" alt="博可" width="160px" height="90px" style="margin:5px auto auto 10px;" />
        </div>



        <script src="<%=basePath%>/js/jquery-3.1.0.min.js" type="text/javascript"></script>
        <script src="<%=basePath%>/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="<%=basePath%>/js/Chart.min.js" type="text/javascript"></script>
        <script src="<%=basePath%>/js/angular.min.js" type="text/javascript"></script>
        <script src="<%=basePath%>/js/angular-route.min.js" type="text/javascript"></script>
        <script src="<%=basePath%>/js/background_route.js" type="text/javascript"></script>
        <script src="<%=basePath%>/js/jquery-ui.min.js" type="text/javascript"></script>
        <!--<script src="../js/jquery.mousewheel.min.js" type="text/javascript"></script>
        <script src="../js/jquery.mCustomScrollbar.min.js" type="text/javascript"></script>-->
        <script src="<%=basePath%>/js/jquery.mCustomScrollbar.concat.min.js" type="text/javascript"></script>
        <!--        <script src="../js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
                <script src="../js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>-->

        <script>
            $(function () {
                $("div.secondNav li").click(function () {
                    $(this).css("background-color", "#FFF");
                    $(this).siblings().css("background-color", "#271f19");
                });
            });
        </script>

        <script>
            /*$(function () {
             $(window).load(function () {
             $("#content").mCustomScrollbar();
             });
             });
             (function ($) {
             $(window).on(function () {
             $("#content").mCustomScrollbar({
             theme:"minimal"
             });
             });
             })(jQuery);*/
        </script>
    </body>
</html>
