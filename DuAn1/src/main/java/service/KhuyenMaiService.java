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

    boolean Save(KhuyenMaiModel khuyenMai);

    boolean Update(KhuyenMaiModel km, String MaKM);

    boolean Delete(KhuyenMaiModel khuyenMai);
}
