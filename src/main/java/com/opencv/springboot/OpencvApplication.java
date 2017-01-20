package com.opencv.springboot;

import nu.pattern.OpenCV;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpencvApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpencvApplication.class, args);
        OpenCV.loadShared();
    }
}
