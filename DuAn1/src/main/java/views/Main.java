/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import debug.main;
import javax.swing.JOptionPane;
import domainmodel.DangNhap;
import domainmodel.KhuyenMai;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import service.impl.KhuyenMaiServiceImp;

/**
 *
 * @author Admin
 */
public class Main extends javax.swing.JFrame {

    public void threadText() {

        Thread one = new Thread() {
            @Override
            public void run() {
                List<KhuyenMai> getAllKm = new KhuyenMaiServiceImp().getAll();

                String textKM = "";

                for (KhuyenMai o : getAllKm) {
                    textKM += " Áp dụng với tất cả hoá đơn mã Khuyến mãi " + o.getMaKM() + " , Ưu đãi "
                            + o.getPhanTramKM() + " % , Từ ngày " + o.getNgayBatDau() + " đến ngày " + o.getNgayKetThuc() + ".                    ";
                }
                String txt = textKM;
                while (true) {
                    txt = txt.substring(1, txt.length()) + txt.charAt(0);
                    try {
                        sleep(110);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jLabel2.setText(txt);
                }

            }

        };
        one.start();
    }

    public Main() {
        initComponents();

    }

    public void Logout() {
        this.dispose();
    }

    DangNhap logg = new DangNhap();

    public Main(DangNhap log) {
        initComponents();
        jbtProfile.setText(log.getTenTaiKhoan());
        logg = log;
        if (!log.getQuyen().equalsIgnoreCase("admin")) {
            Jbtqlynv.setEnabled(false);
            JbtOut.setEnabled(false);
        } else {
            Jbtqlynv.setEnabled(true);
            JbtOut.setEnabled(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Jbtqlynv = new javax.swing.JButton();
        JbtOut = new javax.swing.JButton();
        JbtBan = new javax.swing.JButton();
        JbtOut1 = new javax.swing.JButton();
        Jbtqlynv1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        JbtBan2 = new javax.swing.JButton();
        JbtOut3 = new javax.swing.JButton();
        JbtOut2 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jbtProfile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JbtOut4 = new javax.swing.JButton();
        JbtOut5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1154, 0, 24, 10));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1154, 141, -1, -1));

