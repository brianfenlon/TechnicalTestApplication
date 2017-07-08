/**
 * 
 */
package com.currfair.techtest.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;
import junitx.util.PrivateAccessor;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.currfair.techtest.model.TradeMessage;
import com.currfair.techtest.persistence.TradeDao;
import com.currfair.techtest.service.TradeMessageService;
import com.currfair.techtest.utils.UnitTestUtils;

/**
 * 
 * unit test class for TradeMessageServiceImpl. Demonstrates use of Mocks.
 * 
 * @author fbrian00
 * 
 */
public class TradeMessageServiceImplTest {

	/** Class under test. */
	private TradeMessageService tradeService;

	/** Mock dao. */
	private TradeDao messageDao;

	/** Runs before each unit test execution. */
	@Before
	public void before() throws Exception {
		UnitTestUtils.resetAllData();
		tradeService = new TradeMessageServiceImpl();

		messageDao = EasyMock.createMock(TradeDao.class);

		PrivateAccessor.setField(tradeService, "messageDao", messageDao);
	}

	/** Demonstates the use of Mocks. */
	@Test
	public void testGetTradedCompleted() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 10);
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

		List<TradeMessage> tradeList = new ArrayList<>();
		tradeList.add(trade1);

		EasyMock.expect(messageDao.getTradedCompleted()).andReturn(tradeList);
		EasyMock.replay(messageDao);

		List<TradeMessage> results = tradeService.getTradedCompleted();
		Assert.assertEquals(trade1, results.get(0));
	}
}
