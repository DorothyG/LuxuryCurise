/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
mylayout.controller("checkInState", function () {
    var data = {
        labels: ["内舱房", "海景房", "阳台房", "套房"],
        datasets: [
            {
                label: "未入住",
                backgroundColor: "rgba(249,218,131,1)",
                borderColor: "rgba(249,218,131,1)",
                borderWidth: 1,
                data: [65, 59, 90, 81]
            },
            {
                label: "待入住",
                backgroundColor: "rgba(144,238,144,1)",
                borderColor: "rgba(144,238,144,1)",
                borderWidth: 1,
                data: [14, 23, 5, 14]
            },
            {
                label: "已入住",
                backgroundColor: "rgba(151,187,205,01)",
                borderColor: "rgba(151,187,205,1)",
                borderWidth: 1,
                data: [28, 48, 40, 19]
            }
        ]
    };
    var ctx = document.getElementById("checkInStateChart").getContext("2d");
    var chartBar = new Chart(ctx, {
        type: 'bar',
        data: data,
        options: {
            display: true
        }
    });
});


