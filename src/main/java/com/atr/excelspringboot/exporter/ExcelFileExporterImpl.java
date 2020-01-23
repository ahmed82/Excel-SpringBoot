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
	public ByteArrayInputStream exportAllEmployee() {
		try {
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet();

			Row row = sheet.createRow(0);
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			List<Employee> employees = employeeService.getAllEmployees();
			// Creating Excel Header
			Cell cell = row.createCell(0);
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
			cell.setCellStyle(headerCellStyle);

			// Creating data row for each Employy object
			for (int i = 0; i < employees.size(); i++) {
				Row dataRow = sheet.createRow(i + 1);
				dataRow.createCell(0).setCellValue(employees.get(i).getId());
				dataRow.createCell(1).setCellValue(employees.get(i).getFirst_name());
				dataRow.createCell(1).setCellValue(employees.get(i).getLast_name());
				dataRow.createCell(1).setCellValue(employees.get(i).getEmail());
			}

			// Auto size Excel cell for populated data
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			workbook.write(outputStream);
			
			return new ByteArrayInputStream(outputStream.toByteArray());
			//outputStream.close();
	       // workbook.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		

		//return null;
	}

}
