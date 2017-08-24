/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
route.controller("roomChange", function () {
    $(function () {
        $("#formerRoomType").change(function () {
            var value = $(this).find("option:selected").val();
            $("#formerRoomPrice").val(value);
        });
        $("#formerRoomPrice").change(function () {
            var value = $(this).find("option:selected").val();
            $("#formerRoomType").val(value);
        });
    });
});

