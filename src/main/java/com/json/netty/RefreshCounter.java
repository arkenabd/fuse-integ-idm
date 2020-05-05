package com.json.netty;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.properties.PropertiesComponent;

public class RefreshCounter implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		PropertiesComponent pc = exchange.getContext().getComponent("properties", PropertiesComponent.class);
	
		pc.setLocation("classpath:application.properties");
		pc.setCache(false);
		java.util.Properties properties = new java.util.Properties();
		
		properties.setProperty("test", "0");
		System.out.println("new : " + properties.getProperty("test"));
		pc.setOverrideProperties(properties);

	}

}
