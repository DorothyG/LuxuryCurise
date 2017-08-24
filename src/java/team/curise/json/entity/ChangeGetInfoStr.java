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
public class ChangeGetInfoStr {
    private String old_room_name;
    private String old_room_type;
    private String old_deposit_amount;
    private String now_deposit_amount;
    private String now_room_name;

    public String getOld_room_name() {
        return old_room_name;
    }

    public void setOld_room_name(String old_room_name) {
        this.old_room_name = old_room_name;
    }

    public String getOld_room_type() {
        return old_room_type;
    }

    public void setOld_room_type(String old_room_type) {
        this.old_room_type = old_room_type;
    }

    public String getOld_deposit_amount() {
        return old_deposit_amount;
    }

    public void setOld_deposit_amount(String old_deposit_amount) {
        this.old_deposit_amount = old_deposit_amount;
    }

    public String getNow_deposit_amount() {
        return now_deposit_amount;
    }

    public void setNow_deposit_amount(String now_deposit_amount) {
        this.now_deposit_amount = now_deposit_amount;
    }

    public String getNow_room_name() {
        return now_room_name;
    }

    public void setNow_room_name(String now_room_name) {
        this.now_room_name = now_room_name;
    }
    
    
}
