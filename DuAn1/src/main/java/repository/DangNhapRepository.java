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
import domainmodel.NhanVien;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public Object[] checkInfoLogin(String Account) {

        String query = "SELECT DN.TenTaiKhoan , DN.MatKhau FROM DangNhap DN JOIN  NhanVien NV ON DN.IdNhanVien = NV.IdNhanVien WHERE NV.TrangThai = 'OFF' AND DN.TenTaiKhoan = :tk";
        Query q = session.createQuery(query);
        q.setParameter("tk", Account);
        List<Object[]> countCus = q.getResultList();
        return countCus.get(0);

    }

    public List<DangNhap> getAll() {
        Query query = session.createQuery(fromTable, DangNhap.class);
        List<DangNhap> lists = query.getResultList();
        return lists;
    }

    public List<Object[]> checkAccountByIdStaff() {
        Query q = session.createQuery("SELECT DN.TenTaiKhoan,DN.MatKhau FROM NhanVien NV JOIN DangNhap DN ON NV.IdNhanVien = DN.IdNhanVien ");
        List<Object[]> countCus = q.getResultList();
        return countCus;
    }

    public static void main(String[] args) {

        String textResuilt = "";
        try {
            new DangNhapRepository().checkInfoLogin("anhbanthien");
            textResuilt = "TK ĐÃ BỊ KHOÁ";
        } catch (Exception e) {
            textResuilt = "OKE";
        }
        System.out.println(textResuilt);

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

    public boolean Update(DangNhap Login) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(Login);
            transaction.commit();
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
