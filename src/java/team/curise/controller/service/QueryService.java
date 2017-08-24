/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.entity.RoomInfo;
import team.curise.entity.UserRole;
import team.curise.entity.service.CuriseInfoService;
import team.curise.entity.service.RoomInfoService;
import team.curise.entity.service.UserRoleService;

/**
 *
 * @author pupu
 */
@Service
public class QueryService {

    //@Resource不可以注解在static变量上面
    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RoomInfoService roomInfoService;

    @Resource
    private CuriseInfoService curiseInfoService;

    public int findUserIdByUName(String u_name) {
        List r4 = userRoleService.find("from UserRole where user_name = ? ", u_name);
        if (r4.size() == 0) {
            r4 = userRoleService.find("from UserRole where real_name = ? ", u_name);
        }
        if (r4.size() == 0) {
            return 0;
        }
        List<UserRole> l = (List<UserRole>) r4;
        UserRole u = l.get(0);
        int u_id = u.getId();
        return u_id;
    }

    //这里既然能返回就说明是可以强制转换到RoomInfo的。这里如果我是选择了某几列的，就会报错，可能必须和他所选的列一样的类才行吧，不能多不能少
    public int findCuriseIdByCName(String c_name) {
        int curise_id = (int) curiseInfoService.find("select id from CuriseInfo where name = ?", c_name).get(0);
        return curise_id;
    }

    public int findRoomIdByRName(String room_name, int curise_id) {
        //这里我不能选择某一列。否则就直接返回异常
        List r = roomInfoService.find("from RoomInfo where curise_id=? and room_name =?", curise_id, room_name);
        //它不仅这里错了就返回了，还检查了下面的代码
        if (r.size() == 0) {
            return 0;
        }
        List<RoomInfo> list1 = (List<RoomInfo>) r;
        RoomInfo ri = list1.get(0);
        int room_id = ri.getId();
        return room_id;
    }

    public int findLayerByCuriseId(int curise_id) {
        List r = roomInfoService.find("select max(layer) from RoomInfo where curise_id=? ", curise_id);
        int maxLayer = (int) r.get(0);
        return maxLayer;
    }
}
