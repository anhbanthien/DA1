/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domainmodel.SanPham;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repository.SanPhamRepository;
import service.IManageSanPhamService;
import viewmodel.QLSanPham;

/**
 *
 * @author trong
 */
public class ManageSanPhamService implements IManageSanPhamService {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<QLSanPham> getAll() {
        List<SanPham> lstSP = sanPhamRepository.getAll();
        List<QLSanPham> lstQLSP = new ArrayList<>();
        for (SanPham x : lstSP) {
            QLSanPham qlsp = new QLSanPham();
            qlsp.setIDSP(x.getIdSP());
            qlsp.setTenSP(x.getTenSP());
            qlsp.setMoTa(x.getMoTa());
            qlsp.setImage(x.getImage());
            qlsp.setGia(x.getGia());
            qlsp.setTrangThai(x.getTrangThai());

            lstQLSP.add(qlsp);
        }
        return lstQLSP;
    }

    @Override
    public QLSanPham getOne(UUID id) {
        SanPham x = sanPhamRepository.getOne(id);

        QLSanPham qlsp = new QLSanPham();
        qlsp.setIDSP(x.getIdSP());
        qlsp.setTenSP(x.getTenSP());
        qlsp.setMoTa(x.getMoTa());
        qlsp.setImage(x.getImage());
        qlsp.setGia(x.getGia());
        qlsp.setTrangThai(x.getTrangThai());
        return qlsp;
    }

    @Override
    public String add(QLSanPham qlsp) {
        SanPham sp = new SanPham();
        sp.setIdSP(qlsp.getIDSP());
        sp.setTenSP(qlsp.getTenSP());
        sp.setMoTa(qlsp.getMoTa());
        sp.setImage(qlsp.getImage());
        sp.setGia(qlsp.getGia());
        sp.setTrangThai(qlsp.getTrangThai());

        return sanPhamRepository.Add(sp) ? "Thêm thành công" : "Thêm thất bại";
    }

    @Override
    public String update(UUID id, QLSanPham qlsp) {
        SanPham sp = new SanPham();
        sp.setIdSP(id);
        sp.setTenSP(qlsp.getTenSP());
        sp.setMoTa(qlsp.getMoTa());
        sp.setImage(qlsp.getImage());
        sp.setGia(qlsp.getGia());
        sp.setTrangThai(qlsp.getTrangThai());

        return sanPhamRepository.Update(id, sp) ? "Sửa thành công" : "Sửa thất bại";
    }

    @Override
    public String delete(QLSanPham qlsp) {
        SanPham sp = new SanPham();
        sp.setIdSP(qlsp.getIDSP());
        sp.setTenSP(qlsp.getTenSP());
        sp.setMoTa(qlsp.getMoTa());
        sp.setImage(qlsp.getImage());
        sp.setGia(qlsp.getGia());
        sp.setTrangThai(qlsp.getTrangThai());
        return sanPhamRepository.Delete(sp) ? "Xóa thành công" : "Xóa thất bại";
    }

    public static void main(String[] args) {
        ManageSanPhamService manageSanPhamService = new ManageSanPhamService();
        List<QLSanPham> lstQLSP = manageSanPhamService.getAll();
        for (QLSanPham x : lstQLSP) {
            System.out.println(x.toString());
        }
        // manageSanPhamService.add(new QLSanPham("CA PHE", "123", "JPG", 123, "132"));
        //  manageSanPhamService.delete(lstQLSP.get(2));
//        QLSanPham qlsp = new QLSanPham("123", "123", "123", 0, "123");
//        manageSanPhamService.update(lstQLSP.get(0).getIDSP(), qlsp);
    }

    @Override
    public QLSanPham getOneByTen(String ten) {
        SanPham x = sanPhamRepository.getOneByTen(ten);
        QLSanPham qlsp = new QLSanPham();
        qlsp.setIDSP(x.getIdSP());
        qlsp.setTenSP(x.getTenSP());
        qlsp.setMoTa(x.getMoTa());
        qlsp.setImage(x.getImage());
        qlsp.setGia(x.getGia());
        qlsp.setTrangThai(x.getTrangThai());
        return qlsp;
    }

}
