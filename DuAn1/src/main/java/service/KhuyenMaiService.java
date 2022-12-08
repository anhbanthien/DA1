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
    public boolean add(KhuyenMai khuyenmai);
    public boolean update(KhuyenMai khuyenmai, UUID Id);
    boolean delete(KhuyenMai khuyenmai);
}
