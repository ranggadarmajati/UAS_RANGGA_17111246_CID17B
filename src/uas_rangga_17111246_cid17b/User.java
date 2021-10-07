/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_rangga_17111246_cid17b;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author rangga
 */
public class User {
    
    // deklarasi value
    String id;
    String nik;
    String name;
    String username;
    String password;
    Date birth_of_date;
    String phone;
    String address;
    String role;
    
    
    // deklarasi db
    Connection con;
    Statement stat;
    PreparedStatement pst = null;
    ResultSet rs;
    String sql;
   
    public User() throws IOException{
      ConnectionDb DB = new ConnectionDb();
       DB.config();  
        con = DB.con;
        stat = DB.stm;
        pst = DB.pst;
    }
    
    public void transactionUsers(String type) throws IOException{
        if("save".equals(type)){
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Nama Harus diisi!");
            }else if("".equals(nik)){
                JOptionPane.showMessageDialog(null, "Nik Harus diisi!");
            }else if("".equals(username)){
                JOptionPane.showMessageDialog(null, "Username Harus diisi!");
            }else if("".equals(password)){
                JOptionPane.showMessageDialog(null, "Password Harus diisi!");
            }else if("".equals(birth_of_date)){
                JOptionPane.showMessageDialog(null, "Tanggal Lahir Harus diisi!");
            }else if("".equals(phone)){
                JOptionPane.showMessageDialog(null, "No Hp Harus diisi!");
            }else if("".equals(address)){
                JOptionPane.showMessageDialog(null, "Alamat Harus diisi!");
            }else if("-".equals(role)){
                JOptionPane.showMessageDialog(null, "Role Harus diisi!");
            }else{
                try{
                    sql = "INSERT INTO `users` (`nik`,`name`, `username`, `password`,`birth_of_date`,`phone`, `address`,`role`) VALUES (?,?,?,?,?,?,?,?)";
                    pst=con.prepareStatement(sql);
                    pst.setString(1, nik);
                    pst.setString(2, name);
                    pst.setString(3, username);
                    pst.setString(4, password);
                    pst.setDate(5, birth_of_date);
                    pst.setString(6, phone);
                    pst.setString(7, address);
                    pst.setString(8, role);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data Karyawan Berhasil disimpan.");
                } catch (SQLException err){
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
            }
        }else if("update".equals(type)){
              if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Nama Harus diisi!");
            }else if("".equals(nik)){
                JOptionPane.showMessageDialog(null, "Nik Harus diisi!");
            }else if("".equals(username)){
                JOptionPane.showMessageDialog(null, "Username Harus diisi!");
            }else if("".equals(birth_of_date)){
                JOptionPane.showMessageDialog(null, "Tanggal Lahir Harus diisi!");
            }else if("".equals(phone)){
                JOptionPane.showMessageDialog(null, "No Hp Harus diisi!");
            }else if("".equals(address)){
                JOptionPane.showMessageDialog(null, "Alamat Harus diisi!");
            }else{
                try{
                    sql = "UPDATE `users` SET `name` = ?,  `username`=?, `birth_of_date`=?,  `phone` = ?, `address` = ?, `role`= ? WHERE `users`.`nik` = ?;";
                    pst=con.prepareStatement(sql);
                    pst.setString(1, name);
                    pst.setString(2, username);
                    pst.setDate(3, birth_of_date);
                    pst.setString(4, phone);
                    pst.setString(5, address);
                    pst.setString(6, role);
                    pst.setString(7, nik);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data Karyawan Berhasil di Update");
                } catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }else{
            try{
                sql="DELETE from users WHERE users.nik= ?";
                 pst=con.prepareStatement(sql);
                 pst.setString(1, nik);
                 pst.execute();
                 JOptionPane.showMessageDialog(null, "Data Karyawan Berhasil di Hapus"); 
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    
}
