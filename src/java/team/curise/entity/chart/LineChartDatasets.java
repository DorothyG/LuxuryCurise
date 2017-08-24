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
public class LineChartDatasets {
    private String label;
    private boolean fill;
    private double lineTension;
    private String backgroundColor;
    private String borderColor;
    private String borderCapStyle;
    private double borderDashOffset;
    private String borderJoinStyle;
    private String pointBorderColor;
    private String pointBackgroundColor;
    private int pointBorderWidth;
    private int pointHoverRadius;
    private String pointHoverBackgroundColor;
    private String pointHoverBorderColor;
    private int pointHoverBorderWidth;
    private int pointRadius;
    private int pointHitRadius;
    private List<Double> data;
    private boolean spanGaps;

    public LineChartDatasets(String label, boolean fill, double lineTension, String backgroundColor, String borderColor, String borderCapStyle,  double borderDashOffset, String borderJoinStyle, String pointBorderColor, String pointBackgroundColor, int pointBorderWidth, int pointHoverRadius, String pointHoverBackgroundColor, String pointHoverBorderColor, int pointHoverBorderWidth,int pointRadius, int pointHitRadius, List<Double> data, boolean spanGaps) {
        this.label = label;
        this.fill = fill;
        this.lineTension = lineTension;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.borderCapStyle = borderCapStyle;
        this.borderDashOffset = borderDashOffset;
        this.borderJoinStyle = borderJoinStyle;
        this.pointBorderColor = pointBorderColor;
        this.pointBackgroundColor = pointBackgroundColor;
        this.pointBorderWidth = pointBorderWidth;
        this.pointHoverRadius = pointHoverRadius;
        this.pointHoverBackgroundColor = pointHoverBackgroundColor;
        this.pointHoverBorderColor = pointHoverBorderColor;
        this.pointHoverBorderWidth = pointHoverBorderWidth;
        this.pointRadius = pointRadius;
        this.pointHitRadius = pointHitRadius;
        this.data = data;
        this.spanGaps = spanGaps;
    }

    public int getPointHoverBorderWidth() {
        return pointHoverBorderWidth;
    }

    public void setPointHoverBorderWidth(int pointHoverBorderWidth) {
        this.pointHoverBorderWidth = pointHoverBorderWidth;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public double getLineTension() {
        return lineTension;
    }

    public void setLineTension(double lineTension) {
        this.lineTension = lineTension;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getBorderCapStyle() {
        return borderCapStyle;
    }

    public void setBorderCapStyle(String borderCapStyle) {
        this.borderCapStyle = borderCapStyle;
    }

    public double getBorderDashOffset() {
        return borderDashOffset;
    }

    public void setBorderDashOffset(double borderDashOffset) {
        this.borderDashOffset = borderDashOffset;
    }

    public String getBorderJoinStyle() {
        return borderJoinStyle;
    }

    public void setBorderJoinStyle(String borderJoinStyle) {
        this.borderJoinStyle = borderJoinStyle;
    }

    public String getPointBorderColor() {
        return pointBorderColor;
    }

    public void setPointBorderColor(String pointBorderColor) {
        this.pointBorderColor = pointBorderColor;
    }

    public String getPointBackgroundColor() {
        return pointBackgroundColor;
    }

    public void setPointBackgroundColor(String pointBackgroundColor) {
        this.pointBackgroundColor = pointBackgroundColor;
    }

    public int getPointBorderWidth() {
        return pointBorderWidth;
    }

    public void setPointBorderWidth(int pointBorderWidth) {
        this.pointBorderWidth = pointBorderWidth;
    }

    public int getPointHoverRadius() {
        return pointHoverRadius;
    }

    public void setPointHoverRadius(int pointHoverRadius) {
        this.pointHoverRadius = pointHoverRadius;
    }

    public String getPointHoverBackgroundColor() {
        return pointHoverBackgroundColor;
    }

    public void setPointHoverBackgroundColor(String pointHoverBackgroundColor) {
        this.pointHoverBackgroundColor = pointHoverBackgroundColor;
    }

    public String getPointHoverBorderColor() {
        return pointHoverBorderColor;
    }

    public void setPointHoverBorderColor(String pointHoverBorderColor) {
        this.pointHoverBorderColor = pointHoverBorderColor;
    }

    public int getPointRadius() {
        return pointRadius;
    }

    public void setPointRadius(int pointRadius) {
        this.pointRadius = pointRadius;
    }

    public int getPointHitRadius() {
        return pointHitRadius;
    }

    public void setPointHitRadius(int pointHitRadius) {
        this.pointHitRadius = pointHitRadius;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }

    public boolean isSpanGaps() {
        return spanGaps;
    }

    public void setSpanGaps(boolean spanGaps) {
        this.spanGaps = spanGaps;
    }
    
}
