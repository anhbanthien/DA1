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
import java.sql.Date;

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
    private Date NgayTao;
    private Date NgayTT;
    private float TienTra;
    private float TongTien;
    private String TrangThai;
    private String Ten;
    private String SoDienThoai;
    private float PhanTramKM;
    private String HoTen;

    public HoaDonModel() {
    }

    public HoaDonModel(HoaDon hoadon) {
        this.IDHD = hoadon.getIDHD();
        this.IDKH = hoadon.getIDKH();
        this.IDNV = hoadon.getIDNV();
        this.IDKM = hoadon.getIDKM();
        this.IDB = hoadon.getIDB();
        this.NgayTao = hoadon.getNgayTao();
        this.NgayTT = hoadon.getNgayTT();
        this.TienTra = hoadon.getTienTra();
        this.TongTien = hoadon.getTongTien();
        this.TrangThai = hoadon.getTrangThai();

        if (hoadon.getIDKH() != null) {
            this.Ten = hoadon.getIDKH().getTen();
            this.SoDienThoai = hoadon.getIDKH().getSoDienThoai();
            this.HoTen = hoadon.getIDNV().getHoTen();
        }

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

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public float getPhanTramKM() {
        return PhanTramKM;
    }

    public void setPhanTramKM(float PhanTramKM) {
        this.PhanTramKM = PhanTramKM;
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

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Date getNgayTT() {
        return NgayTT;
    }

    public void setNgayTT(Date NgayTT) {
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
        return "HoaDonModel{" + "IDHD=" + IDHD + ", IDNV=" + IDNV + ", IDKH=" + IDKH + ", IDKM=" + IDKM + ", IDB=" + IDB + ", NgayTao=" + NgayTao + ", NgayTT=" + NgayTT + ", TienTra=" + TienTra + ", TongTien=" + TongTien + ", TrangThai=" + TrangThai + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{IDHD, HoTen, NgayTao, TongTien, TrangThai};
    }
}
