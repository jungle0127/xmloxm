package com.ps.xml.oxm.xstream;

import java.util.Date;
import java.util.Locale;

import com.ps.xml.oxm.dto.UserDto;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class XStreamParser {
	private XStream xstream;
	public XStreamParser() {		
		this.xstream = new XStream(new Dom4JDriver());
		this.xstream.alias("user", UserDto.class);
		this.xstream.registerConverter(new DateConverter(Locale.CHINA));
	}
	public String object2Xml() {
		UserDto pojo = new UserDto();
		pojo.setId(1);
		pojo.setGender(0);
		pojo.setUserName("ps");
		pojo.setBirthDay(new Date());
		return this.xstream.toXML(pojo);
	}
	public UserDto xml2Object(String xml) {
		return (UserDto)this.xstream.fromXML(xml);
	}
}
