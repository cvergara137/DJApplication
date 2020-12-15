/*
 * Filename: User.java
 * Short description: 
 * @author  Bret Talley
 * @version Oct 3, 2020
 */
package Model;

import java.io.Serializable;

/**
 * @author bret_
 * @version 1.0 Oct 3, 2020
 */
public class User implements Serializable {    
    private String userName; 
    private String userPassword; 
    public User(String un, String up)
    {
            userName = un; 
            userPassword = up;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    

}