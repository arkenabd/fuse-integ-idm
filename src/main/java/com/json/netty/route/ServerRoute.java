package com.json.netty.route;

import javax.xml.bind.JAXBContext;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.json.netty.Application;
import com.json.netty.util.Ops;
import com.json.netty.util.ResponseType;
import com.json.netty.util.JsonReq;

@Component
public class ServerRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		JAXBContext jaxbContext = JAXBContext.newInstance(Ops.class);
		JaxbDataFormat eventDataFormat = new JaxbDataFormat(jaxbContext);

		restConfiguration().apiContextPath("/openapi.json").component("restlet").contextPath("/hanabank").port("7070")
				.scheme("http").apiProperty("api.title", "Hana Bank - Registration").apiProperty("api.version", "1")
				.apiProperty("api.specification.contentType.json", "application/vnd.oai.openapi+json;version=2.0")
				.apiProperty("api.specification.contentType.yaml", "application/vnd.oai.openapi;version2.0");

		rest().path("/hello").get().route().transform().constant("Hello World").marshal().json(JsonLibrary.Gson,
				ResponseType.class);

		rest().path("/reg").post().consumes("application/json")
		.type(JsonReq.class).to("direct:appCreated");

		from("direct:appCreated")
				.log("Body : (${body})")
				.bean("generateFixLengthReq", "generate(${body})")
				// assign value to a POJO
				.log("Body after generateFixLengthReq : (${body})")
				.bean("tcpClient", "call(${body})")
				//.bean("postBean", "setValue(${body.getId},${body.getName})")
				// marshall for generating json as return based on a POJO
				// .marshal().json(JsonLibrary.Gson, UserPojo.class)
				.log("Final Body : ${body}");
	}

}
