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
import javax.annotation.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.curise.controller.mana.service.InfoService;
import team.curise.entity.chart.PieChart;
import team.curise.entity.chart.PieChartDatasets;
import team.curise.json.entity.CreditOfDiffRank;
import team.curise.json.entity.RealNameInfo;
import team.curise.json.entity.management.InfoManageEntity;
import team.curise.json.entity.management.TotalLayerCheckin;

/**
 *
 * @author pupu
 */
@Controller
public class InfoManaController {

    @Resource
    private InfoService infoService;
    
    private List<String> occupList = new ArrayList<>();

    //总的
    @ResponseBody
    @RequestMapping("/indexBackground/infoManage")
    public InfoManageEntity infoManage() {
        InfoManageEntity i = new InfoManageEntity();
        i.setCredit(getAllCredit());
        i.setReal_name(getAllRealName());
        infoService.initAllOccupTwo(1, occupList);
        i.setOccupList(occupList);
        return i;
    }

    //信用度审查的总体
    @ResponseBody
    @RequestMapping("/creditAll")
    public PieChart getAllCredit() {
        CreditOfDiffRank c = infoService.getAllCredit(1);

        List<PieChartDatasets> datasets = new ArrayList<>();
        List<String> labels = Arrays.asList("A", "B", "C", "D", "E");
        List<Integer> data = new ArrayList<>();
        data.add(c.getA());
        data.add(c.getB());
        data.add(c.getC());
        data.add(c.getD());
        data.add(c.getE());
        List<String> backgroundColor = Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#7B68EE", "#FF6347");
        List<String> hoverBackgroundColor = Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#7B68EE", "#FF6347");
        PieChartDatasets pcd = new PieChartDatasets(data, backgroundColor, hoverBackgroundColor);
        datasets.add(pcd);
        PieChart pieChart = new PieChart(labels, datasets);

        return pieChart;
    }

    //信用度按职业分
    @ResponseBody
    @RequestMapping("/creditByOccup")
    public PieChart getCreditByOccup(HttpServletRequest req) {
        String occupation = req.getParameter("occupation");
        CreditOfDiffRank c = infoService.getCreditByOccup(1, occupation);
        List<PieChartDatasets> datasets = new ArrayList<>();
        List<String> labels = Arrays.asList("A", "B", "C", "D", "E");
        List<Integer> data = new ArrayList<>();
        data.add(c.getA());
        data.add(c.getB());
        data.add(c.getC());
        data.add(c.getD());
        data.add(c.getE());
        List<String> backgroundColor = Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#7B68EE", "#FF6347");
        List<String> hoverBackgroundColor = Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#7B68EE", "#FF6347");
        PieChartDatasets pcd = new PieChartDatasets(data, backgroundColor, hoverBackgroundColor);
        datasets.add(pcd);
        PieChart pieChart = new PieChart(labels, datasets);

        return pieChart;
    }

    //信用度按性别分
    @ResponseBody
    @RequestMapping("/creditBySex")
    public PieChart getCreditBySex(HttpServletRequest req) {
        String sex = req.getParameter("sex");
        CreditOfDiffRank c = infoService.getCreditBySex(1, sex);
        List<PieChartDatasets> datasets = new ArrayList<>();
        List<String> labels = Arrays.asList("A", "B", "C", "D", "E");
        List<Integer> data = new ArrayList<>();
        data.add(c.getA());
        data.add(c.getB());
        data.add(c.getC());
        data.add(c.getD());
        data.add(c.getE());
        List<String> backgroundColor = Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#7B68EE", "#FF6347");
        List<String> hoverBackgroundColor = Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#7B68EE", "#FF6347");
        PieChartDatasets pcd = new PieChartDatasets(data, backgroundColor, hoverBackgroundColor);
        datasets.add(pcd);
        PieChart pieChart = new PieChart(labels, datasets);

        return pieChart;
    }

//    信用度按年龄分
    @ResponseBody
    @RequestMapping("/creditByAge")
    public PieChart getCreditByAge(HttpServletRequest req) {
        String age = req.getParameter("age");
        CreditOfDiffRank c = infoService.getCreditByAge(1,age);
        List<PieChartDatasets> datasets = new ArrayList<>();
        List<String> labels = Arrays.asList("A", "B", "C", "D", "E");
        List<Integer> data = new ArrayList<>();
        data.add(c.getA());
        data.add(c.getB());
        data.add(c.getC());
        data.add(c.getD());
        data.add(c.getE());
        List<String> backgroundColor = Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#7B68EE", "#FF6347");
        List<String> hoverBackgroundColor = Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#7B68EE", "#FF6347");
        PieChartDatasets pcd = new PieChartDatasets(data, backgroundColor, hoverBackgroundColor);
        datasets.add(pcd);
        PieChart pieChart = new PieChart(labels, datasets);

        return pieChart;
    }

    //实名制总体
    @ResponseBody
    @RequestMapping("/realNameAll")
    public PieChart getAllRealName() {
        RealNameInfo realNameInfo = infoService.getAllRealName(1);
        List<PieChartDatasets> datasets = new ArrayList<>();
        List<String> labels = Arrays.asList("实名", "未实名");
        List<Integer> data = new ArrayList<>();
        data.add(realNameInfo.getRealName());
        data.add(realNameInfo.getNotRealName());
        List<String> backgroundColor = Arrays.asList("#FF6384", "#36A2EB");
        List<String> hoverBackgroundColor = Arrays.asList("#FF6384", "#36A2EB");
        PieChartDatasets pcd = new PieChartDatasets(data, backgroundColor, hoverBackgroundColor);
        datasets.add(pcd);
        PieChart pieChart = new PieChart(labels, datasets);

        return pieChart;
    }

