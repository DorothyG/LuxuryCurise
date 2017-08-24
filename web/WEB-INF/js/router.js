/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
'use strict';

//前端路由
var route = angular.module("layout", ["ngRoute"]);
route.config(["$routeProvider", function ($routeProvider) {
        $routeProvider
                .when("/curiseAboard", {
                    templateUrl: "curiseAboard",
                    controller: "curiseAboard"
                })
                .when("/reserve", {
                    templateUrl: "reserve",
                    controller: "reserve"
                })
                .when("/roomChange", {
                    templateUrl: "roomChange",
                    controller: "roomChange"
                })
                .when("/payment", {
                    templateUrl: "payment",
                    controller: "payment"
                })
                .when("/depositPay", {
                    templateUrl: "depositPay",
                    controller: "depositPay"
                })
                .when("/customerInfo", {
                    templateUrl: "customerInfo",
                    controller: "customerInfo"
                })
                .when("/reserveInfo", {
                    templateUrl: "reserveInfo",
                    controller: "reserveInfo"
                })
                .when("/changeInfo", {
                    templateUrl: "changeInfo",
                    controller: "changeInfo"
                })
                .when("/thingsConsume", {
                    templateUrl: "thingsConsume",
                    controller: "thingsConsume"
                })
                .when("/cleanStatus", {
                    templateUrl: "cleanStatus",
                    controller: "cleanStatus"
                })
                .when("/saleRate", {
                    templateUrl: "saleRate",
                    controller: "saleRate"
                })
                .otherwise({
                    redirectTo: "/curiseAboard"
                });
    }]);

//客房管理-登船登记控制器
route.controller("curiseAboard", function ($http, $scope) {
    //获取当前时间，绑定到输入框内
    var date = new Date();
    var month = date.getMonth() + 1;
    $scope.time = date.getFullYear() + "-" + month + "-" + date.getDate() + " " + date.getHours()
            + ":" + date.getMinutes();

    //控制展开/折叠文字
    $(function () {
        var flag = true;
        $("a#all").click(function () {
            flag = !flag;
            if (flag) {
                $(this).empty().append("展开全部<i class='icon-angle-down'></i>");
                $("a.layer-spread").empty().append("展开<i class='icon-angle-down spread'></i>");
            } else {
                $(this).empty().append("折叠全部<i class='icon-angle-up'></i>");
                $("a.layer-spread").empty().append("折叠<i class='icon-angle-up spread'></i>");
            }
        });
    });

    $(function () {
        var flag = true;
        $("a.layer-spread").click(function () {
            flag = !flag;
            if (flag) {
                $(this).empty().append("展开<i class='icon-angle-down spread'></i>");
            } else {
                $(this).empty().append("折叠<i class='icon-angle-up spread'></i>");
            }
        })
    });

    //从后台获取json数据
    $http({
        method: "get",
        url: "/LuxuryCurise/index/curiseAboard",
        //cache:true,
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        var json = JSON.stringify(response);
        var curiseAboard = angular.fromJson(json);
        $("div#loading").css("display", "none");
        $scope.curiseAboard = curiseAboard;
    });


    //为模态框中不能显示的输入框绑定事件
    $(function () {
        $("#myModal").off("show.bs.modal").on("show.bs.modal", function (e) {
            var invoker = $(e.relatedTarget).find("h3").text();
            $("input[name='room_name']").val(invoker + "");
        });
    });

    $(function () {
        $("button#ok").off().click(function () {
            /*var curise_aboard = [$("input#room_name").val(),
             $("input#real_name").val(),
             $("input#ID_number").val(),
             $("input[name='sex']:checked").val(),
             $("input#phone_number").val(),
             $("input#time").val()];*/
            var room_name = $("input[name='room_name']").val();
            var real_name = $("input[name='real_name']").val();
            var ID_number = $("input[name='ID_number']").val();
            var sex = 0;
            if ($("input[name='sex']:checked").val() == "男") {
                sex = 2;
            }
            else {
                sex = 1;
            }
            var phone_number = $("input[name='phone_number']").val();
            var time = $("input[name='time']").val();
            //alert(room_name + real_name + ID_number + sex + phone_number + time);
            $.post({
                url: "/LuxuryCurise/index/manageReserveInfo/curiseAboard",
                data: {
                    //curise_aboard: curise_aboard
                    room_name: room_name,
                    real_name: real_name,
                    ID_number: ID_number,
                    sex: sex,
                    phone_number: phone_number,
                    time: time
                }
            }, function () {
                $("div#myModal").modal('hide');
            });
        });
    });

});