        jPanel2.setBackground(new java.awt.Color(140, 110, 98));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lmain.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 110));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 160, 20));

        Jbtqlynv.setBackground(new java.awt.Color(105, 82, 73));
        Jbtqlynv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jbtqlynv.setForeground(new java.awt.Color(255, 255, 255));
        Jbtqlynv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NV.png"))); // NOI18N
        Jbtqlynv.setText("   Nhân Viên");
        Jbtqlynv.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        Jbtqlynv.setBorderPainted(false);
        Jbtqlynv.setContentAreaFilled(false);
        Jbtqlynv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtqlynvActionPerformed(evt);
            }
        });
        jPanel2.add(Jbtqlynv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 140, 30));

        JbtOut.setBackground(new java.awt.Color(105, 82, 73));
        JbtOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JbtOut.setForeground(new java.awt.Color(255, 255, 255));
        JbtOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cusPng.png"))); // NOI18N
        JbtOut.setText("   Khách Hàng");
        JbtOut.setToolTipText(" ");
        JbtOut.setBorder(null);
        JbtOut.setBorderPainted(false);
        JbtOut.setContentAreaFilled(false);
        JbtOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtOutActionPerformed(evt);
            }
        });
        jPanel2.add(JbtOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 136, 40));

        JbtBan.setBackground(new java.awt.Color(105, 82, 73));
        JbtBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JbtBan.setForeground(new java.awt.Color(255, 255, 255));
        JbtBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mergetable.png"))); // NOI18N
        JbtBan.setText("   Bàn");
        JbtBan.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JbtBan.setBorderPainted(false);
        JbtBan.setContentAreaFilled(false);
        JbtBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtBanActionPerformed(evt);
            }
        });
        jPanel2.add(JbtBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 136, 60));

        JbtOut1.setBackground(new java.awt.Color(105, 82, 73));
        JbtOut1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JbtOut1.setForeground(new java.awt.Color(255, 255, 255));
        JbtOut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productPNG.png"))); // NOI18N
        JbtOut1.setText(" SẢN PHẨM");
        JbtOut1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JbtOut1.setBorderPainted(false);
        JbtOut1.setContentAreaFilled(false);
        JbtOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtOut1ActionPerformed(evt);
            }
        });
        jPanel2.add(JbtOut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 136, -1));

        Jbtqlynv1.setBackground(new java.awt.Color(105, 82, 73));
        Jbtqlynv1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jbtqlynv1.setForeground(new java.awt.Color(255, 255, 255));
        Jbtqlynv1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chartPNG.png"))); // NOI18N
        Jbtqlynv1.setText("    Thống Kê");
        Jbtqlynv1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        Jbtqlynv1.setBorderPainted(false);
        Jbtqlynv1.setContentAreaFilled(false);
        Jbtqlynv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtqlynv1ActionPerformed(evt);
            }
        });
        jPanel2.add(Jbtqlynv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 136, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 160, 20));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 160, 20));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 160, 20));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 160, 10));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 160, 20));

        JbtBan2.setBackground(new java.awt.Color(105, 82, 73));
        JbtBan2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JbtBan2.setForeground(new java.awt.Color(255, 255, 255));
        JbtBan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sellPNG.png"))); // NOI18N
        JbtBan2.setText("    Bán Hàng");
        JbtBan2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JbtBan2.setBorderPainted(false);
        JbtBan2.setContentAreaFilled(false);
        JbtBan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtBan2ActionPerformed(evt);
            }
        });
        jPanel2.add(JbtBan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 150, 56));

        JbtOut3.setBackground(new java.awt.Color(105, 82, 73));
        JbtOut3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JbtOut3.setForeground(new java.awt.Color(255, 255, 255));
        JbtOut3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invoicePNG.png"))); // NOI18N
        JbtOut3.setText("    Hoá Đơn");
        JbtOut3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JbtOut3.setBorderPainted(false);
        JbtOut3.setContentAreaFilled(false);
        JbtOut3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtOut3ActionPerformed(evt);
            }
        });
        jPanel2.add(JbtOut3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 136, 50));

        JbtOut2.setBackground(new java.awt.Color(105, 82, 73));
        JbtOut2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JbtOut2.setForeground(new java.awt.Color(255, 255, 255));
        JbtOut2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salePNG.png"))); // NOI18N
        JbtOut2.setText("Khuyến Mãi");
        JbtOut2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JbtOut2.setBorderPainted(false);
        JbtOut2.setContentAreaFilled(false);
        JbtOut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtOut2ActionPerformed(evt);
            }
        });
        jPanel2.add(JbtOut2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 136, -1));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 160, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 630));

        jPanel3.setBackground(new java.awt.Color(249, 238, 231));

        jPanel4.setBackground(new java.awt.Color(139, 110, 96));
        jPanel4.setForeground(new java.awt.Color(139, 110, 96));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtProfile.setBackground(new java.awt.Color(105, 82, 73));
        jbtProfile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtProfile.setForeground(new java.awt.Color(255, 255, 255));
        jbtProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profile.png"))); // NOI18N
        jbtProfile.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jbtProfile.setBorderPainted(false);
        jbtProfile.setContentAreaFilled(false);
        jbtProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtProfileActionPerformed(evt);
            }
        });
        jPanel4.add(jbtProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 120, 64));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 700, 51));

        JbtOut4.setBackground(new java.awt.Color(105, 82, 73));
        JbtOut4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JbtOut4.setForeground(new java.awt.Color(255, 255, 255));
        JbtOut4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LogoutPng.png"))); // NOI18N
        JbtOut4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JbtOut4.setBorderPainted(false);
        JbtOut4.setContentAreaFilled(false);
        JbtOut4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtOut4ActionPerformed(evt);
            }
        });
        jPanel4.add(JbtOut4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 65, 60));

        JbtOut5.setBackground(new java.awt.Color(105, 82, 73));
        JbtOut5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JbtOut5.setForeground(new java.awt.Color(255, 255, 255));
        JbtOut5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NotiPNG.png"))); // NOI18N
        JbtOut5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JbtOut5.setBorderPainted(false);
        JbtOut5.setContentAreaFilled(false);
        JbtOut5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtOut5ActionPerformed(evt);
            }
        });
        jPanel4.add(JbtOut5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 60, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/news.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 451, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(jLabel4)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 1020, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Jbtqlynv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtqlynv1ActionPerformed
        new ViewThongKe().setVisible(true);
    }//GEN-LAST:event_Jbtqlynv1ActionPerformed

    private void JbtOut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtOut1ActionPerformed
        new FrmQLSanPham().setVisible(true);
    }//GEN-LAST:event_JbtOut1ActionPerformed

    private void JbtBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtBanActionPerformed
        new ViewBan().setVisible(true);
    }//GEN-LAST:event_JbtBanActionPerformed

    private void JbtOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtOutActionPerformed

        new KhachHangJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_JbtOutActionPerformed

    private void JbtqlynvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtqlynvActionPerformed
        new QlyNhanVienDialog(this, true).setVisible(true);
    }//GEN-LAST:event_JbtqlynvActionPerformed

    private void jbtProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtProfileActionPerformed

        new InfoAccount(logg).setVisible(true);
    }//GEN-LAST:event_jbtProfileActionPerformed

    private void JbtBan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtBan2ActionPerformed
        new BanHangJDialog(this, true, logg).setVisible(true);
    }//GEN-LAST:event_JbtBan2ActionPerformed

    private void JbtOut3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtOut3ActionPerformed
        new HoaDonView().setVisible(true);
    }//GEN-LAST:event_JbtOut3ActionPerformed

    private void JbtOut4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtOut4ActionPerformed
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_JbtOut4ActionPerformed

    private void JbtOut5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtOut5ActionPerformed
        threadText();

    }//GEN-LAST:event_JbtOut5ActionPerformed

    private void JbtOut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtOut2ActionPerformed
        new ViewKhuyenMai().setVisible(true);
    }//GEN-LAST:event_JbtOut2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbtBan;
    private javax.swing.JButton JbtBan2;
    private javax.swing.JButton JbtOut;
    private javax.swing.JButton JbtOut1;
    private javax.swing.JButton JbtOut2;
    private javax.swing.JButton JbtOut3;
    private javax.swing.JButton JbtOut4;
    private javax.swing.JButton JbtOut5;
    private javax.swing.JButton Jbtqlynv;
    private javax.swing.JButton Jbtqlynv1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton jbtProfile;
    // End of variables declaration//GEN-END:variables
}
