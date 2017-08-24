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
public class LayerDeposit {
    private int layer;//层数
    private int total_rooms;//总舱位
    private int paid_deposit_num;//这一层交了押金的房间数
    private int unpaid_deposit_num;//这一层未交押金的房间数
    private List<RoomTypeDeposit> roomTypeDeposits;

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
     * @return the paid_deposit_num
     */
    public int getPaid_deposit_num() {
        return paid_deposit_num;
    }

    /**
     * @param paid_deposit_num the paid_deposit_num to set
     */
    public void setPaid_deposit_num(int paid_deposit_num) {
        this.paid_deposit_num = paid_deposit_num;
    }

    /**
     * @return the unpaid_deposit_num
     */
    public int getUnpaid_deposit_num() {
        return unpaid_deposit_num;
    }

    /**
     * @param unpaid_deposit_num the unpaid_deposit_num to set
     */
    public void setUnpaid_deposit_num(int unpaid_deposit_num) {
        this.unpaid_deposit_num = unpaid_deposit_num;
    }

    /**
     * @return the roomTypeDeposits
     */
    public List<RoomTypeDeposit> getRoomTypeDeposits() {
        return roomTypeDeposits;
    }

    /**
     * @param roomTypeDeposits the roomTypeDeposits to set
     */
    public void setRoomTypeDeposits(List<RoomTypeDeposit> roomTypeDeposits) {
        this.roomTypeDeposits = roomTypeDeposits;
    }
    
}
