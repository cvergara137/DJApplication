/*
 * Filename: Play.java
 * Short description: 
 * @author  Bret Talley
 * @version Oct 1, 2020
 */
package Model;

import Controller.PlayerFrameFXMLController;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * @author bret_
 * @version 1.0 Oct 1, 2020
 */



public class Play extends PlayerControls
{
    // Instance Variables -- define your private data    
    PlayerControls playerControls;
    PlayerFrameFXMLController FXController;
    HBox playerLeft = FXController.getPlayerLeft();
    protected MediaPlayer mediaPlayer;
    

// Constructors
    public Play()
    {
            // initialize default values
    }
    public Play(int data) // pass in data to initialize variables
    {
    }    

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable    
    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable    
    // Additional methods -- such as for calculation, display    

    public String toString()
    {
            // return data as a String
            return "";
    }

    public void ButtonControl() {
        
    }
    
    public void AlterAudio() {
        
    }
    
    public void SendData() {
        
    }
    
    public void Play(String path)
    {
     try {
         FIS = new FileInputStream(path);
         BIS = new BufferedInputStream(FIS);
         
         fileLocation = path + "";
         
     //    player = new Player(BIS);
         
         final Media media = new Media(fileLocation.toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
         
         songtotalLength = FIS.available();
         
         
     } 
     catch (FileNotFoundException ex) {
     
     } catch (IOException ex) {
         Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
     }
     

    }
    
}