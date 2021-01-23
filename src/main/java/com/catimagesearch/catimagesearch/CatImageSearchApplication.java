package com.catimagesearch.catimagesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
@ComponentScan(basePackages = { "com.catimagesearch.catimagesearch"} )
public class CatImageSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatImageSearchApplication.class, args);
	}

}
