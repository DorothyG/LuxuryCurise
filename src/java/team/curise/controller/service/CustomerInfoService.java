/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.entity.UserRole;
import team.curise.entity.service.RoomInfoService;
import team.curise.entity.service.RoomUserService;
import team.curise.entity.service.UserRoleService;
import team.curise.json.entity.CustomerInfo;

/**
 *
 * @author pupu
 */
@Service
public class CustomerInfoService {
    
    String[] sexType = {"", "女", "男"};
    
    @Resource
    private RoomUserService roomUserService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RoomInfoService roomInfoService;
    @Resource
    private QueryService queryService;
    
    public List<CustomerInfo> findAllCustomerInfo(int curise_id) {
        List r = roomUserService.find("select user_id,room_id from RoomUser where curise_id=? and is_now=?", curise_id, 1);
         List<CustomerInfo> result = getCustomerInfoByRoomUser(r);
         return result;
    }

    public List<CustomerInfo> findCustomerInfoByUName(String user_name, int curise_id) {
        List<CustomerInfo> result  = new ArrayList<>();
        int u_id = queryService.findUserIdByUName(user_name);
        if(u_id==0){
            return result;
        }
        List r = roomUserService.find("select user_id,room_id from RoomUser where curise_id=? and user_id=? and is_now=?", curise_id, u_id, 1);
        result = getCustomerInfoByRoomUser(r);
        return result;
    }

    public List<CustomerInfo> getCustomerInfoByRoomUser(List r) {
        List<CustomerInfo> result = new ArrayList<>();
        if (r.size() == 0) {
            return result;
        }
        for (int i = 0; i < r.size(); i++) {
            Object[] obj = (Object[]) r.get(i);
            CustomerInfo ci = new CustomerInfo();
            int user_id = (int) obj[0];
            int room_id = (int) obj[1];
            UserRole r2 = (UserRole) userRoleService.find("from UserRole where id=?", user_id).get(0);
            UserRole u = (UserRole) r2;
            ci.setAge(u.getAge());
            ci.setID_number(u.getID_number());
            ci.setOccupation(u.getOccupation());
            ci.setPhone_number(u.getPhone_number());
            ci.setPoint(u.getPoint());
            ci.setReal_name(u.getReal_name());
            ci.setUser_name(u.getUser_name());
            ci.setSex(sexType[u.getSex()]);
            String room_name = (String) roomInfoService.find("select room_name from RoomInfo where id=?", room_id).get(0);
            ci.setRoom_name(room_name);
            result.add(ci);
        }
        return result;
    }
}
