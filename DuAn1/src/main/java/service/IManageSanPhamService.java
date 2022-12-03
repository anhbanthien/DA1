/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import java.util.UUID;
import viewmodel.QLSanPham;

/**
 *
 * @author trong
 */
public interface IManageSanPhamService {

    List<QLSanPham> getAll();

    QLSanPham getOne(UUID id);

    QLSanPham getOneByTen(String ten);

    String add(QLSanPham qlsp);

    String update(UUID id, QLSanPham qlsp);

    String delete(QLSanPham qlsp);

}
