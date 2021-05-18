package com.whitetest.soap.data.services;

import java.util.GregorianCalendar;

import java.util.List;
import java.util.Optional;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Service;

import com.whitetest.soap.data.models.Exam;
import com.whitetest.soap.data.models.ExamsResponse;
import com.whitetest.soap.data.models.SingletonData;
import com.whitetest.soap.data.models.Student;
import com.whitetest.soap.data.models.StudentRequest;
import com.whitetest.soap.data.models.WhiteTestResponse;

@Service
public class WhiteTestService {
	
	
	public WhiteTestResponse checkWhiteTest(StudentRequest studentRequest) throws DatatypeConfigurationException {
		
		WhiteTestResponse whiteTestResponse=new WhiteTestResponse();
		List<Student> students=SingletonData.getStudent();
		List<Exam> exams=SingletonData.getExams();
		Optional<Student> student=students.stream()
				 				.filter((std) -> std.getId()==studentRequest.getStudentId())
				                .findFirst();
				                
		Optional<Exam> exam= exams.stream()
 						.filter((ex) -> ex.getCode().equals(studentRequest.getExamCode()))
 						.findFirst();
 	
		if(!student.isPresent()) {
			whiteTestResponse.setBadRequests("wrong student id");
		}else if(!exam.isPresent()) {
			whiteTestResponse.setBadRequests("wrong exam code");
		}else {
			whiteTestResponse.setExam(exam.get());
			whiteTestResponse.setStudent(student.get());
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
	        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
	        XMLGregorianCalendar date =datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
	        whiteTestResponse.setDate(date);
		}
			
		return whiteTestResponse;
				              
	}
	
	public ExamsResponse getAllWhiteTests()
	{
		ExamsResponse res= new ExamsResponse();
		res.setExams(SingletonData.getExams());
		return res;
				
	}
	


}
