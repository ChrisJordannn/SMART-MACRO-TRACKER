/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;
import static JFrame.DBConnection.con;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author chrisjordan
 */
public class WaterTracker extends javax.swing.JFrame {

    /**
     * Creates new form TrackPage
     */
    int S_no, userId; float Consumed;
    DefaultTableModel model;
    public WaterTracker() {
        initComponents();
        setWaterTable();
    }
    public boolean insertWater(){
        boolean isAdded = false;
        Consumed= Float.parseFloat(water_textfield.getText());
        
        try{     
            if (SessionManager.isLoggedIn()) {
                User currentUser = SessionManager.getCurrentUser();
                userId = currentUser.getId();
                } else {
                JOptionPane.showMessageDialog(this, "unsuccessful");
            // Handle not logged in
             }
            Connection con = DBConnection.getConnection();
            String sql = "insert into water_tracker(id, consumed) values(?,?)";
            //String sql = "update macro set bcalories=?, bprotein=?, lcalories=?, lprotein=?, scalories=?, sprotein=?, dcalories=?, dprotein=? where id = (SELECT id FROM users WHERE user_id = ?))";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setFloat(1, userId);
            pst.setFloat(2,Consumed);
           
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isAdded= true;
            } else {
                isAdded= false;
            }

    } catch (Exception e) {
        e.printStackTrace(System.out);
        isAdded = false;
    
    }
        return isAdded;
}
    public boolean updatewater(){
        boolean isUpdated = false;
        Consumed= Float.parseFloat(water_textfield.getText());     
        try{     
            if (SessionManager.isLoggedIn()) {
                User currentUser = SessionManager.getCurrentUser();
                userId = currentUser.getId();
                } else {
                JOptionPane.showMessageDialog(this, "Unsuccessful");
            // Handle not logged in
             }
            Connection con = DBConnection.getConnection();
            //String sql = "update water_tracker set consumed=? where id = ?";
            String sql = "UPDATE water_tracker SET consumed = ? WHERE id = ? ORDER BY wid DESC LIMIT 1";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setFloat(1,Consumed);
            pst.setInt(2,userId);
           
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isUpdated= true;
            } else {
                isUpdated= false;
            }

    } catch (Exception e) {
        e.printStackTrace(System.out);
        isUpdated = false;
    
    }
        return isUpdated;
}
    public void setWaterTable() {
    int counter = 1;

    try {
        if (SessionManager.isLoggedIn()) {
            User currentUser = SessionManager.getCurrentUser();
            userId = currentUser.getId();
        } else {
            JOptionPane.showMessageDialog(this, "Unsuccessful");
            // Handle not logged in
            return;  // Exit the method if not logged in
        }

        Connection con = DBConnection.getConnection();
        String sql = "SELECT consumed FROM water_tracker WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, userId);

            clearTable();
            
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    S_no = counter;
                    Consumed = rs.getFloat("consumed");
                    Object[] obj = {S_no, Consumed};
                    model = (DefaultTableModel) water_table.getModel();
                    model.addRow(obj);
                    counter++;
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void clearTable(){
        DefaultTableModel model  = (DefaultTableModel) water_table.getModel();
        model.setRowCount(0);
    }
// method to compute BMI and display result

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
        water_textfield = new javax.swing.JTextField();
        UPDATE_WATER = new javax.swing.JButton();
        WATER_ADD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        water_table = new rojeru_san.complementos.RSTableMetro();

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
        jLabel4.setText("WATER TRACKER");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, -1));

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

        a_diet.setBackground(new java.awt.Color(51, 51, 51));
        a_diet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a_dietMouseClicked(evt);
            }
        });
        a_diet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-diet-plan-48.png"))); // NOI18N
        jLabel7.setText("   DIET PLAN");
        a_diet.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 170, 60));

        jPanel3.add(a_diet, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 350, 60));

        a_water.setBackground(new java.awt.Color(0, 153, 153));
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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, 780));

        jPanel4.setBackground(new java.awt.Color(51, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("ENTER WATER CONSUMED(in Litres)");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 420, 60));

        water_textfield.setBackground(new java.awt.Color(51, 204, 255));
        water_textfield.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        water_textfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        water_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                water_textfieldActionPerformed(evt);
            }
        });
        jPanel4.add(water_textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 260, 60));

        UPDATE_WATER.setBackground(new java.awt.Color(51, 0, 153));
        UPDATE_WATER.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        UPDATE_WATER.setForeground(new java.awt.Color(255, 255, 255));
        UPDATE_WATER.setText("UPDATE");
        UPDATE_WATER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE_WATERActionPerformed(evt);
            }
        });
        jPanel4.add(UPDATE_WATER, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 160, 50));

        WATER_ADD.setBackground(new java.awt.Color(0, 102, 153));
        WATER_ADD.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        WATER_ADD.setForeground(new java.awt.Color(255, 255, 255));
        WATER_ADD.setText("ADD");
        WATER_ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WATER_ADDActionPerformed(evt);
            }
        });
        jPanel4.add(WATER_ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 160, 50));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 1030, 130));

        water_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S_no", "Consumed"
            }
        ));
        water_table.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        water_table.setColorFilasBackgound1(new java.awt.Color(204, 255, 255));
        water_table.setRowHeight(50);
        jScrollPane1.setViewportView(water_table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 660, 470));

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

    private void water_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_water_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_water_textfieldActionPerformed

    private void WATER_ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WATER_ADDActionPerformed
        // TODO add your handling code here:
        if(insertWater() == true){
            JOptionPane.showMessageDialog(this, "Sucessfully logged water consumption!");
            clearTable();
            setWaterTable();
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Water Consumption log failed");
        }
        
    }//GEN-LAST:event_WATER_ADDActionPerformed

    private void UPDATE_WATERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE_WATERActionPerformed
        // TODO add your handling code here:
        if(updatewater() == true){
            JOptionPane.showMessageDialog(this, "Update successfull!");
            clearTable();
            setWaterTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Updation Failed");
        }
    }//GEN-LAST:event_UPDATE_WATERActionPerformed

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
           AnalyzePage a5 = new AnalyzePage();
                a5.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_jPanel8MouseClicked

    private void a_bmiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a_bmiMouseClicked
        // TODO add your handling code here:
        BMIPage b5 = new BMIPage();
        b5.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_a_bmiMouseClicked

    private void a_dietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a_dietMouseClicked
        // TODO add your handling code here:
        DietPlanPage d5 = new DietPlanPage();
        d5.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_a_dietMouseClicked

    private void a_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a_logoutMouseClicked
        // TODO add your handling code here:
        LoginPage l5 = new LoginPage();
         l5.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_a_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(WaterTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WaterTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WaterTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WaterTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new WaterTracker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UPDATE_WATER;
    private javax.swing.JButton WATER_ADD;
    private javax.swing.JPanel a_bmi;
    private javax.swing.JPanel a_diet;
    private javax.swing.JPanel a_home;
    private javax.swing.JPanel a_logout;
    private javax.swing.JPanel a_track;
    private javax.swing.JPanel a_water;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.complementos.RSTableMetro water_table;
    private javax.swing.JTextField water_textfield;
    // End of variables declaration//GEN-END:variables
}
