package com.atr.excelspringboot.exporter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atr.excelspringboot.model.Employee;
import com.atr.excelspringboot.service.EmployeeService;

@Service
public class ExcelFileExporterImpl implements ExcelFileExporter {

	@Autowired
	EmployeeService employeeService;

	@Override
	public ByteArrayInputStream exportAllEmployee() throws Exception {
		 
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("Employees info");

			Row row = sheet.createRow(0);
			
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			String[] columns = {"id","Firt Name","Last Name","Email"};
			
			// Creating Excel Header from the columns array
			for (int i = 0; i < columns.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(columns[i]);
				cell.setCellStyle(headerCellStyle);
			}
			
			// Creating Excel Header
		/*	Cell cell = row.createCell(0);
			cell.setCellValue("Employye Number");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(1);
			cell.setCellValue("Firt Name");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(2);
			cell.setCellValue("Last Name");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(3);
			cell.setCellValue("Email");
			cell.setCellStyle(headerCellStyle);*/

			// Creating data row for each Employy object
			
			List<Employee> employees = employeeService.getAllEmployees();
			
			for (int i = 0; i < employees.size(); i++) {
				Row dataRow = sheet.createRow(i + 1);// to exclude the header row
				dataRow.createCell(0).setCellValue(employees.get(i).getId());
				dataRow.createCell(1).setCellValue(employees.get(i).getFirst_name());
				dataRow.createCell(2).setCellValue(employees.get(i).getLast_name());
				dataRow.createCell(3).setCellValue(employees.get(i).getEmail());
			}

			// Auto size Excel cell for populated data
			for (int i = 0; i < columns.length; i++) {
				sheet.autoSizeColumn(i);
			}
			/*sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);*/
			
			System.out.println("************************"+employeeService.getAllEmployees());

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			workbook.write(outputStream);
			workbook.close();
			return new ByteArrayInputStream(outputStream.toByteArray());
			//outputStream.close();

	}

}
