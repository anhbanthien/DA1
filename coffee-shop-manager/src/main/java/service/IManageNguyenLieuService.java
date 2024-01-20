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

    List<QLNguyenLieu> getByCT(UUID idCT);

    QLNguyenLieu getOne(UUID idNL);

    QLNguyenLieu getOneByTen(String tenNL);

    boolean add(QLNguyenLieu qlnl);

    boolean update(UUID idNL, QLNguyenLieu qlnl);

    boolean delete(UUID idNL);
}
