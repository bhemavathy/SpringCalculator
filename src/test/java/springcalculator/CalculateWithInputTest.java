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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import MyCalculator.MyCalculator.Calculate;
import MyCalculator.MyCalculator.CalculateWithInput;

public class CalculateWithInputTest {

	@InjectMocks
	CalculateWithInput cwi;
	@Mock
	Calculate calculate;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void calcWithInputTestMul() {

		Mockito.when(calculate.multiply(2, 3)).thenReturn(7d);

		double actual = cwi.calculateWithInput(2, 3, '*');
		Assert.assertEquals(7d, actual);
	}

	@Test
	public void calcWithInputTestAdd() {
		Mockito.when(calculate.add(2, 3)).thenReturn(5d);

		double actual = cwi.calculateWithInput(2, 3, '+');
		Assert.assertEquals(5d, actual);
	}

	@Test
	public void calcWithInputTestSub() {
		Mockito.when(calculate.sub(2, 3)).thenReturn(-1d);

		double actual = cwi.calculateWithInput(2, 3, '-');
		Assert.assertEquals(-1d, actual);
	}

	@Test
	public void calcWithInputTestDiv() {
		Mockito.when(calculate.divide(2, 3)).thenReturn(0.3d);

		double actual = cwi.calculateWithInput(2, 3, '/');
		Assert.assertEquals(0.3d, actual, 1e-1);
	}

	@Test
	public void calcWithInputTestPer() {
Mockito.when(calculate.percentage(2, 3)).thenReturn(33.3d);
		
		double actual = cwi.calculateWithInput(2, 3, '%');
		Assert.assertEquals(33.3d, actual, 1e-1);
	}

	

	@Test(expected = NullPointerException.class)
	public void operatorNullTest() {
		CalculateWithInput cwi = new CalculateWithInput();
		double out = cwi.calculateWithInput(2, 3, (char) 0);

	}

	@Test(expected = RuntimeException.class)
	public void operatorAlertTest() {
		CalculateWithInput cwi = new CalculateWithInput();
		double out = cwi.calculateWithInput(2, 3, '^');

	}

}
