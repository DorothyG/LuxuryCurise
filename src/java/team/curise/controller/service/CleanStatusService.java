/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import team.curise.entity.RoomInfo;
import team.curise.entity.service.RoomInfoService;
import team.curise.json.entity.CleanStatus;

/**
 *
 * @author pupu
 */
@Service
public class CleanStatusService {

    String[] roomType = {"", "套房", "阳台房", "海景房", "内舱房"};
    String[] cleanState = {"", "未清洁", "已清洁"};

    @Resource
    private RoomInfoService roomInfoService;
    @Resource
    private QueryService queryService;

    //最后证明不能通过把result放在参数中去修改result的值的做法，只能像现在这样返回改变引用了，不知道为什么传值改变引用不行
    public List<CleanStatus> findAllCleanStatus(int curise_id) throws IOException {
        //一开始不行，后来在这里测试，发现是roomInfoService为空，因为@Resource的运行机制，如果我只是通过new CleanStatusService的方法来实例化是不行的
        //roomInfoService并没有被实例化，所以我为这个service也@Service，并且在配置文件中修改，发现配置文件是可以由多个扫描路径的
        List r = roomInfoService.find("from RoomInfo where curise_id=?", curise_id);
//       resp.getWriter().write(r.toString());测试证明这里数据正确
        List<CleanStatus> result = getCleanStatusByRoomInfo(r);
//        resp.getWriter().write(result.toString());测试证明这里还有数据
        return result;
    }

    public List<CleanStatus> findCleanStatusByRoomName(int curise_id, String room_name)  {
        List<CleanStatus> result = new ArrayList<>();
        int room_id = queryService.findRoomIdByRName(room_name, curise_id);
        if(room_id==0){
            return result;
        }
        List r = roomInfoService.find("from RoomInfo where curise_id=? and room_name=?", curise_id, room_name);
        result = getCleanStatusByRoomInfo(r);
        return result;
    }

    public List<CleanStatus> getCleanStatusByRoomInfo(List r) {
        List<CleanStatus> result = new ArrayList<>();
//        resp.getWriter().write(r);
        List<RoomInfo> list = (List<RoomInfo>) r;
        System.out.println(list.size());
        if (r.size() == 0) {
            return result;
        }
        for (RoomInfo ri : list) {
            CleanStatus c = new CleanStatus();
            c.setRoom_type(roomType[ri.getRoom_type()]);
            c.setRoom_name(ri.getRoom_name());
            c.setClean_state(cleanState[ri.getClean_state()]);
            result.add(c);
        }
        return result;
    }
}
