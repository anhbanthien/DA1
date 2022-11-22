/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domainmodel.HoaDon;
import java.util.List;
import java.util.UUID;
import viewmodel.QLHDCT;

/**
 *
 * @author trong
 */
public interface IManageHDCTService {
    List<QLHDCT> getAll();
    List<QLHDCT> getListbyHD(UUID hoaDon);

    QLHDCT getOne(UUID id);

    String add(QLHDCT qlhdct);

    String update(UUID id, QLHDCT qlhdct);

    String delete(UUID id);
    
    
}
