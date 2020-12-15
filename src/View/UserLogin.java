/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.User;
//import Model.UserList;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author bret_
 */
public class UserLogin extends javax.swing.JFrame {

    /**
     * Creates new form UserLogin
     */
    ArrayList<String> usernames = new ArrayList<String>();
    ArrayList<String> passwords = new ArrayList<String>();
    ArrayList<String> listOfUsers = new ArrayList<String>();
    ArrayList<String> listOfPasswords = new ArrayList<String>();
    ArrayList<ArrayList<String>>  userList = new ArrayList<ArrayList<String>>(); 
    
  //  private UserList currentUserList;
    
    

    
    String user1 = "Skrillex";
    String user2 = "Calvin Harris";
    String user3 = "Marshmello";
    String user4 = "test";
    String pw1 = "12345";
    String pw2 = "54321";
    String pw3 = "6789";
    String pw4 = "test";
    
    private Gson gson = new Gson();
    
    public UserLogin(Controller controller) {
        initComponents();
        setVisible(true);
   //     currentUserList = new UserList();
        usernames.add(user1);
        usernames.add(user2);
        usernames.add(user3);
        usernames.add(user4);
        passwords.add(pw1);
        passwords.add(pw2);
        passwords.add(pw3);
        passwords.add(pw4);
//        
//        userList.add(usernames);
//        userList.add(passwords);
//        
        // Java objects to File
        try (FileWriter writer = new FileWriter("..usernames.json")) {
            gson.toJson(usernames, writer);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
                try (FileWriter writer = new FileWriter("..passwords.json")) {
            gson.toJson(passwords, writer);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
//                   try  (FileReader reader = new FileReader("..login.json")) {
//               
//                    JsonElement json = gson.fromJson(reader, JsonElement.class);
//
//                    String jsonInString = gson.toJson(json);
//                
//                     System.out.println(jsonInString);
//                     
//                        JsonArray array1 = json.getAsJsonArray();
//                        System.out.println(array1.contains(json));
//                        
//                  //   JSONArray jsonArray = new JSONArray(jsonInString);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
        

        
     //   System.out.println(listOfUsers.toString());
        
        
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("username");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Login or create a new account");

        jButton1.setText("Create New User");

        jButton2.setText("Login");

        jPasswordField1.setText("jPasswordField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                .addComponent(jTextField1)))))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public ArrayList<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(ArrayList<String> usernames) {
        this.usernames = usernames;
    }

    public ArrayList<String> getPasswords() {
        return passwords;
    }

    public void setPasswords(ArrayList<String> passwords) {
        this.passwords = passwords;
    }
    
    public ArrayList<String> getListOfUsers() {
        return listOfUsers;
    }

    public ArrayList<String> getListOfPasswords() {
        return listOfPasswords;
    }

    public javax.swing.JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(javax.swing.JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public javax.swing.JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(javax.swing.JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public javax.swing.JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(javax.swing.JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public void setjPasswordField1(javax.swing.JPasswordField jPasswordField1) {
        this.jPasswordField1 = jPasswordField1;
    }

    public javax.swing.JPasswordField getjPasswordField1() {
        return jPasswordField1;
    }

//    public UserList getCurrentUserList() {
//        return currentUserList;
//    }
//
//    public void setCurrentUserList(UserList currentUserList) {
//        this.currentUserList = currentUserList;
//    }

    public Gson getGson() {
        return gson;
    }





}