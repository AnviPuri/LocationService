package com.location.util;

import java.util.List;

/**
 * @author Anvi Puri
 *
 */
public interface ReportUtil {

	/**
	 * @param path takes the path where the jpeg is to be stored
	 * @param data
	 */
	public void generatePieChart(String path, List<Object[]> data);

}
