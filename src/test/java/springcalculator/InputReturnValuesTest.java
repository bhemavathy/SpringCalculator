package springcalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

import junit.framework.Assert;

import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;

import MyCalculator.MyCalculator.InputReturnValues;

public class InputReturnValuesTest {
	
	@Test
	public void getterSetterTest() {
		double input1 = 100, expinp1 = 100;
		double input2 = 50, expinp2 = 50;
		char operator = '+', expoperator = '+';
		InputReturnValues irv = new InputReturnValues();
		irv.setInput1(input1);
		irv.setInput2(input2);
		irv.setOperator(operator);
		Assert.assertEquals(expinp1, (irv.getInput1()));
		Assert.assertEquals(expinp2, irv.getInput2());
		Assert.assertEquals(expoperator, irv.getOperator());

	}

}
