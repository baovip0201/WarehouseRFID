/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author MSI GF
 */
public class Item {
    private int itemCode;
    private String name;

    public Item(int ItemCode, String Name) {
        this.itemCode = ItemCode;
        this.name = Name;
    }

    public Item() {
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int ItemCode) {
        this.itemCode = ItemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }
    
    
}
