package MyCalculatorException;

import java.io.FileNotFoundException;

public class CalcFileNotFoundException extends CalcIOException {

	public CalcFileNotFoundException(String string, FileNotFoundException ex) {
		super(string, ex);

	}
}
