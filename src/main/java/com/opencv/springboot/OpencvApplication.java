package com.opencv.springboot;

import org.opencv.core.Core;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpencvApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpencvApplication.class, args);
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

	}
}
