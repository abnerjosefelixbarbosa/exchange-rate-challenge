package com.org.backendjava.dto;

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
}