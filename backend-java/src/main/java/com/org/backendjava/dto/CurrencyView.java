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
public class CurrencyView {
	private String code;
	private String codein;
	private String name;
    private String high;
    private String low;
    private String varBid;
    private String pctChange;
    private String bid;
    private String ask;
    private String timestamp;
    private String create_date;
    
	public void setCurrencyView(ObjectNode objectNode) {
		this.code = objectNode.get("code").asText();
		this.codein = objectNode.get("codein").asText();
		this.name = objectNode.get("name").asText();
		this.high = objectNode.get("high").asText();
		this.low = objectNode.get("low").asText();
		this.varBid = objectNode.get("varBid").asText();
		this.pctChange = objectNode.get("pctChange").asText();
		this.bid = objectNode.get("bid").asText();
		this.ask = objectNode.get("ask").asText();
		this.timestamp = objectNode.get("timestamp").asText();
		this.create_date = objectNode.get("create_date").asText();
	}
}
