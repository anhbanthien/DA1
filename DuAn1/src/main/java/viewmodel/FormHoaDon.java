/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.Ban;
import domainmodel.HoaDon;
import domainmodel.KhachHang;
import domainmodel.KhuyenMai;
import domainmodel.NhanVien;
import domainmodel.SanPham;
import java.util.UUID;

/**
 *
 * @author hungn
 */
public class FormHoaDon {

    private UUID IDHD;
    private String HoTen;
    private String Ten;
    private String SoDienThoai;
    private float PhanTramKM;
    private int IDB;
    private String NgayTao;
    private String NgayTT;
    private float TienTra;
    private float TongTien;
    private String TrangThai;
    private String tenSP;
    private float Gia;
    private String moTa;

    public FormHoaDon() {
    }

    public FormHoaDon(HoaDon hoaDon) {
        this.IDHD = hoaDon.getIDHD();
        this.HoTen = hoaDon.getIDNV().getHoTen();
        this.Ten = hoaDon.getIDKH().getTen();
        this.SoDienThoai = hoaDon.getIDKH().getSoDienThoai();
        this.PhanTramKM = hoaDon.getIDKM().getPhanTramKM();
        this.IDB = hoaDon.getIDB().getIDB();
        this.NgayTao = hoaDon.getNgayTao();
        this.NgayTT = hoaDon.getNgayTT();
        this.TienTra = hoaDon.getTienTra();
        this.TongTien = hoaDon.getTongTien();
        this.TrangThai = hoaDon.getTrangThai();
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

    public float getPhanTramKM() {
        return PhanTramKM;
    }

    public void setPhanTramKM(float PhanTramKM) {
        this.PhanTramKM = PhanTramKM;
    }

    public int getIDB() {
        return IDB;
    }

    public void setIDB(int IDB) {
        this.IDB = IDB;
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

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public Object[] toData1() {
        return new Object[]{IDHD, IDB, HoTen, NgayTao, TongTien, TrangThai};
    }

    public Object[] toData2() {
        return new Object[]{IDHD, HoTen, Ten, IDB, NgayTao, NgayTT, TongTien, TrangThai};
    }

}
