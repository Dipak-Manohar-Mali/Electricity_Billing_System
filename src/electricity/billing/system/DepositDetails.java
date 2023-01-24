/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

import ConToDb.ConectDb;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
/**
 *
 * @author Dipak Mali
 */
public class DepositDetails extends JFrame implements ActionListener{
    PreparedStatement ptmt;
    ResultSet rs;
    Choice meternumber, cmonth;
    JTable table;
    JButton search, print;
    
    DepositDetails(){
        super("Deposit Details");
        
        setSize(700, 700);
        setLocation(400, 100);
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblmeternumber = new JLabel("Search By Meter Number");
        lblmeternumber.setBounds(20, 20, 150, 20);
        add(lblmeternumber);
        
        meternumber = new Choice();
        meternumber.setBounds(180, 20, 150, 20);
        add(meternumber);
        
        try {
            Connection conn= ConectDb.connect();
            ptmt=conn.prepareStatement("select * from customer");
	    rs=ptmt.executeQuery();
            
            while(rs.next()) {
                meternumber.add(rs.getString("meter_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblmonth = new JLabel("Search By Month");
        lblmonth.setBounds(400, 20, 100, 20);
        add(lblmonth);
        
        cmonth = new Choice();
        cmonth.setBounds(520, 20, 150, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        add(cmonth);
        
        table = new JTable();
        
        try {
            Connection conn= ConectDb.connect();
            ptmt=conn.prepareStatement("select * from bill");
	    rs=ptmt.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 100, 700, 600);
        add(sp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            
            try {
               Connection conn= ConectDb.connect();
               ptmt=conn.prepareStatement("select * from bill where meter_no =? and month =?");
               
               ptmt.setString(1, meternumber.getSelectedItem());
               ptmt.setString(2, cmonth.getSelectedItem());
	       rs=ptmt.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                
            }
        } else  {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DepositDetails();
    }
}