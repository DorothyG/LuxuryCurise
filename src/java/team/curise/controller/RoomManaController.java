/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.curise.controller.mana.service.RoomManaService;
import team.curise.entity.chart.BarChart;
import team.curise.entity.chart.BarChartDatasets;
import team.curise.entity.chart.PieChart;
import team.curise.entity.chart.PieChartDatasets;
import team.curise.json.entity.management.CheckinState;
import team.curise.json.entity.management.CuriseThingsConsume;
import team.curise.json.entity.management.RoomManageEntity;
import team.curise.json.entity.management.TotalLayerCheckin;

/**
 *
 * @author pupu
 */
@Controller
public class RoomManaController {

    @Resource
    private RoomManaService roomManaService;

    private String[] checkinState = {"未入住", "待入住", "已入住"};
    private List<String> occuplist = new ArrayList<>();
    //总的
    @ResponseBody
    @RequestMapping("/indexBackground/roomManage")
    public RoomManageEntity roomManage() throws IOException {
        RoomManageEntity r = new RoomManageEntity();
        r.setCheckin(getAllCheckin());
        r.setConsume(getAllThingsConsume());
        r.setSex(getNumOfDiffSex());
        r.setAge(getNumOfDiffAge());
        r.setTotalLayerCheckin(roomManageAll());
        roomManaService.initAllOccupTwo(1,occuplist);
        r.setOccupList(occuplist);
        return r;
    }

    //总表
    @ResponseBody
    @RequestMapping("/roomManageAll")
    public TotalLayerCheckin roomManageAll() throws IOException {
        TotalLayerCheckin totalLayerCheckin = roomManaService.getRTypeCheckinStateByLayer(1);
        return totalLayerCheckin;
    }

    //点击按舱房类型的时候就是请求到这里，返回按照舱房类型划分的数据
    //room_type 1套房 2阳台房 3海景房 4内舱房
    @ResponseBody
    @RequestMapping("/checkinByRType")
    public BarChart getCheckinByRType() {
        List<CheckinState> checkinStates = roomManaService.getCheckinByRType(1);
        List<String> labels = Arrays.asList("套房", "阳台房", "海景房", "内舱房");
        List<Integer> wait_checkin = new ArrayList<>();
        List<Integer> havenot_checkin = new ArrayList<>();
        List<Integer> already_checkin = new ArrayList<>();
        List<BarChartDatasets> datasets = new ArrayList<>();
        for (int j = 0; j < 4; j++) {
            CheckinState c = checkinStates.get(j);
            wait_checkin.add(c.getWait_checkin());
            havenot_checkin.add(c.getHavenot_checkin());
            already_checkin.add(c.getAlready_checkin());
        }
        //"未入住","待入住","已入住"
        for (int i = 0; i < 3; i++) {
            BarChartDatasets barChartDatasets = new BarChartDatasets();
            barChartDatasets.setLabel(checkinState[i]);
            barChartDatasets.setBorderWidth(1);
            if (i == 0) {
                barChartDatasets.setBackgroundColor("rgba(249,218,131,1)");
                barChartDatasets.setBorderColor("rgba(249,218,131,1)");
                barChartDatasets.setData(havenot_checkin);
            } else if (i == 1) {
                barChartDatasets.setBackgroundColor("rgba(144,238,144,1)");
                barChartDatasets.setBorderColor("rgba(144,238,144,1)");
                barChartDatasets.setData(wait_checkin);
            } else if (i == 2) {
                barChartDatasets.setBackgroundColor("rgba(151,187,205,01)");
                barChartDatasets.setBorderColor("rgba(151,187,205,1)");
                barChartDatasets.setData(already_checkin);
            }
            datasets.add(barChartDatasets);
        }

        BarChart barChart = new BarChart(labels, datasets);
        return barChart;
    }

    //点击按层数的时候请求到這，返回按层数划分的入住状态的信息
    @ResponseBody
    @RequestMapping("/checkinByLayer")
    public BarChart getCheckinByLayer() {
        List<CheckinState> checkinStates = roomManaService.getCheckinByLayer(1);
        int layers = checkinStates.size();
        List<String> labels = new ArrayList<>();
        for (int i = 1; i <= layers; i++) {
            labels.add(i + "层");
        }
        List<Integer> wait_checkin = new ArrayList<>();
        List<Integer> havenot_checkin = new ArrayList<>();
        List<Integer> already_checkin = new ArrayList<>();
        List<BarChartDatasets> datasets = new ArrayList<>();
        for (int i = 0; i < layers; i++) {
            CheckinState c = checkinStates.get(i);
            wait_checkin.add(c.getWait_checkin());
            havenot_checkin.add(c.getHavenot_checkin());
            already_checkin.add(c.getAlready_checkin());
        }
        //"未入住","待入住","已入住"
        for (int i = 0; i < 3; i++) {
            BarChartDatasets barChartDatasets = new BarChartDatasets();
            barChartDatasets.setLabel(checkinState[i]);
            barChartDatasets.setBorderWidth(1);
            if (i == 0) {
                barChartDatasets.setBackgroundColor("rgba(249,218,131,1)");
                barChartDatasets.setBorderColor("rgba(249,218,131,1)");
                barChartDatasets.setData(havenot_checkin);
            } else if (i == 1) {
                barChartDatasets.setBackgroundColor("rgba(144,238,144,1)");
                barChartDatasets.setBorderColor("rgba(144,238,144,1)");
                barChartDatasets.setData(wait_checkin);
            } else if (i == 2) {
                barChartDatasets.setBackgroundColor("rgba(151,187,205,01)");
                barChartDatasets.setBorderColor("rgba(151,187,205,1)");
                barChartDatasets.setData(already_checkin);
            }
            datasets.add(barChartDatasets);
        }

        BarChart barChart = new BarChart(labels, datasets);
        return barChart;
    }

