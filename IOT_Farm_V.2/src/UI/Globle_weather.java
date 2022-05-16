/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.SQL_Lite3.Load_Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Jayashanka Deshan
 */
public class Globle_weather extends javax.swing.JInternalFrame {

    Integer value;
    
    public Globle_weather() throws FileNotFoundException 
    {
        initComponents();
        
                
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        BasicInternalFrameUI bis = (BasicInternalFrameUI) this.getUI();
        
        bis.setNorthPane(null);
        
        Timer timer;
        
        ActionListener actionListener = new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Date date = new Date();
                
                DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
                
                String time = timeFormat.format(date);
                
                timeFormat = new SimpleDateFormat("dd MMMM yyyy");
                
                today.setText(timeFormat.format(date));
                
                DateFormat get_status = new SimpleDateFormat("HH");
                
                String status = get_status.format(date);
                
                value = Integer.valueOf(status);
                
                 if((value>=00)&&(value<13))
                {                    
                    //clock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sun_80px.png")));
                    
                    //background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Background_02.png")));
                    
                    //today.setForeground(Color.);
                    
                    //time_zone.setBackground(Color.BLACK);
                    
                    
                }
                if((value>=13)&&(value<18))
                {
                    //System.out.print("Evening");
                    
                    //clock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/evening_80px.png")));
                    
                   // background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Background_04.jpg")));
                    
                    //today.setForeground(Color.BLACK);
                    
                    //time_zone.setForeground(Color.BLACK);
                }
                if((value>=18)&&(value<=24))
                {
                    //clock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/night_landscape_80px.png")));
                    
                    //background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Background_04.jfif")));
                    
                    //today.setForeground(Color.BLACK);
                    
                    //time_zone.setForeground(Color.BLACK);
                    
                    

                }
                
                time_zone.setText(time);
                
                try {
                    jLabel28.setText("Last Update : "+Core.Background.Cache_Reader.data("time.dat"));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Globle_weather.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        };
        
        timer = new Timer(1000, actionListener);
        
        timer.setInitialDelay(0);
        
        timer.start();
        
        
        

        
         /*List<ModelChartLine> list = new ArrayList<>();
        list.add(new ModelChartLine("Monday", 10));
        list.add(new ModelChartLine("Tuesday", 150));
        list.add(new ModelChartLine("Wednesday", 80));
        list.add(new ModelChartLine("Thursday", 100));
        list.add(new ModelChartLine("Friday", 125));
        list.add(new ModelChartLine("Saturday", 80));
        list.add(new ModelChartLine("Sunday", 200));
        chartLine1.setModel(list);*/
        
        //load_data();
        
        //Core.Background.Weather_Chart.Weather_Chart();
        
        Core.Background.Task_Schedule.tasker();
        
        //Weather_Chart.tasker();
        
       
    }

    
    
    
    
    public void load_data()
    {
        jLabel2.setText(Load_Data.load_condition("Weather"));
        
        jLabel27.setText(Load_Data.load_condition("Weather")+","+Load_Data.load_condition("Weather_description"));
        
        jLabel24.setText(Load_Data.load_condition("Feel_Like")+" F");
        
        jLabel18.setText(Load_Data.load_condition("Wind_Speed")+" km/h");
        
        jLabel21.setText(Load_Data.load_condition("Pressure")+" MB");
        
        jLabel14.setText("Max Temperature : "+Load_Data.load_condition("Max_Temp")+" F");
        
        jLabel15.setText("Min Temperature : "+Load_Data.load_condition("Min_Temp")+ " F");
        
        jLabel7.setText("Temperature In F : "+Load_Data.load_condition("Temperature")+ " F");
        
        jLabel16.setText(Load_Data.load_condition("Humidity")+"%");
    }
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel28 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        time_zone = new javax.swing.JLabel();
        today = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        chartLine1 = new com.deshan.chart.ChartLine();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("LAST UPDATE : ");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 580, 350, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dashboard_icons/location_25px.png"))); // NOI18N
        jLabel1.setText("Rathnapura, Sri Lanka");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 520, 350, 50));

        time_zone.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        time_zone.setForeground(new java.awt.Color(255, 255, 255));
        time_zone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        time_zone.setText("2.30P.M");
        getContentPane().add(time_zone, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 390, 350, 70));

        today.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        today.setForeground(new java.awt.Color(255, 255, 255));
        today.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        today.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dashboard_icons/calendar_4_25px.png"))); // NOI18N
        today.setText("2022 - 10 - 22");
        getContentPane().add(today, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 470, 350, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Layout/8140.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 350, 700));

        jPanel2.setBackground(new java.awt.Color(242, 242, 242));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Fahrenheit");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 650, 260, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Weather_Icons/Orginal/807-mild-rain-outline.png"))); // NOI18N
        jLabel2.setText("MID RAIN");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 220, 90));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("millibars");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 650, 260, 30));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(102, 102, 102));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 510, 180));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("mid Rain, overcast clouds");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 270, 40));

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("760 MB");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, 270, 60));

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("310.28 F");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 590, 260, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/temp_80.gif"))); // NOI18N
        jLabel4.setText("TEMPERATURE");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 270, 80));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Temperature In F : 304.55");

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Max Temperature :  304.55 F");

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Min Temperature :  304.55 F ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 240, 120));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Atmospheric pressure.gif"))); // NOI18N
        jLabel20.setText("AIR PRESSURE");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, 280, 60));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Check Out Today's Weather Information");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 651, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/feel_like.gif"))); // NOI18N
        jLabel23.setText("FEEL LIKE");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, 240, 70));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Layout/Weather_Card.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 496, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Layout/Weather_Card.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 496, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/humidity_80.gif"))); // NOI18N
        jLabel25.setText("HUMIDITY");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 250, 80));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Atmospheric water Percentage %");

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("96%");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 240, 110));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Layout/Weather_Card.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 272, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Kilometer per hour");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 260, 30));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("8.5 km/h");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 260, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Layout/Weather_Card.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 272, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/windspeed_80.gif"))); // NOI18N
        jLabel17.setText("WIND SPEED");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 220, 70));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Layout/Weather_Card.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 496, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Layout/Weather_Card.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 272, -1, -1));
        jPanel2.add(chartLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 51, 860, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static com.deshan.chart.ChartLine chartLine1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    public static javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    public static javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    public static javax.swing.JLabel jLabel27;
    public static javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel time_zone;
    private javax.swing.JLabel today;
    // End of variables declaration//GEN-END:variables
}
