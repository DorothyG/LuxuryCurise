/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller;

import java.text.ParseException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import team.curise.controller.service.*;
import team.curise.json.entity.*;

/**
 *
 * @author pupu
 */
@Controller
public class QueryInputController {

    @Resource
    private CleanStatusService cleanStatusService;
    @Resource
    private ThingsConsumeService thingsConsumeService;
    @Resource
    private ChangeInfoService changeInfoService;
    @Resource
    private CustomerInfoService customerInfoService;
    @Resource
    private ReserveInfoService reserveInfoService;
    @Resource
    private SaleRateService saleRateService;
    
     private int curise_id = 1;
    private String curise_name = "维多利亚1号";

    @ResponseBody
    @RequestMapping(value = "/index/changeInfo", method = RequestMethod.POST)
    public List<ChangeInfo> changeInfo(HttpServletRequest req) {
        String u_name = req.getParameter("user_name");
        List<ChangeInfo> result = changeInfoService.findCIByUName(u_name, curise_id);
        return result;
    }
       @ResponseBody
    @RequestMapping(value="/index/cleanStatus",method=RequestMethod.POST)
    public List<CleanStatus> cleanStatus(HttpServletRequest req) {
        String room_name = req.getParameter("room_name");
         List<CleanStatus> result = cleanStatusService.findCleanStatusByRoomName(curise_id, room_name);
         return result;
    }
    
     @ResponseBody
    @RequestMapping(value="/index/thingsConsume",method=RequestMethod.POST)
    public List<ThingsConsume> thingsConsume(HttpServletRequest req) {
        String room_name = req.getParameter("room_name");
        List<ThingsConsume> result = thingsConsumeService.findTCByRoomName(curise_id, room_name);
        return result;
    }
    
    //预定查询,注意想如果找不到应该怎么办
    //用户名和真实姓名都可以查询
    @ResponseBody
    @RequestMapping(value="/index/reserveInfo",method=RequestMethod.POST)
    public List<ReserveInfo> reserveInfo(HttpServletRequest req) throws ParseException {
        String u_name = req.getParameter("user_name");
        List<ReserveInfo> result = reserveInfoService.findAllReserveInfoByUName(u_name, curise_id);
        return result;
    }
    
     @ResponseBody
    @RequestMapping(value="/index/customerInfo",method = RequestMethod.POST)
    public List<CustomerInfo> customerInfo(HttpServletRequest req) {
        String u_name = req.getParameter("user_name");
        List<CustomerInfo> result = customerInfoService.findCustomerInfoByUName(u_name, curise_id);
        return result;
    }
    
       //这里输入的舱房类型是String，如内舱房
    @ResponseBody
    @RequestMapping(value="/index/saleRate",method=RequestMethod.POST)
    public SaleRate saleRate(HttpServletRequest req) {
        String r_type=req.getParameter("room_type");
        SaleRate s = saleRateService.findSaleRateByRoomType(curise_id, curise_name, r_type);
        return s;
    }
}