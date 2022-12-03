/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import java.util.UUID;

/**
 *
 * @author trong
 */
public class QLNguyenLieu {
    private UUID idNL;
    private String tenNL;
    private int soLuong;
    private String dvt;
    private String ngayNhap;
    private int hsd;
    private UUID idCT;

    public QLNguyenLieu() {
    }

    public QLNguyenLieu(UUID idNL, String tenNL, int soLuong, String dvt, String ngayNhap, int hsd, UUID idCT) {
        this.idNL = idNL;
        this.tenNL = tenNL;
        this.soLuong = soLuong;
        this.dvt = dvt;
        this.ngayNhap = ngayNhap;
        this.hsd = hsd;
        this.idCT = idCT;
    }

    public QLNguyenLieu(String tenNL, int soLuong, String dvt, String ngayNhap, int hsd) {
        this.tenNL = tenNL;
        this.soLuong = soLuong;
        this.dvt = dvt;
        this.ngayNhap = ngayNhap;
        this.hsd = hsd;
    }

    public UUID getIdNL() {
        return idNL;
    }

    public void setIdNL(UUID idNL) {
        this.idNL = idNL;
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

    public UUID getIdCT() {
        return idCT;
    }

    public void setIdCT(UUID idCT) {
        this.idCT = idCT;
    }

    @Override
    public String toString() {
        return "QLNguyenLieu{" + "idNL=" + idNL + ", tenNL=" + tenNL + ", soLuong=" + soLuong + ", dvt=" + dvt + ", ngayNhap=" + ngayNhap + ", hsd=" + hsd + ", idCT=" + idCT + '}';
    }

    
}
