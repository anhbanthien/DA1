/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.HoaDon;
import java.util.List;
import java.util.UUID;
import viewmodel.HoaDonModel;

/**
 *
 * @author hungn
 */
public interface HoaDonService {

    List<HoaDonModel> getAllHoaDon();

    List<HoaDonModel> getHoaDonByTT(String TT);

    List<HoaDonModel> getSearch();
    
    boolean update (HoaDon hd , UUID id);
    
     HoaDonModel getOne(UUID _idHD);
}
