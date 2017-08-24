/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;
import team.curise.entity.ManagerRole;
import team.curise.entity.ServiceRole;
import team.curise.entity.service.UserRoleService;
import team.curise.entity.UserRole;
import team.curise.entity.service.ManageRoleService;
import team.curise.entity.service.ServiceRoleService;

/**
 * @author pupu
 */
///只要能够到我的controller，控制权就交给springmvc了
@Controller
public class LoginController {

    @Resource
    private UserRoleService userRoleService;
    @Resource
    private ManageRoleService managerRoleService;
    @Resource
    private ServiceRoleService serviceRoleService;

    @RequestMapping(value = "/manageLogin", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        System.err.println("============");
        System.out.println("===============");
//        ModelAndView mv = new ModelAndView();

        String curiseChoose = request.getParameter("curiseChoose");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        System.err.println("============");
        if (role.equals("service")) {
            //获取session;
            HttpSession session = request.getSession(true);
            ServiceRole sr = (ServiceRole) userRoleService.find("from ServiceRole where account=? ", account).get(0);
            System.out.println("account:" + sr.getAccount() + ",databasepassword:" + sr.getPassword() + ",nowPassword:" + encoderByMd5(password));
            if (sr != null && sr.getPassword().equals(encoderByMd5(password))) {
                //把这些东西都加到session中去;
                //在session的数据， 在界面中也可以直接通过${}获取到;
                System.out.println("enter service ,the account and password are right");
                session.setAttribute("account", account);
                //如果我用setViewName就不会改变url，因为是直接去到页面的，直接显示页面，没有经过springmvc的控制器
                response.sendRedirect("index");
            } else {
//                mv.addObject("message", "username or password is wrong");
//                mv.setViewName("login");
                response.sendRedirect("login");
            }
//            return mv;
        } else if (role.equals("manager")) {
            //获取session;
            HttpSession session = request.getSession(true);
            ManagerRole mr = (ManagerRole) userRoleService.find("from ManagerRole where account=? ", account).get(0);
            if (mr != null && mr.getPassword().equals(encoderByMd5(password))) {
                //把这些东西都加到session中去;
                //在session的数据， 在界面中也可以直接通过${}获取到;
                session.setAttribute("account", account);
                 response.sendRedirect("indexBackground");
//                 return mv;
            } else {
//                mv.addObject("message", "username or password is wrong");
//                mv.setViewName("login");
                response.sendRedirect("login");
            }
//            return mv;
        }
//        return mv;
    }

    @RequestMapping(value = "/register")
    public void register(@ModelAttribute UserRole user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//       String account = "aurora";
//       String p="pulifang";
        ManagerRole m = new ManagerRole();
        ServiceRole s = new ServiceRole();
        String[] accounts = {"pupu", "dorothy", "amy", "andy", "emily"};
        String[] passwords = {"pupu", "dorothy", "amy", "andy", "emily"};

        for (int i = 0; i < accounts.length; i++) {
            String password = encoderByMd5(passwords[i]);
            s.setAccount(accounts[i]);
            s.setPassword(password);
            serviceRoleService.save(s);
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("logoutlogoutlogoutlogoutlogoutlogout");
        HttpSession session = request.getSession(true);
        session.removeAttribute("account");
        response.sendRedirect("login");
    }

    public String encoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

//    /**
//     * 实际的登录代码 如果登录成功，跳转至首页；登录失败，则将失败信息反馈对用户
//     *
//     * @param request
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/dologin")
//    public String doLogin(HttpServletRequest request, Model model) {
//        String msg = "";
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        System.out.println(userName);
//        System.out.println(password);
//        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
//        token.setRememberMe(true);
//        Subject subject = SecurityUtils.getSubject();
//
//        try {
//            subject.login(token);
//            if (subject.isAuthenticated()) {
//                return "redirect:/";
//            } else {
//                return "login";
//            }
//        } catch (IncorrectCredentialsException e) {
//            msg = "登录密码错误.  Password  for  account  " + token.getPrincipal() + "  was  incorrect.";
//            model.addAttribute("message", msg);
//            System.out.println(msg);
//        } catch (ExcessiveAttemptsException e) {
//            msg = "登录失败次数过多";
//            model.addAttribute("message", msg);
//            System.out.println(msg);
//        } catch (LockedAccountException e) {
//            msg = "帐号已被锁定.  The  account  for  username  " + token.getPrincipal() + "  was  locked.";
//            model.addAttribute("message", msg);
//            System.out.println(msg);
//        } catch (DisabledAccountException e) {
//            msg = "帐号已被禁用.  The  account  for  username  " + token.getPrincipal() + "  was  disabled.";
//            model.addAttribute("message", msg);
//            System.out.println(msg);
//        } catch (ExpiredCredentialsException e) {
//            msg = "帐号已过期.  the  account  for  username  " + token.getPrincipal() + " was  expired.";
//            model.addAttribute("message", msg);
//            System.out.println(msg);
//        } catch (UnknownAccountException e) {
//            msg = "帐号不存在.  There  is  no  user  with  username  of  " + token.getPrincipal();
//            model.addAttribute("message", msg);
//            System.out.println(msg);
//        } catch (UnauthorizedException e) {
//            msg = "您没有得到相应的授权！" + e.getMessage();
//            model.addAttribute("message", msg);
//            System.out.println(msg);
//        }
//        return "login";
//    }
}
