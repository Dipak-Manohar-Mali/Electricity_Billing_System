/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
import ConToDb.ConectDb;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Dipak Mali
 */
public class BillDetails extends JFrame {
    PreparedStatement ptmt;
    ResultSet rs;
    BillDetails(String meter) {
        
        setSize(700, 650);
        setLocation(400, 150);
        
        getContentPane().setBackground(Color.WHITE);
        
        JTable table = new JTable();
        
        try {
            Connection conn= ConectDb.connect();
            ptmt=conn.prepareStatement("select * from bill where meter_no = ?");
            ptmt.setString(1, meter);
            rs=ptmt.executeQuery();
           
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 700, 650);
        add(sp);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new BillDetails("");
    }
}
