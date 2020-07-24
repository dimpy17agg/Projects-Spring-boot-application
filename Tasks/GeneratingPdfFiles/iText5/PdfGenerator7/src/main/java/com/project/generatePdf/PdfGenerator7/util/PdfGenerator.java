package com.project.generatePdf.PdfGenerator7.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.*;
import java.util.stream.Stream;

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
import com.project.generatePdf.PdfGenerator7.model.*;
public class PdfGenerator {

	public static ByteArrayInputStream employeePdfReport(List<Employee> emp){
		Document document=new Document();
	  ByteArrayOutputStream out=new ByteArrayOutputStream();

	  try{
		  PdfWriter.getInstance(document, out);
		  document.open();
		  Font font=FontFactory.getFont(FontFactory.COURIER,14,BaseColor.BLACK);
		  Paragraph para=new Paragraph("Employee",font);
		  para.setAlignment(Element.ALIGN_CENTER);
		  document.add(para);
		  document.add(Chunk.NEWLINE);
		  
		  PdfPTable table=new PdfPTable(3);
		  Stream.of("Id","Name","Designation").forEach(headerTitle->{
			PdfPCell header=new PdfPCell();  
              Font headFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
              header.setBackgroundColor(BaseColor.LIGHT_GRAY);
              header.setHorizontalAlignment(Element.ALIGN_CENTER);
              header.setBorderWidth(2);
              header.setPhrase(new Phrase(headerTitle,headFont));
              table.addCell(header);
		  });
			  
		  for(Employee employee: emp){
			  PdfPCell idCell=new PdfPCell(new Phrase(employee.getId().toString()));
			  idCell.setPaddingLeft(4);
			  idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		       idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		      table.addCell(idCell);
		      
		      
		      PdfPCell nameCell=new PdfPCell(new Phrase(employee.getName()));
		      nameCell.setPaddingLeft(4);
		      nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		      nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		      table.addCell(nameCell);
		      
		      PdfPCell desCell=new PdfPCell(new Phrase(employee.getDesignation()));
		      desCell.setPaddingLeft(4);
		      desCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		      desCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		      table.addCell(desCell);
		      
		  }
	     document.add(table);
	     document.close();
	  }
	  
	  catch(Exception e){
		  System.out.println(e);
	  }
	  return new ByteArrayInputStream(out.toByteArray());	
	}
}
