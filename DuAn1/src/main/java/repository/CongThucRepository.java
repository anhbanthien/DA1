/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import config.HibernatUtil;
import domainmodel.CongThuc;
import domainmodel.NguyenLieu;
import domainmodel.NhanVien;
import domainmodel.SanPham;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.impl.QlyNhanVienImpl;

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

    public List<CongThuc> getAllBySP(UUID idSP) {
        String sql = fromTable + " WHERE IDSP = :idSP";
        Query query = session.createQuery(sql, CongThuc.class);
        query.setParameter("idSP", idSP);
        List<CongThuc> lists = query.getResultList();
        return lists;
    }

    public CongThuc getOne(UUID idCT) {
        return session.get(CongThuc.class, idCT);

    }

    public CongThuc getOneByTen(String ten) {
//        String sql = fromTable + " WHERE Ten = :ten ";
//        Query query = session.createQuery(sql, SanPham.class);
//        query.setParameter("ten", ten);
//        CongThuc congthuc =  (CongThuc) query.getSingleResult();
//        return congthuc;
        return session.get(CongThuc.class, ten);
    }

    public boolean Add(CongThuc ct) {

        try {
            session.getTransaction().begin();
            session.save(ct);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean Update(UUID idCT, CongThuc ct) {

        try {

            CongThuc st = session.get(CongThuc.class, idCT);
            st.setSanPham(ct.getSanPham());
            st.setTen(ct.getTen());
            st.setMoTa(ct.getMoTa());
            st.setTrangThai(ct.getTrangThai());
            session.getTransaction().begin();
            session.save(st);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean Delete(UUID id) {

        try {
            session.getTransaction().begin();
            session.delete(session.get(CongThuc.class, id));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static void main(String[] args) {
        CongThucRepository ct = new CongThucRepository();
        SanPhamRepository sp = new SanPhamRepository();
        List<CongThuc> lstCT = ct.getAll();
        List<CongThuc> lst = ct.getAllBySP(lstCT.get(0).getSanPham().getIDSP());
//        SanPham SP = sp.getOne(lst.get(0).getSanPham().getIDSP());
////        List<CongThuc> lst = ct.getAllBySP(UUID.fromString("C6121911-A534-9746-941D-8B146F24FE62"));
        for (CongThuc x : lstCT) {
            System.out.println(x.toString());
        }
        System.out.println(lstCT.get(0).getSanPham().getIDSP());
//        System.out.println(SP.toString());
        System.out.println(lst.get(1).getIdCT());
    }
}
