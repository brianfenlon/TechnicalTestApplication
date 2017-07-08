/**
 * 
 */
package com.currfair.techtest.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currfair.techtest.model.TradeMessage;
import com.currfair.techtest.model.analytics.CurrencyTransations;
import com.currfair.techtest.persistence.TradeDao;
import com.currfair.techtest.service.TradeMessageAnalyticsService;

/**
 * Trade analysics service implemenation class.
 * 
 * @author fbrian00
 * 
 */
@Service
public class TradeMessageAnalyticsServiceImpl implements TradeMessageAnalyticsService {

	/** Trade Dao. */
	@Autowired
	private TradeDao tradeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.currfair.techtest.service.TradeMessageAnalyticsService#processStats(com.currfair.techtest.model
	 * .TradeMessage)
	 */
	@Override
	public void processStats(TradeMessage trade) {
		// #Transactions per hour
		processTransactionsPerCurrencyPerHour(trade);
		// Totals per hour
		processRunningBuySellTotalsPerCurrency(trade);
	}

	/**
	 * Get transactions per currency per hour details.
	 * 
	 * @return transactions per currency per hour details
	 */
	@Override
	public Map<Integer, Map<String, CurrencyTransations>> getTransactionsPerCurrencyPerHour() {
		return tradeDao.getTransactionsPerHour();
	}

	/**
	 * Get buy/sell details.
	 * 
	 * @return buy/sell details.
	 */
	@Override
	public Map<String, CurrencyTransations> getBuySellTotalsPerCurrency() {
		return tradeDao.getBuySellTotals();
	}

	/**
	 * Add the trade details to the current stats on currency transactions per hour.
	 * 
	 * @param trade trade
	 */
	private void processTransactionsPerCurrencyPerHour(TradeMessage trade) {
		Map<Integer, Map<String, CurrencyTransations>> transPerHour = tradeDao.getTransactionsPerHour();
		Calendar c = Calendar.getInstance();
		c.setTime(trade.getTimePlaced());

		final int HOUR = c.get(Calendar.HOUR_OF_DAY);
		final String CURRENCY_BUY_KEY = trade.getCurrencyTo();

		Map<String, CurrencyTransations> currStats = transPerHour.get(HOUR);
		if (currStats == null) {
			currStats = new HashMap<>();
		}

		CurrencyTransations buyTrans = currStats.get(CURRENCY_BUY_KEY);
		if (buyTrans == null) {
			buyTrans = new CurrencyTransations();
		}
		buyTrans.setCountBuy(buyTrans.getCountBuy() + 1);
		buyTrans.setTotalBuyAmount(buyTrans.getTotalBuyAmount().add(trade.getAmountBuy()));

		currStats.put(CURRENCY_BUY_KEY, buyTrans);

		final String CURRENCY_SELL_KEY = trade.getCurrencyFrom();
		CurrencyTransations sellTrans = currStats.get(CURRENCY_SELL_KEY);
		if (sellTrans == null) {
			sellTrans = new CurrencyTransations();
		}
		sellTrans.setCountSell(sellTrans.getCountSell() + 1);
		sellTrans.setTotalSellAmount(sellTrans.getTotalSellAmount().add(trade.getAmountSell()));

		currStats.put(CURRENCY_SELL_KEY, sellTrans);

		transPerHour.put(HOUR, currStats);
	}

	/**
	 * Add the trade details to the current buy/sell transactions statistics.
	 * 
	 * @param trade trade
	 */
	private void processRunningBuySellTotalsPerCurrency(TradeMessage trade) {
		Map<String, CurrencyTransations> runningTotals = tradeDao.getBuySellTotals();

		final String CURRENCY_BUY_KEY = trade.getCurrencyTo();
		final String CURRENCY_SELL_KEY = trade.getCurrencyFrom();

		CurrencyTransations buyCurrency = runningTotals.get(CURRENCY_BUY_KEY);
		CurrencyTransations sellCurrency = runningTotals.get(CURRENCY_SELL_KEY);

		if (buyCurrency == null) {
			buyCurrency = new CurrencyTransations();
		}
		if (sellCurrency == null) {
			sellCurrency = new CurrencyTransations();
		}

		buyCurrency.setCountBuy(buyCurrency.getCountBuy() + 1);
		buyCurrency.setTotalBuyAmount(buyCurrency.getTotalBuyAmount().add(trade.getAmountBuy()));
		
		sellCurrency.setCountSell(sellCurrency.getCountSell() + 1);
		sellCurrency.setTotalSellAmount(sellCurrency.getTotalSellAmount().add(trade.getAmountSell()));

		runningTotals.put(CURRENCY_BUY_KEY, buyCurrency);
		runningTotals.put(CURRENCY_SELL_KEY, sellCurrency);

	}
}