    //实名制按职业分
    @ResponseBody
    @RequestMapping("/realNameNumByOccup")
    public PieChart getRealNameNumByOccup(HttpServletRequest req) {
        String occupation = req.getParameter("occupation");
        RealNameInfo realNameInfo = infoService.getRealNameNumByOccup(1, occupation);
        List<PieChartDatasets> datasets = new ArrayList<>();
        List<String> labels = Arrays.asList("实名", "未实名");
        List<Integer> data = new ArrayList<>();
        data.add(realNameInfo.getRealName());
        data.add(realNameInfo.getNotRealName());
        List<String> backgroundColor = Arrays.asList("#FF6384", "#36A2EB");
        List<String> hoverBackgroundColor = Arrays.asList("#FF6384", "#36A2EB");
        PieChartDatasets pcd = new PieChartDatasets(data, backgroundColor, hoverBackgroundColor);
        datasets.add(pcd);
        PieChart pieChart = new PieChart(labels, datasets);
        return pieChart;
    }

    //实名制按职业分里面的总的
    @ResponseBody
    @RequestMapping("/realNameNumByOccupAll")
    public PieChart getRealNameNumByOccupAll() {
        Map<String, Integer> numOfDiffOccup = infoService.getNumOfDiffOccup(1);
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

    //实名制按性别分
    @ResponseBody
    @RequestMapping("/realNameNumBySex")
    public PieChart getRealNameNumBySex(HttpServletRequest req) {
         String sex = req.getParameter("sex");
        RealNameInfo realNameInfo = infoService.getRealNameNumBySex(1, sex);
        List<PieChartDatasets> datasets = new ArrayList<>();
        List<String> labels = Arrays.asList("实名", "未实名");
        List<Integer> data = new ArrayList<>();
        data.add(realNameInfo.getRealName());
        data.add(realNameInfo.getNotRealName());
        List<String> backgroundColor = Arrays.asList("#FF6384", "#36A2EB");
        List<String> hoverBackgroundColor = Arrays.asList("#FF6384", "#36A2EB");
        PieChartDatasets pcd = new PieChartDatasets(data, backgroundColor, hoverBackgroundColor);
        datasets.add(pcd);
        PieChart pieChart = new PieChart(labels, datasets);
        return pieChart;
    }

    //实名制按性别分里面的总体
    @ResponseBody
    @RequestMapping("/realNameNumBySexAll")
    public PieChart getRealNameNumBySexAll(HttpServletRequest req) {
        Map<String, Integer> map = infoService.getNumOfDiffSex(1);
        List<PieChartDatasets> datasets = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            labels.add(m.getKey());
            data.add(m.getValue());
        }
        List<String> backgroundColor = Arrays.asList("#FF6384", "#36A2EB");
        List<String> hoverBackgroundColor = Arrays.asList("#FF6384", "#36A2EB");
        PieChartDatasets pcd = new PieChartDatasets(data, backgroundColor, hoverBackgroundColor);
        datasets.add(pcd);
        PieChart pieChart = new PieChart(labels, datasets);
        return pieChart;
    }

    //实名制按年龄分
    @ResponseBody
    @RequestMapping("/realNameNumByAge")
    public PieChart getRealNameNumByAge(HttpServletRequest req) {
         String age = req.getParameter("age");
        RealNameInfo realNameInfo = infoService.getRealNameNumByAge(1, age);
        List<PieChartDatasets> datasets = new ArrayList<>();
        List<String> labels = Arrays.asList("实名", "未实名");
        List<Integer> data = new ArrayList<>();
        data.add(realNameInfo.getRealName());
        data.add(realNameInfo.getNotRealName());
        List<String> backgroundColor = Arrays.asList("#FF6384", "#36A2EB");
        List<String> hoverBackgroundColor = Arrays.asList("#FF6384", "#36A2EB");
        PieChartDatasets pcd = new PieChartDatasets(data, backgroundColor, hoverBackgroundColor);
        datasets.add(pcd);
        PieChart pieChart = new PieChart(labels, datasets);
        return pieChart;
    }

    //实名制按年龄里面的总体
    @ResponseBody
    @RequestMapping("/realNameNumByAgeAll")
    public PieChart getRealNameNumByAgeAll(HttpServletRequest req) {
        Map<String, Integer> map = infoService.getNumOfDiffAge(1);
        List<PieChartDatasets> datasets = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            labels.add(m.getKey());
            data.add(m.getValue());
        }
        List<String> backgroundColor = Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#7B68EE", "#FF6347");
        List<String> hoverBackgroundColor = Arrays.asList("#FF6384", "#36A2EB", "#FFCE56", "#7B68EE", "#FF6347");
        PieChartDatasets pcd = new PieChartDatasets(data, backgroundColor, hoverBackgroundColor);
        datasets.add(pcd);
        PieChart pieChart = new PieChart(labels, datasets);
        return pieChart;
    }
}
