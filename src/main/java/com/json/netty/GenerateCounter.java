package com.json.netty;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.properties.PropertiesComponent;

public class GenerateCounter {
	public int newCounter = 0;

	public int getSequence(String input,Exchange exchange) throws Exception {

		newCounter = newCounter + 1;
		return newCounter;

	}
	
	public int resetSequence(String input,Exchange exchange) throws Exception {

		newCounter = 1;
		return newCounter;

	}

}
