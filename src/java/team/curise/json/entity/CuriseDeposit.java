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
public class CuriseDeposit {
    private String curise_name;//邮轮名称
    private int total_rooms;//总舱位
    private int paid_deposit_num;//这一艘邮轮交了押金的房间数
    private int unpaid_deposit_num;//这一艘邮轮未交押金的房间数
    private List<LayerDeposit> layerDeposits;

    /**
     * @return the curise_name
     */
    public String getCurise_name() {
        return curise_name;
    }

    /**
     * @param curise_name the curise_name to set
     */
    public void setCurise_name(String curise_name) {
        this.curise_name = curise_name;
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
     * @return the layerDeposits
     */
    public List<LayerDeposit> getLayerDeposits() {
        return layerDeposits;
    }

    /**
     * @param layerDeposits the layerDeposits to set
     */
    public void setLayerDeposits(List<LayerDeposit> layerDeposits) {
        this.layerDeposits = layerDeposits;
    }
    
}
