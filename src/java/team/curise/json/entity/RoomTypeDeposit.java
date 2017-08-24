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
public class RoomTypeDeposit {
    private String room_type;
    private String room_name;
    private String is_paid_deposit;

    /**
     * @return the room_type
     */
    public String getRoom_type() {
        return room_type;
    }

    /**
     * @param room_type the room_type to set
     */
    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    /**
     * @return the room_name
     */
    public String getRoom_name() {
        return room_name;
    }

    /**
     * @param room_name the room_name to set
     */
    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    /**
     * @return the is_paid_deposit
     */
    public String getIs_paid_deposit() {
        return is_paid_deposit;
    }

    /**
     * @param is_paid_deposit the is_paid_deposit to set
     */
    public void setIs_paid_deposit(String is_paid_deposit) {
        this.is_paid_deposit = is_paid_deposit;
    }
    
}
