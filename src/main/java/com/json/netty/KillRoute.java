package com.json.netty;

import java.util.concurrent.TimeUnit;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ShutdownRunningTask;
import org.apache.camel.component.restlet.RestletConstants;
import org.apache.camel.management.event.ExchangeFailureHandlingEvent;
import org.apache.camel.spi.ShutdownStrategy;

import com.sun.research.ws.wadl.Request;

public class KillRoute implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		ShutdownStrategy shutdownStrategy = exchange.getContext().getShutdownStrategy();
		shutdownStrategy.setTimeout(1000);
		shutdownStrategy.setTimeUnit(TimeUnit.MILLISECONDS);
		shutdownStrategy.setShutdownNowOnTimeout(true);

		System.out.println("Request Headers :" + exchange.getIn().getHeaders().toString());
	}

}
