/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author trong
 */
@Entity
@Table(name = "HDCT")
public class HoaDonChiTiet {
    @Id
    @Column(name = "IDHDCT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID idHDCT;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDHD", referencedColumnName = "IDHD")
    private HoaDon hoaDon;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDSP", referencedColumnName = "IDSP")
    private SanPham sanPham;
    
    @Column(name = "SoLuong")
    private int soLuong;
    
    @Column(name = "SoBanCT")
    private int soBanCT;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(UUID idHDCT, HoaDon hoaDon, SanPham sanPham, int soLuong, int soBanCT) {
        this.idHDCT = idHDCT;
        this.hoaDon = hoaDon;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.soBanCT = soBanCT;
    }

    public UUID getIdHDCT() {
        return idHDCT;
    }

    public void setIdHDCT(UUID idHDCT) {
        this.idHDCT = idHDCT;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getSoBanCT() {
        return soBanCT;
    }

    public void setSoBanCT(int soBanCT) {
        this.soBanCT = soBanCT;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "idHDCT=" + idHDCT + ", hoaDon=" + hoaDon + ", sanPham=" + sanPham + ", soLuong=" + soLuong + ", soBanCT=" + soBanCT + '}';
    }
    
}
