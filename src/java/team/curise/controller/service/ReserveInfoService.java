/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.entity.service.RoomInfoService;
import team.curise.entity.service.RoomUserService;
import team.curise.entity.service.UserRoleService;
import team.curise.json.entity.ReserveInfo;
import team.curise.util.DateUtil;

/**
 *
 * @author pupu
 */
@Service
public class ReserveInfoService {

    String[] roomType = {"", "套房", "阳台房", "海景房", "内舱房"};
    
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RoomUserService roomUserService;
    @Resource
    private RoomInfoService roomInfoService;
    @Resource
    private QueryService queryService;

    public List<ReserveInfo> findAllReserveInfo(int curise_id) throws ParseException {
        List r = roomUserService.find("select user_id,room_id,time from RoomUser where pre_room_id = ? and curise_id =? and is_now=?", 0, curise_id, 1);
        List<ReserveInfo> result = getReserveInfoByRoomUser(r);
        return result;
    }

    public List<ReserveInfo> findAllReserveInfoByUName(String user_name, int curise_id) throws ParseException {
        List<ReserveInfo> result = new ArrayList<>();
        int u_id = queryService.findUserIdByUName(user_name);
        if (u_id == 0) {
            return result;
        }
        List r = roomUserService.find("select user_id,room_id,time from RoomUser where pre_room_id = ? and curise_id =? and user_id=? and is_now=?", 0, curise_id, u_id, 1);
        result = getReserveInfoByRoomUser(r);
        return result;
    }

    public List<ReserveInfo> getReserveInfoByRoomUser(List r) throws ParseException {
        List<ReserveInfo> result = new ArrayList<>();
        if (r.size() == 0) {
            return result;
        }
        for (int i = 0; i < r.size(); i++) {
            Object[] obj = (Object[]) r.get(i);
            ReserveInfo reserve = new ReserveInfo();
            int user_id = (int) obj[0];
            int room_id = (int) obj[1];
            List room = roomInfoService.find("select room_type,room_name from RoomInfo where id=?", room_id);
            Object[] roomObj = (Object[]) room.get(0);
            int room_type = (int) roomObj[0];
            String room_name = (String) roomObj[1];
            reserve.setRoom_type(roomType[room_type]);
            reserve.setRoom_name(room_name);
            List user = userRoleService.find("select user_name,real_name,ID_number from UserRole where id = ?", user_id);
            Object[] userObj = (Object[]) user.get(0);
            reserve.setUser_name((String) userObj[0]);
            reserve.setReal_name((String) userObj[1]);
            reserve.setID_number((String) userObj[2]);

            reserve.setTime(DateUtil.stringDateFormat((String) obj[2]));
            result.add(reserve);
        }
        return result;
    }
}
