/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Tag_BUS;
import DTO.RFID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
public class Input {

    //public static Set<RFID> listScan1 = new HashSet<>();;

    List<String> tempList;
    Tag_BUS tagBUS = new Tag_BUS();
    int count = 0;
    Set<String> colData;

    public Input() {
        Order_Detail a=new Order_Detail();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
    }
  
    
    List<String> getTags(){
        List<String> list=new ArrayList<>();
        for(int i=1;i<30;i++){
            list.add("300F 4FB7 3AD0 01C0 8369 A"+i);
        }
                      
        return list;
    }
    public void scan(){
               
                for(String s: getTags()) {                   
                    Order_Detail.map1.put(s, new RFID("1","1"));
                    Order_Detail.model1.setRowCount(0);

                    for (Map.Entry<String, RFID> entry : Order_Detail.map1.entrySet()) {
                        //tempList=new HashSet<>();
                        String k = entry.getKey();
                        RFID v = entry.getValue();
                        Order_Detail.model1.addRow(new Object[]{k, v.getDate(), v.getGate()});
                        Order_Detail.tbl_scan.setModel(Order_Detail.model1);                       
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Input1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                show();          
    }
    
    public void show() {
        Order_Detail.model2.setRowCount(0);
        Vector data = Order_Detail.model1.getDataVector();
        Vector row = (Vector) data.elementAt(0);
        int mColIndex = 0;
        Set<String> colData = new HashSet<>(Order_Detail.tbl_scan.getRowCount());

        for (int i = 0; i < Order_Detail.tbl_scan.getRowCount(); i++) {
            row = (Vector) data.elementAt(i);
            colData.add(row.get(mColIndex).toString());
        }
        
        
        for (String s : colData) {
            System.out.println(s);
            String element = tagBUS.query_product_id(s);

            if (Order_Detail.map.containsKey(element)) {
                Order_Detail.map.put(element, Order_Detail.map.get(element) + 1);
            } else {
                Order_Detail.map.put(element, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : Order_Detail.map.entrySet()) {
            String k = entry.getKey();
            int v = entry.getValue();
            System.out.println(k + " + " + v);
            Order_Detail.model2.addRow(new Object[]{k, v});
        }
    }

    private void showProduct() {
        Order_Detail.model2.setRowCount(0);
        for (String ls : tempList) {
            String element = tagBUS.query_product_id(ls);

            System.out.println(element);
            if (Order_Detail.map.containsKey(element)) {
                Order_Detail.map.put(element, Order_Detail.map.get(element) + 1);
            } else {
                Order_Detail.map.put(element, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : Order_Detail.map.entrySet()) {
            String k = entry.getKey();
            int v = entry.getValue();
            System.out.println(k + " + " + v);
            Order_Detail.model2.addRow(new Object[]{k, v});
        }

    }
}
