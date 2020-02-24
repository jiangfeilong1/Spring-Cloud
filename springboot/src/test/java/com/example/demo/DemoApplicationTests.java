package com.example.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

@SpringBootTest
class DemoApplicationTests {
    @LocalServerPort
    private int port;
    private URL base;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @BeforeAll
    public void setUp() throws Exception{
        this.base = new URL("http://localhost:"+port+"/hello");
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void getHello() throws Exception{
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(base.toString(),String.class);
    }

}
