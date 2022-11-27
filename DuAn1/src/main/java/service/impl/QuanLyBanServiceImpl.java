/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import domainmodel.Ban;
import java.util.UUID;
import reponse.BanReponse;
import repository.BanRepository;
import service.QuanLyBanService;

/**
 *
 * @author vutuo
 */
public class QuanLyBanServiceImpl implements QuanLyBanService {

    private BanRepository repository = new BanRepository();

    @Override
    public List<BanReponse> getAll() {
        List<Ban> list = repository.getAll();
//        List<BanReponse> reponses = new ArrayList<>();
//        for (Ban ban : list) {
//            BanReponse banReponse = new BanReponse();
//            reponses.add(banReponse);
//        }
//        return reponses;
        return list.stream().map(BanReponse::new).collect(Collectors.toList());

    }

    @Override
    public String add(Ban ban) {
        boolean add = repository.add(ban);

        if (add) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(Ban ban) {
        boolean update = repository.update(ban);
        if (update) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(Ban ban) {
        boolean delete = repository.delete(ban);
        if (delete) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    public static void main(String[] args) {
        QuanLyBanServiceImpl impl = new QuanLyBanServiceImpl();
        List<BanReponse> list = impl.getAll();
        for (BanReponse banReponse : list) {
            System.out.println(banReponse);
        }
    }

    @Override
    public Ban getOne(int IDB) {
        return new BanRepository().getOne(IDB);
    }

}
