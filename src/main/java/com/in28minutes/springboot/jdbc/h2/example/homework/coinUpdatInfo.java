package com.in28minutes.springboot.jdbc.h2.example.student;

public class coinUpdatInfo {
    private String chartName;
    private String updated;
    private String updatedISO;
    private String updateduk;

    public coinUpdatInfo(String chartName, String updated) {
        super();
        this.chartName = chartName;
        this.updated = updated;
    }
    public coinUpdatInfo(String chartName, String updated, String updatedISO,String updateduk) {
        super();
        this.chartName = chartName;
        this.updated = updated;
        this.updatedISO = updatedISO;
        this.updateduk = updateduk;
    }

    public String getChartName() {
        return chartName;
    }
    public String getUpdated() {
        return updated;
    }
    public String getUpdatedISO() {
        return updatedISO;
    }
    public String getUpdateduk() {
        return updateduk;
    }
}
