<%-- 
    Document   : changeInfoTable
    Created on : 2016-11-4, 21:45:22
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
        <form class="form-inline" name="change" action="index/manageReserveInfo/change/{now_room_name}/{real_name}" method="post">
                            <input type="text" id="room_name" value="" style="display:none;"/>
                            <label for="name">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:&nbsp;&nbsp;</label>
                            <input class="form-control" name="real_name" type="text" size="25" name="name">
                            <br/><br/>
                            <label for="formerRoomNum">原&nbsp;舱&nbsp;房&nbsp;号：
                               <input class="form-control" name="old_room_name" type="text" size="25" >
                            </label>
                            <br/><br/>
                            label for="formerRoomNum">现&nbsp;舱&nbsp;房&nbsp;号：
                               <input class="form-control" name="now_room_name" type="text" size="25" >
                            </label>
                            <br/><br/>
                        
                            <input type="submit" value="提交">
                        </form>
    </body>
</html>
