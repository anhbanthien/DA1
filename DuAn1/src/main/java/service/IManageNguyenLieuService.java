/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import java.util.UUID;
import viewmodel.QLNguyenLieu;
import viewmodel.QLSanPham;

/**
 *
 * @author trong
 */
public interface IManageNguyenLieuService {
    List<QLNguyenLieu> getAll();

    QLNguyenLieu getOne(String maNL);

    String add(QLNguyenLieu qlnl);

    String update(String maNL, QLNguyenLieu qlnl);

    String delete(QLNguyenLieu qlnl);
}
