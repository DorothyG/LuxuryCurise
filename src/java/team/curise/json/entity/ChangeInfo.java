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

public class ChangeInfo {
    private String real_name;
    private String user_name;
    private String old_room_type;
    private String old_room_name;
    private String new_room_type;
    private String new_room_name;
    private double old_room_deposit;
    private double new_room_deposit;

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
     * @return the new_room_type
     */
    public String getNew_room_type() {
        return new_room_type;
    }

    /**
     * @param new_room_type the new_room_type to set
     */
    public void setNew_room_type(String new_room_type) {
        this.new_room_type = new_room_type;
    }

    /**
     * @return the new_room_name
     */
    public String getNew_room_name() {
        return new_room_name;
    }

    /**
     * @param new_room_name the new_room_name to set
     */
    public void setNew_room_name(String new_room_name) {
        this.new_room_name = new_room_name;
    }

    /**
     * @return the old_room_deposit
     */
    public double getOld_room_deposit() {
        return old_room_deposit;
    }

    /**
     * @param old_room_deposit the old_room_deposit to set
     */
    public void setOld_room_deposit(double old_room_deposit) {
        this.old_room_deposit = old_room_deposit;
    }

    /**
     * @return the new_room_deposit
     */
    public double getNew_room_deposit() {
        return new_room_deposit;
    }

    /**
     * @param new_room_deposit the new_room_deposit to set
     */
    public void setNew_room_deposit(double new_room_deposit) {
        this.new_room_deposit = new_room_deposit;
    }
    
    
    
}
