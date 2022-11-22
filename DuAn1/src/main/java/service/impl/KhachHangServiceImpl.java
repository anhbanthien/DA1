/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.KhachHang;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repository.KhachHangRepository;
import service.KhachHangService;
import viewmodel.KhachHangModel;

/**
 *
 * @author vanlo
 */
public class KhachHangServiceImpl implements KhachHangService {

    KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHangModel> getAll() {
        List<KhachHang> list = khachHangRepository.getAll();
        List<KhachHangModel> khachHangModels = new ArrayList<>();

        for (KhachHang hd : list) {
            khachHangModels.add(new KhachHangModel(hd));
        }

        return khachHangModels;
    }

    @Override
    public KhachHangModel getOne(String Sdt) {
        return new KhachHangModel(khachHangRepository.getBySdt(Sdt));
    }

    @Override
    public KhachHangModel getOne(UUID id) {
        return new KhachHangModel(khachHangRepository.getOne(id));
    }

    @Override
    public boolean Save(KhachHangModel khachHang) {
        return khachHangRepository.add(new KhachHang(khachHang));
    }

    @Override
    public boolean Update(KhachHangModel khachHang) {
        return khachHangRepository.update(new KhachHang(khachHang));
    }

    @Override
    public boolean Delete(KhachHangModel khachHang) {
        return khachHangRepository.delete(new KhachHang(khachHang));
    }

}
