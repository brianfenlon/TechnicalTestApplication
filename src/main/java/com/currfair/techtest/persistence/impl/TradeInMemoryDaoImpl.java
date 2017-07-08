/**
 * 
 */
package com.currfair.techtest.persistence.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.currfair.techtest.model.TradeMessage;
import com.currfair.techtest.model.analytics.CurrencyTransations;
import com.currfair.techtest.persistence.InMemoryDatabaseStub;
import com.currfair.techtest.persistence.TradeDao;

/**
 * Trade related persistence implementation class.
 * 
 * @author fbrian00
 */
@Repository
public class TradeInMemoryDaoImpl implements TradeDao {

	/**
	 * Save/update trade.
	 * 
	 * @param trade Trade message
	 * @return Saved trade.
	 */
	@Override
	public TradeMessage save(TradeMessage trade) {
		TradeMessage tmsg = trade;
		tmsg.setId(UUID.randomUUID().toString());

		InMemoryDatabaseStub.addTradeMessage(trade);
		return tmsg;
	}

	/**
	 * Retrieve all processed/completed trades.
	 * 
	 * @return List of all trades completed
	 */
	@Override
	public List<TradeMessage> getTradedCompleted() {
		List<TradeMessage> trades = null;

		Map<String, TradeMessage> messages = InMemoryDatabaseStub.getProcessedMessageData();
		if (!messages.isEmpty()) {
			trades = new ArrayList<TradeMessage>(messages.values());
		}
		return trades;
	}

	/**
	 * Retrieve statistical data on currency transactions per hour.
	 * 
	 * @return Currency transactions per hour.
	 */
	@Override
	public Map<Integer, Map<String, CurrencyTransations>> getTransactionsPerHour() {
		return InMemoryDatabaseStub.getTransactionsPerHourData();
	}

	/**
	 * Retrieve statistical data on buy/sell details.
	 * 
	 * @return Buy / sell stats.
	 */
	@Override
	public Map<String, CurrencyTransations> getBuySellTotals() {
		return InMemoryDatabaseStub.getBuySellTotalsDataTable();
	}

}
