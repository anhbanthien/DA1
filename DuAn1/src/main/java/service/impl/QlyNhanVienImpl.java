/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import model.NhanVien;
import repository.NhanVienRepository;
import service.IQlyNhanVien;

/**
 *
 * @author Admin
 */
public class QlyNhanVienImpl implements IQlyNhanVien{

    @Override
    public ArrayList<NhanVien> getAllStaff() {
        return (ArrayList<NhanVien>) new NhanVienRepository().getAll();
    }
    
}
