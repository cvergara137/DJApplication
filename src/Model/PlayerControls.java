/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.Window;


/**
 *
 * @author bret_
 */
abstract public class PlayerControls {
    
    private Stop stop;
    private Play play;
    
    protected FileInputStream FIS;  
    protected BufferedInputStream BIS; 
    protected long songtotalLength;
    protected String fileLocation;
    
    
    public PlayerControls() {
        
    }
    
    abstract public void ButtonControl();
    
    abstract public void AlterAudio();
    
    abstract public void SendData();
    
    
        public void LoadSong() {    
       
                    File file = null;
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter fileExtension = new FileChooser.ExtensionFilter("Audio files", "*.mp3", "*.wav");
        fileChooser.getExtensionFilters().add(fileExtension);
        Window stage = null;
        file = fileChooser.showOpenDialog(stage);
        System.out.println(file);
            
        FileFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");
       JFileChooser chooser = new JFileChooser("C:\\music:");
       chooser.addChoosableFileFilter(filter);
    
       
       int returnVal = chooser.showOpenDialog(null);
       
       if (returnVal == JFileChooser.APPROVE_OPTION)
       {
           stop.ButtonControl();
           File myFile = chooser.getSelectedFile();
           String song = myFile + "";
           

           
           play.Play(song);
       }
    }  

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public BufferedInputStream getBIS() {
        return BIS;
    }

    public void setBIS(BufferedInputStream BIS) {
        this.BIS = BIS;
    }

    public FileInputStream getFIS() {
        return FIS;
    }

    public void setFIS(FileInputStream FIS) {
        this.FIS = FIS;
    }
        
        
        
    
}
