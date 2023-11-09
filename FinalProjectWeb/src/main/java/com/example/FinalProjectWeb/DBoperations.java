package com.example.FinalProjectWeb;

import java.sql.*;
import java.util.ArrayList;

public class DBoperations {
    static String url = "jdbc:sqlite:C:/Users/ultid/Documents/FinalProjectWeb/src/main/resources/static/my.db";
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String sql = "CREATE TABLE IF NOT EXISTS recipes (\n"
                    + "	id integer PRIMARY KEY,\n"
                    + "	name text NOT NULL,\n"
                    + "	desc text,\n"
                    + "	imgLink text\n"
                    + ");";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
    public static void add(Recipe recipe){
        try {
            String sql = "INSERT INTO recipes (id, name, desc,imgLink)\n" +
                    "VALUES ("+(FinalProjectWebApplication.recipes.indexOf(recipe)+1)+",\""
                    +recipe.getName()+"\",\""+recipe.getDesc()+"\",\""+recipe.getImgLink()+"\");";
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void getRecipes(){
        try {
            String sql = "SELECT * FROM recipes;";
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            ResultSet resultSet= stmt.getResultSet();
            FinalProjectWebApplication.recipes=new ArrayList<>();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String desc= resultSet.getString("desc");
                String imgLink= resultSet.getString("imgLink");
                Recipe recipe=new Recipe(name,desc,imgLink);
                FinalProjectWebApplication.recipes.add(recipe);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
