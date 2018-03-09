/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemabookingsystem;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Elina
 */
public class CinemaBookingSystem extends Application {

    @Override
    public void start(Stage primaryStage) {

        /**
         * "Hello world button form example"
         */
        //test changes
//        Button btn = new Button();
//        Button btn2 = new Button();
//        btn.setText("Say 'Hello World'");
//        btn2.setText("TestButton");
//        call Action when button is pressed
//        btn.setOnAction(new EventHandler<ActionEvent>() {
            // Action method defined
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
        // Adding Grid to Scene
        GridPane loginGrid = new GridPane();
        loginGrid.setAlignment(Pos.CENTER);
        loginGrid.setHgap(10);
        loginGrid.setVgap(10);
        loginGrid.setPadding(new Insets(25, 25, 25, 25));
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        root.getChildren().add(btn2);
        
//        Scene scene = new Scene(root, 850, 600);
        
        Scene loginScene = new Scene(loginGrid, 850, 600);
        
        primaryStage.setTitle("Cinema Booking System");
        primaryStage.setScene(loginScene);
        
        /**
         * Adding "Cinema Booking system" title
         * Username and Password field with titles
         */
        
        Text scenetitle = new Text("Welcome to Cinema Booking System");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        loginGrid.add(scenetitle, 0, 0, 2, 1); //what means this numbers???
        
        Label username = new Label("User Name:");
        loginGrid.add(username, 0, 1);
        
        TextField userTextField = new TextField();
        loginGrid.add(userTextField, 1, 1);
        
        Label password = new Label("Password:");
        loginGrid.add(password, 0, 2);
        
        TextField passTextField = new TextField();
        loginGrid.add(passTextField, 1, 2);
        
        /**
         * Adding Submit button
         */
        
        Button submitBtn = new Button("Submit");
        submitBtn.setAlignment(Pos.CENTER_RIGHT);
        loginGrid.add(submitBtn, 1, 4);
        
        /**
         * Adding Create button
         */
        
        Button createBtn = new Button("Create");
        createBtn.setAlignment(Pos.CENTER_LEFT);
        loginGrid.add(createBtn, 2, 4);
        
        
//        HBox hbBtn = new HBox(10);
//        hbBtn.setAlignment(Pos.CENTER);
//        hbBtn.getChildren().add(submitBtn);
//        grid.add(hbBtn, 1, 4);
        
        primaryStage.show();
        
        /**
         * Make new Scene for app
         */
        
        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.setHgap(10);
        mainGrid.setVgap(10);
        mainGrid.setPadding(new Insets(25, 25, 25, 25));
        
        Scene mainScene = new Scene(mainGrid, 950, 600);
        
        
        /**
         * Create button creates new user and writes user`s info into file
         */
        
        createBtn.setOnAction(new EventHandler<ActionEvent>(){
            
            User usr = new User(userTextField.getText(), passTextField.getText());
//            System.out.println(userTextField.getText() + " ");
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    usr.writeNewUser(usr);
                } catch (IOException ex) {
                    Logger.getLogger(CinemaBookingSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
        
        /**
         * If Username and Password is correct, clear window
         */
        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                /**
                 * Write code for User info checking,
                 * but first make new User!!
                 */
                primaryStage.setScene(mainScene);
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
}
