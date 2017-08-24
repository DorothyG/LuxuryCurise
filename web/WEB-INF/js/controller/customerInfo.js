/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
route.controller("customerInfo", function ($http, $scope) {
    $http({
        method: "get",
        url: "/LuxuryCurise/index/customerInfo",
        headers: {"Content-Type": "application/json"},
    }).success(function (response) {
        var json = JSON.stringify(response);
        var customerInfo = angular.fromJson(json);
        $("div#loading").css("display", "none");
        $scope.customerInfo = customerInfo;
    });

    $(function () {
        $("button#search").click(function () {
            $("div#loading").css("display", "block");
            $("div#search").css("display", "block");
            $("div#template").css("display", "none");
            $("button#return").addClass("disabled")
            var Name = $("input").val();
            $.post({
                url: "/LuxuryCurise/index/customerInfo",
                data: {
                    user_name: Name
                }
            }, function (response) {
                var json = JSON.stringify(response);
                //alert(json);
                var customerInfoSearch = angular.fromJson(json);
                $scope.customerInfoSearch = customerInfoSearch;
                $("div#loading").css("display", "none");
                $("button#return").removeClass("disabled");
                $scope.$apply();
            });
        });
    });
    
    $(function(){
        $("button#return").click(function(){
            $("div#template").css("display", "block");
            $("div#search").css("display", "none");
            $("input").val("");
        });
    });
});

