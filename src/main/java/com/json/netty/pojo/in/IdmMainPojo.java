package com.json.netty.pojo.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "Timestamp", "ClientID", "Key", "BranchID", "CounterID", "ProductType", "TrxType", "Detail",
		"Timeout", "VersiProgram", "RespCode", "RespDetail" })
public class IdmMainPojo {

	@JsonProperty("Timestamp")
	private String timestamp;
	@JsonProperty("ClientID")
	private String clientID;
	@JsonProperty("Key")
	private String key;
	@JsonProperty("BranchID")
	private String branchID;
	@JsonProperty("CounterID")
	private String counterID;
	@JsonProperty("ProductType")
	private String productType;
	@JsonProperty("TrxType")
	private String trxType;
	@JsonProperty("Detail")
	private IdmDetail detail;
	@JsonProperty("Timeout")
	private String timeout;
	@JsonProperty("VersiProgram")
	private String versiProgram;
	@JsonProperty("RespCode")
	private String respCode;
	@JsonProperty("RespDetail")
	private String respDetail;

	@JsonProperty("Timestamp")
	public String getTimestamp() {
		return timestamp;
	}

	@JsonProperty("Timestamp")
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@JsonProperty("ClientID")
	public String getClientID() {
		return clientID;
	}

	@JsonProperty("ClientID")
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	@JsonProperty("Key")
	public String getKey() {
		return key;
	}

	@JsonProperty("Key")
	public void setKey(String key) {
		this.key = key;
	}

	@JsonProperty("BranchID")
	public String getBranchID() {
		return branchID;
	}

	@JsonProperty("BranchID")
	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	@JsonProperty("CounterID")
	public String getCounterID() {
		return counterID;
	}

	@JsonProperty("CounterID")
	public void setCounterID(String counterID) {
		this.counterID = counterID;
	}

	@JsonProperty("ProductType")
	public String getProductType() {
		return productType;
	}

	@JsonProperty("ProductType")
	public void setProductType(String productType) {
		this.productType = productType;
	}

	@JsonProperty("TrxType")
	public String getTrxType() {
		return trxType;
	}

	@JsonProperty("TrxType")
	public void setTrxType(String trxType) {
		this.trxType = trxType;
	}

	@JsonProperty("Detail")
	public IdmDetail getDetail() {
		return detail;
	}

	@JsonProperty("Detail")
	public void setDetail(IdmDetail detail) {
		this.detail = detail;
	}

	@JsonProperty("Timeout")
	public String getTimeout() {
		return timeout;
	}

	@JsonProperty("Timeout")
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	@JsonProperty("VersiProgram")
	public String getVersiProgram() {
		return versiProgram;
	}

	@JsonProperty("VersiProgram")
	public void setVersiProgram(String versiProgram) {
		this.versiProgram = versiProgram;
	}

	@JsonProperty("RespCode")
	public String getRespCode() {
		return respCode;
	}

	@JsonProperty("RespCode")
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	@JsonProperty("RespDetail")
	public String getRespDetail() {
		return respDetail;
	}

	@JsonProperty("RespDetail")
	public void setRespDetail(String respDetail) {
		this.respDetail = respDetail;
	}

}