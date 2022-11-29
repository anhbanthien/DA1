/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import java.util.UUID;

/**
 *
 * @author trong
 */
public class QLCongThuc {
    private UUID idCT;
    private UUID idSP;
    private String ten;
    private String moTa;
    private String image;
    private String trangThai;
    private String idMaNL;

    public QLCongThuc() {
    }

    public QLCongThuc(UUID idCT, UUID idSP, String ten, String moTa, String image, String trangThai, String idMaNL) {
        this.idCT = idCT;
        this.idSP = idSP;
        this.ten = ten;
        this.moTa = moTa;
        this.image = image;
        this.trangThai = trangThai;
        this.idMaNL = idMaNL;
    }

    public QLCongThuc(String ten, String moTa, String image, String trangThai) {
        this.ten = ten;
        this.moTa = moTa;
        this.image = image;
        this.trangThai = trangThai;
    }

    public UUID getIdCT() {
        return idCT;
    }

    public void setIdCT(UUID idCT) {
        this.idCT = idCT;
    }

    public UUID getIdSP() {
        return idSP;
    }

    public void setIdSP(UUID idSP) {
        this.idSP = idSP;
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
        this.image = "null";
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdMaNL() {
        return idMaNL;
    }

    public void setIdMaNL(String idMaNL) {
        this.idMaNL = idMaNL;
    }

    @Override
    public String toString() {
        return "QLCongThuc{" + "idCT=" + idCT + ", idSP=" + idSP + ", ten=" + ten + ", moTa=" + moTa + ", image=" + image + ", trangThai=" + trangThai + ", idMaNL=" + idMaNL + '}';
    }
    
    
    
}
