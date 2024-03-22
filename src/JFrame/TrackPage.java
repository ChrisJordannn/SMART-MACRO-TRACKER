/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
/**
 *
 * @author chrisjordan
 */
public class TrackPage extends javax.swing.JFrame {

    /**
     * Creates new form TrackPage
     */
    double breakfast_calories,breakfast_protein,lunch_calories,lunch_protein, snacks_calories,snacks_protein,dinner_calories,dinner_protein;
    int userId;
    public TrackPage() {
        initComponents();
        loadValuesFromDatabase();
    }
    public boolean inserttrack(){
        boolean isAdded = false;
        breakfast_calories= Double.parseDouble(b_calories.getText());
        breakfast_protein= Double.parseDouble(b_protein.getText());
        lunch_calories= Double.parseDouble(l_calories.getText());
        lunch_protein= Double.parseDouble(l_protein.getText());
        snacks_calories= Double.parseDouble(s_calories.getText());
        snacks_protein= Double.parseDouble(s_protein.getText());
        dinner_calories= Double.parseDouble(d_calories.getText());
        dinner_protein= Double.parseDouble(d_protein.getText());
        
        try{     
            if (SessionManager.isLoggedIn()) {
                User currentUser = SessionManager.getCurrentUser();
                userId = currentUser.getId();
                } else {
                JOptionPane.showMessageDialog(this, "Unsuccessful");
             }
            Connection con = DBConnection.getConnection();
            String sql = "insert into macro(id, bcalories,bprotein,lcalories,lprotein,scalories,sprotein,dcalories,dprotein) values(?,?,?,?,?,?,?,?,?)";
            //String sql = "update macro set bcalories=?, bprotein=?, lcalories=?, lprotein=?, scalories=?, sprotein=?, dcalories=?, dprotein=? where id = (SELECT id FROM users WHERE user_id = ?))";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,userId);
            pst.setDouble(2,breakfast_calories);
            pst.setDouble(3,breakfast_protein);
            pst.setDouble(4,lunch_calories);
            pst.setDouble(5,lunch_protein);
            pst.setDouble(6,snacks_calories);
            pst.setDouble(7,snacks_protein);
            pst.setDouble(8,dinner_calories);
            pst.setDouble(9,dinner_protein); 
           
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
    public boolean updatetrack(){
        boolean isUpdated = false;
        breakfast_calories= Double.parseDouble(b_calories.getText());
        breakfast_protein= Double.parseDouble(b_protein.getText());
        lunch_calories= Double.parseDouble(l_calories.getText());
        lunch_protein= Double.parseDouble(l_protein.getText());
        snacks_calories= Double.parseDouble(s_calories.getText());
        snacks_protein= Double.parseDouble(s_protein.getText());
        dinner_calories= Double.parseDouble(d_calories.getText());
        dinner_protein= Double.parseDouble(d_protein.getText());
        
        try{     
             if (SessionManager.isLoggedIn()) {
                User currentUser = SessionManager.getCurrentUser();
                userId = currentUser.getId();
                } else {
                JOptionPane.showMessageDialog(this, "Unsuccessful");
             }
            Connection con = DBConnection.getConnection();
            //String sql = "insert into nutrition(bcalories,bprotein,lcalories,lprotein,scalories,sprotein,dcalories,dprotein) values(?,?,?,?,?,?,?,?)";
            String sql = "UPDATE macro SET bcalories=?, bprotein=?, lcalories=?, lprotein=?, scalories=?, sprotein=?, dcalories=?, dprotein=? WHERE id = ?  ORDER BY m_id DESC LIMIT 1";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDouble(1,breakfast_calories);
            pst.setDouble(2,breakfast_protein);
            pst.setDouble(3,lunch_calories);
            pst.setDouble(4,lunch_protein);
            pst.setDouble(5,snacks_calories);
            pst.setDouble(6,snacks_protein);
            pst.setDouble(7,dinner_calories);
            pst.setDouble(8,dinner_protein); 
            pst.setInt(9,userId);
           
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isUpdated= true;
            } else {
                isUpdated= false;
            }
            con.close();

    } catch (Exception e) {
        e.printStackTrace(System.out);
        isUpdated = false;
    
    }
        return isUpdated;
}
    private void loadValuesFromDatabase() {
        try {
            if (SessionManager.isLoggedIn()) {
                User currentUser = SessionManager.getCurrentUser();
                userId = currentUser.getId();
            } else {
                JOptionPane.showMessageDialog(this, "Unsuccessful");
                return;
            }

            Connection con = DBConnection.getConnection();
            String sql = "SELECT bcalories, bprotein, lcalories, lprotein, scalories, sprotein, dcalories, dprotein FROM macro WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                // Set the retrieved values in the text fields
                b_calories.setText(String.valueOf(rs.getDouble("bcalories")));
                b_protein.setText(String.valueOf(rs.getDouble("bprotein")));
                l_calories.setText(String.valueOf(rs.getDouble("lcalories")));
                l_protein.setText(String.valueOf(rs.getDouble("lprotein")));
                s_calories.setText(String.valueOf(rs.getDouble("scalories")));
                s_protein.setText(String.valueOf(rs.getDouble("sprotein")));
                d_calories.setText(String.valueOf(rs.getDouble("dcalories")));
                d_protein.setText(String.valueOf(rs.getDouble("dprotein")));
            }

            con.close(); // Close the connection after use
        } catch (Exception e) {
            e.printStackTrace(System.out);
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        b_calories = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        b_protein = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        l_calories = new javax.swing.JTextField();
        l_protein = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        s_calories = new javax.swing.JTextField();
        s_protein = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        d_calories = new javax.swing.JTextField();
        d_protein = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        t_update1 = new javax.swing.JButton();
        t_insert1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Tracklabel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        t_analyze = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel4.setText("WELCOME G!");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 190, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1580, 70));

