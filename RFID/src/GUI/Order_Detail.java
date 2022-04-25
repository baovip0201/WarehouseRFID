/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.OrderdetailBUS;
import BUS.ProductBUS;
import BUS.Tag_BUS;
import DTO.Orderdetail;
import DTO.Order;
import DTO.Product;
import DTO.RFID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MSI
 */
public class Order_Detail extends javax.swing.JFrame {

    DefaultTableModel model, model1, model2;
    List<Orderdetail> dList = new ArrayList<>();
    OrderdetailBUS bus = new OrderdetailBUS();
    Set<RFID> list_rfid, tempList;
    Tag_BUS tagBUS=new Tag_BUS();
    TagRFID tagrfid=new TagRFID();  
    Map<String, Integer> map=new HashMap<>();
    Map<String, RFID> map2=new HashMap<>();
    public Order_Detail() {
        initComponents();
        model = (DefaultTableModel) tbl_orderdetail.getModel();
        model1 = (DefaultTableModel) tbl_scan.getModel();
        model2 = (DefaultTableModel) tbl_count.getModel();
        showD();
        showResult();
        showProduct();
        getCb_Box_Order();
        //getCb_Box_Product();
    }
    private void showD(){
        dList=bus.getListV();
        model.setRowCount(0);
        dList.forEach((tv)->{
        model.addRow(new Object[] {tv.getOrder_id(),tv.getProduct_id(),tv.getQuanity()});
        });
        
    }
    private void getCb_Box_Order(){        
        List<Order> list=new ArrayList<>();       
        list = bus.fill_cbb_order();
        for(Order item: list){
            cbb_order_id.addItem(item.getOrder_id());
        }
        
     }
    
//    private void getCb_Box_Product(){        
//        List<Product> list=new ArrayList<>();       
//        list = bus.fill_cbb_product();
//        for(Product item: list){
//            cbb_product_id.addItem(item.getProduct_id());
//        }
//        
//     }
    private void showResult() {
        tempList=new HashSet<>();
        tagrfid.listScan.forEach((ls) -> {
            map2.put(ls.getTagID(), new RFID(ls.getDate(), ls.getGate()));
            //model.addRow(new Object[]{ls.getTagID(), ls.getDate(), ls.getGate()});
        });

        for (Map.Entry<String, RFID> entry : map2.entrySet()) {
            String k = entry.getKey();
            RFID v = entry.getValue();
            model1.addRow(new Object[]{k, v.getDate(), v.getGate()});           
            tempList.add(new RFID(k,v.getDate(), v.getGate()));
        }
    }
    private void showProduct(){    
        tempList.forEach((ls) -> {
            //product_id.add(tagBUS.query_product_id(ls.getTagID()));  
            String element=tagBUS.query_product_id(ls.getTagID());
            System.out.println(element);
            if(map.containsKey(element)){
                map.put(element, map.get(element)+1);
            }else{
                map.put(element,1);
            }
        });
        
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            String k=entry.getKey();
            int v=entry.getValue();
            model2.addRow(new Object[]{k,v});
        }
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_orderdetail = new javax.swing.JTable();
        btnThemDiem = new javax.swing.JButton();
        btnSuaDiem = new javax.swing.JButton();
        btnXoaDiem = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cbb_order_id = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_scan = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_count = new javax.swing.JTable();
        btn_refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Order ID:");

        tbl_orderdetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Order ID", "Product ID", "Quanity"
            }
        ));
        tbl_orderdetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_orderdetailMouseClicked(evt);
            }
        });
        tbl_orderdetail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_orderdetailKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_orderdetail);

        btnThemDiem.setText("Lưu");
        btnThemDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDiemActionPerformed(evt);
            }
        });

        btnSuaDiem.setText("Sửa");
        btnSuaDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDiemActionPerformed(evt);
            }
        });

        btnXoaDiem.setText("Xóa");
        btnXoaDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDiemActionPerformed(evt);
            }
        });

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbl_scan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag ID", "Date", "Gate"
            }
        ));
        jScrollPane2.setViewportView(tbl_scan);

        tbl_count.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product_ID", "QTY"
            }
        ));
        jScrollPane3.setViewportView(tbl_count);

        btn_refresh.setText("Refresh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_refresh)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(btnXoaDiem, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                    .addComponent(btnThemDiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(btnSuaDiem)
                                    .addComponent(cbb_order_id, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbb_order_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btn_refresh)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemDiem)
                            .addComponent(btnSuaDiem))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoaDiem)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDiemActionPerformed
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            String k=entry.getKey();
            int v=entry.getValue();
            Orderdetail tv = new Orderdetail();
                tv.setOrder_id(cbb_order_id.getSelectedItem().toString());                
                tv.setProduct_id(k);
                tv.setQuanity(v);
                bus.them(tv);
            
        }
                JOptionPane.showMessageDialog(rootPane, "Đã thêm");
                tbl_orderdetail.setModel(model);
                showD();
    }//GEN-LAST:event_btnThemDiemActionPerformed

    private void btnSuaDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDiemActionPerformed
        int i = tbl_orderdetail.getSelectedRow();
        String dk=(tbl_orderdetail.getValueAt(i, 0).toString());
        String dk1=(tbl_orderdetail.getValueAt(i, 1).toString());
        Orderdetail tv = new Orderdetail();
        model.setValueAt(tv.getQuanity(), i, 2); 
        bus.sua(tv,dk,dk1);
        JOptionPane.showMessageDialog(rootPane, "Đã cập nhật");
        showD();
    }//GEN-LAST:event_btnSuaDiemActionPerformed

    private void btnXoaDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDiemActionPerformed
        int i = tbl_orderdetail.getSelectedRow();
       
        Orderdetail tv = bus.dsd.get(i);
        int option = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
            if(option == 0){
            bus.xoa(tv);
            if (bus.dsd.remove(i) == null) {
            model.removeRow(i);
            }
            tbl_orderdetail.setModel(model);
        showD();
        }
    }//GEN-LAST:event_btnXoaDiemActionPerformed

    private void tbl_orderdetailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_orderdetailKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_orderdetailKeyPressed

    private void tbl_orderdetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_orderdetailMouseClicked

    }//GEN-LAST:event_tbl_orderdetailMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Order_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order_Detail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaDiem;
    private javax.swing.JButton btnThemDiem;
    private javax.swing.JButton btnXoaDiem;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JComboBox<String> cbb_order_id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_count;
    private javax.swing.JTable tbl_orderdetail;
    private javax.swing.JTable tbl_scan;
    // End of variables declaration//GEN-END:variables
}
