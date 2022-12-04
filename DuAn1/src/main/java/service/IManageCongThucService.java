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

/**
 *
 * @author trong
 */
public interface IManageCongThucService {

    List<QLCongThuc> getAll();

    QLCongThuc getOne(UUID idCT);

    QLCongThuc getOneByTen(String ten);
    
    String add(QLCongThuc qlct);

    String update(UUID idCT, QLCongThuc qlct);

    String delete(QLCongThuc qlct);
}
