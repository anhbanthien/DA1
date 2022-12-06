/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domainmodel.NguyenLieu;
import domainmodel.SanPham;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repository.CongThucRepository;
import repository.NguyenLieuRepository;
import service.IManageNguyenLieuService;
import viewmodel.QLNguyenLieu;
import viewmodel.QLSanPham;

/**
 *
 * @author trong
 */
public class ManageNguyenLieuService implements IManageNguyenLieuService {

    NguyenLieuRepository nguyenLieuRepository = new NguyenLieuRepository();
    CongThucRepository congThucRepository = new CongThucRepository();

    @Override
    public List<QLNguyenLieu> getAll() {
        List<NguyenLieu> lstNL = nguyenLieuRepository.getAll();
        List<QLNguyenLieu> lstQLNL = new ArrayList<>();
        for (NguyenLieu x : lstNL) {
            QLNguyenLieu qlnl = new QLNguyenLieu();
            qlnl.setIdNL(x.getIDNL());
            qlnl.setTenNL(x.getTenNL());
            qlnl.setSoLuong(x.getSoLuong());
            qlnl.setDvt(x.getDvt());
            qlnl.setNgayNhap(x.getNgayNhap());
            qlnl.setHsd(x.getHsd());
            qlnl.setIdCT(x.getCongthuc().getIdCT());
            lstQLNL.add(qlnl);
        }
        return lstQLNL;
    }

    @Override
    public QLNguyenLieu getOne(UUID idNL) {
        NguyenLieu x = nguyenLieuRepository.getOne(idNL);
        QLNguyenLieu qlnl = new QLNguyenLieu();
        qlnl.setIdNL(x.getIDNL());
        qlnl.setTenNL(x.getTenNL());
        qlnl.setSoLuong(x.getSoLuong());
        qlnl.setDvt(x.getDvt());
        qlnl.setNgayNhap(x.getNgayNhap());
        qlnl.setHsd(x.getHsd());
        qlnl.setIdCT(x.getCongthuc().getIdCT());
        return qlnl;
    }

    @Override
    public String add(QLNguyenLieu qlnl) {
        NguyenLieu nl = new NguyenLieu();
        nl.setIDNL(qlnl.getIdNL());
        nl.setTenNL(qlnl.getTenNL());
        nl.setSoLuong(qlnl.getSoLuong());
        nl.setDvt(qlnl.getDvt());
        nl.setNgayNhap(qlnl.getNgayNhap());
        nl.setHsd(qlnl.getHsd());
        nl.setCongthuc(congThucRepository.getOne(qlnl.getIdCT()));
        return nguyenLieuRepository.Add(nl) ? "Thêm thành công" : "Thêm thất bại";
    }

    @Override
    public String update(UUID idNL, QLNguyenLieu qlnl) {
        NguyenLieu nl = new NguyenLieu();
        nl.setIDNL(qlnl.getIdNL());
        nl.setTenNL(qlnl.getTenNL());
        nl.setSoLuong(qlnl.getSoLuong());
        nl.setDvt(qlnl.getDvt());
        nl.setNgayNhap(qlnl.getNgayNhap());
        nl.setHsd(qlnl.getHsd());
        nl.setCongthuc(congThucRepository.getOne(qlnl.getIdCT()));

        return nguyenLieuRepository.Update(idNL, nl) ? "Sửa thành công" : "Sửa thất bại";
    }

    @Override
    public String delete(QLNguyenLieu qlnl) {

        NguyenLieu nl = new NguyenLieu();
        nl.setIDNL(qlnl.getIdNL());
        nl.setTenNL(qlnl.getTenNL());
        nl.setSoLuong(qlnl.getSoLuong());
        nl.setDvt(qlnl.getDvt());
        nl.setNgayNhap(qlnl.getNgayNhap());
        nl.setHsd(qlnl.getHsd());
        nl.setCongthuc(congThucRepository.getOne(qlnl.getIdCT()));

        return nguyenLieuRepository.Delete(nl) ? "Xóa thành công" : "Xóa thất bại";
    }

    public static void main(String[] args) {
        ManageNguyenLieuService mana = new ManageNguyenLieuService();
        ManageCongThucService manact = new ManageCongThucService();
        List<QLNguyenLieu> lst = mana.getByCT(manact.getAll().get(0).getIdCT());
        for (QLNguyenLieu x : lst) {
            System.out.println(x.toString());
        }
        //mana.add(new QLNguyenLieu("NL02", "muối", 200, "gam", "22-11-2022", 30));
        // System.out.println(mana.delete(lst.get(2)));
        //System.out.println(mana.update("NL02", new QLNguyenLieu("NL03", "bột ngọt 123", 10, "kilogam", "1-1-2022", 30)));
        //mana.delete(new QLNguyenLieu("58107C05-3AFE-9542-803F-AEDED6C1B83E", "123", 123, "123", "123", 123,"D8DC8573-E8C6-4F5B-8726-9A746F10AEFF"));
        //   mana.delete(new QLNguyenLieu(58107C05-3AFE-9542-803F-AEDED6C1B83E, "123", 123, "123", "123", 123, D8DC8573-E8C6-4F5B-8726-9A746F10AEFF));
        
        
    }

    @Override
    public QLNguyenLieu getOneByTen(String tenNL) {
        NguyenLieu x = nguyenLieuRepository.getOneByTen(tenNL);
        QLNguyenLieu qlnl = new QLNguyenLieu();
        qlnl.setIdNL(x.getIDNL());
        qlnl.setTenNL(x.getTenNL());
        qlnl.setSoLuong(x.getSoLuong());
        qlnl.setDvt(x.getDvt());
        qlnl.setNgayNhap(x.getNgayNhap());
        qlnl.setHsd(x.getHsd());
        qlnl.setIdCT(x.getCongthuc().getIdCT());
        return qlnl;
    }

    @Override
    public List<QLNguyenLieu> getByCT(UUID idCT) {
        List<NguyenLieu> lstNL = nguyenLieuRepository.getByCT(idCT);
        List<QLNguyenLieu> lstQLNL = new ArrayList<>();
        for (NguyenLieu x : lstNL) {
            QLNguyenLieu qlnl = new QLNguyenLieu();
            qlnl.setIdNL(x.getIDNL());
            qlnl.setTenNL(x.getTenNL());
            qlnl.setSoLuong(x.getSoLuong());
            qlnl.setDvt(x.getDvt());
            qlnl.setNgayNhap(x.getNgayNhap());
            qlnl.setHsd(x.getHsd());
            qlnl.setIdCT(x.getCongthuc().getIdCT());
            lstQLNL.add(qlnl);
        }
        return lstQLNL;
    }

}
