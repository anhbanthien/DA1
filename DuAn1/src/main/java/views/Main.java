/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import javax.swing.JOptionPane;
import domainmodel.DangNhap;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Main extends javax.swing.JFrame {

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
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Jbtqlynv = new javax.swing.JButton();
        JbtOut = new javax.swing.JButton();
        JbtBan = new javax.swing.JButton();
        JbtOut1 = new javax.swing.JButton();
        Jbtqlynv1 = new javax.swing.JButton();
        JbtBan1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jbtProfile = new javax.swing.JButton();
        JbtOut2 = new javax.swing.JButton();
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
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ANHBANTHIEN");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 110, -1, -1));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 143, 160, 10));

        Jbtqlynv.setBackground(new java.awt.Color(105, 82, 73));
        Jbtqlynv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Jbtqlynv.setForeground(new java.awt.Color(255, 255, 255));
        Jbtqlynv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QlyNhanVien.png"))); // NOI18N
        Jbtqlynv.setText("Nhân Viên");
        Jbtqlynv.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        Jbtqlynv.setBorderPainted(false);
        Jbtqlynv.setContentAreaFilled(false);
        Jbtqlynv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtqlynvActionPerformed(evt);
            }
        });
        jPanel2.add(Jbtqlynv, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 442, 136, -1));

        JbtOut.setBackground(new java.awt.Color(105, 82, 73));
        JbtOut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JbtOut.setForeground(new java.awt.Color(255, 255, 255));
        JbtOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invoicePNG.png"))); // NOI18N
        JbtOut.setText("Hoá Đơn");
        JbtOut.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JbtOut.setBorderPainted(false);
        JbtOut.setContentAreaFilled(false);
        JbtOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtOutActionPerformed(evt);
            }
        });
        jPanel2.add(JbtOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 136, 50));

        JbtBan.setBackground(new java.awt.Color(105, 82, 73));
        JbtBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
        jPanel2.add(JbtBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 136, 67));

        JbtOut1.setBackground(new java.awt.Color(105, 82, 73));
        JbtOut1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JbtOut1.setForeground(new java.awt.Color(255, 255, 255));
        JbtOut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productPNG.png"))); // NOI18N
        JbtOut1.setText("SẢN PHẨM");
        JbtOut1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JbtOut1.setBorderPainted(false);
        JbtOut1.setContentAreaFilled(false);
        JbtOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtOut1ActionPerformed(evt);
            }
        });
        jPanel2.add(JbtOut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 519, 136, -1));

        Jbtqlynv1.setBackground(new java.awt.Color(105, 82, 73));
        Jbtqlynv1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Jbtqlynv1.setForeground(new java.awt.Color(255, 255, 255));
        Jbtqlynv1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chartPNG.png"))); // NOI18N
        Jbtqlynv1.setText("Thống Kê");
        Jbtqlynv1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        Jbtqlynv1.setBorderPainted(false);
        Jbtqlynv1.setContentAreaFilled(false);
        Jbtqlynv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtqlynv1ActionPerformed(evt);
            }
        });
        jPanel2.add(Jbtqlynv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 136, -1));

        JbtBan1.setBackground(new java.awt.Color(105, 82, 73));
        JbtBan1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JbtBan1.setForeground(new java.awt.Color(255, 255, 255));
        JbtBan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sellPNG.png"))); // NOI18N
        JbtBan1.setText("Bán Hàng");
        JbtBan1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JbtBan1.setBorderPainted(false);
        JbtBan1.setContentAreaFilled(false);
        JbtBan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtBan1ActionPerformed(evt);
            }
        });
        jPanel2.add(JbtBan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 160, 136, 56));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 160, -1));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 160, -1));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 160, -1));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 160, -1));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 160, 20));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 160, 10));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 160, 10));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 568));

        jPanel3.setBackground(new java.awt.Color(249, 238, 231));

        jPanel4.setBackground(new java.awt.Color(139, 110, 96));
        jPanel4.setForeground(new java.awt.Color(139, 110, 96));

        jbtProfile.setBackground(new java.awt.Color(139, 110, 96));
        jbtProfile.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbtProfile.setForeground(new java.awt.Color(139, 110, 96));
        jbtProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profile.png"))); // NOI18N
        jbtProfile.setBorder(null);
        jbtProfile.setBorderPainted(false);
        jbtProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtProfileActionPerformed(evt);
            }
        });

        JbtOut2.setBackground(new java.awt.Color(105, 82, 73));
        JbtOut2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JbtOut2.setForeground(new java.awt.Color(255, 255, 255));
        JbtOut2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10955895351582988856-48.png"))); // NOI18N
        JbtOut2.setText("Chuyển TK");
        JbtOut2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JbtOut2.setBorderPainted(false);
        JbtOut2.setContentAreaFilled(false);
        JbtOut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtOut2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JbtOut2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbtProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
            .addComponent(JbtOut2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/news.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 411, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(93, 93, 93))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 1020, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtProfileActionPerformed
        new InfoAccount(logg).setVisible(true);
    }//GEN-LAST:event_jbtProfileActionPerformed

    private void JbtBan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtBan1ActionPerformed
        new BanHangJDialog(this, true).setVisible(true);
    }//GEN-LAST:event_JbtBan1ActionPerformed

    private void Jbtqlynv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtqlynv1ActionPerformed
        new ViewThongKe().setVisible(true);
    }//GEN-LAST:event_Jbtqlynv1ActionPerformed

    private void JbtOut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtOut1ActionPerformed
        
    }//GEN-LAST:event_JbtOut1ActionPerformed

    private void JbtBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtBanActionPerformed
        new ViewBan().setVisible(true);
    }//GEN-LAST:event_JbtBanActionPerformed

    private void JbtOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtOutActionPerformed

        new HoaDonView().setVisible(true);

    }//GEN-LAST:event_JbtOutActionPerformed

    private void JbtqlynvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtqlynvActionPerformed
        new QlyNhanVienDialog(this, true).setVisible(true);
    }//GEN-LAST:event_JbtqlynvActionPerformed

    private void JbtOut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtOut2ActionPerformed
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_JbtOut2ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbtBan;
    private javax.swing.JButton JbtBan1;
    private javax.swing.JButton JbtOut;
    private javax.swing.JButton JbtOut1;
    private javax.swing.JButton JbtOut2;
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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton jbtProfile;
    // End of variables declaration//GEN-END:variables
}
