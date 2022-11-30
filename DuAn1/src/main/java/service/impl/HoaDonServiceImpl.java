/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.HoaDon;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import repository.HoaDonRepository;
import service.HoaDonService;
import viewmodel.HoaDonModel;

/**
 *
 * @author hungn
 */
public class HoaDonServiceImpl implements HoaDonService {

    private HoaDonRepository hoadonrepository = new HoaDonRepository();

    @Override
    public List<HoaDonModel> getAllHoaDon() {
        return (ArrayList<HoaDonModel>) new HoaDonRepository().getAll().stream().map(HoaDonModel::new).collect(Collectors.toList());
    }

    @Override
    public List<HoaDonModel> getHoaDonByTT(String TT) {
        List<HoaDon> list = hoadonrepository.getHoaDonByTT(TT);
        List<HoaDonModel> hoadonmodel = new ArrayList<>();

        for (HoaDon hd : list) {
            HoaDonModel model = new HoaDonModel(hd);
            hoadonmodel.add(model);
        }
        return hoadonmodel;
    }

    public static void main(String[] args) {
        List<HoaDonModel> lists = new HoaDonServiceImpl().getAllHoaDon();
        for (HoaDonModel o : lists) {
            System.out.println(o.toString());
        }
    }
//    @Override
//    public String update(HoaDonModel hoadonModel) {
//        boolean update = hoadonrepository.update(hoadonModel);
//
//        if (update) {
//            return "Update thành công";
//        } else {
//            return "Update thất bại";
//        }
//    }

    @Override
    public List<HoaDonModel> getSearch() {
        return (ArrayList<HoaDonModel>) new HoaDonRepository().getAll().stream().map(HoaDonModel::new).collect(Collectors.toList());
    }

    @Override
    public HoaDonModel getOne(UUID idHD) {
        return new HoaDonModel(hoadonrepository.getOne(idHD));
    }

    @Override
    public boolean update(HoaDon hd, UUID id) {
        return new HoaDonRepository().update(hd, id);
    }

    @Override
    public List<HoaDon> getHoaDonByCheck(int IDB) {
        return new HoaDonRepository().getHoaDonByCheck(IDB);
    }
    
    @Override
    public List<FormHoaDon> getAllHoaDon1() {
        return (ArrayList<FormHoaDon>) new HoaDonRepository().getAll().stream().map(FormHoaDon::new).collect(Collectors.toList());
    }

    @Override
    public List<FormHoaDon> getHoaDonByTT1(String TT) {
        List<HoaDon> list = hoadonrepository.getHoaDonByTT(TT);
        List<FormHoaDon> formhd = new ArrayList<>();

        for (HoaDon hd : list) {
            FormHoaDon model = new FormHoaDon(hd);
            formhd.add(model);
        }
        return formhd;
    }

}
