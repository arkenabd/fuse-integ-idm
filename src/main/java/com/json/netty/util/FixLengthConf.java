package com.json.netty.util;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class FixLengthConf {

	public List<FixLengthMessageIn> getConf() {

		List<FixLengthMessageIn> flconf = new ArrayList<FixLengthMessageIn>();
		Resource resource = new ClassPathResource("classpath:FixLengthConfig.xml");
//        InputStream inputStream = resource.getInputStream();
//        try {
//            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
//            String data = new String(bdata, StandardCharsets.UTF_8);
//            LOGGER.info(data);
//        } catch (IOException e) {
//            LOGGER.error("IOException", e);
//        }
		try {

//			File fXmlFile = new File("src/main/resources/FixLengthConfig.xml");
			// File fXmlFile = resource.getFile();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			// Document doc = dBuilder.parse(fXmlFile);
			Document doc = readXml(resource.getInputStream());
			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("field");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

//				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
//
//					System.out.println("Field name : " + eElement.getAttribute("name"));
//					System.out.println("start : " + eElement.getElementsByTagName("start").item(0).getTextContent());
//					System.out.println("end : " + eElement.getElementsByTagName("end").item(0).getTextContent());
					flconf.add(new FixLengthMessageIn(eElement.getAttribute("name").toString(),
							eElement.getElementsByTagName("start").item(0).getTextContent().toString(),
							eElement.getElementsByTagName("end").item(0).getTextContent().toString(), ""));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flconf;
	}

	public static Document readXml(InputStream is) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		dbf.setValidating(false);
		dbf.setIgnoringComments(false);
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setNamespaceAware(true);
		// dbf.setCoalescing(true);
		// dbf.setExpandEntityReferences(true);

		DocumentBuilder db = null;
		db = dbf.newDocumentBuilder();
		db.setEntityResolver(new NullResolver());

		// db.setErrorHandler( new MyErrorHandler());

		return db.parse(is);
	}
}

class NullResolver implements EntityResolver {
	public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
		return new InputSource(new StringReader(""));
	}
}