package springcalculator;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;

import MyCalculator.MyCalculator.InputReturnValues;
import MyCalculator.MyCalculator.ReadFile;
import MyCalculator.MyCalculator.WriteFile;
import MyCalculator.MyCalculator.WriteRandom;
import MyCalculatorException.CalcFileNotFoundException;
import MyCalculatorException.MyCalcException;

public class ReadFileTest {

	@Test(expected = NullPointerException.class)
	public void readNullFileTest() throws MyCalcException, IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Randomnull.csv"));
		bw.close();
		ReadFile rf = new ReadFile("Randomnull.csv");
		rf.readinputfile();

	}

	@Test(expected = FileNotFoundException.class)
	public void readFileFoundTest() throws FileNotFoundException, MyCalcException  {
		
		ReadFile rf = new ReadFile("//rand1.csv");
		rf.readinputfile();

	}

	@Test
	public void readTestToVerifyEachRowSize() throws IOException,
			MyCalcException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Random1.csv"));

		String[] record2 = new String[] { "2", "*", "3" };
		String[] record3 = new String[] { "4", "+", "5" };

		String result1 = 2 + "," + '*' + "," + 3 + "," + "=" + "," + 6;
		String result2 = 4 + "," + '+' + "," + 5 + "," + "=" + "," + 9;
		bw.newLine();
		bw.append(result1);
		bw.newLine();
		bw.append(result2);
		bw.close();

		List<String[]> expectedrecords = new ArrayList<String[]>();

		expectedrecords.add(record2);
		expectedrecords.add(record3);
		for (int i = 0; i < expectedrecords.size(); i++) {

			ReadFile rf = new ReadFile("Random1.csv");

			List<InputReturnValues> inputslist = rf.readinputfile();

			for (int j = 0; j < inputslist.size(); j++) {

				Assert.assertEquals(
						Double.parseDouble((expectedrecords.get(j)[0])),
						(inputslist.get(j).getInput1()));
				Assert.assertEquals((expectedrecords.get(j)[1].charAt(0)),
						inputslist.get(j).getOperator());

				Assert.assertEquals(
						Double.parseDouble((expectedrecords.get(j)[0])),
						(inputslist.get(j).getInput1()));
			}
		}

	}

	@Test
	public void readTestToVerifyContainsOperator() throws IOException,
			MyCalcException {
		
		WriteRandom  wr =  new WriteRandom("Randomop.csv");
		wr.write(8);
		wr.randClose();

		ReadFile rf = new ReadFile("Randomop.csv");

		List<InputReturnValues> inputslist = rf.readinputfile();

		for (InputReturnValues inpValues : inputslist) {

			char op = inpValues.getOperator();

			Assert.assertTrue("Operator is not accepted", (op == '+'
					|| op == '-' || op == '*' || op == '/' || op == '%'));
		}

	}
	
	
}
