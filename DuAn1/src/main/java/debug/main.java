/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package debug;

import domainmodel.KhuyenMai;
import java.util.List;
import service.impl.KhuyenMaiServiceImp;

/**
 *
 * @author Admin
 */
public class main {

    public static void main(String[] args) {
        List<KhuyenMai> getAllKm = new KhuyenMaiServiceImp().getAll();

        String textKM = "";

        for (KhuyenMai o : getAllKm) {
            textKM += "Áp dụng với tất cả hoá đơn mã Khuyến mãi "+o.getMaKM() + " , Ưu đãi "+
                    o.getPhanTramKM() +" % ,Từ ngày "+ o.getNgayBatDau() +"Đến ngày "+ o.getNgayKetThuc();
        }

        System.out.println(textKM);
    }
}
