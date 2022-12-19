/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.KhuyenMai;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public interface KhuyenMaiService {

    public List<KhuyenMai> getAll();

    public String add(KhuyenMai khuyenmai);

    public String update(KhuyenMai khuyenmai);

    boolean delete(KhuyenMai khuyenmai);
    
    KhuyenMai getOne(String maKM);
}
