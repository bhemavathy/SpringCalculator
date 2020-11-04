package springcalculator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import MyCalculator.MyCalculator.CalcEntry;
import MyCalculator.MyCalculator.Calculate;
import MyCalculator.MyCalculator.CalculateWithInput;
import MyCalculator.MyCalculator.InputReturnValues;
import MyCalculator.MyCalculator.ReadFile;
import MyCalculator.MyCalculator.WriteFile;
import MyCalculator.MyCalculator.WriteRandom;
import MyCalculatorException.MyCalcException;

//@SpringBootTest(classes = CalcEntry.class)
public class CalcEntryTest {

	@InjectMocks
	CalcEntry calcentry;

	@Mock
	CalculateWithInput cwi;
	@Mock
	
	ReadFile rf = new ReadFile("Randomop.csv");
	@Mock
	WriteFile wf = new WriteFile("Randomout.csv");
	@Mock
	WriteRandom wr = new WriteRandom("Randomop.csv");

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void EntryTestWithReadFile() throws MyCalcException, FileNotFoundException {

		Mockito.when(rf.readinputfile()).thenReturn(null);

		String expected = null;
		List<InputReturnValues> inputslist = rf.readinputfile();
		Assert.assertEquals(expected, inputslist);

	}

	@Test
	public void runTest() throws FileNotFoundException, MyCalcException {
		
		wr.write(2);
		wr.randClose();
		List<InputReturnValues> list = new ArrayList<InputReturnValues>();
		InputReturnValues irv = new InputReturnValues();
		irv.setInput1(2);
		irv.setOperator('+');
		irv.setInput2(3);
		list.add(irv);
		
		Mockito.when(rf.readinputfile()).thenReturn(list);
		Mockito.when(cwi.calculateWithInput(2, 3, '+')).thenReturn(4d);

		for (InputReturnValues inpValues : list) {

			double output = cwi.calculateWithInput(inpValues.getInput1(),
					inpValues.getInput2(), inpValues.getOperator());

			wf.writeOutputFile(inpValues, output);

		}
		
		

		 Assert.assertEquals(4d, cwi.calculateWithInput(2, 3, '+'));
		 Assert.assertEquals(list, rf.readinputfile());
		
				
		
		

	}
	@Test
	public void mainTest(){
		calcentry.main(new String[] {});
	}
	
	

}
