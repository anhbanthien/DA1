/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import config.HibernatUtil;
import domainmodel.NguyenLieu;
import domainmodel.SanPham;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author trong
 */
public class NguyenLieuRepository {

    Session session = HibernatUtil.getFACTORY().openSession();
    private String fromTable = "FROM NguyenLieu";

    public List<NguyenLieu> getAll() {
        Query query = session.createQuery(fromTable, NguyenLieu.class);
        List<NguyenLieu> lists = query.getResultList();
        return lists;
    }

    public NguyenLieu getOne(String maNL) {
        String sql = fromTable + " WHERE MaNL = :maNL ";
        Query query = session.createQuery(sql, NguyenLieu.class);
        query.setParameter("maNL", maNL);
        NguyenLieu nguyenLieu = (NguyenLieu) query.getSingleResult();
        return nguyenLieu;
    }

    public boolean Add(NguyenLieu nl) {
        Transaction transaction = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nl);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean Update(String maNL, NguyenLieu nl) {
        Transaction transaction = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(nl);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean Delete(NguyenLieu nl) {
        Transaction transaction = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nl);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

        
    }
    public static void main(String[] args) {
        NguyenLieuRepository nl = new NguyenLieuRepository();
        List<NguyenLieu> lst = nl.getAll();
        for (NguyenLieu x : lst) {
            System.out.println(x.toString());
        }
    }
}
