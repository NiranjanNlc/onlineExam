/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

 
import java.awt.*;  
import java.awt.event.*;  
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
        Label n=new Label("Name:",Label.CENTER);
        Label p=new Label("password:",Label.CENTER);
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
        
        new OnlineTest("Online Test ");  
    
             
//To change body of generated methods, choose Tools | Templates.
    }

    
}
