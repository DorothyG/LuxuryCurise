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
                .when("/roomManage", {
                    templateUrl: "roomManage",
                    controller: "roomManage"
                })
                .when("/infoManage", {
                    templateUrl: "infoManage",
                    controller: "infoManage"
                })
                .when("/engageManage", {
                    templateUrl: "engageManage",
                    controller: "engageManage"
                })
                .otherwise({
                    redirectTo: "/roomManage"
                });
    }]);

//后台管理-客房管理控制器
route.controller("roomManage", function ($scope, $http) {
    //页面注入后的请求
    $http({
        method: "get",
        url: "/LuxuryCurise/indexBackground/roomManage",
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        $scope.totalLayerCheckin = response.totalLayerCheckin;

        $("div#loading").css("display", "none");
        $("div#loading1").css("display", "none");
        $("div#loading2").css("display", "none");
        $("div#loading3").css("display", "none");
        $("div#loading4").css("display", "none");

        //alert(JSON.stringify(response.totalLayerCheckin));

        var checkInStateChart = new Chart(document.getElementById("checkInStateChart").getContext("2d"), {
            type: 'bar',
            data: response.checkin,
            options: {
                display: true
            }
        });

        var roomUseStateChart = new Chart(document.getElementById("roomUseStateChart").getContext("2d"), {
            type: 'bar',
            data: response.consume,
            options: {
                display: true
            }
        });

        var customerGroupStateChart = new Chart(document.getElementById("customerGroupStateChart").getContext("2d"), {
            type: 'pie',
            data: response.sex,
            options: {
                display: true
            }
        });

        var ageLevelStateChart = new Chart(document.getElementById("ageLevelStateChart").getContext("2d"), {
            type: 'pie',
            data: response.age,
            options: {
                display: true
            }
        });

    });

    //入住状态按照舱房类型请求
    $(function () {
        $("button#accordType").off().click(function () {
            $.get({
                url: "/LuxuryCurise/checkinByRType"
            }, function (response) {
                $("canvas#checkInStateChart").remove();
                $("div#checkInState").append("<canvas id='checkInStateChart' width='1000' height='500'></canvas>");
                var checkInStateChart = new Chart(document.getElementById("checkInStateChart").getContext("2d"), {
                    type: 'bar',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //入住状态按照层数分请求
    $(function () {
        $("button#accordLayer").off().click(function () {
            $.get({
                url: "/LuxuryCurise/checkinByLayer"
            }, function (response) {
                $("canvas#checkInStateChart").remove();
                $("div#checkInState").append("<canvas id='checkInStateChart' width='1000' height='500'></canvas>");
                var checkInStateChart = new Chart(document.getElementById("checkInStateChart").getContext("2d"), {
                    type: 'bar',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //入住状态总体请求
    $(function () {
        $("button#total").off().click(function () {
            $.get({
                url: "/LuxuryCurise/checkinAll"
            }, function (response) {
                $("canvas#checkInStateChart").remove();
                $("div#checkInState").append("<canvas id='checkInStateChart' width='1000' height='500'></canvas>");
                var checkInStateChart = new Chart(document.getElementById("checkInStateChart").getContext("2d"), {
                    type: 'bar',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //消费群体按照职业分请求
    $(function () {
        $("button#accordOccup").off().click(function () {
            $.get({
                url: "/LuxuryCurise/numOfDiffOccup"
            }, function (response) {
                $("canvas#customerGroupStateChart").remove();
                $("div#customerGroupState").append("<canvas id='customerGroupStateChart' width='200' height='200'></canvas>");
                var customerGroupStateChart = new Chart(document.getElementById("customerGroupStateChart").getContext("2d"), {
                    type: 'pie',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //消费群体按照性别分请求
    $(function () {
        $("button#accordSex").off().click(function () {
            $.get({
                url: "/LuxuryCurise/numOfDiffSex"
            }, function (response) {
                $("canvas#customerGroupStateChart").remove();
                $("div#customerGroupState").append("<canvas id='customerGroupStateChart' width='200' height='200'></canvas>");
                var customerGroupStateChart = new Chart(document.getElementById("customerGroupStateChart").getContext("2d"), {
                    type: 'pie',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });
    /*$(".form_date").datetimepicker({
     language: "zh-cn",
     format: "yyyy MM dd",
     autoclose: true,
     todayBtn: true,
     pickerPosition: "bottom-left"
     });*/

});

//后台管理-信息管理控制器
route.controller("infoManage", function ($scope, $http) {
    //页面注入后请求
    $http({
        method: "get",
        url: "/LuxuryCurise/indexBackground/infoManage",
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        //alert(JSON.stringify(response));
        $scope.occupList = response.occupList;
        $("div#loading1").css("display", "none");
        $("div#loading2").css("display", "none");

        var realNameRegisterChart = new Chart(document.getElementById("realNameRegisterChart").getContext("2d"), {
            type: 'pie',
            data: response.real_name,
            options: {
                display: true
            }
        });

        var creditCheckChart = new Chart(document.getElementById("creditCheckChart").getContext("2d"), {
            type: 'pie',
            data: response.credit,
            options: {
                display: true
            }
        });
    });
    /*var customerPaymentChart = new Chart(document.getElementById("customerPaymentChart").getContext("2d"), {
     type: 'bar',
     data: data,
     options: {
     display: true
     }
     });*/

    //信用度审查按照性别分请求
    $(function () {
        $("a.sex2").click(function () {
            var sex = $(this).text();
            $.get({
                url: "/LuxuryCurise/creditBySex",
                data: {
                    sex: sex
                }
            }, function (response) {
                $("canvas#creditCheckChart").remove();
                $("div#creditCheck").append("<canvas id='creditCheckChart' width='300' height='300'></canvas>");
                var creditCheckChart = new Chart(document.getElementById("creditCheckChart").getContext("2d"), {
                    type: 'pie',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    $scope.send = function ($event) {
        var occup = $($event.target).text();
        $.get({
            url: "/LuxuryCurise/creditByOccup",
            data: {
                occupation: occup
            }
        }, function (response) {
            //alert("lalalalla");
            $("canvas#creditCheckChart").remove();
            $("div#creditCheck").append("<canvas id='creditCheckChart' width='300' height='300'></canvas>");
            var creditCheckChart = new Chart(document.getElementById("creditCheckChart").getContext("2d"), {
                type: 'pie',
                data: response,
                options: {
                    display: true
                }
            });
        });
    };

    //信用度审查按照年龄分请求
    $(function () {
        $("a.age2").click(function () {
            var age = $(this).text();
            $.get({
                url: "/LuxuryCurise/creditByAge",
                data: {
                    age: age
                }
            }, function (response) {
                $("canvas#creditCheckChart").remove();
                $("div#creditCheck").append("<canvas id='creditCheckChart' width='300' height='300'></canvas>");
                var creditCheckChart = new Chart(document.getElementById("creditCheckChart").getContext("2d"), {
                    type: 'pie',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //信用度审查总体请求
    $(function () {
        $("button#total").off().click(function () {
            $.get({
                url: "/LuxuryCurise/creditAll"
            }, function (response) {
                $("canvas#creditCheckChart").remove();
                $("div#creditCheck").append("<canvas id='creditCheckChart' width='300' height='300'></canvas>");
                var creditCheckChart = new Chart(document.getElementById("creditCheckChart").getContext("2d"), {
                    type: 'pie',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //实名制登记按照性别分总体请求
    $(function () {
        $("a#allsex").off().click(function () {
            $.get({
                url: "/LuxuryCurise/realNameNumBySexAll"
            }, function (response) {
                $("canvas#realNameRegisterChart").remove();
                $("div#realNameRegister").append("<canvas id='realNameRegisterChart' width='500' height='500'></canvas>");
                var realNameRegisterChart = new Chart(document.getElementById("realNameRegisterChart").getContext("2d"), {
                    type: 'pie',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //实名制登记按照性别分分性别请求
    $(function () {
        $("a.sex").click(function () {
            var sex = $(this).text();
            $.get({
                url: "/LuxuryCurise/realNameNumBySex",
                data: {
                    sex: sex
                }
            }, function (response) {
                $("canvas#realNameRegisterChart").remove();
                $("div#realNameRegister").append("<canvas id='realNameRegisterChart' width='500' height='500'></canvas>");
                var realNameRegisterChart = new Chart(document.getElementById("realNameRegisterChart").getContext("2d"), {
                    type: 'pie',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //实名制登记按照年龄分总体请求
    $(function () {
        $("a#allage").off().click(function () {
            $.get({
                url: "/LuxuryCurise/realNameNumByAgeAll"
            }, function (response) {
                $("canvas#realNameRegisterChart").remove();
                $("div#realNameRegister").append("<canvas id='realNameRegisterChart' width='500' height='500'></canvas>");
                var realNameRegisterChart = new Chart(document.getElementById("realNameRegisterChart").getContext("2d"), {
                    type: 'pie',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //实名制登记按照年龄分分年龄阶段请求
    $(function () {
        $("a.age").click(function () {
            var age = $(this).text();
            $.get({
                url: "/LuxuryCurise/realNameNumByAge",
                data: {
                    age: age
                }
            }, function (response) {
                $("canvas#realNameRegisterChart").remove();
                $("div#realNameRegister").append("<canvas id='realNameRegisterChart' width='500' height='500'></canvas>");
                var realNameRegisterChart = new Chart(document.getElementById("realNameRegisterChart").getContext("2d"), {
                    type: 'pie',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //实名制登记按照职业分总体请求
    $(function () {
        $("a#alloccup").off().click(function () {
            $.get({
                url: "/LuxuryCurise/realNameNumByOccupAll"
            }, function (response) {
                $("canvas#realNameRegisterChart").remove();
                $("div#realNameRegister").append("<canvas id='realNameRegisterChart' width='500' height='500'></canvas>");
                var realNameRegisterChart = new Chart(document.getElementById("realNameRegisterChart").getContext("2d"), {
                    type: 'pie',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    $scope.other = function ($event) {
        var occup = $($event.target).text();
        $.get({
            url: "/LuxuryCurise/realNameNumByOccup",
            data: {
                occupation: occup
            }
        }, function (response) {
            $("canvas#realNameRegisterChart").remove();
            $("div#realNameRegister").append("<canvas id='realNameRegisterChart' width='500' height='500'></canvas>");
            var realNameRegisterChart = new Chart(document.getElementById("realNameRegisterChart").getContext("2d"), {
                type: 'pie',
                data: response,
                options: {
                    display: true
                }
            });
        });
    };

    //实名制登记总体请求
    $(function () {
        $("button#total2").off().click(function () {
            $.get({
                url: "/LuxuryCurise/realNameAll"
            }, function (response) {
                $("canvas#realNameRegisterChart").remove();
                $("div#realNameRegister").append("<canvas id='realNameRegisterChart' width='500' height='500'></canvas>");
                var realNameRegisterChart = new Chart(document.getElementById("realNameRegisterChart").getContext("2d"), {
                    type: 'pie',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });
});

//后台管理-经营管理控制器
route.controller("engageManage", function ($scope, $http) {
    //页面注入后请求
    $http({
        method: "get",
        url: "/LuxuryCurise//indexBackground/engageManage",
        headers: {"Content-Type": "application/json"}
    }).success(function (response) {
        //alert(JSON.stringify(response));
        $("div#loading").css("display", "none");
        $("div#loading1").css("display", "none");
        $("div#loading2").css("display", "none");
        $("div#loading3").css("display", "none");
        $("div#loading4").css("display", "none");

        var whole = new Chart(document.getElementById("whole").getContext("2d"), {
            type: 'line',
            data: response.total,
            options: {
                display: true
            }
        });

        var retailDepartChart = new Chart(document.getElementById("retailDepartChart").getContext("2d"), {
            type: 'line',
            data: response.retail,
            options: {
                display: true
            }
        });

        var entertainDepartChart = new Chart(document.getElementById("entertainDepartChart").getContext("2d"), {
            type: 'line',
            data: response.entertain,
            options: {
                display: true
            }
        });

        var foodDepartChart = new Chart(document.getElementById("foodDepartChart").getContext("2d"), {
            type: 'line',
            data: response.food,
            options: {
                display: true
            }
        });

        var roomDepartChart = new Chart(document.getElementById("roomDepartChart").getContext("2d"), {
            type: 'line',
            data: response.room,
            options: {
                display: true
            }
        });
    });

    //总营业额表按照月份请求
    $(function () {
        $("button#totalAccordMonth").off().click(function () {
            $.get({
                url: "/LuxuryCurise/totalRevenueOnMonth"
            }, function (response) {
                $("canvas#whole").remove();
                $("div#total").append("<canvas id='whole' width='500' height='200'></canvas>");
                var whole = new Chart(document.getElementById("whole").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //总营业额表按照季度请求
    $(function () {
        $("button#totalAccordQuater").off().click(function () {
            $.get({
                url: "/LuxuryCurise/totalRevenueOnQuarter"
            }, function (response) {
                $("canvas#whole").remove();
                $("div#total").append("<canvas id='whole' width='500' height='200'></canvas>");
                var whole = new Chart(document.getElementById("whole").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //总营业额表按照年份请求
    $(function () {
        $("button#totalAccordYear").off().click(function () {
            $.get({
                url: "/LuxuryCurise/totalRevenueOnYear"
            }, function (response) {
                $("canvas#whole").remove();
                $("div#total").append("<canvas id='whole' width='500' height='200'></canvas>");
                var whole = new Chart(document.getElementById("whole").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //零售部按照月份请求
    $(function () {
        $("button#retailAccordMonth").off().click(function () {
            $.get({
                url: "/LuxuryCurise/retailDepartRevenueOnMonth"
            }, function (response) {
                $("canvas#retailDepartChart").remove();
                $("div#retailDepart").append("<canvas id='retailDepartChart' width='500' height='240'></canvas>");
                var retailDepartChart = new Chart(document.getElementById("retailDepartChart").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //零售部按照季度请求
    $(function () {
        $("button#retailAccordQuater").off().click(function () {
            $.get({
                url: "/LuxuryCurise/retailDepartRevenueOnQuarter"
            }, function (response) {
                $("canvas#retailDepartChart").remove();
                $("div#retailDepart").append("<canvas id='retailDepartChart' width='500' height='240'></canvas>");
                var retailDepartChart = new Chart(document.getElementById("retailDepartChart").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //零售部按照年份请求
    $(function () {
        $("button#retailAccordYear").off().click(function () {
            $.get({
                url: "/LuxuryCurise/retailDepartRevenueOnYear"
            }, function (response) {
                $("canvas#retailDepartChart").remove();
                $("div#retailDepart").append("<canvas id='retailDepartChart' width='500' height='240'></canvas>");
                var retailDepartChart = new Chart(document.getElementById("retailDepartChart").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //娱乐部按照月份请求
    $(function () {
        $("button#entertainAccordMonth").off().click(function () {
            $.get({
                url: "/LuxuryCurise/entertainDepartRevenueOnMonth"
            }, function (response) {
                $("canvas#entertainDepartChart").remove();
                $("div#entertainDepart").append("<canvas id='entertainDepartChart' width='500' height='240'></canvas>");
                var entertainDepartChart = new Chart(document.getElementById("entertainDepartChart").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //娱乐部按照季度请求
    $(function () {
        $("button#entertainAccordQuater").off().click(function () {
            $.get({
                url: "/LuxuryCurise/entertainDepartRevenueOnQuarter"
            }, function (response) {
                $("canvas#entertainDepartChart").remove();
                $("div#entertainDepart").append("<canvas id='entertainDepartChart' width='500' height='240'></canvas>");
                var entertainDepartChart = new Chart(document.getElementById("entertainDepartChart").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //娱乐部按照年份请求
    $(function () {
        $("button#entertainAccordYear").off().click(function () {
            $.get({
                url: "/LuxuryCurise/entertainDepartRevenueOnYear"
            }, function (response) {
                $("canvas#entertainDepartChart").remove();
                $("div#entertainDepart").append("<canvas id='entertainDepartChart' width='500' height='240'></canvas>");
                var entertainDepartChart = new Chart(document.getElementById("entertainDepartChart").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //餐饮部按照月份请求
    $(function () {
        $("button#foodAccordMonth").off().click(function () {
            $.get({
                url: "/LuxuryCurise/foodDepartRevenueOnMonth"
            }, function (response) {
                $("canvas#foodDepartChart").remove();
                $("div#foodDepart").append("<canvas id='foodDepartChart' width='500' height='240'></canvas>");
                var foodDepartChart = new Chart(document.getElementById("foodDepartChart").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //餐饮部按照季度请求
    $(function () {
        $("button#foodAccordQuater").off().click(function () {
            $.get({
                url: "/LuxuryCurise/foodDepartRevenueOnQuarter"
            }, function (response) {
                $("canvas#foodDepartChart").remove();
                $("div#foodDepart").append("<canvas id='foodDepartChart' width='500' height='240'></canvas>");
                var foodDepartChart = new Chart(document.getElementById("foodDepartChart").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //餐饮部按照年份请求
    $(function () {
        $("button#foodAccordYear").off().click(function () {
            $.get({
                url: "/LuxuryCurise/foodDepartRevenueOnYear"
            }, function (response) {
                $("canvas#foodDepartChart").remove();
                $("div#foodDepart").append("<canvas id='foodDepartChart' width='500' height='240'></canvas>");
                var foodDepartChart = new Chart(document.getElementById("foodDepartChart").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //客房营收按照月份请求
    $(function () {
        $("button#roomAccordMonth").off().click(function () {
            $.get({
                url: "/LuxuryCurise/roomRevenueOnMonth"
            }, function (response) {
                $("canvas#roomDepartChart").remove();
                $("div#roomDepart").append("<canvas id='roomDepartChart' width='500' height='240'></canvas>");
                var roomDepartChart = new Chart(document.getElementById("roomDepartChart").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //客房营收按照季度请求
    $(function () {
        $("button#roomAccordQuater").off().click(function () {
            $.get({
                url: "/LuxuryCurise/roomRevenueOnQuarter"
            }, function (response) {
                $("canvas#roomDepartChart").remove();
                $("div#roomDepart").append("<canvas id='roomDepartChart' width='500' height='240'></canvas>");
                var roomDepartChart = new Chart(document.getElementById("roomDepartChart").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

    //客房营收按照年份请求
    $(function () {
        $("button#roomAccordYear").off().click(function () {
            $.get({
                url: "/LuxuryCurise/roomRevenueOnYear"
            }, function (response) {
                $("canvas#roomDepartChart").remove();
                $("div#roomDepart").append("<canvas id='roomDepartChart' width='500' height='240'></canvas>");
                var roomDepartChart = new Chart(document.getElementById("roomDepartChart").getContext("2d"), {
                    type: 'line',
                    data: response,
                    options: {
                        display: true
                    }
                });
            });
        });
    });

});