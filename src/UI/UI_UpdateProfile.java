/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import DAO.Dataservice;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Admin
 */
public class UI_UpdateProfile extends javax.swing.JPanel {

    /**
     * Creates new form UI_UpdateProfile
     */
    public UI_UpdateProfile() {
        initComponents();
        loadProfilesIntoTable(jtable_profile);
    }
    private static Connection connection;

    static {
        // Mở kết nối đến cơ sở dữ liệu khi lớp được nạp
        connection = DAO.Dataservice.Getconnect();
    }
    public static void loadProfilesIntoTable(JTable table) {
            CallableStatement cstmt = null;
            ResultSet rs = null;

            try {
                // Bước 2: Tạo và thực thi stored procedure
                cstmt = connection.prepareCall("{call LoadProfilesIntoTable(?)}");
                cstmt.registerOutParameter(1, OracleTypes.CURSOR);
                cstmt.execute();

                // Bước 3: Lấy dữ liệu từ stored procedure
                rs = (ResultSet) cstmt.getObject(1);

                // Bước 4: Tạo DefaultTableModel với các cột tương ứng với cột trong ResultSet
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Profile");
                model.addColumn("Resource Name");
                model.addColumn("Limit");

                // Bước 5: Thêm dữ liệu từ ResultSet vào model
                while (rs.next()) {
                    Object[] row = new Object[3];
                    row[0] = rs.getString("PROFILE");
                    row[1] = rs.getString("RESOURCE_NAME");
                    row[2] = rs.getString("LIMIT");
                    model.addRow(row);
                }

                // Bước 6: Đặt model cho JTable
                table.setModel(model);

            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                // Bước 7: Đóng tất cả các tài nguyên
                try {
                    if (rs != null) rs.close();
                    if (cstmt != null) cstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    
    public static void createUserWithProfile( String username, String password, String profileName) {
        try (CallableStatement cstmt = connection.prepareCall("{call sys.Proc_CreateUserWithProfile(?, ?, ?)}")) {
            cstmt.setString(1, username);
            cstmt.setString(2, password);
            cstmt.setString(3, profileName);
            cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void modifyUserWithProfile(String username, String newProfileName) {
        try (CallableStatement cstmt = connection.prepareCall("{call sys.Proc_ModifyUserWithProfile(?, ?)}")) {
            cstmt.setString(1, username);
            cstmt.setString(2, newProfileName);
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Sửa thông tin người dùng thành công.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sửa thông tin người dùng thất bại.", "Thất bại", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void deleteUser(String username) {
        try (CallableStatement cstmt = connection.prepareCall("{call sys.Proc_DeleteUser(?)}")) {
            cstmt.setString(1, username);
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Xóa người dùng thành công.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Xóa người dùng thất bại.", "Thất bại", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public static void deleteProfile(String profileName) {
        try (CallableStatement cstmt = connection.prepareCall("{call sys.Proc_DeleteProfile(?)}")) {
            cstmt.setString(1, profileName);
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Xóa profile thành công.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Xóa profile thất bại.", "Thất bại", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_profile = new javax.swing.JTable();
        btn_suauser = new javax.swing.JButton();
        btn_xoaprofile = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable_username = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cập Nhật Profile");

        jLabel2.setText("User: ");

        jtable_profile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtable_profile);

        btn_suauser.setText("sửa user với profile được chọn");
        btn_suauser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suauserActionPerformed(evt);
            }
        });

        btn_xoaprofile.setText("Xóa profile:");
        btn_xoaprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaprofileActionPerformed(evt);
            }
        });

        jButton1.setText("Xem User Thuộc Profile");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtable_username.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtable_username);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_suauser)
                                .addGap(101, 101, 101)
                                .addComponent(btn_xoaprofile, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)
                                .addComponent(jButton1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(248, 248, 248))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_suauser, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoaprofile, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_suauserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suauserActionPerformed
        int selectedRow = jtable_profile.getSelectedRow();

        // Kiểm tra xem có dòng nào được chọn không
        if (selectedRow != -1) {
            // Lấy tên tablespace từ dòng được chọn
            String profile_name = (String) jtable_profile.getValueAt(selectedRow, 0); // Thay columnIndex bằng chỉ số cột chứa tên tablespace trong bảng của bạn

            // Gọi phương thức xóa tablespace
            try {
                modifyUserWithProfile(txt_user.getText(),profile_name);
                loadProfilesIntoTable(jtable_profile);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(jPanel1, "Lỗi Rồi!");
            }
            
        } else {
            // Hiển thị thông báo cho người dùng nếu không có dòng nào được chọn
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một Profile!.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_suauserActionPerformed

    private void btn_xoaprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaprofileActionPerformed
        int selectedRow = jtable_profile.getSelectedRow();

        // Kiểm tra xem có dòng nào được chọn không
        if (selectedRow != -1) {
            // Lấy tên tablespace từ dòng được chọn
            String profile_name = (String) jtable_profile.getValueAt(selectedRow, 0); // Thay columnIndex bằng chỉ số cột chứa tên tablespace trong bảng của bạn

            // Gọi phương thức xóa tablespace
            try {
                deleteProfile(profile_name);
                loadProfilesIntoTable(jtable_profile);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(jPanel1, "Lỗi Rồi!");
            }
            
        } else {
            // Hiển thị thông báo cho người dùng nếu không có dòng nào được chọn
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một Profile để xóa!.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_xoaprofileActionPerformed
public static void getUsersByProfile(String profileName, JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); // Xóa dữ liệu cũ

    try {
         CallableStatement cstmt = connection.prepareCall("{call sys.Proc_GetUsersByProfile(?, ?)}");

        // Thiết lập tham số đầu vào và đầu ra cho stored procedure
        cstmt.setString(1, profileName);
        cstmt.registerOutParameter(2, OracleTypes.CURSOR);

        // Thực thi stored procedure
        cstmt.execute();

        // Lấy kết quả từ stored procedure
        ResultSet rs = (ResultSet) cstmt.getObject(2);

        // Thêm dữ liệu vào model của JTable
        while (rs.next()) {
            model.addRow(new Object[]{rs.getString("username")});
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRow = jtable_profile.getSelectedRow();

        // Kiểm tra xem có dòng nào được chọn không
        if (selectedRow != -1) {
            // Lấy tên tablespace từ dòng được chọn
            String profile_name = (String) jtable_profile.getValueAt(selectedRow, 0); // Thay columnIndex bằng chỉ số cột chứa tên tablespace trong bảng của bạn

            // Gọi phương thức xóa tablespace
            try {
                getUsersByProfile(profile_name,jtable_username);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(jPanel1, "Lỗi Rồi!");
            }
            
        } else {
            // Hiển thị thông báo cho người dùng nếu không có dòng nào được chọn
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một Profile!.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_suauser;
    private javax.swing.JButton btn_xoaprofile;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtable_profile;
    private javax.swing.JTable jtable_username;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
