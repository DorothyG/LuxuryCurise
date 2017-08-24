<%-- 
    Document   : index
    Created on : 2016-10-8, 18:54:08
    Author     : pupu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!DOCTYPE html>
<html ng-app="layout">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<base href="/LuxuryCurise/index/">-->

        <title>index</title>
        <link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>/css/index.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>/css/jquery.mCustomScrollbar.min.css" rel="stylesheet" type="text/css"/>

        <script src="<%=basePath%>/js/angular.min.js" type="text/javascript"></script>
        <script src="<%=basePath%>/js/angular-route.min.js" type="text/javascript"></script>

        <style>
            form#search{
                padding: 0 0 20px 30%;
            }
            input#name{
                width:300px;
            }
            i{
                margin: 0 15px 0 25px;
            }
        </style>
    </head>
    <body>
        <div id="firstNav">
            <ul class="nav nav-tabs" style="background-color: #f9da83;">
                <li class="active"><a href="#roomManage" data-toggle="tab">客房管理</a></li>
                <li><a href="#infoSearch" data-toggle="tab">信息查询</a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane in active" id="roomManage">
                    <div class="secondNav">
                        <ul class="nav nav-stacked">
                            <li class="active">
                                <a href="#/curiseAboard">
                                    <i class="icon-edit"></i>登船登记</a>
                            </li>
                            <li>
                                <a href="#/reserve">
                                    <i class="icon-desktop"></i>预定登记</a>
                            </li>
                            <li>
                                <a href="#/roomChange">
                                    <i class="icon-move"></i>换舱登记</a>
                            </li>
                            <li>
                                <a href="#/payment">
                                    <i class="icon-money"></i>消费结账</a>
                            </li>
                            <li>
                                <a href="#/depositPay">
                                    <i class="icon-bar-chart"></i>补交押金</a>
                            </li>
                        </ul>

                    </div>
                </div>
                <div class="tab-pane" id="infoSearch">
                    <div class="secondNav">
                        <ul class="nav nav-stacked">
                            <li class="active"><a href="#/customerInfo">
                                    <i class="icon-book"></i>客人信息</a></li>
                            <li><a href="#/reserveInfo">
                                    <i class="icon-check"></i>客房预订</a></li>
                            <li><a href="#/changeInfo">
                                    <i class="icon-book"></i>换舱登记</a></li>
                            <li><a href="#/thingsConsume">
                                    <i class="icon-tasks"></i>物品消耗</a></li>
                            <li><a href="#/cleanStatus">
                                    <i class="icon-glass"></i>清洁状态</a></li>
                            <li><a href="#/saleRate">
                                    <i class="icon-globe"></i>销售进度</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="content">
            <div ng-view></div>
        </div>

        <div id="top">
            <div id="curise" name="curise" class="dropdown">
                <a id="curiseKind" class="dropdown-toggle" data-toggle="dropdown">
                    <img src="<%=basePath%>/icon/Curise.png" width="56px" height="32px">
                </a>
                <!--<ul class="dropdown-menu" role="menu" aria-labelledby="curiseKind">
                    <li><a class="curiseName" data-toggle="tab">维多利亚1号</a></li>
                    <li><a class="curiseName" data-toggle="tab">东方皇家号</a></li>
                </ul>-->
            </div>
            <font>豪华邮轮前台服务系统</font>
            <div id="login" class="dropdown">
                <a id="loginState" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="icon-user icon-2x" id="user"></i>
                    <label style="font-size:18px;">${account}</label>
                </a>
                <ul class="dropdown-menu" role="menu" aria-labelledby="loginState">
                    <li><a>设置</a></li>
                    <li>
                        <a id="logout">退出</a>
                        <form id="lo" action="/LuxuryCurise/logout" method="post">
                        </form>
                    </li>
                </ul>
            </div>
        </div>

        <div id="tabBackground">
            <img src="<%=basePath%>/icon/perficient.png" alt="博可" width="160px" height="90px" style="margin:5px auto auto 10px;" />
        </div>

    </body>

    <script src="<%=basePath%>/js/jquery-3.1.0.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/common.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/router.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/jquery.mCustomScrollbar.concat.min.js" type="text/javascript"></script>

    <script>
        $(function () {
            $("div.secondNav li").click(function () {
                $(this).css("background-color", "#FFF");
                $(this).siblings().css("background-color", "#271f19");
            });
        });
    </script>

    <script>
        (function ($) {
            $(window).on("load", function () {
                $("#content").mCustomScrollbar({
                    theme: "mininal-dark"
                });
            });
        })(jQuery);
    </script>

    <script>
        $(function () {
            $("a#logout").off().click(function () {
                $("form#lo").submit();
                /*$.post({
                    url: "/LuxuryCurise/logout"
                });*/
            });
        });
    </script>

</html>
