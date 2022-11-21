/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.UUID;
import domainmodel.HoaDon;
import java.util.Date;

/**
 *
 * @author hungn
 */
public class HoaDonModel {

    private UUID IDHD;
    private UUID IDKH;
    private String HoTen;
    private String Ten;
    private String PhanTramKM;
    private String NgayTao;
    private String NgayTT;
    private float TienTra;
    private float TongTien;
    private String TrangThai;

    public HoaDonModel() {
    }

    public HoaDonModel(HoaDon hoadon) {
        this.IDHD = hoadon.getIDHD();
        this.IDKH = hoadon.getIDKH().getId();
        this.HoTen = hoadon.getIDNV().getHoTen();
        this.Ten = hoadon.getIDKH().getTen();
        this.PhanTramKM = hoadon.getIDKM().getPhanTramKM();
        this.NgayTao = hoadon.getNgayTao();
        this.NgayTT = hoadon.getNgayTT();
        this.TienTra = hoadon.getTienTra();
        this.TongTien = hoadon.getTongTien();
        this.TrangThai = hoadon.getTrangThai();
    }

    public UUID getIDKH() {
        return IDKH;
    }

    public void setIDKH(UUID IDKH) {
        this.IDKH = IDKH;
    }

    public UUID getIDHD() {
        return IDHD;
    }

    public void setIDHD(UUID IDHD) {
        this.IDHD = IDHD;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getPhanTramKM() {
        return PhanTramKM;
    }

    public void setPhanTramKM(String PhanTramKM) {
        this.PhanTramKM = PhanTramKM;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getNgayTT() {
        return NgayTT;
    }

    public void setNgayTT(String NgayTT) {
        this.NgayTT = NgayTT;
    }

    public float getTienTra() {
        return TienTra;
    }

    public void setTienTra(float TienTra) {
        this.TienTra = TienTra;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "HoaDonModel{" + "IDHD=" + IDHD + ", HoTen=" + HoTen + ", Ten=" + Ten + ", PhanTramKM=" + PhanTramKM + ", NgayTao=" + NgayTao + ", NgayTT=" + NgayTT + ", TienTra=" + TienTra + ", TongTien=" + TongTien + ", TrangThai=" + TrangThai + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{HoTen, Ten, PhanTramKM, NgayTao, NgayTT, TienTra, TongTien, TrangThai};
    }

}