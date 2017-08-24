/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
route.controller("changeInfo", function ($http, $scope) {
    $http({
        method: "get",
        url: "/LuxuryCurise/index/changeInfo",
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        var json = JSON.stringify(response);
        var changeInfo = angular.fromJson(json);
        $scope.changeInfo = changeInfo;
    });
});


