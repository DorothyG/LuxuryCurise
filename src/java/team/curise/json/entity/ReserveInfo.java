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
public class ReserveInfo {
    //1套房2阳台房3海景房4内舱房
    private String room_type;
    private String room_name;
    private String real_name;
    private String user_name;
    private String ID_number;
    private String time;

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
     * @return the real_name
     */
    public String getReal_name() {
        return real_name;
    }

    /**
     * @param real_name the real_name to set
     */
    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    /**
     * @return the user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @param user_name the user_name to set
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return the ID_number
     */
    public String getID_number() {
        return ID_number;
    }

    /**
     * @param ID_number the ID_number to set
     */
    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }
    
}
