<%-- 
    Document   : paymentTable
    Created on : 2016-11-4, 21:48:48
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form class="form-inline" name="resrve" action="index/managePaymentInfo/payment" method="post">
                            <input type="text" id="room_name" value="" style="display:none;"/>
                            <label for="tel">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
                            <input class="form-control" name="real_name" type="text" size="25">
                            <br/><br/>
                            <label for="tel">实付金额：</label>
                            <input class="form-control" id="amount" type="text" size="25">
                            <br/><br/>
                            <label for="name">已交押金：
                                <span class="text-info" id="paid">11000</span></label>
                            <br/><br/>
                            <label for="name">应付金额：
                                <span class="text-info" id="shouldpay">12000</span></label>
                            <br/>
                             <table class="table table-hover table-bordered table-striped" style="text-align:center;"> 
                                <caption>消费明细</caption>
                                <thead>
                                    <tr>
                                        <th class="span8">消费地点</th>
                                        <th class="span6">消费类型</th>
                                        <th class="span10">消费时间</th>
                                        <th class="span6">消费金额</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th>零售部</th>
                                        <th>客房交费</th>
                                        <th>2016-09-29 10:22:59.000</th>
                                        <th>500</th>
                                    </tr>
                                    <tr>
                                        <th>餐饮部</th>
                                        <th>法式大餐</th>
                                        <th>2016-09-20 18:27:15.000</th>
                                        <th>280</th>
                                    </tr>
                                </tbody>
                            </table>      
                                 
                            <input type="submit" value="提交">
                        </form>
    </body>
</html>
