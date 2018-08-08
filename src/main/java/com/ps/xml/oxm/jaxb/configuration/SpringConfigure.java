package com.ps.xml.oxm.jaxb.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.Marshaller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.ps.xml.oxm.jaxb.dto.Student;
import com.ps.xml.oxm.jaxb.dto.Teacher;
import com.ps.xml.oxm.jaxb.service.MarshalAndUnmarshalService;

@Configuration
public class SpringConfigure {
	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		Map<String,Object> properties = new HashMap<>();
		properties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setClassesToBeBound(Student.class,Teacher.class);
		marshaller.setMarshallerProperties(properties);
		return marshaller;
	}
	@Bean
	public MarshalAndUnmarshalService marshalAndUnmarshalService() {
		return new MarshalAndUnmarshalService();
	}
}
