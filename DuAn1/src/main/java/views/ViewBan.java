package views;

import domainmodel.Ban;
import domainmodel.HoaDon;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import reponse.BanReponse;
import repository.BanRepository;
import service.impl.HoaDonServiceImpl;
import service.impl.QuanLyBanServiceImpl;
import viewmodel.HoaDonModel;

public class ViewBan extends javax.swing.JFrame {

    private ArrayList<BanReponse> listTables = (ArrayList<BanReponse>) new QuanLyBanServiceImpl().getAll();
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
    private ArrayList<HoaDonModel> listInvoices = (ArrayList<HoaDonModel>) new HoaDonServiceImpl().getHoaDonByTT();
    private DefaultTableModel dtmSecond = new DefaultTableModel();

    public void fillIDB() {

        cbbIDB.setModel(dcbm);

        for (BanReponse o : (ArrayList<BanReponse>) new QuanLyBanServiceImpl().getAll()) {

            cbbIDB.addItem(o.getIDB() + "");

        }

    }

    public String checkActiveTable(int IDB) {

        try {
            if (new HoaDonServiceImpl().getHoaDonByCheck(IDB).get(0) != null) {
                return "Có Người";
            }
        } catch (Exception e) {
            return "Còn Trống";
        }
        return null;
    }

    public void fillToTable(ArrayList<BanReponse> listTables) {

        dtm = (DefaultTableModel) tblTable.getModel();
        dtm.setRowCount(0);
        for (BanReponse o : listTables) {
            dtm.addRow(new Object[]{o.getIDB(), o.getTrangThaiBan(), checkActiveTable(o.getIDB()) + "",
                new BanRepository().getTotolCustomer(o.getIDB()).get(0)
            });
        }

    }

    public void fillToTableSecond(ArrayList<HoaDonModel> getAllInvoices) {

        dtmSecond = (DefaultTableModel) tblHoaDon.getModel();
        dtmSecond.setRowCount(0);
        for (HoaDonModel o : getAllInvoices) {
            dtmSecond.addRow(new Object[]{
                o.getIDB().getIDB(), o.getIDHD(), o.getIDKH().getTen(), o.getIDNV().getHoTen(),
                new BanRepository().getTotolCustomer(o.getIDB().getIDB()).get(0)

            });
        }

    }

    public ViewBan() {
        initComponents();
        fillToTable(listTables);
        fillIDB();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        cbbIDB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnAdd1 = new javax.swing.JButton();
        rdbOFF = new javax.swing.JRadioButton();
        rdbOn = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLastCus = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 51, 0));
        jPanel1.setForeground(new java.awt.Color(204, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUẢN LÝ BÀN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(866, 67, -1, 555));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus (1).png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 99, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/detail.png"))); // NOI18N
        jButton1.setText("Detail Tables");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 280, 140, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsz_ban.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, 460, 190));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mergetable.png"))); // NOI18N
        jButton3.setText("Merge Table");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 281, 160, 30));

        cbbIDB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbbIDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 117, 250, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("SỐ BÀN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 71, -1, -1));

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Số bàn", "Trạng Thái Bàn", "Thông Tin Bàn", "Số người"
            }
        ));
        tblTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 175, 360, 163));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Bàn Số", "ID Hoá Đơn", "Tên Khách Hàng", "Nhân Viên Phụ Trách", "Số Người"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 393, 848, 229));

        btnAdd1.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd1.setForeground(new java.awt.Color(255, 51, 51));
        btnAdd1.setText("X");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(749, 118, 99, -1));

        buttonGroup1.add(rdbOFF);
        rdbOFF.setText("OFF");
        getContentPane().add(rdbOFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 359, -1, -1));

        buttonGroup1.add(rdbOn);
        rdbOn.setText("ON");
        getContentPane().add(rdbOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 359, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Trạng Thái Bàn");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 330, -1, -1));

        jLabel4.setText("Thêm khách hàng");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));
        getContentPane().add(txtLastCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 100, 20));

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 80, 20));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        jButton4.setText("Update Table");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 140, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        Ban ban = new Ban();
        if (rdbOn.isSelected()) {
            ban.setTrangThaiBan("Đang Hoạt Động");
        } else {
            ban.setTrangThaiBan("Chưa Hoạt Động");
        }
        JOptionPane.showMessageDialog(this, new QuanLyBanServiceImpl().add(ban));
        fillToTable((ArrayList<BanReponse>) new QuanLyBanServiceImpl().getAll());
        dcbm.removeAllElements();
        fillIDB();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableMouseClicked
        //JOptionPane.showMessageDialog(this, listTables.get(tblTable.getSelectedRow()).getIDB());
    }//GEN-LAST:event_tblTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fillToTableSecond((ArrayList<HoaDonModel>) new HoaDonServiceImpl().getHoaDonByTT());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked

    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // System.out.println(new BanRepository().getTotolCustomer(Integer.parseInt(cbbIDB.getSelectedItem() + "")).get(0) + "");
        try {

            int IdTable = Integer.parseInt(cbbIDB.getSelectedItem() + "");

            if (Integer.parseInt(new BanRepository().getTotolCustomer(IdTable).get(0) + "") >= 5) {

                JOptionPane.showMessageDialog(this, "Bàn đã đầy người");
                return;

            }
            HoaDonModel Hdw = listInvoices.get(tblHoaDon.getSelectedRow());
            HoaDon Hdm = new HoaDon(Hdw);
            Hdm.setIDB(new QuanLyBanServiceImpl().getOne(Integer.parseInt(cbbIDB.getSelectedItem() + "")));
            if (new HoaDonServiceImpl().update(Hdm, listInvoices.get(tblHoaDon.getSelectedRow()).getIDHD())) {
                JOptionPane.showMessageDialog(this, "Merge Table succesfully");
                fillToTableSecond((ArrayList<HoaDonModel>) new HoaDonServiceImpl().getHoaDonByTT());
                fillToTable((ArrayList<BanReponse>) new QuanLyBanServiceImpl().getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Merge Table failed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng lựa chọn");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int IDB = listTables.get(tblTable.getSelectedRow()).getIDB();

        Ban ban = new Ban();
        if (rdbOn.isSelected()) {
            ban.setTrangThaiBan("Đang Hoạt Động");
        } else {
            ban.setTrangThaiBan("Chưa Hoạt Động");

        }
        if (new BanRepository().updateTable(ban, IDB)) {
            JOptionPane.showMessageDialog(this, "UPDATE Table");
            fillToTable((ArrayList<BanReponse>) new QuanLyBanServiceImpl().getAll());
        } else {
            JOptionPane.showMessageDialog(this, "UPDATE Failed");

        }


    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbIDB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdbOFF;
    private javax.swing.JRadioButton rdbOn;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblTable;
    private javax.swing.JTextField txtLastCus;
    // End of variables declaration//GEN-END:variables
}
