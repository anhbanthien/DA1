/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
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
 * @author trong
 */
@Entity
@Table(name = "NguyenLieu")
public class NguyenLieu implements Serializable {

    @Id
    @Column(columnDefinition = "uniqueidentifier")
    @GeneratedValue
    private UUID IDNL;

    @Column(name = "TenNL")
    private String tenNL;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DVT")
    private String dvt;

    @Column(name = "NgayNhap")
    private String ngayNhap;

    @Column(name = "HSD")
    private int hsd;

    @ManyToOne
    @JoinColumn(name = "IDCT")
    private CongThuc congthuc;

    public NguyenLieu() {
    }

    public NguyenLieu(UUID IDNL, String tenNL, int soLuong, String dvt, String ngayNhap, int hsd, CongThuc congthuc) {
        this.IDNL = IDNL;
        this.tenNL = tenNL;
        this.soLuong = soLuong;
        this.dvt = dvt;
        this.ngayNhap = ngayNhap;
        this.hsd = hsd;
        this.congthuc = congthuc;
    }

    public UUID getIDNL() {
        return IDNL;
    }

    public void setIDNL(UUID IDNL) {
        this.IDNL = IDNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getHsd() {
        return hsd;
    }

    public void setHsd(int hsd) {
        this.hsd = hsd;
    }

    public CongThuc getCongthuc() {
        return congthuc;
    }

    public void setCongthuc(CongThuc congthuc) {
        this.congthuc = congthuc;
    }

    @Override
    public String toString() {
        return "NguyenLieu{" + "IDNL=" + IDNL + ", tenNL=" + tenNL + ", soLuong=" + soLuong + ", dvt=" + dvt + ", ngayNhap=" + ngayNhap + ", hsd=" + hsd + ", congthuc=" + congthuc + '}';
    }

    
}
