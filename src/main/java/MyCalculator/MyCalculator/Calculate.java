package MyCalculator.MyCalculator;

import org.springframework.stereotype.Component;

import MyCalculatorException.MyCalcException;

@Component
public class Calculate {

	volatile public int plusop = 0;
	volatile public int minusop = 0;
	volatile public int multipyop = 0;
	volatile public int divideop = 0;
	volatile public int percop = 0;

	/**
	 * @param input1
	 * @param input2
	 * @return sum
	 */
	public double add(double input1, double input2) {
		plusop++;
		double result = input1 + input2;
		return result;

	}

	/**
	 * @param input1
	 * @param input2
	 * @return difference
	 */
	public double sub(double input1, double input2) {
		double result = input1 - input2;

		minusop++;

		return result;
	}

	/**
	 * @param input1
	 * @param input2
	 * @return product
	 */
	public double multiply(double input1, double input2) {
		double result = input1 * input2;

		multipyop++;

		return result;
	}

	/**
	 * @param dividend
	 * @param divisor
	 * @return quotient
	 * @throws MyCalcException
	 * @throws Exception
	 */
	public double divide(double dividend, double divisor){
		double result = 0;
		try {
			result = dividend / divisor;
			divideop++;

		} catch (Exception e) {

		}

		return result;

	}

	/**
	 * @param obtainedvalue
	 * @param totalvalue
	 * @return percentage
	 */
	public double percentage(double obtainedvalue, double totalvalue) {
		double result = (obtainedvalue * 100) / totalvalue;

		percop++;

		return result;
	}

	public void operatorSum() {
		toString();

	}

	public String toString() {

		return "Calculate {" + " addop=" + plusop + ", subop=" + minusop
				+ ", mulop=" + multipyop + ", divop=" + divideop + ", perop="
				+ percop + "}";

	}

}
