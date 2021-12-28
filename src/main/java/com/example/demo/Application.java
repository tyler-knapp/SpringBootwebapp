package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.sql.*;

@SpringBootApplication
public class Application {

	private Menu menu;

	public Application(Menu menu) throws FileNotFoundException {
		this.menu = menu;
	}

	public void run(){
		menu.showWelcomeMessage();
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu();
		Application demoApplication = new Application(menu);
		SpringApplication.run(Application.class, args);

		String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "postgres1";

		try{
			Connection jdbcConnection = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection to Postgres Successful");

			String sql = "SELECT * FROM users";
			Statement statement = jdbcConnection.createStatement();

			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				int id = result.getInt("id");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");

				System.out.println( id + " " + firstName + " " + lastName );
			}

			jdbcConnection.close();

		}catch(SQLException e){
			System.out.println("Error Connecting to DataBase");
			e.printStackTrace();
		}

		demoApplication.run();

	}

}
