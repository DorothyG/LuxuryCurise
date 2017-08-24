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
public class LayerPayment {
    private int layer;//层数
    private int total_rooms;//总舱位
    private int paid;//未缴费的房间数
    private int unpaid;//已缴费的房间数
    private List<RoomTypePayment> roomTypePayments;

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
     * @return the paied
     */
    public int getPaid() {
        return paid;
    }

    /**
     * @param paied the paied to set
     */
    public void setPaid(int paid) {
        this.paid = paid;
    }

    /**
     * @return the unpaied
     */
    public int getUnpaid() {
        return unpaid;
    }

    /**
     * @param unpaied the unpaied to set
     */
    public void setUnpaid(int unpaid) {
        this.unpaid = unpaid;
    }

    /**
     * @return the roomTypePayments
     */
    public List<RoomTypePayment> getRoomTypePayments() {
        return roomTypePayments;
    }

    /**
     * @param roomTypePayments the roomTypePayments to set
     */
    public void setRoomTypePayments(List<RoomTypePayment> roomTypePayments) {
        this.roomTypePayments = roomTypePayments;
    }
    
    
}
