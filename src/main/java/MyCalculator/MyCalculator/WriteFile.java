package MyCalculator.MyCalculator;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import MyCalculatorException.CalcFileNotFoundException;
import MyCalculatorException.CalcIOException;
import MyCalculatorException.MyCalcException;

@Component
public class WriteFile {
	BufferedWriter bw = null;
	long starttime;
	


private String outpathfile ;
@Autowired
	public WriteFile(@Value("${outFile}") String outpath) throws MyCalcException, IOException {
	
	this.outpathfile = outpath;
	

		
			try {
				bw = new BufferedWriter(new FileWriter(outpathfile,true));
			} catch (FileNotFoundException e1) {
				throw new CalcFileNotFoundException("Not able to find path", e1);
			}
		
		String heading = "input1,operator,input2,=,result";
		 starttime = System.currentTimeMillis();
		try {
			bw.append(heading);
		} catch (IOException e) {
			throw new CalcIOException("couldnot write heading in write file", e);
		}

	}

	public void writeOutputFile(InputReturnValues inpValues, double output)
			throws MyCalcException {

		String calcin3 = Double.toString(output);
		double input1 = inpValues.getInput1();
		double input2 = inpValues.getInput2();
		char operator = inpValues.getOperator();

		String result = input1 + "," + operator + "," + input2 + "," + "="
				+ "," + calcin3;

		try {
			bw.newLine();
		} catch (IOException e) {
			throw new CalcIOException("Not able to add newline", e);
		}

		try {
			bw.append(result);
		} catch (IOException e1) {
			throw new CalcIOException("Not able to add result", e1);
		}
		
		

	}

	public void writerclose() throws IOException {
		// TODO Auto-generated method stub
		bw.close();
		long endtime = System.currentTimeMillis();
		long duration = endtime - starttime;
		System.out.println("time taken to write the outputs to file" + duration + " ms");
	}
	
	
	
}
