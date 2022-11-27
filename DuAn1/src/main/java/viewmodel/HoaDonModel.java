/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.Ban;
import java.util.UUID;
import domainmodel.HoaDon;
import domainmodel.KhachHang;
import domainmodel.KhuyenMai;
import domainmodel.NhanVien;

/**
 *
 * @author hungn
 */
public class HoaDonModel {

    private UUID IDHD;
    private NhanVien IDNV;
    private KhachHang IDKH;
    private KhuyenMai IDKM;
    private Ban IDB;
    private String NgayTao;
    private String NgayTT;
    private float TienTra;
    private float TongTien;
    private String TrangThai;

    public HoaDonModel() {
    }

    public HoaDonModel(HoaDon hoadon) {
        this.IDHD = hoadon.getIDHD();
        this.IDKH = hoadon.getIDKH();
        this.IDNV = hoadon.getIDNV();
        this.IDKM = hoadon.getIDKM();

        this.NgayTao = hoadon.getNgayTao();
        this.NgayTT = hoadon.getNgayTT();
        this.TienTra = hoadon.getTienTra();
        this.TongTien = hoadon.getTongTien();
        this.TrangThai = hoadon.getTrangThai();
    }

    public UUID getIDHD() {
        return IDHD;
    }

    public void setIDHD(UUID IDHD) {
        this.IDHD = IDHD;
    }

    public NhanVien getIDNV() {
        return IDNV;
    }

    public void setIDNV(NhanVien IDNV) {
        this.IDNV = IDNV;
    }

    public KhachHang getIDKH() {
        return IDKH;
    }

    public void setIDKH(KhachHang IDKH) {
        this.IDKH = IDKH;
    }

    public KhuyenMai getIDKM() {
        return IDKM;
    }

    public void setIDKM(KhuyenMai IDKM) {
        this.IDKM = IDKM;
    }

    public Ban getIDB() {
        return IDB;
    }

    public void setIDB(Ban IDB) {
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

}
