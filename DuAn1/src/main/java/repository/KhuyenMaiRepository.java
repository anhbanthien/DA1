/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.HibernatUtil;
import domainmodel.Ban;
import domainmodel.KhuyenMai;
import java.util.List;
import javax.persistence.Query;
import domainmodel.NhanVien;
import domainmodel.SanPham;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class KhuyenMaiRepository {

    private String fromTable = "From KhuyenMai";

    private Session session = HibernatUtil.getFACTORY().openSession();

    public List<KhuyenMai> getAll() {
        Query query = session.createQuery(fromTable, KhuyenMai.class);
        List<KhuyenMai> listkm = query.getResultList();
        return listkm;
    }

    public boolean add(KhuyenMai khuyenmai) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(khuyenmai);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean update(KhuyenMai km) {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            session.getTransaction().begin();
            session.saveOrUpdate(km);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean delete(KhuyenMai khuyenmai) {
        Transaction transaction = null;
        try ( Session session = HibernatUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(khuyenmai);
            transaction.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public KhuyenMai getOne(String maKM) {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            String HQL = "FROM KhuyenMai WHERE MaKM = :maKM";
            Query query = session.createQuery(HQL, Object.class);
            query.setParameter("maKM", maKM);
            KhuyenMai km = (KhuyenMai) query.getSingleResult();
            return km;
        } catch (Exception e) {
          
            return null;
        }
    }

    public static void main(String[] args) {
        KhuyenMai km = new KhuyenMaiRepository().getOne("KM");
        System.out.println(km);
    }
}
