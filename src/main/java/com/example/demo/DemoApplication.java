package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class DemoApplication {

	private Menu menu;

	public DemoApplication(Menu menu) throws FileNotFoundException {
		this.menu = menu;
	}

	public void run(){
		menu.showWelcomeMessage();
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu();
		DemoApplication demoApplication = new DemoApplication(menu);
		SpringApplication.run(DemoApplication.class, args);
		demoApplication.run();

	}

}
