/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pupu
 */
@Entity
@Table(name = "room_year_revenue")
public class RoomYearRevenue {
    
    private int id;
    private int curise_id;
    private double revenue;
    private String collator;
    private String date;

    public RoomYearRevenue() {
    }

    public RoomYearRevenue(int id, int curise_id, double revenue, String collator, String date) {
        this.id = id;
        this.curise_id = curise_id;
        this.revenue = revenue;
        this.collator = collator;
        this.date = date;
    }
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurise_id() {
        return curise_id;
    }

    public void setCurise_id(int curise_id) {
        this.curise_id = curise_id;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getCollator() {
        return collator;
    }

    public void setCollator(String collator) {
        this.collator = collator;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
