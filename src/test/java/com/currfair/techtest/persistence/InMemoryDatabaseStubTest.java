/**
 * 
 */
package com.currfair.techtest.persistence;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import junitx.util.PrivateAccessor;

import org.junit.Assert;
import org.junit.Test;

import com.currfair.techtest.model.TradeMessage;
import com.currfair.techtest.model.analytics.CurrencyTransations;

/**
 * Unit test class for InMemoryDatabaseStub. Demonstrates standard unit testing plus accessing private members.
 * 
 * @author fbrian00
 * 
 */
public class InMemoryDatabaseStubTest {

	/** Verifies the stubbing DB acts as expected. */
	@Test
	public void testAddAndRetrieveAllTradeMessage() {
		Calendar c = Calendar.getInstance();
		Date now = c.getTime();

		TradeMessage trade1 = new TradeMessage();
		trade1.setAmountBuy(new BigDecimal("950.00"));
		trade1.setAmountSell(new BigDecimal("1000.00"));
		trade1.setCurrencyFrom("EUR");
		trade1.setCurrencyTo("GBP");
		trade1.setId("100");
		trade1.setOriginatingCountry("IE");
		trade1.setRate(new BigDecimal("0.95"));
		trade1.setTimePlaced(now);
		trade1.setUserId("User1");

		TradeMessage trade2 = new TradeMessage();
		trade2.setAmountBuy(new BigDecimal("445.00"));
		trade2.setAmountSell(new BigDecimal("500.00"));
		trade2.setCurrencyFrom("USD");
		trade2.setCurrencyTo("NZD");
		trade2.setId("101");
		trade2.setOriginatingCountry("USA");
		trade2.setRate(new BigDecimal("0.951"));
		trade2.setTimePlaced(now);
		trade2.setUserId("User2");

		InMemoryDatabaseStub.addTradeMessage(trade1);
		InMemoryDatabaseStub.addTradeMessage(trade2);

		Map<String, TradeMessage> alltradesList = InMemoryDatabaseStub.getProcessedMessageData();
		Assert.assertEquals(trade1, alltradesList.get(trade1.getId()));
		Assert.assertEquals(trade2, alltradesList.get(trade2.getId()));

	}

	@Test
	public void testGetBuySellTotalsDataTable() {

		CurrencyTransations currTrans = new CurrencyTransations();
		currTrans.setCountBuy(1);
		currTrans.setTotalBuyAmount(new BigDecimal("1000.01"));

		try {
			((Map<String, CurrencyTransations>)PrivateAccessor.getField(InMemoryDatabaseStub.class,
					"buySellTotalsDataTable")).put("GBP", currTrans);
			Map<String, CurrencyTransations> stats = InMemoryDatabaseStub.getBuySellTotalsDataTable();
			Assert.assertNull(stats.get("USD"));
			Assert.assertEquals(currTrans, stats.get("GBP"));
		} catch (NoSuchFieldException e) {
			Assert.fail();
			e.printStackTrace();
		}

	}
}
