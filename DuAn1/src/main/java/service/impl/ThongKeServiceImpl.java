/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.Date;
import java.util.List;
import repository.ThongKeRepository;
import repository.ThongKeRepository1;
import service.ThongKeService;
import service.ThongKeService1;

/**
 *
 * @author vutuo
 */
public class ThongKeServiceImpl implements ThongKeService1 {

    private ThongKeRepository1 repository = new ThongKeRepository1();

    @Override
    public List<Object[]> getList() {

        return repository.listThongKe();
    }

    @Override
    public List<Object> soLuong(String date) {
        return repository.soLuong(date);
    }

    

}
