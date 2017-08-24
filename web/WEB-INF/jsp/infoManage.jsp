<%-- 
    Document   : infoManage
    Created on : 2016-10-28, 15:21:02
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
            div#loading1, #loading2{
                width:100%;
                padding: 18% 0 0 0;
            }
            div#loading1 span, #loading2 span{
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
            
            div#creditCheck, #realNameRegister{
                border: 1px solid #e5901a;
                border-radius: 15px;
                padding: 20px 20px 30px 20px;
                margin: 10px 10px 20px 0px;
                float:left;
                width:48%;
                height:620px;
                background-color: #FFFcF9;
            }
            div#customerPayment{
                border: 1px solid #e5901a;
                border-radius: 15px;
                padding: 20px 20px 30px 20px;
                margin: 10px 0px 30px 0px;
                width:100%;
                height:660px;
                float: left;
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
            <div id="creditCheck">
                <label>信用度审查：</label>

                <button id="total" class="btn btn-default choose">总体</button>

                <div class="dropdown choose">
                    <a id="accordSex" class="btn btn-success dropdown-toggle pull-right " data-toggle="dropdown">
                        性别
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordSex">
                        <li><a class="sex2">男</a></li>
                        <li><a class="sex2">女</a></li>
                    </ul>
                </div>

                <div class="dropdown choose">
                    <a id="accordOccup" class="btn btn-primary dropdown-toggle pull-right " data-toggle="dropdown">
                        职业
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordOccup">
                        <li><a class="occup2" ng-click="send($event)" ng-repeat="x in occupList">{{x}}</a></li>
                        <!--<li><a class="occup2">总经理</a></li>
                        <li><a class="occup2">主任</a></li>
                        <li><a class="occup2">保镖</a></li>
                        <li><a class="occup2">其他</a></li>-->
                    </ul>
                </div>

                <div class="dropdown choose">
                    <a id="accordAge" class="btn btn-info dropdown-toggle pull-right " data-toggle="dropdown">
                        年龄
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordSex2">
                        <li><a class="age2">童年</a></li>
                        <li><a class="age2">少年</a></li>
                        <li><a class="age2">青年</a></li>
                        <li><a class="age2">中年</a></li>
                        <li><a class="age2">老年</a></li>
                    </ul>
                </div>
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
                
                <canvas id="creditCheckChart" width="300" height="300"></canvas>
            </div>
            <div id="realNameRegister">
                <label>实名制登记：</label>
                <button id="total2" class="btn btn-default choose">总体</button>

                <div class="dropdown choose">
                    <a id="accordSex2" class="btn btn-success dropdown-toggle pull-right " data-toggle="dropdown">
                        性别
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordSex2">
                        <li><a id="allsex" data-toggle="tab">总体</a></li>
                        <li><a class="sex">男</a></li>
                        <li><a class="sex">女</a></li>
                    </ul>
                </div>

                <div class="dropdown choose">
                    <a id="accordOccup2" class="btn btn-primary dropdown-toggle pull-right " data-toggle="dropdown">
                        职业
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordOccup">
                        <li><a id="alloccup">总体</a></li>
                        <li><a class="occup" ng-click="other($event)" ng-repeat="x in occupList">{{x}}</a></li>
                        <!--<li><a class="occup">总经理</a></li>
                        <li><a class="occup">主任</a></li>
                        <li><a class="occup">保镖</a></li>
                        <li><a class="occup">其他</a></li>-->
                    </ul>
                </div>

                <div class="dropdown choose">
                    <a id="accordAge2" class="btn btn-info dropdown-toggle pull-right " data-toggle="dropdown">
                        年龄
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordSex2">
                        <li><a id="allage">总体</a></li>
                        <li><a class="age">童年</a></li>
                        <li><a class="age">少年</a></li>
                        <li><a class="age">青年</a></li>
                        <li><a class="age">中年</a></li>
                        <li><a class="age">老年</a></li>
                    </ul>
                </div>
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
                
                <canvas id="realNameRegisterChart" width="500" height="500"></canvas>
            </div>
            <!--<div id="customerPayment">
                <label>客人消费：</label>
                <hr />
                <canvas id="customerPaymentChart" width="1000" height="500"></canvas>
            </div>-->
        </div>

    </body>
</html>
