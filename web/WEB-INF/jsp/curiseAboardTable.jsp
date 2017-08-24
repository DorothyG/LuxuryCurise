<%-- 
    Document   : curiseAboardTable
    Created on : 2016-11-4, 21:46:10
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
        <form class="form-inline" name="resrve" action="/LuxuryCurise/index/manageReserveInfo/curiseAboard" method="post">
                            <label for="name">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
                            <input class="form-control" name="real_name" type="text" value="张毅" size="25">
                            <br/><br/>
                            <label for="name">身份证号：</label>
                            <input class="form-control" name="ID_number"  type="text"  value="458900198809238907"size="25">
                            <br/><br/>
                              <label for="name">房间号：</label>
                              <input class="form-control" name="room_name"  type="text" value="101" size="25">
                            <br/><br/>
                            <label for="name">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
                            <label class="checkbox-inline">
                                <input type="radio" name="sex" value="2" checked="checked"/>男
                            </label>
                            <label class="checkbox-inline">
                                <input type="radio" name="sex" value="1"/>女
                            </label>
                            <br/><br/>
                            <label for="tel">联系方式：</label>
                            <input class="form-control"name="phone_number" type="text"  value="13838383388" size="25">
                            <br/><br/>
                            <label for="name">登船时间：
                                <input class="form-control" name="time" type="text" size="22" readOnly="true" ng-model="time" />
                            </label>
                            <br/><br/>
                          <input type="submit" value="提交">
                        </form>
    </body>
</html>
