package com.deshan.swing.progress;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicProgressBarUI;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class ProgressCircleUI extends BasicProgressBarUI {

    public float getAnimate() {
        return animate;
    }

    public void setAnimate(float animate) {
        this.animate = animate;
    }

    private Animator animator;
    private float animate;

    public void start() {
        if (!animator.isRunning()) {
            animator.start();
        }
    }

    @Override
    public void installUI(JComponent jc) {
        super.installUI(jc);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                setAnimate(fraction);
                progressBar.repaint();
            }
        };
        animator = new Animator(800, target);
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Area area = new Area(createCircle(c, 0, 0, 360));
        area.subtract(new Area(createCircle(c, 15, 0, 360)));
        g2.setColor(new Color(216, 216, 216, 50));
        g2.fill(area);
        g2.setComposite(AlphaComposite.SrcIn);
        int r = (int) (progressBar.getPercentComplete() * 360);
        g2.setPaint(new GradientPaint(0, 0, progressBar.getBackground(), 0, c.getHeight(), progressBar.getForeground()));
        Area area1 = new Area(createCircle(c, 0, 90, -r * animate));
        area1.subtract(new Area(createCircle(c, 15, 0, 360)));
        g2.fill(area1);
        if (progressBar.isStringPainted()) {
            paintString(g);
        }
        g2.dispose();
    }

    private Shape createCircle(Component c, int s, int start, double angle) {
        int width = c.getWidth();
        int height = c.getHeight();
        int size = Math.min(width, height) - s;
        int x = (width - size) / 2;
        int y = (height - size) / 2;
        return new Arc2D.Double(x, y, size, size, start, angle, Arc2D.PIE);
    }

    private void paintString(Graphics g) {
        Insets b = progressBar.getInsets();
        int barRectWidth = progressBar.getWidth() - b.right - b.left;
        int barRectHeight = progressBar.getHeight() - b.top - b.bottom;
        g.setColor(new Color(212, 212, 212));
        paintString(g, b.left, b.top, barRectWidth, barRectHeight, 0, b);
    }
}
