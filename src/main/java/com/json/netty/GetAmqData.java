package com.json.netty;

import java.util.Enumeration;
import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.jms.Connection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.jms.JmsException;

public class GetAmqData {

	public String process(String amqaddress, String amqport, String amquser, String amqpass, String queuename,
			String timeout, Exchange exchange) throws Exception {
		/*
		 * String url = (String) exchange.getProperty("fileRespPay");
		 * 
		 * ConsumerTemplate template = exchange.getContext().createConsumerTemplate();
		 * Exchange fileExchange = template.receive(url, 29000);
		 * exchange.getOut().setBody(fileExchange.getIn().getBody());
		 * System.out.println("Get message from callback :" +
		 * fileExchange.getIn().getBody()); template.doneUoW(fileExchange);
		 */

		/*
		 * Connection connection = null; InitialContext initialContext = null; Session
		 * session = null; try { // Step 1. Create an initial context to perform the
		 * JNDI lookup. Properties p = new Properties();
		 * p.put("java.naming.factory.initial",
		 * "org.apache.activemq.artemis.jndi.ActiveMQInitialContextFactory"); //
		 * p.put("connectionFactory.ConnectionFactory", "tcp://192.168.88.230:30728");
		 * p.put("connectionFactory.ConnectionFactory", "tcp://localhost:61615");
		 * p.put("queue.queue/exampleQueue", "exampleQueue"); initialContext = new
		 * InitialContext(p);
		 * 
		 * // lookup on the queue Queue queue = (Queue)
		 * initialContext.lookup("queue/exampleQueue");
		 * 
		 * // lookup on the Connection Factory ConnectionFactory cf =
		 * (ConnectionFactory) initialContext.lookup("ConnectionFactory");
		 * 
		 * // Create an authenticated JMS Connection // connection =
		 * cf.createConnection("usermMq", "HBDEMKuw"); connection =
		 * cf.createConnection("admin", "admin");
		 * 
		 * // Create a JMS Session session = connection.createSession(false,
		 * Session.AUTO_ACKNOWLEDGE); // Create a JMS Message Consumer MessageConsumer
		 * messageConsumer = session.createConsumer(queue, "JMSCorrelationID='" +
		 * exchange.getProperty("transId") + "'");
		 * 
		 * // Start the Connection connection.start();
		 * 
		 * // Receive the message
		 * 
		 * TextMessage messageReceived = (TextMessage) messageConsumer.receive(50000);
		 * 
		 * System.out.println("Received message: " + messageReceived.getText()); return
		 * messageReceived.getText().toString();
		 * 
		 * return "ERROR"; } catch (Exception e) { e.printStackTrace();
		 * System.out.println("Data not Found"); return "Data not Found"; } finally { //
		 * Be sure to close our JMS resources! if (session != null) { session.close(); }
		 * if (initialContext != null) { initialContext.close(); } if (connection !=
		 * null) { connection.close(); } }
		 */

		Session session = null;
		Connection connection = null;
		String output = "";
		try {
			ConnectionFactory factory = new ActiveMQConnectionFactory(amquser, amqpass,
					"tcp://" + amqaddress + ":" + amqport);
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue(queuename);
			Destination destination = session.createQueue(queuename);
			MessageConsumer messageConsumer = session.createConsumer(destination,
					"JMSCorrelationID='" + exchange.getProperty("transId") + "'");
			System.out.println("[" + exchange.getProperty("transId") + "] Get data from AMQ with JMSCorrelationID:"
					+ exchange.getProperty("transId"));
			TextMessage textMessage = (TextMessage) messageConsumer.receive(Integer.parseInt(timeout));
			output = textMessage.getText();
			System.out.println("[" + exchange.getProperty("transId") + "] Received Message From AMQ :" + output);
			exchange.setProperty("bodyResponseOri", output);
			session.close();
			connection.close();

		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("[" + exchange.getProperty("transId") + "] Data not Found");
			return "Data not Found";
		} finally {
			// Be sure to close our JMS resources!
			if (session != null) {
				session.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return output;
	}

}