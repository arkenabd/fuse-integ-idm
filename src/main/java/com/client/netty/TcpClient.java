package com.client.netty;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.jpos.iso.ISOException;
import org.springframework.stereotype.Component;

import com.json.netty.GenerateIso;
import com.json.netty.ParsingFixLengthResp;
import com.json.netty.ParsingIso;

@Component
public class TcpClient {

	public String call(String inputVal) {
		System.out.println("INSIDE TCP CLIENT");
		System.out.println("Fixlength message :" + inputVal);
		String msgReceived = "";
		try {
//			InetAddress address = InetAddress.getByName("34.87.45.79");
//			Socket socket = new Socket(address, 23472);
			InetAddress address = InetAddress.getByName("0.0.0.0");
			Socket socket = new Socket(address, 7000);
			OutputStream os = socket.getOutputStream();
			System.out.println("Message sent.");

			byte[] byteArr = inputVal.getBytes();
			os.write(byteArr, 0, byteArr.length);

			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			msgReceived = br.readLine();

			System.out.println("Message received.");

			System.out.println(msgReceived);
			os.flush();
			os.close();
			is.close();
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
//		ParsingIso parsingIso = new ParsingIso();
//		String returnJson = "";
//		try {
//			returnJson = parsingIso.parsingIsoMessage(msgReceived);
//		} catch (ISOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ParsingFixLengthResp parseResp = new ParsingFixLengthResp();
		String returnJson = null;
		try {
			returnJson = parseResp.parsingIsoMessage(msgReceived);
		} catch (ISOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnJson;
	}
}
