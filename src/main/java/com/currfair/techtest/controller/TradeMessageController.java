package com.currfair.techtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.currfair.techtest.model.TradeMessage;
import com.currfair.techtest.service.TradeMessageAnalyticsService;
import com.currfair.techtest.service.TradeMessageService;

/**
 * Handles requests for trade processing.
 */
@Controller
@RequestMapping(value = "/trade")
public class TradeMessageController {

	/** Logging object. */
	private static final Logger logger = LoggerFactory.getLogger(TradeMessageController.class);

	/** Trade messaging service. */
	@Autowired
	private TradeMessageService messageService;

	/** Trade analytics service. */
	@Autowired
	private TradeMessageAnalyticsService analyticsService;

	/**
	 * Processes the trade message supplied as parameter. Calls the trade analytics service to update statistics in
	 * real-time.
	 * 
	 * @param trade message for processing.
	 * @return Trade message with ID
	 */
	@RequestMapping(method = { RequestMethod.POST })
	@ResponseBody
	public TradeMessage processMessage(@RequestBody TradeMessage trade) {
		logger.info("Check is logging is working: " + trade.getUserId());
		TradeMessage processedTrade = messageService.processMessage(trade);
		analyticsService.processStats(processedTrade);
		return processedTrade;
	}

}
