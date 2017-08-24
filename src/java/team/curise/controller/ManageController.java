/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import team.curise.entity.*;
import team.curise.json.entity.CuriseAboard;
import team.curise.json.entity.DepositPay;
import team.curise.json.entity.*;
import team.curise.entity.service.ConsumptionService;
import team.curise.entity.service.CuriseInfoService;
import team.curise.entity.service.ObjectConsumeService;
import team.curise.entity.service.PayDepositAfter;
import team.curise.entity.service.RoomInfoService;
import team.curise.entity.service.RoomUserService;
import team.curise.entity.service.UserRoleService;
import team.curise.util.DateUtil;

/**
 *
 * @author pupu
 */
@Controller
public class ManageController {

    String[] roomType = {"", "套房", "阳台房", "海景房", "内舱房"};
    String[] cleanState = {"", "未清洁", "已清洁"};
    String[] sexType = {"", "女", "男"};
    String[] isPaid = {"未缴费", "已缴费"};
    String[] check_in_state = {"", "未入住", "待入住", "已入住"};
    //1已交2未交
    String[] isPaidDeposit = {"", "已交押金", "未交押金"};
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RoomUserService roomUserService;
    @Resource
    private RoomInfoService roomInfoService;
    @Resource
    private ObjectConsumeService objectConsumeService;
    @Resource
    private CuriseInfoService curiseInfoService;
    @Resource
    private ConsumptionService consumptionService;

    @ResponseBody
    @RequestMapping("/index/depositPay")
    public CuriseDeposit depositPay() {
        String c_name = "维多利亚1号";
        CuriseDeposit cd = new CuriseDeposit();
        int curise_id = 1;
        long a = (long) curiseInfoService.find("select count(*) from RoomInfo where curise_id =?", curise_id).get(0);
        int total_rooms = (int) a;
        cd.setCurise_name(c_name);
        cd.setTotal_rooms(total_rooms);

        List r = roomInfoService.find("select max(layer) from RoomInfo where curise_id=? ", curise_id);
        int maxLayer = (int) r.get(0);
        List<LayerDeposit> layerDeposits = new ArrayList<>();
        int paid_deposit_num = 0;//这一艘邮轮交了押金的房间数
        int unpaid_deposit_num = 0;//这一艘邮轮未交押金的房间数

        for (int i = 1; i <= maxLayer; i++) {
            LayerDeposit ld = new LayerDeposit();
            List<RoomTypeDeposit> roomTypeDeposits = new ArrayList<>();
            a = (long) curiseInfoService.find("select count(*) from RoomInfo where curise_id=? and layer=? ", curise_id, i).get(0);
            int l_total_rooms = (int) a;
            ld.setTotal_rooms(l_total_rooms);
            ld.setLayer(i);
            int l_paid_deposit_num = 0;//这一层交了押金的房间数
            int l_unpaid_deposit_num = 0;//这一层未交押金的房间数
            //这艘邮轮这一层的所有被预定了的房间及其押金状态
            //这一层的所有已经被预定的房间
            List r1 = roomInfoService.find("from RoomInfo where layer=? and check_in_state != ? and curise_id=?", i, 1, 1);
            List<RoomInfo> list = (List<RoomInfo>) r1;
            for (RoomInfo rrr : list) {
                System.out.println(rrr.getRoom_name() + "..");
                RoomTypeDeposit rtd = new RoomTypeDeposit();
                rtd.setRoom_name(rrr.getRoom_name());
                rtd.setRoom_type(roomType[rrr.getRoom_type()]);
                int is_paid_deposit = (int) roomInfoService.find("select deposit_state from RoomUser where room_id=?", rrr.getId()).get(0);
                if (is_paid_deposit == 1) {
                    l_paid_deposit_num++;
                } else {
                    l_unpaid_deposit_num++;
                }
                int id = rrr.getId();
                rtd.setIs_paid_deposit(isPaidDeposit[is_paid_deposit]);
                roomTypeDeposits.add(rtd);
            }

            ld.setPaid_deposit_num(l_paid_deposit_num);
            ld.setUnpaid_deposit_num(l_unpaid_deposit_num);

            paid_deposit_num += l_paid_deposit_num;
            unpaid_deposit_num += l_unpaid_deposit_num;

            ld.setRoomTypeDeposits(roomTypeDeposits);
            layerDeposits.add(ld);
        }
        cd.setPaid_deposit_num(paid_deposit_num);
        cd.setUnpaid_deposit_num(unpaid_deposit_num);
        cd.setLayerDeposits(layerDeposits);

        return cd;
    }

