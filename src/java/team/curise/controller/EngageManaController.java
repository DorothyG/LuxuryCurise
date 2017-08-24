/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.curise.controller.mana.service.EngageService;
import team.curise.entity.DepartMonthRevenue;
import team.curise.entity.RoomMonthRevenue;
import team.curise.entity.chart.LineChart;
import team.curise.entity.chart.LineChartDatasets;
import team.curise.entity.service.UserRoleService;
import team.curise.json.entity.CreditOfDiffRank;
import team.curise.json.entity.RevenueOfMonth;
import team.curise.json.entity.management.EngageManageEntity;
import team.curise.json.entity.management.RevenueMonth;
import team.curise.json.entity.management.RevenueQuarter;
import team.curise.json.entity.management.RevenueYear;
import team.curise.json.entity.management.RoomManageEntity;
import team.curise.util.DateUtil;

/**
 *
 * @author pupu
 */
@Controller
public class EngageManaController {

    @Resource
    private EngageService engageService;
    @Resource
    private UserRoleService userRoleService;

    //总的
    @ResponseBody
    @RequestMapping("/indexBackground/engageManage")
    public EngageManageEntity engageManage() throws IOException, ParseException {
        EngageManageEntity e = new EngageManageEntity();
        e.setTotal(totalRevenueOnMonth());
        e.setRoom(roomRevenueOnMonth());
        e.setRetail(retailDepartRevenueOnMonth());
        e.setEntertain(entertainDepartRevenueOnMonth());
        e.setFood(foodDepartRevenueOnMonth());
        return e;
    }

    @ResponseBody
    @RequestMapping("/totalRevenueOnMonth")
    public LineChart totalRevenueOnMonth() throws ParseException {
        LineChart total = new LineChart();
        total.setLabels(retailDepartRevenueOnMonth().getLabels());
        List<LineChartDatasets> datasets = new ArrayList<>();
        datasets.add(retailDepartRevenueOnMonth().getDatasets().get(0));
        datasets.add(entertainDepartRevenueOnMonth().getDatasets().get(0));
        datasets.add(foodDepartRevenueOnMonth().getDatasets().get(0));
        datasets.add(roomRevenueOnMonth().getDatasets().get(0));
        total.setDatasets(datasets);
        return total;
    }

    @ResponseBody
    @RequestMapping("/totalRevenueOnQuarter")
    public LineChart totalRevenueOnQuarter() throws ParseException {
        LineChart total = new LineChart();
        total.setLabels(retailDepartRevenueOnQuarter().getLabels());
        List<LineChartDatasets> datasets = new ArrayList<>();
        datasets.add(retailDepartRevenueOnQuarter().getDatasets().get(0));
        datasets.add(entertainDepartRevenueOnQuarter().getDatasets().get(0));
        datasets.add(foodDepartRevenueOnQuarter().getDatasets().get(0));
        datasets.add(roomRevenueOnQuarter().getDatasets().get(0));
        total.setDatasets(datasets);
        return total;
    }

    @ResponseBody
    @RequestMapping("/totalRevenueOnYear")
    public LineChart totalRevenueOnYear() throws ParseException {
        LineChart total = new LineChart();
        total.setLabels(retailDepartRevenueOnYear().getLabels());
        List<LineChartDatasets> datasets = new ArrayList<>();
        datasets.add(retailDepartRevenueOnYear().getDatasets().get(0));
        datasets.add(entertainDepartRevenueOnYear().getDatasets().get(0));
        datasets.add(foodDepartRevenueOnYear().getDatasets().get(0));
        datasets.add(roomRevenueOnYear().getDatasets().get(0));
        total.setDatasets(datasets);
        return total;
    }

    @ResponseBody
    @RequestMapping("/retailDepartRevenueOnMonth")
    public LineChart retailDepartRevenueOnMonth() throws ParseException {
        List<RevenueMonth> revenueOfMonth = engageService.retailDepartRevenueOnMonth(1);
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (RevenueMonth r : revenueOfMonth) {
            labels.add(r.getMonth() + "月");
            data.add(r.getRevenue());
        }
        List<LineChartDatasets> datasets = new ArrayList<>();
        LineChartDatasets l = new LineChartDatasets("零售部", false, 0.1, "rgba(75,192,192,0.4)", "rgba(75,192,192,1)", "butt", 0.0, "miter", "rgba(75,192,192,1)", "#fff", 1, 5, "rgba(75,192,192,1)", "rgba(220,220,220,1)", 2, 1, 10, data, false);
        datasets.add(l);
        LineChart lc = new LineChart(labels, datasets);
        return lc;
    }

