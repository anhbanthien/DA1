/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domainmodel.SanPham;
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
    
    boolean add(QLSanPham qlsp);

    boolean update(UUID id, QLSanPham sp);

    boolean delete(UUID id);

    

}
