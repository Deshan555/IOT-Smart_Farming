package com.deshan.chart;

public class ModelChartLine {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public ModelChartLine(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public ModelChartLine() {
    }

    private String name;
    private double value;
}
