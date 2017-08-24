/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller.mana.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.controller.service.QueryService;
import team.curise.entity.ObjectsTotalConsume;
import team.curise.entity.service.CuriseInfoService;
import team.curise.entity.service.RoomInfoService;
import team.curise.json.entity.management.*;
import team.curise.util.MapUtil;
import team.curise.entity.*;
/**
 *
 * @author pupu
 */
@Service
public class RoomManaService {
//1未入住 2带入住 3已入住

    @Resource
    private RoomInfoService roomInfoService;
    @Resource
    private CuriseInfoService curiseInfoService;
    @Resource
    private QueryService queryService;
    @Resource
    private ManaBaseService manaBaseService;

    private Map<String, Integer> occupNumMap = new TreeMap<>();

    //总表
    //得到每一层的每一种舱房类型的入住情况
    public TotalLayerCheckin getRTypeCheckinStateByLayer(int curise_id) {
        double roomType1AllRooms = 0;
        double roomType2AllRooms = 0;
        double roomType3AllRooms = 0;
        double roomType4AllRooms = 0;
        double roomType1NotCheckin = 0;
        double roomType2NotCheckin = 0;
        double roomType3NotCheckin = 0;
        double roomType4NotCheckin = 0;
        TotalLayerCheckin totalLayerCheckin = new TotalLayerCheckin();
        List<LayerCheckin> layerCheckinList = new ArrayList<>();
        int layers = queryService.findLayerByCuriseId(curise_id);
        for (int layer = 1; layer <= layers; layer++) {
            LayerCheckin layerCheckin = new LayerCheckin();
            List<CheckinState> roomTypeCheckinList = new ArrayList<>();
            for (int i = 1; i <= 4; i++) {
                CheckinState roomTypeLayerCheckin = new CheckinState();
                long already_checkin = (long) roomInfoService.find("select count(*) from RoomInfo where curise_id=? and room_type=? and layer=? and check_in_state=?", curise_id, i, layer, 3).get(0);
                long wait_checkin = (long) roomInfoService.find("select count(*) from RoomInfo where curise_id=? and room_type=? and layer=? and check_in_state=?", curise_id, i, layer, 2).get(0);
                long havenot_checkin = (long) roomInfoService.find("select count(*) from RoomInfo where curise_id=? and room_type=? and layer=? and check_in_state=?", curise_id, i, layer, 1).get(0);
                if (i == 1) {
                    roomType1NotCheckin += havenot_checkin;
                    roomType1AllRooms += already_checkin + wait_checkin + havenot_checkin;
                } else if (i == 2) {
                    roomType2NotCheckin += havenot_checkin;
                    roomType2AllRooms += already_checkin + wait_checkin + havenot_checkin;
                } else if (i == 3) {
                    roomType3NotCheckin += havenot_checkin;
                    roomType3AllRooms += already_checkin + wait_checkin + havenot_checkin;
                } else {
                    roomType4NotCheckin += havenot_checkin;
                    roomType4AllRooms += already_checkin + wait_checkin + havenot_checkin;
                }
                roomTypeLayerCheckin.setAlready_checkin((int) already_checkin);
                roomTypeLayerCheckin.setHavenot_checkin((int) havenot_checkin);
                roomTypeLayerCheckin.setWait_checkin((int) wait_checkin);
                roomTypeCheckinList.add(roomTypeLayerCheckin);
            }
            layerCheckin.setLayer(layer);
            layerCheckin.setRoomTypeCheckinList(roomTypeCheckinList);
            layerCheckinList.add(layerCheckin);
        }
        totalLayerCheckin.setLayerCheckinList(layerCheckinList);
        List<String> utilizationRate = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("0.00");
        utilizationRate.add(df.format(roomType1NotCheckin / roomType1AllRooms));
        utilizationRate.add(df.format(roomType2NotCheckin / roomType2AllRooms));
        utilizationRate.add(df.format(roomType3NotCheckin / roomType3AllRooms));
        utilizationRate.add(df.format(roomType4NotCheckin / roomType4AllRooms));
        
        totalLayerCheckin.setUtilizationRate(utilizationRate);
        return totalLayerCheckin;
    }

