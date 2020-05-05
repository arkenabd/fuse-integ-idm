package com.json.netty.util;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.restlet.RestletConstants;
import org.restlet.Response;
import org.restlet.data.Status;

public class GeneralError implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Response response = exchange.getIn().getHeader(RestletConstants.RESTLET_RESPONSE, Response.class);
		response.setStatus(Status.SERVER_ERROR_INTERNAL);
		exchange.getIn().setHeader(RestletConstants.RESTLET_RESPONSE, response);

	}

}
