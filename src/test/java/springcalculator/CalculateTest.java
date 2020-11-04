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
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import MyCalculator.MyCalculator.Calculate;
import MyCalculator.MyCalculator.CalculateWithInput;

public class CalculateTest {


	@Test
	public void addTwoNegTest() {
		double input1 = -40;
		double input2 = -50;
		double expres = -90;
		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.add(input1, input2);
		Assert.assertEquals(expres, actresult);

	}

	@Test(timeout = 2000)
	public void subTest() throws InterruptedException {
		double input1 = 100;
		double input2 = 50;
		double expres = 50;
		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.sub(input1, input2);
		Assert.assertEquals(expres, actresult);
		Thread.sleep(1000);

	}

	@Test
	public void mulTest() {
		double input1 = 100;
		double input2 = 50;
		double expres = 5000;
		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.multiply(input1, input2);
		Assert.assertEquals(expres, actresult);

	}

	@Test
	public void mulTestWithZeroAsOneInput() {

		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.multiply(0, 10);
		Assert.assertTrue(0d == actresult);

	}

	@Test
	public void mulTestWithOneNegInput() {

		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.multiply(-5, 10);
		Assert.assertTrue(-50d == actresult);

	}

	@Test
	public void divTest() {
		double input1 = 100;
		double input2 = 50;
		double expres = 2;
		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.divide(input1, input2);
		Assert.assertEquals(expres, actresult);
		// assertThat(actresult, is(expres));
	}

	@Test
	public void divTestdivideByZero() {
		double input1 = 100;
		double input2 = 0;
		Calculate calculate = new Calculate();
		calculate.divide(input1, input2);

	}

	@Test
	public void percTest() {
		double input1 = 100;
		double input2 = 200;
		double expres = 50;
		double actresult;
		Calculate calculate = new Calculate();
		actresult = calculate.percentage(input1, input2);
		Assert.assertEquals(expres, actresult);

	}
	
	
	@Test
	public void operatorIncTestAdd() {
		Calculate cwi = new Calculate();
		double out = cwi.add(2, 3);
		Assert.assertEquals(1, cwi.plusop);
	}

	@Test
	public void operatorIncTestMul() {
		Calculate cwi = new Calculate();
		double out = cwi.multiply(2, 3);
		Assert.assertEquals(1, cwi.multipyop);
	}

	@Test
	public void operatorIncTestDiv() {
		Calculate cwi = new Calculate();
		double out = cwi.divide(2, 3);
		Assert.assertEquals(1, cwi.divideop);
	}

	@Test
	public void operatorIncTestSub() {
		Calculate cwi = new Calculate();
		double out = cwi.sub(2, 3);
		Assert.assertEquals(1, cwi.minusop);
	}

	@Test
	public void operatorIncTestPer() {
		Calculate cwi = new Calculate();
		double out = cwi.percentage(2, 3);
		Assert.assertEquals(1, cwi.percop);
	}

}
