/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domainmodel.HDCT;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import repository.HDCTRepository;
import repository.HoaDonRepository;
import repository.SanPhamRepository;
import service.IManageHDCTService;
import viewmodel.QLHDCT;

/**
 *
 * @author trong
 */
public class ManageHDCTService implements IManageHDCTService {

    HDCTRepository hDCTRepository = new HDCTRepository();
    SanPhamRepository sanPhamRepository = new SanPhamRepository();

    HoaDonRepository hoaDonRepository = new HoaDonRepository();

    @Override
    public List<QLHDCT> getAll() {
        List<HDCT> lstHDCT = hDCTRepository.getAll();
        List<QLHDCT> lstQLHDCT = new ArrayList<>();
        for (HDCT x : lstHDCT) {
            QLHDCT qlhdct = new QLHDCT();
            qlhdct.setIdHDCT(x.getIDHDCT());
            qlhdct.setIdHD(x.getIDHD().getIDHD());
            qlhdct.setIdSP(x.getIDSP().getIdSP());
            qlhdct.setSoLuong(x.getSoLuong());
            
            lstQLHDCT.add(qlhdct);
        }
        return lstQLHDCT;
    }

    @Override
    public QLHDCT getOne(UUID id) {
        HDCT hdct = hDCTRepository.getOne(id);
        QLHDCT qlhdct = new QLHDCT();
        qlhdct.setIdHDCT(hdct.getIdHDCT());
        qlhdct.setIdHD(hdct.getHoaDon().getIDHD());
        qlhdct.setIdSP(hdct.getSanPham().getIdSP());
        qlhdct.setSoLuong(hdct.getSoLuong());
        qlhdct.setSoBanCT(hdct.getSoBanCT());
        return qlhdct;
    }
    @Override
    public List<QLHDCT> getListbyHD(UUID hoaDon) {
        List<HDCT> lstHDCT = hDCTRepository.getAll();
        List<QLHDCT> lstQLHDCT = new ArrayList<>();
        for (HDCT x : lstHDCT) {
            if(x.getHoaDon().getIDHD().equals(hoaDon)){
            QLHDCT qlhdct = new QLHDCT();
            qlhdct.setIdHDCT(x.getIdHDCT());
            qlhdct.setIdHD(x.getHoaDon().getIDHD());
            qlhdct.setIdSP(x.getSanPham().getIdSP());
            qlhdct.setTenSP(x.getSanPham().getTenSP());
            qlhdct.setGia(x.getSanPham().getGia());
            qlhdct.setSoLuong(x.getSoLuong());
            qlhdct.setSoBanCT(x.getSoBanCT());
            lstQLHDCT.add(qlhdct);
            }
        }
        return lstQLHDCT;}
    @Override
    public String add(QLHDCT qlhdct) {
        HDCT hdct = new HDCT();
        hdct.setIdHDCT(qlhdct.getIdHD());
        hdct.setHoaDon(hoaDonRepository.getOne(qlhdct.getIdHD()));
        hdct.setSanPham(sanPhamRepository.getOne(qlhdct.getIdSP()));
        hdct.setSoLuong(qlhdct.getSoLuong());
        hdct.setSoBanCT(qlhdct.getSoBanCT());

        return hDCTRepository.Add(hdct) ? "Thêm thành công" : "Thêm thất bại";
    }
    
    @Override
    public String update(UUID id, QLHDCT qlhdct) {
        HDCT hdct = new HDCT();
        hdct.setIdHDCT(qlhdct.getIdHD());
        hdct.setHoaDon(hoaDonRepository.getOne(qlhdct.getIdHD()));
        hdct.setSanPham(sanPhamRepository.getOne(qlhdct.getIdSP()));
        hdct.setSoLuong(qlhdct.getSoLuong());
        hdct.setSoBanCT(qlhdct.getSoBanCT());

        return hDCTRepository.Update(id, hdct) ? "Sửa thành công" : "Sửa thất bại";
    }

    @Override
    public String delete(UUID id) {
        return hDCTRepository.Delete(id) ? "Xóa thành công" : "Xóa thất bại";
    }

    private void valueOf() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
