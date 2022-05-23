/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.Background.Active_Status;
import Core.Background.Bugs_Log;
import Core.MySql.Connector;
import com.deshan.model.ModelStaff;
import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jayashanka Deshan
 */
public class devices extends javax.swing.JInternalFrame {

    
    
    public devices() 
    {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        BasicInternalFrameUI bis = (BasicInternalFrameUI) this.getUI();
        
        bis.setNorthPane(null);
        
        tasker();
        
        table2.setFont(new Font("Serif", Font.BOLD, 20));
    }
    
    public void tasker()
    {
        Timer t = new Timer();
        
        t.schedule(new TimerTask()
        {
            @Override
        
            public void run() 
            {
                table_clean();
                
                initData();
                
                map_set();
                
                status();
            }
        }, 0, 10000);
    }
    
    public void table_clean()
    {
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        
        int rowCount = model.getRowCount();
                
        for (int i = rowCount - 1; i >= 0; i--) 
        {
            model.removeRow(i);
        }
    }
    
    private void initData() 
    {
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        
        String SQL = "SELECT * FROM devices;";
        
        String status = null;
        
        int count = 0;
        
        int active_nodes = 0;
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                String id = rs.getString("device_ID");
                
                String name =  rs.getString("device_Name");
                
                String active =  rs.getString("last_active");
                
                if(rs.getString("status").equals("A"))
                {
                    status = "ACTIVATED";
                    
                    active_nodes++;
                }
                else
                {
                    status = "DISABLE";
                }
                
                count++;
                                
                model.addRow(new ModelStaff(new ImageIcon(getClass().getResource("/img/cloud_development_100px.png")), id, name, active, status).toDataTable());
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }

        table2.fixTable(jScrollPane2);
        
        table2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14));
        
        jLabel5.setText(String.valueOf(count));
        
        jLabel7.setText(String.valueOf(active_nodes));
    }
    

    public void status()
    {
       try
       {
           if(Active_Status.load_status("2944799").equals("A"))
           {
               jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/sucess.png")));
           }
           else
           {
               jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/warning.png")));
           }
           
           if(Active_Status.load_status("3012594").equals("A"))
           {
               jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/sucess.png")));
           }
           else
           {
               jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/warning.png")));
           }
           
           if(Active_Status.load_status("2605093").equals("A"))
           {
               jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/sucess.png")));
           }
           else
           {
               jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/warning.png")));
           }
           
           if(Active_Status.load_status("2944800").equals("A"))
           {
               jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/sucess.png")));
           }
           else
           {
               jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/warning.png")));
           }
           
           if(Active_Status.load_status("2649500").equals("A"))
           {
               jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/sucess.png")));
           }
           else
           {
               jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/warning.png")));
           }
           
           if(Active_Status.load_status("2619500").equals("A"))
           {
               jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/sucess.png")));
           }
           else
           {
               jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/warning.png")));
           }
           
           if(Active_Status.load_status("2644500").equals("A"))
           {
               jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/sucess.png")));
           }
           else
           {
               jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/warning.png")));
           }
                      
           if(Active_Status.load_status("3032489").equals("A"))
           {
               jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/sucess.png")));
           }
           else
           {
               jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/warning.png")));
           }
       }
       catch(Exception error)
       {
           
       }
    }
    
    public static void applyQualityRenderingHints(Graphics2D g2d) {

    g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
    g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

}
    
    public static void map_set()
    {
                        BufferedImage master = null;
                try {
                    master = ImageIO.read(new File("map.jpg"));
                } catch (IOException ex) {
                    
                }

    int diameter = Math.min(master.getWidth(), master.getHeight());
    BufferedImage mask = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);

    Graphics2D g2d = mask.createGraphics();
    applyQualityRenderingHints(g2d);
    g2d.fillOval(0, 0, diameter - 1, diameter - 1);
    g2d.dispose();

    BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
    g2d = masked.createGraphics();
    applyQualityRenderingHints(g2d);
    int x = (diameter - master.getWidth()) / 2;
    int y = (diameter - master.getHeight()) / 2;
    g2d.drawImage(master, x, y, null);
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
    g2d.drawImage(mask, 0, 0, null);
    g2d.dispose();

    //JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(masked)));
    
    jLabel1.setIcon(new javax.swing.ImageIcon(masked));
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
        jPanel2 = new javax.swing.JPanel();
        roundPanel2 = new com.deshan.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new com.deshans.swing.Table();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        roundPanel3 = new com.deshan.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        roundPanel4 = new com.deshan.swing.RoundPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        roundPanel5 = new com.deshan.swing.RoundPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundPanel2.setBackground(new java.awt.Color(242, 242, 242));

        table2.setForeground(new java.awt.Color(51, 51, 51));
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SENSOR", "DEVICE ID", "DEVICE NAME", "LAST ACTIVE", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        table2.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(table2);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1210, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(roundPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 1230, 350));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/warning.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 180, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/warning.png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 220, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/warning.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 80, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/sucess.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 220, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/sucess.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 80, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/warning.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 160, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/warning.png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 250, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notifications/warning.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 40, -1, -1));

        roundPanel3.setBackground(new java.awt.Color(242, 242, 242));
        roundPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/map.jpg"))); // NOI18N
        roundPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(911, 0, -1, 310));

        roundPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/history/Sandy_Tech-27_Single-12.jpg"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 80)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("10");

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ACTIVE NODES");

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel3.add(roundPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 430, 290));

        roundPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/history/Sandy_Tech-18_Single-05.jpg"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 80)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("10");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TOTAL NODES");

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addGroup(roundPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)))
                .addContainerGap())
        );

        roundPanel3.add(roundPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 290));

        jPanel2.add(roundPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1230, 310));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 730));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private com.deshan.swing.RoundPanel roundPanel2;
    private com.deshan.swing.RoundPanel roundPanel3;
    private com.deshan.swing.RoundPanel roundPanel4;
    private com.deshan.swing.RoundPanel roundPanel5;
    private com.deshans.swing.Table table2;
    // End of variables declaration//GEN-END:variables
}
