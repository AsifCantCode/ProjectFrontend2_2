package com.example.projectfrontend2_2;


import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class AttendanceChart {
    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private CategoryAxis x;

    @FXML
    private CategoryAxis y;
    public void initialize(URL url, ResourceBundle resourceBundle){
        XYChart.Series series1 = new XYChart.Series<>();
        series1.setName("2003");

        series1.getData().add(new XYChart.Data("Austria", 2323));
        series1.getData().add(new XYChart.Data("Australia", 4423));
        series1.getData().add(new XYChart.Data("France", 59992));
        series1.getData().add(new XYChart.Data("Bangladesh", 23433));
        series1.getData().add(new XYChart.Data("India", 10000));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");

        series2.getData().add(new XYChart.Data("Austria", 23233));
        series2.getData().add(new XYChart.Data("Australia", 44233));
        series2.getData().add(new XYChart.Data("France", 599292));
        series2.getData().add(new XYChart.Data("Bangladesh", 234333));
        series2.getData().add(new XYChart.Data("India", 120000));

        barChart.getData().addAll(series1);
    }
}
