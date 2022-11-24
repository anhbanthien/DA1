/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domainmodel.CongThuc;
import domainmodel.NguyenLieu;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repository.CongThucRepository;
import service.IManageCongThucService;
import viewmodel.QLCongThuc;
import viewmodel.QLNguyenLieu;

/**
 *
 * @author trong
 */
public class ManageCongThucService implements IManageCongThucService {

    CongThucRepository congThucRepository = new CongThucRepository();

//    @Override
//    public List<QLCongThuc> getAll() {
//        List<CongThuc> lstCT = congThucRepository.getAll();
//        List<QLCongThuc> lstQLCT = new ArrayList<>();
//        for (CongThuc x : lstCT) {
//            QLCongThuc qlct = new QLCongThuc();
//            qlct.setIdCT(x.getIdCT());
//            qlct.setIdSP(x.getSanPham().getIdSP());
//            qlct.setTen(x.getTen());
//            qlct.setMoTa(x.getMoTa());
//            qlct.setImage(x.getImage());
//            qlct.setTrangThai(x.getTrangThai());
//            qlct.setIdMaNL(x.getNguyenLieu().getMaNL());
//            lstQLCT.add(qlct);
//        }
    @Override
    public List<QLCongThuc> getAll() {
        List<CongThuc> lstCT = congThucRepository.getAll();
        List<QLCongThuc> lstQLCT = new ArrayList<>();
        for (CongThuc x : lstCT) {
            QLCongThuc qlct = new QLCongThuc();
            qlct.setIdCT(x.getIdCT());
            qlct.setIdSP(x.getSanPham().getIdSP());
            qlct.setTen(x.getTen());
            qlct.setMoTa(x.getMoTa());
            qlct.setImage(x.getImage());
            qlct.setTrangThai(x.getTrangThai());
            qlct.setIdMaNL(x.getNguyenLieu().getMaNL());
            lstQLCT.add(qlct);
        }
        return lstQLCT;
    }

    @Override
    public QLCongThuc getOne(UUID idCT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String add(QLCongThuc qlct) {
        CongThuc ct = new CongThuc();
        ct.setIdCT(qlct.getIdCT());
        ct.getSanPham().setIdSP(qlct.getIdSP());
        ct.setTen(qlct.getTen());
        ct.setMoTa(qlct.getMoTa());
        ct.setImage(qlct.getImage());
        ct.setTrangThai(qlct.getTrangThai());
        ct.getNguyenLieu().setMaNL(qlct.getIdMaNL());
        return congThucRepository.Add(ct) ? "Thêm thành công" : "Thêm thất bại";
    }

    @Override
    public String update(UUID idCT, QLCongThuc qlct) {
        CongThuc ct = new CongThuc();
        ct.setIdCT(idCT);
        ct.getSanPham().setIdSP(qlct.getIdSP());
        ct.setTen(qlct.getTen());
        ct.setMoTa(qlct.getMoTa());
        ct.setImage(qlct.getImage());
        ct.setTrangThai(qlct.getTrangThai());
        ct.getNguyenLieu().setMaNL(qlct.getIdMaNL());

        return congThucRepository.Update(idCT, ct) ? "Sửa thành công" : "Sửa thất bại";
    }

    @Override
    public String delete(QLCongThuc qlct) {
        CongThuc ct = new CongThuc();
        ct.setIdCT(qlct.getIdCT());
        ct.getSanPham().setIdSP(qlct.getIdSP());
        ct.setTen(qlct.getTen());
        ct.setMoTa(qlct.getMoTa());
        ct.setImage(qlct.getImage());
        ct.setTrangThai(qlct.getTrangThai());
        ct.getNguyenLieu().setMaNL(qlct.getIdMaNL());
        return congThucRepository.Delete(ct) ? "Xóa thành công" : "Xóa thất bại";
    }

    public static void main(String[] args) {
        ManageCongThucService mana = new ManageCongThucService();
        List<QLCongThuc> lst = mana.getAll();
        for (QLCongThuc x : lst) {
            System.out.println(x.toString());
        }
    }
}
