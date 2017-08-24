/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller.mana.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.entity.service.UserRoleService;

/**
 *
 * @author pupu
 */
@Service
public class ManaBaseService {

    @Resource
    private UserRoleService userRoleService;

    public List<Integer> getAllUserIdByCuriseId(int curise_id) {
        List<Integer> list = new ArrayList<>();
        List r = userRoleService.find("select user_id from RoomUser where curise_id=?", curise_id);
        for (int i = 0; i < r.size(); i++) {
            int user_id = (int) r.get(i);
            System.out.print("user_id:"+user_id+",");
            if(list.contains(user_id)){
                continue;
            }
            list.add(user_id);
        }
        
        return list;
    }
}
