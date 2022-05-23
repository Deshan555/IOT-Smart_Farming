package com.deshans.swing;

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JLabel;

import javax.swing.border.EmptyBorder;

public class TableCell extends JLabel
{

    public TableCell(String value)
    {
        super(value);
    
        setForeground(new Color(60, 60, 60));
        
        setFont(new java.awt.Font("Yu Gothic UI", 0, 14));
        
        setBorder(new EmptyBorder(5, 5, 5, 5));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        g.setColor(new Color(250, 250, 250));
    
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(new Color(255, 255, 255));
        
        g.fillRect(0, 6, getWidth(), getHeight() - 12);
        
        super.paintComponent(g);
    }
}