    @ResponseBody
    @RequestMapping("/index/payment")
    public CurisePayment payment() {
        String c_name = "维多利亚1号";
        CurisePayment cp = new CurisePayment();
        int curise_id = (int) curiseInfoService.find("select id from CuriseInfo where name = ?", c_name).get(0);
        long a = (long) curiseInfoService.find("select count(*) from RoomInfo where curise_id =?", curise_id).get(0);
        int total_rooms = (int) a;
        cp.setCurise_name(c_name);
        cp.setTotal_rooms(total_rooms);

        List r = roomInfoService.find("select max(layer) from RoomInfo where curise_id=? ", curise_id);
        int maxLayer = (int) r.get(0);
        List<LayerPayment> layerPayments = new ArrayList<>();
        int paid = 0;//这一艘邮轮未缴费的房间数
        int unpaid = 0;//这一艘邮轮已缴费的房间数
        for (int i = 1; i <= maxLayer; i++) {
            LayerPayment lp = new LayerPayment();
            a = (long) curiseInfoService.find("select count(*) from RoomInfo where curise_id=? and layer=? ", curise_id, i).get(0);
            int l_total_rooms = (int) a;
            int l_paid = 0;//这一层未缴费的房间数
            int l_unpaid = 0;//这一层已缴费的房间数
            lp.setLayer(i);
            lp.setTotal_rooms(l_total_rooms);
            List<RoomTypePayment> roomTypePayments = new ArrayList<>();

            //对于已缴费和未缴费来说，都是针对已经预定的人的，RoomUser表中存放的就是已经预定的
            //找出所有这一艘邮轮的这一层的房间，及房间住的人
            List r1 = roomUserService.find("select room_id,user_id from RoomUser where room_id in(select id from RoomInfo where layer = ? and curise_id=?)", i, curise_id);
            for (int j = 0; j < r1.size(); j++) {
                Object[] obj = (Object[]) r1.get(j);
                int room_id = (int) obj[0];
                int user_id = (int) obj[1];
                RoomTypePayment rtp = new RoomTypePayment();
                
                //因为我们这里是统一缴费的，所以只要查询这个用户的一条消费记录看是否缴清即可，如果不是统一缴费，就要看这个用户所有的消费记录是否都已经缴清
                //这里要考虑到有些用户是没有消费的，所以不能直接取里面的字段
                List rrr = consumptionService.find("from Consumption where user_id = ?", user_id);
                if(rrr.size()==0){
                    continue;
                }
                Consumption c = (Consumption)rrr.get(0);
                int is_paid =c.getIs_paid();
                if (is_paid == 0) {
                    l_unpaid++;
                } else {
                    l_paid++;
                }
                rtp.setIsPaid(isPaid[is_paid]);
                List r2 = roomInfoService.find("select room_name,room_type from RoomInfo where id=?", room_id);
                Object[] obj2 = (Object[]) r2.get(0);
                String room_name = (String) obj2[0];
                int room_type = (int) obj2[1];
                rtp.setRoom_name(room_name);
                rtp.setRoom_type(roomType[room_type]);
                roomTypePayments.add(rtp);
            }
            lp.setPaid(l_paid);
            lp.setUnpaid(l_unpaid);
            lp.setRoomTypePayments(roomTypePayments);

            paid += l_paid;
            unpaid += l_unpaid;

            layerPayments.add(lp);
        }
        cp.setPaid(paid);
        cp.setUnpaid(unpaid);
        cp.setLayerPayments(layerPayments);
        return cp;
    }

