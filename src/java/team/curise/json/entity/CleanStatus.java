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
public class CleanStatus {

    private String room_type;
    private String room_name;
    private String clean_state;

    /**
     * @return the clean_state
     */
    public String getClean_state() {
        return clean_state;
    }

    /**
     * @param clean_state the clean_state to set
     */
    public void setClean_state(String clean_state) {
        this.clean_state = clean_state;
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

}
