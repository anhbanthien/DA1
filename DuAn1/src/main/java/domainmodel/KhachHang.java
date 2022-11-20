/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import viewmodel.KhachHangModel;

/**
 *
 * @author vanlo
 */
@Entity
@Table(name = "KhachHang")
public class KhachHang {

    @Id
    @Column(name = "IdKhachHang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name = "Ten")
    private String Ten;
    @Column(name = "DiemTichLuy")
    private int DiemTichLuy;
    @Column(name = "SoDienThoai")
    private String SoDienThoai;
    @Column(name = "TrangThai")
    private String TrangThai;

    public KhachHang(UUID id, String Ten, int DiemTichLuy, String SoDienThoai, String TrangThai) {
        this.id = id;
        this.Ten = Ten;
        this.DiemTichLuy = DiemTichLuy;
        this.SoDienThoai = SoDienThoai;
        this.TrangThai = TrangThai;
    }
    public KhachHang(KhachHangModel khachHang) {
        this.id = khachHang.getId();
        this.Ten = khachHang.getTen();
        this.DiemTichLuy = khachHang.getDiemTichLuy();
        this.SoDienThoai = khachHang.getSoDienThoai();
        this.TrangThai = khachHang.getTrangThai();
    }

    public KhachHang() {
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

    public int getDiemTichLuy() {
        return DiemTichLuy;
    }

    public void setDiemTichLuy(int DiemTichLuy) {
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
