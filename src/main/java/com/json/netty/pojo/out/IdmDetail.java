
package com.json.netty.pojo.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "TrxConfirm" })
public class IdmDetail {

	@JsonProperty("TrxConfirm")
	private String trxConfirm;

	@JsonProperty("TrxConfirm")
	public String getTrxConfirm() {
		return trxConfirm;
	}

	@JsonProperty("TrxConfirm")
	public void setTrxConfirm(String trxConfirm) {
		this.trxConfirm = trxConfirm;
	}

}