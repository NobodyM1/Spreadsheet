import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Spreadsheet {
	 
	int count4 = 0;
	boolean isOperator = false;
	
	//HashMap map = new HashMap();
	
	HashMap<String, String> hmap = new HashMap<String, String>();
	
	public String get(String cell) {
		
		//Object result = map.get(cell);
		String test = hmap.get(cell);
		
		return test;
	}
	
	public void set(String cell, String value) {
		hmap.put(cell, value);
	}
	
	//*****************EVALUATION**********************
	public String evaluate(String cell) {
		
		String test = hmap.get(cell);
		
		Pattern pat = Pattern.compile("'");
		Matcher mat = pat.matcher(test);
		int count = 0;
		
		while (mat.find()){
			count++;
		}
		
		if(count < 2){
			//Value must be numbers only
			
			//************** Check if value is reference *************
			pat = Pattern.compile("=");
			int count3 = 0;
			mat = pat.matcher(test);
			while(mat.find()){
				count3++;
			}
			pat = Pattern.compile("((\\d*\\.\\d+)|(\\d+)|([\\+\\-\\*/\\(\\)]))");
			mat = pat.matcher(test);
			while(mat.find()){
				isOperator = true;
			}
			if(isOperator == true){
				String math = test.substring(1);
				int reader = 0;
				int number1 = 0;
				char operator = '+';
				while(reader < math.length()){
					if(Character.isDigit(math.charAt(reader)) == true ){
						if(operator == '+'){
							number1 = number1 + Character.getNumericValue(math.charAt(reader));
						}
						if(operator == '-'){
							number1 = number1 - Character.getNumericValue(math.charAt(reader));
						}
						if(operator == '*'){
							number1 = number1 * Character.getNumericValue(math.charAt(reader));
						}
						if(operator == '/'){
							number1 = number1 / Character.getNumericValue(math.charAt(reader));
						}
						if(operator == '%'){
							number1 = number1 % Character.getNumericValue(math.charAt(reader));
						}
						reader++;
					}
					else{
						operator = math.charAt(reader);
						reader++;
					}
					
				}
				String result = String.valueOf(number1);
				return result;
			}
			//Accepts only input that has no ' characters
			if(count3 == 1 && count == 0){
				String refCell = test.substring(1);
				test = hmap.get(refCell);
				//Loop back and check the new value
				hmap.put(cell, test);
				if(count4 < 1){
					count4++;
					evaluate(cell);
				}
				else{
					return "#Circular";
				}
				
			}
			//*********** Value reference end ***************
			
			//********** Check if input is only digits ***********
			int count2 = 0;
			for (int i = 0, len = test.length(); i < len; i++) {
			    if (Character.isDigit(test.charAt(i)) || test.charAt(i) == '-') {
			        count2++;
			    }
			}
			
			if(test.length() != count2){
				//Error
				// Change value 
				//hmap.put(cell, "#Error");
				return "#Error";
				
			}
			else{
				//Nothing
				//hmap.put(cell, test);
				return test;
			}
			//********* Digit check ends **************
		}
		
		//************* Gets value between '' ***************
		else {
			Pattern pattern = Pattern.compile("\'([^\"]*)\'");
			Matcher matcher = pattern.matcher(test);
			while(matcher.find()){
				test = matcher.group(1);
				//hmap.put(cell, test);
				return test;
			}
		}
		//**************** Value get ends ****************
		return test;
	}
	
}
