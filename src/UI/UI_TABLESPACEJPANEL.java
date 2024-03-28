package UI;
import DAO.Dataservice;
import GUI.GUI_TABLESPACE_ADD;
import GUI.GUI_TABLESPACE_CREATE;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

public class UI_TABLESPACEJPANEL extends javax.swing.JPanel {
    public UI_TABLESPACEJPANEL() {
        initComponents();
        fillToTable(Jtable_showtablespaces);
        fillDataFilesToTable(Jtable_datafile);
    }
public static void fillToTable(JTable table) {
        ResultSet rs = null;
        CallableStatement cs = null;
        Connection conn = null;

        try {
            conn = Dataservice.Getconnect();
            cs = conn.prepareCall("{call Proc_fillTablespaceToTable(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);

            // Tạo DefaultTableModel để chứa dữ liệu
            DefaultTableModel model = new DefaultTableModel(new String[]{"Owner", "Tablespace Name"}, 0);

            // Đọc dữ liệu từ ResultSet và thêm vào model
            while (rs.next()) {
                String owner = rs.getString("owner");
                String tablespaceName = rs.getString("tablespace_name");
                model.addRow(new Object[]{owner, tablespaceName});
            }

            // Đặt model cho JTable
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ nếu cần
        } finally {
            // Đóng ResultSet và CallableStatement sau khi sử dụng xong
            try {
                if (rs != null) rs.close();
                if (cs != null) cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Xử lý ngoại lệ nếu cần
            }
        }
    }


public static void searchAndFillTable(JTable table, String keyword) {
    Connection connection = null;
    CallableStatement callableStatement = null;
    ResultSet resultSet = null;
    
    try {
        connection = Dataservice.Getconnect(); // Lấy kết nối từ lớp Dataservice
        callableStatement = connection.prepareCall("{call PROC_searchAndFillTable(?, ?)}");
        callableStatement.setString(1, keyword);
        callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
        callableStatement.execute();
        resultSet = (ResultSet) callableStatement.getObject(2);
        
        DefaultTableModel model = new DefaultTableModel(new String[]{"Tablespace Name", "Owner"}, 0);
        
        while (resultSet.next()) {
            String owner = resultSet.getString("owner");
            String tablespaceName = resultSet.getString("tablespace_name");
            model.addRow(new Object[]{tablespaceName, owner});
        }
        
        table.setModel(model);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) resultSet.close();
            if (callableStatement != null) callableStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
     public void dropTableSpace(String tablespaceName) {
        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DAO.Dataservice.Getconnect();
            
            // Tạo callable statement để gọi stored procedure
            String sql = "{call Proc_DropTableSpace(?)}";
            CallableStatement callableStatement = connection.prepareCall(sql);

            // Đặt tham số cho stored procedure
            callableStatement.setString(1, tablespaceName);

            // Thực thi stored procedure
            callableStatement.execute();
            // Hiển thị thông báo thành công
            System.out.println("Tablespace " + tablespaceName + " dropped successfully.");
        } catch (SQLException e) {
            // Xử lý lỗi nếu có
            e.printStackTrace();
            System.out.println("Error dropping tablespace.");
        }
    }

    public static void fillDataFilesToTable(JTable table) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = Dataservice.Getconnect(); // Sử dụng phương thức Getconnect để lấy kết nối từ lớp Dataservice
            callableStatement = connection.prepareCall("{call PROC_fillDataFilesToTable(?)}");
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.execute();
            resultSet = (ResultSet) callableStatement.getObject(1);
            
            DefaultTableModel model = new DefaultTableModel(new String[]{"File_id", "File_name", "Tablespace_name"}, 0);
            
            while (resultSet.next()) {
                int file_id = resultSet.getInt("file_id");
                String file_name = resultSet.getString("file_name");
                String tablespaceName = resultSet.getString("tablespace_name");
                model.addRow(new Object[]{file_id, file_name, tablespaceName});
            }
            
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (callableStatement != null) callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
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
            java.util.logging.Logger.getLogger(GUI_TABLESPACE_CREATE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_TABLESPACE_CREATE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_TABLESPACE_CREATE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_TABLESPACE_CREATE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_TABLESPACEJPANEL().setVisible(true);
            }
        });
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
        txt_timkiemtablespace = new javax.swing.JTextField();
        btn_timkiemtblespace = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtable_showtablespaces = new javax.swing.JTable();
        btn_taodataspace = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtable_datafile = new javax.swing.JTable();
        btn_bosungdatafile = new javax.swing.JButton();
        btnxoatbspace = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel1.setText("Tất Cả Tablespaces:");

        btn_timkiemtblespace.setText("Tìm Kiếm");
        btn_timkiemtblespace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemtblespaceActionPerformed(evt);
            }
        });

        Jtable_showtablespaces.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên TableSpace", "Tên OWNER"
            }
        ));
        jScrollPane1.setViewportView(Jtable_showtablespaces);

        btn_taodataspace.setText("Tạo DataSpace");
        btn_taodataspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taodataspaceActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel2.setText("Thông Tin Datafile:");

        Jtable_datafile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "File ID", " File Name", "DataSpace"
            }
        ));
        jScrollPane2.setViewportView(Jtable_datafile);

        btn_bosungdatafile.setText("Bổ Sung Datafile");
        btn_bosungdatafile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bosungdatafileActionPerformed(evt);
            }
        });

        btnxoatbspace.setText("Xóa TBSpace");
        btnxoatbspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoatbspaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_timkiemtablespace, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_timkiemtblespace)
                .addGap(121, 121, 121))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnxoatbspace, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_bosungdatafile)
                .addGap(42, 42, 42)
                .addComponent(btn_taodataspace, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_timkiemtblespace)
                        .addComponent(txt_timkiemtablespace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnxoatbspace, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_bosungdatafile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_taodataspace, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
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

    private void btn_taodataspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taodataspaceActionPerformed
       GUI_TABLESPACE_CREATE  gui_tablespace_create = new GUI_TABLESPACE_CREATE();
       gui_tablespace_create.setVisible(true);
    }//GEN-LAST:event_btn_taodataspaceActionPerformed

    private void btn_bosungdatafileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bosungdatafileActionPerformed
        GUI.GUI_TABLESPACE_ADD gui_tablespace_add = new GUI_TABLESPACE_ADD();
        gui_tablespace_add.setVisible(true);
    }//GEN-LAST:event_btn_bosungdatafileActionPerformed

    private void btn_timkiemtblespaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemtblespaceActionPerformed
        searchAndFillTable(Jtable_showtablespaces, txt_timkiemtablespace.getText());
    }//GEN-LAST:event_btn_timkiemtblespaceActionPerformed

    private void btnxoatbspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoatbspaceActionPerformed
        // Lấy chỉ số dòng được chọn
        int selectedRow = Jtable_showtablespaces.getSelectedRow();

        // Kiểm tra xem có dòng nào được chọn không
        if (selectedRow != -1) {
            // Lấy tên tablespace từ dòng được chọn
            String tablespaceName = (String) Jtable_showtablespaces.getValueAt(selectedRow, 0); // Thay columnIndex bằng chỉ số cột chứa tên tablespace trong bảng của bạn

            JOptionPane.showMessageDialog(this, tablespaceName);
            // Gọi phương thức xóa tablespace
            //dropTableSpace(tablespaceName);
        } else {
            // Hiển thị thông báo cho người dùng nếu không có dòng nào được chọn
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một tablespace để xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnxoatbspaceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtable_datafile;
    private javax.swing.JTable Jtable_showtablespaces;
    private javax.swing.JButton btn_bosungdatafile;
    private javax.swing.JButton btn_taodataspace;
    private javax.swing.JButton btn_timkiemtblespace;
    private javax.swing.JButton btnxoatbspace;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txt_timkiemtablespace;
    // End of variables declaration//GEN-END:variables

    public void refreshTable() {
        fillToTable(Jtable_showtablespaces);
        fillDataFilesToTable(Jtable_datafile);// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
