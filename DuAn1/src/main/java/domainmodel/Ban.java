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
import javax.persistence.Table;

/**
 *
 * @author vutuo
 */
@Entity
@Table(name = "Ban")
public class Ban implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int soBan;
    private String trangThaiBan;
    private int soBanGhep;


    public Ban() {
    }

    public Ban(int soBan) {
        this.soBan = soBan;
    }

    public Ban(String trangThaiBan, int soBanGhep) {
        this.trangThaiBan = trangThaiBan;
        this.soBanGhep = soBanGhep;
    }
    
    public Ban(int soBan, String trangThaiBan, int soBanGhep) {
        this.soBan = soBan;
        this.trangThaiBan = trangThaiBan;
        this.soBanGhep = soBanGhep;
    }

    public int getSoBan() {
        return soBan;
    }

    public void setSoBan(int soBan) {
        this.soBan = soBan;
    }

    public String getTrangThaiBan() {
        return trangThaiBan;
    }

    public void setTrangThaiBan(String trangThaiBan) {
        this.trangThaiBan = trangThaiBan;
    }

    public int getSoBanGhep() {
        return soBanGhep;
    }

    public void setSoBanGhep(int soBanGhep) {
        this.soBanGhep = soBanGhep;
    }

 


   


    
}
