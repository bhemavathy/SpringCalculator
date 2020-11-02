package MyCalculatorException;

import java.io.IOException;

public class CalcIOException extends MyCalcException {

	public CalcIOException(String string, IOException ex1) {
		super(string, ex1);

	}

}
