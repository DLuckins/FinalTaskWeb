package com.example.FinalProjectWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class FinalProjectWebApplication {
	public static List<Recipe> recipes= new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectWebApplication.class, args);
		DBoperations.connect();
		DBoperations.getRecipes();
	}
}
