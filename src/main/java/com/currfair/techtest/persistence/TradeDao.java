/**
 * 
 */
package com.currfair.techtest.persistence;

import java.util.List;
import java.util.Map;

import com.currfair.techtest.model.TradeMessage;
import com.currfair.techtest.model.analytics.CurrencyTransations;

/**
 * Trade related persistence interface.
 * 
 * @author fbrian00
 */
public interface TradeDao {

	/**
	 * Save/update trade.
	 * 
	 * @param trade Trade message
	 * @return Saved trade.
	 */
	public TradeMessage save(TradeMessage trade);

	/**
	 * Retrieve all processed/completed trades.
	 * 
	 * @return List of all trades completed
	 */
	public List<TradeMessage> getTradedCompleted();

	/**
	 * Get transactions per hour details.
	 * 
	 * @return Currency transactions per hour.
	 */
	public Map<Integer, Map<String, CurrencyTransations>> getTransactionsPerHour();

	/**
	 * Get buy/sell totals details.
	 * 
	 * @return Buy / sell stats.
	 */
	public Map<String, CurrencyTransations> getBuySellTotals();
}
