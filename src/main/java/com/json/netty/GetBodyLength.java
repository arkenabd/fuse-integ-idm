package com.json.netty;

import java.nio.charset.StandardCharsets;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class GetBodyLength implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		String body = "";
		try {
			body = (String) exchange.getIn().getBody().toString();
			System.out.println("Response ORI from HLI :" + body);
			if (body.length() != 189 && body.length() != 74) {
				exchange.getIn().setBody("ERROR");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int bodyLength = body.length();
		bodyLength = bodyLength;
		exchange.setProperty("bodyLength", bodyLength);
	}

}
