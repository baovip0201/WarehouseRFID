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
public class TagRefItem {
    private String tag;
    private int itemCode;

    public TagRefItem() {
    }

    public TagRefItem(String tag, int itemCode) {
        this.tag = tag;
        this.itemCode = itemCode;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }
    
    
}
