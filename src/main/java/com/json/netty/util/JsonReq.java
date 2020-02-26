package com.json.netty.util;

public class JsonReq {
	Basic BasicObject;
	private String ops;

	// Getter Methods

	public Basic getBasic() {
		return BasicObject;
	}

	public String getOps() {
		return ops;
	}

	// Setter Methods

	public void setBasic(Basic basicObject) {
		this.BasicObject = basicObject;
	}

	public void setOps(String ops) {
		this.ops = ops;
	}
}