/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author chrisjordan
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    int userId;int S_no; float Consumed;
    float Total_Calories, Total_Protein;
    DefaultTableModel model;
    public HomePage() {
        initComponents();
        displayLastInsertedBMI();
        HomesetWaterTable();
        setMacroTable();
    }
    public void displayLastInsertedBMI() {
    try {
        if (SessionManager.isLoggedIn()) {
            User currentUser = SessionManager.getCurrentUser();
            userId = currentUser.getId();
            Connection con = DBConnection.getConnection();
            String sql = "SELECT bmi_value FROM bmi WHERE id = ? ORDER BY bmi_id DESC LIMIT 1";
            
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, userId);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    float lastInsertedBMI = rs.getFloat("bmi_value");
                    home_bmi.setText("" + lastInsertedBMI);
                } else {
                    home_bmi.setText("No BMI");
                }

                rs.close();
            }
            
            con.close(); // Close the connection outside of the try-with-resources block
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void HomesetWaterTable() {
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
                    model = (DefaultTableModel) home_water.getModel();
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
        DefaultTableModel model  = (DefaultTableModel) home_water.getModel();
        model.setRowCount(0);
    }
    public void setMacroTable() {
        int count=1;
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
            String sql = "SELECT bcalories, lcalories, scalories, dcalories, bprotein, lprotein, sprotein, dprotein FROM macro WHERE id = ?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, userId);
                model = (DefaultTableModel) home_macro.getModel();
                clearMacroTable();
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        S_no= count;
                        Total_Calories = rs.getFloat("bcalories") + rs.getFloat("lcalories") + rs.getFloat("scalories") + rs.getFloat("dcalories");
                        Total_Protein = rs.getFloat("bprotein") + rs.getFloat("lprotein") + rs.getFloat("sprotein") + rs.getFloat("dprotein");

                        Object[] obj = {S_no, Total_Calories, Total_Protein};
                        model.addRow(obj);
                        count++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearMacroTable() {
        DefaultTableModel macroModel = (DefaultTableModel) home_macro.getModel();
        macroModel.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Tracklabel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        h_analyze = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        h_bmi = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        h_diet = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        h_water = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        home_bmi = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        home_water = new rojeru_san.complementos.RSTableMetro();
        jScrollPane3 = new javax.swing.JScrollPane();
        home_macro = new rojeru_san.complementos.RSTableMetro();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1464, 976));

        jPanel1.setBackground(new java.awt.Color(255, 0, 102));
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

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel4.setText("WELCOME G!");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, 190, 50));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tracklabel.setBackground(new java.awt.Color(51, 51, 51));
        Tracklabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TracklabelMouseClicked(evt);
            }
        });
        Tracklabel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-write-50.png"))); // NOI18N
        jLabel1.setText("   TRACK");
        Tracklabel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 160, 60));

        jPanel3.add(Tracklabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 350, 60));

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-home-50.png"))); // NOI18N
        jLabel5.setText("   HOME PAGE");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 180, 60));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 350, 60));

        h_analyze.setBackground(new java.awt.Color(51, 51, 51));
        h_analyze.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                h_analyzeMouseClicked(evt);
            }
        });
        h_analyze.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-analyze-50.png"))); // NOI18N
        jLabel8.setText("   ANALYZE");
        h_analyze.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 160, 60));

        jPanel3.add(h_analyze, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 350, 60));

        h_bmi.setBackground(new java.awt.Color(51, 51, 51));
        h_bmi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                h_bmiMouseClicked(evt);
            }
        });
        h_bmi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-calculate-50.png"))); // NOI18N
        jLabel6.setText("   BMI CALCULATOR");
        h_bmi.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 230, 60));

        jPanel3.add(h_bmi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 350, 60));

        h_diet.setBackground(new java.awt.Color(51, 51, 51));
        h_diet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                h_dietMouseClicked(evt);
            }
        });
        h_diet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-diet-plan-48.png"))); // NOI18N
        jLabel7.setText("   DIET PLAN");
        h_diet.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 170, 60));

        jPanel3.add(h_diet, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 350, 60));

        h_water.setBackground(new java.awt.Color(51, 51, 51));
        h_water.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                h_waterMouseClicked(evt);
            }
        });
        h_water.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-water-bottle-50.png"))); // NOI18N
        jLabel9.setText("   WATER TRACKER");
        h_water.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 220, 60));

        jPanel3.add(h_water, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 350, 60));

        jPanel12.setBackground(new java.awt.Color(255, 0, 102));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-logout-50.png"))); // NOI18N
        jLabel12.setText("   LOGOUT");
        jPanel12.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 200, 60));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 350, 60));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(0, 0, 102)));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        home_bmi.setColumns(20);
        home_bmi.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        home_bmi.setRows(5);
        jScrollPane2.setViewportView(home_bmi);

        jPanel14.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 240, 90));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-bmi-64.png"))); // NOI18N
        jPanel14.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 260, 190));

        jPanel17.setBackground(new java.awt.Color(0, 0, 102));
        jPanel17.setPreferredSize(new java.awt.Dimension(696, 124));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/smtbanner1.jpg"))); // NOI18N
        jLabel15.setText("jLabel15");
        jPanel17.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 447, 129));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/smtbanner1.jpg"))); // NOI18N
        jLabel17.setText("jLabel17");
        jPanel17.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 276, 129));

        jPanel13.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 760, 170));

        home_water.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "S_no", "Consumed"
            }
        ));
        home_water.setColorBackgoundHead(new java.awt.Color(0, 0, 102));
        home_water.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        home_water.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        home_water.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        home_water.setRowHeight(40);
        jScrollPane1.setViewportView(home_water);

        jPanel13.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 410, 300));

        home_macro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "S_no", "Total_Calories", "Total_Protein"
            }
        ));
        home_macro.setColorBackgoundHead(new java.awt.Color(0, 0, 102));
        home_macro.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        home_macro.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        home_macro.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        home_macro.setRowHeight(40);
        jScrollPane3.setViewportView(home_macro);

        jPanel13.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, -1, 300));

        jPanel4.setBackground(new java.awt.Color(102, 0, 102));

        jLabel11.setBackground(new java.awt.Color(102, 0, 102));
        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Water Consumption Log");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 410, 40));

        jPanel6.setBackground(new java.awt.Color(102, 0, 102));

        jLabel16.setBackground(new java.awt.Color(102, 0, 102));
        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("MACRO OVERVIEW");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 450, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        setSize(new java.awt.Dimension(1478, 868));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void trackredirect(){
        try{
                TrackPage track1 = new TrackPage();
                track1.setVisible(true);
                this.dispose();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void TracklabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TracklabelMouseClicked
        // TODO add your handling code here:
        trackredirect();
    }//GEN-LAST:event_TracklabelMouseClicked

    private void h_analyzeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_h_analyzeMouseClicked
        // TODO add your handling code here:
                AnalyzePage analyze1 = new AnalyzePage();
                analyze1.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_h_analyzeMouseClicked

    private void h_bmiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_h_bmiMouseClicked
        // TODO add your handling code here:
        BMIPage bmi1 = new BMIPage();
        bmi1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_h_bmiMouseClicked

    private void h_dietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_h_dietMouseClicked
        // TODO add your handling code here:
        DietPlanPage d4 = new DietPlanPage();
        d4.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_h_dietMouseClicked

    private void h_waterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_h_waterMouseClicked
        // TODO add your handling code here:
         WaterTracker wt1 = new WaterTracker();
         wt1.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_h_waterMouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // TODO add your handling code here:
         LoginPage l1 = new LoginPage();
         l1.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jPanel12MouseClicked

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Tracklabel;
    private javax.swing.JPanel h_analyze;
    private javax.swing.JPanel h_bmi;
    private javax.swing.JPanel h_diet;
    private javax.swing.JPanel h_water;
    private javax.swing.JTextArea home_bmi;
    private rojeru_san.complementos.RSTableMetro home_macro;
    private rojeru_san.complementos.RSTableMetro home_water;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
