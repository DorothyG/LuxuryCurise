/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.json.entity;

import java.util.List;

/**
 *
 * @author pupu
 */
public class LayerReserve {
    private int layer;//层数
    private int total_rooms;//总舱位
     private int reserved;//已预定
    private int remainder;//剩余
    private int checked_in;//入住
    private List<RoomTypeLayerReserve> roomTypeLayerReserves;

    /**
     * @return the layer
     */
    public int getLayer() {
        return layer;
    }

    /**
     * @param layer the layer to set
     */
    public void setLayer(int layer) {
        this.layer = layer;
    }

    /**
     * @return the total_rooms
     */
    public int getTotal_rooms() {
        return total_rooms;
    }

    /**
     * @param total_rooms the total_rooms to set
     */
    public void setTotal_rooms(int total_rooms) {
        this.total_rooms = total_rooms;
    }

    /**
     * @return the reserved
     */
    public int getReserved() {
        return reserved;
    }

    /**
     * @param reserved the reserved to set
     */
    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    /**
     * @return the remainder
     */
    public int getRemainder() {
        return remainder;
    }

    /**
     * @param remainder the remainder to set
     */
    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }

    /**
     * @return the check_in
     */
    public int getChecked_in() {
        return checked_in;
    }

    /**
     * @param check_in the check_in to set
     */
    public void setChecked_in(int checked_in) {
        this.checked_in = checked_in;
    }

    /**
     * @return the roomTypeLayerReserves
     */
    public List<RoomTypeLayerReserve> getRoomTypeLayerReserves() {
        return roomTypeLayerReserves;
    }

    /**
     * @param roomTypeLayerReserves the roomTypeLayerReserves to set
     */
    public void setRoomTypeLayerReserves(List<RoomTypeLayerReserve> roomTypeLayerReserves) {
        this.roomTypeLayerReserves = roomTypeLayerReserves;
    }
    
    
}
