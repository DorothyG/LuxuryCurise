/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.json.entity;

/**
 *
 * @author pupu
 */
public class ChangeGetInfo {
    private String old_room_name;
    private String old_room_type;
    private double old_deposit_amount;
    private double now_deposit_amount;
    private String now_room_name;

    /**
     * @return the old_room_name
     */
    public String getOld_room_name() {
        return old_room_name;
    }

    /**
     * @param old_room_name the old_room_name to set
     */
    public void setOld_room_name(String old_room_name) {
        this.old_room_name = old_room_name;
    }

    /**
     * @return the old_room_type
     */
    public String getOld_room_type() {
        return old_room_type;
    }

    /**
     * @param old_room_type the old_room_type to set
     */
    public void setOld_room_type(String old_room_type) {
        this.old_room_type = old_room_type;
    }

    /**
     * @return the old_deposit_amount
     */
    public double getOld_deposit_amount() {
        return old_deposit_amount;
    }

    /**
     * @param old_deposit_amount the old_deposit_amount to set
     */
    public void setOld_deposit_amount(double old_deposit_amount) {
        this.old_deposit_amount = old_deposit_amount;
    }

    /**
     * @return the now_deposit_amount
     */
    public double getNow_deposit_amount() {
        return now_deposit_amount;
    }

    /**
     * @param now_deposit_amount the now_deposit_amount to set
     */
    public void setNow_deposit_amount(double now_deposit_amount) {
        this.now_deposit_amount = now_deposit_amount;
    }

    /**
     * @return the now_room_name
     */
    public String getNow_room_name() {
        return now_room_name;
    }

    /**
     * @param now_room_name the now_room_name to set
     */
    public void setNow_room_name(String now_room_name) {
        this.now_room_name = now_room_name;
    }


    
}
