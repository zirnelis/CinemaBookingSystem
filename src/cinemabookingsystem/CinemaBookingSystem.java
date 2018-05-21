/*
 * 
 */
package cinemabookingsystem;


import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
//import javafx.scene.web.PopupFeatures;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.GroupLayout;

/**
 *
 * @author Elina
 */
public class CinemaBookingSystem extends Application {

   
    static GoogleMapsSample sample;
    
    static String location = "56.9420051,24.0927632";
    static Stage stage = new Stage();
    static GridPane mapGrid = new GridPane();
    
    static Button submitBtn;
    static Stage secondaryStage;
    
    static User tempUsr; //to generate users
    

    User user;

    @Override
    public void start(Stage primaryStage) throws IOException {


//        tempUsr = new User("meh", "123");
//        tempUsr.writeNewUser(tempUsr);
        

        
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
        
        submitBtn = new Button("Submit");
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
        
        mapGrid.setAlignment(Pos.CENTER);
        mapGrid.setHgap(10);
        mapGrid.setVgap(10);
        mapGrid.setPadding(new Insets(25, 25, 25, 25));

        Scene mapScene = new Scene(mapGrid,950,600); 

        Button showMapBtn = new Button("SHOW MAP!");
        submitBtn.setAlignment(Pos.CENTER_RIGHT);
        mainGrid.add(showMapBtn, 1, 4);

        
        /**
         * Create button creates new user and writes user`s info into file
         */
        
        createBtn.setOnAction(new EventHandler<ActionEvent>(){
            User usr = new User(userTextField.getText(), passTextField.getText());
            System.out.println(userTextField.getText()+" "+passTextField.getText());
//            System.out.println(userTextField.getText() + " ");
            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println("Happens in CBS");
//                    usr.writeNewUser(usr);
                    usr.writeNewUser02(usr);
                } catch (Exception ex ){
                    System.err.println("error: "+ ex);
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
                
                
                
                /**
                 * Open Map and find your location
                 */
                primaryStage.close();
                Platform.setImplicitExit(false);
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
        });
    }

    
    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
            launch(args);
            
        }
        
    }
    

