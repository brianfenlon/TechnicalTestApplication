/**
 * 
 */
package com.currfair.techtest.persistence.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.currfair.techtest.model.TradeMessage;
import com.currfair.techtest.persistence.InMemoryDatabaseStub;
import com.currfair.techtest.persistence.TradeDao;
import com.currfair.techtest.utils.UnitTestUtils;

/**
 * unit test class for TradeInMemoryDaoImpl. Standard unit testing.
 * 
 * @author fbrian00
 * 
 */
public class TradeInMemoryDaoImplTest {

	/** Class under test. */
	private TradeDao dao;

	/** Runs before each unit test execution. */
	@Before
	public void setup() throws Exception {
		UnitTestUtils.resetAllData();
		dao = new TradeInMemoryDaoImpl();
	}

	/**
	 * Verifies the dao and DB interaction.
	 */
	@Test
	public void testRetrieveAndSaveTradeMessages() {
		List<TradeMessage> results = dao.getTradedCompleted();
		Assert.assertNull(results);

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

		dao.save(trade1);
		results = dao.getTradedCompleted();
		Assert.assertEquals(1, results.size());
		Assert.assertEquals(trade1, results.get(0));
	}

	/**
	 * Verifies the dao and DB interaction.
	 */
	@Test
	public void testGetTransactionsPerHour() {
		Assert.assertEquals(0, InMemoryDatabaseStub.getTransactionsPerHourData().keySet().size());
	}

	/**
	 * Verifies the dao and DB interaction.
	 */
	@Test
	public void testGetProcessedMessageData() {
		Assert.assertNotNull(InMemoryDatabaseStub.getProcessedMessageData().keySet().size());
	}
}
