/**
 * 
 */
package com.currfair.techtest.model.analytics;

/**
 * Currency statistics object.
 * 
 * @author fbrian00
 */
public class CurrencyStats {

	/** Currency code. */
	private String currency;

	/** Transaction statistics. */
	private CurrencyTransations transactionDetails;

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the transactionDetails
	 */
	public CurrencyTransations getTransactionDetails() {
		return transactionDetails;
	}

	/**
	 * @param transactionDetails the transactionDetails to set
	 */
	public void setTransactionDetails(CurrencyTransations transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CurrencyStats [currency=" + currency + ", transactionDetails=" + transactionDetails + "]";
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
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((transactionDetails == null) ? 0 : transactionDetails.hashCode());
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
		CurrencyStats other = (CurrencyStats)obj;
		if (currency == null) {
			if (other.currency != null) {
				return false;
			}
		} else if (!currency.equals(other.currency)) {
			return false;
		}
		if (transactionDetails == null) {
			if (other.transactionDetails != null) {
				return false;
			}
		} else if (!transactionDetails.equals(other.transactionDetails)) {
			return false;
		}
		return true;
	}
}
