package com.ps.xml.oxm.jaxb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Component;

@Component
public class MarshalAndUnmarshalService {
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	
	public Marshaller getMarshaller() {
		return marshaller;
	}
	@Autowired
	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}
	public Unmarshaller getUnmarshaller() {
		return unmarshaller;
	}
	@Autowired
	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}
	
	
}
