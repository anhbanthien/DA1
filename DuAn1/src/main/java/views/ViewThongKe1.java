/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import domainmodel.HoaDon;
import domainmodel.KhachHang;
import java.awt.CardLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import service.impl.HoaDonServiceImpl;
import service.impl.KhachHangServiceImpl;
import service.impl.ThongKeServiceImpl;
import viewmodel.HoaDonModel;
import viewmodel.KhachHangModel;


/**
 *
 * @author vutuo
 */
public class ViewThongKe1 extends javax.swing.JFrame {

    /**
     * Creates new form TKe
     */
    private KhachHangServiceImpl impl = new KhachHangServiceImpl();
    private List<KhachHangModel> listKH = impl.getAll();
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtm1 = new DefaultTableModel();
    private HoaDonServiceImpl donServiceImpl = new HoaDonServiceImpl();
    private List<HoaDonModel> listHD = donServiceImpl.getAllHoaDon();
    private ThongKeServiceImpl serviceImpl = new ThongKeServiceImpl();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private List<Object[]> listTK = serviceImpl.getList();

    public ViewThongKe1() {
        initComponents();
        setLocationRelativeTo(null);
        jTable2.setModel(dtm);
        String headers[] = {"Ngày", "Số đơn thanh toán", "Số lượng sản phẩm", "Tổng tiền"};
        String headers1[] = {"Ngày", "Tên sản phẩm", "Số lượng sản phẩm", "Tổng tiền"};
        dtm.setColumnIdentifiers(headers);
        jTable3.setModel(dtm1);
        dtm1.setColumnIdentifiers(headers1);
        // Ngày hôm nay
        String date = java.time.LocalDate.now().toString();
        txtTien1.setText(tongDoanhThu(listHD, date) + " VNĐ");
        txtHDDB1.setText(soDonDaBan(listHD, date) + "");
        txtSPDB1.setText(serviceImpl.soLuong(date).get(0) + "");

        // Ngày hôm qua
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        String hq = yesterday.toString();
        System.out.println(hq);
        txtTien2.setText(tongDoanhThu(listHD, hq) + " VNĐ");
        txtHDDB2.setText(soDonDaBan(listHD, hq) + "");
        txtSPDB2.setText(serviceImpl.soLuong(hq).get(0) + "");
        showData(listTK);

    }

    private void showData(List<Object[]> list) {
        dtm.setRowCount(0);
        for (Object[] objects : list) {
            dtm.addRow(objects);
        }
    }