//客房管理-预定登记控制器
route.controller("reserve", function ($scope, $http) {
    //获取当前时间，绑定到输入框内
    var date = new Date();
    var month = date.getMonth() + 1;
    $scope.time = date.getFullYear() + "-" + month + "-" + date.getDate() + " " + date.getHours()
            + ":" + date.getMinutes();

    //控制展开/折叠文字
    $(function () {
        var flag = true;
        $("a#all").click(function () {
            flag = !flag;
            if (flag) {
                $(this).empty().append("展开全部<i class='icon-angle-down'></i>");
                $("a.layer-spread").empty().append("展开<i class='icon-angle-down spread'></i>");
            } else {
                $(this).empty().append("折叠全部<i class='icon-angle-up'></i>");
                $("a.layer-spread").empty().append("折叠<i class='icon-angle-up spread'></i>");
            }
        });
    });

    $(function () {
        var flag = true;
        $("a.layer-spread").click(function () {
            flag = !flag;
            if (flag) {
                $(this).empty().append("展开<i class='icon-angle-down spread'></i>");
            } else {
                $(this).empty().append("折叠<i class='icon-angle-up spread'></i>");
            }
        });
    });

    //从后台获取json数据
    $http({
        method: "get",
        url: "/LuxuryCurise/index/curiseAboard",
        //cache:true,
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        var json = JSON.stringify(response);
        var reserve = angular.fromJson(json);
        $("div#loading").css("display", "none");
        $scope.reserve = reserve;
    });

    //为模态框中不能显示的输入框绑定事件
    $(function () {
        $("#myModal").off("show.bs.modal").on("show.bs.modal", function (e) {
            var invoker = $(e.relatedTarget).find("h3").text();
            $("input#room_name").val(invoker + "");
        });
    });

    $(function () {
        $("button#ok").off().click(function () {
            /*var curise_aboard = [$("input#room_name").val(),
             $("input#real_name").val(),
             $("input#ID_number").val(),
             $("input[name='sex']:checked").val(),
             $("input#phone_number").val(),
             $("input#time").val()];*/
            var age = parseInt($("input[name='age']").val());
            var sex = 0;
            if ($("input[name='sex']:checked").val() == "男") {
                sex = 2;
            }
            else {
                sex = 1;
            }
            $.post({
                url: "/LuxuryCurise/index/manageReserveInfo/reserve",
                data: {
                    //curise_aboard: curise_aboard
                    room_name: $("input#room_name").val(),
                    real_name: $("input[name='user_name']").val(),
                    ID_number: $("input[name='ID_number']").val(),
                    sex: sex,
                    phone_number: $("input[name='phone_number']").val(),
                    occupation: $("input[name='occupation']").val(),
                    age: age,
                    time: $("input[name='time']").val()
                }
            }, function () {
                $("div#myModal").modal('hide');

                $http({
                    method: "get",
                    url: "/LuxuryCurise/index/curiseAboard",
                    //cache:true,
                    headers: {"Content-Type": "application/json"}
                }).success(function (response) {
                    var json = JSON.stringify(response);
                    var reserve = angular.fromJson(json);
                    $("div#loading").css("display", "none");
                    $scope.reserve = reserve;
                });
            });
        });
    });
});

