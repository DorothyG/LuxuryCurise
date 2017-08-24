/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.json.entity.management;

/**
 *
 * @author pupu
 */
public class CheckinState {
    private int already_checkin;// 已入住
    private int wait_checkin;//待入住
    private int havenot_checkin;//未入住

    public int getAlready_checkin() {
        return already_checkin;
    }

    public void setAlready_checkin(int already_checkin) {
        this.already_checkin = already_checkin;
    }

    public int getWait_checkin() {
        return wait_checkin;
    }

    public void setWait_checkin(int wait_checkin) {
        this.wait_checkin = wait_checkin;
    }

    public int getHavenot_checkin() {
        return havenot_checkin;
    }

    public void setHavenot_checkin(int havenot_checkin) {
        this.havenot_checkin = havenot_checkin;
    }
    
    
}
