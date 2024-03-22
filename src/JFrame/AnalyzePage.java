/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;
import static JFrame.DBConnection.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
/**
 *
 * @author chrisjordan
 */
public class AnalyzePage extends javax.swing.JFrame {

    /**
     * Creates new form TrackPage
     */
    double breakfast_calories,breakfast_protein,lunch_calories,lunch_protein, snacks_calories,snacks_protein,dinner_calories,dinner_protein;
    int userId,counter,S_no;
    DefaultTableModel model;
    public AnalyzePage() {
        initComponents();
        setAnalyzeTable();
        calculateAndDisplayTotal();
    }
    public void setAnalyzeTable(){
        int counter = 1;
        try{
             if (SessionManager.isLoggedIn()) {
                User currentUser = SessionManager.getCurrentUser();
                userId = currentUser.getId();
                } else {
                JOptionPane.showMessageDialog(this, "unsuccessful");
            // Handle not logged in
             }
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","christ123");
             //Statement st = con.createStatement();
             //ResultSet rs = st.executeQuery("select bcalories,bprotein, lcalories, lprotein, scalories, sprotein, dcalories, dprotein from macro where id=?");
             //pst.setInt(1, userId);
             String sql = "SELECT bcalories, bprotein, lcalories, lprotein, scalories, sprotein, dcalories, dprotein FROM macro WHERE id=?";
             PreparedStatement pst = con.prepareStatement(sql) ;
             pst.setInt(1, userId);
             clearTable();
             ResultSet rs = pst.executeQuery();
             while (rs.next()){
                 S_no = counter;
                 breakfast_calories = rs.getDouble("bcalories");
                 breakfast_protein = rs.getDouble("bprotein");
                 lunch_calories = rs.getDouble("lcalories");
                 lunch_protein  = rs.getDouble("lprotein");
                 snacks_calories = rs.getDouble("scalories");
                 snacks_protein = rs.getDouble("sprotein");
                 dinner_calories = rs.getDouble("dcalories");
                 dinner_protein =rs.getDouble("dprotein");
                 Object[] obj = {S_no, breakfast_calories,breakfast_protein,lunch_calories,lunch_protein,snacks_calories,
                     snacks_protein,dinner_calories,dinner_protein };
                 model = (DefaultTableModel)tbl_analyze.getModel();
                 model.addRow(obj);
                 counter++;
             }
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
    public void clearTable(){
        DefaultTableModel model  = (DefaultTableModel)tbl_analyze.getModel();
        model.setRowCount(0);
    }
    private void calculateAndDisplayTotal() {
    // Iterate through the table rows
    for (int i = 0; i < tbl_analyze.getRowCount(); i++) {
        double sumCalories = 0;
        double sumProtein = 0;

        // Calculate the sum of bcalories, lcalories, scalories, and dcalories for each row
        sumCalories += (double) tbl_analyze.getValueAt(i, 1); // breakfast_calories
        sumCalories += (double) tbl_analyze.getValueAt(i, 3); // lunch_calories
        sumCalories += (double) tbl_analyze.getValueAt(i, 5); // snacks_calories
        sumCalories += (double) tbl_analyze.getValueAt(i, 7); // dinner_calories

        // Calculate the sum of bprotein, lprotein, sprotein, and dprotein for each row
        sumProtein += (double) tbl_analyze.getValueAt(i, 2); // breakfast_protein
        sumProtein += (double) tbl_analyze.getValueAt(i, 4); // lunch_protein
        sumProtein += (double) tbl_analyze.getValueAt(i, 6); // snacks_protein
        sumProtein += (double) tbl_analyze.getValueAt(i, 8); // dinner_protein

        // Set the total protein in the appropriate column
        tbl_analyze.setValueAt(sumCalories, i, 9);
        tbl_analyze.setValueAt(sumProtein, i, 10); // Update "total_protein" column
    }
}

    private void compareAndSetRemarks() {
        // Fetch the value from the "set limits" field
        double dailyLimit = Double.parseDouble(a_limit.getText());

        // Iterate through the table rows
        for (int i = 0; i < tbl_analyze.getRowCount(); i++) {
            double sumCalories = 0;
            double sumProtein = 0;

            // Calculate the sum of bcalories, lcalories, scalories, and dcalories for each row
            sumCalories += (double) tbl_analyze.getValueAt(i, 1); // breakfast_calories
            sumCalories += (double) tbl_analyze.getValueAt(i, 3); // lunch_calories
            sumCalories += (double) tbl_analyze.getValueAt(i, 5); // snacks_calories
            sumCalories += (double) tbl_analyze.getValueAt(i, 7); // dinner_calories

            // Calculate the sum of bprotein, lprotein, sprotein, and dprotein for each row
            sumProtein += (double) tbl_analyze.getValueAt(i, 2); // breakfast_protein
            sumProtein += (double) tbl_analyze.getValueAt(i, 4); // lunch_protein
            sumProtein += (double) tbl_analyze.getValueAt(i, 6); // snacks_protein
            sumProtein += (double) tbl_analyze.getValueAt(i, 8); // dinner_protein

            // Compare the calculated sum with the daily limit
            if (sumCalories < dailyLimit) {
                tbl_analyze.setValueAt("SubOptimal", i, 11); // Update "remarks" column to "Less"
            } else if (sumCalories == dailyLimit) {
                tbl_analyze.setValueAt("Optimal", i, 11); // Update "remarks" column to "Perfect"
            } else {
                tbl_analyze.setValueAt("Excessive", i, 11); // Update "remarks" column to "Exceed"
            }

            // Set the total protein in the appropriate column
            tbl_analyze.setValueAt(sumCalories, i, 9);
            tbl_analyze.setValueAt(sumProtein, i, 10); // Update "total_protein" column
        }
    }
    
    public void homeredirect(){
        try{
                HomePage home1 = new HomePage();
                home1.setVisible(true);
                this.dispose();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //update 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        a_limit = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        analyze_butt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_analyze = new rojeru_san.complementos.RSTableMetro();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        a_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setAutoscrolls(true);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("ENTER YOUR DAILY CALORIES LIMIT ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 430, 50));

        a_limit.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        a_limit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_limitActionPerformed(evt);
            }
        });
        jPanel1.add(a_limit, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 300, 50));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setText("kcal");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 90, 50));

        analyze_butt.setBackground(new java.awt.Color(153, 0, 153));
        analyze_butt.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        analyze_butt.setForeground(new java.awt.Color(255, 255, 255));
        analyze_butt.setText("COMPUTE");
        analyze_butt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyze_buttActionPerformed(evt);
            }
        });
        jPanel1.add(analyze_butt, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 170, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1580, 70));

        tbl_analyze.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "m_id", "breakfast_calories", "breakfast_protein", "lunch_calories", "lunch_protein", "snacks_calories", "snacks_protein", "dinner_calories", "dinner_protein", "total_calories", "total_protein", "remarks"
            }
        ));
        tbl_analyze.setColorBackgoundHead(new java.awt.Color(204, 0, 204));
        tbl_analyze.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_analyze.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_analyze.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        tbl_analyze.setFuenteHead(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbl_analyze.setRowHeight(50);
        jScrollPane1.setViewportView(tbl_analyze);
        if (tbl_analyze.getColumnModel().getColumnCount() > 0) {
            tbl_analyze.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 1430, 480));

        jPanel4.setBackground(new java.awt.Color(204, 0, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel15.setBackground(new java.awt.Color(204, 0, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("BREAKFAST");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(26, 26, 26))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 250, 50));

        jPanel13.setBackground(new java.awt.Color(204, 0, 204));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel16.setBackground(new java.awt.Color(204, 0, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("      DINNER");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 180, 250, 50));

        jPanel14.setBackground(new java.awt.Color(204, 0, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel17.setBackground(new java.awt.Color(204, 0, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("       SNACKS");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, -1, 50));

        jPanel15.setBackground(new java.awt.Color(204, 0, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel18.setBackground(new java.awt.Color(204, 0, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("       LUNCH");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        getContentPane().add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 240, 50));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setAutoscrolls(true);
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 0, 102));
        jLabel19.setText("ANALYZE");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 240, 50));

        a_back.setBackground(new java.awt.Color(153, 0, 255));
        a_back.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        a_back.setForeground(new java.awt.Color(255, 255, 255));
        a_back.setText("<<BACK");
        a_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_backActionPerformed(evt);
            }
        });
        jPanel3.add(a_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 10, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1580, 70));

        setSize(new java.awt.Dimension(1478, 868));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void a_limitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_limitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a_limitActionPerformed

    private void a_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_backActionPerformed
        // TODO add your handling code here:
        HomePage h = new HomePage();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_a_backActionPerformed

    private void analyze_buttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyze_buttActionPerformed
        // TODO add your handling code here:
        compareAndSetRemarks();
    }//GEN-LAST:event_analyze_buttActionPerformed

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
            java.util.logging.Logger.getLogger(AnalyzePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnalyzePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnalyzePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnalyzePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnalyzePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a_back;
    private javax.swing.JTextField a_limit;
    private javax.swing.JButton analyze_butt;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.complementos.RSTableMetro tbl_analyze;
    // End of variables declaration//GEN-END:variables
}
