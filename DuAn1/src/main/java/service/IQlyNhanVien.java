/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import domainmodel.NhanVien;
import java.util.UUID;
import viewmodel.NhanVienModel;

/**
 *
 * @author Admin
 */
public interface IQlyNhanVien {

    ArrayList<NhanVienModel> getAllStaff();

    boolean Save(NhanVien Staff);
    boolean Update(UUID Id ,NhanVien Staff);
    boolean Delete(UUID Id);

}
