/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.HoaDonModel;

/**
 *
 * @author hungn
 */
public interface HoaDonService {

    List<HoaDonModel> getAllHoaDon();

    List<HoaDonModel> getSearch();

    public List<HoaDonModel> getHoaDonByTT(String TT);
}
