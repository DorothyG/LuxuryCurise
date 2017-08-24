/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.curise.controller.service.*;
import team.curise.json.entity.*;

/**
 *
 * @author pupu
 */
@Controller
public class QueryAllController {

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

//    @ResponseBody
//    @RequestMapping("/inedx/engageManage")
//    public String engageManage() throws IOException {
//        
//        return "1";
//    }
    
    @ResponseBody
    @RequestMapping("/index/cleanStatus")
    public List<CleanStatus> clean() throws IOException {
        List<CleanStatus> result = cleanStatusService.findAllCleanStatus(curise_id);
        return result;
    }

    @ResponseBody
    @RequestMapping("/index/thingsConsume")
    public List<ThingsConsume> thingsConsume() {
        List<ThingsConsume> result = thingsConsumeService.findAllThingsConsume(curise_id);
        return result;
    }

    @ResponseBody
    @RequestMapping("/index/changeInfo")
    public List<ChangeInfo> changeInfo() {
        List<ChangeInfo> result = changeInfoService.findAllCI(curise_id);
        return result;
    }
    
    //预定查询
    @ResponseBody
    @RequestMapping("/index/reserveInfo")
    public List<ReserveInfo> reserveInfo() throws ParseException {
        List<ReserveInfo> result = reserveInfoService.findAllReserveInfo(curise_id);
        return result;
    }
    
     @ResponseBody
    @RequestMapping("/index/customerInfo")
    public List<CustomerInfo> customerInfo() {
        List<CustomerInfo> result = customerInfoService.findAllCustomerInfo(curise_id);
        return result;
    }
    
    @ResponseBody
    @RequestMapping("/index/saleRate")
    public SaleRate saleRate() {
        SaleRate s = saleRateService.findAllSaleRate(curise_id, curise_name);
        return s;
    }
}
