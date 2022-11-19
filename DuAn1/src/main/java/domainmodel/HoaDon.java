/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author hungn
 */
@Entity
@Table(name = "HoaDon")
public class HoaDon {

    @Id
    @Column(columnDefinition = "uniqueidentifier")
    @GeneratedValue
    private UUID IDHD;
    @ManyToOne
    @JoinColumn(name = "IDNV")
    private NhanVien IDNV;
    @ManyToOne
    @JoinColumn(name = "IDKH")
    private KhachHang IDKH;
    @ManyToOne
    @JoinColumn(name = "IDKM")
    private KhuyenMai IDKM;

    private String NgayTao;
    private String NgayTT;
    private float TienTra;
    private float TongTien;
    private String TrangThai;

    public HoaDon() {
    }

    public HoaDon(UUID IDHD, NhanVien IDNV, KhachHang IDKH, KhuyenMai IDKM, String NgayTao, String NgayTT, float TienTra, float TongTien, String TrangThai) {
        this.IDHD = IDHD;
        this.IDNV = IDNV;
        this.IDKH = IDKH;
        this.IDKM = IDKM;
        this.NgayTao = NgayTao;
        this.NgayTT = NgayTT;
        this.TienTra = TienTra;
        this.TongTien = TongTien;
        this.TrangThai = TrangThai;
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
        return "HoaDon{" + "IDHD=" + IDHD + ", IDNV=" + IDNV + ", IDKH=" + IDKH + ", IDKM=" + IDKM + ", NgayTao=" + NgayTao + ", NgayTT=" + NgayTT + ", TienTra=" + TienTra + ", TongTien=" + TongTien + ", TrangThai=" + TrangThai + '}';
    }

}
