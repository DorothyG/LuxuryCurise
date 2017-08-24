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
public class LayerSale {
    private int layer;//层数
    private int total_rooms;//总舱位
    private int sailed;//已销售
    private int unsail;//未销售
    private List<RoomTypeLayerSale> roomTypeSales;

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
     * @return the sailed
     */
    public int getSailed() {
        return sailed;
    }

    /**
     * @param sailed the sailed to set
     */
    public void setSailed(int sailed) {
        this.sailed = sailed;
    }

    /**
     * @return the unsail
     */
    public int getUnsail() {
        return unsail;
    }

    /**
     * @param unsail the unsail to set
     */
    public void setUnsail(int unsail) {
        this.unsail = unsail;
    }

    /**
     * @return the roomTypeSales
     */
    public List<RoomTypeLayerSale> getRoomTypeSales() {
        return roomTypeSales;
    }

    /**
     * @param roomTypeSales the roomTypeSales to set
     */
    public void setRoomTypeSales(List<RoomTypeLayerSale> roomTypeSales) {
        this.roomTypeSales = roomTypeSales;
    }
    
    
}
