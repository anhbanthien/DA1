/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SanPham")
public class SanPham {

    @Id
    @Column(columnDefinition = "uniqueidentifier")
    @GeneratedValue
    private UUID idSP;

    @Column(name = "TenSP")
    private String tenSP;

    @Column(name = "Mota")
    private String moTa;

    @Column(name = "Image")
    private String image;

    @Column(name = "Gia")
    private BigDecimal gia;

    @Column(name = "TrangThai")
    private String trangThai;

    public SanPham() {
    }

    public SanPham(UUID idSP, String tenSP, String moTa, String image, BigDecimal gia, String trangThai) {
        this.idSP = idSP;
        this.tenSP = tenSP;
        this.moTa = moTa;
        this.image = image;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public UUID getIdSP() {
        return idSP;
    }

    public void setIdSP(UUID idSP) {
        this.idSP = idSP;
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

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
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
        return "SanPham{" + "idSP=" + idSP + ", tenSP=" + tenSP + ", moTa=" + moTa + ", image=" + image + ", gia=" + gia + ", trangThai=" + trangThai + '}';
    }
}
