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

    private int IDB;
    private String trangThaiBan;

    public BanReponse() {
    }

    public BanReponse(Ban ban) {
        this.IDB = ban.getIDB();
        this.trangThaiBan = ban.getTrangThaiBan();
    }

    public int getIDB() {
        return IDB;
    }

    public void setIDB(int IDB) {
        this.IDB = IDB;
    }

    public String getTrangThaiBan() {
        return trangThaiBan;
    }

    public void setTrangThaiBan(String trangThaiBan) {
        this.trangThaiBan = trangThaiBan;
    }

    public Object[] toRowData() {
        return new Object[]{IDB, trangThaiBan};
    }

}
