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
public class DailyView {
	//private CurrencyView currencyView;
	private CurrencyDailyView currencyDailyView;
}
