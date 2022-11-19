/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.HibernatUtil;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import domainmodel.DangNhap;
import org.hibernate.Session;

public class DangNhapRepository {

    Session session = HibernatUtil.getFACTORY().openSession();
    private String fromTable = "FROM DangNhap"; // HQL 

    public DangNhap CheckLogin(String Account, String Password) {

        String sql = fromTable + " WHERE TenTaiKhoan =:tk and MatKhau = :mk";
        Query query = session.createQuery(sql, DangNhap.class);
        query.setParameter("tk", Account);
        query.setParameter("mk", Password);
        try {
            DangNhap log = (DangNhap) query.getSingleResult();
            if (log.getTenTaiKhoan().equalsIgnoreCase(Account) && log.getMatKhau().equalsIgnoreCase(Password)) {
                return log;
            }
        } catch (Exception e) {

        }
        return null;

    }

    public static void main(String[] args) {
        System.out.println(new DangNhapRepository().CheckLogin("staff", "123").toString());
    }

    public List<DangNhap> getAll() {
        Query query = session.createQuery(fromTable, DangNhap.class);
        List<DangNhap> lists = query.getResultList();
        return lists;
    }

    public DangNhap getOne(String Account) {
        return session.get(DangNhap.class, Account);
    }

    public boolean Save(DangNhap Login) {
        try {
            session.getTransaction().begin();
            session.save(Login);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Update(DangNhap Login, String Account) {
        try {
            DangNhap lg = session.get(DangNhap.class, Account);
            lg.setTenTaiKhoan(Login.getTenTaiKhoan());
            lg.setMatKhau(Login.getMatKhau());
            lg.setQuyen(Login.getQuyen());
            lg.setIdNhanVien(Login.getIdNhanVien());
            session.getTransaction().begin();
            session.save(Login);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Delete(String Account) {
        try {
            session.getTransaction().begin();
            session.delete(session.get(DangNhap.class, Account));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