    //得到每一种类型的舱房的入住情况
    public List<CheckinState> getCheckinByRType(int curise_id) {
        List<CheckinState> list = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            CheckinState roomTypeLayerCheckin = new CheckinState();

            long already_checkin = (long) roomInfoService.find("select count(*) from RoomInfo where curise_id=? and room_type=? and check_in_state=?", curise_id, i, 3).get(0);
            long wait_checkin = (long) roomInfoService.find("select count(*) from RoomInfo where curise_id=? and room_type=? and check_in_state=?", curise_id, i, 2).get(0);
            long havenot_checkin = (long) roomInfoService.find("select count(*) from RoomInfo where curise_id=? and room_type=? and check_in_state=?", curise_id, i, 1).get(0);
            roomTypeLayerCheckin.setAlready_checkin((int) already_checkin);
            roomTypeLayerCheckin.setHavenot_checkin((int) havenot_checkin);
            roomTypeLayerCheckin.setWait_checkin((int) wait_checkin);
            list.add(roomTypeLayerCheckin);
        }
        return list;
    }

    //得到每一层的入住情况
    public List<CheckinState> getCheckinByLayer(int curise_id) {
        List<CheckinState> list = new ArrayList<>();
        int maxLayer = queryService.findLayerByCuriseId(curise_id);
        for (int layer = 1; layer <= maxLayer; layer++) {
            CheckinState layerCheckin = new CheckinState();
            long already_checkin = (long) roomInfoService.find("select count(*) from RoomInfo where curise_id=? and layer=? and check_in_state=?", curise_id, layer, 3).get(0);
            long wait_checkin = (long) roomInfoService.find("select count(*) from RoomInfo where curise_id=? and layer=? and check_in_state=?", curise_id, layer, 2).get(0);
            long havenot_checkin = (long) roomInfoService.find("select count(*) from RoomInfo where curise_id=? and layer=? and check_in_state=?", curise_id, layer, 1).get(0);
            layerCheckin.setAlready_checkin((int) already_checkin);
            layerCheckin.setHavenot_checkin((int) havenot_checkin);
            layerCheckin.setWait_checkin((int) wait_checkin);
            list.add(layerCheckin);
        }
        return list;
    }

    //得到一艘邮轮全部的入住情况
    public CheckinState getAllCheckin(int curise_id) {
        CheckinState curiseCheckinState = new CheckinState();
        long already_checkin = (long) roomInfoService.find("select count(*) from RoomInfo where curise_id=?  and check_in_state=?", curise_id, 3).get(0);
        long wait_checkin = (long) roomInfoService.find("select count(*) from RoomInfo where curise_id=? and check_in_state=?", curise_id, 2).get(0);
        long havenot_checkin = (long) roomInfoService.find("select count(*) from RoomInfo where curise_id=?  and check_in_state=?", curise_id, 1).get(0);
        curiseCheckinState.setAlready_checkin((int) already_checkin);
        curiseCheckinState.setHavenot_checkin((int) havenot_checkin);
        curiseCheckinState.setWait_checkin((int) wait_checkin);
        return curiseCheckinState;
    }

    //获取一艘邮轮所有的物品消耗
    public CuriseThingsConsume getAllThingsConsume(int curise_id) {
        List r = roomInfoService.find("from ObjectsTotalConsume where curise_id=? ", curise_id);
        List<ObjectsTotalConsume> list = (List<ObjectsTotalConsume>) r;
        ObjectsTotalConsume o = list.get(0);
        CuriseThingsConsume c = new CuriseThingsConsume();
        c.setComb(o.getComb());
        c.setLotion(o.getLotion());
        c.setShamppo(o.getShamppo());
        c.setSlippers(o.getSlippers());
        c.setSoap(o.getSoap());
        c.setToothbrush(o.getToothbrush());
        c.setToothpaste(o.getToothpaste());
        c.setTowel(o.getTowel());
        return c;
    }

    //获得用户各个年龄阶段的人数
    public Map<String,Integer> getNumOfDiffAge(int curise_id) {
        Map<String,Integer> map = new HashMap<>();
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        int childhood = 0;
        int early_youth = 0;
        int youth = 0;
        int midlife = 0;
        int old = 0;

        for (Integer user_id : userIds) {
            int age = (int) roomInfoService.find("select age from UserRole where id=?", user_id).get(0);
            if (age <= 6) {
                childhood++;
            } else if (age <= 17) {
                early_youth++;
            } else if (age <= 40) {
                youth++;
            } else if (age <= 65) {
                midlife++;
            } else {
                old++;
            }
        }
        map.put("童年", childhood);
        map.put("少年", early_youth);
        map.put("青年", youth);
        map.put("中年", midlife);
        map.put("老年", old);
        return map;
    }

    //获得各个职业的人数，前四个职业，剩下的都是其他
    public Map<String, Integer> getNumOfDiffOccup(int curise_id) {
        Map<String, Integer> result = new HashMap<>();
        initAllOccup(curise_id);
       ArrayList<Map.Entry<String, Integer>> entries = MapUtil.sortByValue(occupNumMap);
        for (int i = 0; i <entries.size() ; i++) {
            System.out.print(entries.get(i).getKey() + ":" + entries.get(i).getValue()+",,,");
        }
        int otherNum = 0;
        for (int i=0;i<entries.size();i++) {
            if (i < 4) {
                result.put(entries.get(i).getKey(), entries.get(i).getValue());
            } else {
                otherNum+=entries.get(i).getValue();
            }
        }
        result.put("其他职业", otherNum);
        return result;
    }

    //获得不同性别的人数
    public Map<String, Integer> getNumOfDiffSex(int curise_id) {
        //sex 1女 2男
        Map<String, Integer> map = new HashMap<>();
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        int female = 0;
        int male = 0;
        for (Integer user_id : userIds) {
            List r = roomInfoService.find("select sex from UserRole where id=?  ", user_id);
            int sex;
            if (r.size() == 1) {
                sex = (int) r.get(0);
                if (sex == 1) {
                    female++;
                } else if (sex == 2) {
                    male++;
                }
            }
        }
        map.put("男", male);
        map.put("女", female);
        return map;
    }
