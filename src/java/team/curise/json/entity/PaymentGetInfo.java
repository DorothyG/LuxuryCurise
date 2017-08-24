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
public class PaymentGetInfo {
    private String real_name;
    private double paid_deposit;
    private double should_pay;
    private double real_pay;
    private List<UserConsumption> userConsumptions;

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    
    public double getReal_pay() {
        return real_pay;
    }

    public void setReal_pay(double real_pay) {
        this.real_pay = real_pay;
    }

    
    /**
     * @return the paid_deposit
     */
    public double getPaid_deposit() {
        return paid_deposit;
    }

    /**
     * @param paid_deposit the paid_deposit to set
     */
    public void setPaid_deposit(double paid_deposit) {
        this.paid_deposit = paid_deposit;
    }

    /**
     * @return the should_pay
     */
    public double getShould_pay() {
        return should_pay;
    }

    /**
     * @param should_pay the should_pay to set
     */
    public void setShould_pay(double should_pay) {
        this.should_pay = should_pay;
    }

    /**
     * @return the userConsumptions
     */
    public List<UserConsumption> getUserConsumptions() {
        return userConsumptions;
    }

    /**
     * @param userConsumptions the userConsumptions to set
     */
    public void setUserConsumptions(List<UserConsumption> userConsumptions) {
        this.userConsumptions = userConsumptions;
    }
    
    
}
