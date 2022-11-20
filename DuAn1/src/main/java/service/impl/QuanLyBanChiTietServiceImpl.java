/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.stream.Collectors;
import domainmodel.Ban;
import domainmodel.BanChiTiet;
import reponse.BanChiTietReponse;
import reponse.BanReponse;
import repository.BanChiTietRepository;
import repository.BanRepository;
import service.QuanLyBanChiTietService;

/**
 *
 * @author vutuo
 */
public class QuanLyBanChiTietServiceImpl implements QuanLyBanChiTietService {

    private BanChiTietRepository repository = new BanChiTietRepository();

    @Override
    public List<BanChiTietReponse> getAll() {
        List<BanChiTiet> list = repository.getAll();
        return list.stream().map(BanChiTietReponse::new).collect(Collectors.toList());

    }

    @Override
    public String add(BanChiTiet bct) {
        boolean add = repository.add(bct);
        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(BanChiTiet bct) {
        boolean update = repository.update(bct);
        if (update) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(BanChiTiet bct) {
        boolean delete = repository.delete(bct);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    public static void main(String[] args) {
        QuanLyBanChiTietServiceImpl impl = new QuanLyBanChiTietServiceImpl();
        List<BanChiTietReponse> list = impl.getAll();
        for (BanChiTietReponse banChiTietReponse : list) {
            System.out.println(banChiTietReponse.toString());
        }
    }
}
