package springcalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;


import MyCalculator.MyCalculator.CalculateWithInput;
import MyCalculator.MyCalculator.InputReturnValues;
import MyCalculator.MyCalculator.WriteFile;
import MyCalculatorException.CalcFileNotFoundException;
import MyCalculatorException.CalcIOException;
import MyCalculatorException.MyCalcException;

public class WriteFileTest {

	

	@Test
	public void writeTestToVerifyHeader() throws IOException, MyCalcException {
		WriteFile wf = new WriteFile("Randomout.csv");
		wf.writerclose();
		BufferedReader br = new BufferedReader(new FileReader("Randomout.csv"));
		String line = br.readLine();
		String[] actual = line.split(",");
		String[] expected = new String[5];
		expected[0] = "input1";
		expected[2] = "input2";
		expected[1] = "operator";
		expected[3] = "=";
		expected[4] = "result";

		Assert.assertEquals(expected[0] + expected[1] + expected[2]
				+ expected[3] + expected[4], actual[0] + actual[1] + actual[2]
				+ actual[3] + actual[4]);

	}

	@Test
	public void writeOutputFileTest() throws MyCalcException, IOException {
		WriteFile wf = new WriteFile("Randomout.csv");

		List<InputReturnValues> inputslist = new ArrayList<InputReturnValues>();

		CalculateWithInput cwi = new CalculateWithInput();
		for (InputReturnValues inpValues : inputslist) {

			double output = cwi.calculateWithInput(inpValues.getInput1(),
					inpValues.getInput2(), inpValues.getOperator());

			wf.writeOutputFile(inpValues, output);

		}

		BufferedReader br = new BufferedReader(new FileReader("Randomout.csv"));
		String[] record2 = new String[] { "2", "*", "3" };
		String[] record3 = new String[] { "4", "+", "5" };
		List<String[]> expectedrecords = new ArrayList<String[]>();

		expectedrecords.add(record2);
		expectedrecords.add(record3);
		String line = br.readLine();
		while ((line = br.readLine()) != null) {

			String[] actual = line.split(",");

			Assert.assertEquals(
					expectedrecords.get(0)[0] + expectedrecords.get(0)[1]
							+ expectedrecords.get(0)[2]
							+ expectedrecords.get(0)[3]
							+ expectedrecords.get(0)[4], actual[0] + actual[1]
							+ actual[2] + actual[3] + actual[4]);
		}
	}

}
