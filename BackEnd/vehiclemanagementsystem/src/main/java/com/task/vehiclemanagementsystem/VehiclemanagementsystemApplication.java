package com.task.vehiclemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class VehiclemanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehiclemanagementsystemApplication.class, args);
	}

}
