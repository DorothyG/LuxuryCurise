/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
route.controller("depositPay", function ($scope) {
    $scope.amount = 3000;
    var date = new Date();
    var month = date.getMonth() + 1;
    $scope.time = date.getFullYear() + "-" + month + "-" + date.getDate() + " " + date.getHours()
            + ":" + date.getMinutes();
});


