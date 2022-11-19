/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import domainmodel.NhanVien;
import java.util.UUID;
import java.util.stream.Collectors;
import repository.NhanVienRepository;
import service.IQlyNhanVien;
import viewmodel.NhanVienModel;

/**
 *
 * @author Admin
 */
public class QlyNhanVienImpl implements IQlyNhanVien {

    @Override
    public ArrayList<NhanVienModel> getAllStaff() {
        return (ArrayList<NhanVienModel>) new NhanVienRepository().getAll().stream().map(NhanVienModel::new).collect(Collectors.toList());
    }

    @Override
    public boolean Save(NhanVien Staff) {
        return new QlyNhanVienImpl().Save(Staff);
    }

    @Override
    public boolean Update(UUID Id, NhanVien Staff) {
        return new QlyNhanVienImpl().Update(Id, Staff);
    }

    @Override
    public boolean Delete(UUID Id) {
        return new QlyNhanVienImpl().Delete(Id);
    }

}
