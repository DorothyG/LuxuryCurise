/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.entity.chart;

import java.util.List;

/**
 *
 * @author Apple
 */
public class PieChartDatasets {
    private List<Integer> data;
    private List<String> backgroundColor;
    private List<String> hoverBackgroundColor;
    
    public PieChartDatasets(List<Integer> data, List<String> backgroundColor, List<String> hoverBackgroundColor){
        this.data = data;
        this.backgroundColor = backgroundColor;
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public List<String> getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(List<String> backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public List<String> getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(List<String> hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }
    
}
