/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.HibernatUtil;
import java.util.List;
import domainmodel.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import viewmodel.HoaDonModel;

/**
 *
 * @author hungn
 */
public class HoaDonRepository {

    private String fromTable = "From HoaDon";

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<HoaDon> getAll() {
        Query query = session.createQuery(fromTable, HoaDon.class);
        List<HoaDon> lists = query.getResultList();
        return lists;
    }

    public List<HoaDon> search(String TrangThai) {
        return (List<HoaDon>) session.get(HoaDon.class, TrangThai);
    }

    public static void main(String[] args) {
        List<HoaDon> list = new HoaDonRepository().getAll();
        for (HoaDon hd : list) {
            System.out.println(hd.toString());
        }
//        List<HoaDon> list = new HoaDonRepository().search("Đã Thanh Toán");
//        for (HoaDon hd : list) {
//            System.out.println(hd.toString());
//        }
    }
}
