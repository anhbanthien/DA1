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
    private int IDB;
    private String trangThaiBan;

    public Ban() {
    }

    public Ban(String trangThaiBan) {
        this.IDB = IDB;
    }

    public int getIDB() {
        return IDB;
    }

    public void setIDB(int IDB) {
        this.IDB = IDB;
    }

    public String getTrangThaiBan() {
        return trangThaiBan;
    }

    public void setTrangThaiBan(String trangThaiBan) {
        this.trangThaiBan = trangThaiBan;
    }

    @Override
    public String toString() {
        return "Ban{" + "IDB=" + IDB + ", trangThaiBan=" + trangThaiBan + '}';
    }

}
