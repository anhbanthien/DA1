/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.KhuyenMai;
import java.util.List;
import java.util.UUID;
import repository.KhuyenMaiRepository;
import service.KhuyenMaiService;

/**
 *
 * @author Admin
 */
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    private KhuyenMaiRepository repository = new KhuyenMaiRepository();

    @Override
    public List<KhuyenMai> getAll() {
        return new KhuyenMaiRepository().getAll();
    }

    @Override
    public String add(KhuyenMai khuyenmai) {
        boolean add = repository.add(khuyenmai);
        if (add) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String update(KhuyenMai khuyenmai) {
        boolean update = repository.update(khuyenmai);
        if (update) {
            return "Update thành công";
        } else {
            return "Update thất bại";
        }
    }

    @Override
    public boolean delete(KhuyenMai khuyenmai) {
        return repository.delete(khuyenmai);
    }

    @Override
    public KhuyenMai getOne(String MaKM) {
        return repository.getOne(MaKM);
    }

}
