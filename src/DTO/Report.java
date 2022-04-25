/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author MSI
 */
public class Report {
    private String order_id;
    private String product_id;
    private String product_name;
    private int quanity;

    public Report() {
    }

    
    public Report(String order_id, String product_id, String product_name, int quanity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.quanity = quanity;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }
    
}
