<%-- 
    Document   : reserve
    Created on : 2016-10-22, 11:59:44
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
                margin: 0 15px 10px 0;
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
            div.modal-body{
                padding: 20px 0 0 130px;
            }
            a.layer-spread{
                float: right;
                margin: -20px 0 0 0;
            }
        </style>

        <font>预定登记：</font>
        <br /><br /><br />

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

        <!--<form role="form" class="form-inline" id="search">
            <input type="text" class="form-control" id="name" name="check" />
            <input type="submit" name="submit" value="查找" class="btn btn-primary" />
        </form>-->
        <div ng-controller="reserve">
            <!--邮轮信息-->
            <div id="curiseInfo">
                <label id="curiseName" ng-bind="reserve.curise_name"></label>
                <div class="cabin">
                    <label>总舱位：
                        <span class="text-info" ng-bind="reserve.total_rooms"></span>
                    </label>
                    &nbsp;&nbsp;
                    <label>已预订：
                        <span class="text-warning" ng-bind="reserve.reserved"></span>
                    </label>
                    &nbsp;&nbsp;
                    <label>剩余：
                        <span class="text-success" ng-bind="reserve.remainder"></span>
                    </label>
                    &nbsp;&nbsp;
                    <label>入住：
                        <span class="text-danger" ng-bind="reserve.checked_in">0</span>
                    </label>
                </div>
                <a data-toggle="collapse" id="all" data-target=".panel-collapse">展开全部<i class="icon-angle-down"></i></a>
            </div>

            <div class="panel-group" id="layerInfo">
                <div class="panel panel-default" ng-repeat="x in reserve.layerReserves">
                    <!--层数信息-->
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <label>层数：
                                <span ng-bind="x.layer" ></span>
                            </label>
                            <div class="layer text-muted">
                                <label>总舱位：
                                    <span class="text-info" ng-bind="x.total_rooms"></span>
                                </label>
                                &nbsp;&nbsp;
                                <label>已预订：
                                    <span class="text-warning" ng-bind="x.reserved"></span>
                                </label>
                                &nbsp;&nbsp;
                                <label>剩余：
                                    <span class="text-success" ng-bind="x.remainder"></span>
                                </label>
                                &nbsp;&nbsp;
                                <label>入住：
                                    <span class="text-danger" ng-bind="x.checked_in"></span>
                                </label>
                            </div>

                            <a class="layer-spread" data-toggle="collapse" href="/reserve#layer{{x.layer}}">
                                折叠<i class="icon-angle-up spread"></i>
                            </a>
                        </h4>
                    </div>
                    <!---------->
                    <div id="layer{{x.layer}}" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <span ng-repeat="y in x.roomTypeLayerReserves">
                                <a ng-if="y.room_type == '内舱房' && y.check_in_state == '未入住'" class="btn btn-info color" data-toggle="modal" data-target="#myModal">
                                    <p ng-bind="y.room_type"></p>
                                    <h3 ng-bind="y.room_name"></h3>
                                    <p ng-bind="y.check_in_state"></p>
                                </a>
                                <a ng-if="y.room_type == '套房' && y.check_in_state == '未入住'" class="btn btn-primary color" data-toggle="modal" data-target="#myModal">
                                    <p ng-bind="y.room_type"></p>
                                    <h3 ng-bind="y.room_name"></h3>
                                    <p ng-bind="y.check_in_state"></p>
                                </a>
                                <a ng-if="y.room_type == '海景房' && y.check_in_state == '未入住'" class="btn btn-success color" data-toggle="modal" data-target="#myModal">
                                    <p ng-bind="y.room_type"></p>
                                    <h3 ng-bind="y.room_name"></h3>
                                    <p ng-bind="y.check_in_state"></p>
                                </a>
                                <a ng-if="y.room_type == '阳台房' && y.check_in_state == '未入住'" class="btn btn-warning color" data-toggle="modal" data-target="#myModal">
                                    <p ng-bind="y.room_type"></p>
                                    <h3 ng-bind="y.room_name"></h3>
                                    <p ng-bind="y.check_in_state"></p>
                                </a>
                                <!--      
                                <span ng-switch="y.check_in_state">
                                    <a ng-switch-when="未入住" class="btn btn-warning color" data-toggle="modal" data-target="#myModal">
                                        <p ng-bind="y.room_type"></p>
                                        <h3 ng-bind="y.room_name"></h3>
                                        <p ng-bind="y.check_in_state"></p>
                                    </a>
                                </span>
                                <!--<span ng-switch="y.room_type">
                                    <a ng-switch-when="内舱房" class="btn btn-info color" data-toggle="modal" data-target="#myModal">
                                        <!--<span ng-switch="y.check_in_state">
                                            <p ng-bind="y.room_type"></p>
                                            <h3 ng-bind="y.room_name"></h3>
                                            <p ng-bind="y.check_in_state"></p>
                                            <!--<p ng-switch-when="已入住" class="color1" ng-bind="y.check_in_state"></p>
                                            <p ng-switch-when="待入住" class="color" ng-bind="y.check_in_state"></p>
                                            <p ng-switch-when="未入住" class="color2" ng-bind="y.check_in_state"></p>-->
                                        <!--</span>
                                    </a>

                                    <a ng-switch-when="套房" class="btn btn-primary color" data-toggle="modal" data-target="#myModal">
                                        <p ng-bind="y.room_type"></p>
                                        <h3 ng-bind="y.room_name"></h3>
                                        <p ng-bind="y.check_in_state"></p>
                                    </a>

                                    <a ng-switch-when="海景房" class="btn btn-success color" data-toggle="modal" data-target="#myModal">
                                        <p ng-bind="y.room_type"></p>
                                        <h3 ng-bind="y.room_name"></h3>
                                        <p ng-bind="y.check_in_state"></p>
                                    </a>

                                    <a ng-switch-when="阳台房" class="btn btn-warning color" data-toggle="modal" data-target="#myModal">
                                        <p ng-bind="y.room_type"></p>
                                        <h3 ng-bind="y.room_name"></h3>
                                        <p ng-bind="y.check_in_state"></p>
                                    </a>
                                </span>-->
                            </span>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <form class="form-inline" name="reserve" method="post">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabelab">
                                客房预订
                            </h4>
                        </div>
                        <div class="modal-body">
                            <input type="text" id="room_name" style="display:none;"/>
                            <label for="name">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
                            <input class="form-control" name="user_name" type="text" size="25" >
                            <br/><br/>
                            <label for="name">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
                            <label class="checkbox-inline">
                                <input type="radio" name="sex" value="male" checked="checked"/>男
                            </label>
                            <label class="checkbox-inline">
                                <input type="radio" name="sex" value="female"/>女
                            </label>
                            <br/><br/>
                            <label for="tel">联系方式：</label>
                            <input class="form-control" name="phone_number" type="text" size="25" name="phone_number">
                            <br/><br/>
                            <label for="name">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</label>
                            <input class="form-control" name="occupation" type="text" size="25" name="occupation">
                            <br/><br/>
                            <label for="name">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</label>
                            <input class="form-control" name="age" type="text" size="25" name="age">
                            <br/><br/>
                            <label for="tel">身份证号：</label>
                            <input class="form-control" name="ID_number" type="text" size="25" name="ID_number">
                            <br/><br/>
                            <label for="tel">预定日期：
                                <input class="form-control" name="time" type="text" size="22" readOnly="true" ng-model="time" />
                            </label>
                            <br/><br/>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消
                            </button>
                            <button type="button" id="print" class="btn btn-info">
                                打印
                            </button>
                            <button type="button" id="ok" class="btn btn-primary">
                                确定
                            </button>
                        </div>
                    </div><!-- /.modal-content -->
                </form>
            </div><!-- /.modal -->
        </div>
    </body>
</html>
