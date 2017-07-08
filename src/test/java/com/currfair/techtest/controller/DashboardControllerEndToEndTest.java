/**
 * 
 */
package com.currfair.techtest.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.currfair.techtest.model.TradeMessage;
import com.currfair.techtest.model.analytics.CurrencyTransations;
import com.currfair.techtest.utils.UnitTestUtils;

/**
 * Demonstrates end-to-end unit tests.
 * 
 * @author fbrian00
 * 
 */
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class DashboardControllerEndToEndTest {

	/** Class under test. */
	@Autowired
	private DashboardController dashboardController;

	/** Controller to verify business process. */
	@Autowired
	private TradeMessageController tradeMessageController;

	/** Runs before each unit test execution. */
	@Before
	public void setup() throws Exception {
		UnitTestUtils.resetAllData();
	}

	/** Verifies getCurrencyPerHourStats and processMessage interaction. */
	@Test
	public void testGetCurrencyPerHourStats() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 11);
		Date now = c.getTime();

		TradeMessage trade1 = new TradeMessage();
		trade1.setAmountBuy(new BigDecimal("445.00"));
		trade1.setAmountSell(new BigDecimal("500.00"));
		trade1.setCurrencyFrom("USD");
		trade1.setCurrencyTo("NZD");
		trade1.setOriginatingCountry("IE");
		trade1.setRate(new BigDecimal("0.95"));
		trade1.setTimePlaced(now);
		trade1.setUserId("User2");
		Map<Integer, Map<String, CurrencyTransations>> stats = dashboardController.getCurrencyPerHourStats();

		tradeMessageController.processMessage(trade1);

		stats = dashboardController.getCurrencyPerHourStats();
		CurrencyTransations usdStats = stats.get(11).get("USD");
		Assert.assertEquals(new BigDecimal("500.00").doubleValue(), usdStats.getTotalSellAmount().doubleValue(), 0.0d);
		Assert.assertEquals(1l, usdStats.getCountSell());

		CurrencyTransations nzdStats = stats.get(11).get("NZD");
		Assert.assertEquals(new BigDecimal("445.00").doubleValue(), nzdStats.getTotalBuyAmount().doubleValue(), 0.0d);
		Assert.assertEquals(1l, nzdStats.getCountBuy());
	}

	/** Verifies getBuySellTotalsPerCurrency and processMessage interaction. */
	@Test
	public void testGetBuySellTotalsPerCurrency() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 10);
		Date now = c.getTime();

		TradeMessage trade1 = new TradeMessage();
		trade1.setAmountBuy(new BigDecimal("950.00"));
		trade1.setAmountSell(new BigDecimal("1000.00"));
		trade1.setCurrencyFrom("EUR");
		trade1.setCurrencyTo("GBP");
		trade1.setOriginatingCountry("IE");
		trade1.setRate(new BigDecimal("0.95"));
		trade1.setTimePlaced(now);
		trade1.setUserId("User1");

		Map<String, CurrencyTransations> stats = dashboardController.getBuySellTotalsPerCurrency();

		tradeMessageController.processMessage(trade1);
		stats = dashboardController.getBuySellTotalsPerCurrency();

		CurrencyTransations eurTrans = stats.get("EUR");
		Assert.assertEquals(new BigDecimal("1000.00").doubleValue(), eurTrans.getTotalSellAmount().doubleValue(), 0.0d);
		Assert.assertEquals(1l, eurTrans.getCountSell());

		CurrencyTransations gbpTrans = stats.get("GBP");
		Assert.assertEquals(new BigDecimal("950.00").doubleValue(), gbpTrans.getTotalBuyAmount().doubleValue(), 0.0d);
		Assert.assertEquals(1l, gbpTrans.getCountBuy());
	}
}
