package UI;

import DAO.Dataservice;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import net.proteanit.sql.DbUtils;
import oracle.jdbc.OracleTypes;

public class UI_PHANQUYEN_HT extends javax.swing.JPanel {
    public UI_PHANQUYEN_HT() {
        initComponents();
        new UI_SEETABLE().setVisible(true);  
        
    }    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        btnGrant = new javax.swing.JButton();
        btnRevoke = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("USERS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("ROLES");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("CÁC QUYỀN");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT USER" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT ROLES" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALTER ANY TABLE", "EXECUTE ANY PROCEDURE", "ALTER ANY PROCEDURE", "CREATE ANY SEQUENCE", "CREATE ROLE", "ALTER ANY SEQUENCE", "DROP ANY INDEX", "ALTER ANY INDEX", "DELETE ANY TABLE", "UPDATE ANY TABLE", "INSERT ANY TABLE", "DROP ANY TABLE", "CREATE ANY TABLE", "GRANT ANY PRIVILEGE", "CREATE ANY PROCEDURE", "CREATE ANY INDEX", "SELECT ANY TABLE", "CREATE USER", "CREATE SESSION", "GRANT ANY ROLE", "DROP ANY VIEW", "CREATE ANY VIEW", "DROP USER" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("CHỌN ĐỐI TƯỢNG");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USER", "ROLE" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(67, 67, 67))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
        );

