/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Random;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.Regression;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/** @see https://stackoverflow.com/a/37716411/230513 */
public class RegressionTest {

    private static final int N = 85;
    //private static final Random R = new Random();
    
    //private static final int R 

    private static XYDataset createDataset() {
        XYSeries series = new XYSeries("Data");
        
        XYSeries series2 = new XYSeries("Data");
        
        series2.add(1,20);
        
        series2.add(85, 20);
        
        /*for (int i = 0; i < N; i++) {
            series.add(i, R.nextGaussian() + i);
        }*/
        series.add(1,83);
        series.add(2,84);
        series.add(3,83);
        series.add(4,82);
        series.add(5,81);
        
        XYSeriesCollection xyData = new XYSeriesCollection(series);
        double[] coefficients = Regression.getOLSRegression(xyData, 0);
        double b = coefficients[0]; // intercept
        double m = coefficients[1]; // slope
        XYSeries trend = new XYSeries("Trend");
        double x = series.getDataItem(0).getXValue();
        trend.add(x, m * x + b);
        x = series.getDataItem(series.getItemCount() - 1).getXValue();
        trend.add(x, m * x + b);
        xyData.addSeries(trend);
        return xyData;
    }

    private static JFreeChart createChart(final XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart("Test", "X", "Y",
            dataset, PlotOrientation.VERTICAL, true, false, false);
        return chart;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                XYDataset dataset = createDataset();
                JFreeChart chart = createChart(dataset);
                ChartPanel chartPanel = new ChartPanel(chart) {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(640, 480);
                    }
                };
                f.add(chartPanel);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
}