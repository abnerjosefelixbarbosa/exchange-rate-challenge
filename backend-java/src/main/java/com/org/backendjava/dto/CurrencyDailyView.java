package com.org.backendjava.dto;

import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CurrencyDailyView {
	private String high;
	private String low;
	private String pctChange;
	private String bid;
	private String ask;
	private String varBid;
	private String timestamp;

	public void setCurrencyDailyView(ObjectNode objectNode) {
		this.high = objectNode.get("high").asText();
		this.low = objectNode.get("low").asText();
		this.varBid = objectNode.get("varBid").asText();
		this.pctChange = objectNode.get("pctChange").asText();
		this.bid = objectNode.get("bid").asText();
		this.ask = objectNode.get("ask").asText();
		this.timestamp = objectNode.get("timestamp").asText();
	}
}