/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
'use strict';

var mylayout = angular.module("layout", []);
mylayout.controller("curiseName", function ($scope) {
    $(function () {
        $("input[type='button']").off().click(function () {
            var account = $("input[name='account']").val();
            var password = $("input[name='password']").val();
            var role = $("input[name='role']:checked").val();
            var curiseChoose = $("input[name='curiseChoose']:checked").val();
            alert(account + "/" + password + "/" + role + "/" + curiseChoose);
            $.post({
                url: "/LuxuryCurise/manageLogin",
                data: {
                    account: account,
                    password: password,
                    role: role,
                    curiseChoose: curiseChoose
                }
            }, function (response) {
                //alert("提交成功！");
                $('.login').addClass('test');
                setTimeout(function () {
                    $('.login').addClass('testtwo');
                }, 300);
                setTimeout(function () {
                    $('.authent').show().animate({right: -320}, {
                        easing: 'easeOutQuint',
                        duration: 600,
                        queue: false
                    });
                    $('.authent').animate({opacity: 1}, {
                        duration: 200,
                        queue: false
                    }).addClass('visible');
                }, 500);
                setTimeout(function () {
                    $('.authent').show().animate({right: 90}, {
                        easing: 'easeOutQuint',
                        duration: 600,
                        queue: false
                    });
                    $('.authent').animate({opacity: 0}, {
                        duration: 200,
                        queue: false
                    }).addClass('visible');
                    $('.login').removeClass('testtwo');
                }, 2500);
                setTimeout(function () {
                    $('.login').removeClass('test');
                    $('.login div').fadeOut(123);
                }, 2800);
                setTimeout(function () {
                    $('.success').fadeIn();
                }, 3200);
            });
        });
    });
});


