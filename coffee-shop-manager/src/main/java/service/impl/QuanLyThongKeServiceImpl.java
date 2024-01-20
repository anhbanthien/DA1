/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
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
    public List<Object> soLuong(Date date) {
        return repository.soLuong(date);
    }

    @Override
    public List<Object[]> getListTK() {
        return repository.listThongKeKH();
    }

    @Override
    public List<Object[]> getListSP() {
        return repository.listThongKeSP();
    }

    @Override
    public List<Object> soLuongNgay(Date ngayBD, Date ngayKT) {
        return repository.soLuongNgay(ngayBD, ngayKT);
    }

    @Override
    public List<Object[]> getListTKKH(Date ngayBD, Date ngayKT) {
        return repository.listThongKeKHSearch(ngayBD, ngayKT);
    }

    @Override
    public List<Object[]> getListDT(Date ngayBD, Date ngayKT) {
        return repository.listThongKeDT(ngayBD, ngayKT);
    }

    @Override
    public List<Object[]> getListTKMD() {
        return repository.listThongKeKHMacDinh();
    }

    @Override
    public List<Object[]> listThongKeCT(Date ngayTT) {
        return repository.listThongKeCT(ngayTT);
    }

    @Override
    public List<Object[]> tkSPMD() {
        return repository.listThongKeSPMD();
    }

    @Override
    public List<Object[]> thongKeSPNgay(Date ngayBD, Date ngayKT) {
        return repository.listThongKeSPNgay(ngayBD, ngayKT);
    }

    @Override
    public List<Object> listHDNgay(Date ngayBD, Date ngayKT) {
        return repository.listHDNgay(ngayBD, ngayKT);
    }

    @Override
    public List<Object> listTongTienNgay(Date ngayBD, Date ngayKT) {
        return repository.listTongTienNgay(ngayBD, ngayKT);
    }

    @Override
    public List<Object[]> listMouse(UUID id) {
        return repository.listMouseClickCT(id);
    }

    @Override
    public List<Object[]> listBieuDo() {
        return repository.listBieuDo();
    }
}
