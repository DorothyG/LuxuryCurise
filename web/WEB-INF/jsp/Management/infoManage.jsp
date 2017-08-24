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
            div#creditCheck, #realNameRegister{
                border: 1px solid #e5901a;
                border-radius: 15px;
                padding: 20px 20px 30px 20px;
                margin: 10px 20px 20px 0px;
                float:left;
                width:520px;
                height:620px;
                background-color: #FFFcF9;
            }
            div#customerPayment{
                border: 1px solid #e5901a;
                border-radius: 15px;
                padding: 20px 20px 30px 20px;
                margin: 10px 0px 30px 0px;
                width:1088px;
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
                    <a id="accordThings" class="btn btn-success dropdown-toggle pull-right " data-toggle="dropdown">
                        性别
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">男</a></li>
                        <li><a data-toggle="tab">女</a></li>
                    </ul>
                </div>

                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-primary dropdown-toggle pull-right " data-toggle="dropdown">
                        职业
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">职员</a></li>
                        <li><a data-toggle="tab">教授</a></li>
                    </ul>
                </div>

                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-info dropdown-toggle pull-right " data-toggle="dropdown">
                        年龄
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">青少年（16-18）</a></li>
                        <li><a data-toggle="tab">中年（35-40）</a></li>
                    </ul>
                </div>
                <hr />
                <canvas id="creditCheckChart" width="300" height="300"></canvas>
            </div>
            <div id="realNameRegister">
                <label>实名制登记：</label>
                <button id="total" class="btn btn-default choose">总体</button>

                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-success dropdown-toggle pull-right " data-toggle="dropdown">
                        性别
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">男</a></li>
                        <li><a data-toggle="tab">女</a></li>
                    </ul>
                </div>

                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-primary dropdown-toggle pull-right " data-toggle="dropdown">
                        职业
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">职员</a></li>
                        <li><a data-toggle="tab">教授</a></li>
                    </ul>
                </div>

                <div class="dropdown choose">
                    <a id="accordThings" class="btn btn-info dropdown-toggle pull-right " data-toggle="dropdown">
                        年龄
                    </a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="accordThings">
                        <li><a data-toggle="tab">青少年（16-18）</a></li>
                        <li><a data-toggle="tab">中年（35-40）</a></li>
                    </ul>
                </div>
                <hr />
                <canvas id="realNameRegisterChart" width="500" height="500"></canvas>
            </div>
            <div id="customerPayment">
                <label>客人消费：</label>
                <hr />
                <canvas id="customerPaymentChart" width="1000" height="500"></canvas>
            </div>
        </div>

    </body>
</html>
