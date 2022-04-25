/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PODetail;
import DTO.TagRefItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI GF
 */
public class Data {
    public static Map<String, Integer> getTagRefItemData(){
        Map<String, Integer> map = new HashMap<>();
        try {
            Connection connection = Connect.getConnect();
            String sql = "SELECT `TagCode`, `ItemCode` FROM `tag`";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tagCode = rs.getString("TagCode");
                int itemCode = rs.getInt("ItemCode");
                map.put(tagCode, itemCode);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    
    public static Map<Integer, String> getMapItemName(){
        Map<Integer, String> map = new HashMap<>();
        try {
            Connection connection = Connect.getConnect();
            String sql = "SELECT `ItemCode`, `Name` FROM `item`";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tagCode = rs.getString("Name");
                int itemCode = rs.getInt("ItemCode");
                map.put(itemCode, tagCode);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    
    public static void insertPo(PODetail detail){
        try {
            Connection connection = Connect.getConnect();
            String sql = "INSERT INTO `po_detail`(`POId`, `ITemCode`, `QTY`, `Gate`, `DateTime`) VALUES"
                    + " (1," + detail.getItemCode() + "," + detail.getQty() + "," + detail.getGate() + "," + detail.getDateTime() + ")";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
