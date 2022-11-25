/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.SanPham;
import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class QLSanPham {
    private UUID IDSP;
    private String tenSP;
    private String moTa;
    private String image;
    private float gia;
    private String trangThai;

    public QLSanPham() {
    }

    public QLSanPham(UUID IDSP, String tenSP, String moTa, String image, float gia, String trangThai) {
        this.IDSP = IDSP;
        this.tenSP = tenSP;
        this.moTa = moTa;
        this.image = image;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    

    public QLSanPham(String tenSP, String moTa, String image, float gia, String trangThai) {
        this.tenSP = tenSP;
        this.moTa = moTa;
        this.image = image;
        this.gia = gia;
        this.trangThai = trangThai;
    }
    

    public UUID getIDSP() {
        return IDSP;
    }

    public void setIDSP(UUID IDSP) {
        this.IDSP = IDSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPhamModel{" + "IDSP=" + IDSP + ", tenSP=" + tenSP + ", moTa=" + moTa + ", image=" + image + ", gia=" + gia + ", trangThai=" + trangThai + '}';
    }

    
}
