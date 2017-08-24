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
public class RevenueYear {
    private int year;
    private double revenue;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public RevenueYear(int year, double revenue) {
        this.year = year;
        this.revenue = revenue;
    }
    
}
