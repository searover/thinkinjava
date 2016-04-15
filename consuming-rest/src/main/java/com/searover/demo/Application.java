package com.searover.demo;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
//import org.apache.http.client.methods.HttpGet;

/**
 * Created by searover on 4/5/16.
 */
@SpringBootApplication
public class Application implements CommandLineRunner{
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    private static final String QING_CLOUD_URL = "https://api.qingcloud.com/iaas/";
    private static final String QING_CLOUD_ACCESS_KEY_ID = "PQTFNPWUXBMZBQYWDDMH";

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... strings) throws Exception {
//        RestTemplate restTemplate = new RestTemplate();
//        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random",Quote.class);
//        LOGGER.info(quote.toString());
        StringBuilder urlBuilder = new StringBuilder(QING_CLOUD_URL);

        HttpGet get = new HttpGet(QING_CLOUD_URL);

    }
}
