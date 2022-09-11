package com.in28minutes.springboot.jdbc.h2.example.student;

public class CoinRate {
    private String chartName;
    private String currency;
    private String code;
    private String symbol;
    private String rate;
    private String description;
    private String rate_float;
    public CoinRate() {
        super();
    }

//
//    chartName varchar(255)  not null,
//    Currency varchar(255)  not null,
//    code  varchar(255) not null,
//    symbol varchar(255) not null,
//    rate  varchar(255) not null,
//    description varchar(255) not null,
//    rate_float varchar(255) not null,
    public CoinRate(String chartName, String currency, String code,String symbol,String rate,String description,String rate_float) {
        super();
        this.chartName = chartName;
        this.currency = currency;
        this.code = code;
        this.symbol = symbol;
        this.rate = rate;
        this.description = description;
        this.rate_float = rate_float;
    }


    public String getChartName() {
        return chartName;
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
    public String getDescription() {
        return description;
    }
    public String getRate_float() {
        return rate_float;
    }
    public void setName(String chartName) {
        this.chartName = chartName;
    }


    @Override
    public String toString() {
        return String.format("Coininfo [chartName=%s]", chartName);
    }
}
