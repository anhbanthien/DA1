/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.HibernatUtil;
import java.util.List;
import javax.persistence.Query;
import domainmodel.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vanlo
 */
public class KhachHangRepository {
     private Session session = HibernatUtil.getFACTORY().openSession();
    
    private String fromTable = "FROM KhachHang"; //HQL
    public List<KhachHang> getAll(){
        Query query = session.createQuery(fromTable,KhachHang.class);
        List<KhachHang> lists = query.getResultList();
        return lists;
    }
//    public KhachHang getOne(long id){
//        String sql = fromTable + " WHERE id = : id";
//        Query query = session.createQuery(sql, KhachHang.class);
//        query.setParameter("id", id);
//        KhachHang khachHang = (KhachHang) query.getSingleResult();
//        return khachHang;
//    }
    public static void main(String[] args) {
        List<KhachHang> lists = new KhachHangRepository().getAll();
        System.out.println("Vui lên đi");
        for (KhachHang list : lists) {
            System.out.println(list.toString());
        }
    }
//    public Boolean add(KhachHang khachHang){
//        Transaction transaction = null;
//        try(Session session = HibernatUtil.getFACTORY().openSession()){
//            transaction = session.beginTransaction();
//            session.save(khachHang);
//            transaction.commit();
//            return true;
//        } catch(Exception e){
//    return null;
//    }
//    }
}
