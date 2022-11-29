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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author trong
 */
@Entity
@Table(name = "CongThuc")
public class CongThuc {

    @Id
    @Column(columnDefinition = "uniqueidentifier")
    @GeneratedValue
    private UUID idCT;

    @OneToOne
    @JoinColumn(name = "IDSP", referencedColumnName = "IDSP")
    private SanPham sanPham;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "Mota")
    private String moTa;
    @Column(name = "Image")
    private String image;
    @Column(name = "TrangThai")
    private String trangThai;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMaNL", referencedColumnName = "MaNL")
    private NguyenLieu nguyenLieu;

    public CongThuc() {
    }

    public CongThuc(UUID idCT, SanPham sanPham, String ten, String moTa, String image, String trangThai, NguyenLieu nguyenLieu) {
        this.idCT = idCT;
        this.sanPham = sanPham;
        this.ten = ten;
        this.moTa = moTa;
        this.image = image;
        this.trangThai = trangThai;
        this.nguyenLieu = nguyenLieu;
    }

    public UUID getIdCT() {
        return idCT;
    }

    public void setIdCT(UUID idCT) {
        this.idCT = idCT;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }

    @Override
    public String toString() {
        return "CongThuc{" + "idCT=" + idCT + ", sanPham=" + sanPham + ", ten=" + ten + ", moTa=" + moTa + ", image=" + image + ", trangThai=" + trangThai + ", nguyenLieu=" + nguyenLieu + '}';
    }

    
    
    

}
