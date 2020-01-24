## Spring Boot Maven Project work with Excel sheet using POI library

Apache POI library supports both .xls and .xlsx files and is a more complex library than other Java libraries for working with Excel files.

It provides the Workbook interface for modeling an Excel file, and the Sheet, Row, and Cell interfaces that model the elements of an Excel file, as well as implementations of each interface for both file formats.

When working with the newer .xlsx file format, you would use the XSSFWorkbook, XSSFSheet, XSSFRow, and XSSFCell classes.

To work with the older .xls format, use the HSSFWorkbook, HSSFSheet, HSSFRow, and HSSFCell classes.

## Basic Interfaces
To start working with the POI API, we should learn about the following interfaces from package org.apache.poi.ss.usermodel:

### Workbook:
 This interface is the high-level representation of an Excel workbook. XSSFWorkbook and SXSSFWorkbook are the concrete implementations we will work with.
### Sheet: 
This interface is the high-level representation of an Excel worksheet. XSSFSheet and SXSSFSheet are the concrete implementations we will work with.
### Row:
 This interface is the high-level representation of a row of an Excel worksheet. XSSFRow and SXSSFRow are the concrete implementations we will work with.
### Cell:
 This interface is the high-level representation of a cell in a row of an Excel worksheet. XSSFCell and SXSSFCell are the concrete implementations we will work with.
### CellStyle:
 This interface is the high-level representation of the styling or formatting information for the cells on an Excel worksheet. XSSFCellStyle is the concrete implementation we will work with.

## Various APIs
We can use the POI library for reading and writing Excel files in several ways:

User API (XSSF)
Streaming User API (SXSSF)
Event API (XSSF with SAX)


### Accessing H2 console
Start the spring boot application and access the console in browser with URL : http://localhost:8080/h2."# Excel-SpringBoot" 