//客房管理-换舱登记控制器
route.controller("roomChange", function ($scope, $http) {
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

    $(function () {
        var flag = true;
        $("a#all").click(function () {
            flag = !flag;
            if (flag) {
                $(this).empty().append("展开全部<i class='icon-angle-down'></i>");
                $("a.layer-spread").empty().append("展开<i class='icon-angle-down spread'></i>");
            } else {
                $(this).empty().append("折叠全部<i class='icon-angle-up'></i>");
                $("a.layer-spread").empty().append("折叠<i class='icon-angle-up spread'></i>");
            }
        });
    });

    $(function () {
        var flag = true;
        $("a.layer-spread").click(function () {
            flag = !flag;
            if (flag) {
                $(this).empty().append("展开<i class='icon-angle-down spread'></i>");
            } else {
                $(this).empty().append("折叠<i class='icon-angle-up spread'></i>");
            }
        })
    });

    $http({
        method: "get",
        url: "/LuxuryCurise/index/curiseAboard",
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        var json = JSON.stringify(response);
        var roomChange = angular.fromJson(json);
        $("div#loading").css("display", "none");
        $scope.roomChange = roomChange;
    });

    $(function () {
        $("#myModal").on("shown.bs.modal", function (e) {
            var invoker = $(e.relatedTarget).find("h3").text();
            $("input#room_name").val(invoker + "");
        });
    });

    $(function () {
        $("input[name='real_name']").off().blur(function () {
            $.get({
                url: "/LuxuryCurise/index/manageReserveInfo/change",
                data: {
                    now_room_name: $("input#room_name").val(),
                    real_name: $(this).val()
                }
            }, function (response) {
                $("span#old_room_name").text(response.old_room_name);
                $("span#old_room_type").text(response.old_room_type);
                $("span#old_deposit_amount").text(response.old_deposit_amount);
                $("span#now_deposit_amount").text(response.now_deposit_amount);
                $scope.change = response;
                //alert(JSON.stringify($scope.change));
                $scope.$apply();
            });
        });
    });

    $(function () {
        $("button#ok").off().click(function () {
            /*var curise_aboard = [$("input#room_name").val(),
             $("input#real_name").val(),
             $("input#ID_number").val(),
             $("input[name='sex']:checked").val(),
             $("input#phone_number").val(),
             $("input#time").val()];*/
            var old_deposit_amount = $("span#old_deposit_amount").text();
            var now_deposit_amount = $("span#now_deposit_amount").text();
            /*alert($("input#room_name").val() + $("input[name='real_name']").val() + 
                    $("span#old_room_name").text() + $("span#old_room_type").text()+ old_deposit_amount + now_deposit_amount);*/
            $.post({
                url: "/LuxuryCurise/index/manageReserveInfo/change",
                data: {
                    //curise_aboard: curise_aboard
                    now_room_name: $("input#room_name").val(),
                    real_name: $("input[name='real_name']").val(),
                    old_room_name: $("span#old_room_name").text(),
                    old_room_type: $("span#old_room_type").text(),
                    old_deposit_amount: old_deposit_amount,
                    now_deposit_amount: now_deposit_amount
                }
            }, function () {
                $("div#myModal").modal('hide');

                $http({
                    method: "get",
                    url: "/LuxuryCurise/index/curiseAboard",
                    headers: {"Content-Type": "application/json"}
                }).success(function (response) {
                    var json = JSON.stringify(response);
                    var roomChange = angular.fromJson(json);
                    $("div#loading").css("display", "none");
                    $scope.roomChange = roomChange;
                });
            });
        });
    });
});

