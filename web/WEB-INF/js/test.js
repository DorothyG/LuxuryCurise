/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var data = {
    labels: ["内舱房", "海景房", "阳台房", "套房"],
    datasets: [
        {
            label: "未入住",
            backgroundColor: "rgba(218,165,32,0.5)",
            borderColor: "rgba(218,165,32,1)",
            borderWidth: 1,
            data: [65, 59, 86, 81]
        },
        {
            label: "待入住",
            backgroundColor: "rgba(144,238,144,0.5)",
            borderColor: "rgba(144,238,144,1)",
            borderWidth: 1,
            data: [14, 23, 5, 14]
        },
        {
            label: "已入住",
            backgroundColor: "rgba(151,187,205,0.5)",
            borderColor: "rgba(151,187,205,1)",
            borderWidth: 1,
            data: [28, 48, 40, 19]
        }
    ]
};
var chartBar = null;
window.onload = function () {
    $("div#content").append("<canvas id='myChart1' width='1024' height='500'></canvas>");
    var ctx = document.getElementById("myChart1").getContext("2d");
    chartBar = new Chart(ctx, {
        type: 'bar',
        data: data,
        options: {
            display: true
        }
    });

    $("div#content").append("<canvas id='myChart2' width='1024' height='500'></canvas>");
    var ctx2 = document.getElementById("myChart2").getContext("2d");
    chartBar2 = new Chart(ctx2, {
        type: 'bar',
        data: data,
        options: {
            display: true
        }
    })

    var ctx3 = document.getElementById("myChart3").getContext("2d");
    chartBar3 = new Chart(ctx3, {
        type: 'pie',
        data: data2,
        options: {
            display: true
        }
    })

    var ctx4 = document.getElementById("myChart4").getContext("2d");
    chartBar4 = new Chart(ctx4, {
        type: 'pie',
        data: data2,
        options: {
            display: true
        }
    })
}
var data2 = {
    labels: [
        "青年",
        "中年",
        "老年"
    ],
    datasets: [
        {
            data: [30, 40, 20],
            backgroundColor: [
                "#FF6384",
                "#36A2EB",
                "#FFCE56"
            ],
            hoverBackgroundColor: [
                "#FF6384",
                "#36A2EB",
                "#FFCE56"
            ]
        }
    ]
}


