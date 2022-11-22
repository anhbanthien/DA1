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
    private String NgayBatDau;
    private String NgayKetThuc;
    private String PhanTramKM;
    private String TrangThai;

    public KhuyenMai() {
    }

    public KhuyenMai(UUID IDKM, String NgayBatDau, String NgayKetThuc, String PhanTramKM, String TrangThai) {
        this.IDKM = IDKM;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.PhanTramKM = PhanTramKM;
        this.TrangThai = TrangThai;
    }

    public UUID getIDKM() {
        return IDKM;
    }

    public void setIDKM(UUID IDKM) {
        this.IDKM = IDKM;
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

    public String getPhanTramKM() {
        return PhanTramKM;
    }

    public void setPhanTramKM(String PhanTramKM) {
        this.PhanTramKM = PhanTramKM;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "IDKM=" + IDKM + ", NgayBatDau=" + NgayBatDau + ", NgayKetThuc=" + NgayKetThuc + ", PhanTramKM=" + PhanTramKM + ", TrangThai=" + TrangThai + '}';
    }

}
