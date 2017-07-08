package com.currfair.techtest.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.currfair.techtest.model.TradeMessage;
import com.currfair.techtest.model.analytics.CurrencyTransations;
import com.currfair.techtest.service.TradeMessageAnalyticsService;
import com.currfair.techtest.service.TradeMessageService;

/**
 * Handles requests for the application statistics page.
 */
@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {

	/** Log object. */
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);

	/** Trade messaging service. */
	@Autowired
	private TradeMessageService messageService;

	/** Trade analytics service. */
	@Autowired
	private TradeMessageAnalyticsService analyticsService;

	/**
	 * Retrieves trades and stores as attribute for messageDashboard JSP.
	 * 
	 * @param model Used to pass attributes for use in JSP.
	 * @return JSP name: messageDashboard
	 */
	@RequestMapping(value = "/trade", method = RequestMethod.GET)
	public String generateTradeMessageDashboard(Model model) {
		List<TradeMessage> trades = messageService.getTradedCompleted();

		model.addAttribute("trades", trades);
		return "messageDashboard";
	}

	/**
	 * Retrieves the currency by hour statistics.
	 * 
	 * @return Stats on currency by hour
	 */
	@RequestMapping(value = "/trade/currencyperhour", method = RequestMethod.GET)
	@ResponseBody
	public Map<Integer, Map<String, CurrencyTransations>> getCurrencyPerHourStats() {

		return analyticsService.getTransactionsPerCurrencyPerHour();
	}

	/**
	 * Retrieves the buy/sell amounts by currency statistics.
	 * 
	 * @return Stats on buy/sell by currency.
	 */
	@RequestMapping(value = "/trade/buyselltotals", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, CurrencyTransations> getBuySellTotalsPerCurrency() {

		return analyticsService.getBuySellTotalsPerCurrency();
	}
}
