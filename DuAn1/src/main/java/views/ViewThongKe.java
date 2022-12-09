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
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
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
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import service.impl.HoaDonServiceImpl;
import service.impl.KhachHangServiceImpl;
import service.impl.QuanLyThongKeServiceImpl;
import viewmodel.HoaDonModel;
import viewmodel.KhachHangModel;

/**
 *
 * @author vutuo
 */
public class ViewThongKe extends javax.swing.JFrame {

    /**
     * Creates new form TKe
     */
    private KhachHangServiceImpl impl = new KhachHangServiceImpl();
    private List<KhachHangModel> listKH = impl.getAll();
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtm1 = new DefaultTableModel();
    private DefaultTableModel dtm2 = new DefaultTableModel();
    private DefaultTableModel dtm3 = new DefaultTableModel();
    private HoaDonServiceImpl donServiceImpl = new HoaDonServiceImpl();
    private List<HoaDonModel> listHD = donServiceImpl.getAllHoaDon();
    private QuanLyThongKeServiceImpl serviceImpl = new QuanLyThongKeServiceImpl();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private List<Object[]> listTK = serviceImpl.getList();
    private List<Object[]> listTKKH = serviceImpl.getListTK();
    private List<Object[]> listTKKHMD = serviceImpl.getListTKMD();
    private List<Object[]> listTKSP = serviceImpl.getListSP();
    private List<Object[]> listSPMD = serviceImpl.tkSPMD();
    private List<Object[]> listFillKH = null;
    private List<Object[]> listRong = new ArrayList<>();

