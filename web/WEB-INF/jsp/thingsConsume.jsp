<%-- 
    Document   : thingsConsume
    Created on : 2016-10-16, 21:26:00
    Author     : Apple
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            //loading
            div#loading{
                width:50%;
                height:auto;
            }
            div#loading span{
                margin: 0 0 0 47%;
            }
            .sk-cube-grid {
                width: 40px;
                height: 40px;
                margin: 10px auto;
                /*
                 * Spinner positions
                 * 1 2 3
                 * 4 5 6
                 * 7 8 9
                 */ }
            .sk-cube-grid .sk-cube {
                width: 33.33%;
                height: 33.33%;
                background-color:#1d7db1;
                float: left;
                -webkit-animation: sk-cubeGridScaleDelay 1.3s infinite ease-in-out;
                animation: sk-cubeGridScaleDelay 1.3s infinite ease-in-out; }
            .sk-cube-grid .sk-cube1 {
                -webkit-animation-delay: 0.2s;
                animation-delay: 0.2s; }
            .sk-cube-grid .sk-cube2 {
                -webkit-animation-delay: 0.3s;
                animation-delay: 0.3s; }
            .sk-cube-grid .sk-cube3 {
                -webkit-animation-delay: 0.4s;
                animation-delay: 0.4s; }
            .sk-cube-grid .sk-cube4 {
                -webkit-animation-delay: 0.1s;
                animation-delay: 0.1s; }
            .sk-cube-grid .sk-cube5 {
                -webkit-animation-delay: 0.2s;
                animation-delay: 0.2s; }
            .sk-cube-grid .sk-cube6 {
                -webkit-animation-delay: 0.3s;
                animation-delay: 0.3s; }
            .sk-cube-grid .sk-cube7 {
                -webkit-animation-delay: 0.0s;
                animation-delay: 0.0s; }
            .sk-cube-grid .sk-cube8 {
                -webkit-animation-delay: 0.1s;
                animation-delay: 0.1s; }
            .sk-cube-grid .sk-cube9 {
                -webkit-animation-delay: 0.2s;
                animation-delay: 0.2s; }

            @-webkit-keyframes sk-cubeGridScaleDelay {
                0%, 70%, 100% {
                    -webkit-transform: scale3D(1, 1, 1);
                    transform: scale3D(1, 1, 1); }
                35% {
                    -webkit-transform: scale3D(0, 0, 1);
                    transform: scale3D(0, 0, 1); } }

            @keyframes sk-cubeGridScaleDelay {
                0%, 70%, 100% {
                    -webkit-transform: scale3D(1, 1, 1);
                    transform: scale3D(1, 1, 1); }
                35% {
                    -webkit-transform: scale3D(0, 0, 1);
                    transform: scale3D(0, 0, 1); } }

            //other
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
    <body ng-controller="thingsConsume">
        <font>物品消耗</font>
        <br /><br /><br />
        <form role="form" class="form-inline" id="search">
            <input type="text" class="form-control" id="name" name="room_name" placeholder="请输入客房号" />
            <button id="search" class="btn btn-primary disabled" >查找</button>
        </form>

        <div id="loading" class="alert alert-info">
            <div class="sk-cube-grid">
                <div class="sk-cube sk-cube1"></div>
                <div class="sk-cube sk-cube2"></div>
                <div class="sk-cube sk-cube3"></div>
                <div class="sk-cube sk-cube4"></div>
                <div class="sk-cube sk-cube5"></div>
                <div class="sk-cube sk-cube6"></div>
                <div class="sk-cube sk-cube7"></div>
                <div class="sk-cube sk-cube8"></div>
                <div class="sk-cube sk-cube9"></div>
            </div>
            <span>正在加载...</span>
        </div>

        <div id="template">
            <table class="table table-striped table-hover table-bordered"> 
                <thead>
                    <tr>
                        <th class="span8">舱房类型</th>
                        <th class="span4">舱房号</th>
                        <th class="span8">梳子</th>
                        <th class="span8">沐浴露</th>
                        <th class="span4">洗发水</th>
                        <th class="span8">拖鞋</th>
                        <th class="span8">肥皂</th>
                        <th class="span4">牙刷</th>
                        <th class="span6">牙膏</th>
                        <th class="span6">毛巾</th>
                        <th class="span6">日期</th>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-repeat="x in thingsconsume">
                        <th>{{x.room_type}}</th>
                        <th>{{x.room_name}}</th>
                        <th>{{x.comb}}</th>
                        <th>{{x.lotion}}</th>
                        <th>{{x.shamppo}}</th>     
                        <th>{{x.slippers}}</th>
                        <th>{{x.soap}}</th>
                        <th>{{x.toothbrush}}</th> 
                        <th>{{x.toothpaste}}</th>
                        <th>{{x.towel}}</th>
                        <th>{{x.date}}</th>
                    </tr>
                </tbody>
            </table>
        </div>
        
        <div id="search" style="display:none;">
            <button id="return" class="btn btn-info pull-right">返回</button>
            <br /><br />
            <table class="table table-striped table-hover table-bordered"> 
                <thead>
                    <tr>
                        <th class="span8">舱房类型</th>
                        <th class="span4">舱房号</th>
                        <th class="span8">梳子</th>
                        <th class="span8">沐浴露</th>
                        <th class="span4">洗发水</th>
                        <th class="span8">拖鞋</th>
                        <th class="span8">肥皂</th>
                        <th class="span4">牙刷</th>
                        <th class="span6">牙膏</th>
                        <th class="span6">毛巾</th>
                        <th class="span6">日期</th>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-repeat="y in thingsConsumeSearch">
                        <th>{{y.room_type}}</th>
                        <th>{{y.room_name}}</th>
                        <th>{{y.comb}}</th>
                        <th>{{y.lotion}}</th>
                        <th>{{y.shamppo}}</th>     
                        <th>{{y.slippers}}</th>
                        <th>{{y.soap}}</th>
                        <th>{{y.toothbrush}}</th> 
                        <th>{{y.toothpaste}}</th>
                        <th>{{y.towel}}</th>
                        <th>{{y.date}}</th>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>