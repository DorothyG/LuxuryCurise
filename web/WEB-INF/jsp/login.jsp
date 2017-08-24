<%-- 
    Document   : login
    Created on : 2016-11-3, 22:34:37
    Author     : Apple
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>

        <link href="<%=basePath%>/css/jquery-ui.min.css" rel="stylesheet prefetch" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/default.css">
        <link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>/css/remodal.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>/css/remodal-default-theme.css" rel="stylesheet" type="text/css"/>

        <!--<script src="<%=basePath%>/js/angular.min.js" type="text/javascript"></script>-->

        <style>
            div#role{
                width:318px;
                height:38px;
                border: 1px solid #f9da83;
                border-radius: 10px;
                color: #f9da83;
                position: absolute;
                float: bottom;
                left:0;
                margin: -207px 0 0 0;
                text-align: center;
                padding: 14px 0 10px 0;
            }
            label#system{
                font-size: 19px;
                font-family: "微软雅黑";
            }
            div#choose{
                display: none;
                font-size: 17px;
                text-align: center;
                padding: 0 0 0 0;
                left: 0;
            }
            img#left{
                float:left;
                margin: 0 0 0 60px;
            }
            img#right{
                float:right;
                margin: 0 40px 0 0;
            }
            img#right_2{
                float:right;
                margin: 300px 20px 0 0;
            }
            div#cloud img{
                margin: -10% 0 0 0;
                opacity: 0.7;
                filter: url(blur.svg#blur); /* FireFox, Chrome, Opera */

                -webkit-filter: blur(1px); /* Chrome, Opera */
                -moz-filter: blur(1px);
                -ms-filter: blur(1px);    
                filter: blur(1px);

                filter: progid:DXImageTransform.Microsoft.Blur(PixelRadius=10, MakeShadow=false); 
            }
            div#waves{
                width:100%;
                height:40%;
                float: left;
                margin: 24% 0 0 0;
            }
            div#append{
                width:100%;
                height: 20%;
                background-color: #DAA520;
            }
            hr{
                background-color: #271f19;
            }
            div#curiseChoose{
                text-align: left;
            }
            p#modal1Desc{
                font-size: 18px;
                color:#271f19;
                margin: 0 0 0 10px;
            }
        </style>
    </head>
    <body>
        <header class="htmleaf-header">
            <h1 style="font-weight: lighter">豪华邮轮管理系统 <span>Luxury Curise Management System</span></h1>
        </header>
        <form method="post" action="/LuxuryCurise/manageLogin" target="_self">
            <div class='login'>
                <div class='login_title'>
                    <a id="trigger" href="#modal">
                        <img id="curise" src="icon/curise.svg" width="150px" height="80px"> 
                    </a>
                    <br />
                    <span id="curiseName">请选择邮轮</span>
                </div>

                <div class='login_fields'>
                    <div class='login_fields__user'>
                        <div class='icon'>
                            <img src='icon/user_icon_copy.png' />
                        </div>
                        <input placeholder='用户名' name="account" type='text' />
                        <div class='validation'>
                            <img src='icon/tick.png' />
                        </div>
                    </div>
                    <div class='login_fields__password'>
                        <div class='icon'>
                            <img src='icon/lock_icon_copy.png' />
                        </div>
                        <input placeholder='密码' name="password" type='password' />
                        <div class='validation'>
                            <img src='icon/tick.png' />
                        </div>
                    </div>
                    <div class='login_fields__submit'>
                        <input type='button' value='登  录'/>
                        <br/>
                        <div class='forgot'>
                            <a href='#'>忘记密码?</a>
                        </div>
                    </div>
                </div>
                <div id="role">
                    <i class="icon-hand-right icon-large"></i>
                    <label id="system">请先选择系统</label>
                    <br /><br />
                    <div id="choose">
                        <input type="radio" name="role" value="service"/>
                        <i class="icon-leaf"></i>&nbsp;我是前台服务人员
                        <hr />
                        <input type="radio" name="role" value="manager" />
                        <i class="icon-key"></i>&nbsp;我是后台管理人员
                    </div>
                </div>

                <div class='success'>
                    <h2>登录成功</h2>
                    <img src="icon/curise.svg" width="150px" height="80px" alt=""/>
                    <br /><br />
                    <span class="text-success">欢迎回来</span>
                </div>
            </div>
            <div class='authent'>
                <img src='icon/puff.svg' />
                <p>登录中...</p>
            </div>

            <div id="curiseChoose" class="remodal" data-remodal-id="modal" role="dialog" aria-labelledby="modal1Title" aria-describedby="modal1Desc">
                <button data-remodal-action="close" class="remodal-close" aria-label="Close"></button>
                <div>
                    <h2 id="modal1Title">请选择邮轮：</h2>
                    <p id="modal1Desc">
                        <c:forEach items="${curiseNames}" var="curiseName" varStatus="id">
                            <input type="radio" name="curiseChoose" value="${curiseName}" />${curiseName}
                            <br />
                        </c:forEach>

                        <!--<input type="radio" name="curiseChoose" value="东方皇家号" />东方皇家号
                        <br />-->
                    </p>
                </div>
                <br>
                <button data-remodal-action="cancel" class="remodal-cancel">取消</button>
                <button data-remodal-action="confirm" class="remodal-confirm">确定</button>
            </div>

        </form>

        <div id="cloud">
            <img id="left" src="<%=basePath%>/icon/cloud_right.png" alt="" width="444" height="286"/>
            <img id="right" src="<%=basePath%>/icon/cloud_left.png" alt=""/>
            <img id="right_2" src="<%=basePath%>/icon/cloud_left.png" alt="" width="167" height="103"/>
        </div>

        <div id="waves">
            <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                 width="100%" height="240px" xml:space="preserve">
            <defs>
            <pattern id="water" width=".25" height="1.1" patternContentUnits="objectBoundingBox">
                <path fill="#000" d="M0.25,1H0c0,0,0-0.659,0-0.916c0.083-0.303,0.158,0.334,0.25,0C0.25,0.327,0.25,1,0.25,1z"/>
            </pattern>

            <rect id="rect" transform="translate(2,116)" width="1000" height="200">

            <mask id="text-mask">
                <use x="0" y="0" xlink:href="#rect" opacity="1" fill="#DAA520"/>
            </mask>

            <g id="eff">
            <use x="0" y="0" xlink:href="#text" fill="#DAA520"/>

            <rect class="water-fill" mask="url(#text-mask)" fill="url(#water)" x="-300" y="50" width="2000" height="200" opacity="0.3">
            <animate attributeType="xml" attributeName="x" from="-500" to="0" repeatCount="indefinite" dur="2s"/>
            </rect>

            <rect class="water-fill" mask="url(#text-mask)" fill="url(#water)" y="45" width="2000" height="200" opacity="0.3">
            <animate attributeType="xml" attributeName="x" from="-500" to="0" repeatCount="indefinite" dur="3s"/>
            </rect>

            <rect class="water-fill" mask="url(#text-mask)" fill="url(#water)" y="55" width="2000" height="200" opacity="0.3">
            <animate attributeType="xml" attributeName="x" from="-500" to="0" repeatCount="indefinite" dur="1.4s"/>
            </rect>

            <rect class="water-fill" mask="url(#text-mask)" fill="url(#water)" y="55" width="2000" height="200" opacity="0.3">
            <animate attributeType="xml" attributeName="x" from="-500" to="0" repeatCount="indefinite" dur="2.8s"/>
            </rect>
            </g>
            </defs>

            <use xlink:href="#eff" opacity="0.9" style="mix-blend-mode:color-burn"/>
            </svg>
            <div id="append"></div>
        </div>

