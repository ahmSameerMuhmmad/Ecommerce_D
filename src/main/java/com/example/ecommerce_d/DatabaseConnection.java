package com.example.ecommerce_d;

import java.sql.*;

public class DatabaseConnection {
    Connection con=null;
    String SQLURL="jdbc:mysql://localhost:3306/ecommerce?useSSL=false&allowPublicKeyRetrieval=true";
    String userName="root";
    String password="Rehan9729@";
    DatabaseConnection() throws SQLException {
        con= DriverManager.getConnection(SQLURL,userName,password);
        if(con!=null){
            System.out.println("Our Connection is Established with the database");
        }

    }

//    "select * from temperory";
    public ResultSet executeQuery(String query) throws SQLException {
        ResultSet result=null;
        try {
            Statement statement=con.createStatement();
             result=statement.executeQuery(query);
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;


    }

    public int executeUpdate(String query){
        int row=0;
        try {
            Statement statement=con.createStatement();
            row=statement.executeUpdate(query);
            return row;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return row;
    }



}
