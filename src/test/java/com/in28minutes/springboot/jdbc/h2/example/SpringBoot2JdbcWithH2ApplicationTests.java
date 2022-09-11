package com.in28minutes.springboot.jdbc.h2.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

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
import java.net.HttpURLConnection;
import java.io.IOException;
import java.net.URL;
import org.testng.annotations.Test;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import static org.testng.AssertJUnit.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SpringBoot2JdbcWithH2ApplicationTests {
	private JdbcTemplate template;

	@Autowired
	@Test
	public void contextLoads() throws IOException {
		JdbcTemplate jdbcTemplate;
		CoinJdbcRepository coinJdbcRepository = new CoinJdbcRepository();
		Coin coin = new Coin("test","test");
		int a = coinJdbcRepository.insert(coin);
		assertEquals("200",a);
	}

}
