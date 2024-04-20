package com.org.backendjava.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class DataView {
	//@JsonProperty("USDBRL")
	//@JsonAnySetter
	private CurrencyView currencyView;
	
	
	
	@JsonIgnore
	public void setDataView(ObjectNode objectNode) {
		this.currencyView = new CurrencyView();
		currencyView.setCode(objectNode.get("code").asText());
	}
}
