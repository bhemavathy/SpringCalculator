package springcalculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import MyCalculator.MyCalculator.WriteRandom;
import MyCalculatorException.MyCalcException;

public class WriteRandomTest {

	@Test(expected = MyCalcException.class)
	public void writeRanFileTest() throws MyCalcException {

		WriteRandom wr = new WriteRandom("I://rand1.csv");

	}

	@Test
	public void writeRanVerifyHeaderTest() throws MyCalcException, IOException {
		String[] record1 = new String[] { "input1", "operator", "input2" };

		WriteRandom wr = new WriteRandom("Random.csv");
		wr.randClose();

		BufferedReader br = new BufferedReader(new FileReader("Random.csv"));
		String line = br.readLine();
		String[] actual = line.split(",");

		Assert.assertEquals(record1[0].toString(), actual[0].toString());
		Assert.assertEquals(record1[1].toString(), actual[1].toString());
		Assert.assertEquals(record1[2].toString(), actual[2].toString());

	}

	@Test
	public void writenoOfvaluesTest() throws MyCalcException, IOException {

		WriteRandom wr = new WriteRandom("Random.csv");
		wr.write(5);
		wr.randClose();

		BufferedReader br = new BufferedReader(new FileReader("Random.csv"));
		String line = br.readLine();
		while ((line = br.readLine()) != null) {
			String[] actual = line.split(",");

			Assert.assertTrue((actual[0].matches("[.0-9]+"))
					&& (actual[0].length() <= 4));
			Assert.assertTrue((actual[2].matches("[.0-9]+"))
					&& (actual[0].length() <= 4));
			Assert.assertTrue(actual[1].contains("+")
					|| actual[1].contains("-") || actual[1].contains("*")
					|| actual[1].contains("/") || actual[1].contains("%"));

		}
	}

}