        jButton3.setText("XEM QUYỀN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnGrant.setText("GRANT");
        btnGrant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrantActionPerformed(evt);
            }
        });

        btnRevoke.setText("REVOKE");
        btnRevoke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevokeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGrant, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                        .addComponent(btnRevoke, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(244, 244, 244)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrant, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRevoke, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private boolean isComboBoxLoaded = false;
    private boolean isComboBoxLoaded2 = false;
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        Object selectedItem = jComboBox2.getSelectedItem();
        if (selectedItem != null && !isComboBoxLoaded2) {
        loadRolesToComboBox();
        isComboBoxLoaded2 = true; // Đánh dấu là đã chạy loadRolesToComboBox()
    }  
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void btnGrantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrantActionPerformed
        ResultSet rs = null;
        CallableStatement cs = null;
        Connection con = null;                    
        try{  
        con = Dataservice.Getconnect();
        int selectValue = jComboBox4.getSelectedIndex();
        if(selectValue == 0){
            String user_name = jComboBox1.getSelectedItem().toString();
            String permission = jComboBox3.getSelectedItem().toString();
            cs = con.prepareCall("{CALL proc_grant_user(?, ?)}");

            cs.setString(1, user_name);
            cs.setString(2, permission);
                // Thực thi stored procedure
            cs.execute();
            System.out.println("Permissions granted to user successfully."+ user_name + permission);
                
        }else if(selectValue == 1){//////////////////////////////////////////////////
            String user_name = jComboBox2.getSelectedItem().toString();
            String permission = jComboBox3.getSelectedItem().toString();
            cs = con.prepareCall("{CALL proc_grant_user(?, ?)}");

            cs.setString(1, user_name);
            cs.setString(2, permission);
                // Thực thi stored procedure
            cs.execute();
            System.out.println("Permissions granted to role successfully."+ user_name + permission);
        }
            }
            catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (cs != null) cs.close();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        

    }//GEN-LAST:event_btnGrantActionPerformed
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // Lấy item được chọn trong JComboBox
        Object selectedItem = jComboBox1.getSelectedItem();
        if (selectedItem != null && !isComboBoxLoaded) {
                loadAdminsToComboBox();
                isComboBoxLoaded = true; // Đánh dấu là đã chạy loadRolesToComboBox()
    }          
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnRevokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevokeActionPerformed
        ResultSet rs = null;
        CallableStatement cs = null;
        Connection con = null;
        try{
                con = Dataservice.Getconnect();
                int selectValue = jComboBox4.getSelectedIndex();
        if(selectValue == 0){
                String user_name = jComboBox1.getSelectedItem().toString();
                String permission = jComboBox3.getSelectedItem().toString();
                cs = con.prepareCall("{CALL PROC_REVOKE_PRIVILEGE(?, ?)}");

                cs.setString(1, user_name);
                cs.setString(2, permission);
                // Thực thi stored procedure
                cs.execute();
                System.out.println("Permissions"+ permission +" revoke to user "+ user_name +"successfully.");
        }else if(selectValue == 1){
            String user_name = jComboBox2.getSelectedItem().toString();
                String permission = jComboBox3.getSelectedItem().toString();
                cs = con.prepareCall("{CALL PROC_REVOKE_PRIVILEGE(?, ?)}");

                cs.setString(1, user_name);
                cs.setString(2, permission);
                // Thực thi stored procedure
                cs.execute();
                System.out.println("Permissions"+ permission +" revoke to role "+ user_name +"successfully.");
        }
            }
            catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (cs != null) cs.close();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        

    }//GEN-LAST:event_btnRevokeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ResultSet rs = null;
        CallableStatement cs = null;
        Connection con = null;   
        try {
            int selectValue = jComboBox4.getSelectedIndex();
            if(selectValue == 0){
                con = Dataservice.Getconnect();           
                String name = jComboBox1.getSelectedItem().toString();
                // Tạo CallableStatement và đăng ký tham số
                cs = con.prepareCall("{CALL PROC_XEM_USER_PRIVILEGE(?, ?)}");
                cs.setString(1, name);
                cs.registerOutParameter(2, OracleTypes.CURSOR);

                // Thực thi stored procedure
                cs.execute();

                // Lấy kết quả từ tham số OUT
                rs = (ResultSet) cs.getObject(2);

                // Hiển thị kết quả trong jTable1
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                ///////////////////////////////////////
        }else if(selectValue == 1){
            con = Dataservice.Getconnect();           
                String name = jComboBox2.getSelectedItem().toString();
                // Tạo CallableStatement và đăng ký tham số
                cs = con.prepareCall("{CALL PROC_XEM_USER_PRIVILEGE(?, ?)}");
                cs.setString(1, name);
                cs.registerOutParameter(2, OracleTypes.CURSOR);

                // Thực thi stored procedure
                cs.execute();

                // Lấy kết quả từ tham số OUT
                rs = (ResultSet) cs.getObject(2);

                // Hiển thị kết quả trong jTable1
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Đóng kết nối và giải phóng tài nguyên
        finally {
            try {
                if (rs != null) rs.close();
                if (cs != null) cs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void loadAdminsToComboBox() {
    ResultSet rs = null;
    CallableStatement cs = null;
    Connection con = null;   
    try {
        con = Dataservice.Getconnect();
        // Tạo CallableStatement và đăng ký tham số
        cs = con.prepareCall("{CALL PROC_list_admins(?)}");

        cs.registerOutParameter(1, OracleTypes.CURSOR); // Đăng ký tham số đầu ra

        // Thực thi stored procedure
        cs.execute();

        // Lấy kết quả từ tham số đầu ra
        rs = (ResultSet) cs.getObject(1);

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        // Lặp qua kết quả và thêm vào JComboBox
        while (rs.next()) {
            String admin = rs.getString("USERNAME");
            comboBoxModel.addElement(admin);
        }jComboBox1.setModel(comboBoxModel);
    } catch (Exception e) {
        System.out.println(e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (cs != null) cs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
    
    private void loadRolesToComboBox() {
    ResultSet rs = null;
    CallableStatement cs = null;
    Connection con = null;

try {
    con = Dataservice.Getconnect();
    // Tạo CallableStatement và đăng ký tham số
    cs = con.prepareCall("{CALL PROC_list_roles(?)}");

    cs.registerOutParameter(1, OracleTypes.CURSOR); // Đăng ký tham số đầu ra

    // Thực thi stored procedure
    cs.execute();

    // Lấy kết quả từ tham số đầu ra
    rs = (ResultSet) cs.getObject(1);


    // Lặp qua kết quả và thêm vào JComboBox
    while (rs.next()) {
        String admin = rs.getString("ROLE");
        jComboBox2.addItem(admin);
    }
} catch (Exception e) {
    System.out.println(e.getMessage());
} finally {
    try {
        if (rs != null) rs.close();
        if (cs != null) cs.close();
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
}
    


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGrant;
    private javax.swing.JButton btnRevoke;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
