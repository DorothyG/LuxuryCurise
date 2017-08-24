<%-- 
    Document   : engageManage
    Created on : 2016-10-28, 15:21:42
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

            div#retailDepart, #entertainDepart, #foodDepart, #roomDepart{
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
            <div id="total" style="padding: 20px 20px 30px 0px;">
                <label>总营业额表：</label>

                <button id="totalAccordYear" class="btn btn-info choose pull-right ">按年份</button>
                <button id="totalAccordQuater" class="btn btn-primary choose pull-right ">按季度</button>
                <button id="totalAccordMonth" class="btn btn-success choose pull-right ">按月份</button>

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

                <!--<div class="dropdown choose">
                    <a id="accordThings" class="btn btn-info dropdown-toggle pull-right " data-toggle="dropdown">
                        按年份
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">2016</a></li>
                        <li><a data-toggle="tab">2015</a></li>
                    </ul>
                </div>
                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-primary dropdown-toggle pull-right " data-toggle="dropdown">
                        按季度
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">1</a></li>
                        <li><a data-toggle="tab">2</a></li>
                    </ul>
                </div>
                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-success dropdown-toggle pull-right " data-toggle="dropdown">
                        按月份
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">1</a></li>
                        <li><a data-toggle="tab">2</a></li>
                    </ul>
                </div>-->

                <canvas id="whole" width="500" height="200"></canvas>
                <br />
            </div>
            <div id="retailDepart">
                <label>零售部：</label>

                <button id="retailAccordYear" class="btn btn-info choose pull-right ">按年份</button>
                <button id="retailAccordQuater" class="btn btn-primary choose pull-right ">按季度</button>
                <button id="retailAccordMonth" class="btn btn-success choose pull-right ">按月份</button>

                <!--<div class="dropdown choose">
                    <a id="accordThings" class="btn btn-info dropdown-toggle pull-right " data-toggle="dropdown">
                        按年份
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">2016</a></li>
                        <li><a data-toggle="tab">2015</a></li>
                    </ul>
                </div>
                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-primary dropdown-toggle pull-right " data-toggle="dropdown">
                        按季度
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">1</a></li>
                        <li><a data-toggle="tab">2</a></li>
                    </ul>
                </div>
                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-success dropdown-toggle pull-right " data-toggle="dropdown">
                        按月份
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">1</a></li>
                        <li><a data-toggle="tab">2</a></li>
                    </ul>
                </div>-->

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
                
                <canvas id="retailDepartChart" width="500" height="240"></canvas>
            </div>
            <div id="entertainDepart">
                <label>娱乐事业部：</label>

                <button id="entertainAccordYear" class="btn btn-info choose pull-right ">按年份</button>
                <button id="entertainAccordQuater" class="btn btn-primary choose pull-right ">按季度</button>
                <button id="entertainAccordMonth" class="btn btn-success choose pull-right ">按月份</button>

                <!--<div class="dropdown choose">
                    <a id="accordThings" class="btn btn-info dropdown-toggle pull-right " data-toggle="dropdown">
                        按年份
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">2016</a></li>
                        <li><a data-toggle="tab">2015</a></li>
                    </ul>
                </div>
                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-primary dropdown-toggle pull-right " data-toggle="dropdown">
                        按季度
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">1</a></li>
                        <li><a data-toggle="tab">2</a></li>
                    </ul>
                </div>
                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-success dropdown-toggle pull-right " data-toggle="dropdown">
                        按月份
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">1</a></li>
                        <li><a data-toggle="tab">2</a></li>
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
                
                <canvas id="entertainDepartChart" width="500" height="240"></canvas>
            </div>
            <div id="foodDepart">
                <label>餐饮部：</label>

                <button id="foodAccordYear" class="btn btn-info choose pull-right ">按年份</button>
                <button id="foodAccordQuater" class="btn btn-primary choose pull-right ">按季度</button>
                <button id="foodAccordMonth" class="btn btn-success choose pull-right ">按月份</button>

                <!--<div class="dropdown choose">
                    <a id="accordThings" class="btn btn-info dropdown-toggle pull-right " data-toggle="dropdown">
                        按年份
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">2016</a></li>
                        <li><a data-toggle="tab">2015</a></li>
                    </ul>
                </div>
                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-primary dropdown-toggle pull-right " data-toggle="dropdown">
                        按季度
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">1</a></li>
                        <li><a data-toggle="tab">2</a></li>
                    </ul>
                </div>
                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-success dropdown-toggle pull-right " data-toggle="dropdown">
                        按月份
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">1</a></li>
                        <li><a data-toggle="tab">2</a></li>
                    </ul>
                </div>-->

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
                
                <canvas id="foodDepartChart" width="500" height="240"></canvas>
            </div>
            <div id="roomDepart">
                <label>客房营收：</label>

                <button id="roomAccordYear" class="btn btn-info choose pull-right ">按年份</button>
                <button id="roomAccordQuater" class="btn btn-primary choose pull-right ">按季度</button>
                <button id="roomAccordMonth" class="btn btn-success choose pull-right ">按月份</button>

                <!--<div class="dropdown choose">
                    <a id="accordThings" class="btn btn-info dropdown-toggle pull-right " data-toggle="dropdown">
                        按年份
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">2016</a></li>
                        <li><a data-toggle="tab">2015</a></li>
                    </ul>
                </div>
                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-primary dropdown-toggle pull-right " data-toggle="dropdown">
                        按季度
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">1</a></li>
                        <li><a data-toggle="tab">2</a></li>
                    </ul>
                </div>
                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-success dropdown-toggle pull-right " data-toggle="dropdown">
                        按月份
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">1</a></li>
                        <li><a data-toggle="tab">2</a></li>
                    </ul>
                </div>-->

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
                
                <canvas id="roomDepartChart" width="500" height="240"></canvas>
            </div>
        </div>

    </body>
</html>
