package com.json.netty.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MessageValidatorold implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("Exception Thrown");
		SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			format.parse((String) exchange.getProperty("timestamp"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CamelCustomException();
		}

	}
}
