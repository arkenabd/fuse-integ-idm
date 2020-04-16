package com.json.netty.pojo.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "TrxId", "Token", "noHP", "Amount" })
public class IdmDetail {

	@JsonProperty("TrxId")
	private String trxId;
	@JsonProperty("Token")
	private String token;
	@JsonProperty("noHP")
	private String noHP;
	@JsonProperty("Amount")
	private String amount;

	@JsonProperty("TrxId")
	public String getTrxId() {
		return trxId;
	}

	@JsonProperty("TrxId")
	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}

	@JsonProperty("Token")
	public String getToken() {
		return token;
	}

	@JsonProperty("Token")
	public void setToken(String token) {
		this.token = token;
	}

	@JsonProperty("noHP")
	public String getNoHP() {
		return noHP;
	}

	@JsonProperty("noHP")
	public void setNoHP(String noHP) {
		this.noHP = noHP;
	}

	@JsonProperty("Amount")
	public String getAmount() {
		return amount;
	}

	@JsonProperty("Amount")
	public void setAmount(String amount) {
		this.amount = amount;
	}

}