//初始化职业，职业人数的map
    public void initAllOccup(int curise_id) {
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        for (Integer user_id : userIds) {
//            System.out.println("user_id:"+user_id);
            List r = roomInfoService.find("select occupation from UserRole where id=?", user_id);
            if (r.size() == 1) {
                String occup = (String) r.get(0);
//                System.out.println("occup:"+occup);
                if (occupNumMap.containsKey(occup)) {
                    int num = occupNumMap.get(occup);
                    num++;
                    occupNumMap.put(occup, num);
                } else {
                    occupNumMap.put(occup, 1);
                }
            }
        }
    }
    //初始化职业
    public void initAllOccupTwo(int curise_id, List<String> occupList) {
        List<Integer> userIds = manaBaseService.getAllUserIdByCuriseId(curise_id);
        for (Integer user_id : userIds) {
//            System.out.println("user_id:"+user_id);
            List r = roomInfoService.find("select occupation from UserRole where id=?", user_id);
            if (r.size() == 1) {
                String occup = (String) r.get(0);
                if (!occupList.contains(occup)) {
                    occupList.add(occup);
                } 
            }
        }
    }

    public List<Double> getRTypeUtilizationRate(int curise_id) {
        List<CheckinState> list = getCheckinByRType(curise_id);
        List<Double> result = new ArrayList<>();
        for (CheckinState r : list) {
            int total = r.getAlready_checkin() + r.getHavenot_checkin() + r.getWait_checkin();
            double rate = (total - r.getHavenot_checkin()) / total * 100;
            result.add(rate);
        }
        return result;
    }

}
