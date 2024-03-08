package UI;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ACER
 */
public class UI_SEETABLE extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public UI_SEETABLE() {
        initComponents();
        jTable1.setVisible(false);
        
    }                                                                             
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_SEETABLE().setVisible(true);
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(757, 504));

        jButton1.setText("SEE TABLE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "KHACHHANG", "CHITIETHOADON", "SANPHAM" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("TABLE 1");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(341, 341, 341))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 168, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTable1.setVisible(true);
        
        Connection con;
        Statement st;
        try {       
            Class.forName("oracle.jdbc.OracleDriver");            
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sys", "123");
            System.out.println("Connected to databse");                       
            st = con.createStatement();
            
            String selectedValue = jList1.getSelectedValue();
            
            String sql=String.format("SELECT * FROM %s", selectedValue);
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next())
            {
                if(selectedValue == "KHACHHANG"){
                
                    String title[]={"MAKH","TENKH","SDT_KH","DIACHI_KH","NULL","NULL"};
                for(int i=0;i<6;i++)
                {
                     jTable1.getColumnModel().getColumn(i).setHeaderValue(title[i]);
                }
                String Ma = rs.getString("MAKH");
                String Ten = rs.getString("TENKH");
                String SDT = rs.getString("SDT_KH");
                String DIACHI = rs.getString("DIACHI_KH");
                
                String tbData[] = {Ma,Ten,SDT,DIACHI};   
                DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();                               
                tblModel.addRow(tbData);
                }
                else if(selectedValue == "SANPHAM"){
                    String title[]={"MASP","TENSP","DVT","GIABAN","SOLUONG","MALOAISP"};
                for(int i=0;i<6;i++)
                {
                     jTable1.getColumnModel().getColumn(i).setHeaderValue(title[i]);
                }
                String Ma = rs.getString("MASP");
                String Ten = rs.getString("TENSP");
                String DVT = rs.getString("DVT");
                String GIABAN = String.valueOf(rs.getFloat("GIABAN"));
                String SOLUONG = String.valueOf(rs.getInt("SOLUONG"));
                String MALOAISP = rs.getString("MALOAISP");
                
                String tbData[] = {Ma,Ten,DVT,GIABAN,SOLUONG,MALOAISP}; 
                DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();                               
                tblModel.addRow(tbData);
                }
                else if(selectedValue == "CHITIETHOADON"){
                String title[]={"MAHD","MASP","GIABAN","SOLUONG","THANHTIEN","NULL"};
                for(int i=0;i<6;i++)
                {
                     jTable1.getColumnModel().getColumn(i).setHeaderValue(title[i]);
                }
                String Ma = rs.getString("MAHD");
                String Ten = rs.getString("MASP");
                String GIABAN = String.valueOf(rs.getFloat("GIABAN"));
                String SOLUONG = String.valueOf(rs.getInt("SOLUONG"));
                String THANHTIEN = String.valueOf(rs.getFloat("THANHTIEN"));
                
                String tbData[] = {Ma,Ten,GIABAN,SOLUONG,THANHTIEN}; 
                DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();                               
                tblModel.addRow(tbData);
                }          
                
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
