package MyCalculator.MyCalculator;

import org.springframework.stereotype.Component;

/**
 * Class provides input1,input2 and operator to set and get the values
 *
 */
@Component
public class InputReturnValues {
	private double input1;
	private double input2;
	private char operator;

	public double getInput1() {
		return input1;
	}

	public void setInput1(double input1) {
		this.input1 = input1;
	}

	public double getInput2() {
		return input2;
	}

	public void setInput2(double input2) {
		this.input2 = input2;
	}

	public char getOperator() {
		return operator;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

}
