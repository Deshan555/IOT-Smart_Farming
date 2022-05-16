package com.deshan.chart;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class PanelChartPie extends javax.swing.JPanel {

    private final List<ModelChartPie> list;
    private float chartSize = 0.5f;

    public PanelChartPie() {
        initComponents();
        list = new ArrayList<>();
        setBackground(new Color(250, 250, 250));
        setOpaque(false);
    }

    private double getTotal() {
        double total = 0;
        for (ModelChartPie d : list) {
            total += d.getValue();
        }
        return total;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double x = (width - size) / 2;
        double y = (height - size) / 2;
        Shape area = new Ellipse2D.Double(x, y, size, size);
        g2.setColor(getBackground());
        g2.fill(area);
        double total = getTotal();
        double curvalu = 0;
        for (ModelChartPie data : list) {
            double startAngle = (curvalu * 360f / total) + 90;  //  +90 to start from 90 angle
            double angle = (data.getValue() * 360f / total);
            g2.setColor(data.getColor());
            Shape shape = new Arc2D.Double(x, y, size, size, startAngle, angle, Arc2D.PIE);
            g2.fill(shape);
            curvalu += data.getValue();
        }
        double inSize = size * chartSize;
        double x1 = (width - inSize) / 2;
        double y1 = (height - inSize) / 2;
        Shape cut = new Ellipse2D.Double(x1, y1, inSize, inSize);
        g2.setComposite(AlphaComposite.Clear);
        g2.fill(cut);
        grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    }

    public void addItem(ModelChartPie data) {
        list.add(data);
        repaint();
    }

    public void removeAllData() {
        list.clear();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
