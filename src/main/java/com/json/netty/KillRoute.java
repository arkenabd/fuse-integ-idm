package com.json.netty;

import java.util.concurrent.TimeUnit;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ShutdownRunningTask;
import org.apache.camel.management.event.ExchangeFailureHandlingEvent;

public class KillRoute implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String id = exchange.getFromRouteId();
		System.out.println("routeId to be killed:" + id);
		if (exchange.getContext().getRoute(id) != null) {
			System.out.println("Start Gracefully removing route " + id);
			try {
//				exchange.getContext().getInflightRepository().remove(exchange);
				exchange.getContext().setShutdownRunningTask(ShutdownRunningTask.CompleteCurrentTaskOnly);
				/*
				 * exchange.getContext().stopRoute(id, 1, TimeUnit.MILLISECONDS); //
				 * exchange.getContext().removeRoute(id); exchange.getContext().startRoute(id);
				 */
				System.out.println("End Gracefully removing route " + id);
			} catch (Exception e) {
				System.out.println("Failed to remove route: " + id + "," + e.getMessage());
			}
		}

	}

}
