/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

 import java.sql.*;

import java.awt.*;  
import java.awt.event.*;  
import static java.util.jar.Pack200.Packer.PASS;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.css.StyleOrigin.USER;
import javax.swing.*;  
/**
 *
 * @author niranjan
 */
public class login extends JFrame implements ActionListener  {
   TextField name,pass;
    Button b1,b2;
    login()
    {
        setLayout(new FlowLayout());
        this.setLayout(null);
        Label n=new Label("User :",Label.CENTER);
        Label p=new Label("Password:",Label.CENTER);
        name=new TextField(20);
        pass=new TextField(20);
        pass.setEchoChar('#');
        b1=new Button("submit");
        b2=new Button("cancel");
        this.add(n);
        this.add(name);
        this.add(p);
        this.add(pass);
        this.add(b1);
        this.add(b2);
        n.setBounds(70,90,90,60);
        p.setBounds(70,130,90,60);
        name.setBounds(200,100,90,20);
        pass.setBounds(200,140,90,20);
        b1.setBounds(100,260,70,40);
        b2.setBounds(180,260,70,40);
        b1.addActionListener(this);
 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
       System.out.println("working ");
       try {
           login(name.toString(),pass.toString());
       } catch (SQLException ex) {
           Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
       }
       
        
    
             
//To change body of generated methods, choose Tools | Templates.
    }
public void login(String user, String pass) throws SQLException
{
    
   String DB_URL = "jdbc:mysql://localhost/";

   //  Database credentials
    String USER = "root";
 String PASS = "";
    Connection conn = null;
   Statement stmt = null;
   
       try {
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
       }

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT id,pass FROM user ";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         
         String uid = rs.getString("id ");
         String upass  = rs.getString("pass ");

         // user matching 
          if(user.equals(uid)&& pass.equals(upass))
          {
          new OnlineTest("Online Test ");  
          break;
          }
          
          }
      
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
 
   

}
    
}
