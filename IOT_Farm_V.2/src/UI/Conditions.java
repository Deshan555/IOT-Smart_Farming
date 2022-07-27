/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.Background.Bugs_Log;
import Core.Background.get_localDate;
import Core.Background.water_lvReformat;
import Core.MySql.Connector;
import static Core.MySql.data_count.count;
import static UI.NewJFrame.list;
import com.deshan.chart.ModelChartLine;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import org.jfree.chart.renderer.category.BarRenderer;

/**
 *
 * @author Jayashanka Deshan
 */
public class Conditions extends javax.swing.JInternalFrame {

 
    public static String date = get_localDate.LocalDate();
    
    public Conditions() 
    {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        BasicInternalFrameUI bis = (BasicInternalFrameUI) this.getUI();
        
        bis.setNorthPane(null);
        
        showLineChart();
        
        showBarChart();
        
        update_chart();
        
        showLineChart1();
        
        showBarChart1();
        
        update_chart1();
        
        showLineChart2();
        
        showBarChart2();
        
        update_chart2();
        
        showLineChart3();
        
        showBarChart3();
        
        humidity_max();
        
        humidity_min();
        
        catch_maxTemp();
        
        catch_minTemp();
        
        catch_maxHeatIndex();
        
        catch_minHeatIndex();
        
        catch_maxGas();
        
        catch_minGas();
        
        wleval_max();
        
        wleval_min();
        
        showLineChart4();
        
        showBarChart4();
        
        soil_max();
        
        soil_min();
        
        showLineChart5();
        
        showBarChart5();
        
        //showHistogram();
        

        
    }
    
    
    
    
    
