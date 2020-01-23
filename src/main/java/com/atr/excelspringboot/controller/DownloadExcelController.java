package com.atr.excelspringboot.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.atr.excelspringboot.exporter.ExcelFileExporter;

@Controller
public class DownloadExcelController {
	
	@Autowired
	ExcelFileExporter excelFileExporter;
	
	@GetMapping("/download/employees.xlsx")
	public void downloadWxcelFile(HttpServletResponse response) throws IOException {
		response.setContentType("application/octel-stream");
		response.setHeader("Contenet-Disposition", "attachment; filename=employee.xlsx");
		System.out.println("---------------------------");
		ByteArrayInputStream inputStream = excelFileExporter.exportAllEmployee();
		IOUtils.copy(inputStream, response.getOutputStream());
		
		
	}
}
