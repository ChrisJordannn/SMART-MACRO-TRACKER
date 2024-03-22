/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;
import static JFrame.DBConnection.con;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author chrisjordan
 */
public class DietPlanPage extends javax.swing.JFrame {

    /**
     * Creates new form TrackPage
     */
    
    public DietPlanPage() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        a_track = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        a_home = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        a_bmi = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        a_diet = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        a_water = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        a_logout = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        deficit_EXPLORE_button = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        recomp_EXPLORE_button1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        surplus_EXPLORE_button2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 102));
        jPanel1.setAutoscrolls(true);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 5, 50));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SMART MACRO TRACKER");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 310, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DIET PLAN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1580, 70));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        a_track.setBackground(new java.awt.Color(51, 51, 51));
        a_track.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a_trackMouseClicked(evt);
            }
        });
        a_track.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-write-50.png"))); // NOI18N
        jLabel1.setText("   TRACK");
        a_track.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 160, 60));

        jPanel3.add(a_track, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 350, 60));

        a_home.setBackground(new java.awt.Color(51, 51, 51));
        a_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a_homeMouseClicked(evt);
            }
        });
        a_home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-home-50.png"))); // NOI18N
        jLabel5.setText("   HOME PAGE");
        a_home.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 180, 60));

        jPanel3.add(a_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 350, 60));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-analyze-50.png"))); // NOI18N
        jLabel8.setText("   ANALYZE");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 160, 60));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 350, 60));

        a_bmi.setBackground(new java.awt.Color(51, 51, 51));
        a_bmi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a_bmiMouseClicked(evt);
            }
        });
        a_bmi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-calculate-50.png"))); // NOI18N
        jLabel6.setText("   BMI CALCULATOR");
        a_bmi.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 230, 60));

        jPanel3.add(a_bmi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 350, 60));

        a_diet.setBackground(new java.awt.Color(0, 153, 153));
        a_diet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-diet-plan-48.png"))); // NOI18N
        jLabel7.setText("   DIET PLAN");
        a_diet.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 170, 60));

        jPanel3.add(a_diet, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 350, 60));

        a_water.setBackground(new java.awt.Color(51, 51, 51));
        a_water.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a_waterMouseClicked(evt);
            }
        });
        a_water.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-water-bottle-50.png"))); // NOI18N
        jLabel9.setText("   WATER TRACKER");
        a_water.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 220, 60));

        jPanel3.add(a_water, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 350, 60));

        a_logout.setBackground(new java.awt.Color(255, 0, 102));
        a_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a_logoutMouseClicked(evt);
            }
        });
        a_logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-logout-50.png"))); // NOI18N
        jLabel12.setText("   LOGOUT");
        a_logout.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 200, 60));

        jPanel3.add(a_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 350, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, 790));

        jPanel4.setBackground(new java.awt.Color(153, 255, 153));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 900));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 0));
        jLabel11.setText("CALORIC DEFICIT");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 6, 209, 49));

        deficit_EXPLORE_button.setBackground(new java.awt.Color(0, 153, 0));
        deficit_EXPLORE_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        deficit_EXPLORE_button.setForeground(new java.awt.Color(255, 255, 255));
        deficit_EXPLORE_button.setText("EXPLORE!");
        deficit_EXPLORE_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deficit_EXPLORE_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(deficit_EXPLORE_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, -1, 51));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/new new1.png"))); // NOI18N
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 330, 510));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 340, 690));

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(400, 900));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 0, 102));
        jLabel13.setText("BODY RECOMPOSITION");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, -1, 49));

        recomp_EXPLORE_button1.setBackground(new java.awt.Color(102, 0, 102));
        recomp_EXPLORE_button1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        recomp_EXPLORE_button1.setForeground(new java.awt.Color(255, 255, 255));
        recomp_EXPLORE_button1.setText("EXPLORE!");
        recomp_EXPLORE_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recomp_EXPLORE_button1ActionPerformed(evt);
            }
        });
        jPanel5.add(recomp_EXPLORE_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 608, -1, 51));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/new new 2.png"))); // NOI18N
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 330, 510));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 340, 690));

        jPanel6.setBackground(new java.awt.Color(255, 153, 153));
        jPanel6.setPreferredSize(new java.awt.Dimension(400, 900));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 0, 0));
        jLabel14.setText("CALORIC SURPLUS");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 6, -1, 49));

        surplus_EXPLORE_button2.setBackground(new java.awt.Color(153, 0, 0));
        surplus_EXPLORE_button2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        surplus_EXPLORE_button2.setForeground(new java.awt.Color(255, 255, 255));
        surplus_EXPLORE_button2.setText("EXPLORE!");
        surplus_EXPLORE_button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surplus_EXPLORE_button2ActionPerformed(evt);
            }
        });
        jPanel6.add(surplus_EXPLORE_button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 600, -1, 51));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/new new 3.png"))); // NOI18N
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 330, 510));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 90, 340, 690));

        setSize(new java.awt.Dimension(1478, 868));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void a_trackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a_trackMouseClicked
        // TODO add your handling code here:
                TrackPage track1 = new TrackPage();
                track1.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_a_trackMouseClicked

    private void a_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a_homeMouseClicked
        // TODO add your handling code here:
                HomePage home1 = new HomePage();
                home1.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_a_homeMouseClicked

    private void deficit_EXPLORE_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deficit_EXPLORE_buttonActionPerformed
        // TODO add your handling code here:
        CaloricDeficitPage cd = new CaloricDeficitPage();
        cd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_deficit_EXPLORE_buttonActionPerformed

    private void recomp_EXPLORE_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recomp_EXPLORE_button1ActionPerformed
        // TODO add your handling code here:
        BodyRecompPage br = new BodyRecompPage();
        br.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_recomp_EXPLORE_button1ActionPerformed

    private void surplus_EXPLORE_button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surplus_EXPLORE_button2ActionPerformed
        // TODO add your handling code here:
        CaloricSurplusPage cs = new CaloricSurplusPage();
        cs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_surplus_EXPLORE_button2ActionPerformed

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        AnalyzePage a4 = new AnalyzePage();
        a4.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel8MouseClicked

    private void a_bmiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a_bmiMouseClicked
        // TODO add your handling code here:
        BMIPage b4 = new BMIPage();
        b4.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_a_bmiMouseClicked

    private void a_waterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a_waterMouseClicked
        // TODO add your handling code here:
        WaterTracker w4 = new WaterTracker();
        w4.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_a_waterMouseClicked

    private void a_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a_logoutMouseClicked
        // TODO add your handling code here:
        LoginPage l4 = new LoginPage();
         l4.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_a_logoutMouseClicked
// CARD 2 [204,204,255], CARD 3 [255,102,102]
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
            java.util.logging.Logger.getLogger(DietPlanPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DietPlanPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DietPlanPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DietPlanPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new DietPlanPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel a_bmi;
    private javax.swing.JPanel a_diet;
    private javax.swing.JPanel a_home;
    private javax.swing.JPanel a_logout;
    private javax.swing.JPanel a_track;
    private javax.swing.JPanel a_water;
    private javax.swing.JButton deficit_EXPLORE_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton recomp_EXPLORE_button1;
    private javax.swing.JButton surplus_EXPLORE_button2;
    // End of variables declaration//GEN-END:variables
}
