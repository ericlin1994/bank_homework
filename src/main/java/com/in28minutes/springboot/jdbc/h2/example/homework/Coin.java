package com.in28minutes.springboot.jdbc.h2.example.student;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coin {

    private String chartName;
    private String chineseName;
    public String coinRate;
    private String currency;
    private String code;
    private String symbol;

    private String rate;
    private String description;
    private String rate_float;
    private String updated;
    private String updatedISO;
    private String updateduk;

    public Coin() {
        super();
    }
    public Coin(String chartName, String chineseName) {
        super();
        this.chartName = chartName;
        this.chineseName = chineseName;
    }
    public Coin(String chartName, String chineseName, String coinRate, String currency, String code, String symbol, String rate, String description, String rate_float, String updated, String updatedISO, String updateduk) {
        this.chartName = chartName;
        this.chineseName = chineseName;
        this.coinRate = coinRate;
        this.currency = currency;
        this.code = code;
        this.symbol = symbol;
        this.rate = rate;
        this.description = description;
        this.rate_float = rate_float;
        this.updated = updated;
        this.updatedISO = updatedISO;
        this.updateduk = updateduk;
    }

    public String getCoinRate() {
        return coinRate;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getRate() {
        return rate;
    }

    public String getDescription() {
        return description;
    }

    public String getRate_float() {
        return rate_float;
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

    public String getChartName() {
        return chartName;
    }
    public String getChineseName() {
        return chineseName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }


    @Override
    public String toString() {
        return String.format("Coininfo [chartName=%s]", chartName);
    }

}
