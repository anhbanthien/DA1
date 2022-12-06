/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.KhuyenMai;
import java.util.UUID;

/**
 *
 * @author hungn
 */
public class KhuyenMaiModel {

    private UUID IDKM;
    private String MaKM;
    private String NgayBatDau;
    private String NgayKetThuc;
    private float PhanTramKM;
    private int TrangThai;

    public KhuyenMaiModel() {
    }

    public KhuyenMaiModel(KhuyenMai km) {
        this.IDKM = km.getIDKM();
        this.MaKM = km.getMaKM();
        this.NgayBatDau = km.getNgayBatDau();
        this.NgayKetThuc = km.getNgayKetThuc();
        this.PhanTramKM = km.getPhanTramKM();
        this.TrangThai = km.getTrangThai();
    }

    public UUID getIDKM() {
        return IDKM;
    }

    public void setIDKM(UUID IDKM) {
        this.IDKM = IDKM;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public String getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(String NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public float getPhanTramKM() {
        return PhanTramKM;
    }

    public void setPhanTramKM(float PhanTramKM) {
        this.PhanTramKM = PhanTramKM;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "KhuyenMaiModel{" + "IDKM=" + IDKM + ", MaKM=" + MaKM + ", NgayBatDau=" + NgayBatDau + ", NgayKetThuc=" + NgayKetThuc + ", PhanTramKM=" + PhanTramKM + ", TrangThai=" + TrangThai + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{MaKM, PhanTramKM, NgayBatDau, NgayKetThuc, TrangThai == 1 ? "On" : "Off"};
    }
}
