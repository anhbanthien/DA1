/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import config.HibernatUtil;
import domainmodel.CongThuc;
import domainmodel.NguyenLieu;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author trong
 */
public class CongThucRepository {

    Session session = HibernatUtil.getFACTORY().openSession();
    private String fromTable = "FROM CongThuc";

    public List<CongThuc> getAll() {
        Query query = session.createQuery(fromTable, CongThuc.class);
        List<CongThuc> lists = query.getResultList();
        return lists;
    }

    public CongThuc getOne(UUID idCT) {
        String sql = fromTable + " WHERE IDCT = :idCT ";
        Query query = session.createQuery(sql, CongThuc.class);
        query.setParameter("idCT", idCT);
        CongThuc congThuc = (CongThuc) query.getSingleResult();
        return congThuc;
    }

    public boolean Add(CongThuc ct) {
        Transaction transaction = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ct);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean Update(UUID idCT, CongThuc ct) {
        Transaction transaction = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(ct);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean Delete(CongThuc ct) {
        Transaction transaction = null;
        try (Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ct);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        CongThucRepository ct = new CongThucRepository();
        List<CongThuc> lst = ct.getAll();
        for (CongThuc x : lst) {

        }
   //     new CongThucRepository().getAll().forEach(a -> System.out.println(a.toString()));

    }
}
