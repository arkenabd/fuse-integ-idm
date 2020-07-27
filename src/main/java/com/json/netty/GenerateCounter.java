package com.json.netty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.commons.lang3.StringUtils;

public class GenerateCounter {
	AtomicLong atomicLong = new AtomicLong();

	public void getSequence(String input, Exchange exchange) throws Exception {
		try {
//			Thread.sleep(10);
//			newCounter = newCounter + 1;
			exchange.setProperty("counter", atomicLong.incrementAndGet());
			String pattern = "yyyyMMddHHmmss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
//			System.out.println(date);
			String value = StringUtils.rightPad(date, 14, " ")
					+ StringUtils.leftPad(String.valueOf(atomicLong.get()), 6, "0");
			exchange.setProperty("transId", value);
			System.out.println("[" + exchange.getProperty("transId") + "] Trans ID : " + value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void resetSequence(String input, Exchange exchange) throws Exception {

		atomicLong.set(0);

	}

}
