package com.atr.excelspringboot.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.atr.excelspringboot.exporter.ExcelFileExporter;
import com.atr.excelspringboot.service.CreateDocument;

@Controller
public class DownloadExcelController {
	
	@Autowired
	ExcelFileExporter excelFileExporter;
	
	@GetMapping("/download/employees.xlsx")
	public void downloadExcelFile(HttpServletResponse response) throws Exception {
		response.setContentType("application/octel-stream");
		response.setHeader("Contenet-Disposition", "attachment; filename=employee.xlsx");
		System.out.println("---------------------------");
		ByteArrayInputStream inputStream = excelFileExporter.exportAllEmployee();
		IOUtils.copy(inputStream, response.getOutputStream());

		
	}
	
	@GetMapping("/download/persons.xlsx")
	public ResponseEntity<InputStreamResource> downloadExcelFile2() throws Exception{
		ByteArrayInputStream inputStream = excelFileExporter.exportAllEmployee();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Contenet-Disposition", "attachment; filename=persons.xlsx");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(inputStream));
	}
	
	@Autowired
	CreateDocument worddoc;
	
	@GetMapping("/download/employees.docx")
	public void downloadWordFile(HttpServletResponse response) throws IOException {
		worddoc.newDocument();
		
		
	}
}
