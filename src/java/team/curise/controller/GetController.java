/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author pupu
 */
@Controller
public class GetController {

    @RequestMapping("/changeInfoTable")
    public ModelAndView changeInfoTable() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/changeInfoTable");
        return mv;
    }
    
    @RequestMapping("/curiseAboardTable")
    public ModelAndView curiseAboardTable() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/curiseAboardTable");
        return mv;
    }
    
    @RequestMapping("/depositPayTable")
    public ModelAndView depositPayTable() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/depositPayTable");
        return mv;
    }
    
    @RequestMapping("/paymentTable")
    public ModelAndView paymentTable() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/paymentTable");
        return mv;
    }
    
    @RequestMapping("/reserveTable")
    public ModelAndView reserveInfoTable() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/reserveTable");
        return mv;
    }
    
    @RequestMapping("/engageManage")
    public ModelAndView engageManege() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/engageManage");
        return mv;
    }
    
    @RequestMapping("/indexBackground")
    public ModelAndView inedx() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/indexBackground");
        return mv;
    }
    
    @RequestMapping("/infoManage")
    public ModelAndView infoManage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/infoManage");
        return mv;
    }
    
    @RequestMapping("/roomManage")
    public ModelAndView roomManage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/roomManage");
        return mv;
    }
    
    //就是为了能让angular的index能访问得到，能访问得到就能注入到另一个html中
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/cleanStatus")
    public ModelAndView cleanStatus() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cleanStatus");
        return mv;
    }
    
    @RequestMapping("/changeInfo")
    public ModelAndView changeInfo() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("changeInfo");
        return mv;
    }

    @RequestMapping("/curiseAboard")
    public ModelAndView curiseAboard() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("curiseAboard");
        return mv;
    }
    
    @RequestMapping("/customerInfo")
    public ModelAndView customerInfo() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customerInfo");
        return mv;
    }
    
    @RequestMapping("/depositPay")
    public ModelAndView depositPay() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("depositPay");
        return mv;
    }
    
    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        System.out.println("lllllllllll");
        return mv;
    }
    
    @RequestMapping("/payment")
    public ModelAndView payment() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("payment");
        return mv;
    }
    
    @RequestMapping("/reserve")
    public ModelAndView reserve() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("reserve");
        return mv;
    }
    
    @RequestMapping("/reserveInfo")
    public ModelAndView reserveInfo() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("reserveInfo");
        return mv;
    }
    
    @RequestMapping("/roomChange")
    public ModelAndView roomChange() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("roomChange");
        return mv;
    }
    
    @RequestMapping("/saleRate")
    public ModelAndView saleRate() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("saleRate");
        return mv;
    }
    
   
    
    @RequestMapping("/thingsConsume")
    public ModelAndView thingsConsume() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("thingsConsume");
        return mv;
    }
}
