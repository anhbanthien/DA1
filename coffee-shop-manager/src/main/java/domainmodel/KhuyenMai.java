/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.sql.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hungn
 */
@Entity
@Table(name = "KhuyenMai")
public class KhuyenMai {

    @Id
    @Column(columnDefinition = "uniqueidentifier")
    @GeneratedValue
    private UUID IDKM;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private float PhanTramKM;
    private int TrangThai;
    private String MaKM;

    public KhuyenMai() {
    }

    public KhuyenMai(UUID IDKM, Date NgayBatDau, Date NgayKetThuc, float PhanTramKM, int TrangThai, String MaKM) {
        this.IDKM = IDKM;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.PhanTramKM = PhanTramKM;
        this.TrangThai = TrangThai;
        this.MaKM = MaKM;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public UUID getIDKM() {
        return IDKM;
    }

    public void setIDKM(UUID IDKM) {
        this.IDKM = IDKM;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
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
        return "KhuyenMai{" + "IDKM=" + IDKM + ", NgayBatDau=" + NgayBatDau + ", NgayKetThuc=" + NgayKetThuc + ", PhanTramKM=" + PhanTramKM + ", TrangThai=" + TrangThai + '}';
    }

}
