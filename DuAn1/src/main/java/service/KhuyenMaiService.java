/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.KhuyenMaiModel;

/**
 *
 * @author hungn
 */
public interface KhuyenMaiService {

    List<KhuyenMaiModel> getAll();

    String Save(KhuyenMaiModel khuyenMai);

    String Update(KhuyenMaiModel khuyenMai, String MaKM);

    String Delete(KhuyenMaiModel khuyenMai);
}
