/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_rangga_17111246_cid17b;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author rangga
 */
public class ModelItem {
     // deklarasi value
    String id;
    String supplier_id;
    String type_item_id;
    String name;
    Integer price_buy;
    Integer price_sale;
    Integer stock;
    String barcode;
    String plu;
    
    
    // deklarasi db
    Connection con;
    Statement stat;
    PreparedStatement pst = null;
    ResultSet rs;
    String sql;
   
    public ModelItem() throws IOException{
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
            }else if("-".equals(supplier_id)){
                JOptionPane.showMessageDialog(null, "Supplier Harus diisi!");
            }else if("-".equals(type_item_id)){
                JOptionPane.showMessageDialog(null, "Jenis Barang Harus diisi!");
            }else if(price_buy == null){
                JOptionPane.showMessageDialog(null, "Harga Beli Harus diisi!");
            }else if(price_sale == null){
                JOptionPane.showMessageDialog(null, "Harga Jual Harus diisi!");
            }else if(barcode.equals("")){
                JOptionPane.showMessageDialog(null, "Barcode Harus diisi!");
            }else if(plu.equals("")){
                JOptionPane.showMessageDialog(null, "Plu Harus diisi!");
            }else{
                Integer s_id = Integer.parseInt(supplier_id);
                Integer ti_id = Integer.parseInt(type_item_id);
                try{
                    sql = "INSERT INTO `item` (`supplier_id`, `type_item_id`, `name`,`price_buy`,`price_sale`,`barcode`,`plu`) VALUES (?,?,?,?,?,?,?)";
                    pst=con.prepareStatement(sql);
                    pst.setInt(1, s_id);
                    pst.setInt(2, ti_id);
                    pst.setString(3, name);
                    pst.setInt(4, price_buy);
                    pst.setInt(5, price_sale);
//                    pst.setInt(6, stock);
                    pst.setString(6, barcode);
                    pst.setString(7, plu);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data  Barang Berhasil disimpan.");
                } catch (SQLException err){
                    JOptionPane.showMessageDialog(null, err.getMessage());
                }
            }
        }else if("update".equals(type)){
              if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Nama Harus diisi!");
            }else if("-".equals(supplier_id)){
                JOptionPane.showMessageDialog(null, "Supplier Harus diisi!");
            }else if("-".equals(type_item_id)){
                JOptionPane.showMessageDialog(null, "Jenis Barang Harus diisi!");
            }else if(price_buy == null){
                JOptionPane.showMessageDialog(null, "Harga Beli Harus diisi!");
            }else if(price_sale == null){
                JOptionPane.showMessageDialog(null, "Harga Jual Harus diisi!");
            }else if(barcode.equals("")){
                JOptionPane.showMessageDialog(null, "Barcode Harus diisi!");
            }else if(plu.equals("")){
                JOptionPane.showMessageDialog(null, "Plu Harus diisi!");
            }else{
                Integer s_id = Integer.parseInt(supplier_id);
                Integer ti_id = Integer.parseInt(type_item_id);
                try{
                    sql = "UPDATE `item` SET `supplier_id` = ?, `type_item_id` = ?, `name` = ?,  `price_buy`=?, `price_sale` = ?, `barcode` = ?, `plu` = ?  WHERE `item`.`id` = ?;";
                    pst=con.prepareStatement(sql);
                    pst.setInt(1, s_id);
                    pst.setInt(2, ti_id);
                    pst.setString(3, name);
                    pst.setInt(4, price_buy);
                    pst.setInt(5, price_sale);
//                    pst.setInt(6, stock);
                    pst.setString(6, barcode);
                    pst.setString(7, plu);
                    pst.setString(8, id);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Data  Barang Berhasil di Update");
                } catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }else{
            try{
                sql="DELETE from item WHERE item.id= ?";
                 pst=con.prepareStatement(sql);
                 pst.setString(1, id);
                 pst.execute();
                 JOptionPane.showMessageDialog(null, "Data  Barang Berhasil di Hapus"); 
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
