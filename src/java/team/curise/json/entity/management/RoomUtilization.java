/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.json.entity.management;

import java.util.List;

/**
 *
 * @author pupu
 * 客房使用
 * 各种舱房类型里面的数据是一样的，所以他们以顺序做区别
 * 1
 */
public class RoomUtilization {
    List<RoomTypeCuriseCheckin> roomTypeCuriseCheckinList;

    public List<RoomTypeCuriseCheckin> getRoomTypeCuriseCheckinList() {
        return roomTypeCuriseCheckinList;
    }

    public void setRoomTypeCuriseCheckinList(List<RoomTypeCuriseCheckin> roomTypeCuriseCheckinList) {
        this.roomTypeCuriseCheckinList = roomTypeCuriseCheckinList;
    }
    
}
