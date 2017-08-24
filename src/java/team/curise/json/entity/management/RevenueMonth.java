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
public class RevenueMonth {
    private int month;
    private double revenue;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public RevenueMonth(int month, double revenue) {
        this.month = month;
        this.revenue = revenue;
    }
    
    
}
