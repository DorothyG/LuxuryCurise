/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
route.controller("curiseAboard", function ($http, $scope) {
    var date = new Date();
    var month = date.getMonth() + 1;
    $scope.time = date.getFullYear() + "-" + month + "-" + date.getDate() + " " + date.getHours()
            + ":" + date.getMinutes();

    $(function () {
        $("a#all").click(function () {
            $(".panel-collapse").collapse("toggle");
            $(this).empty().html("折叠全部<i class='icon-angle-down'></i>")
        });
    });
    
    $http({
        method: "get",
        url: "/LuxuryCurise/index/curiseAboard",
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        var json = JSON.stringify(response);
        var curiseAboard = angular.fromJson(json);
        $scope.curiseAboard = curiseAboard;
    });
});

