package com.example.courseapi.courseExample.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.example.courseapi.courseExample.model.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
public class PdfGenerate {

	public static ByteArrayInputStream pdfReport(List<Course> courseList){
		
		Document document=new Document();
		  ByteArrayOutputStream out=new ByteArrayOutputStream();
		try{
			
		PdfWriter.getInstance(document, out);
		document.open();
		Font font=FontFactory.getFont(FontFactory.HELVETICA_BOLD,14,BaseColor.BLUE);
		  Paragraph para=new Paragraph("Courses",font);
		  para.setAlignment(Element.ALIGN_CENTER);
		  document.add(para);
		  document.add(Chunk.NEWLINE);
		  	
		  PdfPTable table=new PdfPTable(3);
		  Stream.of("CourseId","Name","Description").forEach(headerTitle->{
			PdfPCell header=new PdfPCell();  
              Font headFont=FontFactory.getFont(FontFactory.COURIER_BOLD);
              header.setBackgroundColor(BaseColor.LIGHT_GRAY);
              header.setHorizontalAlignment(Element.ALIGN_CENTER);
              header.setBorderWidth(2);
              header.setPhrase(new Phrase(headerTitle,headFont));
              table.addCell(header);
		  });
			
		  for(Course course: courseList){
			  PdfPCell idCell=new PdfPCell(new Phrase(course.getCourseId()));
		       idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		      table.addCell(idCell);
		      
		      PdfPCell nameCell=new PdfPCell(new Phrase(course.getName()));
		      nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		      table.addCell(nameCell);
		      
		      PdfPCell desCell=new PdfPCell(new Phrase(course.getDescription()));
		      desCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		      table.addCell(desCell);
		  }
		  document.add(table);
		     document.close();
		}
		catch(Exception e){
			System.out.print(e);
		}
		
		return new ByteArrayInputStream(out.toByteArray());	
			
	}
	
	
	
	
}
