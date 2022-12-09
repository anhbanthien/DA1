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
    private String trangThai;

    public QLCongThuc() {
    }

    public QLCongThuc(UUID idCT, UUID idSP, String ten, String moTa, String trangThai) {
        this.idCT = idCT;
        this.idSP = idSP;
        this.ten = ten;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public QLCongThuc(UUID idSP, String ten, String moTa, String image, String trangThai) {
        this.idSP = idSP;
        this.ten = ten;
        this.moTa = moTa;
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

  

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "QLCongThuc{" + "idCT=" + idCT + ", idSP=" + idSP + ", ten=" + ten + ", moTa=" + moTa + ", trangThai=" + trangThai + '}';
    }

    
    
}
