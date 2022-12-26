package com.example.ecommerce_d;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {

    public static DatabaseConnection connection;
    public  static Group root;

    public static String emailId;
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        emailId="";
        connection=new DatabaseConnection();
        root=new Group();
        Header header=new Header();
        ProductPage productPage=new ProductPage();
        AnchorPane productPane=new AnchorPane();
        productPane.getChildren().add(productPage.products());
        productPane.setLayoutY(100);
        productPane.setLayoutX(150);
        root.getChildren().addAll(header.root,productPane);

        stage.setTitle("Ecommerce!");
        stage.setScene(new Scene(root,500,500));
        stage.show();
        stage.setOnCloseRequest(e ->{
            try {
                connection.con.close();
                System.out.println("Connection is closed successfully");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}