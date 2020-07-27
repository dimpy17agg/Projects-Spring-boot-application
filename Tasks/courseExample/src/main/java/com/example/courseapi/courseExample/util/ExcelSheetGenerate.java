package com.example.courseapi.courseExample.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
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
import com.example.courseapi.courseExample.model.*;

public class ExcelSheetGenerate {

	public static ByteArrayInputStream excelSheetConvertor(List<Course> courseList){
		String[] columns={"courseId","Name","Description"};
		Workbook workbook=new XSSFWorkbook();
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		try{
			
			
			CreationHelper creatHelper=workbook.getCreationHelper();
			
			Sheet sheet=workbook.createSheet("CoursesDetails");
			Font headerFont=workbook.createFont();
	    	headerFont.setBold(true);
              headerFont.setColor(IndexedColors.RED.getIndex());	    	
	    	CellStyle headerCellStyle=workbook.createCellStyle();
	    	headerCellStyle.setFont(headerFont);
              
	    	Row headerRow=sheet.createRow(0);
	    	for(int i=0;i<columns.length;i++){
		    	 Cell cell=	headerRow.createCell(i);
		    	   cell.setCellValue(columns[i]);
		    		cell.setCellStyle(headerCellStyle);
		    	}
	    	 int rowIndex=1;
	         for(Course course:courseList){
	        	 Row row=sheet.createRow(rowIndex++);
	        	 row.createCell(0).setCellValue(course.getCourseId());
	        	 row.createCell(1).setCellValue(course.getName());
	        	 row.createCell(2).setCellValue(course.getDescription());
	  	         }
	         workbook.write(out);
		}
		
		catch(Exception e){
			System.out.print(e);
		}
		 return new ByteArrayInputStream(out.toByteArray());	
	}

	
}
