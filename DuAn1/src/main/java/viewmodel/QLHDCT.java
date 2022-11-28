/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import domainmodel.HDCT;
import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 * @author trong
 */
public class QLHDCT {
    private UUID idHDCT;
    private UUID idHD;
    private UUID idSP;
    private String tenSP;
    private float gia;
    private int soLuong;
    private int soBanCT;

    public QLHDCT(UUID idHD, UUID idSP, int soLuong) {
        this.idHD = idHD;
        this.idSP = idSP;
        this.soLuong = soLuong;
    }

    public QLHDCT(UUID idHD, UUID idSP, double soLuong) {
        this.idHD = idHD;
        this.idSP = idSP;
        this.soLuong = (int) soLuong;
    }

    
    
    
    public float getGia() {
        return gia;
    }
    public float getTien() {
        
        return gia*soLuong;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
    public QLHDCT(HDCT hdct) {
        this.idHDCT = idHDCT;
        this.idHD = idHD;
        this.idSP = idSP;
        this.tenSP = tenSP;
        this.gia = gia;
        this.soLuong = soLuong;
        this.soBanCT = soBanCT;
    }

    public String getTenSP() {
        return tenSP;
    }
    public QLHDCT(UUID idHDCT, UUID idHD, UUID idSP, String tenSP, float gia, int soLuong, int soBanCT) {
        this.idHDCT = idHDCT;
        this.idHD = idHD;
        this.idSP = idSP;
        this.tenSP = tenSP;
        this.gia = gia;
        this.soLuong = soLuong;
        this.soBanCT = soBanCT;
    }
    

    public QLHDCT() {
    }

    public QLHDCT(UUID idHDCT, UUID idHD,String tenSP , UUID idSP, int soLuong, int soBanCT) {
        this.idHDCT = idHDCT;
        this.idHD = idHD;
        this.idSP = idSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.soBanCT = soBanCT;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public UUID getIdHDCT() {
        return idHDCT;
    }

    public void setIdHDCT(UUID idHDCT) {
        this.idHDCT = idHDCT;
    }

    public UUID getIdHD() {
        return idHD;
    }

    public void setIdHD(UUID idHD) {
        this.idHD = idHD;
    }

    public UUID getIdSP() {
        return idSP;
    }

    public void setIdSP(UUID idSP) {
        this.idSP = idSP;
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
        return "QLHDCT{" + "idHDCT=" + idHDCT + ", idHD=" + idHD + ", idSP=" + idSP + ", soLuong=" + soLuong + ", soBanCT=" + soBanCT + '}';
    }
    
    
}
