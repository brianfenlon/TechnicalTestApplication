/**
 * 
 */
package com.currfair.techtest.utils;

import java.util.Map;

import junitx.util.PrivateAccessor;

import org.junit.Before;

import com.currfair.techtest.model.TradeMessage;
import com.currfair.techtest.model.analytics.CurrencyTransations;
import com.currfair.techtest.persistence.InMemoryDatabaseStub;

/**
 * @author fbrian00
 * 
 */
public class UnitTestUtils {

	public static void resetAllData() throws Exception {

		((Map<String, TradeMessage>)PrivateAccessor.getField(InMemoryDatabaseStub.class, "tradeMessageDataTable"))
				.clear();

		((Map<Integer, Map<String, CurrencyTransations>>)PrivateAccessor.getField(InMemoryDatabaseStub.class,
				"transactionsPerHourDataTable")).clear();

		((Map<String, CurrencyTransations>)PrivateAccessor.getField(InMemoryDatabaseStub.class,
				"buySellTotalsDataTable")).clear();
	}
}
