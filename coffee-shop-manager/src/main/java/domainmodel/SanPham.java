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
    private UUID IDSP;

    private String TenSP;

    private String MoTa;

    private String Image;

    private float Gia;

    private int TrangThai;

    public SanPham() {
    }

    public SanPham(UUID IDSP, String TenSP, String MoTa, String Image, float Gia, int TrangThai) {
        this.IDSP = IDSP;
        this.TenSP = TenSP;
        this.MoTa = MoTa;
        this.Image = Image;
        this.Gia = Gia;
        this.TrangThai = TrangThai;
    }

    public UUID getIDSP() {
        return IDSP;
    }

    public void setIDSP(UUID IDSP) {
        this.IDSP = IDSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public float getGia() {
        return Gia;
    }

    public void setGia(float Gia) {
        this.Gia = Gia;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

 

   
}
