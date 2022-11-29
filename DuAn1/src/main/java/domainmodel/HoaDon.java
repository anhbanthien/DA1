package domainmodel;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import domainmodel.Ban;
import viewmodel.HoaDonModel;

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
    @ManyToOne
    @JoinColumn(name = "IDB")
    private Ban IDB;
    private String NgayTao;
    private String NgayTT;
    private float TienTra;
    private float TongTien;
    private String TrangThai;

    public HoaDon() {
    }

    public HoaDon(UUID IDHD) {
        this.IDHD = IDHD;
    }

    public HoaDon(Ban IDB, UUID IDHD, NhanVien IDNV, KhachHang IDKH, KhuyenMai IDKM, String NgayTao, String NgayTT, float TienTra, float TongTien, String TrangThai) {
        this.IDHD = IDHD;
        this.IDNV = IDNV;
        this.IDKH = IDKH;
        this.IDKM = IDKM;
        this.NgayTao = NgayTao;
        this.NgayTT = NgayTT;
        this.TienTra = TienTra;
        this.TongTien = TongTien;
        this.TrangThai = TrangThai;
        this.IDB = IDB;
    }

    public HoaDon(HoaDonModel hoadon) {
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

    public Ban getIDB() {
        return IDB;
    }

    public void setIDB(Ban IDB) {
        this.IDB = IDB;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "IDHD=" + IDHD + ", IDNV=" + IDNV + ", IDKH=" + IDKH + ", IDKM=" + IDKM + ", IDB=" + IDB + ", NgayTao=" + NgayTao + ", NgayTT=" + NgayTT + ", TienTra=" + TienTra + ", TongTien=" + TongTien + ", TrangThai=" + TrangThai + '}';
    }
    
}
