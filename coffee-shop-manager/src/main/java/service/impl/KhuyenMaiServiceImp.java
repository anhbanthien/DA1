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
public class KhuyenMaiServiceImp implements KhuyenMaiService{

    @Override
    public List<KhuyenMai> getAll() {
       return new  KhuyenMaiRepository().getAll();
    }

    @Override
    public boolean add(KhuyenMai khuyenmai) {
         return new  KhuyenMaiRepository().add(khuyenmai);
    }

    @Override
    public boolean update(KhuyenMai khuyenmai, UUID Id) {
         return new KhuyenMaiRepository().update(khuyenmai, Id);
    }

    @Override
    public boolean delete(KhuyenMai khuyenmai) {
       return new KhuyenMaiRepository().delete(khuyenmai);
    }
    
}
