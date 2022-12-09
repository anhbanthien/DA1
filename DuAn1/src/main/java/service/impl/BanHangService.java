/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.HDCT;
import java.util.UUID;
import repository.BanHangRepository;
import service.IBanHangService;
import repository.HDCTRepository;
import repository.HoaDonRepository;
import repository.SanPhamRepository;
import viewmodel.QLHDCT;

/**
 *
 * @author vanlo
 */
public class BanHangService implements IBanHangService {

    @Override
    public String update(QLHDCT qlhdct, UUID id) {
        HDCT hdct = new HDCT();
        hdct.setIDHDCT(qlhdct.getIdHD());
        hdct.setIDHD(new HoaDonRepository().getOne(qlhdct.getIdHD()));
        hdct.setIDSP(new SanPhamRepository().getOne(qlhdct.getIdSP()));
        hdct.setSoLuong(qlhdct.getSoLuong());

        return new BanHangRepository().Update(hdct, id) ? "Sửa thành công" : "Sửa thất bại";
    }

    @Override
    public QLHDCT getOne(UUID idHD, UUID idSP) {
        HDCT hdct = new BanHangRepository().getOne(idHD, idSP);
        if (hdct == null) {
            return null;
        }
        QLHDCT qlhdct = new QLHDCT();
        qlhdct.setIdHDCT(hdct.getIDHDCT());
        qlhdct.setIdHD(hdct.getIDHD().getIDHD());
        qlhdct.setIdSP(hdct.getIDSP().getIDSP());
        qlhdct.setSoLuong(hdct.getSoLuong());
        return qlhdct;
    }

    @Override
    public String delete(UUID qlhdct) {

        return new BanHangRepository().Delete(qlhdct) ? "xóa thành công" : "xóa thất bại";
    }

}
