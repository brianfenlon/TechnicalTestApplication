/**
 * 
 */
package com.currfair.techtest.model.analytics;

import java.math.BigDecimal;

/**
 * Representation of currency data in statistical format.
 * 
 * @author fbrian00
 * 
 */
public class CurrencyTransations {

	/** Number of times bought. */
	private long countBuy;

	/** Number of times sold. */
	private long countSell;

	/** Total amount bought. */
	private BigDecimal totalBuyAmount;

	/** total amount sold. */
	private BigDecimal totalSellAmount;

	/** Default constructor. Setting financial values to 0.00. */
	public CurrencyTransations() {
		totalBuyAmount = BigDecimal.ZERO;
		totalSellAmount = BigDecimal.ZERO;
	}

	/**
	 * @return the countBuy
	 */
	public long getCountBuy() {
		return countBuy;
	}

	/**
	 * @param countBuy the countBuy to set
	 */
	public void setCountBuy(long countBuy) {
		this.countBuy = countBuy;
	}

	/**
	 * @return the countSell
	 */
	public long getCountSell() {
		return countSell;
	}

	/**
	 * @param countSell the countSell to set
	 */
	public void setCountSell(long countSell) {
		this.countSell = countSell;
	}

	/**
	 * @return the totalBuyAmount
	 */
	public BigDecimal getTotalBuyAmount() {
		return totalBuyAmount;
	}

	/**
	 * @param totalBuyAmount the totalBuyAmount to set
	 */
	public void setTotalBuyAmount(BigDecimal totalBuyAmount) {
		this.totalBuyAmount = totalBuyAmount;
	}

	/**
	 * @return the totalSellAmount
	 */
	public BigDecimal getTotalSellAmount() {
		return totalSellAmount;
	}

	/**
	 * @param totalSellAmount the totalSellAmount to set
	 */
	public void setTotalSellAmount(BigDecimal totalSellAmount) {
		this.totalSellAmount = totalSellAmount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CurrencyTransations [countBuy=" + countBuy + ", countSell=" + countSell + ", totalBuyAmount="
				+ totalBuyAmount + ", totalSellAmount=" + totalSellAmount + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int)(countBuy ^ (countBuy >>> 32));
		result = prime * result + (int)(countSell ^ (countSell >>> 32));
		result = prime * result + ((totalBuyAmount == null) ? 0 : totalBuyAmount.hashCode());
		result = prime * result + ((totalSellAmount == null) ? 0 : totalSellAmount.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CurrencyTransations other = (CurrencyTransations)obj;
		if (countBuy != other.countBuy) {
			return false;
		}
		if (countSell != other.countSell) {
			return false;
		}
		if (totalBuyAmount == null) {
			if (other.totalBuyAmount != null) {
				return false;
			}
		} else if (!totalBuyAmount.equals(other.totalBuyAmount)) {
			return false;
		}
		if (totalSellAmount == null) {
			if (other.totalSellAmount != null) {
				return false;
			}
		} else if (!totalSellAmount.equals(other.totalSellAmount)) {
			return false;
		}
		return true;
	}

}