    @ResponseBody
    @RequestMapping("/retailDepartRevenueOnQuarter")
    public LineChart retailDepartRevenueOnQuarter() throws ParseException {
        List<RevenueQuarter> revenueOfQuarter = engageService.retailDepartRevenueOnQuarter(1);
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (RevenueQuarter r : revenueOfQuarter) {
            labels.add("第" + r.getQuarter() + "季度");
            data.add(r.getRevenue());
        }
        List<LineChartDatasets> datasets = new ArrayList<>();
        LineChartDatasets l = new LineChartDatasets("零售部", false, 0.1, "rgba(75,192,192,0.4)", "rgba(75,192,192,1)", "butt", 0.0, "miter", "rgba(75,192,192,1)", "#fff", 1, 5, "rgba(75,192,192,1)", "rgba(220,220,220,1)", 2, 1, 10, data, false);
        datasets.add(l);
        LineChart lc = new LineChart(labels, datasets);
        return lc;
    }

    @ResponseBody
    @RequestMapping("/retailDepartRevenueOnYear")
    public LineChart retailDepartRevenueOnYear() throws ParseException {
        List<RevenueYear> revenueOfYear = engageService.retailDepartRevenueOnYear(1);
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (RevenueYear r : revenueOfYear) {
            labels.add( r.getYear() + "年");
            data.add(r.getRevenue());
        }
        List<LineChartDatasets> datasets = new ArrayList<>();
        LineChartDatasets l = new LineChartDatasets("零售部", false, 0.1, "rgba(75,192,192,0.4)", "rgba(75,192,192,1)", "butt", 0.0, "miter", "rgba(75,192,192,1)", "#fff", 1, 5, "rgba(75,192,192,1)", "rgba(220,220,220,1)", 2, 1, 10, data, false);
        datasets.add(l);
        LineChart lc = new LineChart(labels, datasets);
        return lc;
    }

    @ResponseBody
    @RequestMapping("/entertainDepartRevenueOnMonth")
    public LineChart entertainDepartRevenueOnMonth() throws ParseException {
        List<RevenueMonth> revenueOfMonth = engageService.entertainDepartRevenueOnMonth(1);
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (RevenueMonth r : revenueOfMonth) {
            labels.add(r.getMonth() + "月");
            data.add(r.getRevenue());
        }
        List<LineChartDatasets> datasets = new ArrayList<>();
        LineChartDatasets l = new LineChartDatasets("娱乐事业部", false, 0.1, "rgba(220,20,60,0.4)", "rgba(220,20,60,1)", "butt", 0.0, "miter", "rgba(220,20,60,1)", "#fff", 1, 5, "rgba(220,20,60,1)", "rgba(220,220,220,1)", 2, 1, 10, data, false);
        datasets.add(l);
        LineChart lc = new LineChart(labels, datasets);
        return lc;
    }

    @ResponseBody
    @RequestMapping("/entertainDepartRevenueOnQuarter")
    public LineChart entertainDepartRevenueOnQuarter() throws ParseException {
        List<RevenueQuarter> revenueOfQuarter = engageService.entertainDepartRevenueOnQuater(1);
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (RevenueQuarter r : revenueOfQuarter) {
            labels.add("第" + r.getQuarter() + "季度");
            data.add(r.getRevenue());
        }
        List<LineChartDatasets> datasets = new ArrayList<>();
        LineChartDatasets l = new LineChartDatasets("娱乐事业部", false, 0.1, "rgba(220,20,60,0.4)", "rgba(220,20,60,1)", "butt", 0.0, "miter", "rgba(220,20,60,1)", "#fff", 1, 5, "rgba(220,20,60,1)", "rgba(220,220,220,1)", 2, 1, 10, data, false);
        datasets.add(l);
        LineChart lc = new LineChart(labels, datasets);
        return lc;
    }

    @ResponseBody
    @RequestMapping("/entertainDepartRevenueOnYear")
    public LineChart entertainDepartRevenueOnYear() throws ParseException {
        List<RevenueYear> revenueOfYear = engageService.entertainDepartRevenueOnYear(1);
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (RevenueYear r : revenueOfYear) {
            labels.add( r.getYear() + "年");
            data.add(r.getRevenue());
        }
        List<LineChartDatasets> datasets = new ArrayList<>();
        LineChartDatasets l = new LineChartDatasets("娱乐事业部", false, 0.1, "rgba(220,20,60,0.4)", "rgba(220,20,60,1)", "butt", 0.0, "miter", "rgba(220,20,60,1)", "#fff", 1, 5, "rgba(220,20,60,1)", "rgba(220,220,220,1)", 2, 1, 10, data, false);
        datasets.add(l);
        LineChart lc = new LineChart(labels, datasets);
        return lc;
    }

    @ResponseBody
    @RequestMapping("/foodDepartRevenueOnMonth")
    public LineChart foodDepartRevenueOnMonth() throws ParseException {
        List<RevenueMonth> revenueOfMonth = engageService.foodDepartRevenueOnMonth(1);
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (RevenueMonth r : revenueOfMonth) {
            labels.add(r.getMonth() + "月");
            data.add(r.getRevenue());
        }
        List<LineChartDatasets> datasets = new ArrayList<>();
        LineChartDatasets l = new LineChartDatasets("餐饮部", false, 0.1, "rgb(0,128,0,0.4)", "rgb(0,128,0,1)", "butt", 0.0, "miter", "rgb(0,128,0,1)", "#fff", 1, 5, "rgb(0,128,0,1)", "rgba(220,220,220,1)", 2, 1, 10, data, false);
        datasets.add(l);
        LineChart lc = new LineChart(labels, datasets);
        return lc;
    }

