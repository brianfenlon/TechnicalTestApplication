/**
 * 
 */
package com.currfair.techtest.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

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
import com.currfair.techtest.utils.UnitTestUtils;

/**
 * Demonstrates end-to-end unit tests and chained processes.
 * 
 * @author fbrian00
 * 
 */
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class TradeMessageControllerEndToEndTest {

	/** Class under test. */
	@Autowired
	private TradeMessageController controller;

	/** Runs before each unit test execution. */
	@Before
	public void setup() throws Exception {
		UnitTestUtils.resetAllData();
	}

	/** Verifies processMessage end-to-end. */
	@Test
	public void testProcessMessage() {
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

		Assert.assertNull(trade1.getId());

		controller.processMessage(trade1);
		Assert.assertNotNull(trade1.getId());

	}
}
