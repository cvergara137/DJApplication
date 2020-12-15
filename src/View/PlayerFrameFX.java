/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import java.awt.Color;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author bret_
 */
public class PlayerFrameFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PlayerFrameFXML.fxml"));


        Scene scene = new Scene(root, 1300, 900);

        primaryStage.setTitle("DJ Application");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //this makes all stages close and the app exit when the main stage is closed
        primaryStage.setOnCloseRequest(e -> Platform.exit());
    }

}
