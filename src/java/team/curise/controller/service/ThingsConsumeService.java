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
import team.curise.entity.ObjectsConsume;
import team.curise.entity.service.ObjectConsumeService;
import team.curise.json.entity.ThingsConsume;
import team.curise.util.DateUtil;

/**
 *
 * @author pupu
 */
@Service
public class ThingsConsumeService {

    String[] roomType = {"", "套房", "阳台房", "海景房", "内舱房"};

    @Resource
    private ObjectConsumeService objectConsumeService;
    @Resource
    private QueryService queryService;

    public List<ThingsConsume> findAllThingsConsume(int curise_id) {
        List r = objectConsumeService.find("from ObjectsConsume where curise_id = ?", curise_id);
        List<ThingsConsume> result = getTCFromObjectsConsume(r);
        return result;
    }

    public List<ThingsConsume> findTCByRoomName(int curise_id, String room_name) {
        List<ThingsConsume> result = new ArrayList<>();
        int room_id = queryService.findRoomIdByRName(room_name, curise_id);
        if (room_id == 0) {
            return result;
        }
        List r = objectConsumeService.find("from ObjectsConsume where curise_id = ? and room_id=?", curise_id, room_id);
        result = getTCFromObjectsConsume(r);
        return result;
    }

    public List<ThingsConsume> getTCFromObjectsConsume(List r) {
        List<ThingsConsume> result = new ArrayList<>();
        List<ObjectsConsume> list = (List<ObjectsConsume>) r;
        if (r.size() == 0) {
            return result;
        }
        for (ObjectsConsume t : list) {
            ThingsConsume ts = new ThingsConsume();
            int room_id = t.getRoom_id();
            int room_type = (int) objectConsumeService.find("select room_type from RoomInfo where id = ?", room_id).get(0);
            String room_name = (String) objectConsumeService.find("select room_name from RoomInfo where id = ?", room_id).get(0);
            ts.setRoom_type(roomType[room_type]);
            ts.setRoom_name(room_name);
            ts.setComb(t.getComb());
            ts.setLotion(t.getLotion());
            ts.setShamppo(t.getShamppo());
            ts.setSlippers(t.getSlippers());
            ts.setSoap(t.getSoap());
            ts.setToothbrush(t.getToothbrush());
            ts.setToothpaste(t.getToothpaste());
            ts.setTowel(t.getTowel());
            ts.setDate(DateUtil.dateFormat(t.getDate()));
            result.add(ts);
        }

        return result;
    }
}
