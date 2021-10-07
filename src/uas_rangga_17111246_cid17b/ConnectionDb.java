/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_rangga_17111246_cid17b;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author rangga darmajati 
 * @email rangga.darmajati@wgs.co.id
 * @gitlab @ranggadj
 * @whatsapp 085721731478
 *
 */
public class ConnectionDb {
    // Declare Connection, Statement and Prepared Statement 
    Connection con;
    Statement stm;
    PreparedStatement pst;
    public void config() throws FileNotFoundException, IOException{
        Properties prop = new Properties();
        FileReader reader = new FileReader("src/uas_rangga_17111246_cid17b/config_db.properties");
        prop.load(reader);
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        String host = prop.getProperty("host");
        String database = prop.getProperty("database");
        System.out.println(username);
        System.out.println(password);
        System.out.println(host);
        System.out.println(database);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://"+host+"/"+database+"", ""+username+"", ""+password+"");
            stm = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal. message:"+e.getMessage());
            System.exit(0);
        }
    }
}
