package com.atr.excelspringboot.controller;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.atr.excelspringboot.exporter.ExcelFileExporter;

@Controller
public class DownloadExcelController {
	
	@Autowired
	ExcelFileExporter excelFileExporter;
	
	@GetMapping("/download/employees.xlsx")
	public void downloadWxcelFile(HttpServletResponse response) {
		response.setContentType("application/octel-stream");
		response.setHeader("Contenet-Disposition", "attachment; filename=employee.xlsx");
		//IOU
		excelFileExporter.exportAllEmployee();
		
		
	}
}
