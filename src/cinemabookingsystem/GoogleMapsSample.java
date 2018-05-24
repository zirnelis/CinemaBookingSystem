/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemabookingsystem;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.application.Platform;


/**
 *
 * @author Elina
 */
public class GoogleMapsSample extends Application{
        static String location = "56.9420051,24.0927632";
    
        static Stage stage = new Stage();
        
        public void start(Stage primaryStage) {
    
            Platform.runLater(() -> {
                WebView webView = new WebView();
                
                // Create the WebEngine
                final WebEngine webEngine = webView.getEngine();
                // LOad the Start-Page
                webEngine.load("https://www.google.lv/maps/@"+ location +",11z");
                
                
                // Update the stage title when a new web page title is available
                webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>()
                {
                    public void changed(ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState)
                    {
                        if (newState == Worker.State.SUCCEEDED)
                        {
                            //stage.setTitle(webEngine.getLocation());
                            stage.setTitle(webEngine.getTitle());
                        }
                    }
                });
                
                // Create the VBox
                VBox root = new VBox();
                // Add the WebView to the VBox
                root.getChildren().add(webView);
                
                // Set the Style-properties of the VBox
                root.setStyle("-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: white;");
                // Create the Scene
                Scene scene = new Scene(root);
                // Add  the Scene to the Stage
                stage.setScene(scene);
                // Display the Stage
                stage.show();
            });
                       
            }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        System.out.println("Tiktāl ir");
//        primaryStage.show();
//    }

    public static void setLocation(String location) {
        GoogleMapsSample.location = location;
    }

    
    
}

