/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author vutuo
 */
@Entity
@Table(name = "BanChiTiet")
public class BanChiTiet implements Serializable {
    @Id
    private int idBanChiTiet;
    @ManyToOne
    @JoinColumn(name = "soBan", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Ban soBan;
    @ManyToOne
    @JoinColumn(columnDefinition = "uniqueidentifier", name = "IDHoaDon", nullable = false)
    private HoaDon IDHoaDon;

    public BanChiTiet() {
    }

    public BanChiTiet(int idBanChiTiet, Ban soBan, HoaDon IDHoaDon) {
        this.idBanChiTiet = idBanChiTiet;
        this.soBan = soBan;
        this.IDHoaDon = IDHoaDon;
    }

    public int getIdBanChiTiet() {
        return idBanChiTiet;
    }

    public void setIdBanChiTiet(int idBanChiTiet) {
        this.idBanChiTiet = idBanChiTiet;
    }

    public Ban getSoBan() {
        return soBan;
    }

    public void setSoBan(Ban soBan) {
        this.soBan = soBan;
    }

    public HoaDon getIDHoaDon() {
        return IDHoaDon;
    }

    public void setIDHoaDon(HoaDon IDHoaDon) {
        this.IDHoaDon = IDHoaDon;
    }

  
 
}
