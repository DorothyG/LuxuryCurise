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
public class RevenueQuarter {
    private int quarter;
    private double revenue;

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public RevenueQuarter(int quarter, double revenue) {
        this.quarter = quarter;
        this.revenue = revenue;
    }
    
}
