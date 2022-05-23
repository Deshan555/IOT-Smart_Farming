package com.deshan.swing.noticeboard;

import com.deshan.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class NoticeBoard extends javax.swing.JPanel {

    public NoticeBoard() {
        initComponents();
        setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setViewportBorder(null);
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        panel.setLayout(new MigLayout("nogrid, fillx"));
        panel.setBackground(Color.yellow);
    }

    public void addNoticeBoard(ModelNoticeBoard data) {
        JLabel title = new JLabel(data.getTitle());
        title.setFont(new Font("Yu Gothic UI", 1, 14));
        title.setForeground(data.getTitleColor());
        panel.add(title);
        JLabel time = new JLabel(data.getTime());
        time.setForeground(new Color(180, 180, 180));
        panel.add(time, "gap 10, wrap");
        JTextPane txt = new JTextPane();
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setForeground(new Color(120, 120, 120));
        txt.setSelectionColor(new Color(150, 150, 150));
        txt.setFont(new Font("Yu Gothic UI", 1, 12));
        txt.setBorder(null);
        txt.setOpaque(false);
        txt.setEditable(false);
        txt.setText(data.getDescription());
        panel.add(txt, "w 100::90%, wrap");
    }

    public void addDate(String date) {
        JLabel lbDate = new JLabel(date);
        lbDate.setBorder(new EmptyBorder(5, 5, 5, 5));
        lbDate.setFont(new Font("Yu Gothic UI", 1, 14));
        lbDate.setForeground(new Color(80, 80, 80));
        panel.add(lbDate, "wrap");
        panel.setBackground(Color.WHITE);
    }

    public void scrollToTop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jScrollPane1.getVerticalScrollBar().setValue(0);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
