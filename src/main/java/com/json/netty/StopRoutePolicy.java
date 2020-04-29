package com.json.netty;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Route;
import org.apache.camel.support.RoutePolicySupport;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

public class StopRoutePolicy extends RoutePolicySupport {

 

  @Override
  public void onExchangeBegin(Route route, Exchange exchange) {
    String stop = "tcp.input";
    CamelContext context = exchange.getContext();
    if (context.getRouteStatus(stop) != null && context.getRouteStatus(stop).isStarted()) {
      try {
        exchange.getContext().getInflightRepository().remove(exchange);
        System.out.println("STOP ROUTE: {}");
        context.stopRoute(stop);
      } catch (Exception e) {
        getExceptionHandler().handleException(e);
      }
    }
  }

  @Override
  public void onExchangeDone(Route route, Exchange exchange) {
    String stop = "tcp.input";
    CamelContext context = exchange.getContext();
    if (context.getRouteStatus(stop) != null && context.getRouteStatus(stop).isStopped()) {
      try {
    	  System.out.println("RESTART ROUTE: {}");
        context.startRoute(stop);
      } catch (Exception e) {
        getExceptionHandler().handleException(e);
      }
    }
  }
}