    private float tongDoanhThuNgay(List<HoaDonModel> list, Date ngayBD, Date ngayKT) {

        Date dateBD = ngayBD;
        Date dateKT = ngayKT;
        Date ngay = null;
        float sum = 0;
        try {
            for (HoaDonModel hoaDonModel : list) {
                ngay = sdf.parse(hoaDonModel.getNgayTT());
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        for (HoaDonModel hoaDonModel : list) {
            if (dateBD.compareTo(ngay) <= 0 && dateKT.compareTo(ngay) >= 0 && hoaDonModel.getTrangThai().equalsIgnoreCase("DTT")) {
                sum += hoaDonModel.getTongTien();
            }
        }
        return sum;
    }

    private int soDonDaBanNgay(List<HoaDonModel> list, Date ngayBD, Date ngayKT) {
        int count = 0;
        Date ngay = null;
        try {
            for (HoaDonModel hoaDonModel : list) {
                ngay = sdf.parse(hoaDonModel.getNgayTT());
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        for (HoaDonModel hoaDonModel : list) {
            if (ngayBD.compareTo(ngay) <= 0 && ngayKT.compareTo(ngay) >= 0 && hoaDonModel.getTrangThai().equalsIgnoreCase("DTT")) {
                count += 1;
            }
        }
        return count;
    }
   private int tongSanPham(List<HoaDonModel> list, Date ngayBD, Date ngayKT) {
        int count = 0;
        Date ngay = null;
        try {
            for (HoaDonModel hoaDonModel : list) {
                ngay = sdf.parse(hoaDonModel.getNgayTT());
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        for (HoaDonModel hoaDonModel : list) {
            if (ngayBD.compareTo(ngay) <= 0 && ngayKT.compareTo(ngay) >= 0 && hoaDonModel.getTrangThai().equalsIgnoreCase("DTT")) {
                count += 1;
            }
        }
        return count;
    }

    
    private float tongDoanhThu(List<HoaDonModel> list, String date) {
        float sum = 0;
        for (HoaDonModel hoaDon : list) {
            if (date.equalsIgnoreCase(hoaDon.getNgayTT()) && hoaDon.getTrangThai().equalsIgnoreCase("DTT")) {
                sum += hoaDon.getTongTien();
            }
        }
        return sum;
    }

    private int soDonDaBan(List<HoaDonModel> list, String date) {
        int count = 0;
        for (HoaDonModel hoaDonModel : list) {
            if (date.equalsIgnoreCase(hoaDonModel.getNgayTT()) && hoaDonModel.getTrangThai().equalsIgnoreCase("DTT")) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtTien0 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHDDB0 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSPDB0 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtTien1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHDDB1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSPDB1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtTien2 = new javax.swing.JLabel();
        txtHDDB2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSPDB2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtBatDau = new com.toedter.calendar.JDateChooser();
        txtKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 51, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 678));

        jButton2.setBackground(new java.awt.Color(51, 204, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Xuất Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 204, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("In");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 204, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Gửi Mail ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("THỐNG KÊ DOANH THU");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Doanh thu theo ngày");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Doanh thu ngày hôm nay");

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        txtTien0.setBackground(new java.awt.Color(255, 255, 255));
        txtTien0.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTien0.setForeground(new java.awt.Color(204, 0, 0));
        txtTien0.setText("0 VNĐ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Tổng hóa đơn đã bán ");

        txtHDDB0.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtHDDB0.setForeground(new java.awt.Color(255, 255, 255));
        txtHDDB0.setText("0");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Tổng số sản phẩm đã bán ");

        txtSPDB0.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtSPDB0.setForeground(new java.awt.Color(255, 255, 255));
        txtSPDB0.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtHDDB0)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSPDB0)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(16, 16, 16))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTien0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtTien0)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHDDB0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSPDB0)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

        txtTien1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTien1.setForeground(new java.awt.Color(204, 0, 0));
        txtTien1.setText("0 VNĐ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Tổng hóa đơn đã bán");

        txtHDDB1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtHDDB1.setForeground(new java.awt.Color(255, 255, 255));
        txtHDDB1.setText("0");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Tổng số sản phẩm đã bán ");

        txtSPDB1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtSPDB1.setForeground(new java.awt.Color(255, 255, 255));
        txtSPDB1.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(txtSPDB1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtHDDB1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(14, 14, 14))
                    .addComponent(txtTien1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtTien1)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHDDB1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSPDB1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 204, 255));

        txtTien2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTien2.setForeground(new java.awt.Color(204, 0, 0));
        txtTien2.setText("0 VNĐ");

        txtHDDB2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtHDDB2.setForeground(new java.awt.Color(255, 255, 255));
        txtHDDB2.setText("0");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Tổng số sản phẩm đã bán ");

