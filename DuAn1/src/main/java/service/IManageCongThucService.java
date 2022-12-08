/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domainmodel.CongThuc;
import java.util.List;
import java.util.UUID;
import viewmodel.QLCongThuc;
import viewmodel.QLNguyenLieu;
import viewmodel.QLSanPham;

/**
 *
 * @author trong
 */
public interface IManageCongThucService {

    List<QLCongThuc> getAll();

    List<QLCongThuc> getAllBySP(UUID idSP);

    QLCongThuc getOne(UUID idCT);

    QLCongThuc getOneByTen(String ten);

//    QLCongThuc getOneByTen(String ten);
    boolean add(QLCongThuc qlct);

    boolean update(UUID idCT, QLCongThuc qlct);

    boolean delete(UUID idCT);
}
