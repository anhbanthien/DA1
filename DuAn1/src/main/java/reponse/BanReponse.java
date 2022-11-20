/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reponse;

import domainmodel.Ban;

/**
 *
 * @author vutuo
 */
public class BanReponse {
    private int soBan;
    private String trangThaiBan;
    private int soBanGhep;

    public BanReponse() {
    }

    public BanReponse(Ban ban) {
        this.soBan = ban.getSoBan();
        this.trangThaiBan = ban.getTrangThaiBan();
        this.soBanGhep = ban.getSoBanGhep();
    }

    public int getSoBan() {
        return soBan;
    }

    public void setSoBan(int soBan) {
        this.soBan = soBan;
    }

    public String getTrangThaiBan() {
        return trangThaiBan;
    }

    public void setTrangThaiBan(String trangThaiBan) {
        this.trangThaiBan = trangThaiBan;
    }

    public int getSoBanGhep() {
        return soBanGhep;
    }

    public void setSoBanGhep(int soBanGhep) {
        this.soBanGhep = soBanGhep;
    }



    public Object[] toRowData(){
    return new Object[]{soBan, trangThaiBan, soBanGhep};
    }

    @Override
    public String toString() {
        return "BanReponse{" + "soBan=" + soBan + ", trangThaiBan=" + trangThaiBan + ", soBanGhep=" + soBanGhep + '}';
    }
    
}
