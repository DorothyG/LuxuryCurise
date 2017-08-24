/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller.mana.service;

import java.text.ParseException;
import java.util.ArrayList;
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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.curise.controller.EngageManaController;
import team.curise.entity.Consumption;
import team.curise.entity.DepartMonthRevenue;
import team.curise.entity.DepartYearRevenue;
import team.curise.entity.RoomMonthRevenue;
import team.curise.entity.RoomYearRevenue;
import team.curise.entity.service.UserRoleService;
import team.curise.json.entity.RevenueOfMonth;
import team.curise.json.entity.management.RevenueMonth;
import team.curise.json.entity.management.RevenueQuarter;
import team.curise.json.entity.management.RevenueYear;
import team.curise.util.DateUtil;

/**
 *
 * @author pupu
 */
@Service
public class EngageService {

    @Resource
    private UserRoleService userRoleService;

    //娱乐事业部 1 餐饮部2  零售部3
    
    //得到零售部十二个月的营业情况
    public List<RevenueMonth> retailDepartRevenueOnMonth(int curise_id) throws ParseException {
        List<RevenueMonth> l = getDepartRevenueOnMonth(curise_id, 3);
        return l;
    }

    public List<RevenueQuarter> retailDepartRevenueOnQuarter(int curise_id) throws ParseException {
        List<RevenueQuarter> l = getDepartRevenueOnQuarter(curise_id, 3);
        return l;
    }

    public List<RevenueYear> retailDepartRevenueOnYear(int curise_id) throws ParseException {
        List<RevenueYear> l = getDepartRevenueOnYear(curise_id, 3);
        return l;
    }
    
    
    //得到娱乐事业部十二个月的营业情况
    public List<RevenueMonth> entertainDepartRevenueOnMonth(int curise_id) throws ParseException {
        List<RevenueMonth> l = getDepartRevenueOnMonth(curise_id, 1);
        return l;
    }

    public List<RevenueQuarter> entertainDepartRevenueOnQuater(int curise_id) throws ParseException {
        List<RevenueQuarter> l = getDepartRevenueOnQuarter(curise_id, 1);
        return l;
    }

    public List<RevenueYear> entertainDepartRevenueOnYear(int curise_id) throws ParseException {
        List<RevenueYear> l = getDepartRevenueOnYear(curise_id, 1);
        return l;
    }
    
    //得到餐饮部十二个月的营业情况
    public List<RevenueMonth> foodDepartRevenueOnMonth(int curise_id) throws ParseException {
        List<RevenueMonth> l = getDepartRevenueOnMonth(curise_id, 2);
        return l;
    }

    public List<RevenueQuarter> foodDepartRevenueOnQuater(int curise_id) throws ParseException {
        List<RevenueQuarter> l = getDepartRevenueOnQuarter(curise_id, 2);
        return l;
    }
    
     public List<RevenueYear> foodDepartRevenueOnYear(int curise_id) throws ParseException {
        List<RevenueYear> l = getDepartRevenueOnYear(curise_id, 2);
        return l;
    }

    //得到客房十二个月的营业情况
    public List<RevenueMonth> roomRevenueOnMonth(int curise_id) throws ParseException {
        List<RevenueMonth> l = getRoomRevenueOnMonth(curise_id);
        return l;
    }
    
    public List<RevenueQuarter> roomRevenueOnQuarter(int curise_id) throws ParseException {
        List<RevenueQuarter> l = getRoomRevenueOnQuarter(curise_id);
        return l;
    }
    
    
    public List<RevenueYear> roomRevenueOnyear(int curise_id) throws ParseException{
        List<RevenueYear> l = getRoomRevenueOnYear(curise_id);
        return l;
    }

    public List<RevenueMonth> getRoomRevenueOnMonth(int curise_id) throws ParseException{
        List<RevenueMonth> l = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int nowMonth = calendar.get(Calendar.MONTH) + 1;
        int nowYear = calendar.get(Calendar.YEAR);
        List<RoomMonthRevenue> r = getMonthRoomRevenueByCuriseId(curise_id);
        sortRoomMonthRevenue(r);
        for(RoomMonthRevenue rmr:r){
            String datetime = rmr.getDate();
            Date date = DateUtil.stringToDate(datetime);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int year = c.get(Calendar.YEAR);
            int month = date.getMonth() + 1;//要注意month是从0开始的
            if ((month <= nowMonth && year == nowYear) || (month > nowMonth && year == (nowYear - 1))) {
                double revenue = rmr.getRevenue();
                RevenueMonth revenueMonth = new RevenueMonth(month, revenue);
                l.add(revenueMonth);
            }
        }
        return l;
    }
    
