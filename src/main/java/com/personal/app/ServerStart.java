package com.personal.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by tim on 6/28/17.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.personal")
public class ServerStart {

    public static void main(String[] args){
        SpringApplication.run(ServerStart.class);
    }
    //To test drop
}
