package com.jbdl25.minorproject;

import com.jbdl25.minorproject.model.Admin;
import com.jbdl25.minorproject.requests.AdminCreateRequest;
import com.jbdl25.minorproject.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinorprojectApplication implements CommandLineRunner {

	@Autowired
	AdminService adminService;

	public static void main(String[] args) {
		SpringApplication.run(MinorprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AdminCreateRequest admin = AdminCreateRequest.builder()
				.name("Mukesh")
				.email("mukesh@gmail.com")
				.password("mukesh123")
				.build();

		adminService.saveAdmin(admin);
	}
}
