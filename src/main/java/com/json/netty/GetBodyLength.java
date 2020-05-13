package com.json.netty;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class GetBodyLength implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		String body = (String) exchange.getIn().getBody();
		int bodyLength = body.length();
		bodyLength = bodyLength - 1;
		exchange.setProperty("bodyLength", bodyLength);
	}

}