<!--<script src='<%=basePath%>/js/stopExecutionOnTimeout.js?t=1'></script>-->
        <script src="<%=basePath%>/js/jquery-3.1.0.min.js" type="text/javascript"></script>
        <script src="<%=basePath%>/js/zepto.min.js" type="text/javascript"></script>
        <script src="<%=basePath%>/js/remodal.min.js" type="text/javascript"></script>
        <script src="<%=basePath%>/js/jquery-ui.min.js"></script>
        <!--<script src="<%=basePath%>/js/login.js"></script>-->

        <script>
            window.jQuery || document.write('<script src="js/jquery-2.1.1.min.js"><\/script>')
        </script>

        <script>
            $(function () {
                $("img#left").animate({marginLeft: "+160px", opacity: "0.3"}, 8000);
                $("img#right").animate({marginRight: "+100px", opacity: "0.3"}, 7000);
                $("img#right_2").animate({marginRight: "+80px", opacity: "0.3"}, 6000);
            });
        </script>

        <script>
            $(function () {
                $("button.remodal-confirm").click(function () {
                    var curiseName = $("input[name='curiseChoose']:checked").val();
                    $("#curiseName").empty().append(curiseName);
                });
            });
        </script>

        <script>
            $("input[type='button']").click(function () {
                /*var account = $("input[name='account']").val();
                var password = $("input[name='password']").val();
                var role = $("input[name='role']:checked").val();
                var curiseChoose = $("input[name='curiseChoose']:checked").val();
                alert(account + "/" + password + "/" + role + "/" + curiseChoose);*/

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
                setTimeout(function () {
                    $("form").submit();
                }, 3600);
            });
            $('input[type="text"],input[type="password"]').focus(function () {
                $(this).prev().animate({'opacity': '1'}, 200);
            });
            $('input[type="text"],input[type="password"]').blur(function () {
                $(this).prev().animate({'opacity': '.5'}, 200);
            });
            $('input[type="text"],input[type="password"]').keyup(function () {
                if (!$(this).val() == '') {
                    $(this).next().animate({
                        'opacity': '1',
                        'right': '30'
                    }, 200);
                } else {
                    $(this).next().animate({
                        'opacity': '0',
                        'right': '20'
                    }, 200);
                }
            });
            var open = 0;
            $('.tab').click(function () {
                $(this).fadeOut(200, function () {
                    $(this).parent().animate({'left': '0'});
                });
            });
        </script>

        <script>
            function blink(selector) {
                $(selector).fadeOut('slow', function () {
                    $(this).fadeIn('slow', function () {
                        blink(this);
                    });
                });
            }
            $(document).ready(function () {
                blink('i.icon-large');
            });

            $(function () {
                $("div#role").click(function () {
                    $(this).css("height", "110px");
                    $("div#choose").css("display", "block");
                    $(this).css({backgroundColor: '#f9da83', color: '#271f19'});
                });
            });

            $(function () {
                $("input:radio[name='role']").change(function () {
                    $("div#role").css("height", "38px");
                    $("div#choose").css("display", "none");
                });
            });
        </script>
</html>
