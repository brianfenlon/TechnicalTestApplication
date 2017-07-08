/**
 * 
 */
package com.currfair.techtest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currfair.techtest.model.TradeMessage;
import com.currfair.techtest.persistence.TradeDao;
import com.currfair.techtest.service.TradeMessageService;

/**
 * Trade service implementation class.
 * 
 * @author fbrian00
 */
@Service
public class TradeMessageServiceImpl implements TradeMessageService {

	/** Trade persistence object. */
	@Autowired
	private TradeDao messageDao;

	/**
	 * Process trade details.
	 * 
	 * @param trade trade details.
	 * @return trade details.
	 */
	@Override
	public TradeMessage processMessage(TradeMessage trade) {
		// TODO verify sell and buy rate is correct for rate

		return messageDao.save(trade);
	}

	/**
	 * Return all messages complete.
	 * 
	 * @return All messages complete.
	 */
	@Override
	public List<TradeMessage> getTradedCompleted() {
		return messageDao.getTradedCompleted();
	}

}
