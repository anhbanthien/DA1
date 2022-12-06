/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domainmodel.SanPham;
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
            QLSanPham qlsp = new QLSanPham(x);
            lstQLSP.add(qlsp);
        }
        return lstQLSP;
    }

    @Override
    public QLSanPham getOne(UUID id) {
        SanPham sp = sanPhamRepository.getOne(id);
        return new QLSanPham(sp);
    }

    @Override
    public String add(QLSanPham qlsp) {
        SanPham sp = new SanPham();
        sp.setIDSP(qlsp.getIDSP());
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
        sp.setIDSP(id);
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
        sp.setIDSP(qlsp.getIDSP());
        sp.setTenSP(qlsp.getTenSP());
        sp.setMoTa(qlsp.getMoTa());
        sp.setImage(qlsp.getImage());
        sp.setGia(qlsp.getGia());
        sp.setTrangThai(qlsp.getTrangThai());
        return sanPhamRepository.Delete(sp) ? "Xóa thành công" : "Xóa thất bại";
    }

    @Override
    public QLSanPham getOneByTen(String ten) {
        SanPham sp = sanPhamRepository.getOneByTen(ten);
        return new QLSanPham(sp);
    }

    public static void main(String[] args) {
        SanPhamRepository spre = new SanPhamRepository();
       // new ManageSanPhamService().getAll().forEach(a -> System.out.print(""));

        ManageSanPhamService mana = new ManageSanPhamService();
        List<QLSanPham> lst = mana.getAll();
        for (QLSanPham x : mana.getAll()) {
            System.out.println(x.toString());
        }
        
        //mana.getOneByTen("")

    }

}
