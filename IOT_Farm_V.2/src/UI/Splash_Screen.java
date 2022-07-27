package UI;

import java.awt.Toolkit;

import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;


public class Splash_Screen extends javax.swing.JFrame {

    /**
     * Creates new form Welcome
     */
    public Splash_Screen() 
    {
        initComponents();
            
        setIconImage(new ImageIcon(getClass().getResource("/img/icons/iceberg_48px.png")).getImage());
    }
        
    public void close()
    {
        WindowEvent new_event;
        
        new_event = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new_event);
   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/iceberg_100px.png"))); // NOI18N
        jLabel1.setText("ICEBURG SMART FARM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 1360, 130));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rocket_30px.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 650, 1360, 40));

        bar.setBackground(new java.awt.Color(255, 255, 255));
        bar.setForeground(new java.awt.Color(51, 51, 51));
        bar.setBorderPainted(false);
        bar.setFocusable(false);
        bar.setOpaque(true);
        getContentPane().add(bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 700, 1400, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/69.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[])
    {
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Windows".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    
                    break;
                }
            }
        }
        catch(Exception ERROR)
        {
            Core.Background.Bugs_Log.exceptions(String.valueOf(ERROR));
        }

        Splash_Screen welcome = new Splash_Screen();
        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                welcome.setVisible(true);     
            }
        });
        
        try
        {
            for(int i = 0;i <= 100;i++)
            {
                Thread.sleep(40);
                
                bar.setValue(i);
                
                jLabel3.setText("APPLICATION LAUNCHING : "+Integer.valueOf(i)+"%");                            
            }
            
            Splash_Screen boot = new Splash_Screen();
            
            home Home = new home();
            
            Home.setVisible(true);
                                        
            welcome.dispose();
        }
        catch(InterruptedException ERROR)
        {            
            jLabel3.setText("Error : Something Wrong");
        }
        
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JProgressBar bar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