    public ViewThongKe() {
        initComponents();
        setLocationRelativeTo(null);
        jTable2.setModel(dtm);
        String headers[] = {"Ngày", "Số đơn thanh toán", "Số lượng sản phẩm", "Tổng tiền"};
        String headers1[] = {"Ngày", "Tên sản phẩm", "Số lượng sản phẩm đã mua", "Tổng hóa đơn", "Điểm tích lũy"};
        String headers2[] = {"Tên sản phẩm", "Số lượng sản phẩm đã bán"};
        String headers3[] = {"IDHD", "Ngày", "Tên sản phẩm", "Số lượng", "Giá"};
        dtm.setColumnIdentifiers(headers);
        jTable3.setModel(dtm1);
        jTable4.setModel(dtm2);
        jTable5.setModel(dtm3);
        dtm1.setColumnIdentifiers(headers1);
        dtm2.setColumnIdentifiers(headers2);
        dtm3.setColumnIdentifiers(headers3);
        // Ngày hôm nay
        String date = java.time.LocalDate.now().toString();
        Date date1 = null;
        try {
            date1 = sdf.parse(java.time.LocalDate.now().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtTien1.setText(tongDoanhThu(listHD, date) + " VNĐ");
        txtHDDB1.setText(soDonDaBan(listHD, date) + "");
        txtSPDB1.setText(serviceImpl.soLuong(date1).get(0) + "");

        // Ngày hôm qua
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        String hq = yesterday.toString();
        Date hq1 = null;
        try {
            hq1 = sdf.parse(hq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtTien2.setText(tongDoanhThu(listHD, hq) + " VNĐ");
        txtHDDB2.setText(soDonDaBan(listHD, hq) + "");
        txtSPDB2.setText(serviceImpl.soLuong(hq1).get(0) + "");
        showData(listTK);
        showDataKH(listTKKHMD);
        showDataSP(listSPMD);

             List<Object[]> listBieuDo = serviceImpl.listBieuDo();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listBieuDo != null) {
            for (Object[] objects : listBieuDo) {
                float f = Float.parseFloat(objects[1]+"");
                long l = (long) f;
                String ngay = objects[0]+"";
                System.out.println(l);
                dataset.setValue(l, "Tổng doanh thu",ngay);
            }
        }
        JFreeChart linechart = ChartFactory.createLineChart("Thống kê doanh thu", "Năm", "Tổng Doanh Thu",
                dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
        // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204, 0, 51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        ChartPanel sd = new ChartPanel(linechart);
        panel.removeAll();
        panel.add(sd, BorderLayout.CENTER);
        panel.validate();

        //
        if (listBieuDo != null) {
            DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
            for (Object[] objects : listBieuDo) {
                float f = Float.parseFloat(objects[1] + "");
                long l = (long) f;
                String ngay = objects[0] + "";
                dataset.addValue(l, "Tổng doanh thu", ngay);
            }
            JFreeChart chart = ChartFactory.createBarChart("THỐNG KÊ DOANH THU", "Thời gian", "Tiền", dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jPanelItem.getWidth(), 230));

            jPanelItem.removeAll();
            jPanelItem.setLayout(new CardLayout());
            jPanelItem.add(chartPanel);
            jPanelItem.validate();
            jPanelItem.repaint();
        }

    }

    private void showData(List<Object[]> list) {
        dtm.setRowCount(0);
        for (Object[] objects : list) {
            dtm.addRow(objects);
        }
    }

    private void showDataKH(List<Object[]> list) {
        dtm1.setRowCount(0);
        for (Object[] objects : list) {
            dtm1.addRow(objects);
        }
    }

    private void showDataSP(List<Object[]> list) {
        dtm2.setRowCount(0);
        for (Object[] objects : list) {
            dtm2.addRow(objects);
        }
    }

    private void showDataDTCT(List<Object[]> list) {
        dtm3.setRowCount(0);
        for (Object[] objects : list) {
            dtm3.addRow(objects);
        }
    }

    private int tongSanPham(List<HoaDonModel> list, Date ngayBD, Date ngayKT) {
        int count = 0;
        Date ngay = null;
        try {
            for (HoaDonModel hoaDonModel : list) {
                ngay = hoaDonModel.getNgayTT();
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
            if (date.equalsIgnoreCase(hoaDon.getNgayTT().toString()) && hoaDon.getTrangThai().equalsIgnoreCase("DTT")) {
                sum += hoaDon.getTongTien();
            }
        }
        return sum;
    }

    private int soDonDaBan(List<HoaDonModel> list, String date) {
        int count = 0;
        for (HoaDonModel hoaDonModel : list) {
            if (date.equalsIgnoreCase(hoaDonModel.getNgayTT().toString()) && hoaDonModel.getTrangThai().equalsIgnoreCase("DTT")) {
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel = new javax.swing.JPanel();
        jPanelItem = new javax.swing.JPanel();

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
                .addGap(28, 28, 28)
                .addComponent(txtTien0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(txtHDDB0)
                            .addGap(66, 66, 66))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(txtSPDB0)
                            .addGap(64, 64, 64))
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7)
                        .addGap(15, 15, 15)))
                .addGap(15, 15, 15))
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
                .addContainerGap(19, Short.MAX_VALUE))
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
                .addContainerGap(22, Short.MAX_VALUE))
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
                .addContainerGap(29, Short.MAX_VALUE))
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
        jLabel12.setText("Thống kê khách hàng");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("THỐNG KÊ DOANH THU");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable4);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Tổng tất cả sản phẩm đã bán được");

        jButton7.setBackground(new java.awt.Color(51, 204, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("TOP");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Thống kê doanh thu chi tiết");

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 0, 0));
        jButton8.setText("X");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(51, 204, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/undo-button.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(51, 204, 0));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Search");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        panel.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Đường", panel);

        javax.swing.GroupLayout jPanelItemLayout = new javax.swing.GroupLayout(jPanelItem);
        jPanelItem.setLayout(jPanelItemLayout);
        jPanelItemLayout.setHorizontalGroup(
            jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );
        jPanelItemLayout.setVerticalGroup(
            jPanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cột", jPanelItem);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(361, 361, 361)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(378, 378, 378)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(txtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel17)
                        .addGap(17, 17, 17)
                        .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(535, 535, 535)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel14))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(20, 20, 20)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(17, 17, 17)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(17, 17, 17)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel12))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String username = "anvtph22489@fpt.edu.vn";
        String password = "evjzzlsbrvrflowx";
        String toEmail = JOptionPane.showInputDialog("Nhập email");
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            String subject = "BÁO CÁO DOANH THU";
            String date = java.time.LocalDate.now().toString();
            Date date1 = null;
            try {
                date1 = sdf.parse(java.time.LocalDate.now().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            String jtext = "Tổng doanh thu hôm nay là : " + tongDoanhThu(listHD, date) + " VNĐ. \nSố đơn đã bán là: " + soDonDaBan(listHD, date) + ""
                    + "\n Tổng số sản phẩm đã bán là: " + serviceImpl.soLuong(date1).get(0).toString();

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );
            message.setSubject(subject);
            message.setText(jtext);
            Transport.send(message);
            JOptionPane.showMessageDialog(this, "Gửi thành công");
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(this, "Gửi thất bại");
            e.printStackTrace();
        }
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
            PdfPTable table = new PdfPTable(4);
            table.addCell("Ngay");
            table.addCell("Tong so don");
            table.addCell("Tong san pham");
            table.addCell("Tong tien");

            for (int i = 0; i < jTable2.getRowCount(); i++) {

                String ngay = jTable2.getValueAt(i, 0).toString();
                String soDon = jTable2.getValueAt(i, 1).toString();
                String tongSP = jTable2.getValueAt(i, 2).toString();
                String tongTien = jTable2.getValueAt(i, 3).toString();

                table.addCell(ngay);
                table.addCell(soDon);
                table.addCell(tongSP);
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
//        DefaultTableModel model = (DefaultTableModel) this.jTable2.getModel();
//        JFileChooser jfc = new JFileChooser("documents");
//        int result = jfc.showSaveDialog(null);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            try {
//                File newFile = jfc.getSelectedFile();
//                newFile = new File(newFile.toString() + ".xlsx");
//                XSSFWorkbook xwb = new XSSFWorkbook();
//                XSSFSheet Diemsheep = xwb.createSheet("Thống kê doanh thu");
//                XSSFRow row = Diemsheep.createRow((short) 0);
//                XSSFCell h;
//                for (int i = 0; i < model.getColumnCount(); i++) {
//                    h = row.createCell((short) i);
//                    h.setCellValue(model.getColumnName(i));
//                }
//
//                XSSFRow row1;
//                XSSFCell a1;
//                for (int i = 0; i < model.getRowCount(); i++) {
//                    row1 = Diemsheep.createRow((short) i + 1);
//                    for (int j = 0; j < model.getColumnCount(); j++) {
//                        a1 = row1.createCell((short) j);
//                        a1.setCellValue(model.getValueAt(i, j).toString());
//                    }
//                }
//                FileOutputStream file = new FileOutputStream(newFile.getAbsoluteFile().getPath());
//                xwb.write(file);
//                xwb.close();
//                file.close();
//                JOptionPane.showMessageDialog(this, "Xuất tệp thành công");
//                openFile(newFile.toString());
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(this, "Xuất tệp thất bại");
//                e.printStackTrace();
//            }
//        }

        Object[] possibilities = {"Doanh thu", "Khách hàng", "Sản phẩm"};
        Object bang = JOptionPane.showInputDialog(this, "Chọn bảng muốn xuất", "Xuất excel", HEIGHT, null, possibilities, DISPOSE_ON_CLOSE);
        if (bang.equals("Doanh thu")) {
            DefaultTableModel model = (DefaultTableModel) this.jTable2.getModel();
            JFileChooser jfc = new JFileChooser("documents");
            int result = jfc.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    File newFile = jfc.getSelectedFile();
                    newFile = new File(newFile.toString() + ".xlsx");
                    XSSFWorkbook xwb = new XSSFWorkbook();
                    XSSFSheet Diemsheep = xwb.createSheet("Thống kê doanh thu");
                    XSSFRow row = Diemsheep.createRow((short) 0);
                    XSSFCell h;
                    for (int i = 0; i < model.getColumnCount(); i++) {
                        h = row.createCell((short) i);
                        h.setCellValue(model.getColumnName(i));
                    }

                    XSSFRow row1;
                    XSSFCell a1;
                    for (int i = 0; i < model.getRowCount(); i++) {
                        row1 = Diemsheep.createRow((short) i + 1);
                        for (int j = 0; j < model.getColumnCount(); j++) {
                            a1 = row1.createCell((short) j);
                            a1.setCellValue(model.getValueAt(i, j).toString());
                        }
                    }
                    FileOutputStream file = new FileOutputStream(newFile.getAbsoluteFile().getPath());
                    xwb.write(file);
                    xwb.close();
                    file.close();
                    JOptionPane.showMessageDialog(this, "Xuất tệp thành công");
                    openFile(newFile.toString());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Xuất tệp thất bại");
                    e.printStackTrace();
                }
            }

        } else if (bang.equals("Khách hàng")) {
            DefaultTableModel model = (DefaultTableModel) this.jTable3.getModel();
            JFileChooser jfc = new JFileChooser("documents");
            int result = jfc.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    File newFile = jfc.getSelectedFile();
                    newFile = new File(newFile.toString() + ".xlsx");
                    XSSFWorkbook xwb = new XSSFWorkbook();
                    XSSFSheet Diemsheep = xwb.createSheet("Thống kê khách hàng");
                    XSSFRow row = Diemsheep.createRow((short) 0);
                    XSSFCell h;
                    for (int i = 0; i < model.getColumnCount(); i++) {
                        h = row.createCell((short) i);
                        h.setCellValue(model.getColumnName(i));
                    }

                    XSSFRow row1;
                    XSSFCell a1;
                    for (int i = 0; i < model.getRowCount(); i++) {
                        row1 = Diemsheep.createRow((short) i + 1);
                        for (int j = 0; j < model.getColumnCount(); j++) {
                            a1 = row1.createCell((short) j);
                            a1.setCellValue(model.getValueAt(i, j).toString());
                        }
                    }
                    FileOutputStream file = new FileOutputStream(newFile.getAbsoluteFile().getPath());
                    xwb.write(file);
                    xwb.close();
                    file.close();
                    JOptionPane.showMessageDialog(this, "Xuất tệp thành công");
                    openFile(newFile.toString());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Xuất tệp thất bại");
                    e.printStackTrace();
                }
            }

        } else if (bang.equals("Sản phẩm")) {
            DefaultTableModel model = (DefaultTableModel) this.jTable4.getModel();
            JFileChooser jfc = new JFileChooser("documents");
            int result = jfc.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    File newFile = jfc.getSelectedFile();
                    newFile = new File(newFile.toString() + ".xlsx");
                    XSSFWorkbook xwb = new XSSFWorkbook();
                    XSSFSheet Diemsheep = xwb.createSheet("Thống kê khách hàng");
                    XSSFRow row = Diemsheep.createRow((short) 0);
                    XSSFCell h;
                    for (int i = 0; i < model.getColumnCount(); i++) {
                        h = row.createCell((short) i);
                        h.setCellValue(model.getColumnName(i));
                    }

                    XSSFRow row1;
                    XSSFCell a1;
                    for (int i = 0; i < model.getRowCount(); i++) {
                        row1 = Diemsheep.createRow((short) i + 1);
                        for (int j = 0; j < model.getColumnCount(); j++) {
                            a1 = row1.createCell((short) j);
                            a1.setCellValue(model.getValueAt(i, j).toString());
                        }
                    }
                    FileOutputStream file = new FileOutputStream(newFile.getAbsoluteFile().getPath());
                    xwb.write(file);
                    xwb.close();
                    file.close();
                    JOptionPane.showMessageDialog(this, "Xuất tệp thành công");
                    openFile(newFile.toString());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Xuất tệp thất bại");
                    e.printStackTrace();
                }
            }
        }

