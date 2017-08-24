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
 */
public class LayerCheckin {
    private List<CheckinState> roomTypeCheckinList;
    private int layer ;

    public List<CheckinState> getRoomTypeCheckinList() {
        return roomTypeCheckinList;
    }

    public void setRoomTypeCheckinList(List<CheckinState> roomTypeCheckinList) {
        this.roomTypeCheckinList = roomTypeCheckinList;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
    
}
