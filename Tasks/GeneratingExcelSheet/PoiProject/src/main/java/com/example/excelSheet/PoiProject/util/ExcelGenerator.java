package com.example.excelSheet.PoiProject.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.excelSheet.PoiProject.model.Customer;

public class ExcelGenerator {

	public static ByteArrayInputStream customersToExcel(List<Customer> customers) throws Exception{
		
		String[] columns={"Id","Name","Address","Age"};
		
	    try(
	    	Workbook workbook=new XSSFWorkbook();
	    	ByteArrayOutputStream out=new ByteArrayOutputStream();
	    ){
	    	CreationHelper createHelper=workbook.getCreationHelper();
	    	Sheet sheet=workbook.createSheet("Customers");
	    	Font headerFont=workbook.createFont();
	    	headerFont.setBold(true);
              headerFont.setColor(IndexedColors.BLUE.getIndex());	    	
	    	CellStyle headerCellStyle=workbook.createCellStyle();
	    	headerCellStyle.setFont(headerFont);
              
	    	Row headerRow=sheet.createRow(0);
	    	
	    	for(int i=0;i<columns.length;i++){
	    	 Cell cell=	headerRow.createCell(i);
	    	   cell.setCellValue(columns[i]);
	    		cell.setCellStyle(headerCellStyle);
	    	}
	    	 CellStyle ageCellStyle = workbook.createCellStyle();
	         ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
	      
	         int rowIndex=1;
	         for(Customer customer:customers){
	        	 Row row=sheet.createRow(rowIndex++);
	        	 row.createCell(0).setCellValue(customer.getId());
	        	 row.createCell(1).setCellValue(customer.getName());
	        	 row.createCell(2).setCellValue(customer.getAddress());
	        	 Cell ageCell = row.createCell(3);
	             ageCell.setCellValue(customer.getAge());
	             ageCell.setCellStyle(ageCellStyle);
	         }
	         workbook.write(out);
	         return new ByteArrayInputStream(out.toByteArray());
	    }
	}
	
}