//        try {
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            XSSFSheet sheet = workbook.createSheet("Thong_ke");
//            XSSFRow row = null;
//            Cell cell = null;
//            row = sheet.createRow(0);
//            cell = row.createCell(0, CellType.STRING);
//            cell.setCellValue("Ngày");
//
//            cell = row.createCell(1, CellType.STRING);
//            cell.setCellValue("Tổng số đơn");
//
//            cell = row.createCell(2, CellType.STRING);
//            cell.setCellValue("Tổng sản phẩm");
//
//            cell = row.createCell(3, CellType.STRING);
//            cell.setCellValue("Tổng tiền");
//
//            for (int i = 0; i < listTK.size(); i++) {
//
//                Object[] model = listTK.get(i);
//                row = sheet.createRow(1 + i);
//
//                cell = row.createCell(0, CellType.STRING);
//                cell.setCellValue(model[0].toString());
//
//                cell = row.createCell(1, CellType.STRING);
//                cell.setCellValue(model[1].toString());
//
//                cell = row.createCell(2, CellType.STRING);
//                cell.setCellValue(model[2].toString());
//
//                cell = row.createCell(3, CellType.STRING);
//                cell.setCellValue(model[3].toString());
//
//            }
//            String path = "";
//            JFileChooser chooser = new JFileChooser();
//            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//            int x = chooser.showSaveDialog(this);
//            if (x == JFileChooser.APPROVE_OPTION) {
//                path = chooser.getSelectedFile().getPath();
//            }
//            File f = new File(path + "\\ThongKe.xlsx");
//            try {
//                FileOutputStream fos = new FileOutputStream(f);
//                workbook.write(fos);
//                fos.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace(System.out);
//                JOptionPane.showMessageDialog(null, e.getMessage());
//            } catch (IOException ex) {
//                ex.printStackTrace(System.out);
//            }
//            JOptionPane.showMessageDialog(this, "In thành công");
//        } catch (Exception ex) {
//            ex.printStackTrace(System.out);
//            JOptionPane.showMessageDialog(this, "Lỗi mở file");
//        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int row = jTable2.getSelectedRow();
        Object listTest = listTK.get(row)[0];
        String ngayTT = listTest + "";
        Date date = null;
        try {
            date = sdf.parse(ngayTT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listFillKH = serviceImpl.listThongKeCT(date);
        showDataDTCT(listFillKH);

//        Date ngayBD = txtBatDau.getDate();
//        Date ngayKT = txtKetThuc.getDate();
//        List<Object[]> listDT = serviceImpl.getListDT(ngayBD, ngayKT);
//        Object listTest = listDT.get(row)[0];
//        String ngayTT = listTest + "";
//        Date date = null;
//        try {
//            date = sdf.parse(ngayTT);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(date + "");
//        listFillKH = serviceImpl.listThongKeCT(date);
//        showDataDTCT(listFillKH);
//                Date ngayBD = txtBatDau.getDate();
//        Date ngayKT = txtKetThuc.getDate();
//        List<Object> listTT = serviceImpl.listTongTienNgay(ngayBD, ngayKT);
//        jLabel16.setText("Sản phẩm bán được theo ngày ");
//        jLabel12.setText("Thống kê khách hàng theo ngày");
//        jLabel15.setText("Thống kê doanh thu theo ngày");
//        if (listTT != null) {
//            txtTien0.setText(listTT.get(0) + " VNĐ");
//
//            System.out.println("T");
//        } else {
//            txtTien0.setText("0 VNĐ");
//            System.out.println("D");
//        }
//        txtHDDB0.setText(serviceImpl.listHDNgay(ngayBD, ngayKT).get(0) + "");
//        List<Object> listSL = serviceImpl.soLuongNgay(ngayBD, ngayKT);
//        int tong = 0;
//        for (int i = 0; i < listSL.size(); i++) {
//            tong += Integer.parseInt(serviceImpl.soLuongNgay(ngayBD, ngayKT).get(i) + "");
//        }
//        txtSPDB0.setText(tong + "");
//        List<Object[]> listTKKHSearch = serviceImpl.getListTKKH(ngayBD, ngayKT);
//        List<Object[]> listDT = serviceImpl.getListDT(ngayBD, ngayKT);
//        List<Object[]> listTKSPNgay = serviceImpl.thongKeSPNgay(ngayBD, ngayKT);
//
//        showDataKH(listTKKHSearch);
//        showData(listDT);
//        showDataSP(listTKSPNgay);
//        showDataDTCT(listRong);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jLabel16.setText("Sản phẩm được bán nhiều nhất");
        jLabel12.setText("Khách hàng mua nhiều sản phẩm nhất");
        showDataSP(listTKSP);
        showDataKH(listTKKH);
        showDataDTCT(listRong);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        int row = jTable5.getSelectedRow();
        String idST = listFillKH.get(row)[0] + "";
        UUID id = UUID.fromString(idST);
        List<Object[]> listMouseKH = serviceImpl.listMouse(id);
        jLabel12.setText("Thống kê khách hàng chi tiết");
        showDataKH(listMouseKH);
    }//GEN-LAST:event_jTable5MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        listTK = serviceImpl.getList();
        showData(listTK);
        showDataKH(listTKKHMD);
        showDataSP(listSPMD);
        showDataDTCT(listRong);
        jLabel12.setText("Thống kê khách hàng");
        jLabel16.setText("Tổng tất cả sản phẩm đã bán được");;
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Date ngayBD = txtBatDau.getDate();
        Date ngayKT = txtKetThuc.getDate();
        List<Object> listTT = serviceImpl.listTongTienNgay(ngayBD, ngayKT);

        listTK = serviceImpl.getListDT(ngayBD, ngayKT);

        jLabel16.setText("Sản phẩm bán được theo ngày ");
        jLabel12.setText("Thống kê khách hàng theo ngày");
        jLabel5.setText("Thống kê doanh thu theo ngày");
        if (listTT != null) {
            txtTien0.setText(listTT.get(0) + " VNĐ");
        } else {
            txtTien0.setText("0 VNĐ");
        }
        txtHDDB0.setText(serviceImpl.listHDNgay(ngayBD, ngayKT).get(0) + "");
        List<Object> listSL = serviceImpl.soLuongNgay(ngayBD, ngayKT);
        int tong = 0;
        for (int i = 0; i < listSL.size(); i++) {
            tong += Integer.parseInt(serviceImpl.soLuongNgay(ngayBD, ngayKT).get(i) + "");
        }
        txtSPDB0.setText(tong + "");
        List<Object[]> listTKKHSearch = serviceImpl.getListTKKH(ngayBD, ngayKT);
        List<Object[]> listDT = serviceImpl.getListDT(ngayBD, ngayKT);
        List<Object[]> listTKSPNgay = serviceImpl.thongKeSPNgay(ngayBD, ngayKT);

        showDataKH(listTKKHSearch);
        showData(listDT);
        showDataSP(listTKSPNgay);
        showDataDTCT(listRong);
    }//GEN-LAST:event_jButton10ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanelItem;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JPanel panel;
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

//    public JFreeChart createChart() {
//        JFreeChart barChart = ChartFactory.createBarChart(
//                "BIỂU ĐỒ THỐNG KÊ DOANH THU THEO NĂM",
//                "Năm", "Doanh thu",
//                createDataset(), PlotOrientation.VERTICAL, false, false, false);
//        return barChart;
//    }
//
//    private CategoryDataset createDataset() {
//        List<Object[]> listBieuDo = serviceImpl.listBieuDo();
//        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        if (listBieuDo != null) {
//            for (int i = 0; i < listBieuDo.size(); i++) {
//                double ep = Double.parseDouble(listBieuDo.get(i)[1] + "");
//                String date = "" + listBieuDo.get(i)[0];
//                System.out.println(ep + "");
//                System.out.println(date + "");
//                dataset.setValue(ep, "Tổng Doanh Thu", date);
//            }
//
//        }
//        return dataset;
//    }
    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

}
