/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.HibernatUtil;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import model.NhanVien;
import org.hibernate.Session;

public class NhanVienRepository {

    Session session = HibernatUtil.getFACTORY().openSession();
    private String fromTable = "FROM NhanVien"; // HQL 

    public List<NhanVien> getAll() {
        Query query = session.createQuery(fromTable, NhanVien.class);
        List<NhanVien> lists = query.getResultList();
        return lists;
    }

    public NhanVien getOne(UUID ID) {
        return session.get(NhanVien.class, ID);
    }

    public boolean Save(NhanVien Staff) {
        try {
            session.getTransaction().begin();
            session.save(Staff);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Update(UUID Id, NhanVien Staff) {
        try {

            NhanVien st = session.get(NhanVien.class, Id);
            st.setEmail(Staff.getEmail());
            st.setGioiTinh(Staff.getGioiTinh());
            st.setHoTen(Staff.getHoTen());
            st.setSDT(Staff.getSDT());
            st.setTrangThai(Staff.getTrangThai());
            session.getTransaction().begin();
            session.save(st);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Delete(UUID Id) {
        try {
            session.getTransaction().begin();
            session.delete(session.get(NhanVien.class, Id));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
