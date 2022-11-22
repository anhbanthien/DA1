/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.HibernatUtil;
import java.util.List;
import javax.persistence.Query;
import domainmodel.BanChiTiet;
import org.hibernate.Session;
import reponse.BanChiTietReponse;

/**
 *
 * @author vutuo
 */
public class BanChiTietRepository {

    private Session session = HibernatUtil.getFACTORY().openSession();
    private String fromTable = "FROM BanChiTiet";

    public List<BanChiTiet> getAll() {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            Query q = session.createQuery("FROM BanChiTiet");
            List<BanChiTiet> list = q.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public Boolean add(BanChiTiet bct) {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            session.getTransaction().begin();
            session.save(bct);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public Boolean update(BanChiTiet bct) {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            session.getTransaction().begin();
            session.saveOrUpdate(bct);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public Boolean delete(BanChiTiet bct) {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            session.getTransaction().begin();
            session.delete(bct);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }
    public static void main(String[] args) {
        BanChiTietRepository repository = new BanChiTietRepository();
        List<BanChiTiet> list = repository.getAll();
        for (BanChiTiet banChiTiet : list) {
            System.out.println(banChiTiet.toString());
        }
    }
}