        txtSPDB2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtSPDB2.setForeground(new java.awt.Color(255, 255, 255));
        txtSPDB2.setText("0");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Tổng hóa đơn đã bán");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(txtSPDB2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txtHDDB2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTien2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtTien2)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHDDB2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSPDB2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Doanh thu ngày hôm qua");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Thống kê doanh thu");

        txtBatDau.setDateFormatString("yyyy-MM-dd");

        txtKetThuc.setDateFormatString("yyyy-MM-dd");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Từ ngày");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Đến ngày");

        jButton5.setBackground(new java.awt.Color(51, 204, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Thống kê doanh thu chi tiết");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(txtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel6)))
                        .addGap(30, 30, 30))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//        String toEmail = JOptionPane.showInputDialog("Nhập email");
//        String fromEmail = "vutuongan2003@gmail.com";
//        String fromEmailPass = "An@0383082214";
//        String subject = "BÁO CÁO DOANH THU";
//        String date = java.time.LocalDate.now().toString();
//        txtTien0.setText(tongDoanhThu(listHD, date) + " VNĐ");
//        txtHDDB0.setText(soDonDaBan(listHD, date) + "");
//        String jtext = "Tổng doanh thu hôm nay là : " + tongDoanhThu(listHD, date) + " VNĐ. Và số đơn đã bán là: " + soDonDaBan(listHD, date) + "";
//        Properties p = new Properties();
//        p.put("mail.smtp.auth", "true");
//        p.put("mail.smtp.host", "smtp.gmail.com");
//        p.put("mail.smtp.port", "587");
//        p.put("mail.smtp.starttls.enable", "true");
//        javax.mail.Session session = javax.mail.Session.getDefaultInstance(p, new Authenticator() {
//            protected PasswordAuthentication gePasswordAuthentication() {
//                return new PasswordAuthentication(fromEmail, fromEmailPass);
//            }
//        });
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(fromEmail));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//            message.setSubject(subject);
//            message.setText(subject);
//            message.setText(jtext);
//            Transport.send(message);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.stmp.user", "username");
//
//        //To use TLS
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.password", "password");
//        //To use SSL
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class",
//                "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "465");
//
//        Session session = Session.getDefaultInstance(props, null);
//        String to = JOptionPane.showInputDialog("Nhập email");
//        String from = "from@gmail.com";
//        String subject = "Testing...";
//        Message msg = new MimeMessage(session);
//        try {
//            msg.setFrom(new InternetAddress(from));
//            msg.setRecipient(Message.RecipientType.TO,
//                    new InternetAddress(to));
//            msg.setSubject(subject);
//            msg.setText("Working fine..!");
//            Transport transport = session.getTransport("smtp");
//            transport.connect("smtp.gmail.com", 465, "username", "password");
//            transport.send(msg);
//            System.out.println("fine!!");
//        } catch (Exception exc) {
//            System.out.println(exc);
//        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String path = "";
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = chooser.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getPath();
        }
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path + "ThongKe.pdf"));

            document.open();

            //            document.add(new Paragraph("THỐNG KÊ DOANH THU"));
            PdfPTable table = new PdfPTable(3);
            table.addCell("Ngày");
            table.addCell("Tổng số đơn");
            table.addCell("Tổng tiền");

            for (int i = 0; i < jTable2.getRowCount(); i++) {

                String ngay = jTable2.getValueAt(i, 0).toString();
                String soDon = jTable2.getValueAt(i, 1).toString();
                String tongTien = jTable2.getValueAt(i, 2).toString();

                table.addCell(ngay);
                table.addCell(soDon);
                table.addCell(tongTien);
            }
            document.add(table);

            JOptionPane.showMessageDialog(this, "In thành công");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ViewThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.close();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Thong_ke");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(0);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Ngày");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tổng số đơn");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Tổng tiền");

            for (int i = 0; i < listTK.size(); i++) {
                //                KhachHangModel model = listKH.get(i);
                Object[] model = listTK.get(i);
                row = sheet.createRow(1 + i);

                //                cell = row.createCell(0, CellType.NUMERIC);
                //                cell.setCellValue(i + 1);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(model[0].toString());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(model[1].toString());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(model[2].toString());
                //
                //                cell = row.createCell(4, CellType.STRING);
                //                cell.setCellValue(listKH.get(i).getTrangThai());
            }
            File f = new File("E:\\DuAn_1\\ThongKe.xlsx");
            try {
                FileOutputStream fos = new FileOutputStream(f);
                workbook.write(fos);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
            JOptionPane.showMessageDialog(this, "In thành công");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            JOptionPane.showMessageDialog(this, "Lỗi mở file");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        Date ngayBD = txtBatDau.getDate();
        Date ngayKT = txtKetThuc.getDate();

        txtTien0.setText(tongDoanhThuNgay(listHD, ngayBD, ngayKT) + " VNĐ");
        txtHDDB0.setText(soDonDaBanNgay(listHD, ngayBD, ngayKT) + "");
      //  List<Object> list = serviceImpl.soLuongNgay(listTK, ngayBD, ngayKT);
//        Date ngay = null;
//         try {
//            for (HoaDonModel hoaDonModel : listHD) {
//                ngay = sdf.parse(hoaDonModel.getNgayTT());
//            }
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        float sum =0;
//        for (HoaDonModel hoaDonModel : listHD) {
//            if (ngayBD.compareTo(ngay) <= 0 && ngayKT.compareTo(ngay) >= 0) {
//                sum += hoaDonModel.getTongTien();
//            }
//        }
//        txtSPDB0.setText(sum+"");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int row = jTable2.getSelectedRow();
        Object[] listTest = listTK.get(row);
//        String ngayTT = listTest.[0];
    }//GEN-LAST:event_jTable2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewThongKe1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewThongKe1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewThongKe1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewThongKe1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewThongKe1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private com.toedter.calendar.JDateChooser txtBatDau;
    private javax.swing.JLabel txtHDDB0;
    private javax.swing.JLabel txtHDDB1;
    private javax.swing.JLabel txtHDDB2;
    private com.toedter.calendar.JDateChooser txtKetThuc;
    private javax.swing.JLabel txtSPDB0;
    private javax.swing.JLabel txtSPDB1;
    private javax.swing.JLabel txtSPDB2;
    private javax.swing.JLabel txtTien0;
    private javax.swing.JLabel txtTien1;
    private javax.swing.JLabel txtTien2;
    // End of variables declaration//GEN-END:variables
}