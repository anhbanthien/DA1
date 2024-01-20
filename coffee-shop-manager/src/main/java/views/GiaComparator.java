/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Comparator;
import viewmodel.QLSanPham;

/**
 *
 * @author trong
 */
public class GiaComparator implements Comparator<QLSanPham> {

    @Override
    public int compare(QLSanPham o1, QLSanPham o2) {
        if (o1.getGia() == o2.getGia()) {
            return 0;
        } else if (o1.getGia() > o2.getGia()) {
            return 1;
        } else {
            return -1;
        }
    }
    
    
}
