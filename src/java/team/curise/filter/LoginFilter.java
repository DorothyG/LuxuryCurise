/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;
import team.curise.entity.CuriseInfo;
import team.curise.entity.service.CuriseInfoService;

/**
 *
 * @author pupu
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String reqUri = request.getRequestURI();
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        if (reqUri.contains("ogin")) {
            System.out.println(reqUri + "...............");
        }
        ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
        CuriseInfoService c = (CuriseInfoService) ac.getBean("curiseInfoService");
        String url = request.getContextPath();

        //如果是去登录页的，为了跟manageLogin区分开来，因为也要放行manageLogin的请求
        if (reqUri.contains("login")) {
            List r = c.find("from CuriseInfo");
            List<CuriseInfo> list = (List<CuriseInfo>) r;
            List<String> curiseNames = new ArrayList<>();
            for (CuriseInfo ci : list) {
                curiseNames.add(ci.getName());
            }
            session.setAttribute("curiseNames", curiseNames);
            fc.doFilter(req, resp);
        }

        if (reqUri.contains("ogin") || reqUri.contains("js") || reqUri.contains("css") || reqUri.contains("icon") || reqUri.contains("font") || reqUri.contains("icon")) {
            fc.doFilter(req, resp);
            return;
        }

        if (account == null || "".equals(account)) {
            List r = c.find("from CuriseInfo");
            List<CuriseInfo> list = (List<CuriseInfo>) r;
            List<String> curiseNames = new ArrayList<>();
            for (CuriseInfo ci : list) {
                curiseNames.add(ci.getName());
            }
            session.setAttribute("curiseNames", curiseNames);
            response.sendRedirect("login");
        } else {
            fc.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
    }

}
