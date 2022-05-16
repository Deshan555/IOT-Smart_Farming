package com.deshan.chart;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;

public class ChartLine extends javax.swing.JPanel {

    public List<ModelChartLine> getModel() 
    {
        
        return model;
    }

    public void setModel(List<ModelChartLine> model) 
    {
        panelChartLine.removeAllData();
        this.model = model;
        initData();
    }

    private List<ModelChartLine> model;

    public ChartLine() {
        initComponents();
        setOpaque(false);
        setBackground(Color.WHITE);
    }

    private void initData() {
        panelChartLine.removeAllData();
        if (model != null) {
            for (ModelChartLine data : model) {
                panelChartLine.addItem(data);
                //panelData.add(new ItemChartLine(data));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelChartLine = new com.deshan.chart.PanelChartLine();

        setBackground(new java.awt.Color(204, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panelChartLineLayout = new javax.swing.GroupLayout(panelChartLine);
        panelChartLine.setLayout(panelChartLineLayout);
        panelChartLineLayout.setHorizontalGroup(
            panelChartLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        panelChartLineLayout.setVerticalGroup(
            panelChartLineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        add(panelChartLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 320, 190));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.deshan.chart.PanelChartLine panelChartLine;
    // End of variables declaration//GEN-END:variables
}