//客房管理-消费结账控制器
route.controller("payment", function ($scope, $http) {
    $http({
        method: "get",
        url: "/LuxuryCurise/index/payment",
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        var json = JSON.stringify(response);
        var payment = angular.fromJson(json);
        $("div#loading").css("display", "none");
        $scope.payment = payment;
    });

    $(function () {
        var flag = true;
        $("a#all").click(function () {
            flag = !flag;
            if (flag) {
                $(this).empty().append("展开全部<i class='icon-angle-down'></i>");
                $("a.layer-spread").empty().append("展开<i class='icon-angle-down spread'></i>");
            } else {
                $(this).empty().append("折叠全部<i class='icon-angle-up'></i>");
                $("a.layer-spread").empty().append("折叠<i class='icon-angle-up spread'></i>");
            }
        });
    });

    $(function () {
        var flag = true;
        $("a.layer-spread").click(function () {
            flag = !flag;
            if (flag) {
                $(this).empty().append("展开<i class='icon-angle-down spread'></i>");
            } else {
                $(this).empty().append("折叠<i class='icon-angle-up spread'></i>");
            }
        });
    });

    $(function () {
        $("#myModal").on("shown.bs.modal", function (e) {
            $("button#ok").addClass("disabled");
            var invoker = $(e.relatedTarget).find("h3").text();
            var value = invoker + "";
            //$("input#room_name").val(invoker + "");
            $("input#room_name").val(value);
            //alert(value);
            $.get({
                url: "/LuxuryCurise/index/managePaymentInfo/payment",
                data: {
                    room_name: value
                },
                headers: {"Content-Type": "application/json"}
            }, function (response) {
                //alert("lalalal");
                $("button#ok").removeClass("disabled");
                $scope.pay = response;
                $("input[name='real_name']").empty().val(response.real_name);
                $("input[name='amount']").empty().val(response.real_pay);
                $scope.$apply();
            });
        });
    });

    $(function () {
        $("button#ok").click(function () {
            /*var curise_aboard = [$("input#room_name").val(),
             $("input#real_name").val(),
             $("input#ID_number").val(),
             $("input[name='sex']:checked").val(),
             $("input#phone_number").val(),
             $("input#time").val()];*/
            //alert($("input[name='real_name']").val());
            $.post({
                url: "/LuxuryCurise/index/managePaymentInfo/pay",
                data: {
                    //room_name: $("input#room_name").val(),
                    real_name: $("input[name='real_name']").val()
                }
            }, function () {
                $("div#myModal").modal('hide');

                $http({
                    method: "get",
                    url: "/LuxuryCurise/index/payment",
                    headers: {"Content-Type": "application/json"}
                }).success(function (response) {
                    var json = JSON.stringify(response);
                    var payment = angular.fromJson(json);
                    $("div#loading").css("display", "none");
                    $scope.payment = payment;
                });
            });
        });
    });
});

//客房管理-补交押金控制器
route.controller("depositPay", function ($scope, $http) {
    $scope.amount = 3000;
    var date = new Date();
    var month = date.getMonth() + 1;
    $scope.time = date.getFullYear() + "-" + month + "-" + date.getDate() + " " + date.getHours()
            + ":" + date.getMinutes();

    $http({
        method: "get",
        url: "/LuxuryCurise/index/depositPay",
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        var json = JSON.stringify(response);
        var depositPay = angular.fromJson(json);
        $("div#loading").css("display", "none");
        $scope.depositPay = depositPay;
    });

    $(function () {
        var flag = true;
        $("a#all").click(function () {
            flag = !flag;
            if (flag) {
                $(this).empty().append("展开全部<i class='icon-angle-down'></i>");
                $("a.layer-spread").empty().append("展开<i class='icon-angle-down spread'></i>");
            } else {
                $(this).empty().append("折叠全部<i class='icon-angle-up'></i>");
                $("a.layer-spread").empty().append("折叠<i class='icon-angle-up spread'></i>");
            }
        });
    });

    $(function () {
        var flag = true;
        $("a.layer-spread").click(function () {
            flag = !flag;
            if (flag) {
                $(this).empty().append("展开<i class='icon-angle-down spread'></i>");
            } else {
                $(this).empty().append("折叠<i class='icon-angle-up spread'></i>");
            }
        })
    });

    $(function () {
        $("#myModal").off().on("shown.bs.modal", function (e) {
            var invoker = $(e.relatedTarget).find("h3").text();
            var value = invoker + "";
            $("input#room_name").val(value);
            //alert(value);
            $.get({
                url: "/LuxuryCurise/index/managePaymentInfo/deposit",
                data: {
                    room_name: value
                }
            }, function (response) {
                $("input[name='real_name']").empty().val(response.real_name);
                $("input[name='deposite_amount']").empty().val(response.deposit_amount);
                //$scope.real_name = response.real_name;
                //$scope.deposit_amount = response.deposit_amount;
                $("button#ok").removeClass("disabled");
                $scope.$apply();
            });
        });
    });

    $(function () {
        $("button#ok").off().click(function () {
            //alert($("input#room_name").val());
            //alert($("input[name='real_name']").val());
            $.post({
                url: "/LuxuryCurise/index/managePaymentInfo/deposit",
                data: {
                    room_name: $("input#room_name").val(),
                    real_name: $("input[name='real_name']").val()
                }
            }, function () {
                $("div#myModal").modal('hide');

                $http({
                    method: "get",
                    url: "/LuxuryCurise/index/depositPay",
                    headers: {"Content-Type": "application/json"}
                }).success(function (response) {
                    var json = JSON.stringify(response);
                    var depositPay = angular.fromJson(json);
                    $("div#loading").css("display", "none");
                    $scope.depositPay = depositPay;
                });
            });
        });
    });
});

