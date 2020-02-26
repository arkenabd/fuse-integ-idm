package com.json.netty;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class GenerateFixLengthReq {
	public String randomNumeric(int n) {
		return RandomStringUtils.randomNumeric(n);
	}

	public String randomAlphabetic(int n) {
		return RandomStringUtils.randomAlphabetic(n);
	}

	public String randomAlphanumeric(int n) {
		return RandomStringUtils.randomAlphanumeric(n);
	}

	public String generate(String desc, String ops) throws ISOException {
		System.out.println("INSIDE METHOD GENERATE FL - REQ ");

		String component1 = StringUtils.rightPad(randomAlphabetic(10).toUpperCase(), 10, " ");
		String component2 = StringUtils.rightPad(randomNumeric(31), 31, " ");
		String component3 = StringUtils.rightPad("XXX", 3, " ");
		String component4 = StringUtils.rightPad(randomNumeric(32), 34, " ");
		String component5 = StringUtils
				.rightPad(randomAlphanumeric(12) + "-" + randomAlphanumeric(4) + "-" + randomAlphanumeric(4), 42, " ");
		String component6 = StringUtils.rightPad(randomAlphabetic(3).toUpperCase(), 3, " ");
		String component7 = StringUtils.rightPad(randomAlphanumeric(12) + "-1DF3-11E9-8A54-" + randomAlphanumeric(12),
				57, " ");
		String component8 = StringUtils.rightPad(desc, 100, " ");
		String component9 = StringUtils.rightPad(ops, 15, " ");
		String component10 = StringUtils.rightPad("@@", 2, " ");

		StringBuilder str = new StringBuilder(component1);
		str.append(component2);
		str.append(component3);
		str.append(component4);
		str.append(component5);
		str.append(component6);
		str.append(component7);
		str.append(component8);
		str.append(component9);
		str.append(component10);

		return str.toString();
	}

}