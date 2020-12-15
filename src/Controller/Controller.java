/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;
import Model.Song;
import View.PlayerFrameFX;
import View.UserLogin;
import View.View;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javax.swing.JButton;

/**
 *
 * @author bret_
 */
public class Controller {
          // initialize default values
    Model model;
    View view;
    private Gson gson;
   
   
  
 

       
    public Controller() {
        model = new Model();
        view = new View(this);
        Controller controller2 = new Controller(model, view); 
        
    }
    
        public Controller(Model model, View view) // pass in data to initialize variables
    {
        this.model = model;
        this.view = view;
       
        
        UserLoginListener();
        
//                            try  (FileReader reader = new FileReader("..login.json")) {
//                    //    listOfUsers = new Gson().fromJson(reader.toString(), ArrayList.class);
//                     //   listOfPasswords = gson.fromJson(reader, passwords.getClass());
//                     ArrayList<String> jsonObject = new Gson().fromJson(reader, ArrayList<String>);
//                     System.out.println(jsonObject);
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
        }
        
        
        public void UserLoginListener() {
        // listener to add song to xml file
        JButton userLogin = view.getUl().getjButton2();
        userLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JButton obj = (JButton) ae.getSource();

                if (obj == userLogin) {
                                
                    String user = view.getUl().getjTextField1().getText();
                    String password = view.getUl().getjPasswordField1().getText();
                    
//                    if (view.getUl().getListOfUsers().contains(user) && view.getUl().getListOfPasswords().contains(password)) 
//                    {
//                        view.getUl().setVisible(false);
//                     //   view.getPf().setVisible(true);
//                        PlayerFrameFX.launch(PlayerFrameFX.class);
//                        
//                        
//                    } else
//                    {
//                        System.out.println("Not a valid user");
//
//                    }    
    
                            // Java object from File

                    

                    /*if (view.getUl().getUsernames().contains(user) && view.getUl().getPasswords().contains(password))
                    {
                        view.getUl().setVisible(false);
                     //   view.getPf().setVisible(true);
                        PlayerFrameFX.launch(PlayerFrameFX.class);
                        
                        
                    } else
                    {
                        System.out.println("Not a valid user");

                    }*/
                    ArrayList<String> usernames = new ArrayList<String>();   
                    ArrayList<String> passwords = new ArrayList<String>(); 
                    gson = new Gson();
                    
                    try  (FileReader readerUser = new FileReader("..usernames.json")) {
               
                    JsonElement json = gson.fromJson(readerUser, JsonElement.class);

                    String jsonInString = gson.toJson(json);
                
                     System.out.println(jsonInString);
                     
                        JsonArray array1 = json.getAsJsonArray();
                        
                           for (int i=0;i<array1.size();i++){ 
                            usernames.add(array1.get(i).toString().replaceAll("\"", ""));
                               } 
                           
                           
                        
  
                        System.out.println(usernames);
                        
                  //   JSONArray jsonArray = new JSONArray(jsonInString);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                    try  (FileReader readerPassword = new FileReader("..passwords.json")) {
               
                    JsonElement json = gson.fromJson(readerPassword, JsonElement.class);

                    String jsonInString2 = gson.toJson(json);
                
                     System.out.println(jsonInString2);
                     
                        JsonArray array2 = json.getAsJsonArray();
                        
                           for (int i=0;i<array2.size();i++){ 
                            passwords.add(array2.get(i).toString().replaceAll("\"", ""));
                               } 
                           
                           
                        
  
                        System.out.println(passwords);
                        
                  //   JSONArray jsonArray = new JSONArray(jsonInString);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(usernames.get(0));
                    System.out.println(view.getUl().getjTextField1().getText());
                    System.out.println(view.getUl().getjPasswordField1().getPassword());
                    
                    if (usernames.contains(view.getUl().getjTextField1().getText()) && password.contains(view.getUl().getjPasswordField1().getText())) {
                        
                         view.getUl().setVisible(false);
                     //   view.getPf().setVisible(true);
                        PlayerFrameFX.launch(PlayerFrameFX.class);
                    } else
                    {
                        System.out.println("Not a valid user");

                    }  
                    
                    
                }

            }

        });
    }
        
        

}