        jPanel13.setBackground(new java.awt.Color(153, 153, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("BREAKFAST");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-breakfast-60.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel21.setText("Kcal");

        b_calories.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel22.setText("Protein");

        jLabel23.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel23.setText("Calories");

        b_protein.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel24.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel24.setText("gms");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_calories, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(b_protein, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel13)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_calories, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_protein, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(32, 32, 32))
        );

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 450, 160));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setText("LUNCH");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-lunch-58.png"))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel25.setText("Calories");

        jLabel26.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel26.setText("Protein");

        l_calories.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        l_protein.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel27.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel27.setText("Kcal");

        jLabel28.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel28.setText("gms");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(l_protein, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l_calories, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel14)))
                .addGap(17, 32, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel25))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_calories, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_protein, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(34, 34, 34))
        );

        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 450, 160));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setText("SNACKS");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-nuts-64.png"))); // NOI18N

        jLabel29.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel29.setText("Calories");

        jLabel30.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel30.setText("Protein");

        s_calories.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        s_protein.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel31.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel31.setText("Kcal");

        jLabel32.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel32.setText("gms");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(s_protein, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s_calories, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel15)))
                .addGap(20, 25, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel29))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(s_calories, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s_protein, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(31, 31, 31))
        );

        jPanel13.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 450, 160));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setText("DINNER");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-steaks-66.png"))); // NOI18N

        jLabel33.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel33.setText("Calories");

        jLabel34.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel34.setText("Protein");

        d_calories.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        d_protein.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel35.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel35.setText("Kcal");

        jLabel36.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel36.setText("gms");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(d_protein, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel36))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d_calories, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel16)))
                .addGap(17, 18, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33)
                    .addComponent(d_calories, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d_protein, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(29, 29, 29))
        );

        jPanel13.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 450, 160));

        t_update1.setBackground(new java.awt.Color(153, 255, 204));
        t_update1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        t_update1.setText("UPDATE");
        t_update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_update1ActionPerformed(evt);
            }
        });
        jPanel13.add(t_update1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 190, 100));

        t_insert1.setBackground(new java.awt.Color(255, 255, 102));
        t_insert1.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        t_insert1.setText("INSERT");
        t_insert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_insert1ActionPerformed(evt);
            }
        });
        jPanel13.add(t_insert1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 190, 100));

        getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 700, 690));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tracklabel.setBackground(new java.awt.Color(0, 153, 153));
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

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-home-50.png"))); // NOI18N
        jLabel5.setText("   HOME PAGE");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 180, 60));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 350, 60));

        t_analyze.setBackground(new java.awt.Color(51, 51, 51));
        t_analyze.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_analyzeMouseClicked(evt);
            }
        });
        t_analyze.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-analyze-50.png"))); // NOI18N
        jLabel8.setText("   ANALYZE");
        t_analyze.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 160, 60));

        jPanel3.add(t_analyze, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 350, 60));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-calculate-50.png"))); // NOI18N
        jLabel6.setText("   BMI CALCULATOR");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 230, 60));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 350, 60));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-diet-plan-48.png"))); // NOI18N
        jLabel7.setText("   DIET PLAN");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 170, 60));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 350, 60));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/icons8-water-bottle-50.png"))); // NOI18N
        jLabel9.setText("   WATER TRACKER");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 220, 60));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 350, 60));

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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, 780));

        setSize(new java.awt.Dimension(1478, 868));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t_update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_update1ActionPerformed
        // TODO add your handling code here:
        if (updatetrack() == true){
            JOptionPane.showMessageDialog(this,"Update successful!!!");
        }
        else{
            JOptionPane.showMessageDialog(this,"Update unsuccessful :(");
        }         
    }//GEN-LAST:event_t_update1ActionPerformed

    private void t_insert1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_insert1ActionPerformed
        // TODO add your handling code here:
        if (inserttrack() == true){
            JOptionPane.showMessageDialog(this,"Insert successful!!!");
        }
        else{
            JOptionPane.showMessageDialog(this,"Insert unsuccessful :(");
        }       
    }//GEN-LAST:event_t_insert1ActionPerformed

    private void TracklabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TracklabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TracklabelMouseClicked

    private void t_analyzeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_analyzeMouseClicked
        // TODO add your handling code here:
                AnalyzePage analyze1 = new AnalyzePage();
                analyze1.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_t_analyzeMouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        HomePage h2 = new HomePage();
        h2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        BMIPage b2 = new BMIPage();
        b2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
        DietPlanPage d2 = new DietPlanPage();
        d2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
        WaterTracker w2 = new WaterTracker();
        w2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // TODO add your handling code here:
        LoginPage l2 = new LoginPage();
         l2.setVisible(true);
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
            java.util.logging.Logger.getLogger(TrackPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrackPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrackPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrackPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrackPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Tracklabel;
    private javax.swing.JTextField b_calories;
    private javax.swing.JTextField b_protein;
    private javax.swing.JTextField d_calories;
    private javax.swing.JTextField d_protein;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
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
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField l_calories;
    private javax.swing.JTextField l_protein;
    private javax.swing.JTextField s_calories;
    private javax.swing.JTextField s_protein;
    private javax.swing.JPanel t_analyze;
    private javax.swing.JButton t_insert1;
    private javax.swing.JButton t_update1;
    // End of variables declaration//GEN-END:variables
}
