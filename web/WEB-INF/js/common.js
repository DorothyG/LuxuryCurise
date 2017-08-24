/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    $("../roomChange.html/#roomType").change(function () {
        var value = $(this).find("option:selected").val();
        $("#roomPrice").val(value);
    })
    $("../roomChange.html/#roomPrice").change(function () {
        var value = $(this).find("option:selected").val();
        $("#roomType").val(value);
    })
});