    //总体的入住状态，进入页面先展示的是这个
    @ResponseBody
    @RequestMapping("/checkinAll")
    public BarChart getAllCheckin() {
        CheckinState checkinStates = roomManaService.getAllCheckin(1);
        List<String> labels = Arrays.asList("未入住", "待入住", "已入住");

        List<BarChartDatasets> datasets = new ArrayList<>();

        List<Integer> data = new ArrayList<>();
        data.add(checkinStates.getHavenot_checkin());
        data.add(checkinStates.getWait_checkin());
        data.add(checkinStates.getAlready_checkin());

        BarChartDatasets b = new BarChartDatasets();
        b.setLabel("");
        b.setBorderWidth(1);
        b.setBackgroundColor("rgba(249,218,131,1)");
        b.setBorderColor("rgba(249,218,131,1)");
        b.setData(data);

        datasets.add(b);

        BarChart barChart = new BarChart(labels, datasets);
        return barChart;
    }

    //客房使用
    @ResponseBody
    @RequestMapping("/curiseThingsConsume")
    public BarChart getAllThingsConsume() {
        CuriseThingsConsume curiseThingsConsume = roomManaService.getAllThingsConsume(1);
        List<String> labels = Arrays.asList("牙刷", "牙膏", "毛巾", "拖鞋", "香皂", "沐浴露", "身体乳", "梳子");
        List<Integer> array = new ArrayList<>();
        List<BarChartDatasets> datasets = new ArrayList<>();

        array.add(curiseThingsConsume.getToothbrush());
        array.add(curiseThingsConsume.getToothpaste());
        array.add(curiseThingsConsume.getTowel());
        array.add(curiseThingsConsume.getSlippers());
        array.add(curiseThingsConsume.getSoap());
        array.add(curiseThingsConsume.getShamppo());
        array.add(curiseThingsConsume.getLotion());
        array.add(curiseThingsConsume.getComb());
        BarChartDatasets b = new BarChartDatasets();
        b.setLabel("");
        b.setBorderWidth(1);
        b.setBackgroundColor("rgba(249,218,131,1)");
        b.setBorderColor("rgba(249,218,131,1)");
        b.setData(array);
        datasets.add(b);

        BarChart barChart = new BarChart(labels, datasets);
        return barChart;
    }

    //消费群体按职业分
    @ResponseBody
    @RequestMapping("/numOfDiffOccup")
    public PieChart getNumOfDiffOccup() {
        Map<String, Integer> numOfDiffOccup = roomManaService.getNumOfDiffOccup(1);
        List<PieChartDatasets> datasets = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : numOfDiffOccup.entrySet()) {
            labels.add(entry.getKey());
            data.add(entry.getValue());
        }

        List<String> backgroundColor = Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#7B68EE", "#FF6347");
        List<String> hoverBackgroundColor = Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#7B68EE", "#FF6347");
        PieChartDatasets pcd = new PieChartDatasets(data, backgroundColor, hoverBackgroundColor);
        datasets.add(pcd);
        PieChart pieChart = new PieChart(labels, datasets);

        return pieChart;
    }

    //消费群体按性别分
    @ResponseBody
    @RequestMapping("/numOfDiffSex")
    public PieChart getNumOfDiffSex() {
        Map<String, Integer> numOfDiffSex = roomManaService.getNumOfDiffSex(1);
        List<PieChartDatasets> datasets = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : numOfDiffSex.entrySet()) {
            labels.add(entry.getKey());
            data.add(entry.getValue());
        }
        List<String> backgroundColor = Arrays.asList("#FF6384", "#36A2EB");
        List<String> hoverBackgroundColor = Arrays.asList("#FF6384", "#36A2EB");
        PieChartDatasets pcd = new PieChartDatasets(data, backgroundColor, hoverBackgroundColor);
        datasets.add(pcd);
        PieChart pieChart = new PieChart(labels, datasets);

        return pieChart;
    }

    //年龄阶段划分
    @ResponseBody
    @RequestMapping("/numOfDiffAge")
    public PieChart getNumOfDiffAge() {
        Map<String, Integer> numOfDiffAge = roomManaService.getNumOfDiffAge(1);
        List<PieChartDatasets> datasets = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : numOfDiffAge.entrySet()) {
            labels.add(entry.getKey());
            data.add(entry.getValue());
        }
        List<String> backgroundColor = Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#7B68EE", "#FF6347");
        List<String> hoverBackgroundColor = Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#7B68EE", "#FF6347");
        PieChartDatasets pcd = new PieChartDatasets(data, backgroundColor, hoverBackgroundColor);
        datasets.add(pcd);
        PieChart pieChart = new PieChart(labels, datasets);

        return pieChart;
    }
    
    
}
