package com.example.practice.PracticePdfGnerator.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.*;

import com.example.practice.PracticePdfGnerator.model.Student;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class PdfGenerate {

	public static ByteArrayInputStream pdfConvertor(List<Student> st){
	
		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
	
	     try{
	    	 PdfPTable table=new PdfPTable(2);
	    	 table.setWidthPercentage(60);
	    	 Font headFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	    	 
	    	 PdfPCell hcell;
	            hcell = new PdfPCell(new Phrase("Id", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("Name", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);
	            
	            for(Student students:st){
	            	
	             PdfPCell cell;
	             cell = new PdfPCell(new Phrase(students.getId().toString()));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);

	                cell = new PdfPCell(new Phrase(students.getName()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(cell);
	             
	            }
	            PdfWriter.getInstance(document, out);
	            document.open();
	            document.add(table);

	            document.close();
	     }
	     
	     catch(Exception e){
	    	 
	     }
	     return new ByteArrayInputStream(out.toByteArray());
	}
	
	
	
}
