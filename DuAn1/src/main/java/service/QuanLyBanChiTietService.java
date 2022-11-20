/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import domainmodel.BanChiTiet;
import reponse.BanChiTietReponse;

/**
 *
 * @author vutuo
 */
public interface QuanLyBanChiTietService {

    List<BanChiTietReponse> getAll();

    String add(BanChiTiet bct);

    String update(BanChiTiet bct);

    String delete(BanChiTiet bct);
}
