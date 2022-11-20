/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reponse;

import java.util.UUID;
import domainmodel.BanChiTiet;

/**
 *
 * @author vutuo
 */
public class BanChiTietReponse {

    private int idBanChiTiet;
    private int soBan;
    private UUID idHoaDon;

    public BanChiTietReponse() {
    }

    public BanChiTietReponse(BanChiTiet bct) {
        this.idBanChiTiet = bct.getIdBanChiTiet();
        this.soBan = bct.getSoBan().getSoBan();
        this.idHoaDon = bct.getIDHoaDon().getIDHD();
    }

    public int getIdBanChiTiet() {
        return idBanChiTiet;
    }

    public void setIdBanChiTiet(int idBanChiTiet) {
        this.idBanChiTiet = idBanChiTiet;
    }

    public int getSoBan() {
        return soBan;
    }

    public void setSoBan(int soBan) {
        this.soBan = soBan;
    }

    public UUID getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(UUID idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    @Override
    public String toString() {
        return "BanChiTietReponse{" + "idBanChiTiet=" + idBanChiTiet + ", soBan=" + soBan + ", idHoaDon=" + idHoaDon + '}';
    }

    public Object[] toRowData() {
        return new Object[]{idBanChiTiet, soBan, idHoaDon};
    }
}
