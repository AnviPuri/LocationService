package com.location.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ReportUtilImpl implements ReportUtil {

	@Override
	public void generatePieChart(String path, List<Object[]> data) {

		DefaultPieDataset dataset = new DefaultPieDataset();
		data.stream().forEach(object -> {
			dataset.setValue(object[0].toString(),(Number) object[1]);
			System.out.println(object[0] + " " + object[1]);
		});
		JFreeChart chart = ChartFactory.createPieChart3D("Location Type Report", dataset, false, false, null);
		try {
			ChartUtilities.saveChartAsJPEG(new File(path + "/pieChart.jpeg"), chart, 300, 300);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
