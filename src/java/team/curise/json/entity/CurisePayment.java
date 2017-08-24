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
public class CurisePayment {
    private String curise_name;//邮轮名称
    private int total_rooms;//总舱位
    private int paid;//已缴费的房间数
    private int unpaid;//未缴费的房间数
    private List<LayerPayment> layerPayments;

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
     * @return the layerPayments
     */
    public List<LayerPayment> getLayerPayments() {
        return layerPayments;
    }

    /**
     * @param layerPayments the layerPayments to set
     */
    public void setLayerPayments(List<LayerPayment> layerPayments) {
        this.layerPayments = layerPayments;
    }
    
}
