package MAIN;


import static DAO.Dataservice.conn;
import SWING.EventMenuSelected;
import UI.UI_Audit_Policy;
import UI.UI_BAI4;
import UI.UI_CreateUserWithautomate;
import UI.UI_Register;
import UI.UI_SEETABLE;
import UI.UI_SessionManager;
import java.awt.Color;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;


public class Main extends javax.swing.JFrame {   
    private String username;
    private Timestamp lastLoginTime;
    public Main(){
        initComponents();
    }
    public Main(String username, Timestamp lastLoginTime) throws SQLException {
        this.username = username;
        this.lastLoginTime = lastLoginTime;
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        menu.initMoving(Main.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 1) {
                    try {
                        ThongBao(DAO.Dataservice.conn);
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   setForm(new UI_SEETABLE());
                    
                } else if (index == 2) {
                    try {
                        ThongBao(DAO.Dataservice.conn);
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    setForm(new UI_BAI4());
                }else if (index == 3){
                    try {
                        ThongBao(DAO.Dataservice.conn);
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    setForm(new UI_SessionManager());                
                }else if (index == 4){
                    try {
                        ThongBao(DAO.Dataservice.conn);
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    setForm(new UI.UI_TABLESPACEJPANEL());                
                }else if (index == 5){
                    try {
                        ThongBao(DAO.Dataservice.conn);
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(DAO.Dataservice.user.equalsIgnoreCase("admin1"))
                    {
                        setForm(new UI.UI_Register());
                    }else{
                        JOptionPane.showMessageDialog(null, "Chỉ Admin mới vào chức năng này!!");
                    }               
                }
                else if (index == 6){
                    try {
                        ThongBao(DAO.Dataservice.conn);
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    }else {
                        // Người dùng không muốn đăng xuất, không thực hiện hành động gì
                    }             
                }
                else if (index == 8){
                    setForm(new UI.UI_SeeInfoUser());                
                }else if (index == 9){
                    try {                
                        setForm(new UI.UI_POLICY());
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if (index == 10){   if(DAO.Dataservice.user.equalsIgnoreCase("sys as sysdba"))
                    {
                        setForm(new UI_Audit_Policy());
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Chỉ Sys mới vào chức năng này!!");
                    }            
                }else if (index == 12){
                    setForm(new UI.UI_CreateProfile()); }
                else if (index == 13){
                    setForm(new UI.UI_UpdateProfile()); }
                else if (index == 14){
                    setForm(new UI.UI_PHANQUYEN_HT());                
                }
                else if (index == 15){
                    setForm(new UI.UI_PHANQUYEN_DT());                
                }else if (index == 16){
                    setForm(new UI.UI_ROLE());
                }else if(index == 19)
                {
                    setForm(new UI_CreateUserWithautomate());
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

public void ThongBao(Connection conn) throws SQLException{
    if(conn.isClosed())
    {
        JOptionPane.showMessageDialog(rootPane, "Phiên Đã Hết Hạn!", "Thông Báo", HEIGHT);
        System.exit(0);
    }
    }
    private void setForm(JComponent com) {
        MainPanel.removeAll();
        MainPanel.add(com);
        MainPanel.repaint();
        MainPanel.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new SWING.PanelBorder();
        MainPanel = new javax.swing.JPanel();
        menu = new Component.Menu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_UserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_ShowLastLoginTime = new javax.swing.JTextField();
        jButton_Exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("UserName:");

        jTextField_UserName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_UserName.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Time:");

        jTextField_ShowLastLoginTime.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField_ShowLastLoginTime.setBorder(null);

        jButton_Exit.setBackground(new java.awt.Color(255, 102, 102));
        jButton_Exit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_Exit.setText("X");
        jButton_Exit.setBorder(null);
        jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextField_ShowLastLoginTime, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_Exit)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Exit)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_UserName, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(jTextField_ShowLastLoginTime))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_ShowLastLoginTime;
    private javax.swing.JTextField jTextField_UserName;
    private Component.Menu menu;
    private SWING.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
