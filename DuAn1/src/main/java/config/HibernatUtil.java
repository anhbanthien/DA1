/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import domainmodel.Ban;
import domainmodel.CongThuc;
import java.util.Properties;
import domainmodel.DangNhap;
import domainmodel.NhanVien;
import domainmodel.HoaDon;
import domainmodel.HDCT;
import domainmodel.KhachHang;
import domainmodel.KhuyenMai;
import domainmodel.NguyenLieu;

import domainmodel.SanPham;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernatUtil {

    private static final SessionFactory FACTORY;

    static {

        Configuration conf = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=DuAn1");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "hieuhlu97@");
        properties.put(Environment.SHOW_SQL, "true");
        conf.setProperties(properties);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(DangNhap.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HDCT.class);
        conf.addAnnotatedClass(KhuyenMai.class);
        conf.addAnnotatedClass(CongThuc.class);
        conf.addAnnotatedClass(NguyenLieu.class);
        conf.addAnnotatedClass(Ban.class);
        conf.addAnnotatedClass(SanPham.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
        System.out.println("");
    }

}
