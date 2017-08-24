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
public class PieChart {
    private List<String> labels;
    private List<PieChartDatasets> datasets;
    
    public PieChart(List<String> labels, List<PieChartDatasets> datasets){
        this.labels = labels;
        this.datasets = datasets;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<PieChartDatasets> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<PieChartDatasets> datasets) {
        this.datasets = datasets;
    }
    
}
