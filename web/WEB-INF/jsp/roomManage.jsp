<%-- 
    Document   : roomManage
    Created on : 2016-10-28, 15:20:28
    Author     : Apple
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <style>
            //loading
            div#loading{
                width:50%;
                height:auto;
            }
            div#loading1, #loading2, #loading3, #loading4{
                width:100%;
                padding: 18% 0 0 0;
            }
            div#loading span, #loading1 span, #loading2 span, #loading3 span, #loading4 span{
                margin: 0 0 0 47%;
            }
            .sk-circle {
                margin: 40px auto;
                width: 40px;
                height: 40px;
                position: relative; }
            .sk-circle .sk-child {
                width: 100%;
                height: 100%;
                position: absolute;
                left: 0;
                top: 0; }
            .sk-circle .sk-child:before {
                content: '';
                display: block;
                margin: 0 auto;
                width: 15%;
                height: 15%;
                background-color: #1d7db1;
                border-radius: 100%;
                -webkit-animation: sk-circleBounceDelay 1.2s infinite ease-in-out both;
                animation: sk-circleBounceDelay 1.2s infinite ease-in-out both; }
            .sk-circle .sk-circle2 {
                -webkit-transform: rotate(30deg);
                -ms-transform: rotate(30deg);
                transform: rotate(30deg); }
            .sk-circle .sk-circle3 {
                -webkit-transform: rotate(60deg);
                -ms-transform: rotate(60deg);
                transform: rotate(60deg); }
            .sk-circle .sk-circle4 {
                -webkit-transform: rotate(90deg);
                -ms-transform: rotate(90deg);
                transform: rotate(90deg); }
            .sk-circle .sk-circle5 {
                -webkit-transform: rotate(120deg);
                -ms-transform: rotate(120deg);
                transform: rotate(120deg); }
            .sk-circle .sk-circle6 {
                -webkit-transform: rotate(150deg);
                -ms-transform: rotate(150deg);
                transform: rotate(150deg); }
            .sk-circle .sk-circle7 {
                -webkit-transform: rotate(180deg);
                -ms-transform: rotate(180deg);
                transform: rotate(180deg); }
            .sk-circle .sk-circle8 {
                -webkit-transform: rotate(210deg);
                -ms-transform: rotate(210deg);
                transform: rotate(210deg); }
            .sk-circle .sk-circle9 {
                -webkit-transform: rotate(240deg);
                -ms-transform: rotate(240deg);
                transform: rotate(240deg); }
            .sk-circle .sk-circle10 {
                -webkit-transform: rotate(270deg);
                -ms-transform: rotate(270deg);
                transform: rotate(270deg); }
            .sk-circle .sk-circle11 {
                -webkit-transform: rotate(300deg);
                -ms-transform: rotate(300deg);
                transform: rotate(300deg); }
            .sk-circle .sk-circle12 {
                -webkit-transform: rotate(330deg);
                -ms-transform: rotate(330deg);
                transform: rotate(330deg); }
            .sk-circle .sk-circle2:before {
                -webkit-animation-delay: -1.1s;
                animation-delay: -1.1s; }
            .sk-circle .sk-circle3:before {
                -webkit-animation-delay: -1s;
                animation-delay: -1s; }
            .sk-circle .sk-circle4:before {
                -webkit-animation-delay: -0.9s;
                animation-delay: -0.9s; }
            .sk-circle .sk-circle5:before {
                -webkit-animation-delay: -0.8s;
                animation-delay: -0.8s; }
            .sk-circle .sk-circle6:before {
                -webkit-animation-delay: -0.7s;
                animation-delay: -0.7s; }
            .sk-circle .sk-circle7:before {
                -webkit-animation-delay: -0.6s;
                animation-delay: -0.6s; }
            .sk-circle .sk-circle8:before {
                -webkit-animation-delay: -0.5s;
                animation-delay: -0.5s; }
            .sk-circle .sk-circle9:before {
                -webkit-animation-delay: -0.4s;
                animation-delay: -0.4s; }
            .sk-circle .sk-circle10:before {
                -webkit-animation-delay: -0.3s;
                animation-delay: -0.3s; }
            .sk-circle .sk-circle11:before {
                -webkit-animation-delay: -0.2s;
                animation-delay: -0.2s; }
            .sk-circle .sk-circle12:before {
                -webkit-animation-delay: -0.1s;
                animation-delay: -0.1s; }

            @-webkit-keyframes sk-circleBounceDelay {
                0%, 80%, 100% {
                    -webkit-transform: scale(0);
                    transform: scale(0); }
                40% {
                    -webkit-transform: scale(1);
                    transform: scale(1); } }

            @keyframes sk-circleBounceDelay {
                0%, 80%, 100% {
                    -webkit-transform: scale(0);
                    transform: scale(0); }
                40% {
                    -webkit-transform: scale(1);
                    transform: scale(1); } }

            //other
            div#legend{
                font-size: 15px;
                font-weight:550;
                padding:10px;
            }
            div#table{
                width:100%;
                height: 50%;
                font-size: 15px;
            }
            div#checkInState,#roomUseState{
                border: 1px solid #e5901a;
                border-radius: 15px;
                padding: 20px 20px 30px 20px;
                margin: 10px 0px 10px 0px;
                width:100%;
                height:660px;
                background-color: #FFFcF9;
            }
            div#customerGroupState,#ageLevelState{
                border: 1px solid #e5901a;
                border-radius: 15px;
                padding: 20px 20px 30px 20px;
                margin: 10px 44px 20px 0px;
                float:left;
                width:45%;
                height:600px;
                background-color: #FFFcF9;
            }
            .choose{
                margin: 12px 8px 0 0;
                float: right;
            }
            hr{
                border-top: 1px dashed #e5901a;
            }
        </style>
        <div>
            <label>总表：</label>

            <div id="loading" class="alert alert-info">
                <div class="sk-circle">
                    <div class="sk-circle1 sk-child"></div>
                    <div class="sk-circle2 sk-child"></div>
                    <div class="sk-circle3 sk-child"></div>
                    <div class="sk-circle4 sk-child"></div>
                    <div class="sk-circle5 sk-child"></div>
                    <div class="sk-circle6 sk-child"></div>
                    <div class="sk-circle7 sk-child"></div>
                    <div class="sk-circle8 sk-child"></div>
                    <div class="sk-circle9 sk-child"></div>
                    <div class="sk-circle10 sk-child"></div>
                    <div class="sk-circle11 sk-child"></div>
                    <div class="sk-circle12 sk-child"></div>
                </div>
                <span>正在加载...</span>
            </div>

            <div id="legend">
                <span class="text-danger">红色</span>为已入住
                <span class="text-success">绿色</span>为未入住
                <span class="text-info">蓝色</span>为待入住
            </div>
            <div id="table">
                <table class="table table-hover table-bordered table-striped"> 
                    <thead>
                        <tr>
                            <th class="span6 text-center">层数</th>
                            <th class="span8 text-center">内舱房</th>
                            <th class="span8 text-center">海景房</th>
                            <th class="span8 text-center">露台海景房</th>
                            <th class="span8 text-center">套房</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr ng-repeat="x in totalLayerCheckin.layerCheckinList">
                            <td class="text-center" ng-bind="x.layer"></th>
                            <td class="text-center" ng-repeat="y in x.roomTypeCheckinList">
                                <span class="text-danger" ng-bind="y.wait_checkin"></span>/
                                <span class="text-success" ng-bind="y.havenot_checkin"></span>/
                                <span class="text-info" ng-bind="y.already_checkin"></span>
                            </td>
                            <!--<th class="text-center">15/15</th>
                            <th class="text-center">15/15</th>
                            <th class="text-center">15/15</th>-->
                        </tr>
                        <tr>
                            <th class="text-center">客房使用率</th>
                            <td class="text-center" ng-bind="totalLayerCheckin.utilizationRate[0]"></td>
                            <td class="text-center" ng-bind="totalLayerCheckin.utilizationRate[1]"></td>
                            <td class="text-center" ng-bind="totalLayerCheckin.utilizationRate[2]"></td>
                            <td class="text-center" ng-bind="totalLayerCheckin.utilizationRate[3]"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div id="checkInState">
                <label>入住状态:</label>

                <button id="total" class="btn btn-info pull-right choose">总体</button>
                <button id="accordLayer" class="btn btn-primary pull-right choose">按层数</button>
                <button id="accordType" class="btn btn-success pull-right choose">按舱房类型</button>

                <hr />

                <div id="loading1">
                    <div class="sk-circle">
                        <div class="sk-circle1 sk-child"></div>
                        <div class="sk-circle2 sk-child"></div>
                        <div class="sk-circle3 sk-child"></div>
                        <div class="sk-circle4 sk-child"></div>
                        <div class="sk-circle5 sk-child"></div>
                        <div class="sk-circle6 sk-child"></div>
                        <div class="sk-circle7 sk-child"></div>
                        <div class="sk-circle8 sk-child"></div>
                        <div class="sk-circle9 sk-child"></div>
                        <div class="sk-circle10 sk-child"></div>
                        <div class="sk-circle11 sk-child"></div>
                        <div class="sk-circle12 sk-child"></div>
                    </div>
                    <span>正在加载...</span>
                </div>

                <canvas id='checkInStateChart' width='1000' height='500'></canvas>
            </div>
            <br />
            <div id="roomUseState">
                <label>客房使用:</label>

                <!--<div class="dropdown choose">
                    <a id="accordThings" class="btn btn-info dropdown-toggle pull-right " data-toggle="dropdown">
                        选择物品
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">梳子</a></li>
                        <li><a data-toggle="tab">毛巾</a></li>
                    </ul>
                </div>-->

                <hr />
                
                <div id="loading2">
                    <div class="sk-circle">
                        <div class="sk-circle1 sk-child"></div>
                        <div class="sk-circle2 sk-child"></div>
                        <div class="sk-circle3 sk-child"></div>
                        <div class="sk-circle4 sk-child"></div>
                        <div class="sk-circle5 sk-child"></div>
                        <div class="sk-circle6 sk-child"></div>
                        <div class="sk-circle7 sk-child"></div>
                        <div class="sk-circle8 sk-child"></div>
                        <div class="sk-circle9 sk-child"></div>
                        <div class="sk-circle10 sk-child"></div>
                        <div class="sk-circle11 sk-child"></div>
                        <div class="sk-circle12 sk-child"></div>
                    </div>
                    <span>正在加载...</span>
                </div>
                
                <canvas id="roomUseStateChart" width="1000" height="500"></canvas>
            </div>
            <br />
            <div id="customerGroupState">
                <label>消费群体：</label>

                <button id="accordOccup" class="btn btn-success pull-right choose">职业</button>
                <button id="accordSex" class="btn btn-info pull-right choose">性别</button>

                <hr />
                
                <div id="loading3">
                    <div class="sk-circle">
                        <div class="sk-circle1 sk-child"></div>
                        <div class="sk-circle2 sk-child"></div>
                        <div class="sk-circle3 sk-child"></div>
                        <div class="sk-circle4 sk-child"></div>
                        <div class="sk-circle5 sk-child"></div>
                        <div class="sk-circle6 sk-child"></div>
                        <div class="sk-circle7 sk-child"></div>
                        <div class="sk-circle8 sk-child"></div>
                        <div class="sk-circle9 sk-child"></div>
                        <div class="sk-circle10 sk-child"></div>
                        <div class="sk-circle11 sk-child"></div>
                        <div class="sk-circle12 sk-child"></div>
                    </div>
                    <span>正在加载...</span>
                </div>
                
                <canvas id="customerGroupStateChart" width="200" height="200"></canvas>
            </div>
            <div id="ageLevelState">
                <label>年龄阶段：</label>
                <hr />
                
                <div id="loading4">
                    <div class="sk-circle">
                        <div class="sk-circle1 sk-child"></div>
                        <div class="sk-circle2 sk-child"></div>
                        <div class="sk-circle3 sk-child"></div>
                        <div class="sk-circle4 sk-child"></div>
                        <div class="sk-circle5 sk-child"></div>
                        <div class="sk-circle6 sk-child"></div>
                        <div class="sk-circle7 sk-child"></div>
                        <div class="sk-circle8 sk-child"></div>
                        <div class="sk-circle9 sk-child"></div>
                        <div class="sk-circle10 sk-child"></div>
                        <div class="sk-circle11 sk-child"></div>
                        <div class="sk-circle12 sk-child"></div>
                    </div>
                    <span>正在加载...</span>
                </div>
                
                <canvas id="ageLevelStateChart" width="200" height="200"></canvas>
            </div>
        </div>

    </body>
</html>
