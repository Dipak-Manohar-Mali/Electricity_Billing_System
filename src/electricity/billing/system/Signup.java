/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
import ConToDb.ConectDb;
import  java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import  java.awt.event.*;
import java.sql.*;


/**
 *
 * @author Dipak Mali
 */
public class Signup extends JFrame implements ActionListener{
PreparedStatement ptmt;
ResultSet rs;
     
    
    JButton create, back;
    Choice accountType;
    JTextField meter, username, name, password;
    Signup(){
        
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);
        
        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(100, 50, 140, 20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading);
        
        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260, 50, 150, 20);
        panel.add(accountType);
        
        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 140, 20);
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblmeter.setVisible(false);
        panel.add(lblmeter);
        
        meter = new JTextField();
        meter.setBounds(260, 90, 150, 20);
        meter.setVisible(false);
        panel.add(meter);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100, 130, 140, 20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblusername);
        
        username = new JTextField();
        username.setBounds(260, 130, 150, 20);
        panel.add(username);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 170, 140, 20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblname);
        
        name = new JTextField();
        name.setBounds(260, 170, 150, 20);
        panel.add(name);
        
        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {}
            
            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    Connection conn= ConectDb.connect();
                    ptmt=conn.prepareStatement("select * from login where meter_no =?");
                    ptmt.setString(1, meter.getText());
                    rs=ptmt.executeQuery();
                    while(rs.next()) {
                        name.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblpassword);
        
        password = new JTextField();
        password.setBounds(260, 210, 150, 20);
        panel.add(password);
        
        accountType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = accountType.getSelectedItem();
                if (user.equals("Customer")) {
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                } else {
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });
        
        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(140, 260, 120, 25);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 260, 120, 25);
        back.addActionListener(this);
        panel.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(415, 30, 250, 250);
        panel.add(image);
        
        setVisible(true);
    }
    
public void actionPerformed(ActionEvent e){
        if(e.getSource()==create){
            String atype = accountType.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            String spassword = password.getText();
            String smeter = meter.getText();
          
           try {
                Connection conn= ConectDb.connect();
                
                if (atype.equals("Admin")) {
                    ptmt=conn.prepareStatement("INSERT INTO login(meter_no,username,name,password,user)values(?,?,?,?,?)");
                                           ptmt.setString(1, smeter);
					   ptmt.setString(2, susername);
					   ptmt.setString(3,sname);
                                           ptmt.setString(4,spassword);
                                           ptmt.setString(5,atype);
                                           ptmt.executeUpdate();
                    
                } else {
                    ptmt=conn.prepareStatement("UPDATE login SET username=?,password =?,user =? where meter_no =?");
                                           ptmt.setString(1, susername);
					   ptmt.setString(2, spassword);
					   ptmt.setString(3,atype);
                                           ptmt.setString(4,smeter);
                                           
                                            ptmt.executeUpdate();
                    
                }
                
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login();
              
            } catch (Exception ke) {
                ke.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
