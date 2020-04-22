package com.example.astarsearch;

import java.sql.*;

public class SavetoDB {
    public static void main(String[] args)
    {
        try
        {
            // mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/test";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            String query = " insert into location (id, location)"
                    + " values (?, ?)";

            AStarSearch astar = new AStarSearch();
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (2, astar.path);

            preparedStmt.execute();

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}
