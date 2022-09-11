package com.in28minutes.springboot.jdbc.h2.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;
@Repository
public class CoinJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    static class CoinRowMapper implements RowMapper<Coin> {
        @Override
        public Coin mapRow(ResultSet rs, int rowNum) throws SQLException {
            Coin coin = new Coin();
            coin.setChartName("Bitcoin");
            return coin;
        }

    }

    public List<Coin> findAll() {
        return jdbcTemplate.query("select * from student", new CoinRowMapper());
    }

    public Coin findByChartName(String chartName) {
        return jdbcTemplate.queryForObject("select * from coinInfo where chartName=?", new BeanPropertyRowMapper<>(Coin.class), chartName);
    }


    public String deleteByChartName(String chartName) {
        jdbcTemplate.update("delete from coinInfo where chartName=?", chartName);
        return "delete complete";
    }

    public int insert(Coin coin) {
        Date d = new Date();

        jdbcTemplate.update("insert into coinInfo ( chartName, chineseName) " + "values(?,  ?)",
                coin.getChartName(),coin.getChineseName());
        jdbcTemplate.update("insert into COINUPDATE ( CHARTNAME,updated, updatedISO,updateduk) " + "values(?,?,  ?,?)",
                coin.getChartName(),d.toString(),d.toString(),d.toString());
        return 200;
    }

    public int update(Coin coin) {
        Date d = new Date();
        jdbcTemplate.update("update COININFO " + " set CHINESENAME = ? " + " where CHARTNAME = ?",
                coin.getChineseName(), coin.getChartName());
        jdbcTemplate.update("update  COINUPDATE set updated=?, updatedISO=?,updateduk=? where CHARTNAME = ?",
                d.toString(),d.toString(),d.toString(),coin.getChartName());
        return 200;
    }

    public int insertRate(Coin coin) {
        Date d = new Date();

        jdbcTemplate.update("insert into COINRATEINFO ( chartName, Currency,code,symbol,rate,description,rate_float) " + "values(?,  ?,?,?,?,?,?)",
                coin.getChartName(),coin.getCurrency(),coin.getCode(),coin.getSymbol(),coin.getRate(),coin.getDescription(),coin.getRate_float());
        jdbcTemplate.update("update  COINUPDATE set updated=?, updatedISO=?,updateduk=? where CHARTNAME = ?",
                d.toString(),d.toString(),d.toString(),coin.getChartName());
        return 200;
        //    chartName varchar(255)  not null,
//    Currency varchar(255)  not null,
//    code  varchar(255) not null,
//    symbol varchar(255) not null,
//    rate  varchar(255) not null,
//    description varchar(255) not null,
//    rate_float varchar(255) not null,
    }

    public int updateRate(Coin coin) {
        Date d = new Date();
        jdbcTemplate.update("update  coinRateInfo set Currency=?, code=?,symbol=?,rate=? ,description=? ,rate_float=?  where CHARTNAME = ? and Currency = ?",
                coin.getCurrency(),coin.getCode(),coin.getSymbol(),coin.getRate(),coin.getDescription(),coin.getRate_float(),coin.getChartName(),coin.getCurrency());
        jdbcTemplate.update("update  COINUPDATE set updated=?, updatedISO=?,updateduk=? where CHARTNAME = ?",
                d.toString(),d.toString(),d.toString(),coin.getChartName());
        return 200;
    }
}
