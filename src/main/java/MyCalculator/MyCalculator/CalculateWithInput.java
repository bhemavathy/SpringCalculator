package MyCalculator.MyCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculateWithInput {

	@Autowired Calculate calculate;
	//public Calculate calculate = new Calculate();


	public double calculateWithInput(double value1, double value2,
			char operator1) {

		double output = 0;
		

		if (operator1 == 0 ) {
			throw new NullPointerException();
		}

		switch (operator1) {
		case '+':
			output = calculate.add(value1, value2);
			
			break;
		case '-':
			output = calculate.sub(value1, value2);
			
			break;
		case '*':
			output = calculate.multiply(value1, value2);
			
			break;
		case '/':
			output = calculate.divide(value1, value2);
			
			break;
		case '%':
			output = calculate.percentage(value1, value2);
			
			break;
		default:
			System.out.println("Please enter the correct operator");
			throw new RuntimeException("Operator is invalid");
			
		

		}
		
		
		return output;
		
		
	}
	
	


}
