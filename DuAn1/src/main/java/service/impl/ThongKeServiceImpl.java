/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import repository.ThongKeRepository;
import service.ThongKeService;

/**
 *
 * @author vutuo
 */
public class ThongKeServiceImpl implements ThongKeService{
    private ThongKeRepository repository = new ThongKeRepository();
    @Override
    public List<Object[]> getList() {
        return repository.listThongKe();
    }
    
}
