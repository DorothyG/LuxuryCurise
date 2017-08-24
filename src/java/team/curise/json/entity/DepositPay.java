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
public class DepositPay {
    private String room_name;
    private String real_name;
    private double deposit_amount;

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
     * @return the deposit_amount
     */
    public double getDeposit_amount() {
        return deposit_amount;
    }

    /**
     * @param deposit_amount the deposit_amount to set
     */
    public void setDeposit_amount(double deposit_amount) {
        this.deposit_amount = deposit_amount;
    }
    
}
