package com.json.netty.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MessageValidator {

	public void process(String timestamp, String trxtype, String validTrx, Exchange exchange) throws Exception {
		ArrayList<String> errorList = new ArrayList<String>();
		Boolean isError = false;
		// validasi transaction type
		if (!trxtype.toUpperCase().equals(validTrx)) {
			isError = true;
			if (errorList.size() == 0) {
				errorList.add("Transaction Type " + trxtype + " is doesnt match with endpoint url : /" + validTrx);
			} else {
				errorList.add(";Transaction Type " + trxtype + " is doesnt match with endpoint url : /" + validTrx);
			}

		}

		// validasi timestamp
		SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			format.parse(timestamp);
		} catch (ParseException e) {
			isError = true;
			if (errorList.size() == 0) {
				errorList.add("Timestamp " + timestamp + " is not valid");
			} else {
				errorList.add(";Timestamp " + timestamp + " is not valid");
			}

		}
		if (isError == true) {
			String errMsg = "";
			for (int i = 0; i < errorList.size(); i++) {
				errMsg = errMsg + errorList.get(i);
			}
			throw new MessageErrorException(errMsg);
		}
	}
}
