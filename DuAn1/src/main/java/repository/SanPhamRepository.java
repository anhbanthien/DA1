/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.HibernatUtil;
import java.util.List;
import javax.persistence.Query;
import domainmodel.NhanVien;
import domainmodel.SanPham;
import java.math.BigDecimal;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SanPhamRepository {

    Session session = HibernatUtil.getFACTORY().openSession();
    private String fromTable = "FROM SanPham";

    public List<SanPham> getAll() {
        Query query = session.createQuery(fromTable, SanPham.class);
        List<SanPham> lists = query.getResultList();
        return lists;
    }

    public SanPham getOne(UUID id) {
        String sql = fromTable + " WHERE IDSP = :id ";
        Query query = session.createQuery(sql, SanPham.class);
        query.setParameter("id", id);
        SanPham sanPham = (SanPham) query.getSingleResult();
        return sanPham;
    }

    public boolean Add(SanPham sp) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean Update(UUID id, SanPham sp) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(sp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean Delete(UUID id) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(id);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static void main(String[] args) {
      
        List<SanPham> lists = new SanPhamRepository().getAll();
      
        for (SanPham list : lists) {
            System.out.println(list.toString());
        }
    }

}
