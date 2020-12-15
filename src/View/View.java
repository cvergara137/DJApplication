/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;

/**
 *
 * @author bret_
 */
public class View {
    private PlayerFrame pf;
    private PlayerFrameFX pffx;
    private UserLogin ul;
    private Controller controller;
    
    
        // Constructors
    public View(Controller controller)
    {
        this.controller = controller;
            // initialize default values
        pf = new PlayerFrame(controller);  
        pffx = new PlayerFrameFX();
        ul = new UserLogin(controller);
      

    
      
    }

    public PlayerFrame getPf() {
        return pf;
    }

    public void setPf(PlayerFrame pf) {
        this.pf = pf;
    }

    public UserLogin getUl() {
        return ul;
    }

    public void setUl(UserLogin ul) {
        this.ul = ul;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public PlayerFrameFX getPffx() {
        return pffx;
    }

    public void setPffx(PlayerFrameFX pffx) {
        this.pffx = pffx;
    }


    
    
}
