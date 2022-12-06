/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.HibernatUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author vutuo
 */
public class ThongKeRepository {

    private Session session = HibernatUtil.getFACTORY().openSession();
    private static final Logger logger = Logger.getLogger(ThongKeRepository.class);

    public List<Object[]> listThongKe() {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            String HQL = " select H.NgayTT, COUNT(H.NgayTT) AS TONGHD,  SUM(HD.SoLuong) as TONGSL,  SUM(H.TongTien) AS TONGTIEN from HoaDon H JOIN HDCT HD ON H.IDHD = HD.IDHD where H.TrangThai = 'DTT' GROUP BY H.NgayTT ORDER BY H.NgayTT DESC";
            Query query = session.createQuery(HQL, Object[].class);
            List<Object[]> lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }

    }

    public List<Object[]> listThongKeCT(Date ngayTT) {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            String HQL = "	 select  H.NgayTT, H.IDHD, SP.TenSP AS TEN, HD.SoLuong,SP.Gia from HDCT HD join SanPham SP on HD.IDSP  = SP.IDSP JOIN HoaDon H ON H.IDHD = HD.IDHD WHERE H.TrangThai = 'DTT' AND H.NgayTT = :ngay";
            Query query = session.createQuery(HQL);
            query.setParameter("ngay", ngayTT);
            List<Object[]> lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }

    }

    public List<Object[]> listThongKeDT(Date ngayBD, Date ngayKT) {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            String HQL = "   select H.NgayTT, COUNT(H.NgayTT) AS TONGHD,  SUM(HD.SoLuong) as TONGSL,  SUM(H.TongTien) AS TONGTIEN from HoaDon H JOIN HDCT HD ON H.IDHD = HD.IDHD where H.TrangThai = 'DTT' AND H.NgayTT BETWEEN  :ngayBD AND  :ngayKT GROUP BY H.NgayTT ORDER BY H.NgayTT DESC";
            Query query = session.createQuery(HQL, Object[].class);
            query.setParameter("ngayBD", ngayBD);
            query.setParameter("ngayKT", ngayKT);
            List<Object[]> lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }

    }

    public List<Object[]> listThongKeKH() {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            String HQL = "   select KH.Ten, KH.SoDienThoai,SUM(HD.SoLuong) AS SL, COUNT(H.IDKH) AS TONGHD, KH.DiemTichLuy from HoaDon H JOIN HDCT HD ON H.IDHD = HD.IDHD JOIN KhachHang KH ON H.IDKH = KH.IdKhachHang WHERE H.TrangThai = 'DTT' GROUP BY KH.Ten, KH.DiemTichLuy, KH.SoDienThoai ORDER BY SUM(HD.SoLuong) DESC";
            Query query = session.createQuery(HQL, Object[].class);
            List<Object[]> lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }

    }

    public List<Object[]> listThongKeKHMacDinh() {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            String HQL = "   select KH.Ten, KH.SoDienThoai,SUM(HD.SoLuong) AS SL, COUNT(H.IDKH) AS TONGHD, KH.DiemTichLuy from HoaDon H JOIN HDCT HD ON H.IDHD = HD.IDHD JOIN KhachHang KH ON H.IDKH = KH.IdKhachHang WHERE H.TrangThai = 'DTT' GROUP BY KH.Ten, KH.DiemTichLuy, KH.SoDienThoai";
            Query query = session.createQuery(HQL, Object[].class);
            List<Object[]> lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }

    }

    public List<Object[]> listThongKeKHSearch(Date ngayBD, Date ngayKT) {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            String HQL = "   select KH.Ten, KH.SoDienThoai,SUM(HD.SoLuong) AS SL, COUNT(H.IDKH) AS TONGHD, KH.DiemTichLuy from HoaDon H JOIN HDCT HD ON H.IDHD = HD.IDHD JOIN KhachHang KH ON H.IDKH = KH.IdKhachHang WHERE H.TrangThai = 'DTT' AND H.NgayTT BETWEEN  :ngayBD AND  :ngayKT GROUP BY KH.Ten, KH.DiemTichLuy, KH.SoDienThoai ORDER BY SUM(HD.SoLuong) DESC";
            Query query = session.createQuery(HQL, Object[].class);
            query.setParameter("ngayBD", ngayBD);
            query.setParameter("ngayKT", ngayKT);
            List<Object[]> lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }

    }

    public List<Object[]> listThongKeSP() {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            String HQL = "	 select SP.TenSP, SUM(HD.SoLuong) from HDCT HD join SanPham SP on HD.IDSP  = SP.IDSP JOIN HoaDon H ON H.IDHD = HD.IDHD WHERE H.TrangThai = 'DTT' AND SP.TrangThai = 1 GROUP BY SP.TenSP ORDER BY SUM(HD.SoLuong) DESC";
            Query query = session.createQuery(HQL);
            List<Object[]> lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public List<Object[]> listThongKeSPMD() {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            String HQL = "	 select SP.TenSP, SUM(HD.SoLuong) from HDCT HD join SanPham SP on HD.IDSP  = SP.IDSP JOIN HoaDon H ON H.IDHD = HD.IDHD WHERE H.TrangThai = 'DTT' AND SP.TrangThai = 1 GROUP BY SP.TenSP ";
            Query query = session.createQuery(HQL);
            List<Object[]> lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public List<Object[]> listThongKeSPNgay(Date ngayBD, Date ngayKT) {
        try ( Session session = HibernatUtil.getFACTORY().openSession();) {
            String HQL = "	 select SP.TenSP, SUM(HD.SoLuong) from HDCT HD join SanPham SP on HD.IDSP  = SP.IDSP JOIN HoaDon H ON H.IDHD = HD.IDHD WHERE H.TrangThai = 'DTT' AND SP.TrangThai = 1 AND H.NgayTT BETWEEN :ngayBD AND :ngayKT GROUP BY SP.TenSP ";
            Query query = session.createQuery(HQL);
            query.setParameter("ngayBD", ngayBD);
            query.setParameter("ngayKT", ngayKT);
            List<Object[]> lists = query.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public List<Object> soLuong(Date date) {
        String HQL = " SELECT SUM(HD.SoLuong) FROM HoaDon H JOIN HDCT HD ON H.IDHD = HD.IDHD WHERE H.TrangThai = 'DTT' AND H.NgayTT = :ngayTT GROUP BY H.NgayTT";
        Query query = session.createQuery(HQL, Object.class);
        query.setParameter("ngayTT", date);
        List<Object> list = query.getResultList();
        if (list.isEmpty()) {
            List<Object> listRong = new ArrayList<>();
            listRong.add("0");
            return listRong;
        } else {
            return list;
        }
    }

    public List<Object> soLuongNgay(Date ngayBD, Date ngayKT) {
        String HQL = "SELECT SUM(HD.SoLuong) FROM HoaDon H JOIN HDCT HD ON H.IDHD = HD.IDHD WHERE H.TrangThai = 'DTT' AND H.NgayTT BETWEEN  :ngayBD AND  :ngayKT GROUP BY H.NgayTT";
        Query query = session.createQuery(HQL, Object.class);
        query.setParameter("ngayBD", ngayBD);
        query.setParameter("ngayKT", ngayKT);
        List<Object> list = query.getResultList();
        if (list.isEmpty()) {
            List<Object> listRong = new ArrayList<>();
            listRong.add("0");
            return listRong;
        } else {
            return list;
        }
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        Date date = null;
        try {
            d = sdf.parse("2022-12-01");
            date = sdf.parse("2022-12-05");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ThongKeRepository().listThongKeSPNgay(d, date).forEach(s -> System.out.println(s.toString()));
    }
}
