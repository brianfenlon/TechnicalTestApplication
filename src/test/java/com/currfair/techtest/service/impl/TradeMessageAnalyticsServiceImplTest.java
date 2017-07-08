/**
 * 
 */
package com.currfair.techtest.service.impl;

import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import junitx.util.PrivateAccessor;

import org.junit.Before;
import org.junit.Test;

import com.currfair.techtest.model.TradeMessage;
import com.currfair.techtest.model.analytics.CurrencyTransations;
import com.currfair.techtest.persistence.InMemoryDatabaseStub;
import com.currfair.techtest.persistence.TradeDao;
import com.currfair.techtest.persistence.impl.TradeInMemoryDaoImpl;
import com.currfair.techtest.service.TradeMessageAnalyticsService;
import com.currfair.techtest.utils.UnitTestUtils;

/**
 * unit test class for TradeMessageAnalyticsServiceImpl. Demonstrates use of Mocks and testing private methods.
 * 
 * @author fbrian00
 * 
 */
public class TradeMessageAnalyticsServiceImplTest {

	/** Class under test. */
	public TradeMessageAnalyticsService analyticsService;

	/** Mock DAO. */
	private TradeDao tradeDao;

	/** Runs before each unit test execution. */
	@Before
	public void setUp() throws Exception {
		UnitTestUtils.resetAllData();
		analyticsService = new TradeMessageAnalyticsServiceImpl();
		tradeDao = new TradeInMemoryDaoImpl();
		PrivateAccessor.setField(analyticsService, "tradeDao", tradeDao);
	}

	/** Verifies the private method updates the DB as expected. */
	@Test
	public void testProcessTransactionsPerCurrencyPerHour() {

		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 9);
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

		Map<Integer, Map<String, CurrencyTransations>> mockData = new HashMap<Integer, Map<String, CurrencyTransations>>();

		Method method;

		try {
			method = (TradeMessageAnalyticsServiceImpl.class).getDeclaredMethod(
					"processTransactionsPerCurrencyPerHour", TradeMessage.class);
			method.setAccessible(true);

			method.invoke(analyticsService, trade1);

			Map<Integer, Map<String, CurrencyTransations>> updatedResults = (Map<Integer, Map<String, CurrencyTransations>>)PrivateAccessor
					.getField(InMemoryDatabaseStub.class, "transactionsPerHourDataTable");

			Map<Integer, Map<String, CurrencyTransations>> results = analyticsService
					.getTransactionsPerCurrencyPerHour();
			CurrencyTransations sellDetails = results.get(9).get("EUR");
			Assert.assertEquals(new BigDecimal("1000.00").doubleValue(),
					sellDetails.getTotalSellAmount().doubleValue(), 0.0);
			Assert.assertEquals(new BigDecimal("0.00").doubleValue(), sellDetails.getTotalBuyAmount().doubleValue(),
					0.0);
			CurrencyTransations buyDetails = results.get(9).get("GBP");
			Assert.assertEquals(new BigDecimal("0.00").doubleValue(), buyDetails.getTotalSellAmount().doubleValue(),
					0.0);
			Assert.assertEquals(new BigDecimal("950.00").doubleValue(), buyDetails.getTotalBuyAmount().doubleValue(),
					0.0);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}
}
