/**
 * 
 */
package com.ft42.tasklist.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ft42.tasklist.dao.TaskDownloadDao;
import com.ft42.tasklist.service.TaskDownloadService;
import com.ft42.tasklist.support.TaskDownloadRequest;
import com.ft42.tasklist.support.TaskUtil;

/**
 * <Description>
 * 
 * @author Somendu
 *
 * @Since 30-May-2020
 */
@Service
public class TaskDownloadServiceImpl implements TaskDownloadService {

	@Autowired
	private TaskDownloadDao taskDownloadDao;

	@Override
	public ByteArrayOutputStream downloadExcel(TaskDownloadRequest taskDownloadRequest)
			throws IOException, FileNotFoundException {

		Map<String, Object> taskDownloadMap = new HashMap<String, Object>();

		// Convert String to Date
		String taskDateFromString = taskDownloadRequest.getDateFrom();
		System.out.println(taskDateFromString);
		Date taskFromDate = TaskUtil.getDateToSQLDate(taskDateFromString);

		// Convert String to Date
		String taskDateToString = taskDownloadRequest.getDateTo();
		Date taskToDate = TaskUtil.getDateToSQLDate(taskDateToString);

		// TODO Take the range, name
		taskDownloadMap.put("dateFrom", taskFromDate);
		taskDownloadMap.put("dateTo", taskToDate);
		taskDownloadMap.put("consName", taskDownloadRequest.getConsName());

		// TODO Query Data
		List<Map<String, Object>> downloadMapList = taskDownloadDao.getDownloadDataList(taskDownloadMap);

		for (Map<String, Object> downloadMap : downloadMapList) {
			Timestamp sqlDate = (Timestamp) downloadMap.get("taskInputDate");
			String sqlDateString = TaskUtil.getSQLDateToDate(sqlDate);
			downloadMap.put("taskInputDate", sqlDateString);
		}

		// TODO Create Excel

		String sheetName = "TaskList";// name of sheet

		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet = workBook.createSheet(sheetName);
		// iterating r number of rows

		XSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("Date");

		row.createCell(1).setCellValue("Task List");
		row.createCell(2).setCellValue("Name");

		int rowNum = 1;

		String taskDate = "";

		for (Map<String, Object> downloadMap : downloadMapList) {

			XSSFRow nextRow = sheet.createRow(rowNum++);

			taskDate = (String) downloadMap.get("taskInputDate");

			nextRow.createCell(1).setCellValue((String) downloadMap.get("taskList"));
			nextRow.createCell(2).setCellValue((String) downloadMap.get("consName"));
		}

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		// write this workbook to an Outputstream.
		workBook.write(outputStream);

		outputStream.close();
		workBook.close();

		// TODO Return Excel

		return outputStream;
	}

}
