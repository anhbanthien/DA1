/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.KhuyenMai;
import java.util.UUID;
import viewmodel.QLHDCT;

/**
 *
 * @author vanlo
 */
public interface IBanHangService {
    String update( QLHDCT qlhdct,UUID id);
    QLHDCT getOne(UUID idHD,UUID idSP);
    String delete(UUID qlhdct);
    KhuyenMai getByMaKM(String MaKM);
    
}
