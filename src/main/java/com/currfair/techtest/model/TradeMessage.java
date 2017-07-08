/**
 * 
 */
package com.currfair.techtest.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * Trade message model.
 * 
 * @author fbrian00
 */
public class TradeMessage implements Serializable {

	/** ID. */
	private static final long serialVersionUID = 1767316627727476398L;

	/** ID assigned by system following processing. */
	private String id;

	/** User who performed trade. */
	private String userId;

	/** Sell currency. */
	private String currencyFrom;

	/** Buy currency. */
	private String currencyTo;

	/** Sell amount (local currency). */
	private BigDecimal amountSell;

	/** Buy amount (local currency). */
	private BigDecimal amountBuy;

	/** Excahance rate. */
	private BigDecimal rate;

	/** Transaction time (local). */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yy HH:mm:ss")
	private Date timePlaced;

	/** Country of origin. */
	private String originatingCountry;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the currencyFrom
	 */
	public String getCurrencyFrom() {
		return currencyFrom;
	}

	/**
	 * @param currencyFrom the currencyFrom to set
	 */
	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	/**
	 * @return the currencyTo
	 */
	public String getCurrencyTo() {
		return currencyTo;
	}

	/**
	 * @param currencyTo the currencyTo to set
	 */
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	/**
	 * @return the amountSell
	 */
	public BigDecimal getAmountSell() {
		return amountSell;
	}

	/**
	 * @param amountSell the amountSell to set
	 */
	public void setAmountSell(BigDecimal amountSell) {
		this.amountSell = amountSell;
	}

	/**
	 * @return the amountBuy
	 */
	public BigDecimal getAmountBuy() {
		return amountBuy;
	}

	/**
	 * @param amountBuy the amountBuy to set
	 */
	public void setAmountBuy(BigDecimal amountBuy) {
		this.amountBuy = amountBuy;
	}

	/**
	 * @return the rate
	 */
	public BigDecimal getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	/**
	 * @return the timePlaced
	 */
	public Date getTimePlaced() {
		return timePlaced;
	}

	/**
	 * @param timePlaced the timePlaced to set
	 */
	public void setTimePlaced(Date timePlaced) {
		this.timePlaced = timePlaced;
	}

	/**
	 * @return the originatingCountry
	 */
	public String getOriginatingCountry() {
		return originatingCountry;
	}

	/**
	 * @param originatingCountry the originatingCountry to set
	 */
	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TradeMessage [id=" + id + ", userId=" + userId + ", currencyFrom=" + currencyFrom + ", currencyTo="
				+ currencyTo + ", amountSell=" + amountSell + ", amountBuy=" + amountBuy + ", rate=" + rate
				+ ", timePlaced=" + timePlaced + ", originatingCountry=" + originatingCountry + "]";
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
		result = prime * result + ((amountBuy == null) ? 0 : amountBuy.hashCode());
		result = prime * result + ((amountSell == null) ? 0 : amountSell.hashCode());
		result = prime * result + ((currencyFrom == null) ? 0 : currencyFrom.hashCode());
		result = prime * result + ((currencyTo == null) ? 0 : currencyTo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((originatingCountry == null) ? 0 : originatingCountry.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((timePlaced == null) ? 0 : timePlaced.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		TradeMessage other = (TradeMessage)obj;
		if (amountBuy == null) {
			if (other.amountBuy != null) {
				return false;
			}
		} else if (!amountBuy.equals(other.amountBuy)) {
			return false;
		}
		if (amountSell == null) {
			if (other.amountSell != null) {
				return false;
			}
		} else if (!amountSell.equals(other.amountSell)) {
			return false;
		}
		if (currencyFrom == null) {
			if (other.currencyFrom != null) {
				return false;
			}
		} else if (!currencyFrom.equals(other.currencyFrom)) {
			return false;
		}
		if (currencyTo == null) {
			if (other.currencyTo != null) {
				return false;
			}
		} else if (!currencyTo.equals(other.currencyTo)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (originatingCountry == null) {
			if (other.originatingCountry != null) {
				return false;
			}
		} else if (!originatingCountry.equals(other.originatingCountry)) {
			return false;
		}
		if (rate == null) {
			if (other.rate != null) {
				return false;
			}
		} else if (!rate.equals(other.rate)) {
			return false;
		}
		if (timePlaced == null) {
			if (other.timePlaced != null) {
				return false;
			}
		} else if (!timePlaced.equals(other.timePlaced)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}

}
