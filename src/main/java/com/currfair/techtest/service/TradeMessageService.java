/**
 * 
 */
package com.currfair.techtest.service;

import java.util.List;

import com.currfair.techtest.model.TradeMessage;

/**
 * Trade related service functionality.
 * 
 * @author fbrian00
 */
public interface TradeMessageService {

	/**
	 * Process trade details.
	 * 
	 * @param trade trade details.
	 * @return trade details.
	 */
	public TradeMessage processMessage(TradeMessage trade);

	/**
	 * Return all messages complete.
	 * 
	 * @return All messages complete.
	 */
	public List<TradeMessage> getTradedCompleted();
}
