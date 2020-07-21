package com.json.netty;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class GetResponseHli implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String url = (String) exchange.getProperty("fileRespPay");

		ConsumerTemplate template = exchange.getContext().createConsumerTemplate();
		Exchange fileExchange = template.receive(url, 29000);
		exchange.getOut().setBody(fileExchange.getIn().getBody());
		System.out.println("Get message from callback :" + fileExchange.getIn().getBody());
		template.doneUoW(fileExchange);
	}
}