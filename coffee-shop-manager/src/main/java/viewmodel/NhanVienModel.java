/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.NhanVien;
import java.util.UUID;

public class NhanVienModel {

    private UUID IdNhanVien;
    private String HoTen;
    private String Email;
    private String SDT;
    private String GioiTinh;
    private String TrangThai;
    private String Image;
    private String MaNhanVien;

    public NhanVienModel() {
    }

    public NhanVienModel(NhanVien staff) {
        this.IdNhanVien = staff.getIdNhanVien();
        this.HoTen = staff.getHoTen();
        this.Email = staff.getEmail();
        this.SDT = staff.getSDT();
        this.GioiTinh = staff.getGioiTinh();
        this.TrangThai = staff.getTrangThai();
        this.Image = staff.getImage();
        this.MaNhanVien = staff.getMaNhanVien();
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public UUID getIdNhanVien() {
        return IdNhanVien;
    }

    public void setIdNhanVien(UUID IdNhanVien) {
        this.IdNhanVien = IdNhanVien;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    @Override
    public String toString() {
        return "NhanVienModel{" + "IdNhanVien=" + IdNhanVien + ", HoTen=" + HoTen + ", Email=" + Email + ", SDT=" + SDT + ", GioiTinh=" + GioiTinh + ", TrangThai=" + TrangThai + ", Image=" + Image + '}';
    }

}
