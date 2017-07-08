/**
 * 
 */
package com.currfair.techtest.persistence;

import java.util.HashMap;
import java.util.Map;

import com.currfair.techtest.model.TradeMessage;
import com.currfair.techtest.model.analytics.CurrencyTransations;

/**
 * Representation of what in-memory DB might look like if used.
 * 
 * @author fbrian00
 */
public class InMemoryDatabaseStub {

	/** Representation of table to store: all processed transactions. */
	private static final Map<String, TradeMessage> tradeMessageDataTable = new HashMap<>();

	/** Representation of table to store: Transactions by currency per hour. */
	private static final Map<Integer, Map<String, CurrencyTransations>> transactionsPerHourDataTable = new HashMap<>();

	/** Representation of table to store: buy & sell totals. */
	private static final Map<String, CurrencyTransations> buySellTotalsDataTable = new HashMap<>();

	/**
	 * Represents <i>save</i>. Should be transactional and ensure that ID is unique.
	 * 
	 * @param trade trade to add to database table.
	 * @return trade saved.
	 */
	public static TradeMessage addTradeMessage(final TradeMessage trade) {
		tradeMessageDataTable.put(trade.getId(), trade);
		return trade;
	}

	/**
	 * <i>Get all processed trades</i>.
	 * 
	 * @return the tradeMessageDataTable
	 */
	public static Map<String, TradeMessage> getProcessedMessageData() {
		return tradeMessageDataTable;
	}

	/**
	 * <i>Get transaction per hour per currency stats</i>.
	 * 
	 * @return transactionsPerHourDataTable
	 */
	public static Map<Integer, Map<String, CurrencyTransations>> getTransactionsPerHourData() {
		return transactionsPerHourDataTable;
	}

	/**
	 * <i>Get buy/sell totals stats</i>.
	 * 
	 * @return buySellTotalsDataTable
	 */
	public static Map<String, CurrencyTransations> getBuySellTotalsDataTable() {
		return buySellTotalsDataTable;
	}

}
