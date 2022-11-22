
package views;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import domainmodel.NhanVien;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JOptionPane;
import service.impl.QlyNhanVienImpl;
import viewmodel.NhanVienModel;

/**
 *
 * @author Admin
 */
public class QlyNhanVien extends javax.swing.JFrame {

    private ArrayList<NhanVienModel> getAll = new QlyNhanVienImpl().getAllStaff();
    private DefaultTableModel tbl = new DefaultTableModel();

    public void fillToTable(List<NhanVienModel> listsStaff) {

        tbl = (DefaultTableModel) tblQlyNhanVien.getModel();
        tbl.setRowCount(0);

        for (NhanVienModel o : listsStaff) {
            tbl.addRow(new Object[]{o.getHoTen(), o.getEmail(), o.getSDT(), o.getGioiTinh(), o.getTrangThai()});
        }

    }

    public QlyNhanVien() {
        initComponents();
        fillToTable(getAll);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQlyNhanVien = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdoFemale = new javax.swing.JRadioButton();
        rdoMale = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtNumberPhone = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        rdoOFF = new javax.swing.JRadioButton();
        rdoOn = new javax.swing.JRadioButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblQlyNhanVien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblQlyNhanVien.setForeground(new java.awt.Color(102, 102, 102));
        tblQlyNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Họ Tên", "Email", "SĐT", "Giới Tính", "Trạng Thái"
            }
        ));
        tblQlyNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQlyNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQlyNhanVien);

        jLabel3.setText("Họ Tên");

        jLabel4.setText("Email");

        jLabel5.setText("SDT");

        jLabel6.setText("Giới tính");

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Nữ");

        buttonGroup1.add(rdoMale);
        rdoMale.setText("Nam");

        jLabel7.setText("Trạng Thái");

        jButton2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        jButton2.setText("Create");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("SimSun-ExtB", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Sitka Subheading", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(51, 102, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QlyNhanVien.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Quản Lý Nhân Viên");

        jButton3.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timkiem.png"))); // NOI18N
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        buttonGroup2.add(rdoOFF);
        rdoOFF.setText("OFF");

        buttonGroup2.add(rdoOn);
        rdoOn.setText("ON");
        rdoOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoOnActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Zilla Slab Medium", 0, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backPng.png"))); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoMale)
                            .addComponent(rdoOn)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdoFemale)
                                    .addComponent(rdoOFF)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(52, 52, 52)
                        .addComponent(txtNumberPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtNumberPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(rdoFemale))
                            .addComponent(rdoMale))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(rdoOFF)
                            .addComponent(rdoOn)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        NhanVien staff = new NhanVien();
        staff.setEmail(txtEmail.getText());
        if (rdoMale.isSelected()) {
            staff.setGioiTinh("Nam");
        } else {
            staff.setGioiTinh("Nữ");
        }
        staff.setHoTen(txtName.getText());
        staff.setSDT(txtNumberPhone.getText());
        if (rdoOn.isSelected()) {
            staff.setTrangThai("ON");
        } else {
            staff.setTrangThai("OFF");
        }

        if (new QlyNhanVienImpl().Save(staff)) {
            JOptionPane.showMessageDialog(this, "Succes");
            getAll.add(new NhanVienModel(staff));
            fillToTable(new QlyNhanVienImpl().getAllStaff());
        } else {
            JOptionPane.showMessageDialog(this, "Failed");
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void rdoOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoOnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoOnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        NhanVien staff = new NhanVien();
        staff.setEmail(txtEmail.getText());
        if (rdoMale.isSelected()) {
            staff.setGioiTinh("Nam");
        } else {
            staff.setGioiTinh("Nữ");
        }
        staff.setHoTen(txtName.getText());
        staff.setSDT(txtNumberPhone.getText());
        if (rdoOn.isSelected()) {
            staff.setTrangThai("ON");
        } else {
            staff.setTrangThai("OFF");
        }
        String Id = getAll.get(tblQlyNhanVien.getSelectedRow()).getIdNhanVien() + "";
        if (new QlyNhanVienImpl().Update(UUID.fromString(Id), staff)) {
            JOptionPane.showMessageDialog(this, "Succes");
        } else {
            JOptionPane.showMessageDialog(this, "Failed");
        }

        fillToTable(new QlyNhanVienImpl().getAllStaff());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblQlyNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQlyNhanVienMouseClicked
        // JOptionPane.showMessageDialog(this, "Id Nhân Viên : " + getAll.get(tblQlyNhanVien.getSelectedRow()).getIdNhanVien());
        //JOptionPane.showMessageDialog(this, "Giới tính Nhân Viên : " + getAll.get(tblQlyNhanVien.getSelectedRow()).getGioiTinh());

        txtName.setText(getAll.get(tblQlyNhanVien.getSelectedRow()).getHoTen());
        txtEmail.setText(getAll.get(tblQlyNhanVien.getSelectedRow()).getEmail());
        txtNumberPhone.setText(getAll.get(tblQlyNhanVien.getSelectedRow()).getSDT());

        if (getAll.get(tblQlyNhanVien.getSelectedRow()).getTrangThai().equalsIgnoreCase("ON")) {
            rdoOn.setSelected(true);
        } else {
            rdoOFF.setSelected(true);
        }
        if (getAll.get(tblQlyNhanVien.getSelectedRow()).getGioiTinh().trim().equalsIgnoreCase("Nam")) {
            rdoMale.setSelected(true);
        } else {
            rdoFemale.setSelected(true);
        }

    }//GEN-LAST:event_tblQlyNhanVienMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (tblQlyNhanVien.getSelectedRow() < 1) {

            JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên muốn xoá , click vào bảng nhân viên");
            JOptionPane.showMessageDialog(this, "Xoá nhân viên thực chất là chuyển đổi trạng thái làm việc,"
                    + "Bạn hãy chọn nhân viên cần xoá và thay đổi trạng thái ON ->OFF");
            return;
        }
        int Number = JOptionPane.showConfirmDialog(this, "Xoá nhé ?");

        if (Number == 0) {
            NhanVien staff = new NhanVien();
            staff.setEmail(txtEmail.getText());
            if (rdoMale.isSelected()) {
                staff.setGioiTinh("Nam");
            } else {
                staff.setGioiTinh("Nữ");
            }
            staff.setHoTen(txtName.getText());
            staff.setSDT(txtNumberPhone.getText());
            if (rdoOn.isSelected()) {
                staff.setTrangThai("ON");
            } else {
                staff.setTrangThai("OFF");
            }
            String Id = getAll.get(tblQlyNhanVien.getSelectedRow()).getIdNhanVien() + "";
            if (new QlyNhanVienImpl().Update(UUID.fromString(Id), staff)) {
                JOptionPane.showMessageDialog(this, "Succes");
            } else {
                JOptionPane.showMessageDialog(this, "Failed");
            }
            fillToTable(new QlyNhanVienImpl().getAllStaff());
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đã huỷ xoá ");
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        List<NhanVienModel> getAllSearch = new ArrayList<>();

        for (NhanVienModel o : getAll) {
            if (o.getHoTen().equalsIgnoreCase(txtSearch.getText())) {
                getAllSearch.add(o);
            }
        }

        if (getAllSearch.size() > 0) {
            fillToTable(getAllSearch);
            JOptionPane.showMessageDialog(this, "Đã tìm thấy");
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        fillToTable(getAll);
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
            java.util.logging.Logger.getLogger(QlyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QlyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QlyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QlyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QlyNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JRadioButton rdoOFF;
    private javax.swing.JRadioButton rdoOn;
    private javax.swing.JTable tblQlyNhanVien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumberPhone;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
