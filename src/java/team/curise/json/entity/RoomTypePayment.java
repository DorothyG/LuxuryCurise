/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.json.entity;

/**
 *
 * @author pupu
 * 这里的房间就默认是已经预定的，查的时候要查已经预定的，即从Room User查
 */
public class RoomTypePayment {
    private String room_type;
    private String room_name;
    private String isPaid;//是否交了押金

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
     * @return the room_num
     */
    public String getRoom_name() {
        return room_name;
    }

    /**
     * @param room_num the room_num to set
     */
    public void setRoom_name(String room_name) {
        this.room_name= room_name;
    }

    /**
     * @return the isPaid
     */
    public String getIsPaid() {
        return isPaid;
    }

    /**
     * @param isPaid the isPaid to set
     */
    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

   
    
}
