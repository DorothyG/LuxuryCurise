<%-- 
    Document   : depositPayTable
    Created on : 2016-11-4, 21:50:58
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
       <form class="form-inline" name="resrve" action="/index/managePaymentInfo/deposit" method="post">
                            <input type="text" id="room_name" value="" style="display:none;"/>
                            <label for="tel">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
                            <input class="form-control" name="real_name" type="text" size="25">
                            <br/><br/>
                            <label for="name">补交金额：</label>
                            <input class="form-control" name="deposite_amount" type="text" size="25" readonly="true" ng-model="amount">
                            <br/><br/>         
                            <label for="name">补交时间：</label>
                            <input class="form-control" name="time" type="text" size="25" readonly="true" ng-model="time">
                            <br /><br />
                            <input type="submit" value="提交">
                        </form>
    </body>
</html>
