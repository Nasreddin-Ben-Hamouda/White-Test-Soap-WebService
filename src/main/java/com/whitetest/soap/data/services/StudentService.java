package com.whitetest.soap.data.services;

import org.springframework.stereotype.Service;

import com.whitetest.soap.data.models.SingletonData;
import com.whitetest.soap.data.models.StudentsResponse;

@Service
public class StudentService {
	
	public StudentsResponse getAllStudents()
	{
		StudentsResponse res= new StudentsResponse();
		res.setStudents(SingletonData.getStudents());
		return res;
				
	}
}
