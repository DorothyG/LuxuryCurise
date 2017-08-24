/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.json.entity.management;

import team.curise.entity.chart.LineChart;

/**
 *
 * @author pupu
 */
public class EngageManageEntity {
    private LineChart total;
    private LineChart retail;
    private LineChart entertain;
    private LineChart room;
    private LineChart food;

    public LineChart getTotal() {
        return total;
    }

    public void setTotal(LineChart total) {
        this.total = total;
    }

    public LineChart getRetail() {
        return retail;
    }

    public void setRetail(LineChart retail) {
        this.retail = retail;
    }

    public LineChart getEntertain() {
        return entertain;
    }

    public void setEntertain(LineChart entertain) {
        this.entertain = entertain;
    }

    public LineChart getRoom() {
        return room;
    }

    public void setRoom(LineChart room) {
        this.room = room;
    }

    public LineChart getFood() {
        return food;
    }

    public void setFood(LineChart food) {
        this.food = food;
    }
   
    
}
