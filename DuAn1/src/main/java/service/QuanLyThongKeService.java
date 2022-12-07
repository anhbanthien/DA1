/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author vutuo
 */
public interface QuanLyThongKeService {

    List<Object[]> getList();

    List<Object> soLuong(Date date);

    List<Object[]> getListTK();

    List<Object[]> getListTKMD();

    List<Object[]> listThongKeCT(Date ngayTT);

    List<Object[]> getListDT(Date ngayBD, Date ngayKT);

    List<Object[]> getListTKKH(Date ngayBD, Date ngayKT);

    List<Object> soLuongNgay(Date ngayBD, Date ngayKT);

    List<Object[]> tkSPMD();

    List<Object[]> thongKeSPNgay(Date ngayBD, Date ngayKT);

    List<Object[]> getListSP();
    
    List<Object> listHDNgay(Date ngayBD, Date ngayKT);
    
    List<Object> listTongTienNgay(Date ngayBD, Date ngayKT);
    
    List<Object[]> listMouse(UUID id);
    
    List<Object[]> listBieuDo();
}