    public List<RevenueMonth> getDepartRevenueOnMonth(int curise_id, int depart_id) throws ParseException {
        List<RevenueMonth> l = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int nowMonth = calendar.get(Calendar.MONTH) + 1;
        int nowYear = calendar.get(Calendar.YEAR);
        //让月份从以前到现在这个月，一共十二个月，算出来发现就是上一年的比目前月份大一的月份开始
        List<DepartMonthRevenue> r = getMonthRevenueByCuriseIdAndDId(curise_id, depart_id);
        sortDepartMonthRevenue(r);
        for (DepartMonthRevenue d : r) {
            String datetime = d.getDate();
            Date date = DateUtil.stringToDate(datetime);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int year = c.get(Calendar.YEAR);
            int month = date.getMonth() + 1;//要注意month是从0开始的
            if ((month <= nowMonth && year == nowYear) || (month > nowMonth && year == (nowYear - 1))) {
                double revenue = d.getRevenue();
                RevenueMonth revenueMonth = new RevenueMonth(month, revenue);
                l.add(revenueMonth);
            }
        }
        return l;
    }

    public List<RevenueQuarter> getRoomRevenueOnQuarter(int curise_id) throws ParseException{
        List<RevenueQuarter> l = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int nowMonth = calendar.get(Calendar.MONTH) + 1;
        int nowYear = calendar.get(Calendar.YEAR);
        List<RoomMonthRevenue> r = getMonthRoomRevenueByCuriseId(curise_id);
        sortRoomMonthRevenue(r);
        int quarter = 1;
        int i = 0;
        double nowQuarter = 0;
        for (RoomMonthRevenue d : r) {
            String datetime = d.getDate();
            Date date = DateUtil.stringToDate(datetime);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int year = c.get(Calendar.YEAR);
            int month = date.getMonth() + 1;//要注意month是从0开始的

            if (month <= nowMonth && year == nowYear) {
                i++;
                nowQuarter += d.getRevenue();
                if (i == 3) {
                    RevenueQuarter q = new RevenueQuarter(quarter, nowQuarter);
                    l.add(q);
                    i = 0;
                    nowQuarter = 0;
                    quarter++;
                }

            }
        }
        return l;
    }
    
    public List<RevenueQuarter> getDepartRevenueOnQuarter(int curise_id, int depart_id) throws ParseException {
        List<RevenueQuarter> l = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int nowMonth = calendar.get(Calendar.MONTH) + 1;
        int nowYear = calendar.get(Calendar.YEAR);
        //让月份从以前到现在这个月，一共十二个月，算出来发现就是上一年的比目前月份大一的月份开始
        List<DepartMonthRevenue> r = getMonthRevenueByCuriseIdAndDId(curise_id, depart_id);
        sortDepartMonthRevenue(r);
        int quarter = 1;
        int i = 0;
        double nowQuarter = 0;
        for (DepartMonthRevenue d : r) {
            String datetime = d.getDate();
            Date date = DateUtil.stringToDate(datetime);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int year = c.get(Calendar.YEAR);
            int month = date.getMonth() + 1;//要注意month是从0开始的

            if (month <= nowMonth && year == nowYear) {
                i++;
                nowQuarter += d.getRevenue();
                if (i == 3) {
                    RevenueQuarter q = new RevenueQuarter(quarter, nowQuarter);
                    l.add(q);
                    i = 0;
                    nowQuarter = 0;
                    quarter++;
                }

            }
        }
        return l;
    }

    public List<RevenueYear> getDepartRevenueOnYear(int curise_id, int depart_id) throws ParseException {
        List<RevenueYear> list = new ArrayList<>();
        List<DepartYearRevenue> l = getYearRevenueByCuriseIdAndDId(curise_id, depart_id);
        sortDepartYearRevenue(l);
        for (DepartYearRevenue d : l) {
            double revenue = d.getRevenue();
            int year = getYearFromDatetime(d.getDate());
            RevenueYear revenueYear = new RevenueYear(year, revenue);
            list.add(revenueYear);
        }
        return list;
    }

    public List<RevenueYear> getRoomRevenueOnYear(int curise_id) throws ParseException {
        List<RevenueYear> list = new ArrayList<>();
        List<RoomYearRevenue> l = getRoomYearRevenueByCuriseId(curise_id);
        sortRoomYearRevenue(l);
        for(RoomYearRevenue r:l){
            double revenue = r.getRevenue();
            int year = getYearFromDatetime(r.getDate());
            RevenueYear revenueYear = new RevenueYear(year, revenue);
            list.add(revenueYear);
        }
        return list;
    }
    
    public int getYearFromDatetime(String datetime) throws ParseException {
        Date date = DateUtil.stringToDate(datetime);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = c.get(Calendar.YEAR);
        return year;
    }

