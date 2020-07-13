package com.json.netty;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.commons.lang3.StringUtils;

public class GenerateCounter {
	public int newCounter = 0;

	public void getSequence(String input, Exchange exchange) throws Exception {
		newCounter = newCounter + 1;
		exchange.setProperty("counter", newCounter);
		String pattern = "yyyyMMddHHmmss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		String value = StringUtils.rightPad(date, 14, " ") + StringUtils.leftPad(String.valueOf(newCounter), 6, "0");
		exchange.setProperty("transId", value);
	}

	public void resetSequence(String input, Exchange exchange) throws Exception {

		newCounter = 0;

	}

}
