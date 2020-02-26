package com.json.netty;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.json.netty.util.FixLengthConf;
import com.json.netty.util.FixLengthMessageIn;
import com.json.netty.util.JsonResult;

@Service
public class ParsingFixLengthResp {
	public String parsingIsoMessage(String inputVal) throws ISOException {
		// 1. Unpack ISO8583 Message
		List<FixLengthMessageIn> flconfList = new ArrayList<FixLengthMessageIn>();
		FixLengthConf conf = new FixLengthConf();
		flconfList = conf.getConf();

		String status = "";
		System.out.println("========Fix Length Config========");
		for (int i = 0; i < flconfList.size(); i++) {

			System.out.println("field name :" + flconfList.get(i).getFieldName());
			System.out.println("start :" + flconfList.get(i).getIndexStart());
			System.out.println("end :" + flconfList.get(i).getIndexEnd());
			String fieldName = flconfList.get(i).getFieldName().toString();
			int start = Integer.parseInt(flconfList.get(i).getIndexStart().toString());
			int end = Integer.parseInt(flconfList.get(i).getIndexEnd().toString());
			System.out.println("=====================================");
			String value = inputVal.substring(start - 1, end);
			flconfList.set(i,
					new FixLengthMessageIn(fieldName, String.valueOf(start), String.valueOf(end), value.trim()));
			if (fieldName.equals("status")) {
				status = value;
			}

		}
		System.out.println("========Fix Length Parsing Result========");

		System.out.println("status :" + status);

		JsonResult jsonRes = new JsonResult();
		jsonRes.setResult(status);
		// Creating Object of ObjectMapper define in Jakson Api
		ObjectMapper ObjMapper = new ObjectMapper();
		String finalreturn = "";
		try {

			// get Oraganisation object as a json string
			finalreturn = ObjMapper.writeValueAsString(jsonRes);

			// Displaying JSON String
			System.out.println(finalreturn);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("=====================================");
		System.out.println("finalreturn : " + finalreturn);
		return finalreturn;

	}

}