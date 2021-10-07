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
public class ModelTypeItem {
      // deklarasi value
    String id;
    String name;
    String description;
    
    // deklarasi db
    Connection con;
    Statement stat;
    PreparedStatement pst = null;
    ResultSet rs;
    String sql;
   
    public ModelTypeItem() throws IOException{
      ConnectionDb DB = new ConnectionDb();
       DB.config();  
        con = DB.con;
        stat = DB.stm;
        pst = DB.pst;
    }
    
    public void transactions(String type) throws IOException{
        if("save".equals(type)){
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Nama Harus diisi!");
            }else if("".equals(description)){
                JOptionPane.showMessageDialog(null, "Keterangan Harus diisi!");
            }else{
                try{
                    sql = "INSERT INTO `type_item` (`name`,`description`) VALUES (?,?)";
                    pst=con.prepareStatement(sql);
                    pst.setString(1, name);
                    pst.setString(2, description);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data Jenis Barang Berhasil disimpan.");
                } catch (SQLException err){
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
            }
        }else if("update".equals(type)){
              if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Nama Harus diisi!");
            }else if("".equals(description)){
                JOptionPane.showMessageDialog(null, "Nik Harus diisi!");
            }else{
                try{
                    sql = "UPDATE `type_item` SET `name` = ?,  `description`=? WHERE `type_item`.`id` = ?;";
                    pst=con.prepareStatement(sql);
                    pst.setString(1, name);
                    pst.setString(2, description);
                    pst.setString(3, id);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data Jenis Barang Berhasil di Update");
                } catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }else{
            try{
                sql="DELETE from type_item WHERE type_item.id= ?";
                 pst=con.prepareStatement(sql);
                 pst.setString(1, id);
                 pst.execute();
                 JOptionPane.showMessageDialog(null, "Data Jenis Barang Berhasil di Hapus"); 
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
