/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.NhanVien;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import viewmodel.KhachHangModel;
import viewmodel.NhanVienModel;

/**
 *
 * @author vanlo
 */
public interface KhachHangService {
    List<KhachHangModel> getAll();

    boolean Save(KhachHangModel khachHang);

    boolean Update(KhachHangModel khachHang);

    boolean Delete(KhachHangModel khachHang);
}
