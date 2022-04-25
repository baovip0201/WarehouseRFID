/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author MSI GF
 */
public class PODetail {
    private int pOid;
    private int itemCode;
    private int qty;
    private int gate;
    private Date dateTime;

    public PODetail(int pOid, int itemCode, int qty, int gate, Date dateTime) {
        this.pOid = pOid;
        this.itemCode = itemCode;
        this.qty = qty;
        this.gate = gate;
        this.dateTime = dateTime;
    }

    public PODetail() {
    }

    public int getpOid() {
        return pOid;
    }

    public void setpOid(int pOid) {
        this.pOid = pOid;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    
    
}
