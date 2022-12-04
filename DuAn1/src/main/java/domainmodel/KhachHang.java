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

@Entity
@Table(name = "KhachHang")
public class KhachHang {

    @Id
    @Column(columnDefinition = "uniqueidentifier")
    @GeneratedValue
    private UUID IdKhachHang;
    @Column(name = "Ten")
    private String Ten;
    @Column(name = "DiemTichLuy")
    private int DiemTichLuy;
    @Column(name = "SoDienThoai")
    private String SoDienThoai;
    @Column(name = "TrangThai")
    private String TrangThai;

    public KhachHang(UUID id, String Ten, int DiemTichLuy, String SoDienThoai, String TrangThai) {
        this.IdKhachHang = id;
        this.Ten = Ten;
        this.DiemTichLuy = DiemTichLuy;
        this.SoDienThoai = SoDienThoai;
        this.TrangThai = TrangThai;
    }

    public KhachHang(KhachHangModel khachHang) {
        this.IdKhachHang = khachHang.getId();
        this.Ten = khachHang.getTen();
        this.DiemTichLuy = khachHang.getDiemTichLuy();
        this.SoDienThoai = khachHang.getSoDienThoai();
        this.TrangThai = khachHang.getTrangThai();
    }

    public KhachHang() {
    }

    public UUID getId() {
        return IdKhachHang;
    }

    public void setId(UUID id) {
        this.IdKhachHang = id;
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