    @ResponseBody
    @RequestMapping("/foodDepartRevenueOnQuarter")
    public LineChart foodDepartRevenueOnQuarter() throws ParseException {
        List<RevenueQuarter> revenueOfQuarter = engageService.foodDepartRevenueOnQuater(1);
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (RevenueQuarter r : revenueOfQuarter) {
            labels.add("第" + r.getQuarter() + "季度");
            data.add(r.getRevenue());
        }
        List<LineChartDatasets> datasets = new ArrayList<>();
        LineChartDatasets l = new LineChartDatasets("餐饮部", false, 0.1, "rgb(0,128,0,0.4)", "rgb(0,128,0,1)", "butt", 0.0, "miter", "rgb(0,128,0,1)", "#fff", 1, 5, "rgb(0,128,0,1)", "rgba(220,220,220,1)", 2, 1, 10, data, false);
        datasets.add(l);
        LineChart lc = new LineChart(labels, datasets);
        return lc;
    }

    @ResponseBody
    @RequestMapping("/foodDepartRevenueOnYear")
    public LineChart foodDepartRevenueOnYear() throws ParseException {
        List<RevenueYear> revenueOfYear = engageService.foodDepartRevenueOnYear(1);
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (RevenueYear r : revenueOfYear) {
            labels.add( r.getYear() + "年");
            data.add(r.getRevenue());
        }
        List<LineChartDatasets> datasets = new ArrayList<>();
        LineChartDatasets l = new LineChartDatasets("餐饮部", false, 0.1, "rgb(0,128,0,0.4)", "rgb(0,128,0,1)", "butt", 0.0, "miter", "rgb(0,128,0,1)", "#fff", 1, 5, "rgb(0,128,0,1)", "rgba(220,220,220,1)", 2, 1, 10, data, false);
        datasets.add(l);
        LineChart lc = new LineChart(labels, datasets);
        return lc;
    }

    @ResponseBody
    @RequestMapping("/roomRevenueOnMonth")
    public LineChart roomRevenueOnMonth() throws ParseException {
        List<RevenueMonth> revenueOfMonth = engageService.roomRevenueOnMonth(1);
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (RevenueMonth r : revenueOfMonth) {
            labels.add(r.getMonth() + "月");
            data.add(r.getRevenue());
        }
        List<LineChartDatasets> datasets = new ArrayList<>();
        LineChartDatasets l = new LineChartDatasets("客房营收", false, 0.1, "rgb(218,112,214,0.4)", "rgb(218,112,214,1)", "butt", 0.0, "miter", "rgb(218,112,214,1)", "#fff", 1, 5, "rgb(218,112,214,1)", "rgba(220,220,220,1)", 2, 1, 10, data, false);
        datasets.add(l);
        LineChart lc = new LineChart(labels, datasets);
        return lc;
    }

    @ResponseBody
    @RequestMapping("/roomRevenueOnQuarter")
    public LineChart roomRevenueOnQuarter() throws ParseException {
        List<RevenueQuarter> revenueOfQuarter = engageService.roomRevenueOnQuarter(1);
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (RevenueQuarter r : revenueOfQuarter) {
            labels.add("第" + r.getQuarter() + "季度");
            data.add(r.getRevenue());
        }
        List<LineChartDatasets> datasets = new ArrayList<>();
        LineChartDatasets l = new LineChartDatasets("客房营收", false, 0.1, "rgb(218,112,214,0.4)", "rgb(218,112,214,1)", "butt", 0.0, "miter", "rgb(218,112,214,1)", "#fff", 1, 5, "rgb(218,112,214,1)", "rgba(220,220,220,1)", 2, 1, 10, data, false);
        datasets.add(l);
        LineChart lc = new LineChart(labels, datasets);
        return lc;
    }

    @ResponseBody
    @RequestMapping("/roomRevenueOnYear")
    public LineChart roomRevenueOnYear() throws ParseException {
        List<RevenueYear> revenueOfYear = engageService.roomRevenueOnyear(1);
        List<String> labels = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        for (RevenueYear r : revenueOfYear) {
            labels.add( r.getYear() + "年");
            data.add(r.getRevenue());
        }
        List<LineChartDatasets> datasets = new ArrayList<>();
        LineChartDatasets l = new LineChartDatasets("客房营收", false, 0.1, "rgb(218,112,214,0.4)", "rgb(218,112,214,1)", "butt", 0.0, "miter", "rgb(218,112,214,1)", "#fff", 1, 5, "rgb(218,112,214,1)", "rgba(220,220,220,1)", 2, 1, 10, data, false);
        datasets.add(l);
        LineChart lc = new LineChart(labels, datasets);
        return lc;
    }
}
