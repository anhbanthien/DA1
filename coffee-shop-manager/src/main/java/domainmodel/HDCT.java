/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
@Table(name = "HDCT")
public class HDCT {
    @Id
    @Column(columnDefinition = "uniqueidentifier")
    @GeneratedValue
    private UUID IDHDCT;
    @ManyToOne
    @JoinColumn(name = "IDHD")
    private HoaDon IDHD;
    @ManyToOne
    @JoinColumn(name = "IDSP")
    private SanPham IDSP;
    private int SoLuong;

    public HDCT() {
    }

    public HDCT(UUID IDHDCT, HoaDon IDHD, SanPham IDSP, int SoLuong) {
        this.IDHDCT = IDHDCT;
        this.IDHD = IDHD;
        this.IDSP = IDSP;
        this.SoLuong = SoLuong;
    }

    public UUID getIDHDCT() {
        return IDHDCT;
    }

    public void setIDHDCT(UUID IDHDCT) {
        this.IDHDCT = IDHDCT;
    }

    public HoaDon getIDHD() {
        return IDHD;
    }

    public void setIDHD(HoaDon IDHD) {
        this.IDHD = IDHD;
    }

    public SanPham getIDSP() {
        return IDSP;
    }

    public void setIDSP(SanPham IDSP) {
        this.IDSP = IDSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "IDHDCT=" + IDHDCT + ", IDHD=" + IDHD + ", IDSP=" + IDSP + ", SoLuong=" + SoLuong + '}';
    }

}
