/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import config.HibernatUtil;
import domainmodel.CongThuc;
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

    CongThucRepository congThucRepository = new CongThucRepository();
    Session session = HibernatUtil.getFACTORY().openSession();
    private String fromTable = "FROM NguyenLieu";

    public List<NguyenLieu> getAll() {
        Query query = session.createQuery(fromTable, NguyenLieu.class);
        List<NguyenLieu> lists = query.getResultList();
        return lists;
    }

    public List<NguyenLieu> getByCT(UUID idCT) {
        String sql = fromTable + " WHERE IDCT = :idCT ";
        Query query = session.createQuery(sql, NguyenLieu.class);
        query.setParameter("idCT", idCT);
        List<NguyenLieu> lists = query.getResultList();
        return lists;
    }

    public NguyenLieu getOne(UUID idNL) {
        return session.get(NguyenLieu.class, idNL);
    }

    public NguyenLieu getOneByTen(String tenNL) {
        String sql = fromTable + " WHERE TenNL = :tenNL ";
        Query query = session.createQuery(sql, NguyenLieu.class);
        query.setParameter("tenNL", tenNL);
        NguyenLieu nguyenLieu = (NguyenLieu) query.getSingleResult();
        return nguyenLieu;
    }

    public boolean Add(NguyenLieu nl) {
//        Transaction transaction = null;
//        try (Session session = HibernatUtil.getFACTORY().openSession()) {
//            transaction = session.beginTransaction();
//            session.save(nl);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }

        try {
            session.getTransaction().begin();
            session.save(nl);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Update(UUID idNL, NguyenLieu nl) {
//        Transaction transaction = null;
//        try (Session session = HibernatUtil.getFACTORY().openSession()) {
//            transaction = session.beginTransaction();
//            session.saveOrUpdate(nl);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
        try {
            NguyenLieu st = session.get(NguyenLieu.class, idNL);
            st.setCongthuc(nl.getCongthuc());
            st.setDvt(nl.getDvt());
            st.setHsd(nl.getHsd());
            st.setNgayNhap(nl.getNgayNhap());
            st.setSoLuong(nl.getSoLuong());
            st.setTenNL(nl.getTenNL());
            session.getTransaction().begin();
            session.save(st);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Delete(UUID id) {
//        Transaction transaction = null;
//        try (Session session = HibernatUtil.getFACTORY().openSession()) {
//            transaction = session.beginTransaction();
//            session.delete(nl);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
        try {
            session.getTransaction().begin();
            session.delete(session.get(NguyenLieu.class, id));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static void main(String[] args) {
        CongThucRepository congThucRepository = new CongThucRepository();
        NguyenLieuRepository nl = new NguyenLieuRepository();
        List<NguyenLieu> lst = nl.getByCT(congThucRepository.getAll().get(0).getIdCT());
        for (NguyenLieu x : lst) {
            System.out.println(x.toString());
        }
        //  nl.Delete(lst.get(4));
    }
}
