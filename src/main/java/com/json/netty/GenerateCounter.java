package com.json.netty;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.properties.PropertiesComponent;

public class GenerateCounter {

	public int process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		PropertiesComponent pc = exchange.getContext().getComponent("properties", PropertiesComponent.class);
		int existingCounter = Integer.parseInt(exchange.getProperty("counter").toString());
		pc.setLocation("classpath:application.properties");
		pc.setCache(false);
		java.util.Properties properties = new java.util.Properties();
		System.out.println("before :" + existingCounter);
		int newCounter = existingCounter + 1;
		properties.setProperty("test", String.valueOf(newCounter));
		System.out.println("new : " + properties.getProperty("test"));
		exchange.setProperty("counter", properties.getProperty("test"));
		pc.setOverrideProperties(properties);
		return newCounter;

	}

}