//信息查询-客人信息控制器
route.controller("customerInfo", function ($http, $scope) {
    $http({
        method: "get",
        url: "/LuxuryCurise/index/customerInfo",
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        var json = JSON.stringify(response);
        var customerInfo = angular.fromJson(json);
        $("button#search").removeClass("disabled");
        $("div#loading").css("display", "none");
        $scope.customerInfo = customerInfo;
    });

    $(function () {
        $("button#search").click(function () {
            $("div#loading,div#search").css("display", "block");
            $("div#template").css("display", "none");
            $("button#return").addClass("disabled");
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

    $(function () {
        $("button#return").click(function () {
            $("div#template").css("display", "block");
            $("div#search").css("display", "none");
            $("input").val("");
        });
    });
});

//信息查询-客房预定控制器
route.controller("reserveInfo", function ($http, $scope) {
    $http({
        method: "get",
        url: "/LuxuryCurise/index/reserveInfo",
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        var json = JSON.stringify(response);
        var reserveInfo = angular.fromJson(json);
        $("button#search").removeClass("disabled");
        $("div#loading").css("display", "none");
        $scope.reserveInfo = reserveInfo;
    });

    $(function () {
        $("button#search").click(function () {
            $("div#loading,div#search").css("display", "block");
            $("div#template").css("display", "none");
            $("button#return").addClass("disabled");
            var Name = $("input").val();
            $.post({
                url: "/LuxuryCurise/index/reserveInfo",
                data: {
                    user_name: Name
                }
            }, function (response) {
                var json = JSON.stringify(response);
                //alert(json);
                var reserveInfoSearch = angular.fromJson(json);
                $scope.reserveInfoSearch = reserveInfoSearch;
                $("div#loading").css("display", "none");
                $("button#return").removeClass("disabled");
                $scope.$apply();
            });
        });
    });

    $(function () {
        $("button#return").click(function () {
            $("div#template").css("display", "block");
            $("div#search").css("display", "none");
            $("input").val("");
        });
    });
});

//信息查询-换舱登记控制器
route.controller("changeInfo", function ($http, $scope) {
    $http({
        method: "get",
        url: "/LuxuryCurise/index/changeInfo",
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        var json = JSON.stringify(response);
        var changeInfo = angular.fromJson(json);
        $("button#search").removeClass("disabled");
        $("div#loading").css("display", "none");
        $scope.changeInfo = changeInfo;
    });

    //查找功能
    $(function () {
        $("button#search").click(function () {
            $("div#loading,div#search").css("display", "block");
            $("div#template").css("display", "none");
            $("button#return").addClass("disabled");
            var Name = $("input").val();
            $.post({
                url: "/LuxuryCurise/index/changeInfo",
                data: {
                    user_name: Name
                }
            }, function (response) {
                var json = JSON.stringify(response);
                //alert(json);
                var changeInfoSearch = angular.fromJson(json);
                $scope.changeInfoSearch = changeInfoSearch;
                $("div#loading").css("display", "none");
                $("button#return").removeClass("disabled");
                $scope.$apply();
            });
        });
    });

    $(function () {
        $("button#return").click(function () {
            $("div#template").css("display", "block");
            $("div#search").css("display", "none");
            $("input").val("");
        });
    });
});

//信息查询-物品消耗控制器
route.controller("thingsConsume", function ($http, $scope) {
    $http({
        method: "get",
        url: "/LuxuryCurise/index/thingsConsume",
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        var json = JSON.stringify(response);
        var thingsconsume = angular.fromJson(json);
        $("button#search").removeClass("disabled");
        $("div#loading").css("display", "none");
        $scope.thingsconsume = thingsconsume;
    });

    //查找功能
    $(function () {
        $("button#search").click(function () {
            $("div#loading,div#search").css("display", "block");
            $("div#template").css("display", "none");
            $("button#return").addClass("disabled");
            var roomName = $("input").val();
            $.post({
                url: "/LuxuryCurise/index/thingsConsume",
                data: {
                    room_name: roomName
                }
            }, function (response) {
                var json = JSON.stringify(response);
                //alert(json);
                var thingsConsumeSearch = angular.fromJson(json);
                $scope.thingsConsumeSearch = thingsConsumeSearch;
                $("div#loading").css("display", "none");
                $("button#return").removeClass("disabled");
                $scope.$apply();
            });
        });
    });

    $(function () {
        $("button#return").click(function () {
            $("div#template").css("display", "block");
            $("div#search").css("display", "none");
            $("input").val("");
        });
    });
});

//信息查询-清洁状态控制器
route.controller("cleanStatus", function ($http, $scope) {
    $http({
        method: "get",
        url: "/LuxuryCurise/index/cleanStatus",
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        var json = JSON.stringify(response);
        var cleanstatus = angular.fromJson(json);
        $("button#search").removeClass("disabled");
        $("div#loading").css("display", "none");
        $scope.cleanstatus = cleanstatus;
    });

    //查找功能
    $(function () {
        $("button#search").click(function () {
            $("div#loading,div#search").css("display", "block");
            $("div#template").css("display", "none");
            $("button#return").addClass("disabled");
            var roomName = $("input").val();
            $.post({
                url: "/LuxuryCurise/index/cleanStatus",
                data: {
                    room_name: roomName
                }
            }, function (response) {
                var json = JSON.stringify(response);
                //alert(json);
                var cleanStatusSearch = angular.fromJson(json);
                $scope.cleanStatusSearch = cleanStatusSearch;
                $("div#loading").css("display", "none");
                $("button#return").removeClass("disabled");
                $scope.$apply();
            });
        });
    });

    $(function () {
        $("button#return").click(function () {
            $("div#template").css("display", "block");
            $("div#search").css("display", "none");
            $("input").val("");
        });
    });
});

//信息查询-消费结账控制器
route.controller("saleRate", function ($http, $scope) {
    $http({
        method: "get",
        url: "/LuxuryCurise/index/saleRate",
        headers: {"Content-Type": "application/json"},
    }).success(function (response) {
        var json = JSON.stringify(response);
        var saleRate = angular.fromJson(json);
        $("button#search").removeClass("disabled");
        $("div#loading").css("display", "none");
        $scope.saleRate = saleRate;
    });

    //查找功能
    $(function () {
        $("button#search").click(function () {
            $("div#loading,div#search").css("display", "block");
            $("div#template").css("display", "none");
            $("button#return").addClass("disabled");
            var roomName = $("input").val();
            $.post({
                url: "/LuxuryCurise/index/saleRate",
                data: {
                    room_name: roomName
                }
            }, function (response) {
                var json = JSON.stringify(response);
                //alert(json);
                var saleRateSearch = angular.fromJson(json);
                $scope.saleRateSearch = saleRateSearch;
                $("div#loading").css("display", "none");
                $("button#return").removeClass("disabled");
                $scope.$apply();
            });
        });
    });

    $(function () {
        $("button#return").click(function () {
            $("div#template").css("display", "block");
            $("div#search").css("display", "none");
            $("input").val("");
        });
    });

    $(function () {
        var flag = true;
        $("a#all").click(function () {
            flag = !flag;
            if (flag) {
                $(this).empty().append("展开全部<i class='icon-angle-down'></i>");
                $("a.layer-spread").empty().append("展开<i class='icon-angle-down spread'></i>");
            } else {
                $(this).empty().append("折叠全部<i class='icon-angle-up'></i>");
                $("a.layer-spread").empty().append("折叠<i class='icon-angle-up spread'></i>");
            }
        });
    });

    function change() {
        alert('lalalal');
        var flag2 = true;
        $("a.layer-spread").click(function () {
            flag2 = !flag2;
            if (flag2) {
                $(this).empty().append("展开<i class='icon-angle-down spread'></i>");
            } else {
                $(this).empty().append("折叠<i class='icon-angle-up spread'></i>");
            }
        });
    }
    ;

});