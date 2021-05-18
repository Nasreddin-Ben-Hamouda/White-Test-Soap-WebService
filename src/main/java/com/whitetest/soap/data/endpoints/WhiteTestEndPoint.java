package com.whitetest.soap.data.endpoints;

import javax.xml.datatype.DatatypeConfigurationException;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.whitetest.soap.data.models.ExamsResponse;
import com.whitetest.soap.data.models.StudentRequest;
import com.whitetest.soap.data.models.WhiteTestResponse;
import com.whitetest.soap.data.services.WhiteTestService;

@Endpoint
public class WhiteTestEndPoint {
	public static final String nameSpace = "com/whitetest/soap/data/models";
	
	@Autowired
	private WhiteTestService service;

	@PayloadRoot(namespace = nameSpace, localPart = "StudentRequest")
	@ResponsePayload
	public WhiteTestResponse getWhiteTest(@RequestPayload StudentRequest studentRequest) throws DatatypeConfigurationException
	{

		return service.checkWhiteTest(studentRequest);
	
	}
	
	@PayloadRoot(namespace = nameSpace, localPart = "ExamsRequest")
	@ResponsePayload
	public ExamsResponse getAllWhiteTests() throws DatatypeConfigurationException
	{
		return service.getAllWhiteTests();
	}
}
