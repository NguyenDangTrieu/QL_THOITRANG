/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Component;


import MODEL.MODEL_Menu;
import SWING.EventMenuSelected;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicScrollBarUI;
public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;
    public void addEventMenuSelected(EventMenuSelected event){
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }
    
    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);       
        jScrollPane2.setOpaque(false);
        jScrollPane2.setBorder(null);
        init();
        
    }

    private void init() {
        listMenu1.addItem(new MODEL_Menu("", "TUẦN 1", MODEL_Menu.MenuType.TITLE));
        listMenu1.addItem(new MODEL_Menu("1", "T.XEM BẢNG", MODEL_Menu.MenuType.MENU));
        listMenu1.addItem(new MODEL_Menu("2", "T.XEM SGA", MODEL_Menu.MenuType.MENU));
        listMenu1.addItem(new MODEL_Menu("3", "D.SESSION", MODEL_Menu.MenuType.MENU));
        listMenu1.addItem(new MODEL_Menu("4", "TR.TABLESPACE", MODEL_Menu.MenuType.MENU));
        listMenu1.addItem(new MODEL_Menu("5", "TR.Register", MODEL_Menu.MenuType.MENU));
          listMenu1.addItem(new MODEL_Menu("6", "TR.Logout", MODEL_Menu.MenuType.MENU));
      
        listMenu1.addItem(new MODEL_Menu("", "TUẦN 2", MODEL_Menu.MenuType.TITLE));
        listMenu1.addItem(new MODEL_Menu("7", "T.PROFILE USER", MODEL_Menu.MenuType.MENU));
        listMenu1.addItem(new MODEL_Menu("8", "TR.POLICY", MODEL_Menu.MenuType.MENU));
        listMenu1.addItem(new MODEL_Menu("9", "D.AUDIT", MODEL_Menu.MenuType.MENU));
        
        listMenu1.addItem(new MODEL_Menu("", "TUẦN 3", MODEL_Menu.MenuType.TITLE));
        listMenu1.addItem(new MODEL_Menu("10", "D.PROFILE", MODEL_Menu.MenuType.MENU));
        listMenu1.addItem(new MODEL_Menu("11", "TR.UPDATE_PROFILE", MODEL_Menu.MenuType.MENU));
        listMenu1.addItem(new MODEL_Menu("12", "T.PHAN_QUYEN_HT", MODEL_Menu.MenuType.MENU));
        listMenu1.addItem(new MODEL_Menu("13", "T.PHAN_QUYEN_DT", MODEL_Menu.MenuType.MENU));
        listMenu1.addItem(new MODEL_Menu("14", "T.TAO_XOA", MODEL_Menu.MenuType.MENU));

        listMenu1.addItem(new MODEL_Menu("", "TUẦN 4", MODEL_Menu.MenuType.TITLE));
        
        listMenu1.addItem(new MODEL_Menu("", "TUẦN 5", MODEL_Menu.MenuType.TITLE));
        
        listMenu1.addItem(new MODEL_Menu("", "", MODEL_Menu.MenuType.EMPTY));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelMoving = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listMenu1 = new SWING.ListMenu<>();

        jPanel1.setOpaque(false);

        panelMoving.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelMoving.setText("THỜI TRANG");
        panelMoving.setToolTipText("");
        panelMoving.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane2.setViewportView(listMenu1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }
    
    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private SWING.ListMenu<String> listMenu1;
    private javax.swing.JLabel panelMoving;
    // End of variables declaration//GEN-END:variables
}
