/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

import ConToDb.ConectDb;
import  java.awt.*;
import javax.swing.*;
import  java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dipak Mali
 */
public class Login extends JFrame implements ActionListener{
PreparedStatement ptmt;
ResultSet rs;   
JButton login,signup,cancel;
JTextField username,password;
JComboBox combo;
    Login(){
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(300,20,100,20);
        add(lblusername);
        
        username=new JTextField();
        username.setBounds(400,20,150,20);
        add(username);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(300,60,100,20);
        add(lblpassword);
        
        password=new JTextField();
        password.setBounds(400,60,150,20);
        add(password);
        
        JLabel Logginginas=new JLabel("Loging as");
        Logginginas.setBounds(300,100,100,20);
        add(Logginginas);
        
        combo=new JComboBox();
        combo.setBounds(400,100,150,20);
        add(combo);
        combo.addItem("Admin");
        combo.addItem("Customer");
        
        login=new JButton("Login");
        login.setBounds(330,160,100,20);
        login.addActionListener(this);
        add(login);
        
        signup=new JButton("signup");
        signup.setBounds(380,200,100,20);
        signup.addActionListener(this);
        add(signup);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(450,160,100,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,250,250);
        add(image);
        
        
        
        
    
      setSize(640,300);
      setLocation(400,200);
      setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
            String susername=username.getText();
            String spassword=password.getText();
            String user=combo.getSelectedItem().toString();
            
            try{
        Connection conn=ConectDb.connect();
        ptmt=conn.prepareStatement("select * from login where (username= ? and password= ?) and user= ?");
        ptmt.setString(1, susername);
        ptmt.setString(2, spassword);
        ptmt.setString(3, user);
					   rs=ptmt.executeQuery();
					   if(rs.next()) {
						JOptionPane.showMessageDialog(null , "Your Login successfully");
                                                
                                                String meter = rs.getString("meter_no");
                                                setVisible(false);
                                                new Project(user, meter);
						
					   }
					   else {
						   JOptionPane.showMessageDialog(null , "Username and password not match");
						   username.setText("");
						   password.setText("");
						   username.requestFocus();
					   }
    } catch (SQLException ex) {
       ex.printStackTrace();;
    }
        
        }else if(e.getSource()==signup){
        
                new Signup();
                setVisible(false);
        
        }else if(e.getSource()==cancel)
        {
            setVisible(false);
        }
        
    
    
    }
    
    public static void main(String arg[]){
    
        new Login();
    
    }
}
