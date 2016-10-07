import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spreadsheet {
	
	String cell;
	String value;

	public String get(String cell) {
		// to be implemented
		return value;
	}
	
	public void set(String cell, String value) {
		int lenght = 0;
		
		// Count how many ' can be found in value
		Pattern pat = Pattern.compile("'");
		Matcher mat = pat.matcher(value);
		int count = 0;
		while (mat.find()){
			count++;
		}
		
		if(count < 2){
			//Value must be numbers only
			Pattern p = Pattern.compile("(\\d+)");
			Matcher m = p.matcher(value);
			while (m.find()){
				lenght++;
			}
			System.out.println(lenght);
			if(value.length() != lenght){
				//Error
				this.value = "#Error";
				return;
			}
			
			this.value = value;
			
		}
		else {
			//Get the value between ''
			Pattern pattern = Pattern.compile("\'([^\"]*)\'");
			Matcher matcher = pattern.matcher(value);
			while(matcher.find()){
				this.value = matcher.group(1);
			}
		}
	}
	
	public String evaluate(String cell) {
		
		return null;
	}
	
}
