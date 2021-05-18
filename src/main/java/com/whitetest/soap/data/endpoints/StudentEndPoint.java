package com.whitetest.soap.data.endpoints;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.whitetest.soap.data.models.StudentsResponse;
import com.whitetest.soap.data.services.StudentService;

@Endpoint
public class StudentEndPoint {
	
	public static final String nameSpace = "com/whitetest/soap/data/models";
	@Autowired
	StudentService service;
	
	
	@PayloadRoot(namespace = nameSpace, localPart = "StudentsRequest")
	@ResponsePayload
	public StudentsResponse getAllStudents()
	{
		return service.getAllStudents();
	}

}
