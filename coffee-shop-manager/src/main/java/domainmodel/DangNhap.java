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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DangNhap")
public class DangNhap {

    @Id
    private String TenTaiKhoan;
    private String MatKhau;
    private String Quyen;
    @ManyToOne
    @JoinColumn(name = "IdNhanVien", referencedColumnName = "IdNhanVien")
    private NhanVien IdNhanVien;

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void setTenTaiKhoan(String TenTaiKhoan) {
        this.TenTaiKhoan = TenTaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }

    public NhanVien getIdNhanVien() {
        return IdNhanVien;
    }

    public void setIdNhanVien(NhanVien IdNhanVien) {
        this.IdNhanVien = IdNhanVien;
    }

    @Override
    public String toString() {
        return "DangNhap{" + "TenTaiKhoan=" + TenTaiKhoan + ", MatKhau=" + MatKhau + ", Quyen=" + Quyen + ", IdNhanVien=" + IdNhanVien + '}';
    }

    public DangNhap() {
    }

    public DangNhap(String TenTaiKhoan, String MatKhau, String Quyen, NhanVien IdNhanVien) {
        this.TenTaiKhoan = TenTaiKhoan;
        this.MatKhau = MatKhau;
        this.Quyen = Quyen;
        this.IdNhanVien = IdNhanVien;
    }

}
