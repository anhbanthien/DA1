/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.KhuyenMai;
import java.util.ArrayList;
import java.util.List;
import repository.KhuyenMaiRepository;
import service.KhuyenMaiService;
import viewmodel.KhuyenMaiModel;

/**
 *
 * @author hungn
 */
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    private KhuyenMaiRepository kmrp = new KhuyenMaiRepository();

    @Override
    public List<KhuyenMaiModel> getAll() {
        List<KhuyenMai> list = kmrp.getAll();
        List<KhuyenMaiModel> listmd = new ArrayList<>();
        for (KhuyenMai km : list) {
            listmd.add(new KhuyenMaiModel(km));
        }

        return listmd;
    }

    @Override
    public boolean Save(KhuyenMaiModel khuyenMai) {
        KhuyenMai km = new KhuyenMai();
        km.setMaKM(khuyenMai.getMaKM());
        km.setPhanTramKM(khuyenMai.getPhanTramKM());
        km.setNgayBatDau(khuyenMai.getNgayBatDau());
        km.setNgayKetThuc(khuyenMai.getNgayKetThuc());
        km.setTrangThai(khuyenMai.getTrangThai());

        return kmrp.add(km);
    }

    @Override
    public boolean Delete(KhuyenMaiModel khuyenMai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Update(KhuyenMaiModel khuyenMai, String MaKM) {
        KhuyenMai km = new KhuyenMai();
        km.setMaKM(khuyenMai.getMaKM());
        km.setPhanTramKM(khuyenMai.getPhanTramKM());
        km.setNgayBatDau(khuyenMai.getNgayBatDau());
        km.setNgayKetThuc(khuyenMai.getNgayKetThuc());
        km.setTrangThai(khuyenMai.getTrangThai());
        return kmrp.update(km, MaKM);
    }

}