    // 这里的预定是在柜台的预定。就要插入这样一个用户，不然的话是在手机端进行预定
    //这样的预定会让用户表多出一个用户，roomuser多出一个记录，roominfo的入住状态也改变
    //押金是船票金额加上百分之十的船票金额
    @RequestMapping(value = "/index/manageReserveInfo/reserve", method = RequestMethod.POST)
    public void reserve(UserRole user, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int curise_id = 1;
        String real_name = user.getReal_name();
        String room_name = req.getParameter("room_name");
        String time = req.getParameter("time");

        user.setCredit("A");
        userRoleService.save(user);
        int user_id = (int) userRoleService.find("select id from UserRole where real_name = ? ", real_name).get(0);

        System.out.println("room_name:" + room_name);
        RoomInfo rii = (RoomInfo) roomInfoService.find("from RoomInfo where room_name=? and curise_id=?", room_name, 1).get(0);
        int room_id = rii.getId();
        double price = rii.getPrice();
//        List r = roomInfoService.find("select id ,price from RoomInfo where room_name=? and curise_id=?", room_name, 1);
//        Object[] obj = (Object[]) r.get(0);
//        int room_id = (int) obj[0];
//        double price = (double) obj[1];
        RoomUser ru = new RoomUser();
        ru.setCurise_id(curise_id);
        ru.setDeposit_amount(price + 0.1 * price);
        ru.setDeposit_state(room_id);
        //deposit 1已交 2未交
        ru.setDeposit_state(2);
        ru.setPre_room_id(0);
        ru.setRoom_id(room_id);
        ru.setTime(time);
        ru.setUser_id(user_id);
        ru.setIs_now(1);
        System.out.println("....................$$$$$$$$$$$");

        System.out.println(".....................");
        roomUserService.save(ru);
        System.out.println("....................$$$$$$$$$$$");
        //check_in_state 1未入住 2带入住 3已入住
        RoomInfo ri = (RoomInfo) roomInfoService.find("from RoomInfo where id=?", room_id).get(0);
        ri.setCheck_in_state(2);
        roomInfoService.update(ri);
        resp.getWriter().write("success");
    }

    //消费结账时候根据姓名传回消费明细,计算出消费明细，这里不用判断是否交过费，因为这个房间是否缴费在之前已经判断过
    //能选择到这个房间，就说明这个房间的用户还未缴费
    @ResponseBody
    @RequestMapping(value = "/index/managePaymentInfo/payment", method = RequestMethod.GET)
    public PaymentGetInfo paymentGetInfo(HttpServletRequest req) throws ParseException {
        System.out.println("paypaupppppppppp");
        String room_name = req.getParameter("room_name");
//      String room_name = "201";
        int paid_deposit = 0;

        int room_id = (int) roomInfoService.find("select id from RoomInfo where room_name=? and curise_id=?", room_name, 1).get(0);
        RoomUser ru = (RoomUser) roomUserService.find("from RoomUser where room_id=? and is_now=?", room_id, 1).get(0);
        int user_id = ru.getUser_id();
        String real_name = (String) roomInfoService.find("select real_name from UserRole where id=?", user_id).get(0);
        int should_pay = 0;
        List<RoomUser> oldRoomUser = (List<RoomUser>) roomUserService.find("from RoomUser where user_id=? and is_now!=?", user_id, 1);
        for (RoomUser r : oldRoomUser) {
            paid_deposit += r.getDeposit_amount();
        }

        RoomUser nowRoomUser = (RoomUser) roomUserService.find("from RoomUser where user_id=? and room_id=? and is_now=?", user_id, room_id, 1).get(0);
        if (nowRoomUser.getDeposit_state() == 1) {
            paid_deposit += nowRoomUser.getDeposit_amount();
        }

        PaymentGetInfo pgi = new PaymentGetInfo();
        pgi.setPaid_deposit(paid_deposit);
        pgi.setShould_pay(6);
        List<UserConsumption> userConsumptions = new ArrayList<>();
        List r1 = consumptionService.find("from Consumption where user_id =?", 6);
        List<Consumption> list = (List<Consumption>) r1;
        for (Consumption c : list) {
            UserConsumption uc = new UserConsumption();
            uc.setAmount(c.getAmount());
            should_pay += c.getAmount();
            uc.setConsume_type(c.getConsume_type());
            uc.setPlace(c.getPlace());
            uc.setTime(DateUtil.stringDateFormat(c.getTime()));
            userConsumptions.add(uc);
        }
        should_pay -= paid_deposit;
        pgi.setUserConsumptions(userConsumptions);
        pgi.setShould_pay(should_pay);
        int real_pay = should_pay - paid_deposit;
        pgi.setReal_pay(real_pay);
        pgi.setReal_name(real_name);
        return pgi;
    }