    public void sortRoomYearRevenue(List<RoomYearRevenue> list){
        Collections.sort(list,new Comparator<RoomYearRevenue>(){
            @Override
            public int compare(RoomYearRevenue o1, RoomYearRevenue o2) {
                try {
                    Date date1 = DateUtil.stringToDate(o1.getDate());
                    Date date2 = DateUtil.stringToDate(o2.getDate());
                    Calendar c = Calendar.getInstance();
                    c.setTime(date1);
                    int year1 = c.get(Calendar.YEAR);
                    c.setTime(date2);
                    int year2 = c.get(Calendar.YEAR);
                    if (year1 > year2) {
                        return 1;
                    } else if (year1 == year2) {
                        return 0;
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(EngageService.class.getName()).log(Level.SEVERE, null, ex);
                }
                return -1;
            }
        });
    }
    
    public void sortDepartYearRevenue(List<DepartYearRevenue> list) {
        Collections.sort(list, new Comparator<DepartYearRevenue>() {
            @Override
            public int compare(DepartYearRevenue o1, DepartYearRevenue o2) {
                try {
                    Date date1 = DateUtil.stringToDate(o1.getDate());
                    Date date2 = DateUtil.stringToDate(o2.getDate());
                    Calendar c = Calendar.getInstance();
                    c.setTime(date1);
                    int year1 = c.get(Calendar.YEAR);
                    c.setTime(date2);
                    int year2 = c.get(Calendar.YEAR);
                    if (year1 > year2) {
                        return 1;
                    } else if (year1 == year2) {
                        return 0;
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(EngageService.class.getName()).log(Level.SEVERE, null, ex);
                }
                return -1;
            }
        });
    }

    public void sortRoomMonthRevenue(List<RoomMonthRevenue> list){
        Collections.sort(list,new Comparator<RoomMonthRevenue>(){
            @Override
            public int compare(RoomMonthRevenue o1, RoomMonthRevenue o2) {
                if(o1!=null&&o2!=null){
                    try {
                        Date date1 = DateUtil.stringToDate(o1.getDate());
                        Date date2 = DateUtil.stringToDate(o2.getDate());
                        int month1 = date1.getMonth();
                        int month2 = date2.getMonth();
                        Calendar c = Calendar.getInstance();
                        c.setTime(date1);
                        int year1 = c.get(Calendar.YEAR);
                        c.setTime(date2);
                        int year2 = c.get(Calendar.YEAR);
                        if (year1 > year2) {
                            return 1;
                        } else if (year1 == year2) {
                            if (month1 > month2) {
                                return 1;
                            } else if (month1 < month2) {
                                return -1;
                            }
                            return 0;
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(EngageService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return -1;
            }
        });
    }
    
    public void sortDepartMonthRevenue(List<DepartMonthRevenue> list) {
        Collections.sort(list, new Comparator<DepartMonthRevenue>() {
            @Override
            public int compare(DepartMonthRevenue o1, DepartMonthRevenue o2) {
                try {
                    if (o1 != null && o2 != null) {
                        Date date1 = DateUtil.stringToDate(o1.getDate());
                        Date date2 = DateUtil.stringToDate(o2.getDate());
                        int month1 = date1.getMonth();
                        int month2 = date2.getMonth();
                        Calendar c = Calendar.getInstance();
                        c.setTime(date1);
                        int year1 = c.get(Calendar.YEAR);
                        c.setTime(date2);
                        int year2 = c.get(Calendar.YEAR);
                        if (year1 > year2) {
                            return 1;
                        } else if (year1 == year2) {
                            if (month1 > month2) {
                                return 1;
                            } else if (month1 < month2) {
                                return -1;
                            }
                            return 0;
                        }
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(EngageManaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                return -1;
            }
        });
    }

    public List<RoomMonthRevenue> getMonthRoomRevenueByCuriseId(int curise_id){
        List r = userRoleService.find("from RoomMonthRevenue where curise_id=? ", curise_id);
        List<RoomMonthRevenue> list = (List<RoomMonthRevenue>)r;
        return list;
    }
    
    public List<DepartMonthRevenue> getMonthRevenueByCuriseIdAndDId(int curise_id, int depart_id) {
        List r = userRoleService.find("from DepartMonthRevenue where curise_id=? and depart_id=?", curise_id, depart_id);
        List<DepartMonthRevenue> list = (List<DepartMonthRevenue>) r;
        return list;
    }

    public List<DepartYearRevenue> getYearRevenueByCuriseIdAndDId(int curise_id, int depart_id) {
        List r = userRoleService.find("from DepartYearRevenue where curise_id=? and depart_id=? ", curise_id, depart_id);
        List<DepartYearRevenue> list = (List<DepartYearRevenue>) r;
        return list;
    }
    
    public List<RoomYearRevenue> getRoomYearRevenueByCuriseId(int curise_id){
        List r = userRoleService.find("from RoomYearRevenue where curise_id=? ", curise_id);
        List<RoomYearRevenue> list = (List<RoomYearRevenue>)r;
        return list;
    }

  
        
    
}
