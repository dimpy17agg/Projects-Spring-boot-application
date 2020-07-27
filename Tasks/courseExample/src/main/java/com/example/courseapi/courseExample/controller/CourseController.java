package com.example.courseapi.courseExample.controller;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.courseapi.courseExample.model.Course;
import com.example.courseapi.courseExample.service.CourseService;
import com.example.courseapi.courseExample.util.ExcelSheetGenerate;
import com.example.courseapi.courseExample.util.PdfGenerate;

@Controller
//@RequestMapping("/courses/details")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/download/ExcelSheet/course.xlsx")
	public ResponseEntity<InputStreamResource> courseExcel(){
		
		List<Course> courses=courseService.findCourses();
	       ByteArrayInputStream bis=ExcelSheetGenerate.excelSheetConvertor(courses);	
		HttpHeaders headers=new HttpHeaders();
		 headers.add("Content-Disposition", "attachment; filename=course.xlsx");
		 return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
	}
	
	@RequestMapping(value="/report/pdfReport",produces=MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> coursePdfReport(){
		List<Course> courseList=courseService.findCourses();
		 ByteArrayInputStream bis=PdfGenerate.pdfReport(courseList);
		 HttpHeaders headers=new HttpHeaders();
		 headers.add("Content-Disposition","inline;filename=courseReport.pdf");
           return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis));
		 
	}
}
