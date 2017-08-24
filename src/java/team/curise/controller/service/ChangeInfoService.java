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
import team.curise.entity.RoomUser;
import team.curise.entity.service.RoomUserService;
import team.curise.entity.service.UserRoleService;
import team.curise.json.entity.ChangeInfo;

/**
 *
 * @author pupu
 */
@Service
public class ChangeInfoService {

    String[] roomType = {"", "套房", "阳台房", "海景房", "内舱房"};
    
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RoomUserService roomUserService;
    @Resource
    private QueryService queryService;
    

    public List<ChangeInfo> findAllCI(int curise_id) {
        List r = roomUserService.find("from RoomUser where pre_room_id!=? and curise_id = ?", 0, curise_id);
        List<ChangeInfo> result = getChangeInfoByRoomUser(r);
        return result;
    }

    public List<ChangeInfo> findCIByUName(String user_name, int curise_id) {
        List<ChangeInfo> result = new ArrayList<>();
        int u_id = queryService.findUserIdByUName(user_name);
        if (u_id == 0) {
            return result;
        }
        List r = roomUserService.find("from RoomUser where pre_room_id!=? and curise_id = ? and user_id=?", 0, curise_id, u_id);
        result = getChangeInfoByRoomUser(r);
        return result;
    }

    public List<ChangeInfo> getChangeInfoByRoomUser(List r) {
        List<ChangeInfo> result = new ArrayList<>();
        List<RoomUser> list = (List<RoomUser>) r;
        if (r.size() == 0) {
            return result;
        }
        for (RoomUser ru : list) {
            ChangeInfo c = new ChangeInfo();
            c.setNew_room_deposit(ru.getDeposit_amount());
            int new_room_id = ru.getRoom_id();
            int user_id = ru.getUser_id();
            //这个应该是在换舱的时候就确定的，只能在一艘邮轮换舱，所以不用再判断是否是一艘油轮
            int old_room_id = ru.getPre_room_id();
            List r1 = roomUserService.find("select room_name,room_type from RoomInfo where id=? ", new_room_id);
            Object[] obj = (Object[]) r1.get(0);
            c.setNew_room_name((String) obj[0]);
            c.setNew_room_type(roomType[(int) obj[1]]);
            List r2 = roomUserService.find("select room_name,room_type from RoomInfo where id=?", old_room_id);
            Object[] obj2 = (Object[]) r2.get(0);
            c.setOld_room_name((String) obj2[0]);
            c.setOld_room_type(roomType[(int) obj2[1]]);
            double old_room_deposit = (double) roomUserService.find("select deposit_amount from RoomUser where room_id=?", old_room_id).get(0);
            c.setOld_room_deposit(old_room_deposit);

            List r3 = userRoleService.find("select real_name,user_name from UserRole where id = ?", user_id);
            Object[] obj3 = (Object[]) r3.get(0);
            c.setReal_name((String) obj3[0]);
            c.setUser_name((String) obj3[1]);
            result.add(c);
        }
        return result;
    }
}
