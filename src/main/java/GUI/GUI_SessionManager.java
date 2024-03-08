/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DAO.DataService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LunChan
 */
public class GUI_SessionManager extends javax.swing.JPanel {
     private int process;

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    /**
     * Creates new form GUI_SessionManager1
     */
    public GUI_SessionManager() {
        initComponents();
        showDataTable(jTable_SessionManager);

        // Disable delete button initially
        jButton_DeleteSesion.setEnabled(false);

        // Add ListSelectionListener to JTable
        jTable_SessionManager.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if (jTable_SessionManager.getSelectedRow() != -1) {
                        // Enable delete button and set selected SID and Serial values
                        jButton_DeleteSesion.setEnabled(true);
                        int selectedProcess = (int) jTable_SessionManager.getValueAt(jTable_SessionManager.getSelectedRow(), 3);
                        setProcess(selectedProcess);
                    } else {
                        // No row is selected, disable delete button
                        jButton_DeleteSesion.setEnabled(false);
                    }
                }
            }
        });
        showDataTable(jTable_SessionManager);
    }
    
    public static void showDataTable(JTable table) {
    DataService dt = new DataService();
    ResultSet rs = null;
    try {
        dt.connectDatabase();
        rs = dt.fetchDataFromDatabase("SELECT COUNT(*) AS soLuongSession,\n" +
"       sid,\n" +
"       serial# AS serial,\n" +
"       username,\n" +
"       process,\n" +
"       program AS ungDungDangDangNhap\n" +
"FROM v$session\n" +
"WHERE STATUS = 'ACTIVE'\n" +
"GROUP BY sid, serial#, process, username, program");
        DefaultTableModel model = new DefaultTableModel(new String[]{"Số Lượng Session", "SID", "Serial", "Process", "Username", "Ứng Dụng"}, 0);
        while (rs.next()) {
            int soLuongSession = rs.getInt("soLuongSession");
            int sid = rs.getInt("sid");
            int serial = rs.getInt("serial");
            int process = rs.getInt("process");
            String username = rs.getString("username");
            String program = rs.getString("ungDungDangDangNhap");
            model.addRow(new Object[]{soLuongSession, sid, serial, process, username, program});
            
        }
        table.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null)
                rs.close();
            dt.closeConnection(); // Đảm bảo đóng kết nối sau khi sử dụng
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_SessionManager = new javax.swing.JTable();
        jButton_ShowProcess = new javax.swing.JButton();
        jButton_DeleteSesion = new javax.swing.JButton();

        jTable_SessionManager.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Số Lượng Sesion", "SID", "Serial", "Process", "Ứng dụng đang đăng nhập"
            }
        ));
        jTable_SessionManager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_SessionManagerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_SessionManager);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_ShowProcess.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton_ShowProcess.setText("Xem Process");

        jButton_DeleteSesion.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton_DeleteSesion.setText("Huỷ Session");
        jButton_DeleteSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_ShowProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton_DeleteSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_ShowProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_DeleteSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_DeleteSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteSesionActionPerformed
        int selectedRow = jTable_SessionManager.getSelectedRow();
        if (selectedRow != -1) {
            Object sidObject = jTable_SessionManager.getValueAt(selectedRow, 1);
            Object serialObject = jTable_SessionManager.getValueAt(selectedRow, 2);
            if (sidObject != null && serialObject != null) {
                int sid = Integer.parseInt(sidObject.toString());
                int serial = Integer.parseInt(serialObject.toString());
                DataService dt = new DataService();
                try {
                    dt.connectDatabase();
                    Connection conn = dt.getCon();
                    String sql = "ALTER SYSTEM KILL SESSION '" + sid + ", " + serial + "'";
                    conn.prepareStatement(sql).executeUpdate();
                    System.out.println("Session with SID " + sid + " and Serial " + serial + " has been cancelled.");
                    dt.closeConnection();
                    JOptionPane.showMessageDialog(this, "Huỷ thành công.");
                    jTable_SessionManager.setModel(new DefaultTableModel(null, new String[]{"Số Lượng Session", "SID", "Serial", "Username", "Ứng Dụng"}));
                    showDataTable(jTable_SessionManager);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Session này không thể huỷ");
                }
            }
        }
    }//GEN-LAST:event_jButton_DeleteSesionActionPerformed

    private void jTable_SessionManagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_SessionManagerMouseClicked
        int selectedRow = jTable_SessionManager.getSelectedRow();
        if (selectedRow != -1) {
            jTable_SessionManager.setVisible(true); // Show delete button on row selection
        } else {
            jTable_SessionManager.setVisible(false); // Hide delete button if no row is selected
        }
    }//GEN-LAST:event_jTable_SessionManagerMouseClicked

    /*
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
            java.util.logging.Logger.getLogger(GUI_SessionManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_SessionManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_SessionManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_SessionManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_SessionManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_DeleteSesion;
    private javax.swing.JButton jButton_ShowProcess;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_SessionManager;
    // End of variables declaration//GEN-END:variables
}
