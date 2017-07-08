/**
 * 
 */
package com.currfair.techtest.service;

import java.util.Map;

import com.currfair.techtest.model.TradeMessage;
import com.currfair.techtest.model.analytics.CurrencyTransations;

/**
 * Analytics Service: trades.
 * 
 * @author fbrian00
 */
public interface TradeMessageAnalyticsService {

	/**
	 * Update current stats with newest trade details.
	 * 
	 * @param trade latest trade.
	 */
	public void processStats(TradeMessage trade);

	/**
	 * Get transactions per currency per hour details.
	 * 
	 * @return transactions per currency per hour details
	 */
	public Map<Integer, Map<String, CurrencyTransations>> getTransactionsPerCurrencyPerHour();

	/**
	 * Get buy/sell details.
	 * 
	 * @return buy/sell details.
	 */
	public Map<String, CurrencyTransations> getBuySellTotalsPerCurrency();
}
