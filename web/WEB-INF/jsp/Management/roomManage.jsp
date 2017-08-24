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
                width:1088px;
                height:660px;
                background-color: #FFFcF9;
            }
            div#customerGroupState,#ageLevelState{
                border: 1px solid #e5901a;
                border-radius: 15px;
                padding: 20px 20px 30px 20px;
                margin: 10px 44px 20px 0px;
                float:left;
                width:500px;
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
            <br />
            <label>总表：</label>
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
                        <tr>
                            <th class="text-center">一层</th>
                            <th class="text-center">
                                <span class="text-danger">15</span>/
                                <span class="text-success">15</span>/
                                <span class="text-info">0</span>
                            </th>
                            <th class="text-center">15/15</th>
                            <th class="text-center">15/15</th>
                            <th class="text-center">15/15</th>
                        </tr>
                        <tr>
                            <th class="text-center">二层</th>
                            <th class="text-center">
                                <span class="text-danger">15</span>/
                                <span class="text-success">15</span>
                            </th>
                            <th class="text-center">15/15</th>
                            <th class="text-center">15/15</th>
                            <th class="text-center">15/15</th>
                        </tr>
                        <tr>
                            <th class="text-center">客房使用率</th>
                            <th class="text-center"></th>
                            <th class="text-center">15/15</th>
                            <th class="text-center">15/15</th>
                            <th class="text-center">15/15</th>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div id="checkInState">
                <label>入住状态:</label>

                <button id="total" class="btn btn-info pull-right choose">总体</button>

                <div class="dropdown choose">
                    <a id="accordLayer" class="btn btn-primary dropdown-toggle pull-right " data-toggle="dropdown">
                        按层数
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordLayer">
                        <li><a data-toggle="tab">一层</a></li>
                        <li><a data-toggle="tab">二层</a></li>
                    </ul>
                </div>

                <div class="dropdown choose">
                    <a id="accordType" class="btn btn-success dropdown-toggle pull-right" data-toggle="dropdown">
                        按舱房类型
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordType">
                        <li><a data-toggle="tab">内舱房</a></li>
                        <li><a data-toggle="tab">套房</a></li>
                    </ul>
                </div>
                <hr />
                <canvas id='checkInStateChart' width='1000' height='500'></canvas>
            </div>
            <br />
            <div id="roomUseState">
                <label>客房使用:</label>

                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-info dropdown-toggle pull-right " data-toggle="dropdown">
                        选择物品
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">梳子</a></li>
                        <li><a data-toggle="tab">毛巾</a></li>
                    </ul>
                </div>
                <!--        <div class="input-group date form_date col-md-3 choose" data-date=""
                             data-date-format="yyyy MM dd">
                            <input class="form-control" size="16" type="text" value="" readonly>
                            <span class="input-group-addon"><i class="icon-remove"></i></span>
                            <span class="input-group-addon"><i class="icon-calendar"></i></span>
                        </div>-->

                <hr />
                <canvas id="roomUseStateChart" width="1000" height="500"></canvas>
            </div>
            <br />
            <div id="customerGroupState">
                <label>消费群体：</label>

                <div class="dropdown choose">
                    <a id="accordSex" class="btn btn-info dropdown-toggle pull-right " data-toggle="dropdown">
                        性别
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordSex">
                        <li><a data-toggle="tab">男</a></li>
                        <li><a data-toggle="tab">女</a></li>
                    </ul>
                </div>
                <div class="dropdown choose">
                    <a id="accordOccup" class="btn btn-success dropdown-toggle pull-right " data-toggle="dropdown">
                        职业
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordOccup">
                        <li><a data-toggle="tab">职员</a></li>
                        <li><a data-toggle="tab">教授</a></li>
                    </ul>
                </div>
                <hr />
                <canvas id="customerGroupStateChart" width="200" height="200"></canvas>
            </div>
            <div id="ageLevelState">
                <label>年龄阶段：</label>
                <hr />
                <canvas id="ageLevelStateChart" width="200" height="200"></canvas>
            </div>
        </div>

    </body>
</html>
