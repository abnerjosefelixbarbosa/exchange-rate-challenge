package com.org.backendjava.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DailyView {
	private CurrencyView currencyView;
	private CurrencyDailyView currencyDailyView;
}
