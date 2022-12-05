/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;

/**
 *
 * @author vutuo
 */
public interface QuanLyThongKeService {

    List<Object[]> getList();

    List<Object> soLuong(String date);

    List<Object[]> getListTK();

//    List<Object[]> getListSP();
}
