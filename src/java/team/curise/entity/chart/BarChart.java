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
public class BarChart {
    private List<String> labels;
    private List<BarChartDatasets> datasets;
    
    public BarChart(List<String> labels, List<BarChartDatasets> datasets){
        this.labels = labels;
        this.datasets = datasets;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<BarChartDatasets> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<BarChartDatasets> datasets) {
        this.datasets = datasets;
    }
    
}