    // for tabed pane 01
    
    
    public void showBarChart()
     {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int count = count("sensor_box_01");
        
        int extract = count - 5;
        
        int x = 0;

        String SQL = "SELECT * FROM sensor_box_01;";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                if(x >= extract)
                {
                    String value = rs.getString("temperature");
                
                    String date =  rs.getString("record_date");
                
                    String time =  rs.getString("record_time");
                
                    dataset.setValue(Double.parseDouble(value), "temperature(C)", date+" : "+time);
                }
                
                x++;
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
        
        JFreeChart chart = ChartFactory.createBarChart("","date and time","temperature(C)", dataset, PlotOrientation.HORIZONTAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        
        Color clr3 = new Color(29, 143, 216);
        
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        
        panel_3.removeAll();
        
        panel_3.add(barpChartPanel, BorderLayout.CENTER);
        
        panel_3.validate();
        
        
    }
    

    public void showLineChart()
    {
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int count = count("sensor_box_01");
        
        int extract = count - 5;
        
        int x = 0;

        String SQL = "SELECT * FROM sensor_box_01;";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                if(x >= extract)
                {
                    String value = rs.getString("temperature");
                
                    String date =  rs.getString("record_date");
                
                    String time =  rs.getString("record_time");
                
                    dataset.setValue(Double.parseDouble(value), "temperature(C)", date+" : "+time);
                }
                
                x++;
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("","date and time","temperature(C)",dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        
        Color lineChartColor = new Color(29, 143, 216);
        
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        
        panel_1.removeAll();
        
        panel_1.add(lineChartPanel, BorderLayout.CENTER);
        
        panel_1.validate();
    }
    
    public void update_chart()
    {
       String SQL = "SELECT * FROM sensor_box_01;";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                String value = rs.getString("temperature");
                
                String date =  rs.getString("record_date");
                
                String time =  rs.getString("record_time");
                
                list.add(new ModelChartLine("Data", Double.parseDouble(value)));
                
                pane.append("Temp : "+value+"C ("+date+")\n\n");
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }        
        data.setModel(list);
    }
    
    
    
    
    // for tabed pane 02
    
    
    public void showBarChart1()
     {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int count = count("sensor_box_01");
        
        int extract = count - 5;
        
        int x = 0;

        String SQL = "SELECT * FROM sensor_box_01;";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                if(x >= extract)
                {
                String value = rs.getString("heat_index");
                
                String date =  rs.getString("record_date");
                
                String time =  rs.getString("record_time");
                
                dataset.setValue(Double.parseDouble(value), "heat index(C)", date+" : "+time);
                }
                
                x++;
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
        
        JFreeChart chart = ChartFactory.createBarChart("","date and time","heat index(C)", dataset, PlotOrientation.HORIZONTAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        
        Color clr3 = new Color(29, 143, 216);
        
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        
        panel_4.removeAll();
        
        panel_4.add(barpChartPanel, BorderLayout.CENTER);
        
        panel_4.validate();
        
        
    }
    

    public void showLineChart1()
    {
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int count = count("sensor_box_01");
        
        int extract = count - 5;
        
        int x = 0;
        
        String SQL = "SELECT * FROM sensor_box_01;";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                if(x >= extract)
                {
                String value = rs.getString("heat_index");
                
                String date =  rs.getString("record_date");
                
                String time =  rs.getString("record_time");
                
                dataset.setValue(Double.parseDouble(value), "heat index(C)", date+" : "+time);
                }
                
                x++;

            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("","date and time","heat index(C)",dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        
        Color lineChartColor = new Color(29, 143, 216);
        
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        
        panel_2.removeAll();
        
        panel_2.add(lineChartPanel, BorderLayout.CENTER);
        
        panel_2.validate();
    }
    
    public void update_chart1()
    {
       String SQL = "SELECT * FROM sensor_box_01;";
        
        Connection connection = Connector.connection();
        
        List<ModelChartLine> lists = new ArrayList<>();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                String value = rs.getString("heat_index");
                
                String date =  rs.getString("record_date");
                
                String time =  rs.getString("record_time");
                
                lists.add(new ModelChartLine("Data", Double.parseDouble(value)));
                
                pane1.append("heat index : "+value+"C ("+date+")\n\n");
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
        
        data1.setModel(lists);
    }
    
    
    // for tabed pane 03
    
    
    public void showBarChart2()
     {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int count = count("sensor_box_01");
        
        int extract = count - 5;
        
        int x = 0;

        String SQL = "SELECT * FROM sensor_box_01;";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                if(x >= extract)
                {
                String value = rs.getString("gas_value");
                
                String date =  rs.getString("record_date");
                
                String time =  rs.getString("record_time");
                
                dataset.setValue(Double.parseDouble(value), "gas value(PPM)", date+" : "+time);
                }
                
                x++;

            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
        
        JFreeChart chart = ChartFactory.createBarChart("","date and time","gas value(PPM)", dataset, PlotOrientation.HORIZONTAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        
        Color clr3 = new Color(29, 143, 216);
        
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        
        panel_6.removeAll();
        
        panel_6.add(barpChartPanel, BorderLayout.CENTER);
        
        panel_6.validate();
        
        
    }
    

    public void showLineChart2()
    {
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int count = count("sensor_box_01");
        
        int extract = count - 5;
        
        int x = 0;
        
        String SQL = "SELECT * FROM sensor_box_01;";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                if(x >= extract)
                {
                   String value = rs.getString("gas_value");
                
                   String date =  rs.getString("record_date");
                
                   String time =  rs.getString("record_time");
                
                   dataset.setValue(Double.parseDouble(value), "gas value(PPM)", date+" : "+time);
                }
                
                x++;
                
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("","date and time","gas value(PPM)",dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        
        Color lineChartColor = new Color(29, 143, 216);
        
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        
        panel_5.removeAll();
        
        panel_5.add(lineChartPanel, BorderLayout.CENTER);
        
        panel_5.validate();
    }
    
    public void update_chart2()
    {
       String SQL = "SELECT * FROM sensor_box_01;";
        
        Connection connection = Connector.connection();
        
        List<ModelChartLine> lists = new ArrayList<>();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                String value = rs.getString("gas_value");
                
                String date =  rs.getString("record_date");
                
                String time =  rs.getString("record_time");
                
                lists.add(new ModelChartLine("Data", Double.parseDouble(value)));
                
                pane2.append("Co2 : "+value+"PPM ("+date+")\n\n");
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
        
        data2.setModel(lists);
    }
    
    
    // for tabed pane 03
    
    
    public void showBarChart3()
     {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int count = count("sensor_box_01");
        
        int extract = count - 5;
        
        int x = 0;

        String SQL = "SELECT * FROM sensor_box_01;";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                if(x >= extract)
                {
                String value = rs.getString("humidity");
                
                String date =  rs.getString("record_date");
                
                String time =  rs.getString("record_time");
                
                dataset.setValue(Double.parseDouble(value), "humidity(%)", date+" : "+time);
                }
                
                x++;

            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
        
        JFreeChart chart = ChartFactory.createBarChart("","date and time","humidity(%)", dataset, PlotOrientation.HORIZONTAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        
        Color clr3 = new Color(29, 143, 216);
        
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        
        panel_8.removeAll();
        
        panel_8.add(barpChartPanel, BorderLayout.CENTER);
        
        panel_8.validate();
        
        
    }
    

    public void showLineChart3()
    {
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int count = count("sensor_box_01");
        
        int extract = count - 5;
        
        int x = 0;
        
        String SQL = "SELECT * FROM sensor_box_01;";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                if(x >= extract)
                {
                   String value = rs.getString("humidity");
                
                   String date =  rs.getString("record_date");
                
                   String time =  rs.getString("record_time");
                
                   dataset.setValue(Double.parseDouble(value), "humidity(%)", date+" : "+time);
                }
                
                x++;
                
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("","date and time","humidity(%)",dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        
        Color lineChartColor = new Color(29, 143, 216);
        
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        
        panel_7.removeAll();
        
        panel_7.add(lineChartPanel, BorderLayout.CENTER);
        
        panel_7.validate();
    }
    
    public void humidity_max()
    {
        String SQL = "SELECT MAX(humidity) FROM sensor_box_01 WHERE Record_date = '"+date+"';";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                Integer data = Integer.valueOf(rs.getString("MAX(humidity)"));
                
                jLabel22.setText("Max Humidity (%) : "+String.valueOf(data));
                
                jLabel23.setText("Data Extracted Date : "+date);
                
                bar_1.setBackground(Color.WHITE);
                
                bar_1.setForeground(Color.BLUE);
                
                bar_1.setValue(data);
                
                bar_1.start();
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.print(ERROR);
        }
    }
    
    public void humidity_min()
    {
        String SQL = "SELECT MIN(humidity) FROM sensor_box_01 WHERE Record_date = '"+date+"';";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {                
                double value = Double.parseDouble(rs.getString("MIN(humidity)"));
                
                int myInt = (int) value;
                
                jLabel24.setText("Min Humidity (%) : "+String.valueOf(myInt));
                
                jLabel21.setText("Data Extracted Date : "+date);
                
                bar_2.setBackground(Color.WHITE);
                
                bar_2.setForeground(Color.RED);
                
                bar_2.setValue(myInt);
                
                bar_2.start();
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.print(ERROR);
        }
    }
        
        
    public void catch_maxTemp()
    {
        String SQL = "SELECT Record_time, MAX(temperature) FROM sensor_box_01 WHERE Record_date = '"+date+"';";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {                
                jLabel5.setText("Max Temperature (C) : "+rs.getString("MAX(temperature)"));
                
                jLabel6.setText("Data Extracted Date : "+date);
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.print(ERROR);
        }
    }
    
    public void catch_minTemp()
    {
        String SQL = "SELECT Record_time, MIN(temperature) FROM sensor_box_01 WHERE Record_date = '"+date+"';";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {                
                jLabel7.setText("Min Temperature (C) : "+rs.getString("MIN(temperature)"));
                
                jLabel4.setText("Data Extracted Date : "+date);
               
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.print(ERROR);
        }
    }
    
    
    public void catch_maxHeatIndex()
    {
        String SQL = "SELECT Record_time, MAX(heat_index) FROM sensor_box_01 WHERE Record_date = '"+date+"';";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {                
                jLabel10.setText("Max Heat Index(C) : "+rs.getString("MAX(heat_index)"));
                
                jLabel11.setText("Data Extracted Date : "+date);
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.print(ERROR);
        }
    }
    
    public void catch_minHeatIndex()
    {
        String SQL = "SELECT Record_time, MIN(heat_index) FROM sensor_box_01 WHERE Record_date = '"+date+"';";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {                
                jLabel12.setText("Min HeatIndex(C) : "+rs.getString("MIN(heat_index)"));
                
                jLabel9.setText("Data Extracted Date : "+date);
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.print(ERROR);
        }
    }
    
    
    public void catch_maxGas()
    {
        String SQL = "SELECT Record_time, MAX(gas_value) FROM sensor_box_01 WHERE Record_date = '"+date+"';";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {                
                jLabel16.setText("Max Gas Value(PPM) : "+rs.getString("MAX(gas_value)"));
                
                jLabel17.setText("Data Extracted Date : "+date);
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.print(ERROR);
        }
    }
    
    public void catch_minGas()
    {
        String SQL = "SELECT Record_time, MIN(gas_value) FROM sensor_box_01 WHERE Record_date = '"+date+"';";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {                
                jLabel18.setText("Min Gas Value (PPM) : "+rs.getString("MIN(gas_value)"));
                
                jLabel15.setText("Data Extracted Date : "+date);
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.print(ERROR);
        }
    }
    
    
    // For water leval
    
    public void wleval_max()
    {
        String SQL = "SELECT MAX(Water_Level) FROM sensor_box_02 WHERE Record_date = '"+date+"';";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                Integer data = water_lvReformat.data_fix(rs.getString("MAX(Water_Level)"));
                
                jLabel28.setText("MAX WATER LEVEL : "+data+"%");
                
                jLabel29.setText("Data Extracted Date : "+date);
                
                //jLabel22.setText("Max Humidity (%) : "+String.valueOf(data));
                
                //jLabel23.setText("Data Extracted Date : "+date);
                
                System.out.println(data);
                
                gaugeChart1.setValueWithAnimation(data);
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.print(ERROR);
        }
    }
    
    public void wleval_min()
    {
        String SQL = "SELECT MIN(Water_Level) FROM sensor_box_02 WHERE Record_date = '"+date+"';";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                Integer data = water_lvReformat.data_fix(rs.getString("MIN(Water_Level)"));
                
                jLabel30.setText("MIN WATER LEVEL : "+data+"%");
                
                jLabel27.setText("Data Extracted Date : "+date);
                
                //jLabel22.setText("Max Humidity (%) : "+String.valueOf(data));
                
                //jLabel23.setText("Data Extracted Date : "+date);
                
                System.out.println(data);
                
                gaugeChart2.setValueWithAnimation(data);
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.print(ERROR);
        }
    }
    
    public void showBarChart4()
     {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int count = count("sensor_box_02");
        
        int extract = count - 5;
        
        int x = 0;

        String SQL = "SELECT * FROM sensor_box_02;";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                if(x >= extract)
                {
                int value = water_lvReformat.data_fix(rs.getString("water_level"));
                
                String date =  rs.getString("record_date");
                
                String time =  rs.getString("record_time");
                
                dataset.setValue(Double.valueOf(value), "water_level(%)", date+" : "+time);
                }
                
                x++;
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
        
        JFreeChart chart = ChartFactory.createBarChart("","date and time","water level(%)", dataset, PlotOrientation.HORIZONTAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        
        Color clr3 = new Color(29, 143, 216);
        
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        
        panel_10.removeAll();
        
        panel_10.add(barpChartPanel, BorderLayout.CENTER);
        
        panel_10.validate();
        
        
    }
    

    public void showLineChart4()
    {
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int count = count("sensor_box_02");
        
        int extract = count - 5;
        
        int x = 0;
        
        String SQL = "SELECT * FROM sensor_box_02;";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                if(x >= extract)
                {
                   int value = water_lvReformat.data_fix(rs.getString("water_level"));
                
                   String date =  rs.getString("record_date");
                
                   String time =  rs.getString("record_time");
                
                   dataset.setValue(Double.valueOf(value), "water_level(%)", date+" : "+time);
                }
                
                x++;
                
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("","date and time","water_level(%)",dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        
        Color lineChartColor = new Color(29, 143, 216);
        
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        
        panel_9.removeAll();
        
        panel_9.add(lineChartPanel, BorderLayout.CENTER);
        
        panel_9.validate();
    }
    
    
     public void showBarChart5()
     {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int count = count("sensor_box_02");
        
        int extract = count - 5;
        
        int x = 0;

        String SQL = "SELECT * FROM sensor_box_02;";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                if(x >= extract)
                {
                String value = rs.getString("Soil_Moisture");
                
                String date =  rs.getString("record_date");
                
                String time =  rs.getString("record_time");
                
                dataset.setValue(Double.parseDouble(value), "Soil Moisture(%)", date+" : "+time);
                }
                
                x++;
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
        
        JFreeChart chart = ChartFactory.createBarChart("","date and time","Soil Moisture(%)", dataset, PlotOrientation.HORIZONTAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        
        Color clr3 = new Color(29, 143, 216);
        
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        
        panel_12.removeAll();
        
        panel_12.add(barpChartPanel, BorderLayout.CENTER);
        
        panel_12.validate();
        
        
    }
    

    public void showLineChart5()
    {
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int count = count("sensor_box_02");
        
        int extract = count - 5;
        
        int x = 0;
        
        String SQL = "SELECT * FROM sensor_box_02;";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                if(x >= extract)
                {
                   String value = rs.getString("Soil_Moisture");
                
                   String date =  rs.getString("record_date");
                
                   String time =  rs.getString("record_time");
                
                   dataset.setValue(Double.parseDouble(value), "Soil Moisture(%)", date+" : "+time);
                }
                
                x++;
                
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.println(ERROR);
        }
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("","date and time","Soil Moisture(%)",dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        
        Color lineChartColor = new Color(29, 143, 216);
        
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        
        panel_11.removeAll();
        
        panel_11.add(lineChartPanel, BorderLayout.CENTER);
        
        panel_11.validate();
    }
    
    
    public void soil_max()
    {
        String SQL = "SELECT MAX(Soil_Moisture) FROM sensor_box_02 WHERE Record_date = '"+date+"';";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                Integer data = Integer.valueOf(rs.getString("MAX(Soil_Moisture)"));
                
                jLabel34.setText("MAX SOIL MOISTURE : "+data+"%");
                
                jLabel35.setText("Data Extracted Date : "+date);
                
                //jLabel22.setText("Max Humidity (%) : "+String.valueOf(data));
                
                //jLabel23.setText("Data Extracted Date : "+date);
                
                System.out.println(data);
                
                liquidProgress.setValue(data);
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.print(ERROR);
        }
    }
    
    public void soil_min()
    {
        String SQL = "SELECT MIN(Soil_Moisture) FROM sensor_box_02 WHERE Record_date = '"+date+"';";
        
        Connection connection = Connector.connection();
        
        try
        {
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next())
            {
                Integer data = Integer.valueOf(rs.getString("MIN(Soil_Moisture)"));
                
                jLabel36.setText("MIN SOIL MOISTURE : "+data+"%");
                
                jLabel33.setText("Data Extracted Date : "+date);
                
                //jLabel22.setText("Max Humidity (%) : "+String.valueOf(data));
                
                //jLabel23.setText("Data Extracted Date : "+date);
                
                System.out.println(data);
                
                liquidProgress1.setValue(data);
            }
            
            connection.close();
        }
        catch(SQLException ERROR)
        {
            Bugs_Log.exceptions(SQL);
            
            System.out.print(ERROR);
        }
    }
    
    
    

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        roundPanel3 = new com.deshan.swing.RoundPanel();
        jTextField1 = new javax.swing.JTextField();
        tab = new tabbed.MaterialTabbed();
        jPanel2 = new javax.swing.JPanel();
        roundPanel12 = new com.deshan.swing.RoundPanel();
        panel_1 = new javax.swing.JPanel();
        roundPanel14 = new com.deshan.swing.RoundPanel();
        panel_3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        roundPanel2 = new com.deshan.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pane = new javax.swing.JTextArea();
        data = new com.deshan.chart.ChartLine();
        roundPanel4 = new com.deshan.swing.RoundPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        roundPanel5 = new com.deshan.swing.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        roundPanel13 = new com.deshan.swing.RoundPanel();
        panel_2 = new javax.swing.JPanel();
        roundPanel15 = new com.deshan.swing.RoundPanel();
        panel_4 = new javax.swing.JPanel();
        roundPanel6 = new com.deshan.swing.RoundPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        roundPanel7 = new com.deshan.swing.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pane1 = new javax.swing.JTextArea();
        data1 = new com.deshan.chart.ChartLine();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        roundPanel8 = new com.deshan.swing.RoundPanel();
        jLabel13 = new javax.swing.JLabel();
        roundPanel16 = new com.deshan.swing.RoundPanel();
        panel_5 = new javax.swing.JPanel();
        roundPanel17 = new com.deshan.swing.RoundPanel();
        panel_6 = new javax.swing.JPanel();
        roundPanel9 = new com.deshan.swing.RoundPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        roundPanel10 = new com.deshan.swing.RoundPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pane2 = new javax.swing.JTextArea();
        data2 = new com.deshan.chart.ChartLine();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        roundPanel11 = new com.deshan.swing.RoundPanel();
        jLabel19 = new javax.swing.JLabel();
        roundPanel18 = new com.deshan.swing.RoundPanel();
        panel_7 = new javax.swing.JPanel();
        roundPanel19 = new com.deshan.swing.RoundPanel();
        panel_8 = new javax.swing.JPanel();
        roundPanel20 = new com.deshan.swing.RoundPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        roundPanel21 = new com.deshan.swing.RoundPanel();
        bar_1 = new com.deshan.swing.progress.Progress();
        bar_2 = new com.deshan.swing.progress.Progress();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        roundPanel22 = new com.deshan.swing.RoundPanel();
        jLabel25 = new javax.swing.JLabel();
        roundPanel23 = new com.deshan.swing.RoundPanel();
        panel_9 = new javax.swing.JPanel();
        roundPanel24 = new com.deshan.swing.RoundPanel();
        panel_10 = new javax.swing.JPanel();
        roundPanel25 = new com.deshan.swing.RoundPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        roundPanel26 = new com.deshan.swing.RoundPanel();
        gaugeChart1 = new chart.GaugeChart();
        gaugeChart2 = new chart.GaugeChart();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        roundPanel27 = new com.deshan.swing.RoundPanel();
        jLabel31 = new javax.swing.JLabel();
        roundPanel28 = new com.deshan.swing.RoundPanel();
        panel_11 = new javax.swing.JPanel();
        roundPanel29 = new com.deshan.swing.RoundPanel();
        panel_12 = new javax.swing.JPanel();
        roundPanel30 = new com.deshan.swing.RoundPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        roundPanel31 = new com.deshan.swing.RoundPanel();
        liquidProgress = new swing.LiquidProgress();
        liquidProgress1 = new swing.LiquidProgress();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.setText("Add Location");
        jTextField1.setBorder(null);
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBackground(new java.awt.Color(242, 242, 242));
        setBorder(null);

        tab.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tab.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(242, 242, 242));
        jPanel2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        roundPanel12.setBackground(new java.awt.Color(255, 255, 255));

        panel_1.setBackground(new java.awt.Color(153, 153, 153));
        panel_1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel12Layout = new javax.swing.GroupLayout(roundPanel12);
        roundPanel12.setLayout(roundPanel12Layout);
        roundPanel12Layout.setHorizontalGroup(
            roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel12Layout.setVerticalGroup(
            roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel14.setBackground(new java.awt.Color(255, 255, 255));

        panel_3.setBackground(new java.awt.Color(153, 153, 153));
        panel_3.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel14Layout = new javax.swing.GroupLayout(roundPanel14);
        roundPanel14.setLayout(roundPanel14Layout);
        roundPanel14Layout.setHorizontalGroup(
            roundPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_3, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel14Layout.setVerticalGroup(
            roundPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TEMPERATURE DATA");

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        pane.setEditable(false);
        pane.setColumns(20);
        pane.setFont(new java.awt.Font("Yu Gothic UI", 0, 13)); // NOI18N
        pane.setForeground(new java.awt.Color(51, 51, 51));
        pane.setRows(5);
        pane.setBorder(null);
        jScrollPane1.setViewportView(pane);

        roundPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 250, 260));
        roundPanel2.add(data, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 593, 259));

        roundPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/history/20944273.jpg"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Date : 2022-10-22 At : 22.34 P.M");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Max Temperature (f) : 110 F");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Date : 2022-10-22 At : 22.34 P.M");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Min Temperature (f) : 10 F");

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roundPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roundPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tab.addTab("TEMPERATURE DATA", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        roundPanel5.setBackground(new java.awt.Color(242, 242, 242));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HEAT INDEX / FEEL LIKE DATA");

        roundPanel13.setBackground(new java.awt.Color(255, 255, 255));

        panel_2.setBackground(new java.awt.Color(153, 153, 153));
        panel_2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel13Layout = new javax.swing.GroupLayout(roundPanel13);
        roundPanel13.setLayout(roundPanel13Layout);
        roundPanel13Layout.setHorizontalGroup(
            roundPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_2, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel13Layout.setVerticalGroup(
            roundPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel15.setBackground(new java.awt.Color(255, 255, 255));

        panel_4.setBackground(new java.awt.Color(153, 153, 153));
        panel_4.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel15Layout = new javax.swing.GroupLayout(roundPanel15);
        roundPanel15.setLayout(roundPanel15Layout);
        roundPanel15Layout.setHorizontalGroup(
            roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_4, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel15Layout.setVerticalGroup(
            roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/history/Wavy_Eco-05_Single-02.jpg"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Date : 2022-10-22 At : 22.34 P.M");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Max Temperature (f) : 110 F");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Date : 2022-10-22 At : 22.34 P.M");

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Min Temperature (f) : 10 F");

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(roundPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );

        roundPanel7.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);

        pane1.setEditable(false);
        pane1.setColumns(20);
        pane1.setFont(new java.awt.Font("Yu Gothic UI", 0, 13)); // NOI18N
        pane1.setForeground(new java.awt.Color(51, 51, 51));
        pane1.setRows(5);
        pane1.setBorder(null);
        jScrollPane2.setViewportView(pane1);

        roundPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 250, 260));
        roundPanel7.add(data1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 593, 259));

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1261, Short.MAX_VALUE)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tab.addTab("HEAT INDEX DATA", jPanel3);

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));
        jPanel1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jPanel4.setLayout(new java.awt.BorderLayout());

        roundPanel8.setBackground(new java.awt.Color(242, 242, 242));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("GAS VALUE (Co2 Parts Per Million)");

        roundPanel16.setBackground(new java.awt.Color(255, 255, 255));

        panel_5.setBackground(new java.awt.Color(153, 153, 153));
        panel_5.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel16Layout = new javax.swing.GroupLayout(roundPanel16);
        roundPanel16.setLayout(roundPanel16Layout);
        roundPanel16Layout.setHorizontalGroup(
            roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_5, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel16Layout.setVerticalGroup(
            roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel17.setBackground(new java.awt.Color(255, 255, 255));

        panel_6.setBackground(new java.awt.Color(153, 153, 153));
        panel_6.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel17Layout = new javax.swing.GroupLayout(roundPanel17);
        roundPanel17.setLayout(roundPanel17Layout);
        roundPanel17Layout.setHorizontalGroup(
            roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel17Layout.setVerticalGroup(
            roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/history/Wavy_Eco-03_Single-04.jpg"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Date : 2022-10-22 At : 22.34 P.M");

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Max Temperature (f) : 110 F");

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Date : 2022-10-22 At : 22.34 P.M");

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Min Temperature (f) : 10 F");

        javax.swing.GroupLayout roundPanel9Layout = new javax.swing.GroupLayout(roundPanel9);
        roundPanel9.setLayout(roundPanel9Layout);
        roundPanel9Layout.setHorizontalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundPanel9Layout.setVerticalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(roundPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );

        roundPanel10.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);

        pane2.setEditable(false);
        pane2.setColumns(20);
        pane2.setFont(new java.awt.Font("Yu Gothic UI", 0, 13)); // NOI18N
        pane2.setForeground(new java.awt.Color(51, 51, 51));
        pane2.setRows(5);
        pane2.setBorder(null);
        jScrollPane3.setViewportView(pane2);

        roundPanel10.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 250, 260));
        roundPanel10.add(data2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 593, 259));

        javax.swing.GroupLayout roundPanel8Layout = new javax.swing.GroupLayout(roundPanel8);
        roundPanel8.setLayout(roundPanel8Layout);
        roundPanel8Layout.setHorizontalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        roundPanel8Layout.setVerticalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(15, 15, 15)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1256, Short.MAX_VALUE))
            .addComponent(roundPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(roundPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("GAS VALUE DATA", jPanel1);

        jPanel5.setBackground(new java.awt.Color(242, 242, 242));
        jPanel5.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jPanel6.setLayout(new java.awt.BorderLayout());

        roundPanel11.setBackground(new java.awt.Color(242, 242, 242));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("HUMIDITY PRESENTAGE");

        roundPanel18.setBackground(new java.awt.Color(255, 255, 255));

        panel_7.setBackground(new java.awt.Color(153, 153, 153));
        panel_7.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel18Layout = new javax.swing.GroupLayout(roundPanel18);
        roundPanel18.setLayout(roundPanel18Layout);
        roundPanel18Layout.setHorizontalGroup(
            roundPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_7, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel18Layout.setVerticalGroup(
            roundPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_7, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel19.setBackground(new java.awt.Color(255, 255, 255));

        panel_8.setBackground(new java.awt.Color(153, 153, 153));
        panel_8.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel19Layout = new javax.swing.GroupLayout(roundPanel19);
        roundPanel19.setLayout(roundPanel19Layout);
        roundPanel19Layout.setHorizontalGroup(
            roundPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel19Layout.setVerticalGroup(
            roundPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/history/Wavy_Cst-02_Single-07.jpg"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Date : 2022-10-22 At : 22.34 P.M");

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Max Temperature (f) : 110 F");

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Date : 2022-10-22 At : 22.34 P.M");

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Min Temperature (f) : 10 F");

        javax.swing.GroupLayout roundPanel20Layout = new javax.swing.GroupLayout(roundPanel20);
        roundPanel20.setLayout(roundPanel20Layout);
        roundPanel20Layout.setHorizontalGroup(
            roundPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundPanel20Layout.setVerticalGroup(
            roundPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(roundPanel20Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );

        roundPanel21.setBackground(new java.awt.Color(255, 255, 255));

        bar_1.setBackground(new java.awt.Color(66, 246, 84));
        bar_1.setBorder(null);
        bar_1.setForeground(new java.awt.Color(19, 153, 32));
        bar_1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        bar_2.setBackground(new java.awt.Color(66, 246, 84));
        bar_2.setBorder(null);
        bar_2.setForeground(new java.awt.Color(19, 153, 32));
        bar_2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("MAX HUMIDITY (%)");

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("MIN HUMIDITY (%)");

        javax.swing.GroupLayout roundPanel21Layout = new javax.swing.GroupLayout(roundPanel21);
        roundPanel21.setLayout(roundPanel21Layout);
        roundPanel21Layout.setHorizontalGroup(
            roundPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel21Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(roundPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bar_2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addGap(64, 64, 64)
                .addGroup(roundPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bar_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );
        roundPanel21Layout.setVerticalGroup(
            roundPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel21Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(roundPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bar_1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(bar_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout roundPanel11Layout = new javax.swing.GroupLayout(roundPanel11);
        roundPanel11.setLayout(roundPanel11Layout);
        roundPanel11Layout.setHorizontalGroup(
            roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel11Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        roundPanel11Layout.setVerticalGroup(
            roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel11Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(15, 15, 15)
                .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(roundPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(roundPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("HUMIDITY DATA", jPanel5);

        jPanel7.setBackground(new java.awt.Color(242, 242, 242));
        jPanel7.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jPanel8.setLayout(new java.awt.BorderLayout());

        roundPanel22.setBackground(new java.awt.Color(242, 242, 242));

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("WATER LEVAL (%)");

        roundPanel23.setBackground(new java.awt.Color(255, 255, 255));

        panel_9.setBackground(new java.awt.Color(153, 153, 153));
        panel_9.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel23Layout = new javax.swing.GroupLayout(roundPanel23);
        roundPanel23.setLayout(roundPanel23Layout);
        roundPanel23Layout.setHorizontalGroup(
            roundPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_9, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel23Layout.setVerticalGroup(
            roundPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_9, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel24.setBackground(new java.awt.Color(255, 255, 255));

        panel_10.setBackground(new java.awt.Color(153, 153, 153));
        panel_10.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel24Layout = new javax.swing.GroupLayout(roundPanel24);
        roundPanel24.setLayout(roundPanel24Layout);
        roundPanel24Layout.setHorizontalGroup(
            roundPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel24Layout.setVerticalGroup(
            roundPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_10, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel25.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/history/20944465.jpg"))); // NOI18N

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("Date : 2022-10-22 At : 22.34 P.M");

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Max Temperature (f) : 110 F");

        jLabel29.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setText("Date : 2022-10-22 At : 22.34 P.M");

        jLabel30.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("Min Temperature (f) : 10 F");

        javax.swing.GroupLayout roundPanel25Layout = new javax.swing.GroupLayout(roundPanel25);
        roundPanel25.setLayout(roundPanel25Layout);
        roundPanel25Layout.setHorizontalGroup(
            roundPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundPanel25Layout.setVerticalGroup(
            roundPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(roundPanel25Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );

        roundPanel26.setBackground(new java.awt.Color(255, 255, 255));

        gaugeChart1.setColor1(new java.awt.Color(29, 142, 216));

        gaugeChart2.setColor1(new java.awt.Color(29, 142, 216));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("HIGHST WATER LEVEL TODAY RECORDED YET");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setText("LOWEST WATER LEVEL TODAY RECORDED YET");

        javax.swing.GroupLayout roundPanel26Layout = new javax.swing.GroupLayout(roundPanel26);
        roundPanel26.setLayout(roundPanel26Layout);
        roundPanel26Layout.setHorizontalGroup(
            roundPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gaugeChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addGap(27, 27, 27)
                .addGroup(roundPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(gaugeChart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        roundPanel26Layout.setVerticalGroup(
            roundPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel26Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gaugeChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gaugeChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel22Layout = new javax.swing.GroupLayout(roundPanel22);
        roundPanel22.setLayout(roundPanel22Layout);
        roundPanel22Layout.setHorizontalGroup(
            roundPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel22Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(roundPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        roundPanel22Layout.setVerticalGroup(
            roundPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel22Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addGap(15, 15, 15)
                .addGroup(roundPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1256, Short.MAX_VALUE))
            .addComponent(roundPanel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(roundPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("WATER LEVEL DATA", jPanel7);

        jPanel9.setBackground(new java.awt.Color(242, 242, 242));
        jPanel9.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jPanel10.setLayout(new java.awt.BorderLayout());

        roundPanel27.setBackground(new java.awt.Color(242, 242, 242));

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("SOIL MOISTURE LEVEL (%)");

        roundPanel28.setBackground(new java.awt.Color(255, 255, 255));

        panel_11.setBackground(new java.awt.Color(153, 153, 153));
        panel_11.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel28Layout = new javax.swing.GroupLayout(roundPanel28);
        roundPanel28.setLayout(roundPanel28Layout);
        roundPanel28Layout.setHorizontalGroup(
            roundPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_11, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel28Layout.setVerticalGroup(
            roundPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_11, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel29.setBackground(new java.awt.Color(255, 255, 255));

        panel_12.setBackground(new java.awt.Color(153, 153, 153));
        panel_12.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel29Layout = new javax.swing.GroupLayout(roundPanel29);
        roundPanel29.setLayout(roundPanel29Layout);
        roundPanel29Layout.setHorizontalGroup(
            roundPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel29Layout.setVerticalGroup(
            roundPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_12, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel30.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/history/20945180.jpg"))); // NOI18N

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("Date : 2022-10-22 At : 22.34 P.M");

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("Max Temperature (f) : 110 F");

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setText("Date : 2022-10-22 At : 22.34 P.M");

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 51, 51));
        jLabel36.setText("Min Temperature (f) : 10 F");

        javax.swing.GroupLayout roundPanel30Layout = new javax.swing.GroupLayout(roundPanel30);
        roundPanel30.setLayout(roundPanel30Layout);
        roundPanel30Layout.setHorizontalGroup(
            roundPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundPanel30Layout.setVerticalGroup(
            roundPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel30Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(roundPanel30Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );

        roundPanel31.setBackground(new java.awt.Color(255, 255, 255));

        liquidProgress.setBackground(new java.awt.Color(153, 219, 255));
        liquidProgress.setBorder(null);
        liquidProgress.setForeground(new java.awt.Color(42, 161, 233));
        liquidProgress.setValue(50);
        liquidProgress.setAnimateColor(new java.awt.Color(255, 255, 255));
        liquidProgress.setBorderColor(new java.awt.Color(255, 255, 255));
        liquidProgress.setBorderPainted(false);
        liquidProgress.setBorderSize(1);
        liquidProgress.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        liquidProgress.setSpaceSize(10);

        liquidProgress1.setBackground(new java.awt.Color(153, 219, 255));
        liquidProgress1.setBorder(null);
        liquidProgress1.setForeground(new java.awt.Color(51, 51, 51));
        liquidProgress1.setValue(50);
        liquidProgress1.setAnimateColor(new java.awt.Color(255, 255, 255));
        liquidProgress1.setBorderColor(new java.awt.Color(255, 255, 255));
        liquidProgress1.setBorderPainted(false);
        liquidProgress1.setBorderSize(1);
        liquidProgress1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        liquidProgress1.setSpaceSize(10);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setText("LOWEST SOIL MOISTURE TODAY ");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(102, 102, 102));
        jLabel42.setText("HIGHEST SOIL MOISTURE TODAY ");

        javax.swing.GroupLayout roundPanel31Layout = new javax.swing.GroupLayout(roundPanel31);
        roundPanel31.setLayout(roundPanel31Layout);
        roundPanel31Layout.setHorizontalGroup(
            roundPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel31Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(roundPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(liquidProgress1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addGap(75, 75, 75)
                .addGroup(roundPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(liquidProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        roundPanel31Layout.setVerticalGroup(
            roundPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(liquidProgress1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(liquidProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel27Layout = new javax.swing.GroupLayout(roundPanel27);
        roundPanel27.setLayout(roundPanel27Layout);
        roundPanel27Layout.setHorizontalGroup(
            roundPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel27Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(roundPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        roundPanel27Layout.setVerticalGroup(
            roundPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel27Layout.createSequentialGroup()
                .addComponent(jLabel31)
                .addGap(15, 15, 15)
                .addGroup(roundPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1256, Short.MAX_VALUE))
            .addComponent(roundPanel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(roundPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("SOIL MOISTURE DATA", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        tab.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained


    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost



    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static com.deshan.swing.progress.Progress bar_1;
    public static com.deshan.swing.progress.Progress bar_2;
    public static com.deshan.chart.ChartLine data;
    public static com.deshan.chart.ChartLine data1;
    public static com.deshan.chart.ChartLine data2;
    private chart.GaugeChart gaugeChart1;
    private chart.GaugeChart gaugeChart2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private swing.LiquidProgress liquidProgress;
    private swing.LiquidProgress liquidProgress1;
    private javax.swing.JTextArea pane;
    private javax.swing.JTextArea pane1;
    private javax.swing.JTextArea pane2;
    private javax.swing.JPanel panel_1;
    private javax.swing.JPanel panel_10;
    private javax.swing.JPanel panel_11;
    private javax.swing.JPanel panel_12;
    private javax.swing.JPanel panel_2;
    private javax.swing.JPanel panel_3;
    private javax.swing.JPanel panel_4;
    private javax.swing.JPanel panel_5;
    private javax.swing.JPanel panel_6;
    private javax.swing.JPanel panel_7;
    private javax.swing.JPanel panel_8;
    private javax.swing.JPanel panel_9;
    private com.deshan.swing.RoundPanel roundPanel10;
    private com.deshan.swing.RoundPanel roundPanel11;
    private com.deshan.swing.RoundPanel roundPanel12;
    private com.deshan.swing.RoundPanel roundPanel13;
    private com.deshan.swing.RoundPanel roundPanel14;
    private com.deshan.swing.RoundPanel roundPanel15;
    private com.deshan.swing.RoundPanel roundPanel16;
    private com.deshan.swing.RoundPanel roundPanel17;
    private com.deshan.swing.RoundPanel roundPanel18;
    private com.deshan.swing.RoundPanel roundPanel19;
    private com.deshan.swing.RoundPanel roundPanel2;
    private com.deshan.swing.RoundPanel roundPanel20;
    private com.deshan.swing.RoundPanel roundPanel21;
    private com.deshan.swing.RoundPanel roundPanel22;
    private com.deshan.swing.RoundPanel roundPanel23;
    private com.deshan.swing.RoundPanel roundPanel24;
    private com.deshan.swing.RoundPanel roundPanel25;
    private com.deshan.swing.RoundPanel roundPanel26;
    private com.deshan.swing.RoundPanel roundPanel27;
    private com.deshan.swing.RoundPanel roundPanel28;
    private com.deshan.swing.RoundPanel roundPanel29;
    private com.deshan.swing.RoundPanel roundPanel3;
    private com.deshan.swing.RoundPanel roundPanel30;
    private com.deshan.swing.RoundPanel roundPanel31;
    private com.deshan.swing.RoundPanel roundPanel4;
    private com.deshan.swing.RoundPanel roundPanel5;
    private com.deshan.swing.RoundPanel roundPanel6;
    private com.deshan.swing.RoundPanel roundPanel7;
    private com.deshan.swing.RoundPanel roundPanel8;
    private com.deshan.swing.RoundPanel roundPanel9;
    private tabbed.MaterialTabbed tab;
    // End of variables declaration//GEN-END:variables
}
