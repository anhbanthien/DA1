/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.HibernatUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author vutuo
 */
public class ThongKeRepository {
     private Session session = HibernatUtil.getFACTORY().openSession();
      public List<Object[]> listThongKe() {
        String HQL = "select H.NgayTT, COUNT(H.NgayTT), SUM(H.TongTien)  from HoaDon H GROUP BY H.NgayTT ORDER BY H.NgayTT DESC";
        Query query = session.createQuery(HQL, Object[].class);
        List<Object[]> lists = query.getResultList();
        return lists;
    }
      public static void main(String[] args) {
        List<Object[]> list = new ThongKeRepository().listThongKe();
          for (Object[] objects : list) {
              String date = (String) objects[0];
              System.out.println(date);
          }
    }
}
