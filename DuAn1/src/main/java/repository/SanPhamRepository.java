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
import viewmodel.QLSanPham;

public class SanPhamRepository {

    Session session = HibernatUtil.getFACTORY().openSession();
    private String fromTable = "FROM SanPham";

    public List<SanPham> getAll() {
        Query query = session.createQuery(fromTable, SanPham.class);
        List<SanPham> lists = query.getResultList();
        return lists;
    }

    public List<Object[]> getTen() {
        String HQL = "select HD.IDSP, SP.TenSP from HDCT HD join SanPham SP on HD.IDSP  = SP.IDSP";
        Query query = session.createQuery(HQL);
        List<Object[]> lists = query.getResultList();
        return lists;
    }

    public SanPham getOne(UUID id) {
        String sql = fromTable + " WHERE IDSP = :id ";
        Query query = session.createQuery(sql, SanPham.class);
        query.setParameter("id", id);
        SanPham sanPham = (SanPham) query.getSingleResult();
        return sanPham;
    }

    public SanPham getOneByTen(String ten) {
        String sql = fromTable + " WHERE TenSP = :ten ";
        Query query = session.createQuery(sql, SanPham.class);
        query.setParameter("ten", ten);
        SanPham sanPham = (SanPham) query.getSingleResult();
        return sanPham;
    }

    public boolean Add(SanPham sp) {
        try {
            session.getTransaction().begin();
            session.save(sp);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean Update(UUID id, SanPham sp) {
        try {
            SanPham st = session.get(SanPham.class, id);
            st.setGia(sp.getGia());
            st.setImage(sp.getImage());
            st.setMoTa(sp.getMoTa());
            st.setTenSP(sp.getTenSP());
            st.setTrangThai(sp.getTrangThai());
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
            session.delete(session.get(SanPham.class, id));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
