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
public class LineChart {
    private List<String> labels;
    private List<LineChartDatasets> datasets;

    public LineChart() {
    }
    
    public LineChart(List<String> labels, List<LineChartDatasets> datasets){
        this.labels = labels;
        this.datasets = datasets;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<LineChartDatasets> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<LineChartDatasets> datasets) {
        this.datasets = datasets;
    }
}
