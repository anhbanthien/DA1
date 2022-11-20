/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.HibernatUtil;
import java.util.List;
import domainmodel.HoaDon;
import domainmodel.HoaDonChiTiet;
import domainmodel.KhachHang;
import java.util.UUID;
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

    public HoaDon getOne(UUID id) {
        String sql = fromTable + " WHERE IDHD = :id ";
        javax.persistence.Query query = session.createQuery(sql, HoaDon.class);
        query.setParameter("id", id);
        HoaDon hd =  (HoaDon) query.getSingleResult();       
        return hd;
    }
    public Boolean add(HoaDon hoaDon){
        Transaction transaction = null;
        try(Session session = HibernatUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(hoaDon);
            transaction.commit();
            return true;
        } catch(Exception e){
    return null;
        }
    }
    public Boolean delete(HoaDon hoaDon){
        Transaction transaction = null;
        try(Session session = HibernatUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(hoaDon);
            transaction.commit();
            return true;
        } catch(Exception e){
    return false;
        }
    }
    public Boolean update(HoaDon hoaDon){
        Transaction transaction = null;
        try(Session session = HibernatUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(hoaDon);
            transaction.commit();
            return true;
        } catch(Exception e){
    return false;
        }
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
