package com.whitetest.soap.data.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.whitetest.soap.data.endpoints.WhiteTestEndPoint;


@EnableWs
@Configuration
public class WhiteTestConfig {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context)
	{
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		 return new ServletRegistrationBean<MessageDispatcherServlet>(servlet,"/tekup/*");
	}

	@Bean
	public XsdSchema schema()
	{
		return new SimpleXsdSchema(new ClassPathResource("whiteTest.xsd"));
	}
	
	@Bean(name="whiteTest")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema)
	{
		DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		defaultWsdl11Definition.setPortTypeName("WhiteTestCheck");
		defaultWsdl11Definition.setLocationUri("/tekup");
		
		defaultWsdl11Definition.setTargetNamespace(WhiteTestEndPoint.nameSpace);
		defaultWsdl11Definition.setSchema(schema);
		return defaultWsdl11Definition;
	}

}
