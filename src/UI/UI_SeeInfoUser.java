package UI;

import DAO.Dataservice;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;


public class UI_SeeInfoUser extends javax.swing.JPanel {

    
    public UI_SeeInfoUser() {
        initComponents();
    }

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Created Date", "Expiration Date", "Status", "Last Login", "Profile"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("SEE USER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "TUYEN", "DEPTRAI", "SCOTT", "SYS", "ST", "AA" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents
        ResultSet rs = null;
        CallableStatement cs = null;
        Connection con = null;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            con = Dataservice.Getconnect();
            cs = con.prepareCall("{CALL PROC_GetUserInfo(?, ?)}");
            String selectedValue = jList1.getSelectedValue();
            cs.setString(1, selectedValue); 

            cs.registerOutParameter(2, OracleTypes.CURSOR); // Đăng ký tham số out là một CURSOR

            cs.execute();

            rs = ((OracleCallableStatement) cs).getCursor(2); // Lấy thông tin CURSOR từ tham số out

            // Tạo đối tượng DefaultTableModel với các cột tương ứng
            // Lấy TableModel từ jtable1
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

            // Xóa các hàng cũ trong TableModel (nếu có)
            tableModel.setRowCount(0);

            // Thêm dữ liệu từ ResultSet vào TableModel
            while (rs.next()) {
                String username = rs.getString("username");
                Date createdDate = rs.getDate("created");
                Date expirationDate = rs.getDate("expiry_date");
                String status = rs.getString("account_status");
                Date lastLogin = rs.getDate("last_login");
                String profileName = rs.getString("profile");

                // Thêm hàng mới vào TableModel
                tableModel.addRow(new Object[]{username, createdDate, expirationDate, status, lastLogin, profileName});
            }

            // Cập nhật JTable để hiển thị dữ liệu mới
            tableModel.fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Đóng các tài nguyên
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        
}
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
