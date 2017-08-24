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
            <div style="padding: 20px 20px 30px 0px;">
                <label>总营业额表：</label>

                <div class="dropdown choose">
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
                </div>

                <canvas id="whole" width="500" height="200"></canvas>
                <br />
            </div>
            <div id="retailDepart">
                <label>零售部：</label>

                <div class="dropdown choose">
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
                </div>

                <hr />
                <canvas id="retailDepartChart" width="500" height="240"></canvas>
            </div>
            <div id="entertainDepart">
                <label>娱乐事业部：</label>

                <div class="dropdown choose">
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
                </div>

                <hr />
                <canvas id="entertainDepartChart" width="500" height="240"></canvas>
            </div>
            <div id="foodDepart">
                <label>餐饮部：</label>

                <div class="dropdown choose">
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
                </div>

                <hr />
                <canvas id="foodDepartChart" width="500" height="240"></canvas>
            </div>
            <div id="roomDepart">
                <label>客房营收：</label>

                <div class="dropdown choose">
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
                </div>

                <hr />
                <canvas id="roomDepartChart" width="500" height="240"></canvas>
            </div>
        </div>

    </body>
</html>
