package com.example.ecommerce_d;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductPage {
    ListView<HBox>products;

    ListView<HBox> productsBySearch(String search) throws SQLException {
        products=new ListView<>();
        ObservableList<HBox>productList= FXCollections.observableArrayList();
        ResultSet res=HelloApplication.connection.executeQuery("Select * from product");
        while(res.next()){
            if(res.getString("productName").toLowerCase().contains(search.toLowerCase())){
                Label name=new Label();
                Label productId=new Label();
                Label price=new Label();
                Button buy=new Button();
                buy.setText("Buy");
                name.setMinWidth(50);;
                productId.setMinWidth(50);;
                price.setMinWidth(50);
                HBox productDetails=new HBox();
                buy.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if(HelloApplication.emailId.equals(""))
                        {
                            Dialog<String> dialog=new Dialog<>();
                            dialog.setTitle("Login");
                            ButtonType type =new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                            dialog.getDialogPane().getButtonTypes().add(type);
                            dialog.setContentText("Please😁 Login first");
                            dialog.showAndWait();
                        }
                        else{
                            System.out.println("You are Logged in with "+HelloApplication.emailId);
                            Order order=new Order();
                            try {
                                order.placeOrder(productId.getText());
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.println("Buy Button is getting clicked");
                    }
                });

                name.setText(res.getString("productName"));
                productId.setText(res.getString("productId"));
                price.setText(res.getString("price"));
                productDetails.getChildren().addAll(productId,name,price,buy);
                productList.add(productDetails);
            }

        }
        products.setItems(productList);
        return products;


    }
    ListView<HBox> products() throws SQLException {
        products=new ListView<>();
        ObservableList<HBox>productList= FXCollections.observableArrayList();
        ResultSet res=HelloApplication.connection.executeQuery("Select * from product");
        while(res.next()){
            Label name=new Label();
            Label productId=new Label();
            Label price=new Label();
            Button buy=new Button();
            buy.setText("Buy");
            name.setMinWidth(50);;
            productId.setMinWidth(50);;
            price.setMinWidth(50);
            HBox productDetails=new HBox();
            buy.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    if(HelloApplication.emailId.equals(""))
                                    {
                                        Dialog<String> dialog=new Dialog<>();
                                        dialog.setTitle("Login");
                                        ButtonType type =new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                                        dialog.getDialogPane().getButtonTypes().add(type);
                                        dialog.setContentText("Please😁 Login first");
                                        dialog.showAndWait();
                                    }
                                    else{
                                        System.out.println("You are Logged in with "+HelloApplication.emailId);
                                        Order order=new Order();
                                        try {
                                            order.placeOrder(productId.getText());
                                        } catch (SQLException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                                    System.out.println("Buy Button is getting clicked");
                                }
            });

            name.setText(res.getString("productName"));
            productId.setText(res.getString("productId"));
            price.setText(res.getString("price"));
            productDetails.getChildren().addAll(productId,name,price,buy);
            productList.add(productDetails);
        }
        products.setItems(productList);
        return products;


    }
}
