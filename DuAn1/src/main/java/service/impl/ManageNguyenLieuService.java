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
    @Override
    public List<QLNguyenLieu> getAll() {
        List<NguyenLieu> lstNL = nguyenLieuRepository.getAll();
        List<QLNguyenLieu> lstQLNL = new ArrayList<>();
        for (NguyenLieu x : lstNL) {
            QLNguyenLieu qlnl = new QLNguyenLieu();
            qlnl.setMaNL(x.getMaNL());
            qlnl.setTenNL(x.getTenNL());
            qlnl.setSoLuong(x.getSoLuong());
            qlnl.setDvt(x.getDvt());
            qlnl.setNgayNhap(x.getNgayNhap());
            qlnl.setHsd(x.getHsd());
            lstQLNL.add(qlnl);
        }
        return lstQLNL;
    }

    @Override
    public QLNguyenLieu getOne(String maNL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String add(QLNguyenLieu qlnl) {
        NguyenLieu nl = new NguyenLieu();
        nl.setMaNL(qlnl.getMaNL());
        nl.setTenNL(qlnl.getTenNL());
        nl.setSoLuong(qlnl.getSoLuong());
        nl.setDvt(qlnl.getDvt());
        nl.setNgayNhap(qlnl.getNgayNhap());
        nl.setHsd(qlnl.getHsd());
        return nguyenLieuRepository.Add(nl)?"Thêm thành công":"Thêm thất bại";
    }

    @Override
    public String update(String maNL, QLNguyenLieu qlnl) {
        NguyenLieu nl = new NguyenLieu();
        nl.setMaNL(maNL);
        nl.setTenNL(qlnl.getTenNL());
        nl.setNgayNhap(qlnl.getNgayNhap());
        nl.setSoLuong(qlnl.getSoLuong());
        nl.setHsd(qlnl.getHsd());
        nl.setDvt(qlnl.getDvt());
        
        
        return nguyenLieuRepository.Update(maNL,nl)?"Sửa thành công":"Sửa thất bại";
    }

    @Override
    public String delete(QLNguyenLieu qlnl) {
        NguyenLieu nl = new NguyenLieu();
        nl.setMaNL(qlnl.getMaNL());
        nl.setTenNL(qlnl.getTenNL());
        nl.setNgayNhap(qlnl.getNgayNhap());
        nl.setSoLuong(qlnl.getSoLuong());
        nl.setHsd(qlnl.getHsd());
        nl.setDvt(qlnl.getDvt());
        return nguyenLieuRepository.Delete(nl)?"Xóa thành công":"Xóa thất bại";
    }
    
    public static void main(String[] args) {
        ManageNguyenLieuService mana = new ManageNguyenLieuService();
        List<QLNguyenLieu> lst = mana.getAll();
        for (QLNguyenLieu x : lst) {
            System.out.println(x.toString());
        }
      //mana.add(new QLNguyenLieu("NL02", "muối", 200, "gam", "22-11-2022", 30));
      //System.out.println(mana.delete(new QLNguyenLieu("NL03", "bột ngọt 123", 10, "kilogam", "1-1-2022", 30)));
     //System.out.println(mana.update("NL02", new QLNguyenLieu("NL03", "bột ngọt 123", 10, "kilogam", "1-1-2022", 30)));
    }

}
