/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.ThongKeRepository;
import service.QuanLyThongKeService;

/**
 *
 * @author vutuo
 */
public class QuanLyThongKeServiceImpl implements QuanLyThongKeService {

    private ThongKeRepository repository = new ThongKeRepository();

    @Override
    public List<Object[]> getList() {

        return repository.listThongKe();
    }

    @Override
    public List<Object> soLuong(String date) {
        return repository.soLuong(date);
    }

    @Override
    public List<Object[]> getListTK() {
        return repository.listThongKeKH();
    }

//    @Override
//    public List<Object[]> getListSP() {
//        return repository.listThongKeSP();
//    }
}
