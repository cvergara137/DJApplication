/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.PlayerFrameFXMLController;

/**
 *
 * @author bret_
 */
public class Model {
    
    private PlayerControls playercontrols;
    private PlayerFrameFXMLController fxController;
    
    public Model() {
        
    }

    public PlayerControls getPlayercontrols() {
        return playercontrols;
    }

    public void setPlayercontrols(PlayerControls playercontrols) {
        this.playercontrols = playercontrols;
    }

    public PlayerFrameFXMLController getFxController() {
        return fxController;
    }

    public void setFxController(PlayerFrameFXMLController fxController) {
        this.fxController = fxController;
    }
    
    
}
