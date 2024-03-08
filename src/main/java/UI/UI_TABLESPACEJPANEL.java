/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import DAO.DataService;
import GUI.GUI_TABLESPACE_ADD;
import GUI.GUI_TABLESPACE_CREATE;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class UI_TABLESPACEJPANEL extends javax.swing.JPanel {

    /**
     * Creates new form GUI_TABLESPACEJPANEL
     */
    public UI_TABLESPACEJPANEL() {
        initComponents();
        fillToTable(Jtable_showtablespaces);
        fillToTabledatafile(Jtable_datafile);
    }
public static void fillToTable(JTable table) {
        DataService dataService = new DataService();
        ResultSet rs = null;
        try {
            dataService.connectDatabase(); // Kết nối đến cơ sở dữ liệu
            // Thực hiện truy vấn để lấy dữ liệu từ cơ sở dữ liệu
            rs = dataService.fetchDataFromDatabase("SELECT DISTINCT owner, tablespace_name \n" +
"FROM dba_segments\n" +
"UNION\n" +
"SELECT NULL, tablespace_name\n" +
"FROM dba_tablespaces\n" +
"WHERE tablespace_name NOT IN (SELECT DISTINCT tablespace_name FROM dba_segments)");

            // Tạo DefaultTableModel để chứa dữ liệu
            DefaultTableModel model = new DefaultTableModel(new String[]{"Tablespace Name","Owner" }, 0);

            // Đọc dữ liệu từ ResultSet và thêm vào model
            while (rs.next()) {
                String owner = rs.getString("owner");
                String tablespaceName = rs.getString("tablespace_name");
                model.addRow(new Object[]{tablespaceName,owner });
            }

            // Đặt model cho JTable
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng ResultSet sau khi sử dụng xong
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // Đóng kết nối đến cơ sở dữ liệu
            dataService.closeConnection();
        }
    }

public static void searchAndFillTable(JTable table, String keyword) {
    DataService dataService = new DataService();
    ResultSet rs = null;
    try {
        dataService.connectDatabase(); // Kết nối đến cơ sở dữ liệu
        // Thực hiện truy vấn để lấy dữ liệu từ cơ sở dữ liệu
        String query = "SELECT DISTINCT owner, tablespace_name \n" +
                "FROM dba_segments\n" +
                "WHERE owner LIKE ?\n" + // Chỉ tìm kiếm theo tên chủ sở hữu (owner)
                "UNION\n" +
                "SELECT NULL, tablespace_name\n" +
                "FROM dba_tablespaces\n" +
                "WHERE tablespace_name NOT IN (SELECT DISTINCT tablespace_name FROM dba_segments)";
        PreparedStatement statement = dataService.getCon().prepareStatement(query);
        statement.setString(1, "%" + keyword + "%");
        rs = statement.executeQuery();

        // Tạo DefaultTableModel để chứa dữ liệu
        DefaultTableModel model = new DefaultTableModel(new String[]{"Tablespace Name", "Owner"}, 0);

        // Đọc dữ liệu từ ResultSet và thêm vào model
        while (rs.next()) {
            String owner = rs.getString("owner");
            String tablespaceName = rs.getString("tablespace_name");
            model.addRow(new Object[]{tablespaceName, owner});
        }

        // Đặt model cho JTable
        table.setModel(model);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Đóng ResultSet sau khi sử dụng xong
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Đóng kết nối đến cơ sở dữ liệu
        dataService.closeConnection();
    }
}

    public static void fillToTabledatafile(JTable table) {
        DataService dataService = new DataService();
        ResultSet rs = null;
        try {
            dataService.connectDatabase(); // Kết nối đến cơ sở dữ liệu
            // Thực hiện truy vấn để lấy dữ liệu từ cơ sở dữ liệu
            rs = dataService.fetchDataFromDatabase("SELECT file_id, file_name, tablespace_name FROM dba_data_files");

            // Tạo DefaultTableModel để chứa dữ liệu
            DefaultTableModel model = new DefaultTableModel(new String[]{"File_id","File_name", "Tablespace_name" }, 0);

            // Đọc dữ liệu từ ResultSet và thêm vào model
            while (rs.next()) {
                int file_id = rs.getInt("file_id");
                String file_name = rs.getString("file_name");
                String tablespaceName = rs.getString("tablespace_name");
                model.addRow(new Object[]{file_id,file_name,tablespaceName});
            }

            // Đặt model cho JTable
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng ResultSet sau khi sử dụng xong
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // Đóng kết nối đến cơ sở dữ liệu
            dataService.closeConnection();
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
                    .addComponent(btn_bosungdatafile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_taodataspace, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
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
       GUI.GUI_TABLESPACE_CREATE gui_tablespace_create = new GUI_TABLESPACE_CREATE();
       gui_tablespace_create.addWindowListener(new WindowAdapter() {
        @Override
        public void windowDeactivated(WindowEvent e) {
            refreshTable();
        }
    });
       gui_tablespace_create.setVisible(true);
    }//GEN-LAST:event_btn_taodataspaceActionPerformed

    private void btn_bosungdatafileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bosungdatafileActionPerformed
        GUI.GUI_TABLESPACE_ADD gui_tablespace_add = new GUI_TABLESPACE_ADD();
        gui_tablespace_add.addWindowListener(new WindowAdapter() {
        @Override
        public void windowDeactivated(WindowEvent e) {
            // Gọi refreshTable() khi JFrame được ẩn
            refreshTable();
        }
    });

    // Hiển thị JFrame
    gui_tablespace_add.setVisible(true);
    }//GEN-LAST:event_btn_bosungdatafileActionPerformed

    private void btn_timkiemtblespaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemtblespaceActionPerformed
        searchAndFillTable(Jtable_showtablespaces, txt_timkiemtablespace.getText());
    }//GEN-LAST:event_btn_timkiemtblespaceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jtable_datafile;
    private javax.swing.JTable Jtable_showtablespaces;
    private javax.swing.JButton btn_bosungdatafile;
    private javax.swing.JButton btn_taodataspace;
    private javax.swing.JButton btn_timkiemtblespace;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txt_timkiemtablespace;
    // End of variables declaration//GEN-END:variables

    public void refreshTable() {
        fillToTable(Jtable_showtablespaces);
        fillToTabledatafile(Jtable_datafile);// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
