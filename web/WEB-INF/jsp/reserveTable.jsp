<%-- 
    Document   : reserveInfoTable
    Created on : 2016-11-4, 21:48:06
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
          <form class="form-inline" name="resrve" action="index/manageReserveInfo/reserve" method="post">
         <input type="text" name="room_name" value="" style="display:none;"/>
                            <label for="name">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
                            <input class="form-control" name="real_name" type="text" size="25" >
                            <br/><br/>
                            <label for="name">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
                            <label class="checkbox-inline">
                                <input type="radio" name="sex" value="2" checked="checked"/>男
                            </label>
                            <label class="checkbox-inline">
                                <input type="radio" name="sex" value="1"/>女
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
                                <input class="form-control" name="time" type="text" size="22"  ng-model="time" />
                            </label>
                            <br/><br/>
                             <label for="tel">房间号：</label>
                            <input class="form-control" name="room_name" type="text" size="25" name="room_name">
                            <br/><br/>
                            <input type="submit" value="提交">
          </form>
    </body>
</html>
