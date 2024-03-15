/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MAIN;

import UI.UI_SessionManager;
import static java.awt.image.ImageObserver.HEIGHT;
import static DAO.Dataservice.conn;
import SWING.EventMenuSelected;
import UI.UI_TABLESPACEJPANEL;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Main extends javax.swing.JFrame {
   
    private String username;
    private java.sql.Timestamp lastLoginTime;
    // Constructor với tham số Session
    
    public Main() {
    }

    public Main(String username, java.sql.Timestamp lastLoginTime) throws SQLException {
        this.username = username;
        this.lastLoginTime = lastLoginTime;
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        menu.initMoving(Main.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                } else if (index == 1) {
                    setForm(new UI_TABLESPACEJPANEL());
                    try {
                        ThongBao(conn);
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else if (index == 2) {
                    setForm(new UI_SessionManager());
                } else if (index == 8) {
                    int confirmLogout = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn đăng xuất?", "Xác nhận Đăng Xuất", JOptionPane.YES_NO_OPTION);

                    if (confirmLogout == JOptionPane.YES_OPTION) {
                        // Thực hiện đăng xuất
                        boolean success = DAO.Dataservice.logoutUser(DAO.Dataservice.user.toUpperCase());

                        if (success) {
                            JOptionPane.showMessageDialog(rootPane, "Đăng Xuất Thành Công");
                            dispose(); // Đóng cửa sổ hiện tại sau khi đăng xuất thành công
                        } else {
                            JOptionPane.showMessageDialog(rootPane,"Đăng xuất không thành công.");
                        }
                    } else {
                        // Người dùng không muốn đăng xuất, không thực hiện hành động gì
                    }
                }
            }
        });
        ThongBao(conn);
        // Set the username and last login time fields
        jTextField_UserName.setText(username);
        if (lastLoginTime != null) {
            jTextField_ShowLastLoginTime.setText(lastLoginTime.toString());
        } else {
            jTextField_ShowLastLoginTime.setText("No login history found");
        }
    }

    private void setForm(JComponent com) {
        MainPanel.removeAll();
        MainPanel.add(com);
        MainPanel.repaint();
        MainPanel.revalidate();
    }
    
    public void ThongBao(Connection conn) throws SQLException{
    if(conn.isClosed())
    {
        JOptionPane.showMessageDialog(rootPane, "Phiên Đã Hết Hạn!", "Thông Báo", HEIGHT);
        System.exit(0);
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new SWING.PanelBorder();
        menu = new Component.Menu();
        MainPanel = new javax.swing.JPanel();
        jTextField_UserName = new javax.swing.JTextField();
        jTextField_ShowLastLoginTime = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_Exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setLayout(new java.awt.BorderLayout());

        jTextField_UserName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_UserName.setBorder(null);

        jTextField_ShowLastLoginTime.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_ShowLastLoginTime.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("UserName:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Time:");

        jButton_Exit.setBackground(new java.awt.Color(255, 102, 102));
        jButton_Exit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_Exit.setText("X");
        jButton_Exit.setBorder(null);
        jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(0, 296, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_ShowLastLoginTime, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jButton_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_ShowLastLoginTime)
                    .addComponent(jButton_Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_UserName)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_ExitActionPerformed

    
    public static void main(String args[]) { 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton jButton_Exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField_ShowLastLoginTime;
    private javax.swing.JTextField jTextField_UserName;
    private Component.Menu menu;
    private SWING.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
