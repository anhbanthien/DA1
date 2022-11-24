/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author trong
 */
@Entity
@Table(name = "NguyenLieu")
public class NguyenLieu implements Serializable{
    
    @Id
    @Column(name = "MaNL")
    private String maNL;
    
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

    public NguyenLieu() {
    }

    public NguyenLieu(String maNL, String tenNL, int soLuong, String dvt, String ngayNhap, int hsd) {
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.soLuong = soLuong;
        this.dvt = dvt;
        this.ngayNhap = ngayNhap;
        this.hsd = hsd;
    }

    public String getMaNL() {
        return maNL;
    }

    public void setMaNL(String maNL) {
        this.maNL = maNL;
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

    @Override
    public String toString() {
        return "NguyenLieu{" + "maNL=" + maNL + ", tenNL=" + tenNL + ", soLuong=" + soLuong + ", dvt=" + dvt + ", ngayNhap=" + ngayNhap + ", hsd=" + hsd + '}';
    }

    

    
    
    
}
