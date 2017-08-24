<%-- 
    Document   : saleRate
    Created on : 2016-10-22, 12:07:33
    Author     : Apple
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body ng-controller="saleRate">
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
            div#curiseInfo{
                height: 56px;
                background-color: #f9da83;
            }
            label#curiseName{
                font-size: 24px;
                font-family: "微软雅黑";
                padding: 10px 0 0 20px;
                float: left;
            }

            a#all{
                float: right;
                padding: 20px 15px 0 0; 
            }
            a#all i{
                margin: 0 0 0 5px;
            }
            a.color{
                color: #f9f8f4;
            }

            a.inside{
                background-color: #ec971f;
            }
            i.spread{
                margin: 0 0 0 5px;
            }
            div.cabin{
                float: left;
                padding: 15px 15px 0 0; 
                margin: 0 0 0 40px;
                font-size: 17px;
            }
            div.layer{
                padding: 0; 
                margin: -20px 0 0 90px;
                font-size: 13px;
            }
            a.layer-spread{
                float: right;
                margin: -20px 0 0 0;
            }
            label#feature{
                font-size: 20px;
                font-weight: lighter;
                color: #271f19;
                font-family: "微软雅黑";
            }
        </style>
        <font>销售进度</font>
        <br /><br /><br />
        <form role="form" class="form-inline" id="search">
            <input type="text" class="form-control" id="name" name="room_type" placeholder="请输入舱房类型"/>
            <button id="search" class="btn btn-primary disabled" >查找</button>
        </form>
        <!--邮轮信息-->

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
            <div id="curiseInfo">
                <label id="curiseName" ng-bind="saleRate.curise_name"></label>
                <div class="cabin">
                    <label>总舱位：
                        <span class="text-info" ng-bind="saleRate.total_rooms"></span>
                    </label>
                    &nbsp;&nbsp;
                    <label>已销售：
                        <span class="text-warning" ng-bind="saleRate.sailed"></span>
                    </label>
                    &nbsp;&nbsp;
                    <label>未销售：
                        <span class="text-success" ng-bind="saleRate.unsail"></span>
                    </label>
                </div>
                <a data-toggle="collapse" id="all" data-target=".panel-collapse" href="javascript:void(0);">展开全部<i class="icon-angle-down"></i></a>
            </div>

            <div class="panel-group" id="layerInfo">
                <div class="panel panel-default" ng-repeat="x in saleRate.layerSales">
                    <!--层数信息-->
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <label>层数：
                                <span ng-bind="x.layer"></span>
                            </label>
                            <div class="layer text-muted">
                                <label>总舱位：
                                    <span class="text-info" ng-bind="x.total_rooms"></span>
                                </label>
                                &nbsp;&nbsp;
                                <label>已销售：
                                    <span class="text-warning" ng-bind="x.sailed"></span>
                                </label>
                                &nbsp;&nbsp;
                                <label>未销售：
                                    <span class="text-success" ng-bind="x.unsail"></span>
                                </label>
                            </div>

                            <a class="layer-spread" data-toggle="collapse" href="/saleRate#layer{{ x.layer}}">
                                折叠<i class="icon-angle-up spread"></i>
                            </a>
                        </h4>
                    </div>
                    <!---------->
                    <div id="layer{{x.layer}}" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table table-striped table-hover table-bordered"> 
                                <thead>
                                    <tr>
                                        <th class="span6">舱房类型</th>
                                        <th class="span8">已销售量</th>
                                        <th class="span8">舱房总量</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr ng-repeat="y in x.roomTypeSales">
                                        <th ng-bind="y.room_type"></th>
                                        <th ng-bind="y.saled"></th>
                                        <th ng-bind="y.total_rooms"></th>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="search" style="display:none;">
            <button id="return" class="btn btn-info pull-right">返回</button>
            <br /><br />
            <label id="feature">舱房类型：<span></span></label>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                    <tr>
                        <th>层数</th>
                        <th>舱房总数</th>
                        <th>已销售量</th>
                        <th>未销售量</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>12</td>
                        <td>23</td>
                        <td>12</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
