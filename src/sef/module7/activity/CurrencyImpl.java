package sef.module7.activity;

import java.util.Calendar;
import java.util.Objects;

/**
 * Represents an implementation of the Currency interface.  The equality test for
 * this currency implementation requires that the value and the name of the denomination
 * must be true in order to be considered equal.
 *
 * @author John Doe
 */
public class CurrencyImpl implements Currency {

	@Override
	public String toString() {
		return "CurrencyImpl{" +
				"value=" + value +
				", denomination=" + denomination +
				", createDate=" + createDate +
				'}';
	}

	private float value;
	private Denomination denomination;

	@Override
	public int hashCode() {
		return Objects.hash(value, denomination, createDate);
	}

	private Calendar createDate;


	/**
	 * Creates an instance of the of the Currency class with the specified
	 * value and denomination
	 *
	 * @param value        the value of the currency
	 * @param denomination the denomination of the currency
	 */
	public CurrencyImpl(float value, Denomination denomination) {
		this.value = value;
		this.denomination = new DenominationImpl(denomination.getName(), denomination.getDescription(), denomination.getSymbol());
		this.createDate = Calendar.getInstance();
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Currency#getValue()
	 */
	public float getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Currency#getDenomination()
	 */
	public Denomination getDenomination() {
		return denomination;
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Currency#getCreateDate()
	 */
	public Calendar getCreateDate() {
		return Calendar.getInstance();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CurrencyImpl)) return false;
		CurrencyImpl currency = (CurrencyImpl) o;
		return Float.compare(currency.value, value) == 0 &&
				denomination.equals(currency.denomination) &&
				createDate.equals(currency.createDate);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
//	public boolean equals(Object o) {
//


}


