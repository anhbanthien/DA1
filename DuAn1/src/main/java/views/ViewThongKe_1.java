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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
public class ViewThongKe_1 extends javax.swing.JFrame {

    /**
     * Creates new form TKe
     */
    private KhachHangServiceImpl impl = new KhachHangServiceImpl();
    private List<KhachHangModel> listKH = impl.getAll();
    private DefaultTableModel dtm = new DefaultTableModel();
    private HoaDonServiceImpl donServiceImpl = new HoaDonServiceImpl();
    private List<HoaDonModel> listHD = donServiceImpl.getAllHoaDon();
    private ThongKeServiceImpl serviceImpl = new ThongKeServiceImpl();
    private List<Object[]> listTK = serviceImpl.getList();

    public ViewThongKe_1() {
        initComponents();
        setLocationRelativeTo(null);
        jTable2.setModel(dtm);
        String headers[] = {"Ngày", "Số đơn thanh toán", "Tổng tiền"};
        dtm.setColumnIdentifiers(headers);

        String date = java.time.LocalDate.now().toString();
        txtTien.setText(tongDoanhThu(listHD, date) + " VNĐ");
        txtDaTT.setText(soDonDaBan(listHD, date) + "");
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        String hq = yesterday.toString();
        txtHomQua.setText(tongDoanhThu(listHD, hq) + " VNĐ");
        txtTongHQ.setText(soDonDaBan(listHD, hq) + "");

        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        LocalDate initial = LocalDate.of(year, month, day);
        String start = initial.withDayOfMonth(1).toString();
        String end = initial.withDayOfMonth(initial.getMonth().length(initial.isLeapYear())).toString();

        String[] intNgay = start.split("-");
        String ngayDau = intNgay[0] + intNgay[1] + intNgay[2];

        String[] intN = end.split("-");
        String ngayCuoi = intN[0] + intN[1] + intN[2];

        int ngayD = Integer.parseInt(ngayDau);
        int ngayC = Integer.parseInt(ngayCuoi);
        System.out.println(ngayD);
        txtTien1.setText(tongDoanhThu(listHD, ngayD, ngayC) + " VNĐ");
        txtDaTT1.setText(soDonDaBan(listHD, ngayD, ngayC) + "");
        showData(listTK);

//frame.add(datePicker);
    }

    private void showData(List<Object[]> list) {
        dtm.setRowCount(0);
        for (Object[] objects : list) {
            dtm.addRow(objects);
        }
    }

    private float tongDoanhThu(List<HoaDonModel> list, int start, int end) {
        float sum = 0;
        for (HoaDonModel hoaDon : list) {
            String ngayTT = hoaDon.getNgayTT();
            String[] ngay = ngayTT.split("-");
            String ngayDau = ngay[0] + ngay[1] + ngay[2];
            int ngayHDTT = Integer.parseInt(ngayDau);
            if (start >= ngayHDTT && ngayHDTT <= end) {
                sum += hoaDon.getTongTien();
            }
        }
        return sum;
    }

    private int soDonDaBan(List<HoaDonModel> list, int start, int end) {
        int count = 0;

        for (HoaDonModel hoaDon : list) {
            String ngayTT = hoaDon.getNgayTT();
            String[] ngay = ngayTT.split("-");
            String ngayDau = ngay[0] + ngay[1] + ngay[2];
            int ngayHDTT = Integer.parseInt(ngayDau);
            if (start >= ngayHDTT && ngayHDTT <= end) {
                count += 1;
            }
        }
        return count;
    }

    private float tongDoanhThu(List<HoaDonModel> list, String date) {
        float sum = 0;
        for (HoaDonModel hoaDon : list) {
            if (date.equalsIgnoreCase(hoaDon.getNgayTT())) {
                sum += hoaDon.getTongTien();
            }
        }
        return sum;
    }

    private int soDonDaBan(List<HoaDonModel> list, String date) {
        int count = 0;
        for (HoaDonModel hoaDonModel : list) {
            if (date.equalsIgnoreCase(hoaDonModel.getNgayTT())) {
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTien = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDaTT = new javax.swing.JLabel();
        txtHomQua = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTongHQ = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtTien1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDaTT1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(930, 567));

        jPanel2.setBackground(new java.awt.Color(102, 51, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(930, 567));

        jButton1.setBackground(new java.awt.Color(0, 204, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Biểu đồ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("THỐNG KÊ DOANH THU");

        txtTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTien.setForeground(new java.awt.Color(255, 255, 255));
        txtTien.setText("0 VNĐ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Doanh thu ngày hôm nay");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tổng đơn đã bán trong hôm nay");

        txtDaTT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDaTT.setForeground(new java.awt.Color(255, 255, 255));
        txtDaTT.setText("0");

        txtHomQua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtHomQua.setForeground(new java.awt.Color(255, 255, 255));
        txtHomQua.setText("0 VNĐ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Doanh thu ngày hôm qua");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tổng số hóa đơn đã bán trong hôm qua");

        txtTongHQ.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTongHQ.setForeground(new java.awt.Color(255, 255, 255));
        txtTongHQ.setText("0");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Doanh Thu Theo Ngày");

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
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tổng doanh thu tháng này");

        txtTien1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTien1.setForeground(new java.awt.Color(255, 255, 255));
        txtTien1.setText("0 VNĐ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tổng đơn đã bán trong tháng này");

        txtDaTT1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDaTT1.setForeground(new java.awt.Color(255, 255, 255));
        txtDaTT1.setText("0");

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 51, 51));
        jButton5.setText("X");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtDaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(84, 84, 84)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHomQua, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(txtTongHQ, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(225, 225, 225)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDaTT1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTien1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(285, 285, 285)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addComponent(jLabel3))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHomQua)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTongHQ))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTien)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDaTT))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTien1))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtDaTT1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            Logger.getLogger(ViewThongKe_1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ViewThongKe_1.class.getName()).log(Level.SEVERE, null, ex);
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
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "In thành công");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            JOptionPane.showMessageDialog(this, "Lỗi mở file");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        if (listTK!= null) {
//                    DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
//            for (Object[] objects : listTK) {
//                Double tongTien = Double.parseDouble(objects[3].toString());
//                categoryDataset.addValue(tongTien, "Học viên", objects[1]);
//                
//            }
//        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewThongKe_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewThongKe_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewThongKe_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewThongKe_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ViewThongKe_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel txtDaTT;
    private javax.swing.JLabel txtDaTT1;
    private javax.swing.JLabel txtHomQua;
    private javax.swing.JLabel txtTien;
    private javax.swing.JLabel txtTien1;
    private javax.swing.JLabel txtTongHQ;
    // End of variables declaration//GEN-END:variables
}
