/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.KhachHang;
import java.util.UUID;
import javax.persistence.Column;

/**
 *
 * @author vanlo
 */
public class KhachHangModel {
    private UUID id;
    private String Ten;
    private String DiemTichLuy;
    private String SoDienThoai;
    private String TrangThai;

    public KhachHangModel() {
    }
    public KhachHangModel(KhachHang khachHang) {
        this.id = khachHang.getId();
        this.Ten = khachHang.getTen();
        this.DiemTichLuy = khachHang.getDiemTichLuy();
        this.SoDienThoai = khachHang.getSoDienThoai();
        this.TrangThai = khachHang.getTrangThai();
    }

    public KhachHangModel(UUID id, String Ten, String DiemTichLuy, String SoDienThoai, String TrangThai) {
        this.id = id;
        this.Ten = Ten;
        this.DiemTichLuy = DiemTichLuy;
        this.SoDienThoai = SoDienThoai;
        this.TrangThai = TrangThai;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getDiemTichLuy() {
        return DiemTichLuy;
    }

    public void setDiemTichLuy(String DiemTichLuy) {
        this.DiemTichLuy = DiemTichLuy;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
