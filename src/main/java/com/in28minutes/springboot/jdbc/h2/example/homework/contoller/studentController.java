package com.in28minutes.springboot.jdbc.h2.example.student.contoller;

import com.in28minutes.springboot.jdbc.h2.example.student.Coin;
import com.in28minutes.springboot.jdbc.h2.example.student.CoinJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;


@RestController
public class studentController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CoinJdbcRepository coinRepository;

    @RequestMapping(value = "/coin",method = RequestMethod.GET)
    public String getCoinInfoFromBank(String name) throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }

    @GetMapping("/coin/{chartName}")
    public String getCoinInfo(@PathVariable("chartName") String chartName) {
        return coinRepository.findByChartName(chartName).toString();
    }


    @RequestMapping(value = "/coin",method = RequestMethod.POST,headers = "Accept=application/json",produces = MediaType.APPLICATION_JSON_VALUE,consumes = {"*/*"})
    public String insertCoin(@RequestBody Coin coin ) {
        logger.info("insert", coinRepository.insert(coin));
        return coin.getChartName()+coin.getChineseName()+"insert";
    }

    @RequestMapping(value = "/coin",method = RequestMethod.DELETE,headers = "Accept=application/json",produces = MediaType.APPLICATION_JSON_VALUE,consumes = {"*/*"})
    public String deleteCoinInfo(@RequestBody Coin coin ) {
        logger.info("delete", coinRepository.deleteByChartName(coin.getChartName()));
        return "delete"+coin.getChartName();
    }
    @RequestMapping(value = "/coin",method = RequestMethod.PUT,headers = "Accept=application/json",produces = MediaType.APPLICATION_JSON_VALUE,consumes = {"*/*"})
    public String updateCoinInfo(@RequestBody Coin coin ) {
        logger.info("Update", coinRepository.update(coin));
        return "update"+coin.getChartName();
    }


    @RequestMapping(value = "/coin/rate",method = RequestMethod.POST,headers = "Accept=application/json",produces = MediaType.APPLICATION_JSON_VALUE,consumes = {"*/*"})
    public String insertCoinRate(@RequestBody Coin coin ) {
        logger.info("insertRate", coinRepository.insertRate(coin));
        return coin.getChartName()+coin.getChineseName()+"insertRate";
    }

    @RequestMapping(value = "/coin/rate",method = RequestMethod.PUT,headers = "Accept=application/json",produces = MediaType.APPLICATION_JSON_VALUE,consumes = {"*/*"})
    public String updateCoinRate(@RequestBody Coin coin ) {
        logger.info("update", coinRepository.updateRate(coin));
        return coin.getChartName()+coin.getChineseName()+"updateRate";
    }

}