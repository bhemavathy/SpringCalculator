package MyCalculator.MyCalculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalcEntry implements CommandLineRunner {

	@Autowired
	ReadFile rf;
	@Autowired
	WriteFile wf;
	@Autowired
	CalculateWithInput cwi;
	@Autowired
	WriteRandom wr;

	public static void main(String[] args) {
		SpringApplication calentry = new SpringApplication(CalcEntry.class);
		calentry.run(args);

	}

	@Override
	public void run(String... arg0) throws Exception {

		wr.writeRandom();
		List<InputReturnValues> inputslist = rf.readinputfile();

		for (InputReturnValues inpValues : inputslist) {

			double output = cwi.calculateWithInput(inpValues.getInput1(),
					inpValues.getInput2(), inpValues.getOperator());

			wf.writeOutputFile(inpValues, output);

		}
		System.out.println(cwi.calculate);

		wf.writerclose();

	}

}
