/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import domainmodel.SanPham;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.IManageCongThucService;
import service.IManageSanPhamService;
import service.impl.ManageCongThucService;
import service.impl.ManageSanPhamService;
import viewmodel.QLCongThuc;
import viewmodel.QLSanPham;

/**
 *
 * @author trong
 */
public class FrmQLCongThuc extends javax.swing.JFrame {

    IManageCongThucService _iManageCongThucService = new ManageCongThucService();
    IManageSanPhamService _iManageSanPhamService = new ManageSanPhamService();
    List<QLCongThuc> lstCT = _iManageCongThucService.getAll();
    int row = -1;
    DefaultTableModel dtm;
    DefaultComboBoxModel dcb;

    /**
     * Creates new form FrmQLCongThuc
     */
    public FrmQLCongThuc() {
        initComponents();
        dcb = (DefaultComboBoxModel) cboTenSP.getModel();
        List<QLSanPham> lstSP = _iManageSanPhamService.getAll();
        dcb.removeAllElements();
        for (QLSanPham x : lstSP) {
            dcb.addElement(x.getTenSP());
        }
        loadData(lstCT);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnXoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTrangThai = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLyCongThuc = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        txtTenCT = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        txtImage = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        btnClose = new javax.swing.JButton();
        cboTenSP = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnXoa.setFont(new java.awt.Font("Sitka Subheading", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnXoa.setText("Delete");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel4.setText("Image");

        jLabel5.setText("Trạng Thái");

        tblQLyCongThuc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblQLyCongThuc.setForeground(new java.awt.Color(102, 102, 102));
        tblQLyCongThuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên Sản Phẩm", "Tên Công Thức", "Mô Tả", "Image", "Trạng Thái"
            }
        ));
        tblQLyCongThuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLyCongThucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQLyCongThuc);

        btnThem.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        btnThem.setText("Create");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên Công Thức");

        btnSua.setFont(new java.awt.Font("SimSun-ExtB", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        btnSua.setText("Update");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(51, 102, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QlyNhanVien.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Quản Lý CÔNG THỨC");

        btnSearch.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timkiem.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(37, 37, 37)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jLabel1.setText("Mô Tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Close-icon_1.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        cboTenSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Tên Sản Phẩm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenCT, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(txtTenCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(31, 31, 31)
                        .addComponent(btnSua)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnXoa)
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            if (_iManageCongThucService.getAll().size() == 0) {
                JOptionPane.showMessageDialog(this, "Dữ liệu trống!");
                return;
            }
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Mời chọn công thức muốn xóa");
                return;
            }

            int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?");
            if (hoi == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, _iManageCongThucService.delete(getData()));
                loadData(_iManageCongThucService.getAll());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Mời chọn công thức muốn xóa");
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblQLyCongThucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLyCongThucMouseClicked
        row = tblQLyCongThuc.getSelectedRow();
        txtTenCT.setText(_iManageCongThucService.getAll().get(row).getTen());
        txtMoTa.setText(_iManageCongThucService.getAll().get(row).getMoTa());
        txtImage.setText(_iManageCongThucService.getAll().get(row).getImage());
        txtTrangThai.setText(_iManageCongThucService.getAll().get(row).getTrangThai());
        cboTenSP.setSelectedItem(_iManageSanPhamService.getOne(_iManageCongThucService.getAll().get(row).getIdSP()).getTenSP());

    }//GEN-LAST:event_tblQLyCongThucMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
//        try {
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không?");
        if (hoi == JOptionPane.YES_OPTION) {
            for (int i = 0; i < _iManageCongThucService.getAll().size(); i++) {
                if (_iManageCongThucService.getAll().get(i).getTen().equalsIgnoreCase(txtTenCT.getText().trim())) {
                    JOptionPane.showMessageDialog(this, "Tên sản phẩm bị trùng!");
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, _iManageCongThucService.add(getDataThem()));
            loadData(_iManageCongThucService.getAll());
        }

//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Mời nhập lại!");
//        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (_iManageCongThucService.getAll().size() == 0) {
                JOptionPane.showMessageDialog(this, "Hêt dữ liệu");
                return;
            }
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Mời chọn dòng muốn sửa!");
                return;
            }

            int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa?", "Sửa", JOptionPane.YES_NO_OPTION);
            if (hoi == JOptionPane.YES_OPTION) {
                for (int i = 0; i < _iManageCongThucService.getAll().size(); i++) {
                    if (row != i && _iManageCongThucService.getAll().get(i).getTen().equalsIgnoreCase(txtTenCT.getText().trim())) {
                        JOptionPane.showMessageDialog(this, "Tên công thức đã tồn tại");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, _iManageCongThucService.update(getID(), getData()));
                loadData(new ManageCongThucService().getAll());

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chọn dòng muốn sửa!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        List<QLCongThuc> lstQLCTTimTheoTen = new ArrayList<>();
        for (QLCongThuc x : _iManageCongThucService.getAll()) {
            if (x.getTen().toLowerCase().startsWith(txtSearch.getText().toLowerCase())) {
                lstQLCTTimTheoTen.add(x);
            }
        }
        if (lstQLCTTimTheoTen.size() != 0) {
            JOptionPane.showMessageDialog(this, "Đã tìm thấy");
            loadData(lstQLCTTimTheoTen);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy!");
        }


    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(FrmQLCongThuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmQLCongThuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmQLCongThuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmQLCongThuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmQLCongThuc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboTenSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblQLyCongThuc;
    private javax.swing.JTextField txtImage;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenCT;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables

    private void loadData(List<QLCongThuc> lstCT) {
        dtm = (DefaultTableModel) tblQLyCongThuc.getModel();
        dtm.setRowCount(0);
        for (QLCongThuc x : lstCT) {
            dtm.addRow(new Object[]{lstCT.indexOf(x) + 1, _iManageSanPhamService.getOne(x.getIdSP()).getTenSP(), x.getTen(), x.getMoTa(), x.getImage(), x.getTrangThai()});
        }
    }

    private UUID getID() {
        return _iManageCongThucService.getOneByTen(txtTenCT.getText()).getIdCT();
    }

    private QLCongThuc getDataThem() {
        QLCongThuc qlct = new QLCongThuc();
        qlct.setTen(txtTenCT.getText());
        qlct.setMoTa(txtMoTa.getText());
        qlct.setImage(txtImage.getText());
        qlct.setTrangThai(txtTrangThai.getText());
        qlct.setIdSP(_iManageSanPhamService.getOneByTen(cboTenSP.getSelectedItem().toString()).getIDSP());
        return qlct;

    }

    private QLCongThuc getData() {
        QLCongThuc qlct = new QLCongThuc();
        qlct.setIdCT(_iManageCongThucService.getOneByTen(txtTenCT.getText()).getIdCT());
        qlct.setIdSP(_iManageSanPhamService.getOneByTen(cboTenSP.getSelectedItem().toString()).getIDSP());
        qlct.setTen(txtTenCT.getText());
        qlct.setMoTa(txtMoTa.getText());
        qlct.setImage(txtImage.getText());
        qlct.setTrangThai(txtTrangThai.getText());

        return qlct;
    }

}
