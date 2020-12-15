/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author bret_
 */

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Stop extends PlayerControls {
    
    Model model;
    
    public long pauseLocation;
    public long songtotalLength;
    
    public Stop() {
        
    }
    
    public void ButtonControl() {
        
                if (model.getFxController().getMedia() != null)
        {
            
            
            model.getFxController().getMediaPlayerLeft().stop();
            pauseLocation = 0;
            songtotalLength = 0;
        }
    }
    
    public void AlterAudio() {
        
    }
    
    public void SendData() {
        
    }
    
}