    //选择确定缴费之后就会到这里，这样需要变化consumption里的每条消费记录的消费状态，都变成已缴费
    @RequestMapping(value = "/index/managePaymentInfo/pay", method = RequestMethod.POST)
    public void payment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String real_name = req.getParameter("real_name");
        System.out.println("real_name" + real_name);
        UserRole u = (UserRole) userRoleService.find("from UserRole where real_name=?", real_name).get(0);
        int user_id = u.getId();
        List r = consumptionService.find("from Consumption where user_id=?", user_id);
        List<Consumption> list = (List<Consumption>) r;
        for (Consumption c : list) {
            c.setIs_paid(1);
            consumptionService.update(c);
        }
        resp.getWriter().write("success");
    }

    //补交押金,通过名字返回这个人需要交的押金金额,不叫押金不能换舱
    @ResponseBody
    @RequestMapping(value = "/index/managePaymentInfo/deposit", method = RequestMethod.GET)
    public PayDepositAfter depositGetInfo(HttpServletRequest req) {
        String room_name = req.getParameter("room_name");
        //String room_name = "106";
        int room_id = (int) roomInfoService.find("select id from RoomInfo where room_name=? and curise_id=?", room_name, 1).get(0);
        System.out.println(room_id);
        int user_id = (int) userRoleService.find("select user_id from RoomUser where room_id=? and curise_id=? and is_now=?", room_id, 1, 1).get(0);
        System.out.println("userID" + user_id);
        String real_name = (String) userRoleService.find("select real_name from UserRole where id=?", user_id).get(0);
        System.out.println(real_name);
        double deposit_amount = (double) roomUserService.find("select deposit_amount from RoomUser where user_id=? and room_id=? and is_now=? ", user_id, room_id, 1).get(0);
        System.out.println(deposit_amount);
        PayDepositAfter p = new PayDepositAfter();
        p.setReal_name(real_name);
        p.setDeposit_amount(deposit_amount);
        return p;
    }

    //补交押金确定后回到这里,补交后就在roomuser中增加一条记录，应该是增加不是修改吧，但是如果是增加就又会引发一些问题了，注意
    @RequestMapping(value = "/index/managePaymentInfo/deposit", method = RequestMethod.POST)
    public void depositPay(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String room_name = req.getParameter("room_name");
        int room_id = (int) roomInfoService.find("select id from RoomInfo where room_name=? and curise_id=?", room_name, 1).get(0);
        //int room_id = (int)roomInfoService.find("select id from RoomInfo where room_name=?",room_name).get(0);

        String real_name = req.getParameter("real_name");
        int user_id = (int) userRoleService.find("select id from UserRole where real_name=?", real_name).get(0);
        RoomUser ru = (RoomUser) roomUserService.find("from RoomUser where user_id=? and room_id=? and is_now=?", user_id, room_id, 1).get(0);
        ru.setDeposit_state(1);
        roomUserService.update(ru);
        //ajax 请求一定要返回一个response才能确定，模态框才能消失
        resp.getWriter().write("success");
    }

    //登船登记，就是在room_info里面把check_in_state的状态改了
    @RequestMapping(value = "/index/manageReserveInfo/curiseAboard", method = RequestMethod.POST)
    public void curiseAboard(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        req.setCharacterEncoding("utf-8");
        String room_name = req.getParameter("room_name");
        String real_name = req.getParameter("real_name");
        String ID_number = req.getParameter("ID_number");

        String s = req.getParameter("sex");//////
        int sex = Integer.parseInt(s);
        String phone_number = req.getParameter("phone_number");
        System.out.println("real_name:" + real_name + ",ID_number:" + ID_number + ",sex:" + sex + ",phone_number:" + phone_number);
        UserRole u = (UserRole) userRoleService.find("from UserRole where ID_number = ?", ID_number).get(0);
        System.out.println(".......real_name:" + u.getReal_name() + ",ID_number:" + u.getID_number() + ",sex:" + u.getSex() + ",phone_number:" + u.getPhone_number());
        if (real_name.equals(u.getReal_name()) && sex == u.getSex() && phone_number.equals(u.getPhone_number())) {
            resp.getWriter().write("success");
            RoomInfo roomInfo = (RoomInfo) roomInfoService.find("from RoomInfo where room_name=?", room_name).get(0);
            roomInfo.setCheck_in_state(3);
            roomInfoService.update(roomInfo);
        } else {
            resp.getWriter().write("false");
        }
    }

    //舱房更换时候通过realname得到一些原舱房信息和现舱房信息
    @ResponseBody
    @RequestMapping(value = "/index/manageReserveInfo/change")
    public ChangeGetInfo changeGetInfo(HttpServletRequest req) {
        String r_name = req.getParameter("real_name");
        String now_room_name = req.getParameter("now_room_name");
//        now_room_name="106";
//        r_name= "张毅";
        double now_room_price = (double) roomInfoService.find("select price from RoomInfo where room_name=? and curise_id=?", now_room_name, 1).get(0);
        double now_deposit_amount = now_room_price * 1.1;

        DecimalFormat df = new DecimalFormat("0.00");
        now_deposit_amount = Double.parseDouble(df.format(now_deposit_amount));
        int user_id = (int) userRoleService.find("select id from UserRole where real_name=?", r_name).get(0);
        int old_room_id = (int) roomUserService.find("select room_id from RoomUser where user_id=? and is_now=?", user_id, 1).get(0);
        RoomInfo oldRoomInfo = (RoomInfo) roomInfoService.find("from RoomInfo where id=? and curise_id=?", old_room_id, 1).get(0);
        double old_deposit_amount = oldRoomInfo.getPrice() * 1.1;
        ChangeGetInfo cgi = new ChangeGetInfo();
        cgi.setNow_deposit_amount(now_deposit_amount);
        cgi.setOld_deposit_amount(old_deposit_amount);
        cgi.setOld_room_name(oldRoomInfo.getRoom_name());
        cgi.setOld_room_type(roomType[oldRoomInfo.getRoom_type()]);
        cgi.setNow_room_name(now_room_name);
        return cgi;
    }

    //舱房更换模态框的提交
    //舱房更换会在roomuser里面产生一条记录，roominfo的入住状态也会改变,原舱房和现舱房的入住状态都要改变
    @RequestMapping(value = "/index/manageReserveInfo/change", method = RequestMethod.POST)
    public void change(ChangeGetInfoStr cgi, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        System.out.println(cgi.getNow_deposit_amount());
        System.out.println(cgi.getNow_room_name());
        System.out.println(cgi.getOld_deposit_amount());
        System.out.println(cgi.getOld_room_name());
        System.out.println(cgi.getOld_room_type());
        System.out.println(req.getParameter("real_name"));
        System.out.println("///////////");
        RoomUser ru = new RoomUser();
        
        ru.setDeposit_amount( Double.parseDouble(cgi.getNow_deposit_amount()));
        ru.setDeposit_state(1);
        int old_room_id = (int) roomInfoService.find("select id from RoomInfo where room_name=?", cgi.getOld_room_name()).get(0);
        int now_room_id = (int) roomInfoService.find("select id from RoomInfo where room_name=?", cgi.getNow_room_name()).get(0);
        int user_id = (int) userRoleService.find("select id from UserRole where real_name=?", req.getParameter("real_name")).get(0);
        ru.setPre_room_id(old_room_id);
        ru.setRoom_id(old_room_id);
        ru.setRoom_id(now_room_id);
        ru.setTime(req.getParameter("time"));
        ru.setUser_id(user_id);
        roomUserService.save(ru);

        RoomInfo old_room = (RoomInfo) roomInfoService.find("from RoomInfo where id=?", old_room_id).get(0);
        RoomInfo now_room = (RoomInfo) roomInfoService.find("from RoomInfo where id=?", now_room_id).get(0);
        old_room.setCheck_in_state(1);
        now_room.setCheck_in_state(3);
        roomInfoService.update(old_room);
        roomInfoService.update(now_room);
        resp.getWriter().write("success");
    }

    //有很多个页面都可以到这，因为都是预定情况
    @ResponseBody
    @RequestMapping(value = "/index/curiseAboard", method = RequestMethod.GET)
    public CuriseAboard manageReserveInfo() {
        String c_name = "维多利亚1号";
        CuriseAboard ca = new CuriseAboard();
        int curise_id = (int) curiseInfoService.find("select id from CuriseInfo where name = ?", c_name).get(0);
        long a = (long) roomInfoService.find("select count(*) from RoomInfo where curise_id =?", curise_id).get(0);
        int total_rooms = (int) a;
        //1未入住2待入住3已入住
        a = (long) roomInfoService.find("select count(*) from RoomInfo where check_in_state =? and curise_id=? ", 1, curise_id).get(0);
        int remainder = (int) a;
        a = (long) roomInfoService.find("select count(*) from RoomInfo where check_in_state =? and curise_id=? ", 2, curise_id).get(0);
        int reserved = total_rooms - remainder;
        a = (long) roomInfoService.find("select count(*) from RoomInfo where check_in_state =? and curise_id=? ", 3, curise_id).get(0);
        int checked_in = (int) a;

        ca.setChecked_in(checked_in);
        ca.setCurise_name(c_name);
        ca.setRemainder(remainder);
        ca.setReserved(reserved);
        ca.setTotal_rooms(total_rooms);

        List r = roomInfoService.find("select max(layer) from RoomInfo where curise_id=? ", curise_id);
        int maxLayer = (int) r.get(0);
        List<LayerReserve> layerReserves = new ArrayList<>();
        for (int i = 1; i <= maxLayer; i++) {
            LayerReserve lr = new LayerReserve();
            a = (long) roomInfoService.find("select count(*) from RoomInfo where curise_id=? and layer=? ", curise_id, i).get(0);
            int l_total_rooms = (int) a;
            //1未入住2待入住3已入住
            a = (long) roomInfoService.find("select count(*) from RoomInfo where check_in_state =? and curise_id=? and layer=? ", 1, curise_id, i).get(0);
            int l_remainder = (int) a;
            int l_reserved = l_total_rooms - l_remainder;
            a = (long) roomInfoService.find("select count(*) from RoomInfo where check_in_state =? and curise_id=? and layer=? ", 3, curise_id, i).get(0);
            int l_checked_in = (int) a;

            lr.setChecked_in(l_checked_in);
            lr.setLayer(i);
            lr.setRemainder(l_remainder);
            lr.setReserved(l_reserved);
            lr.setTotal_rooms(l_total_rooms);

            List<RoomTypeLayerReserve> rtlrs = new ArrayList<>();

            List r1 = roomInfoService.find("select room_name ,room_type,check_in_state from RoomInfo where curise_id=? and layer=?", curise_id, i);
            for (int j = 0; j < r1.size(); j++) {
                Object[] obj = (Object[]) r1.get(j);
                RoomTypeLayerReserve rtlr = new RoomTypeLayerReserve();
                rtlr.setRoom_name((String) obj[0]);
                rtlr.setRoom_type(roomType[(int) obj[1]]);
                rtlr.setCheck_in_state(check_in_state[(int) obj[2]]);
                rtlrs.add(rtlr);
            }

            lr.setRoomTypeLayerReserves(rtlrs);
            layerReserves.add(lr);
        }
        ca.setLayerReserves(layerReserves);
        return ca;
    }

}
