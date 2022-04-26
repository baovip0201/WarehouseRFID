/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TagReportListenerImplementation;

import BUS.Tag_BUS;
import DTO.RFID;
import GUI.Main;
import GUI.Order_Detail;
import com.impinj.octane.ImpinjReader;
import com.impinj.octane.Tag;
import com.impinj.octane.TagReport;
import com.impinj.octane.TagReportListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI
 */
public class MyTagReportListener1 implements TagReportListener{
    public static Set<RFID> scan=new HashSet<>();
    public static Set<String> tempList=new HashSet<>();
    Tag_BUS tagBUS = new Tag_BUS();

    public MyTagReportListener1() {
        Order_Detail a=new Order_Detail();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
    }

    

    @Override
    public void onTagReported(ImpinjReader reader, TagReport report) {
        List<Tag> tags = report.getTags();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        //tempList=new HashSet<>();
                for (Tag t : tags) { 
                    //tempList=new HashSet<>();
                    String epc = t.getEpc().toString();
                    String time = dtf.format(now);
                    String gate = String.valueOf(t.getAntennaPortNumber());
                    
                    scan.add(new RFID(epc, time, gate));
                    Order_Detail.map1.put(epc, new RFID(time, gate));
                    Order_Detail.model1.setRowCount(0);
                    //tempList.add(epc);
                    

                    for (Map.Entry<String, RFID> entry : Order_Detail.map1.entrySet()) {
                        String k = entry.getKey();
                        RFID v = entry.getValue();
                        Order_Detail.model1.addRow(new Object[]{k, v.getDate(), v.getGate()});
                        //Order_Detail.tbl_scan.setModel(Order_Detail.model1);
                        tempList.add(k);
                        
                    }

                }
                //show();
                showProduct();
            
        

    }

    private void showProduct() {
        Order_Detail.map=new HashMap<>();
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

    void show() {
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
           Order_Detail. model2.addRow(new Object[]{k, v});
        }
    }
    
}
