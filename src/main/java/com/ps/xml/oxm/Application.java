package com.ps.xml.oxm;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.oxm.XmlMappingException;

import com.ps.xml.oxm.dto.UserDto;
import com.ps.xml.oxm.jaxb.configuration.SpringConfigure;
import com.ps.xml.oxm.jaxb.dto.Student;
import com.ps.xml.oxm.jaxb.dto.Teacher;
import com.ps.xml.oxm.jaxb.service.MarshalAndUnmarshalService;
import com.ps.xml.oxm.xstream.XStreamParser;

public class Application {
	public static void main(String[] args) throws XmlMappingException, IOException {
		XStreamParser xsp = new XStreamParser();
		String objXml = xsp.object2Xml();
		System.out.println(objXml);
		UserDto pojo = xsp.xml2Object(objXml);
		System.out.println(ReflectionToStringBuilder.toString(pojo));
		System.out.println("======================================");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfigure.class);
		File teacherFile = new File("teacher.xml");
		File studentFile = new File("student.xml");
		Student student = new Student();
		student.setId(2112);
		student.setName("ps");
		Teacher teacher = new Teacher();
		teacher.setName("arbor");
		
		MarshalAndUnmarshalService service = applicationContext.getBean(MarshalAndUnmarshalService.class);
		service.getMarshaller().marshal(student, new StreamResult(studentFile));
		service.getMarshaller().marshal(teacher, new StreamResult(teacherFile));
		
		student = (Student)service.getUnmarshaller().unmarshal(new StreamSource(studentFile));
		teacher = (Teacher)service.getUnmarshaller().unmarshal(new StreamSource(teacherFile));
		
		System.out.println(ReflectionToStringBuilder.toString(teacher));
		System.out.println(ReflectionToStringBuilder.toString(student));
	}
}
